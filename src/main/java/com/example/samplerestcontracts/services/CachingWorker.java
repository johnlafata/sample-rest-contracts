package com.example.samplerestcontracts.services;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CachingWorker {

    Date timeLastRun;
    SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yy");

    public void resetTimeLastRun(){
        timeLastRun=new Date();
    }

    public String getTimeLastRun() {
        return sdf.format(timeLastRun);
    }
}

