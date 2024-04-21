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
        WebElement profile = waitUntilVisible(By.cssSelector(".view-profile>span"));
                //driver.findElement(By.cssSelector(".view-profile>span"));
        String newName = profile.getText();
        Assert.assertEquals(newName, name);
    }

    private void clickSaveBtn() {
        WebElement saveBtn = waitUntilClickable(By.cssSelector(".btn-submit"));
                //driver.findElement(By.cssSelector(".btn-submit"));
        saveBtn.click();
    }

    private void typeEmail() {
        WebElement emailInput = waitUntilVisible(By.cssSelector("#inputProfileEmail"));
                //driver.findElement(By.cssSelector("#inputProfileEmail"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("grigore.crepciuc@testpro.io");

    }

    private void typeNewName(String name) {
        System.out.println(name);
        WebElement profileName = waitUntilVisible(By.cssSelector("#inputProfileName"));
                //driver.findElement(By.cssSelector("#inputProfileName"));
        profileName.click();
        profileName.clear();
        profileName.sendKeys(name);
    }

    private void typeCurrentPassword() {
        WebElement currentPasswordInput = waitUntilClickable(By.id("inputProfileCurrentPassword"));
                //driver.findElement(By.id("inputProfileCurrentPassword"));
        currentPasswordInput.click();
        currentPasswordInput.clear();
        currentPasswordInput.sendKeys("te$t$tudent");
    }

    private void clickOnAvatarIcon() {
        WebElement avatarIcon = waitUntilVisible(By.cssSelector("img[class='avatar']"));
                //driver.findElement(By.cssSelector("img[class='avatar']"));
        avatarIcon.click();
    }
}
