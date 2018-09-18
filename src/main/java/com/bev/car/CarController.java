package com.bev.car;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/car")
public class CarController {

    private static final Logger log = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity getCar() {
        Map body = new HashMap<String, Object>();
        Map data = new HashMap<String, String>();
        body.put("data", new Map[]{data});

        Car car = carService.getCar();
        data.put("car", car);

        return new ResponseEntity(body, HttpStatus.OK);
    }

    @PostMapping("/startCharging")
    @ResponseBody
    public ResponseEntity startChargingCar() {
        carService.setCharing(true);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/stopCharging")
    @ResponseBody
    public ResponseEntity stopChargingCar() {
        carService.setCharing(false);
        return new ResponseEntity(HttpStatus.OK);
    }
}
