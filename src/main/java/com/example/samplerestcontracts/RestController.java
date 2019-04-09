package com.example.samplerestcontracts;


        import com.example.samplerestcontracts.model.AlertResponse;
        import com.example.samplerestcontracts.services.AppAlertService;
        import com.example.samplerestcontracts.services.CachingService;
        import com.example.samplerestcontracts.services.CachingWorker;
        import org.apache.logging.log4j.LogManager;
        import org.apache.logging.log4j.Logger;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(produces="application/json")
public class RestController {

    static Logger logger = LogManager.getLogger(RestController.class);

    @Autowired
    AppAlertService appAlertService;

    @Autowired
    CachingWorker cachingWorker;

    @Autowired
    CachingService cachingService;

    @RequestMapping(path="/getAll", method=RequestMethod.GET)
    @ResponseBody
    public AlertResponse getAll() {
        return appAlertService.getAllAlerts(true);
    }

    @RequestMapping(path="/getAppAlerts/{appName}", method=RequestMethod.GET)
    @ResponseBody
    public AlertResponse getByApplication(@PathVariable("appName") String appName) {
        return getByApplicationAndCategory(appName, null);
    }

    @RequestMapping(path="/getAppAlerts/{appName}/{category}", method=RequestMethod.GET)
    @ResponseBody
    public AlertResponse getByApplicationAndCategory(@PathVariable("appName") String appName, @PathVariable("category") String category) {
        return appAlertService.getAppAlerts(appName, category);
    }

    @RequestMapping(path="/resetCache", method=RequestMethod.PUT)
    @ResponseBody
    public void resetCache() {
        cachingWorker.resetTimeLastRun();
    }

    @RequestMapping(value="/getAllApps", method=RequestMethod.GET, produces="application/json")
    @ResponseBody
    public String getCfApps() {
        return cachingService.getCfAppsAsString();
    }

    @RequestMapping(value="/getAllAlertCategories/{planned}", method=RequestMethod.GET, produces="application/json")
    @ResponseBody
    public String getAlertCategories(@PathVariable("planned") Integer planned) {
        return cachingService.getAlertCategoriesAsString(planned);
    }

    @RequestMapping(value="/getAlertCriteria/{alertTypeId}", method=RequestMethod.GET, produces="application/json")
    @ResponseBody
    public String getAlertCriteria(@PathVariable("alertTypeId") Integer alertTypeId) {
        return cachingService.getAlertCriteriaAsString(alertTypeId);
    }

    @RequestMapping(value="/getAlertMessageTemplate/{alertTypeId}", method=RequestMethod.GET, produces="application/json")
    @ResponseBody
    public String getAlertMessageTemplate(@PathVariable("alertTypeId") Integer alertTypeId) {
        return cachingService.getAlertMessageTemplate(alertTypeId);
    }

    @RequestMapping(value="/getRefreshTimestamp", method=RequestMethod.GET, produces="application/json")
    @ResponseBody
    public String getRefreshTimestamp() {
        return cachingWorker.getTimeLastRun();
    }

    @RequestMapping(value="/getAlertToReview/{alertId}", method=RequestMethod.GET, produces="application/json")
    @ResponseBody
    public String getAlertToReview(@PathVariable("alertId") Integer alertId) {
        return cachingService.getAlertById(alertId);
    }

    @RequestMapping(value="/getAlertToUpdate/{alertId}", method=RequestMethod.GET, produces="application/json")
    @ResponseBody
    public String getAlertToUpdate(@PathVariable("alertId") Integer alertId) {
        return cachingService.getAlertById(alertId);
    }


}