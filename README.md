## Restaurant Recommendation Engine
This project is a restaurant recommendation engine that recommends the top 100 restaurants for a given user. It takes into account the user's preferred cuisines and cost brackets, as well as other factors such as the restaurant's rating, popularity, and distance.

### Getting Started
To use the recommendation engine, follow these steps:

1.Clone the repository to your local machine.
2.Import the project into IDE.
3.Build the project using your IDE's build tool or by running the appropriate command in your terminal or command prompt
4.Run the project using your IDE's run tool or by running the appropriate command in your terminal or command prompt. You will need to specify the main class which is present in Application.java

User Order data and Restaurant is auto populated with random data, However it can configured.

Task Description can be found here -> https://docs.google.com/document/d/1-fRucn7TQiH5IX2suaXa2Nf-nZtdvTGYrUeoe_zSWb4/edit#

Since the algorithm has multiple steps which follow a similar pattern, 
I have chosen the Strategy Pattern to design the code. 
So all the steps would implement the RestaurantStrategy interface, and the order of execution can be chosen by the client, 
thereby completing the decoupling between the client code and the algorithm.

### Strategy Pattern
1.The Strategy Pattern is a behavioral design pattern that enables selecting an algorithm at runtime.
2.It provides a way to define a family of algorithms, encapsulate each one as an object, and make them interchangeable.
3.This pattern allows the algorithms to vary independently from the clients that use them.
4.In our implementation, each step of the algorithm is encapsulated in a separate class that implements the RestaurantStrategy interface, which defines a single method for sorting restaurants.
5.By implementing this interface, each strategy is interchangeable and can be easily replaced by another strategy.
6.This pattern also promotes open-closed principle, as it allows for easy extension without modifying the existing code.


