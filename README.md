# Big-d-BackEnd
Contract Based Development - JPA Backend

Q:
No web hooks?


## Report Requirements

- [x] Includes the final toolbox report made on the contract
- [x] Explains the setup including urls for the repositories
- [x] Includes a short instruction on setting up Jenkins in your particular setup
- [x] Implements one or two use cases, as a proof of concept for the setup
- [x] Implements tests for the implemented use cases. The coverage does not have to be 100% for the tests
- [x] Include UML and code in the report, where it is relevant

### The final toolbox report

[The link to code contract](https://github.com/bigDUnited/big-d-contract)  
[The link to final version of toolbox](https://github.com/bigDUnited/big-d-midterm-enterprise) 

##### Methods from the contract 

```java
public interface ContractInterface {

    public List<LocationDTO> getLocations();

    public List<RouteDTO> getRoutes(int locationId);

    public JourneysDTO getJourney(int routeId);

    public ReservationSummaryDTO makeReservation(int journeyId, int numOfPeople, String vehicleType);
    
    public ReservationSummaryDTO getReservation(int reservationId);
    
    public List<ReservationSummaryDTO> getAllReservations();
}
```

### Explains the setup

Jenkins url: [http://138.68.86.0:8081/](http://138.68.86.0:8081/)

Artifactory url: [http://138.68.86.0:8082/artifactory](http://138.68.86.0:8082/artifactory)


![CI/CD chain](/images/CI.png)

The diagram above shows our deployment scenario.

### Instruction on setting up Jenkins

![1](/images/1.png)
![2](/images/2.png)
![3](/images/3.png)

### Use cases, as a proof of concept
Use Case: 	Create a Reservation
Primary Actor: 	Customer
Scope: 		Reservation page and reservation detail page.
Level: 		!
Brief: 		Customer makes a reservation on the system.
Preconditions: 
Postconditions
	Minimal Guarantees:
		The customer will receive a response from the system.
	Success Guarantees:
		A reservation is saved on the system.
		A reservation is shown on the reservation summary page.
Triggers: 	A reservation object gets submitted to the database.
Basic flow:
		The customer selects a location.
		The customer selects a route.
		The customer selects a journey.
		The customer selects number of passengers.
		The customer selects a vehicle type.
		The customer submits the reservation.
		A reservation details are shown on the reservation summary page.

###

Use Case:	Cancel a reservation
Primary Actor: 	Customer
Scope:		Delete a reservation from the database.
Level:		!
Brief: 		Customer deletes a reservation entry from the system.
Preconditions:
		The customer has created a valid reservation in the system which has not expired yet.
		The customer should know the reservation number of the reservation they want to delete.	
Postconditions:
	Minimal Guarantees:
		The customer will receive a response from the system.
	Succes Guarantees:
		The reservation is deleted from the system.
Triggers:	A reservation object gets deleted from the database.
Basic flow:	
		The customer fills in reservation number.
		The customer presses the "Search" button.
		A reservation gets displayed, so that the customer can see the content.
		The customer presses the "Delete" button.
		The customer confirms the deletion of the reservation.
		The customer receives a confirmation from the system.

### Tests for the implemented use cases

??? none ???

### UML and code in the report, where it is relevant

##### Database

![db](/images/db.png)

```java

```
