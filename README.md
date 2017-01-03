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

[The link to code contract and toolbox](https://github.com/bigDUnited/big-d-contract)  

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

???

### Tests for the implemented use cases

??? none ???

### UML and code in the report, where it is relevant

##### Database

![db](/images/db.png)

```java

```
