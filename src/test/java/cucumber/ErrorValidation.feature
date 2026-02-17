Feature: Error Validation
I want to purchase an item from the website


@ErrorValidation
Scenario Outline: Positive Test for submit the order

Given I landed on Ecomm page
When logged in with username <name> and password <password>
Then Verify incorrect "Incorrect email or password." is displayed or not




Examples:
| name               | password   |
| ankur786@gmail.com | Ankur@1233 |