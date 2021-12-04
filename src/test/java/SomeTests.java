import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPassPage;
import pages.LoginPage;

public class SomeTests extends BaseTest {

    @Test(priority = 3)
    public void copyPasswordBeforeEyeClickTest() {
        String result = new LoginPage(driver)
                .inputUsernameField(login)
                .inputPasswordField(password)
                .copyPasswordField();
        Assert.assertNotEquals(password, result);
    }

    @Test(priority = 4)
    public void copyPasswordAfterEyeClickTest() {
        String resultPassword = new LoginPage(driver)
                .inputUsernameField(login)
                .inputPasswordField(password)
                .eyeButtonClick()
                .copyPasswordField2();
        Assert.assertEquals(password, resultPassword);
    }

    @Test(priority = 5)
    public void forgotPasswordTest() {
        ForgotPassPage page = new LoginPage(driver)
                .forgotPasswordClick();
        Assert.assertTrue(page.loginOrEmailInputDisplayed());
    }

    @Test(priority = 6)
    public void tryToRefreshPasswordByLoginTest() {
        ForgotPassPage page = new LoginPage(driver)
                .forgotPasswordClick()
                .loginOrEmailInput(login)
                .submitButtonClick();
        Assert.assertTrue(page.loginOrEmailSuccessDisplayed());
    }

    @Test(priority = 7)
    public void tryToRefreshPasswordByMail1Test() {
        ForgotPassPage page = new LoginPage(driver)
                .forgotPasswordClick()
                .loginOrEmailInput(email1)
                .submitButtonClick();
        Assert.assertTrue(page.loginOrEmailSuccessDisplayed());
    }

    @Test(priority = 8)
    public void tryToRefreshPasswordByMail2Test() {
        ForgotPassPage page = new LoginPage(driver)
                .forgotPasswordClick()
                .loginOrEmailInput(email2)
                .submitButtonClick();
        Assert.assertTrue(page.loginOrEmailSuccessDisplayed());
    }

    @Test(priority = 9)
    public void backToLoginPageTest() {
        LoginPage page = new LoginPage(driver)
                .forgotPasswordClick()
                .backToLoginPageButtonClick();
        Assert.assertTrue(page.loginPageDisplayed());
    }

    @Test(priority = 10)
    public void wrongLoginOrEmailTest() {
        ForgotPassPage page = new LoginPage(driver)
                .forgotPasswordClick()
                .loginOrEmailInput(wrongLogin)
                .submitButtonClick();
        Assert.assertTrue(page.wrongLoginOrEmailAlertDisabled());
    }

    @Test(priority = 11,enabled=false)
    public void passwordResetSpaceLoginTest() {
        ForgotPassPage page = new LoginPage(driver)
                .forgotPasswordClick()
                .loginOrEmailInput(spaceLogin)
                .submitButtonClick();
        Assert.assertTrue(page.loginOrEmailSuccessDisplayed());
    }

    @Test(priority = 12,enabled=false)
    public void passwordResetSpaceEmailTest() {
        ForgotPassPage page = new LoginPage(driver)
                .forgotPasswordClick()
                .loginOrEmailInput(spaceEmail)
                .submitButtonClick();
        Assert.assertTrue(page.loginOrEmailSuccessDisplayed());
    }

    @Test(priority = 13)
    public void logoClickTest() {
        LoginPage page = new LoginPage(driver)
                .forgotPasswordClick()
                .logoClick();
        Assert.assertTrue(page.loginPageDisplayed());
    }

    @Test(priority = 14)
    public void emptyFieldSubmitButtonClick() {
        ForgotPassPage page = new LoginPage(driver)
                .forgotPasswordClick()
                .submitButtonClick();
        Assert.assertTrue(page.wrongLoginOrEmailAlertDisabled());
    }

    @Test(priority = 15)
    public void textLoginFieldValidationTest() {
        String result = new LoginPage(driver)
                .inputUsernameField("123!@#раздва")
                .usernameFieldCopy();
        Assert.assertEquals("123!@#раздва", result);
    }

    @Test(priority = 16)
    public void textPasswordFieldValidationTest() {
        String result = new LoginPage(driver)
                .inputPasswordField("456$%^пять")
                .eyeButtonClick()
                .copyPasswordField();
        Assert.assertEquals("456$%^пять", result);
    }

}
