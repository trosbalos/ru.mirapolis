import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.UnhandledAlertException;
import pages.LoginPage;
import pages.MainPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginPageTest extends BaseTest {

    @Test
    @Order(1)
    @Description("Successful login")
    public void loginTest() {
        new LoginPage(driver).login(login, password);
        implicitlyWait(10);
        Assertions.assertTrue(new MainPage(driver).avatarDisplayed());
    }

    @Test
    @Order(2)
    @Description("Login with spaces in login")
    public void loginSpaceTrimTest() {
        new LoginPage(driver).login(spaceLogin, password);
        implicitlyWait(10);
        Assertions.assertTrue(new MainPage(driver).avatarDisplayed());
    }

    @Test
    @Order(3)
    @Description(" Login to upper case")
    public void loginSpaceUpperCaseTest() {
        new LoginPage(driver).login(login.toUpperCase(), password);
        implicitlyWait(10);
        Assertions.assertTrue(new MainPage(driver).avatarDisplayed());
    }

    @Test
    @Order(4)
    @Description(" Login to lower case")
    public void loginLowerCaseTest() {
        new LoginPage(driver).login(login.toLowerCase(), password);
        implicitlyWait(10);
        Assertions.assertTrue(new MainPage(driver).avatarDisplayed());
    }

    @Test
    @Order(5)
    @Description("Empty login")
    public void loginEmptyLoginTest() {
        try {
            new LoginPage(driver).login("", password);
        } catch (UnhandledAlertException e) {
            Assertions.assertEquals(failedAuthAlertText, e.getAlertText());
        }
        Assertions.assertTrue(new LoginPage(driver).loginPageDisplayed());
    }

    @Test
    @Order(6)
    @Description("Wrong password")
    public void wrongPasswordTest() {
        try {
            new LoginPage(driver).login(login, "password");
        } catch (UnhandledAlertException e) {
            Assertions.assertEquals(failedAuthAlertText2, e.getAlertText());
        }
        Assertions.assertTrue(new LoginPage(driver).loginPageDisplayed());
    }

    @Test
    @Order(7)
    @Description("Wrong login")
    public void wrongLoginTest() {
        try {
            new LoginPage(driver).login("login", password);
        } catch (UnhandledAlertException e) {
            Assertions.assertEquals(failedAuthAlertText2, e.getAlertText());
        }
        Assertions.assertTrue(new LoginPage(driver).loginPageDisplayed());
    }


    @Test
    @Order(8)
    @Description("Empty password")
    public void loginEmptyPassTest() {
        try {
            new LoginPage(driver).login(login, "");

        } catch (UnhandledAlertException e) {
            Assertions.assertEquals(failedAuthAlertText, e.getAlertText());
        }
        Assertions.assertTrue(new LoginPage(driver).loginPageDisplayed());
    }

    @Test
    @Order(9)
    @Description("Empty password")
    @Disabled
    public void loginSpacePassTest() {
        try {
            new LoginPage(driver).login(login, spacePassword);

        } catch (UnhandledAlertException e) {
            Assertions.assertEquals(failedAuthAlertText, e.getAlertText());
        }
        Assertions.assertTrue(new LoginPage(driver).loginPageDisplayed());
    }

    @Test
    @Order(10)
    @Description("Password to upper case")
    public void loginUpperCasePasswordTest() {
        try {
            new LoginPage(driver).login(login, password.toUpperCase());
        } catch (UnhandledAlertException e) {
            Assertions.assertEquals(failedAuthAlertText2, e.getAlertText());
        }
        Assertions.assertTrue(new LoginPage(driver).loginPageDisplayed());
    }

    @Test
    @Order(11)
    @Description("Password to lower case")
    public void loginLowerCasePasswordTest() {
        try {
            new LoginPage(driver).login(login, password.toLowerCase());

        } catch (UnhandledAlertException e) {
            Assertions.assertEquals(failedAuthAlertText2, e.getAlertText());
        }
        Assertions.assertTrue(new LoginPage(driver).loginPageDisplayed());

    }

    @Test
    @Order(12)
    @Description("Copy password before eye click")
    public void copyPasswordBeforeEyeClickTest() {
        new LoginPage(driver)
                .inputUsernameField(login)
                .inputPasswordField(password)
                .copyPasswordField();
        Assertions.assertNotEquals(password, ((getBufferedString())));
    }

    @Test
    @Order(13)
    @Description("Copy password after eye click")
    public void copyPasswordAfterEyeClickTest() {
        new LoginPage(driver)
                .inputUsernameField(login)
                .inputPasswordField(password)
                .eyeButtonClick()
                .copyPasswordField();
        Assertions.assertEquals(password, ((getBufferedString())));
    }

    @Test
    @Order(14)
    @Description("Forgot login or password page opened")
    public void forgotPasswordTest() {
        new LoginPage(driver)
                .forgotPasswordClick();
        Assertions.assertTrue(new LoginPage(driver).loginOrEmailInputDisabled());
    }

    @Test
    @Order(15)
    @Description("Successful password refresh by login")
    public void tryToRefreshPasswordByLoginTest() {
        new LoginPage(driver)
                .forgotPasswordClick()
                .loginOrEmailInput(login)
                .submitButtonClick();
        Assertions.assertTrue(new LoginPage(driver).loginOrEmailSuccessDisabled());
    }

    @Test
    @Order(16)
    @Description("Successful password refresh by email1")
    public void tryToRefreshPasswordByMail1Test() {
        new LoginPage(driver)
                .forgotPasswordClick()
                .loginOrEmailInput(email1)
                .submitButtonClick();
        Assertions.assertTrue(new LoginPage(driver).loginOrEmailSuccessDisabled());
    }

    @Test
    @Order(17)
    @Description("Successful password refresh by email2")
    public void tryToRefreshPasswordByMail2Test() {
        new LoginPage(driver)
                .forgotPasswordClick()
                .loginOrEmailInput(email2)
                .submitButtonClick();
        Assertions.assertTrue(new LoginPage(driver).loginOrEmailSuccessDisabled());
    }

    @Test
    @Order(18)
    @Description("Successful password refresh by email2")
    public void backToLoginPageTest() {
        new LoginPage(driver)
                .forgotPasswordClick()
                .backToLoginPageButtonClick();
        Assertions.assertTrue(new LoginPage(driver).loginPageDisplayed());
    }

    @Test
    @Order(19)
    @Description("Wrong login or email alert ")
    public void wrongLoginOrEmailTest() {
        new LoginPage(driver)
                .forgotPasswordClick()
                .loginOrEmailInput(wrongLogin)
                .submitButtonClick();
        Assertions.assertTrue(new LoginPage(driver).wrongLoginOrEmailAlertDisabled());
    }

    @Test
    @Order(20)
    @Description("Reset password with space login")
    @Disabled
    public void passwordResetSpaceLoginTest() {
        new LoginPage(driver)
                .forgotPasswordClick()
                .loginOrEmailInput(spaceLogin)
                .submitButtonClick();
        Assertions.assertTrue(new LoginPage(driver).loginOrEmailSuccessDisabled());
    }

    @Test
    @Order(21)
    @Description("Reset password with space email")
    @Disabled
    public void passwordResetSpaceEmailTest() {
        new LoginPage(driver)
                .forgotPasswordClick()
                .loginOrEmailInput(spaceEmail)
                .submitButtonClick();
        Assertions.assertTrue(new LoginPage(driver).loginOrEmailSuccessDisabled());
    }

    @Test
    @Order(22)
    @Description("Back to login page by click on logo")
    public void logoClickTest() {
        new LoginPage(driver)
                .forgotPasswordClick()
                .logoClick();
        Assertions.assertTrue(new LoginPage(driver).loginPageDisplayed());
    }

    @Test
    @Order(23)
    @Description("Empty field submit button click")
    public void emptyFieldSubmitButtonClick() {
        new LoginPage(driver)
                .forgotPasswordClick()
                .submitButtonClick();
        Assertions.assertTrue(new LoginPage(driver).wrongLoginOrEmailAlertDisabled());
    }

}
