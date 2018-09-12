package com.bev.trigger.model;

import java.time.Instant;

public class TriggerEvent implements Comparable{

    final private TriggerEventMeta meta;
    final private Instant created_at;

    public TriggerEvent(String id, Instant createdAt) {
        this.created_at = createdAt;
        this.meta = new TriggerEventMeta(id, createdAt.getEpochSecond());
    }

    public TriggerEventMeta getMeta() {
        return meta;
    }

    public Instant getCreated_at() {
        return created_at;
    }

    @Override
    public int compareTo(Object o) {
        TriggerEvent e = (TriggerEvent)o;

        return this.meta.getTimestamp().compareTo(e.getMeta().getTimestamp());
    }

    private class TriggerEventMeta {
        private String id;
        private Long timestamp;

        public TriggerEventMeta(String id, long timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }
    }
}
