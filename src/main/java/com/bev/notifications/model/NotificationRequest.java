package com.bev.notifications.model;

import java.util.ArrayList;
import java.util.List;

public class NotificationRequest {

    final private List<Data> data = new ArrayList<>();

    public NotificationRequest(String userId) {
        super();
        data.add(new Data(userId));
    }

    public class Data {
        private String user_id;

        public Data(String user_id) {
            this.user_id = user_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

    }

    public List<Data> getData() {
        return data;
    }
}
