Feature: User Login Functionality

#Scenario: Valid Login
#Given User is on Login Page 
#When User enters "tomsmith" and "SuperSecretPassword!"
#Then Should display home page

#Scenario: InValid Login
#Given User is on Login Page 
#When User enters "tomsmith1" and "SuperSecretPassword"
#Then Should display home page


#Scenario Outline: Valid Login
#Given User is on Login Page 
#When User enters "<username>" and "<password>"
#Then Should display home page

#Examples:
#		| username | password |
#		| tomsmith | SuperSecretPassword! |
#		| tomsmith1 | SuperSecretPassword! |
#		| tomsmith2 | SuperSecretPassword! |
		
		
Scenario Outline: Valid Login
Given User is on Login Page 
When User enters credentials
| username | password |
| tomsmith | SuperSecretPassword! |
Then Should display home page
|You logged into a secure area!|
		
