package com.bev.car;

public class Car {

    private boolean running = false;
    private boolean openBonnet = false;
    private boolean openTrunk = false;
    private boolean openDoor = false;
    private boolean openTop = false;
    private boolean lightsOn = false;
    private boolean openWindow = false;
    private int batteryLevel = 100;
    private boolean charging = false;

    public boolean isCharging() {
        return charging;
    }

    public void setCharging(boolean charging) {
        this.charging = charging;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isOpenBonnet() {
        return openBonnet;
    }

    public void setOpenBonnet(boolean openBonnet) {
        this.openBonnet = openBonnet;
    }

    public boolean isOpenTrunk() {
        return openTrunk;
    }

    public void setOpenTrunk(boolean openTrunk) {
        this.openTrunk = openTrunk;
    }

    public boolean isOpenDoor() {
        return openDoor;
    }

    public void setOpenDoor(boolean openDoor) {
        this.openDoor = openDoor;
    }

    public boolean isOpenTop() {
        return openTop;
    }

    public void setOpenTop(boolean openTop) {
        this.openTop = openTop;
    }

    public boolean isLightsOn() {
        return lightsOn;
    }

    public void setLightsOn(boolean lightsOn) {
        this.lightsOn = lightsOn;
    }

    public boolean isOpenWindow() {
        return openWindow;
    }

    public void setOpenWindow(boolean openWindow) {
        this.openWindow = openWindow;
    }

    @Override
    public String toString() {
        return "Car{" +
                "running=" + running +
                ", openBonnet=" + openBonnet +
                ", openTrunk=" + openTrunk +
                ", openDoor=" + openDoor +
                ", openTop=" + openTop +
                ", lightsOn=" + lightsOn +
                ", openWindow=" + openWindow +
                ", batteryLevel=" + batteryLevel +
                '}';
    }
}
