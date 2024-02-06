
# Food Quick Delivery

This is a food delivery system for a food delivery company. The system receives customer orders and distributes them to a driver based on their current load and their location. It also prints an invoice to a .txt file for the customer and updates the database with the customer info and the new driver load.


## Deployment

To deploy this project run
- You can download and run the Docker image from
https://hub.docker.com/repository/docker/sifisosaz/my-java-project/general



## Motivation

When I started learning JAVA I wanted to test myself so I looked for real projects from real companies and I found one that was about making a food delivery system so I decided to challenge myself. I am proud to say my project is ready for real use.


## Installation

To run this project you will need the following:
- SQL Server
- Microsoft JDBC Driver
- JDE 
You will need to create a database in SQL Server based on the db_export Excel file and adapt the database connections in the code to that database.

- Copy the project to a repository and run the JAVA project.
- The Main class runs the project.
    
## Usage/Features

The system contains the following features:
- Stores customer information like:
  + Location (city) of the customer
  + Customer name
  + Contact number of the customer
  + Address of the customer
  + Email address of the customer

- Stores restaurant information like:
  + Location of the restaurant
  + Contact number of the restaurant
  + How many of each meal is being ordered
  + The list of meals being ordered and their prices
  + Any special preparation instructions given by  the customer

- The information about the drivers is in the text file drivers.txt in the following format:
 John Krill, Cape Town, 4
- This shows that the driver’s name is John Krill who is in Durban and he currently has a load of 4 deliveries.

- The system reads the drivers.txt file and finds the driver in the correct area with the smallest load for the delivery.
- If a driver is found an invoice is created for the customer the invoice contains the order info and the driver information.
- If a driver is not found then the user is notified in the invoice that there is no driver.
- This project was created using:
   + JAVA
