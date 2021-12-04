package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPassPage extends AbstractPage {


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

    public ForgotPassPage(WebDriver driver) {
        super(driver);
    }


    public LoginPage backToLoginPageButtonClick() {
        backToLoginPageButton.click();
        return new LoginPage(driver);
    }


    public LoginPage logoClick() {
        logo.click();
        return new LoginPage(driver);
    }


    public boolean loginOrEmailInputDisplayed() {
        return loginOrEmailInput.isDisplayed();
    }


    public ForgotPassPage loginOrEmailInput(String name) {
        loginOrEmailInput.sendKeys(name);
        return this;
    }


    public ForgotPassPage submitButtonClick() {
        submitButton.click();
        return this;
    }


    public boolean loginOrEmailSuccessDisplayed() {
        return loginOrEmailSuccess.isDisplayed();
    }


    public boolean wrongLoginOrEmailAlertDisabled() {
        return wrongLoginOrEmailAlert.isDisplayed();
    }
}
