package com.example.samplerestcontracts.services;

import com.example.samplerestcontracts.model.Alert;
import com.example.samplerestcontracts.model.AlertResponse;
import org.springframework.stereotype.Service;

@Service
public class AppAlertService {

    public AlertResponse getAllAlerts(boolean flag){
        return AppAlertService.createAlertResponse();
    }


    public AlertResponse getAppAlerts(String appName, String Categor){
        return AppAlertService.createAlertResponse();
    }

    public static  AlertResponse createAlertResponse(){
        AlertResponse response = new AlertResponse();
        Alert alert = new Alert();
        alert.setApp("app");
        alert.setCategory("category");
        alert.setMessage("message");
        response.getAlerts().add(alert);
        return response;
    }
}
