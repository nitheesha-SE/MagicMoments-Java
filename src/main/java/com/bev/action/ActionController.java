package com.bev.action;

import com.bev.action.model.IFTTTActionRequest;
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
    final private Map standardBodyResponse = new HashMap<String, String>();

    public ActionController() {
        Map data = new HashMap<String, String>();
        data.put("id", UUID.randomUUID().toString());

        standardBodyResponse.put("data", new Map[]{data});
    }

    @PostMapping("start_car")
    @ResponseBody
    public ResponseEntity startCar(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey,
                                   @RequestBody IFTTTActionRequest request) {
        if ("INVALID".equals(iftttChannelKey)) {
            return generateErrorResponse();
        } else {
            if (null != request.getIfttt_source() &&
                    null != request.getIfttt_source().getId()) {
                carService.setRunning(request.getIfttt_source().getId(), true);
            }
            return new ResponseEntity(standardBodyResponse, HttpStatus.OK);
        }
    }

    @PostMapping("stop_car")
    @ResponseBody
    public ResponseEntity stopCar(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey,
                                  @RequestBody IFTTTActionRequest request) {
        if ("INVALID".equals(iftttChannelKey)) {
            return generateErrorResponse();
        } else {
            if (null != request.getIfttt_source() &&
                    null != request.getIfttt_source().getId()) {
                carService.setRunning(request.getIfttt_source().getId(), false);
            }
            return new ResponseEntity(standardBodyResponse, HttpStatus.OK);
        }
    }

    @PostMapping("open_bonnet")
    @ResponseBody
    public ResponseEntity openBonnet(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey) {
        if ("INVALID".equals(iftttChannelKey)) {
            return generateErrorResponse();
        } else {
            carService.setOpenBonnet(true);
            return new ResponseEntity(standardBodyResponse, HttpStatus.OK);
        }
    }

    @PostMapping("close_bonnet")
    @ResponseBody
    public ResponseEntity closeBonnet(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey) {
        if ("INVALID".equals(iftttChannelKey)) {
            return generateErrorResponse();
        } else {
            carService.setOpenBonnet(false);
            return new ResponseEntity(standardBodyResponse, HttpStatus.OK);
        }
    }

    @PostMapping("open_trunk")
    @ResponseBody
    public ResponseEntity openTrunk(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey) {
        if ("INVALID".equals(iftttChannelKey)) {
            return generateErrorResponse();
        } else {
            carService.setOpenTrunk(true);
            return new ResponseEntity(standardBodyResponse, HttpStatus.OK);
        }
    }

    @PostMapping("close_trunk")
    @ResponseBody
    public ResponseEntity closeTrunk(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey) {
        if ("INVALID".equals(iftttChannelKey)) {
            return generateErrorResponse();
        } else {
            carService.setOpenTrunk(false);
            return new ResponseEntity(standardBodyResponse, HttpStatus.OK);
        }
    }


    @PostMapping("open_door")
    @ResponseBody
    public ResponseEntity openDoor(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey) {
        if ("INVALID".equals(iftttChannelKey)) {
            return generateErrorResponse();
        } else {
            carService.setOpenDoor(true);
            return new ResponseEntity(standardBodyResponse, HttpStatus.OK);
        }
    }

    @PostMapping("close_door")
    @ResponseBody
    public ResponseEntity closeDoor(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey) {
        if ("INVALID".equals(iftttChannelKey)) {
            return generateErrorResponse();
        } else {
            carService.setOpenDoor(false);
            return new ResponseEntity(standardBodyResponse, HttpStatus.OK);
        }
    }


    @PostMapping("open_top")
    @ResponseBody
    public ResponseEntity openTop(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey) {
        if ("INVALID".equals(iftttChannelKey)) {
            return generateErrorResponse();
        } else {
            carService.setOpenTop(true);
            return new ResponseEntity(standardBodyResponse, HttpStatus.OK);
        }
    }

    @PostMapping("close_top")
    @ResponseBody
    public ResponseEntity closeTop(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey) {
        if ("INVALID".equals(iftttChannelKey)) {
            return generateErrorResponse();
        } else {
            carService.setOpenTop(false);
            return new ResponseEntity(standardBodyResponse, HttpStatus.OK);
        }
    }


    @PostMapping("lights_on")
    @ResponseBody
    public ResponseEntity lightsOn(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey) {
        if ("INVALID".equals(iftttChannelKey)) {
            return generateErrorResponse();
        } else {
            carService.setLightsOn(true);
            return new ResponseEntity(standardBodyResponse, HttpStatus.OK);
        }
    }

    @PostMapping("lights_off")
    @ResponseBody
    public ResponseEntity lightsOff(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey) {
        if ("INVALID".equals(iftttChannelKey)) {
            return generateErrorResponse();
        } else {
            carService.setLightsOn(false);
            return new ResponseEntity(standardBodyResponse, HttpStatus.OK);
        }
    }

    @PostMapping("open_window")
    @ResponseBody
    public ResponseEntity openWindow(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey) {
        if ("INVALID".equals(iftttChannelKey)) {
            return generateErrorResponse();
        } else {
            carService.setOpenWindow(true);
            return new ResponseEntity(standardBodyResponse, HttpStatus.OK);
        }
    }

    @PostMapping("close_window")
    @ResponseBody
    public ResponseEntity closeWindow(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey) {
        if ("INVALID".equals(iftttChannelKey)) {
            return generateErrorResponse();
        } else {
            carService.setOpenWindow(false);
            return new ResponseEntity(standardBodyResponse, HttpStatus.OK);
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
