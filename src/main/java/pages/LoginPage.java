package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(css = "input.mira-default-login-page-text-input")
    private WebElement userNameField;
    @FindBy(xpath = "//input[@name=\"password\"]")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submitButton;
    @FindBy(xpath = "//button[@id=\"show_password\"]")
    private WebElement eyeButton;
    @FindBy(xpath = "//a[@class=\"mira-default-login-page-link\"]")
    private WebElement forgotPassword;
    @FindBy(xpath = "//div[@class=\"mira-page-login\"]")
    private WebElement loginPage;
    @FindBy(xpath = "//img[@src=\"Logo/Login\"]")
    private WebElement logo;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage login(String user, String password) {
        inputUsernameField(user);
        inputPasswordField(password);
        submitButtonClick();
        return new MainPage(driver);
    }

    public ForgotPassPage forgotPasswordClick() {
        forgotPassword.click();
        return new ForgotPassPage(driver);
    }

    public boolean loginPageDisplayed() {
        return loginPage.isDisplayed();
    }


    public LoginPage inputUsernameField(String name) {
        userNameField.sendKeys(name);
        return this;
    }


    public String usernameFieldCopy() {
        userNameField.sendKeys(Keys.CONTROL, "a");
        userNameField.sendKeys(Keys.CONTROL, "c");
        return getBufferedString();
    }


    public LoginPage inputPasswordField(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public String copyPasswordField() {
        passwordField.sendKeys(Keys.CONTROL, "a");
        passwordField.sendKeys(Keys.CONTROL, "c");
        return getBufferedString();
    }


    public String copyPasswordField2() {
        return passwordField.getAttribute("value");
    }


    public LoginPage submitButtonClick() {
        submitButton.click();
        return this;
    }


    public LoginPage eyeButtonClick() {
        eyeButton.click();
        return this;
    }

}
