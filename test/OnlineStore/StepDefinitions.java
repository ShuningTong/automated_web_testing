/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OnlineStore;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static junit.framework.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Predicate;
import cucumber.api.java.Before;
import org.openqa.selenium.Keys;

/**
 *
 * @author AsphaltPanthers
 */
public class StepDefinitions{
    public WebDriver driver;
    public WebDriverWait wait;
    private final String HOME_PAGE = "http://store.demoqa.com/";
    
    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "libs/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 30);
    }
    
    @Given("a Firefox browser")
    public void openFirefox() {
    }
    
    @When("I navigate to the home page")
    public void navigateHome() {
        driver.get(HOME_PAGE);
    }
    
    @Then("the title should be (.*)")
    public void checkPageTitle(String title) {
        assertEquals(title, driver.getTitle());
    }
                        
    @Given("I am on homepage")
    public void onHomePage() {
        driver.get(HOME_PAGE);
    }
    
    @When("I hit MyAccount")
    public void hitMyAccount() {
        driver.findElement(By.xpath("//div[@id='account']")).click();
    }
    
    @When("enter correct credentials")
    public void enterCorrectCredentials() {
        wait.until((Predicate <WebDriver>) d -> d.findElement(By.xpath("//input[@id='log']")).isDisplayed());
        driver.findElement(By.xpath("//input[@id='log']")).sendKeys("shuningtong");
        driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("1991@Sn0213");
        driver.findElement(By.xpath("//input[@id='login']")).click();
    }
    
    @Then("there should be greetings")
    public void checkGreetings() {
        wait.until((Predicate <WebDriver>) d -> d.findElement(By.xpath("//li[@id='wp-admin-bar-my-account']/a")).isDisplayed());
        assertEquals("Howdy, shuningtong", driver.findElement(By.xpath("//li[@id='wp-admin-bar-my-account']/a")).getText());
    } 
    
    @When("enter correct username but incorrect password")
    public void enterCorrectUsernameButIncorrectPassword() {
        wait.until((Predicate <WebDriver>) d -> d.findElement(By.xpath("//input[@id='log']")).isDisplayed());
        driver.findElement(By.xpath("//input[@id='log']")).sendKeys("shuningtong");
        driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("incorrectpassword");
        driver.findElement(By.xpath("//input[@id='login']")).click();
    }
    
    @Then("error message should be displayed")
    public void errorMessageDisplayed() {
        wait.until((Predicate <WebDriver>) d -> d.findElement(By.xpath("//p[@class='response']")).isDisplayed());
        assertEquals("ERROR", driver.findElement(By.xpath("//p[@class='response']")).getText().substring(0, 5));
    } 
    
    @Then("message should be displayed to report empty input")
    public void messageReportEmptyInput() {
        wait.until((Predicate <WebDriver>) d -> d.findElement(By.xpath("//p[@class='response']")).isDisplayed());
        assertEquals("Please enter your username and password.", driver.findElement(By.xpath("//p[@class='response']")).getText());
    } 
    
    @When("enter incorrect username and password")
    public void enterIncorrectUsernameAndPassword() {
        wait.until((Predicate <WebDriver>) d -> d.findElement(By.xpath("//input[@id='log']")).isDisplayed());
        driver.findElement(By.xpath("//input[@id='log']")).sendKeys("incorrectusername");
        driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("incorrectpassword");
        driver.findElement(By.xpath("//input[@id='login']")).click();
    }
    
    @When("enter empty username and password")
    public void enterEmptyUsernameAndPassword() {
        wait.until((Predicate <WebDriver>) d -> d.findElement(By.xpath("//input[@id='log']")).isDisplayed());
        driver.findElement(By.xpath("//input[@id='log']")).sendKeys("");
        driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("");
        driver.findElement(By.xpath("//input[@id='login']")).click();
    }
    
    @Given("I am on the page of magic mouse")
    public void onMagicMousePage() {
        driver.get("http://store.demoqa.com/products-page/product-category/accessories/magic-mouse/");
    }
    
    @When("I hit Add To Cart")
    public void hitAddToCart() {
        driver.findElement(By.xpath("//input[@class='wpsc_buy_button']")).click();
    }
    
    @Then("a notification will be shown")
    public void notificationDisplayed() {
        wait.until((Predicate <WebDriver>) d -> d.findElement(By.xpath("//div[@id='fancy_notification_content']/span")).isDisplayed());
        assertEquals("You just added \"Magic Mouse\" to your cart.", driver.findElement(By.xpath("//div[@id='fancy_notification_content']/span")).getText());
    } 
    
    @Given("I have a magic mouse in my shopping cart")
    public void haveMagicMouseInCart() {
        driver.get(HOME_PAGE);
        if (!driver.findElement(By.xpath("//em[@class='count']")).getText().equals("0")){
            driver.findElement(By.xpath("//span[@class='icon']")).click();
            wait.until((Predicate <WebDriver>) d -> d.findElement(By.xpath("//form[@class='adjustform remove']/input[3]")).isDisplayed());
            driver.findElement(By.xpath("//form[@class='adjustform remove']/input[3]")).click();
        }
        driver.get("http://store.demoqa.com/products-page/product-category/accessories/magic-mouse/");
        driver.findElement(By.xpath("//input[@class='wpsc_buy_button']")).click();
    }
    
    @When("I hit checkout in pop-up window")
    public void hitCheckoutInPopup() {
        wait.until((Predicate <WebDriver>) d -> d.findElement(By.xpath("//div[@id='fancy_notification_content']/a[@class='go_to_checkout']")).isDisplayed());
        driver.findElement(By.xpath("//div[@id='fancy_notification_content']/a[@class='go_to_checkout']")).click();
    }
    
    @Then("a total price should be shown")
    public void showTotalPrice() {
        wait.until((Predicate <WebDriver>) d -> d.findElement(By.xpath("//span[@class='yourtotal']")).isDisplayed());
        assertEquals("$150.00", driver.findElement(By.xpath("//span[@class='pricedisplay']")).getText());
    }
    
    @Given("I have nothing in my cart")
    public void haveNothingInCart() {
        driver.get(HOME_PAGE);
        assertEquals("0",driver.findElement(By.xpath("//em[@class='count']")).getText());
        driver.findElement(By.xpath("//span[@class='icon']")).click();
    }
    
    @When("I hit checkout on homepage")
    public void hitCheckoutOnHomepage() {
        driver.findElement(By.xpath("//span[@class='icon']")).click();
    }
    
    @Then("error message will tell me nothing in my cart")
    public void errorTellingNothingInCart() {
        wait.until((Predicate <WebDriver>) d -> d.findElement(By.xpath("//div[@class='entry-content']")).isDisplayed());
        assertEquals("Oops, there is nothing in your cart.", driver.findElement(By.xpath("//div[@class='entry-content']")).getText());
    }

    @When("I enter iphone in search box")
    public void enterIphoneInSearchBox() {
        driver.get("http://store.demoqa.com/?s=iphone&post_type=wpsc-product");
    }
      
    @When("I enter invalid word into search box")
    public void enterInvalidWordInSearchBox() {
        driver.get("http://store.demoqa.com/?s=invalidword&post_type=wpsc-product");
    }
    
    @Then("the first product")
    public void firstProductIsIphone() {
        wait.until((Predicate <WebDriver>) d -> d.findElement(By.xpath("//div[@id='grid_view_products_page_container']/div/div/div[2]/h2/a")).isDisplayed());
        assertEquals("Apple iPhone 4S 32GB SIM-Free – White", driver.findElement(By.xpath("//div[@id='grid_view_products_page_container']/div/div/div[2]/h2/a")).getText());
    }
    
    @Then("error no matching should be shown")
    public void noMatchingProductsDisplayed() {
        wait.until((Predicate <WebDriver>) d -> d.findElement(By.xpath("//div[@id='content']/p")).isDisplayed());
        assertEquals("Sorry, but nothing matched your search criteria. Please try again with some different keywords.", driver.findElement(By.xpath("//div[@id='content']/p")).getText());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
