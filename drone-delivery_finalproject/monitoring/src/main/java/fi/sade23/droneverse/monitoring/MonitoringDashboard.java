package fi.sade23.droneverse.monitoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path="monitoring/v1/drone")
public class MonitoringDashboard {
    @Autowired
    private MonitoringService monitoringService;

    @GetMapping
    public String test(){
        return monitoringService.pingInventoryUnit();
    }
    
}
