package com.bev.car;

import org.springframework.stereotype.Service;

@Service
public class CarService {

    private String carStatus = "OFF";

    public String getCarStatus(){
        return this.carStatus;
    }

    public void setCarStatus(String carStatus){
        this.carStatus = carStatus;
    }
}
