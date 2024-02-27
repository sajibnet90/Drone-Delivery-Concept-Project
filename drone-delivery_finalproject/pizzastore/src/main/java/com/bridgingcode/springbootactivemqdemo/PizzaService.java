package com.bridgingcode.springbootactivemqdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PizzaService {
    @Autowired
    private RestTemplate restTemplate;

    public  String client(){
        String response = "";
        // take rest connection with one of the drone from Dronevers
        //localhost:8484/drone/v1/assignments
        response += "Pizza ordered successfully!\n";
        return response;
    }

     public  String pingDroneUnit(){
        String response = "";
        // take rest connection with one of the drone from Dronevers
        //localhost:8484/drone/v1/assignments
        response += "Food is ready! Send the drone for delivery!\n";
        response += "Dispatched Drones Details!\n";
        response += restTemplate.getForObject("http://localhost:8482/control/drones/1", String.class);
        response += "\n";
        response += restTemplate.getForObject("http://localhost:8484/drone/v1/assignments", String.class);
        return response;
    }


    
}
