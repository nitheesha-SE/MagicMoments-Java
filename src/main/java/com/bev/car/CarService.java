package com.bev.car;

import com.bev.notifications.IFTTTNotificationsService;
import com.bev.trigger.model.BatteryLevelEvent;
import com.bev.trigger.model.CarStartedEvent;
import com.bev.trigger.model.DoorEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.*;

@Service
public class CarService {

    private static final Logger log = LoggerFactory.getLogger(IFTTTNotificationsService.class);


    @Autowired
    private IFTTTNotificationsService iftttNotificationsService;

    final private Car car = new Car();
    final private List<CarStartedEvent> carStaredEvents = new ArrayList<CarStartedEvent>();
    final private List<DoorEvent> doorEvents = new ArrayList<>();
    final private List<BatteryLevelEvent> batteryLevelEvents = new ArrayList<>();

    @PostConstruct
    public void init() {
        log.info("Adding sample battery level events.");

        try {
            for (Integer batteryLevel : Arrays.asList(0, 50, 100)) {
                this.addBatteryLevelEvent(Optional.of(batteryLevel));
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Returns the car object and it's current properties.
     * @return
     */
    public Car getCar() {
        log.debug(car.toString());

        return car;
    }

    /**
     * Returns the list of Car Started events.
     * @param limit
     * @return
     */
    public List<CarStartedEvent> getCarStaredEvents(Integer limit) {
        Collections.sort(this.carStaredEvents, Collections.reverseOrder());

        final List<CarStartedEvent> response;
        if (null != limit) {
            response = this.carStaredEvents
                    .subList(0, limit > this.carStaredEvents.size() ? this.carStaredEvents.size() : limit);
        } else {
            response = this.carStaredEvents;
        }

        return response;
    }

    /**
     * Returns the list of door open and close events.
     * @param limit
     * @return
     */
    public List<DoorEvent> getDoorEvents(Integer limit) {
        Collections.sort(this.doorEvents, Collections.reverseOrder());

        final List<DoorEvent> response;
        if (null != limit) {
            response = this.doorEvents
                    .subList(0, limit > this.doorEvents.size() ? this.doorEvents.size() : limit);
        } else {
            response = this.doorEvents;
        }

        return response;
    }


    /**
     * Returns the list of events that correspond to changes in the battery charge level fluctuations.
     * @param limit
     * @return
     */
    public List<BatteryLevelEvent> getBatteryLevelEvents(Integer limit) {
        Collections.sort(this.batteryLevelEvents, Collections.reverseOrder());

        final List<BatteryLevelEvent> response;
        if (null != limit) {
            response = this.batteryLevelEvents
                    .subList(0, limit > this.batteryLevelEvents.size() ? this.batteryLevelEvents.size() : limit);
        } else {
            response = this.batteryLevelEvents;
        }

        return response;
    }

    /**
     * Add an event that corresponds with a change in the battery charge level.
     * @param batteryLevel
     */
    public void addBatteryLevelEvent(Optional<Integer> batteryLevel) {
        if (batteryLevel.isPresent()) {
            this.car.setBatteryLevel(batteryLevel.get());
            this.batteryLevelEvents.add(new BatteryLevelEvent(UUID.randomUUID().toString(),
                    Instant.now(), batteryLevel.get()));

            //TODO Look into doing an IFTTT realtime notification.
        }
    }

    /**
     * Sets the car's running status.
     * @param userId
     * @param running
     */
    public void setRunning(String userId, boolean running) {
        this.car.setRunning(running);
        if (running) {
            //add car started event
            CarStartedEvent event = new CarStartedEvent(UUID.randomUUID().toString(),
                    Instant.now());

            carStaredEvents.add(event);

            iftttNotificationsService.sendUserIdNotification(userId);
        }
    }

    public void setOpenBonnet(boolean openBonnet) {
        this.car.setOpenBonnet(openBonnet);
    }

    public void setOpenTrunk(boolean openTrunk) {
        this.car.setOpenTrunk(openTrunk);
    }

    public void setOpenDoor(String userId, boolean openDoor) {
        this.car.setOpenDoor(openDoor);
        //add door event
        DoorEvent event = new DoorEvent(UUID.randomUUID().toString(),
                Instant.now());

        doorEvents.add(event);

        iftttNotificationsService.sendUserIdNotification(userId);
    }

    public void setOpenTop(boolean openTop) {
        this.car.setOpenTop(openTop);
    }

    public void setLightsOn(boolean lightsOn) {
        this.car.setLightsOn(lightsOn);
    }

    public void setOpenWindow(boolean openWindow) {
        this.car.setOpenWindow(openWindow);
    }
}
