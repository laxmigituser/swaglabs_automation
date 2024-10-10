Feature: End to end flow

    Scenario Outline: Login and checkout after adding items to cart
	Given User navigates-to "https://www.saucedemo.com/v1/" page 
	When User enters "<username>" as username
	And User enters "<password>" as password
	And User clicks on login button
	Then User verify page title should be "<title>" 
	Then User verify page URL includes "/inventory.html"
	When User add item to cart with name "<item01>"
	When User add item to cart with name "<item02>"
	Then User verify cart count updated to "<itemCount>"
	Then User clicks on cart Icon
	Then User verify page title should be "<title>" 
	Then User verify page URL includes "/cart.html"
	Then User verify item with name "<item01>" added in cart
	Then User verify item with name "<item02>" added in cart
	And User clicks on checkout button
	Then User verify page title should be "<title>" 
	Then User verify page URL includes "/checkout-step-one.html"
	When User enter firstname as "<fname>"
	And User enter lastname as "<lname>"
	And User enter zipcode as "<zip>"
	And User clicks on continue button
	Then User verify page title should be "<title>" 
	Then User verify page URL includes "/checkout-step-two.html"
	And User clicks finish button
	Then User verify page title should be "<title>" 
	Then User verify page URL includes "/checkout-complete.html"
	
	And User closes browser 
	
Examples:
|username|password|item01|item02|itemCount|title|fname|lname|zip|
|standard_user|secret_sauce|Sauce Labs Backpack|Sauce Labs Bolt T-Shirt|2|Swag labs|Tony|Starck|453622|
	
	