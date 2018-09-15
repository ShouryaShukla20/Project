Feature: GiveDetails 
	As a user
	I want to create account
	So I have to enter details and accept terms and Condition


Scenario Outline: Successful submission2
Given  I am on LoanApplicationPagee
And I have entered "<firstname>" into the form
And I have also entered "<lastname>" into the form
When I press submitt
Then the success HTML page should be opened and verifiedd

Examples:
| firstname | lastname |
| Akshay | Sachan | 
| Rohit | Sharma | 
