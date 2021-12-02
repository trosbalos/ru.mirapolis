package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//img[@class=\"avatar\"]")
    private WebElement avatar;

    @Step
    public String getAlertText(){
        return (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.alertIsPresent())).getText();
    }

    @Step
    public boolean avatarDisplayed() {
        takeScreenshot(driver);
        return avatar.isDisplayed();
    }
}
