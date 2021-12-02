package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPassPage extends AbstractPage {

    public ForgotPassPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class=\"mira-default-login-page-link\"]")
    private WebElement forgotPassword;
    @FindBy(xpath = "//input[@name=\"loginOrEmail\"]")
    private WebElement loginOrEmailInput;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class=\"success\"]")
    private WebElement loginOrEmailSuccess;
    @FindBy(xpath = "//div[text()=\"Пользователь с таким именем не найден.\"]")
    private WebElement wrongLoginOrEmailAlert;
    @FindBy(xpath = "//img[@src=\"Logo/Login\"]")
    private WebElement logo;
    @FindBy(xpath = "//a[@class=\"mira-page-forgot-password-link\"]")
    private WebElement backToLoginPageButton;


    @Step
    public ForgotPassPage forgotPasswordClick() {
        forgotPassword.click();
        takeScreenshot(driver);
        return this;
    }
    @Step
    public boolean loginOrEmailInputDisplayed() {

        takeScreenshot(driver);
        return loginOrEmailInput.isDisplayed();
    }
    @Step
    public ForgotPassPage loginOrEmailInput(String name) {
        loginOrEmailInput.sendKeys(name);
        takeScreenshot(driver);
        return this;
    }
    @Step
    public ForgotPassPage submitButtonClick() {
        submitButton.click();
        takeScreenshot(driver);
        return this;
    }
    @Step
    public boolean loginOrEmailSuccessDisplayed() {

        takeScreenshot(driver);
        return loginOrEmailSuccess.isDisplayed();
    }
    @Step
    public boolean wrongLoginOrEmailAlertDisabled() {

        takeScreenshot(driver);
        return wrongLoginOrEmailAlert.isDisplayed();
    }

    @Step
    public LoginPage logoClick() {
        logo.click();
        takeScreenshot(driver);
        return new LoginPage(driver);
    }
    @Step
    public LoginPage backToLoginPageButtonClick() {
        backToLoginPageButton.click();
        takeScreenshot(driver);
        return new LoginPage(driver);
    }



}
