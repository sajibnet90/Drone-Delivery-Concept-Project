package fi.sade23.fleet.main.flights;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="fleet/v1/flights")
public class FlightsController {

    @Autowired
    private FlightsService flightsService;

    @GetMapping
    public String test(){
        return flightsService.pingDroneUnit();
    }
}
