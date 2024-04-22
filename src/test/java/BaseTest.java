import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.Locale;

public class BaseTest {
    public WebDriver driver = null;
    public WebDriverWait wait = null;
    public Actions actions = null;
   // public String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void lunchBrowser(String baseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        actions = new Actions(driver);
        //String url = baseURL;
        navigateToPage(baseURL);
    }
    /*@BeforeMethod
    public void lunchBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        navigateToPage();
    }*/
    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }

    public void clickLoginBtn() {
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
       // WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type = 'password']")));
       // WebElement passwordField = driver.findElement(By.cssSelector("input[type = 'password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type = 'email']")));
       // WebElement emailField = driver.findElement(By.cssSelector("input[type = 'email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

//    public void navigateToPage() {
//        driver.get(url);
//    }
    public void navigateToPage(String url) {
        driver.get(url);
    }
    public void login(String email, String password){
        provideEmail(email);
        providePassword(password);
        clickLoginBtn();
    }
    public String generateRandomName(){
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.name().firstName();
        return newName;
    }
    public String generateRandomPlaylistName(){
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.address().country();
        return newName;
    }
    public WebElement waitUntilVisible(By element){
        return new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public WebElement waitUntilClickable(By element){
        return new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.elementToBeClickable(element));
    }
}