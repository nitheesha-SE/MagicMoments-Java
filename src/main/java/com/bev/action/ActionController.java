package com.bev.action;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/ifttt/v1/actions")
public class ActionController {

    @PostMapping("start_car")
    @ResponseBody
    public ResponseEntity startCar(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey) {
        if ("INVALID".equals(iftttChannelKey)) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        } else {
            Map body = new HashMap<String, Object>();
            Map data = new HashMap<String, String>();
            body.put("data", new Map[]{data});

            data.put("id", UUID.randomUUID().toString());


            return new ResponseEntity(body, HttpStatus.OK);
        }
    }

}
