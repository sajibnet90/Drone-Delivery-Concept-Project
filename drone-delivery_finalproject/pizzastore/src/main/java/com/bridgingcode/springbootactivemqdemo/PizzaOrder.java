package com.bridgingcode.springbootactivemqdemo;


import java.util.List;
import com.bridgingcode.springbootactivemqdemo.model.orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/pizza")
public class PizzaOrder {

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders/{Order_id}")
    public orders getorders(@PathVariable ("Order_id")String Order_id){
        return   orderService.getorders(Order_id);
    }
    @GetMapping("/orders")
    public List<orders> getAllorders(){
        return orderService.getAllorders();
    }

    @Autowired
    private JmsTemplate jmsTemplate;
    
    @PostMapping("/orders")
    public ResponseEntity<String> processPizzaOrder(@RequestBody orders pizzaOrder) {
        try {
            // Send JMS message
            jmsTemplate.convertAndSend("pizza-order-queue", pizzaOrder);

            // Add order
            OrderService.addorders(pizzaOrder.getOrder_id(), pizzaOrder);

            return new ResponseEntity<>("Order Placed Successfully!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    @DeleteMapping("/orders/{Order_id}")
    public String removeorders(@PathVariable ("Order_id") String Order_id){
        orderService.removeorders(Order_id);
        return "Order Cancelled: " + Order_id;
    }


    @GetMapping("/orders_status")
    public String userorder(){
        return pizzaService.client();
    }

    @GetMapping("/send_drone/{Order_id}")
    public String senddrone(@PathVariable("Order_id") String Order_id) {
        String response = "Orders : ";
        response += orderService.getorders(Order_id);
        response += "\n";
        response += pizzaService.pingDroneUnit();
        return response;
    } 
}
