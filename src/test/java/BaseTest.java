import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Locale;

public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
   // public String url = "https://qa.koel.app/";
    //for parallel execution
   private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public static WebDriver getDriver() {
        return threadDriver.get();
    }

//    @BeforeSuite
//    static void setupClass() {
//        WebDriverManager.chromedriver().setup();
//    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void lunchBrowser(String baseURL)throws MalformedURLException {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);
        //driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        getDriver().manage().window().maximize();
        //actions = new Actions(driver);
        //String url = baseURL;
        navigateToPage(baseURL);
    }

    private WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://172.20.10.2:4444";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "safari":
                WebDriverManager.safaridriver().setup();
                return driver = new SafariDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-safari":
                capabilities.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-notifications");
                options.addArguments("--start-maximized");
                return driver = new ChromeDriver(options);
        }
    }
    public WebDriver lambdaTest() throws MalformedURLException {
        String hubURL = "@hub.lambdatest.com/wd/hub";
        String userName = "greytfly";
        String accessKey = "7wXbxSZgFhBvIA71RRHCu2VmyU978XYiklFp1wlbK1ucJIB75H";
        //Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName","chrome");
        capabilities.setCapability("browserVersion","123.0");

       ChromeOptions browserOptions = new ChromeOptions();
       browserOptions.setPlatformName("MacOS Monterey");
       browserOptions.setBrowserVersion("123.0");
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("username", userName);
        ltOptions.put("accessKey", accessKey);
        ltOptions.put("project", "Koel");
        ltOptions.put("platformName","MacOS Monterey");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "java-java");
        //browserOptions.setCapability("LT:Options", ltOptions);
        capabilities.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(new URL("https://" + userName + ":" + accessKey + hubURL), capabilities);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();
    }
//    @AfterMethod(alwaysRun = true)
//    public void closeBrowser(){
//        driver.quit();
//    }
//    public void navigateToPage(String url) {
//        driver.get(url);
//    }
public void navigateToPage(String url) {
    getDriver().get(url);
}
    public WebElement waitUntilVisible(By element){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(element));
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
    //    public void navigateToPage() {
//        driver.get(url);
//    }
}