Feature: Product
    As a company representative
    I want to let my products searchable on homepage
    So that customers can search them easily

        Scenario: enter a valid word into search box
                Given I am on homepage
                When I enter iphone in search box
                Then the first product

        Scenario: enter an invalid word into searchbox
                Given I am on homepage
                When I enter invalid word into search box
                Then error no matching should be shown
