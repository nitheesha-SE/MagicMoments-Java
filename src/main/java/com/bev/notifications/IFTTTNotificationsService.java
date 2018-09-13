package com.bev.notifications;

import com.bev.notifications.model.NotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class IFTTTNotificationsService {

    private Logger log = LoggerFactory.getLogger(IFTTTNotificationsService.class);

    private final static String SERVICE_URL = "https://realtime.ifttt.com/v1/notifications";

    @Autowired
    private RestTemplate restTemplate;

    public void sendUserIdNotification(String userId){
        NotificationRequest bean = new NotificationRequest(userId);

        HttpHeaders headers = new HttpHeaders();
        headers.set("IFTTT-Service-Key", "iUhrtsNrt43se-OmtsKDgF2wJOF0mdMua-dhc6yIllvvayvHAKT4qBPMQyYI9ilt");

        HttpEntity<NotificationRequest> request = new HttpEntity<>(bean, headers);

        ResponseEntity<Void> response = restTemplate.postForEntity(SERVICE_URL, request, Void.class);
        log.debug(response.toString());
    }
}
