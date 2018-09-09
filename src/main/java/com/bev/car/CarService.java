package com.bev.car;

import org.springframework.stereotype.Service;

@Service
public class CarService {

    private Car car = new Car();

    public Car getCar() {
        return car;
    }

    public void setRunning(boolean running){
        this.car.setRunning(running);
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
