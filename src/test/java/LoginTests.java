import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    @Parameters({"qaUrl"})
    public void loginEmailPasswordTest(String qaUrl) throws InterruptedException {
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));
        clickToElement(loginButton);
        WebElement avatar = getDriver().findElement(By.cssSelector(".avatar"));
        //wait.until(ExpectedConditions.visibilityOf(avatar));
        loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(avatar.isDisplayed());
        Assert.assertFalse(loginButton.isDisplayed());
    }

//    @Test
//    public void loginWithNotExistEmailTest(String qaUrl) throws InterruptedException {
//        provideEmail("notExist@class.com");
//        providePassword("te$t$tudent");
//        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));
//        clickToElement(loginButton);
//        Thread.sleep(5000);
//        Assert.assertTrue(loginButton.isDisplayed());
//    }

    @Test(dataProvider = "incorrectCredentials", dataProviderClass = DataProviderClass.class)
    public void loginWithIncorrectCredentials(String email, String password) throws InterruptedException {

        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));
        provideEmail(email);
        providePassword(password);
        clickToElement(loginButton);
       // wait.until(ExpectedConditions.visibilityOf(loginButton));
        Assert.assertTrue(loginButton.isDisplayed());
    }
}
