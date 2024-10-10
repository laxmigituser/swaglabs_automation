Feature: Login 

    Scenario Outline: Login using given credentials
	Given User navigates-to "https://www.saucedemo.com/v1/" page 
	When User enters "<username>" as username
	And User enters "<password>" as password
	And User clicks on login button
	Then User verify page title should be "Swag Labs" 
	Then User verify page URL includes "/inventory.html" 
	And User closes browser 	
	
Examples:
|username|password|
|standard_user|secret_sauce|
|standard_user|admin|