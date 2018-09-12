package com.bev.trigger.model;

import java.time.Instant;

public class CarStartedEvent extends TriggerEvent {

    public CarStartedEvent(String id, Instant createdAt) {
        super(id, createdAt);
    }
}
