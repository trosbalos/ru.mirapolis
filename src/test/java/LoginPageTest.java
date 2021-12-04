import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1, dataProvider = "positiveAdditionData", dataProviderClass = TestDataProvider.class)
    public void loginTest(String login, String password) {
        MainPage page = new LoginPage(driver).login(login, password);
        Assert.assertTrue(page.headerDisplayed());
    }

    @Test(priority = 2, dataProvider = "negativeAdditionData", dataProviderClass = TestDataProvider.class)
    public void loginEmptyLoginTest(String login, String password) {

        MainPage page = new LoginPage(driver)
                .login(login, password);
        Assert.assertTrue(page.getAlertText().contains(failedAuthAlertText));
    }
}
