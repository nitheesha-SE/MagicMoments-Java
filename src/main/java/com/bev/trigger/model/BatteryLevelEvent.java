package com.bev.trigger.model;

import java.time.Instant;

public class BatteryLevelEvent extends TriggerEvent {

    private Integer batteryLevel;

    public BatteryLevelEvent(String id, Instant createdAt, Integer batteryLevel) {
        super(id, createdAt);
        this.batteryLevel = batteryLevel;
    }

    public Integer getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(Integer batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
}
