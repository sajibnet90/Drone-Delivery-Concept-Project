package fi.sade23.droneverse.droneunit;

import org.springframework.stereotype.Component;

@Component
public class DroneService {

    private final String defaultMessage = " ";

    public String droneTest() {
        return defaultMessage;
    }
}
