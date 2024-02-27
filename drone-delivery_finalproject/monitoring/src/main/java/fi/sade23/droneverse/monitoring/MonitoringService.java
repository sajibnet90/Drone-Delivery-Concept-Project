package fi.sade23.droneverse.monitoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // Add this import
import org.springframework.web.client.RestTemplate;

@Service // Add this annotation
public class MonitoringService {

    @Autowired
    private RestTemplate restTemplate;

    public String pingInventoryUnit() {
        String response = "";
        // take rest connection with one of the drone from Dronevers
        // localhost:8080/control/drones/
        response +="Monitoring service is monitoring the Drones\n";
        response +="Message from Control Center\n ";
        response += restTemplate.getForObject("http://localhost:8482/control/drones/", String.class);
        return response;
    }
}
