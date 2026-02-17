Feature: Purchase the Order from Ecommerce Website
I want to purchase an item from the website


Background:
Given I landed on Ecomm page

@Regression
Scenario Outline: Positive Test for submit the order

Given logged in with username <name> and password <password>
When I add product <productName> to the cart
And checkout <productName> is checked out and submit the order
Then Verify "THANKYOU For THE ORDER." is displayed or not




Examples:
| name               | password  | productName      |
| ankur786@gmail.com | Ankur@123 | ADIDAS ORIGINAL  |
