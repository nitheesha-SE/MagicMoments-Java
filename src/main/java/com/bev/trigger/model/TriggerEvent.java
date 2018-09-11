package com.bev.trigger.model;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class TriggerEvent {

    final private Map<String, String> meta = new HashMap<>();

    public TriggerEvent(String id, Instant timestamp) {
        meta.put("id", id);
        meta.put("timestamp", String.valueOf(timestamp.getEpochSecond()));
    }

    public Map<String, String> getMeta() {
        return meta;
    }
}
