
Feature: Online Store

 

Scenario: Successful Login with Valid Credentials
	Given User is on Home Page
	When User Navigate to LogIn Page
	And User enters Credentials to LogIn 
    | Username   | Password |
    | Sp1 | Toolsqa@01 |
    | Sp1 | Toolsqa@01 |
	Then Message displayed Login Successfully
	When User LogOut from the Application
	Then Message displayed LogOut Successfully
	