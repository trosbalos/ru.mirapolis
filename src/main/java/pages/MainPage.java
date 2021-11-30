package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//img[@class=\"avatar\"]")
    private WebElement avatar;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public boolean avatarDisplayed() {

        takeScreenshot(driver);
        return avatar.isDisplayed();
    }
}
