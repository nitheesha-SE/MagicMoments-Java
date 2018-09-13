package com.bev.action.model;

import java.util.Map;

public class IFTTTActionRequest {

    /*
    {
      "actionFields": {
        "title": "New Banksy photo!",
        "body": "Check out a new Bansky photo: http://example.com/images/125"
      },
      "ifttt_source": {
        "id": "2",
        "url": "https://ifttt.com/myrecipes/personal/2"
      },
      "user": {
        "timezone": "Pacific Time (US & Canada)"
      }
    }
     */

    private Map<String, Object> actionFields;
    private IFTTTSource ifttt_source;
    private Map<String, Object> user;

    public Map<String, Object> getActionFields() {
        return actionFields;
    }

    public void setActionFields(Map<String, Object> actionFields) {
        this.actionFields = actionFields;
    }

    public IFTTTSource getIfttt_source() {
        return ifttt_source;
    }

    public void setIfttt_source(IFTTTSource ifttt_source) {
        this.ifttt_source = ifttt_source;
    }

    public Map<String, Object> getUser() {
        return user;
    }

    public void setUser(Map<String, Object> user) {
        this.user = user;
    }

    public class IFTTTSource{
        private String id;
        private String url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
