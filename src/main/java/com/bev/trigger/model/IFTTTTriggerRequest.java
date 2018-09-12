package com.bev.trigger.model;

import java.util.Map;

public class IFTTTTriggerRequest {

    /*
    {
      "trigger_identity": "9df337bdefa1a8f6271eeb014fa953a54f7a6442",
      "triggerFields": {},
      "limit": 0,
      "user": {
        "timezone": "America/Los_Angeles"
      },
      "ifttt_source": {
        "id": "4965e7169fdd17f9",
        "url": "http://example.com/4965e7169fdd17f9"
      }
    }
     */

    private String trigger_identity;
    private Map triggerFields;
    private Integer limit;
    private Map user;
    private Map ifttt_source;

    public String getTrigger_identity() {
        return trigger_identity;
    }

    public void setTrigger_identity(String trigger_identity) {
        this.trigger_identity = trigger_identity;
    }

    public Map getTriggerFields() {
        return triggerFields;
    }

    public void setTriggerFields(Map triggerFields) {
        this.triggerFields = triggerFields;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Map getUser() {
        return user;
    }

    public void setUser(Map user) {
        this.user = user;
    }

    public Map getIfttt_source() {
        return ifttt_source;
    }

    public void setIfttt_source(Map ifttt_source) {
        this.ifttt_source = ifttt_source;
    }
}
