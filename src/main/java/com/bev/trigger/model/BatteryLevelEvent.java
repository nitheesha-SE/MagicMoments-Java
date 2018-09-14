package com.bev.trigger.model;

import java.time.Instant;

public class BatteryLevelEvent extends TriggerEvent {

    private Integer battery_level;

    public BatteryLevelEvent(String id, Instant createdAt, Integer batteryLevel) {
        super(id, createdAt);
        this.battery_level = batteryLevel;
    }

    public Integer getBattery_level() {
        return battery_level;
    }

    public void setBattery_level(Integer battery_level) {
        this.battery_level = battery_level;
    }
}
