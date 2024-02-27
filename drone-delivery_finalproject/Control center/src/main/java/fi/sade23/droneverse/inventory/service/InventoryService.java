package fi.sade23.droneverse.inventory.service;

import fi.sade23.droneverse.inventory.model.Drone;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class InventoryService {

    private HashMap<String,Drone> droneHashMap = new HashMap<>();

    public InventoryService() {
    }

    public Drone getDrone(String id) {
        if (droneHashMap.containsKey(id)) {
            return droneHashMap.get(id);
        }
        return  null;
    }

    public void addDrone(String id, Drone drone){
        if(!droneHashMap.containsKey(id)){
            droneHashMap.put(id, drone);
        }
    }
    public void updateDrone(String id, Drone drone){
        if(droneHashMap.containsKey(id)){
            droneHashMap.replace(id,drone);
        }
    }

    public void removeDrone(String id){
        if(droneHashMap.containsKey(id)){
            droneHashMap.remove(id);
        }
    }

    public List<Drone> getAllDrones(){
        return new ArrayList<>(droneHashMap.values());
    }
}

