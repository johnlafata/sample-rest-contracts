package com.example.samplerestcontracts.services;

import org.springframework.stereotype.Service;

@Service
public class CachingService {

    public String getCfAppsAsString(){
        return "app1,app2,app3";
    }

    public String getAlertCategoriesAsString(Integer planned){
        String categories="";
        for (int i=0; i<planned; i++){
            categories=categories+"categories"+i;
        }
        return categories;
    }

    public String getAlertCriteriaAsString(Integer alertid){
        return "alertCriteria"+alertid;
    }

    public String getAlertMessageTemplate(Integer alertid){
        return "alertTemplate:"+alertid;
    }

    public String getAlertById(Integer alertId){
        return "alertById:"+alertId;
    }
}
