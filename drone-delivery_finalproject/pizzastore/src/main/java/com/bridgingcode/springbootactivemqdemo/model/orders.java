package com.bridgingcode.springbootactivemqdemo.model;

import java.io.Serializable;

public class orders implements Serializable {

    private static final long serialVersionUID = 1L;

    private String Order_id;
    private String Pizza_name;
    private String size;


    public orders(String Order_id, String Pizza_name, String size) {
        this.Order_id = Order_id;
        this.Pizza_name = Pizza_name;
        this.size = size;
    }

    public String getOrder_id() {
        return Order_id;
    }

    public void setOrder_id(String Order_id) {
        this.Order_id = Order_id;
    }

    public String getPizza_name() {
        return Pizza_name;
    }

    public void setPizza_name(String Pizza_name) {
        this.Pizza_name = Pizza_name;
    }

    public String getsize() {
        return size;
    }

    public void setsize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "{" +
                "Order_id='" + Order_id + '\'' +
                ", name='" + Pizza_name + '\'' +
                ", capacity=" + size +
                '}';
    }
}
