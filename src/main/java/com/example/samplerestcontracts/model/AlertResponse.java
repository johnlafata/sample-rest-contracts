package com.example.samplerestcontracts.model;

import java.util.ArrayList;

public class AlertResponse {

    ArrayList<Alert> alerts = new ArrayList<Alert>();

    public ArrayList<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(ArrayList<Alert> alerts) {
        this.alerts = alerts;
    }
}
