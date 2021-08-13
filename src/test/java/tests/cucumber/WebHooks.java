package tests.cucumber;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import core.drivermanager.DriverManager;

@Singleton
public class WebHooks {

    @Inject
    private Injector injector;

    // webdriver
    private AppiumDriver<WebElement> driver;

    // webdriver manager
    private DriverManager manager;

    public void start(){
        manager = injector.getInstance(DriverManager.class);
        manager.getDriver();
    }

    public void quit(){
        manager.getDriver().quit();
    }
}
