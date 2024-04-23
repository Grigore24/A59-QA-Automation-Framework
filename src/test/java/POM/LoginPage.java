package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Locators
    By emailInput = By.cssSelector("input[type='email']");
    By passwordInput = By.cssSelector("input[type='password']");
    By pressLoginBtn = By.cssSelector("button[type='submit']");

    public void provideEmail(String email) {
        //findElement(emailInput).sendKeys(email);
        WebElement emailField = waitUntilVisible(emailInput);
                //wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        // WebElement emailField = driver.findElement(By.cssSelector("input[type = 'email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void providePassword(String password) {
        WebElement passwordField = findElement(passwordInput);
                //wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        // WebElement passwordField = driver.findElement(By.cssSelector("input[type = 'password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickLoginBtn() {
        WebElement loginBtn = waitUntilVisible(pressLoginBtn);
                //wait.until(ExpectedConditions.visibilityOfElementLocated(pressLoginBtn));
        // WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
    }
    public void login(String email, String password){
        provideEmail(email);
        providePassword(password);
        clickLoginBtn();
    }
    //////////////////////Homework16////////////
    public void findRegistrationLink() {
        //WebElement registrationLink = driver.findElement(By.cssSelector("[href='registration']"));
        WebElement registrationLink = waitUntilVisible(By.cssSelector("[href='registration']"));
        registrationLink.click();
    }

}
