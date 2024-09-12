
@tag
Feature: Purchase the order from the Ecommerce Website
  I want to use this template for my feature file

	Background:
	Given I landed on the EcommercePage

  @tag2
  Scenario Outline: Positive test of submitting the order
    Given Logged in with username <name> and password <password>
    When I addd product <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message displayed on the confirmationPage

    Examples: 
      | name  						| password 		| productName  		|
      | anshika@gmail.com | Iamking@000 | ADIDAS ORIGINAL |
      
