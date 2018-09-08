package com.bev.status;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    
    @GetMapping("/ifttt/v1/status")
    public String status() {
        return "OK";
    }
    
}
