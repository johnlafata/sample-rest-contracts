package com.example.samplerestcontracts.base;

import com.example.samplerestcontracts.RestController;
import com.example.samplerestcontracts.model.Alert;
import com.example.samplerestcontracts.model.AlertResponse;
import com.example.samplerestcontracts.services.AppAlertService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.mockito.Mockito;


public class AlertControllerBase {


    @Before
    public void setup() {
        RestController mockController = Mockito.mock(RestController.class);
        Mockito.when(mockController.getAll()).thenReturn(AppAlertService.createAlertResponse());
        Mockito.when(mockController.getByApplication(Mockito.anyString())).thenReturn(AppAlertService.createAlertResponse());
        Mockito.when(mockController.getByApplicationAndCategory(Mockito.anyString(),Mockito.anyString())).thenReturn(AppAlertService.createAlertResponse());
        RestAssuredMockMvc.standaloneSetup(mockController);
    }
}
