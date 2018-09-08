package com.bev.status;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StatusController {
    
    @GetMapping("/ifttt/v1/status")
    @ResponseBody
    public ResponseEntity status(@RequestHeader("IFTTT-Channel-Key") String iftttChannelKey) {
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }
    
}
