Feature: checkout
    As a user
    I want to be able to checkout
    So that I know the total price of my purchase

        Scenario: checkout when nothing in my cart
                Given I have nothing in my cart
                When I hit checkout on homepage
                Then error message will tell me nothing in my cart

        Scenario: add magic mouse to cart
                Given I am on the page of magic mouse
                When I hit Add To Cart
                Then a notification will be shown

        Scenario: checkout when there is one magic mouse in the shopping cart
                Given I have a magic mouse in my shopping cart
                When I hit checkout in pop-up window
                Then a total price should be shown
