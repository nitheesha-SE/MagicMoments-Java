package com.bev.action;

import com.bev.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/ifttt/v1/actions")
public class ActionController {

    @Autowired
    private CarService carService;

    @PostMapping("start_car")
    @ResponseBody
    public ResponseEntity startCar(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey) {
        if ("INVALID".equals(iftttChannelKey)) {
            Map body = new HashMap<String, Object>();

            Map message = new HashMap<String, String>();
            message.put("message", "IFTTT Channel Key is invalid.");

            body.put("errors", new Map[]{message});

            return new ResponseEntity(body, HttpStatus.UNAUTHORIZED);
        } else {
            carService.setCarStatus("ON");

            Map body = new HashMap<String, Object>();
            Map data = new HashMap<String, String>();
            body.put("data", new Map[]{data});

            data.put("id", UUID.randomUUID().toString());


            return new ResponseEntity(body, HttpStatus.OK);
        }
    }

}
