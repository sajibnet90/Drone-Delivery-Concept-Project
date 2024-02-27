package fi.sade23.droneverse.inventory;

import fi.sade23.droneverse.inventory.model.Drone;
import fi.sade23.droneverse.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping(path="")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    @GetMapping("/info")
    public String infoService(){
        return"Drone inventory ready";
    }

    @GetMapping("/control/drones/{id}")
    public Drone getDrone(@PathVariable ("id")String id){
        return  inventoryService.getDrone(id);

        //String response = "Getting Drone ID: " +id + "Here it is:";
        //response += inventoryService.getDrone(id);
        //return response;
    }
    // http://localhost:8080/control/drones/
    @GetMapping("/control/drones/")
    public List<Drone> getAllDrone(){
        return inventoryService.getAllDrones();
    }

    @PostMapping("/control/drones/")
    public String addDrone(@RequestBody Drone drone){
        inventoryService.addDrone(drone.getId(),drone);
        return "Added new drone to fleet: " + drone.toString();
    }
    //curl -X POST -H "Content-Type: application/json" -d '{"id":"4", "name":"drone4", "capacity": 455}' http://localhost:8080/control/drones/

    @DeleteMapping("/control/drones/{id}")
    public String removeDrone(@PathVariable ("id") String id){
        inventoryService.removeDrone(id);
        return "Drone removed from fleet: " + id;
    }
    //curl -X DELETE http://localhost:8080/control/drones/2


    @PutMapping("/control/drones/")
    public String updateDrone(@RequestBody Drone drone){
        inventoryService.updateDrone(drone.getId(),drone);
        return "Updated the drone: " + drone.toString();
    }
    //curl -X PUT -H "Content-Type: application/json" -d '{"id": 1, "name":"Drone1.v2", "capacity": "900"}' http://localhost:8080/control/drones/


}