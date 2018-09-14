package com.bev.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ControllerUtil {

    public ResponseEntity generateErrorResponse() {
        Map body = new HashMap<String, Object>();

        Map message = new HashMap<String, String>();
        message.put("message", "IFTTT Channel Key is invalid.");

        body.put("errors", new Map[]{message});

        return new ResponseEntity(body, HttpStatus.UNAUTHORIZED);
    }
}
