Ways to approach a general Design problem.

Use Cases Generation: Gather all the possible use cases

Constraints and Analysis: How many users, how much data etc.

Basic Design: Most basic design. Few users case.

Bottlenecks: Find the bottlenecks and solve them.

Scalability: A large number of users. 4 and 5 step will go in loop till we get a satisfactory answer

Current Scenario

Use cases for this problem:
1. Parking can be single-level or multilevel.
2. Types of vehicles that can be parked, separate spaces for each type of vehicle.
3. Entry and exit points.
Constraints:
1. Number of vehicles that can be accommodated of any type.
Basic Design/High-Level Components:
1. Vehicle/Type of vehicle.
2. Entry and Exit points.
3. Different spots for vehicles.
Bottlenecks:
1. Capacity breach for any type of vehicle.
Scalability:
1. Scalable from single-level to multi-level
2. Scalable from Bike only parking to accommodate all kinds of vehicles.
3. Keeping these in minds, APIs can be designed in the language of your preference.




 Parking can have many Floors and Floor and can have many ParkingSlots. Each Parking Slot is of certain slot size.
Vehicle is the interface type and all Vehicles just have to implement getType method to return type of Vehicle.
There is a separate enum for Slot size, and each slot size has the list of vehicle types it can accommodate. This keeps Parking and Vehicle objects independent of each other.

For calculating Fare, there is a separate FareController class which maintains map of each vehicle parked with details of parking and entry and exit time. Fare for Vehicle type can be kept in Parking and then getFare method can return the final fare on the basis of its inputs which is Parking, entryTime and exitTime.