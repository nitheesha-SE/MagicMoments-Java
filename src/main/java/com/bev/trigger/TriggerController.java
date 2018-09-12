package com.bev.trigger;

import com.bev.car.CarService;
import com.bev.trigger.model.IFTTTTriggerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/ifttt/v1/triggers")
public class TriggerController {

    @Autowired
    private CarService carService;
    final private Map standardBodyResponse = new HashMap<String, String>();

    public TriggerController() {
        Map data = new HashMap<String, String>();
        data.put("id", UUID.randomUUID().toString());

        standardBodyResponse.put("data", new Map[]{data});
    }

    @PostMapping("car_started")
    @ResponseBody
    public ResponseEntity carStarted(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey,
                                     @RequestBody IFTTTTriggerRequest triggerRequest) {
        if ("INVALID".equals(iftttChannelKey)) {
            return generateErrorResponse();
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("data", carService.getCarStaredEvents(triggerRequest.getLimit()));

            return new ResponseEntity(response, HttpStatus.OK);
        }
    }

    private ResponseEntity generateErrorResponse() {
        Map body = new HashMap<String, Object>();

        Map message = new HashMap<String, String>();
        message.put("message", "IFTTT Channel Key is invalid.");

        body.put("errors", new Map[]{message});

        return new ResponseEntity(body, HttpStatus.UNAUTHORIZED);
    }

}
