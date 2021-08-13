package core.drivermanager;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public abstract class DriverManager {

    protected AppiumDriver<WebElement> driver;

    public abstract AppiumDriver<WebElement> getDriver();
}
