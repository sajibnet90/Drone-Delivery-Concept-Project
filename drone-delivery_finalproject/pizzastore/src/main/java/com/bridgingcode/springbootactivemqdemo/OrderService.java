package com.bridgingcode.springbootactivemqdemo;

import org.springframework.stereotype.Component;

import com.bridgingcode.springbootactivemqdemo.model.orders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class OrderService {

    private static HashMap<String,orders> ordersHashMap = new HashMap<>();

    public OrderService() {
    }

    public orders getorders(String Order_id) {
        if (ordersHashMap.containsKey(Order_id)) {
            return ordersHashMap.get(Order_id);
        }
        return  null;
    }

    public static void addorders(String Order_id, orders order){
        if(!ordersHashMap.containsKey(Order_id)){
            ordersHashMap.put(Order_id, order);
        }
    }

    public void updateorders(String Order_id, orders order){
        if(ordersHashMap.containsKey(Order_id)){
            ordersHashMap.replace(Order_id,order);
        }
    }

    public void removeorders(String Order_id){
        if(ordersHashMap.containsKey(Order_id)){
            ordersHashMap.remove(Order_id);
        }
    }

    public List<orders> getAllorders(){
        return new ArrayList<>(ordersHashMap.values());
    }
}

