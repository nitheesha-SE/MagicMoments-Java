package com.bev.status;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StatusController {

    @GetMapping("/ifttt/v1/status")
    @ResponseBody
    public ResponseEntity status(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey) {
        if ("INVALID".equals(iftttChannelKey)) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    @PostMapping("/ifttt/v1/test/setup")
    @ResponseBody
    public ResponseEntity setup(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey) {
        if ("INVALID".equals(iftttChannelKey)) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        } else {
            Map body = new HashMap<String, Object>();
            body.put("body", new HashMap<>());
            return new ResponseEntity(body, HttpStatus.OK);
        }
    }

}
