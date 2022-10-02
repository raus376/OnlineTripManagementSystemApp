# Online Trip Management System

<hr>
<li>An Collabrative Project Consisting Of the 5 Developer Depicting the implementation of the Trip Managment Platform like MakeMyTrip or Yatra.
<li>An developement of RESTful API for an application. This API performs all the fundamental CRUD operations of any with user validation at every step.
<br>
  
# ER Diagram
<hr>
The following Diagram depicts the flow of our Entity Relation Diagram to simplify the work flow.
<br>
<br>
  
  
![ER diagram](ER diagram link)

<br>
<br>
<hr>
  
# Team Member Roles And Responsibilities
  
<hr>
<br>
<br>

1) Bivek Rai  -Team Lead, Responsible for creating and implementing the ER diagram and flow of the project.

2) Yogesh Saini -Responsible for creating the Repository while making sure of proper implementation Of Controllers

3) Shubham Randive -Responsible For handeling the Exceptions and Creating the Service Layer.

4) Bhanu Prathap Goud -Responsible for The frontent Layer while implementing proper RESTful API naming Conventions.

5) Partha Sarathi  -Responsible for Creating the login and logout Session layer with proper validation.

<br>
<br>

# Teach Stacks Implemented
<hr>
<br>
<br>
<li>Java
<li>Spring
<li>Spring Boot JPA
<li>Hibernate
<li>MySQL
<li>Swagger
<li>Lombok
<li>HTML 5
<li>AdvanceJavaScript(ES6+)
<li>BootStrap 5
<li>CSS3

<br>
<br>



# Modules
<hr>
<li>Login Logout User authentication
<li>Wallet
<li>BankAccount
<li>BeneficiaryDetails
<li>BillPayment
<li>Transaction

<br>
<br>

# Features
<hr>
<br>

- User Login authrntication
- validation for the account number
- validation for the current user and user identification
- RESTful API with CURD operations
- Functional Front End For better user experience

<br>
<br>

# Installation & Run
<hr>
<br>
<br>

```
#changing the server port
server.port=8888

#db specific properties
spring.datasource.url=jdbc:mysql://localhost:3306/sb201db
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root

#ORM s/w specific properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER

```

<br>
<br>

# API Root Endpoint
<hr>
<br>
<br>

```
https://localhost:8888/
```

```
https://localhost:8888/swagger-ui/#
```
<br>
<br>

  
# REST API for an Online Cab Booking Application

* We have developed this REST API for an Online Cab Booking application. This API performs all the fundamental CRUD operations of any Online Cab Booking platform with user validation at every step.
* This project is developed by team of 5 Back-end Developers during project week in Masai School. 

## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL

## Modules

* Login, Logout Module
* Driver Module
* Customer Module
* Admin Module
* TripBooking Module

## Features

* Customer, Driver and Admin authentication & validation with session uuid having.
* Admin Features:
    * Administrator Role of the entire application
    * Only registered admins with valid session token can add/update/delete driver or customer from main database
    * Admin can access the details of different customers, drivers and trip bookings
* Customer Features:
    * Registering themselves with application, and logging in to get the valid session token
    * Viewing list of available cabs and booking a trip
    * Only logged in user can access his trip history, profile updation and other features.

## Contributors

* [@Raja Yadav](https://github.com/RajaYadav00)
* [@Aniket Wagh](https://github.com/aniketw8)
* [@Puja Kumari](https://github.com/Puja983542)
* [@Rahul Kumar](https://github.com/rahulraka)
* [@Najmush Saaquib](https://github.com/najmushsaaquib)


## Installation & Run

* Before running the API server, you should update the database config inside the [application.properties](E-Commerce-Backend\src\main\resources\application.properties) file. 
* Update the port number, username and password as per your local database config.

```
    server.port=8021

    spring.datasource.url=jdbc:mysql://localhost:3306/cabdb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```

## API Root Endpoint

`https://localhost:8021/`

`http://localhost:8021/swagger-ui.html`


## API Module Endpoints

### Customer Module


* `POST /customer/login` : Logging in customer with valid mobile number & password
* `GET /customer/availablecabs` : Getting the list of all the available cabs
* `GET /customers/cabs` : Getting All the cabs
* `GET /customers/checkhistory` : Getting the history of completed tr
* `PUT /customer/update/{mobile}` : Updates customer details based on mobile number
* `PATCH /customer/updatepassword/{mobile}` : Updates customer's password based on the given mobile number
* `POST /customer/booktrip` : Customer can book a cab
* `POST /customer/updatetrip` : Customer can modify or update the trip
* `POST /customer/logout` : Logging out customer based on session token
* `DELETE /customer/delete` : Deletes logged in user 
* `DELETE /customer/complete/{tripid}` : Completed the trip with the given tripid 
* `DELETE /customer/canceltrip` : Cancel the trip with the given tripid 


### Admin Module

* `POST /admin/register` : Register a new admin with proper data validation and admin session
* `POST /admin/login` : Admin can login with mobile number and password provided at the time of registation
* `GET /admin/logout` : Logging out admin based on session token
* `GET /admin/listoftripsbycustomer` : Get list of trips of by a customer id
* `GET /admin/listoftrips` : Get list of trips of all the trips
* `GET /admin/listocustomers` : Get list of all the customers
* `GET /admin/listodrivers` : Get list of all the drivers
* `PUT /admin/update/{username}` : Updates admin detaisl by passed user name
* `DELETE /admin/delete` : Deletes the admin with passed id


### Driver Module

* `POST /driver/register` : Register a new driver with proper data validation and admin session
* `POST /driver/login` : Driver can login with mobile number and password provided at the time of registation
* `POST /driver/status/{?}` : Changes the status of the driver either Online or Offline
* `GET /driver/logout` : Logging out driver based on session token
* `GET /driver/driverlist` : Gets list of all the drivers
* `GET /driver/bestdriver` : Gets the best driver whose rating is over 4.5
* `PUT /driver/update` : Updates the driver details

### Sample API Response for Customer Login

`POST   localhost:80211/login/customer`

* Request Body

```
    {
        "mobileId": "85022457580",
        "password": "Clickme@007"
    }
```

* Response

```
    {
        "sessionId": 3,
        "token": "0ad57094",
        "userId": 9,
        "userType": "customer",
        "sessionStartTime": "2022-06-10T10:48:20.0109626",
        "sessionEndTime": "2022-06-10T11:48:20.0109626"
    }
```

