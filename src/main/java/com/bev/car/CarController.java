package com.bev.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity getCar() {
        Map body = new HashMap<String, Object>();
        Map data = new HashMap<String, String>();
        body.put("data", new Map[]{data});

        data.put("status", carService.getCarStatus());

        return new ResponseEntity(body, HttpStatus.OK);
    }
}
