package com.bev.car;

import com.bev.notifications.IFTTTNotificationsService;
import com.bev.trigger.model.CarStartedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class CarService {

    @Autowired
    private IFTTTNotificationsService iftttNotificationsService;

    final private Car car = new Car();
    final private List<CarStartedEvent> carStaredEvents = new ArrayList<CarStartedEvent>();

    public Car getCar() {
        return car;
    }

    public List<CarStartedEvent> getCarStaredEvents(Integer limit) {
        Collections.sort(carStaredEvents, Collections.reverseOrder());

        final List<CarStartedEvent> response;
        if(null != limit) {
            response = carStaredEvents.subList(0, limit > carStaredEvents.size() ? carStaredEvents.size() : limit);
        } else {
            response = carStaredEvents;
        }

        return response;
    }

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

    public void setOpenDoor(boolean openDoor) {
        this.car.setOpenDoor(openDoor);
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
