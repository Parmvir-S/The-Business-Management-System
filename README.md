# The Business Management System

## What does the application do?

The **Business Management System** will allow a business to populate the application with a suite of items/services it has to offer alongside with their costs. The business will be able to:
- **Create** new items/services for its customers
- Will be able to **view** the current items/services available
- **Update** the items/services offered (name, cost, description, etc.)
- **Delete** items/services currently in the system

After the customer has chosen the type and quantity of item(s)/service(s), the business management application user can then enter those selections along with the customers data into the system. The entered data will be of the form:
- Customer ID
- Customer Name
- Customer Email
- Customer Phone Number
- Items/Services Purchased (Which Items, Total Cost, etc.)

The application user will be given the option to print a receipt for the customer (or to keep a copy for the business itself).
The application will also keep track of all time customer purchase records. The business can view how much money they have made to date, which items/services are purchased the most and how many customers they have provided service to.

## Who will use the application?
In the modern era with the advent of the internet and technology, individuals of all backgrounds are opening up small businesses and thriving. As they scale their businesses and continue expanding their profits, it becomes much more difficult to keep track of customer purchases. Many small business lose out on profit because they have to expend man power on manually keeping track of business expenses/purchases. Moreover, if the business owners aren't doing this tedious work on their own, they are outsourcing it to other employees or third-party companies which comes at financial cost. This Java desktop application will make business management more efficient, streamlined and cost-effective.

## Why is this project of interest to you?
This project is of interest to me because I am surrounded by young entrepreneurs who are trying to open up their own businesses. In particular my younger sister has recently opened up her own business and could use an application that allows her to print receipts for her customers and track basic customer information in one compact application. This will allow her to keep track of which items/services are the most popular and adjust her marketing accordingly which will ultimately yield more new customers and higher return rates.

## User Stories
- As a user, I want to be able to add an item/service to the catalogue list
- As a user, I want to be able to view all the items/services in the catalogue list
- As a user, I want to be able to select ("add to customer cart") specific items/services in the catalogue list
- As a user, I want to be able to remove ("remove from customer cart") specific items/services
- As a user, I want to be able to update existing items/services in the catalogue list
- As a user, I want to be able to delete items/services in the catalogue list
- As a user, I want to be able to print a receipt of the customers purchases
- As a user, I want to be able to view what the total sales to date are and view how many customers have been serviced to date
- As a user, when I am at the main application menu, I want to be reminded to save my store and customer data to file and have the option to do so or not
- As a user, when I start the application, I want to be given the option to load my store and customer data

## Phase 4: Task 2
- Tue Nov 23 20:20:52 PST 2021
- Item Apple was added to the store
- Tue Nov 23 20:20:57 PST 2021
- Item Orange was added to the store
- Tue Nov 23 20:21:04 PST 2021
- Item Banana was added to the store
- Tue Nov 23 20:21:13 PST 2021
- Item Banana was removed from the store
- Tue Nov 23 20:21:53 PST 2021
- Customer Parm was added to customers
- Tue Nov 23 20:22:16 PST 2021
- Customer LeBron James was added to customers
- Tue Nov 23 20:22:26 PST 2021
- Customer LeBron James was removed
- Tue Nov 23 20:22:37 PST 2021
- Item Apple was added to the cart
- Tue Nov 23 20:22:50 PST 2021
- Item Apple was removed from the cart

## Phase 4: Task 3
- I would create a new abstract class called ItemsList
- I would then have both CustomerCart and ItemList extend that abstract class as these classes share very similar functionality. Some of the methods are even identical so the implementation could be provided in the abstract class for those methods.
- In the UI I could use the observer pattern. When the store and customer data is loaded in, I could then make the class holding the current state of the program the subject (observable). All the classes dependent on that loaded in customer and store data will be the observers and will be notified and updated whenever the load button is clicked in the application.
- I would also try and remove the heavy coupling associated with the MainPanelContainer class 