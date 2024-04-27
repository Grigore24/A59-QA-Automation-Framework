import POM.BasePage;
import POM.LoginPage;
import POM.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test(groups = "ProfileTests")
    public void changeProfileName()  {
        LoginPage loginPage = new LoginPage(getDriver());
        ProfilePage profilePage = new ProfilePage(getDriver());
        BasePage basePage = new BasePage(getDriver());
        loginPage.login("grigore.crepciuc@testpro.io","te$t$tudent");
        String name = profilePage.generateRandomName();
        // open profile
        profilePage.clickOnAvatarIcon();
        // type password
        profilePage.typeCurrentPassword();
        // type new name
        profilePage.typeNewName(name);
        // type email
        profilePage.typeEmail();
        // click save
        profilePage.clickSaveBtn();
        // assert profile name is new
        basePage.refreshPage();
       // WebElement profile = waitUntilVisible(By.cssSelector(".view-profile>span"));
                //driver.findElement(By.cssSelector(".view-profile>span"));
        //String newName = profilePage.getProfileName();
        Assert.assertEquals(profilePage.getProfileName(), name);
    }

}
