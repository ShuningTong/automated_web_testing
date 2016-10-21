Feature: Login
    As a user
    I want to login
    So that I can make purchase using my account

	Scenario: login using correct credentials
		Given I am on homepage
                When I hit MyAccount
                And enter correct credentials
                Then there should be greetings

        Scenario: login using correct username but incorrect password
                Given I am on homepage
                When I hit MyAccount
                And enter correct username but incorrect password
                Then error message should be displayed
        
        Scenario: login using incorrect username and password
                Given I am on homepage
                When I hit MyAccount
                And enter incorrect username and password
                Then error message should be displayed

        Scenario: login with empty username and password
		Given I am on homepage
		When I hit MyAccount
		And enter empty username and password
		Then message should be displayed to report empty input
        


                
