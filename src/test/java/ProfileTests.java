import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test(groups = "ProfileTests")
    public void changeProfileName() throws InterruptedException {
        String name = generateRandomName();
        login("grigore.crepciuc@testpro.io","te$t$tudent");
        Thread.sleep(1000);
        // open profile
        clickOnAvatarIcon();
        // type password
        typeCurrentPassword();
        // type new name
        typeNewName(name);
        // type email
        typeEmail();
        // click save
        clickSaveBtn();
        // assert profile name is new
        driver.navigate().refresh();
        WebElement profile = driver.findElement(By.cssSelector(".view-profile>span"));
        String newName = profile.getText();
        Assert.assertEquals(newName, name);
    }

    private void clickSaveBtn() {
        WebElement saveBtn = driver.findElement(By.cssSelector(".btn-submit"));
        saveBtn.click();
    }

    private void typeEmail() {
        WebElement emailInput = driver.findElement(By.cssSelector("#inputProfileEmail"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("grigore.crepciuc@testpro.io");

    }

    private void typeNewName(String name) {
        System.out.println(name);
        WebElement profileName = driver.findElement(By.cssSelector("#inputProfileName"));
        profileName.click();
        profileName.clear();
        profileName.sendKeys(name);
    }

    private void typeCurrentPassword() {
        WebElement currentPasswordInput = driver.findElement(By.id("inputProfileCurrentPassword"));
        currentPasswordInput.click();
        currentPasswordInput.clear();
        currentPasswordInput.sendKeys("te$t$tudent");
    }

    private void clickOnAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        avatarIcon.click();
    }
}
