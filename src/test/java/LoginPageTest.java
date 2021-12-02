import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import pages.ForgotPassPage;
import pages.LoginPage;
import pages.MainPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginPageTest extends BaseTest {

    @Test
    @Order(1)
    @Description("Successful login")
    public void loginTest() {
        MainPage page = new LoginPage(driver)
                 .login(login, password);
        implicitlyWait(10);
        Assertions.assertTrue(page.avatarDisplayed());
    }

    @Test
    @Order(2)
    @Description("Login with spaces in login")
    public void loginSpaceTrimTest() {
        MainPage page = new LoginPage(driver)
                .login(spaceLogin, password);
        implicitlyWait(10);
        Assertions.assertTrue(page.avatarDisplayed());
    }

    @Test
    @Order(3)
    @Description(" Login to upper case")
    public void loginSpaceUpperCaseTest() {
        MainPage page = new LoginPage(driver)
                .login(login.toUpperCase(), password);
        implicitlyWait(10);
        Assertions.assertTrue(page.avatarDisplayed());
    }

    @Test
    @Order(4)
    @Description(" Login to lower case")
    public void loginLowerCaseTest() {
        MainPage page = new LoginPage(driver)
                .login(login.toLowerCase(), password);
        implicitlyWait(10);
        Assertions.assertTrue(page.avatarDisplayed());
    }

    @Test
    @Order(5)
    @Description("Empty login")
    public void loginEmptyLoginTest() {
        MainPage page = new LoginPage(driver)
            .login("", password);
            Assertions.assertEquals(page.getAlertText(),failedAuthAlertText);
    }
    @Test
    @Order(5)
    @Description("Empty login")
    public void loginEmptyLoginTest2() {
        MainPage page = new LoginPage(driver)
            .login("", password);
        Assertions.assertEquals(page.getAlertText(),failedAuthAlertText);
    }

    @Test
    @Order(6)
    @Description("Wrong password")
    public void wrongPasswordTest() {
        MainPage page = new LoginPage(driver)
            .login(login, "password");
            Assertions.assertEquals(page.getAlertText(),failedAuthAlertText2);
    }

    @Test
    @Order(7)
    @Description("Wrong login")
    public void wrongLoginTest() {
        MainPage page = new LoginPage(driver)
            .login("login", password);
            Assertions.assertEquals(page.getAlertText(),failedAuthAlertText2);
    }


    @Test
    @Order(8)
    @Description("Empty password")
    public void loginEmptyPassTest() {
        MainPage page = new LoginPage(driver)
                    .login(login, "");
            Assertions.assertEquals(page.getAlertText(),failedAuthAlertText);
    }

    @Test
    @Order(9)
    @Description(" Password with spaces")
    // Тест падает т.к.у переменной вызывает trim()
    public void loginSpacePassTest() {
        MainPage page = new LoginPage(driver)
                .login(login, spacePassword);
        Assertions.assertEquals(page.getAlertText(),failedAuthAlertText);
    }

    @Test
    @Order(10)
    @Description("Password to upper case")
    /*
     Тест должен проходить, но падает т.к. пароль изначально не содержит символов в нижнем регистре.
     Можно было залогиниться с паролем логином 1 и паролем 1 (а такая учетная запись есть),
     изменить пароль на другой, с символом в нижнем регистре, но это бы было не корректно.
    */

    public void loginUpperCasePasswordTest() {
        MainPage page = new LoginPage(driver)
                  .login(login, password.toUpperCase());
        Assertions.assertEquals(page.getAlertText(),failedAuthAlertText2);
    }

    @Test
    @Order(11)
    @Description("Password to lower case")
    public void loginLowerCasePasswordTest() {
        MainPage page = new LoginPage(driver)
                 .login(login, password.toLowerCase());
        Assertions.assertEquals(page.getAlertText(),failedAuthAlertText2);

    }

    @Test
    @Order(12)
    @Description("Copy password before eye click")
    public void copyPasswordBeforeEyeClickTest() {
        new LoginPage(driver)
                .inputUsernameField(login)
                .inputPasswordField(password)
                .copyPasswordField();
        Assertions.assertNotEquals(password, getBufferedString());
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
        Assertions.assertEquals(password, getBufferedString());
    }

    @Test
    @Order(14)
    @Description("Forgot login or password page opened")
    public void forgotPasswordTest() {
        ForgotPassPage page = new LoginPage(driver)
                .forgotPasswordClick();
        Assertions.assertTrue(page.loginOrEmailInputDisplayed());
    }

    @Test
    @Order(15)
    @Description("Successful password refresh by login")
    public void tryToRefreshPasswordByLoginTest() {
        ForgotPassPage page = new ForgotPassPage(driver)
                .forgotPasswordClick()
                .loginOrEmailInput(login)
                .submitButtonClick();
        Assertions.assertTrue(page.loginOrEmailSuccessDisplayed());
    }

    @Test
    @Order(16)
    @Description("Successful password refresh by email1")
    public void tryToRefreshPasswordByMail1Test() {
        ForgotPassPage page = new ForgotPassPage(driver)
                .forgotPasswordClick()
                .loginOrEmailInput(email1)
                .submitButtonClick();
        Assertions.assertTrue(page.loginOrEmailSuccessDisplayed());
    }

    @Test
    @Order(17)
    @Description("Successful password refresh by email2")
    public void tryToRefreshPasswordByMail2Test() {
        ForgotPassPage page = new ForgotPassPage(driver)
                .forgotPasswordClick()
                .loginOrEmailInput(email2)
                .submitButtonClick();
        Assertions.assertTrue(page.loginOrEmailSuccessDisplayed());
    }

    @Test
    @Order(18)
    @Description("Successful password refresh by email2")
    public void backToLoginPageTest() {
        LoginPage page = new LoginPage(driver)
                .forgotPasswordClick()
                .backToLoginPageButtonClick();
        Assertions.assertTrue(page.loginPageDisplayed());
    }

    @Test
    @Order(19)
    @Description("Wrong login or email alert ")
    public void wrongLoginOrEmailTest() {
        ForgotPassPage page = new ForgotPassPage(driver)
                .forgotPasswordClick()
                .loginOrEmailInput(wrongLogin)
                .submitButtonClick();
        Assertions.assertTrue(page.wrongLoginOrEmailAlertDisabled());
    }

    @Test
    @Order(20)
    @Description("Reset password with space login")
    public void passwordResetSpaceLoginTest() {
        ForgotPassPage page = new ForgotPassPage(driver)
                .forgotPasswordClick()
                .loginOrEmailInput(spaceLogin)
                .submitButtonClick();
        Assertions.assertTrue(page.loginOrEmailSuccessDisplayed());
    }

    @Test
    @Order(21)
    @Description("Reset password with space email")
    public void passwordResetSpaceEmailTest() {
        ForgotPassPage page = new ForgotPassPage(driver)
                .forgotPasswordClick()
                .loginOrEmailInput(spaceEmail)
                .submitButtonClick();
        Assertions.assertTrue(page.loginOrEmailSuccessDisplayed());
    }

    @Test
    @Order(22)
    @Description("Back to login page by click on logo")
    public void logoClickTest() {
        LoginPage page = new LoginPage(driver)
                .forgotPasswordClick()
                .logoClick();
        Assertions.assertTrue(page.loginPageDisplayed());
    }

    @Test
    @Order(23)
    @Description("Empty field submit button click")
    public void emptyFieldSubmitButtonClick() {
        ForgotPassPage page = new ForgotPassPage(driver)
                .forgotPasswordClick()
                .submitButtonClick();
        Assertions.assertTrue(page.wrongLoginOrEmailAlertDisabled());
    }
    @Test
    @Order(24)
    @Description("Login field accept symbols, digits, Russian language")
    public void textLoginFieldValidationTest() {
       new LoginPage(driver)
                .inputUsernameField("123!@#раздва")
                .usernameFieldCopy();
        Assertions.assertEquals("123!@#раздва",getBufferedString());
    }
    @Test
    @Order(25)
    @Description("Password field accept symbols, digits, Russian language")
    public void textPasswordFieldValidationTest() {
       new LoginPage(driver)
                .inputPasswordField("456$%^пять")
                .eyeButtonClick()
                .copyPasswordField();
        Assertions.assertEquals("456$%^пять",getBufferedString());
    }

}
