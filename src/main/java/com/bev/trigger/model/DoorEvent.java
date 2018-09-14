package com.bev.trigger.model;

import java.time.Instant;

public class DoorEvent extends TriggerEvent {

    public DoorEvent(String id, Instant createdAt) {
        super(id, createdAt);
    }
}
