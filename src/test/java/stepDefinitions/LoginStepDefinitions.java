package stepDefinitions;
import POM.HomePage;
import POM.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @After
    public void iCloseBrowser(){
        driver.quit();
    }
    @Given("I open Login Page")
    public void iOpenLoginPage(){
        driver.get("https://qa.koel.app/");
    }
    @When("I enter valid email {string}")
    public void iEnterEmail(String email){
      //  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']"))).sendKeys(email);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
    }
    @And("I enter valid password {string}")
    public void iEnterPassword(String password){
//        wait.until(ExpectedConditions
//                .elementToBeClickable(By.cssSelector("[type='password']"))).sendKeys(password);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
    }
    @And("I click submit")
    public void clickSubmit(){
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']"))).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginBtn();
    }
    @Then("I am logged in")
    public void userIsLoggedIn(){
       // Assert.assertTrue(wait.until(ExpectedConditions
        // .visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.getAvatar());
    }
}