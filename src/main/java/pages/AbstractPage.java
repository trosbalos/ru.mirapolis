package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.ByteArrayInputStream;


public abstract class AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    void takeScreenshot(WebDriver webDriver) {
        Allure.addAttachment("Screenshot",
                new ByteArrayInputStream(((TakesScreenshot) webDriver)
                        .getScreenshotAs(OutputType.BYTES)));
    }
}
