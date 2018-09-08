package com.bev.status;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ifttt/v1")
public class StatusController {

    @GetMapping("/status")
    @ResponseBody
    public ResponseEntity status(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey) {
        if ("INVALID".equals(iftttChannelKey)) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    @PostMapping("/test/setup")
    @ResponseBody
    public ResponseEntity setup(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey) {
        if ("INVALID".equals(iftttChannelKey)) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        } else {
            Map body = new HashMap<String, Object>();
            body.put("data", new HashMap<>());
            return new ResponseEntity(body, HttpStatus.OK);
        }
    }

}
