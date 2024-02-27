** Operating instructions **
Installing, setting up and starting the containers
*clone the code for the system*
• git clone https://github.com/sajibnet90/Drone-Delivery-Concept-Project.git
• Run it using spring boot
** Testing instructions **
Hands on commands to test the system with example requests. How to verify the result.
Console for hivemq: /opt/homebrew/opt/activemq/bin/activemq console

For Pizza store:
** Place order:**  curl -X POST -H "Content-Type: application/json" -d '{"Order_id":"2",
"Pizza_name":"Margherita", "size": "big"}' http://localhost:8481/pizza/orders

** See order details:** curl http://localhost:8481/pizza/orders

**Cancel order:** curl -X DELETE http://localhost:8481/pizza/orders/1

Message from control centre and drone unit: curl
http://localhost:8481/pizza/send_drone/1

**Control Center:**

Assign drones: curl -X POST -H "Content-Type: application/json" -d '{"id":"1",
"name":"droneverse", "capacity": 456}' http://localhost:8482/control/drones/
Drones details: curl http://localhost:8482/control/drones/

Update drone details: curl -X PUT -H "Content-Type: application/json" -d '{"id":"4",
"name":"drone4", "capacity": 439}' http://localhost:8482/control/drones/

Remove drone: curl -X DELETE http://localhost:8482/control/drones/1

Fleet details : curl http://localhost:8312/fleet/v1/flights

Monitoring details : curl http://localhost:8312/fleet/v1/flights

Drone Unit:
Drone assignment: curl -X POST http://localhost:8484/drone/v1/assignments/ready
Drone details: curl : curl -X POST http://localhost:8484/drone/v1/assignments/ready
