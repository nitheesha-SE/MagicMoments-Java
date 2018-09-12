package com.bev.car;

import com.bev.trigger.model.CarStartedEvent;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class CarService {

    final private Car car = new Car();
    final private List<CarStartedEvent> carStaredEvents = new ArrayList<CarStartedEvent>();

    public Car getCar() {
        return car;
    }

    public List<CarStartedEvent> getCarStaredEvents(int limit) {
        Collections.sort(carStaredEvents, Collections.reverseOrder());
        return carStaredEvents.subList(0, limit);
    }

    public void setRunning(boolean running) {
        this.car.setRunning(running);
        if (running) {
            //add car started event
            CarStartedEvent event = new CarStartedEvent(UUID.randomUUID().toString(),
                    Instant.now());

            carStaredEvents.add(event);
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
