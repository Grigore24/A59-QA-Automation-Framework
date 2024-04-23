package POM;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Locale;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    private By pressOnAvatarIcon = By.cssSelector("img[class='avatar']");
    private By wrightCurrentPassword = By.id("inputProfileCurrentPassword");
    private By wrightNewName = By.cssSelector("#inputProfileName");
    private By typeCurrentEmail = By.cssSelector("#inputProfileEmail");
    private By pressSaveBtn = By.cssSelector(".btn-submit");

    public String generateRandomName() {
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.name().firstName();
        return newName;
    }

    public void clickOnAvatarIcon() {
        WebElement avatarIcon = waitUntilVisible(pressOnAvatarIcon);
        //driver.findElement(By.cssSelector("img[class='avatar']"));
        avatarIcon.click();
    }

    public void typeCurrentPassword() {
        WebElement currentPasswordInput = waitUntilClickable(wrightCurrentPassword);
        //driver.findElement(By.id("inputProfileCurrentPassword"));
        currentPasswordInput.click();
        currentPasswordInput.clear();
        currentPasswordInput.sendKeys("te$t$tudent");
    }

    public void typeNewName(String name) {
        System.out.println(name);
        WebElement profileName = waitUntilVisible(wrightNewName);
        //driver.findElement(By.cssSelector("#inputProfileName"));
        profileName.click();
        profileName.clear();
        profileName.sendKeys(name);
    }

    public void typeEmail() {
        WebElement emailInput = waitUntilVisible(typeCurrentEmail);
        //driver.findElement(By.cssSelector("#inputProfileEmail"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("grigore.crepciuc@testpro.io");
    }
    public void clickSaveBtn() {
        WebElement saveBtn = waitUntilClickable(pressSaveBtn);
        //driver.findElement(By.cssSelector(".btn-submit"));
        saveBtn.click();
    }
}
