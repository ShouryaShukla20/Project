Feature: GiveDetails 
	As a user
	I want to create account
	So I have to enter details and accept terms and Condition

@mytag 
Scenario: Successful submission
Given  I am on LoanApplicationPage
And I have entered firstname into the form
|Akshay|
And I have entered lastname into the form
|Sachan|
When I press submit
Then the success HTML page should be opened and verified
	