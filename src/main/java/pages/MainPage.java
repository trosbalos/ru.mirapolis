package pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {
    @FindBy(xpath = "//div[@class=\"mira-wrap-header mira-page-template-row\"]")
    private WebElement header;
    @FindBy(xpath = "//div[@class=\"template\"]/div")
    private WebElement dropDownAvatar;
    @FindBy(xpath = "//span[text()=\"Выйти\"]")
    private WebElement exitButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }


    public String getAlertText() {
        Alert alert = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.alertIsPresent()));
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public boolean headerDisplayed() {
        implicitlyWait(10);
        return header.isDisplayed();
    }

    public MainPage logout() {
        dropDownAvatar.click();
        exitButton.click();
        return this;
    }
}
