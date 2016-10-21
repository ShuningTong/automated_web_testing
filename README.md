This is the repo for deliverable 3 of IS2545 - Software Quality Assurance. I wrote 3 user stories and 9 scenarios in total using Selenium and Cucumber.

My user stories are as follows:
* As a user
> I want to login
> So that I can make purchase using my account

>* Scenario: login using correct credentials
                Given I am on homepage
                When I hit MyAccount
                And enter correct credentials
                Then there should be greetings

>* Scenario: login using correct username but incorrect password
                Given I am on homepage
                When I hit MyAccount
                And enter correct username but incorrect password
                Then error message should be displayed
        
>* Scenario: login using incorrect username and password
                Given I am on homepage
                When I hit MyAccount
                And enter incorrect username and password
                Then error message should be displayed

>* Scenario: login with empty username and password
                Given I am on homepage
                When I hit MyAccount
                And enter empty username and password
                Then message should be displayed to report empty input 

* As a user
> I want to be able to checkout
> So that I know the total price of my purchase

>* Scenario: checkout when nothing in my cart
                Given I have nothing in my cart
                When I hit checkout on homepage
                Then error message will tell me nothing in my cart

>* Scenario: add magic mouse to cart
                Given I am on the page of magic mouse
                When I hit Add To Cart
                Then a notification will be shown

>* Scenario: checkout when there is one magic mouse in the shopping cart
                Given I have a magic mouse in my shopping cart
                When I hit checkout in pop-up window
                Then a total price should be shown

* As a company representative
> I want to let my products searchable on homepage
> So that customers can search them easily

>* Scenario: enter a valid word into search box
                Given I am on homepage
                When I enter iphone in search box
                Then the first product

>* Scenario: enter an invalid word into searchbox
                Given I am on homepage
                When I enter invalid word into search box
                Then error no matching should be shown

My main concerns are as follows:
1. I find it very hard to do test using Selenium and Cucumber together, because Cucumber always try to run all scenarios written in feature file, even some of them do not have corresponding methods in StepDefinition file. It makes the coding process complicated, because I have to temporarily move some of scenarios out of my feature file to make program run quickly and bug-free. 

2. Since @Before and @After methods runs for each test case, the runtime is about 5 mins for all test cases. I think it has room for improvement, but I find out this post: [Why instantiate WebDriver for each @Test method?](http://stackoverflow.com/questions/19323231/why-instantiate-webdriver-for-each-test-method). It looks like if all tests would run in one go and it fails, we would be unable to tell where it failed.

3. If we do some incorrect username and password testing, the website will block our IP address and the error message will change, which makes the testing process even more painful.

4. For product user story, I have something like "When I enter iphone in search box" and "When I enter invalid word into search box". The search box on the website has some javascript function. It has some default value "search product". If I do not click on it first, value I send to it will be appended to the default value, which is very annoying. What's worse, the search box will change its class name after I click on it. So, finally I just let browser open the corresponding url directly. I gave up on sending keys to the search box.

5. xpath is very powerful, but takes time to be familiar with. I find it time-consuming to find a targeted element and figure out its xpath, especially for those elements without id or class. I tried to use Selenium IDE to find the element selector, but it looks like Selenium IDE does not have this function. The UI element tag is always empty.

