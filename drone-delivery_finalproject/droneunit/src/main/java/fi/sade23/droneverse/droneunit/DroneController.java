package fi.sade23.droneverse.droneunit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="drone/v1/assignments")
public class DroneController {

    @Autowired
    private DroneService droneService;

    private String readyMessage = "";

    @GetMapping
    public String test() {
        return droneService.droneTest() + readyMessage;
    }

    @PostMapping("/ready")
    public String markAsReady() {
        readyMessage = "Hei, I am your delivery drone. on the way to pickup the delivery!";
        return "Ready message set";
    }
}

