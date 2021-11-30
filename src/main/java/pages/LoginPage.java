package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends AbstractPage {
    @FindBy(xpath = "//input[@name=\"user\"]")
    private WebElement userNameField;
    @FindBy(xpath = "//input[@name=\"password\"]")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submitButton;
    @FindBy(xpath = "//button[@id=\"show_password\"]")
    private WebElement eyeButton;
    @FindBy(xpath = "//a[@class=\"mira-default-login-page-link\"]")
    private WebElement forgotPassword;
    @FindBy(xpath = "//a[@class=\"mira-page-forgot-password-link\"]")
    private WebElement backToLoginPageButton;
    @FindBy(xpath = "//input[@name=\"loginOrEmail\"]")
    private WebElement loginOrEmailInput;
    @FindBy(xpath = "//div[text()=\"Пользователь с таким именем не найден.\"]")
    private WebElement wrongLoginOrEmailAlert;
    @FindBy(xpath = "//div[@class=\"success\"]")
    private WebElement loginOrEmailSuccess;
    @FindBy(xpath = "//div[@class=\"mira-page-login\"]")
    private WebElement loginPage;
    @FindBy(xpath = "//img[@src=\"Logo/Login\"]")
    private WebElement logo;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public boolean loginPageDisplayed() {

        takeScreenshot(driver);
        return loginPage.isDisplayed();
    }

    @Step
    public boolean loginOrEmailInputDisabled() {

        takeScreenshot(driver);
        return loginOrEmailInput.isDisplayed();
    }

    @Step
    public boolean wrongLoginOrEmailAlertDisabled() {

        takeScreenshot(driver);
        return wrongLoginOrEmailAlert.isDisplayed();
    }

    @Step
    public boolean loginOrEmailSuccessDisabled() {

        takeScreenshot(driver);
        return loginOrEmailSuccess.isDisplayed();
    }

    @Step
    public LoginPage inputUsernameField(String name) {
        userNameField.sendKeys(name);
        takeScreenshot(driver);
        return this;
    }

    @Step
    public LoginPage loginOrEmailInput(String name) {
        loginOrEmailInput.sendKeys(name);
        takeScreenshot(driver);
        return this;
    }

    @Step
    public LoginPage inputPasswordField(String password) {
        passwordField.sendKeys(password);
        takeScreenshot(driver);
        return this;
    }

    @Step
    public LoginPage copyPasswordField() {
        LoginPage page = new LoginPage(driver);
        page.passwordField.sendKeys(Keys.CONTROL, "a");
        page.passwordField.sendKeys(Keys.CONTROL, "c");
        takeScreenshot(driver);
        return this;

    }

    @Step
    public LoginPage submitButtonClick() {
        submitButton.click();
        takeScreenshot(driver);
        return this;
    }

    @Step
    public LoginPage logoClick() {
        logo.click();
        takeScreenshot(driver);
        return this;
    }

    @Step
    public LoginPage forgotPasswordClick() {
        forgotPassword.click();
        takeScreenshot(driver);
        return this;
    }

    @Step
    public LoginPage backToLoginPageButtonClick() {
        backToLoginPageButton.click();
        takeScreenshot(driver);
        return this;
    }

    @Step
    public LoginPage eyeButtonClick() {
        eyeButton.click();
        takeScreenshot(driver);
        return this;
    }

    @Step
    public LoginPage login(String user, String password) {
        new LoginPage(driver)
                .inputUsernameField(user)
                .inputPasswordField(password)
                .submitButtonClick();
        return this;
    }
}
