Feature: SpecFlowFeature1
	In order to be able to see my wishlist
	As a user
	I want to be able to log in

@mytag
Scenario: Log in with correct 
	Given I am on the home page
	When I enter a correct email
	And I enter a correct password
	Then should be able to login
