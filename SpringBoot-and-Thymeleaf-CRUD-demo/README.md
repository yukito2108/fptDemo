# Intro
This project covers a basic CRUD program using thymeleaf and spring boot to manage a data base

For this we start using a boilerplate generated in https://start.spring.io/ using
- Data JPA
- Thymeleaf
- Spring Boot Web
- Spring Boot Devtools
- MySql Connector

## Reading
The program reads from the database a list of customers and show them in a list ordered by its Phone in desc order.

![alt text](https://i.imgur.com/jeXErgX.png)

## Creating a new customer
To add a new customer you must click the *Add Customer* button and you will get redirected to a form to fill the new customer data,
when done clicking the save button will save the customer in the data base and you will get redirected to the main list.

![alt text](https://i.imgur.com/9ITtClm.png)

## Updating an customer
To update an customer you can click in the update button which will send you to the update form where you will get every field pre-filled
with the customer data and you can change any text you want and click save when done and you will get redirected to the main list.

![alt text](https://i.imgur.com/yxYDxUi.png)

## Deleting an customer
When clicking the delete button you will get a pop up asking for confirmation and if you click on agree that customer will be deleted from
the database and the list will be updated.

![alt text](https://i.imgur.com/Utji3Vl.png)
