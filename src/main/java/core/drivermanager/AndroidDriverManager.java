package core.drivermanager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import core.capability.Service;
import core.exception.DriverInitException;

import javax.inject.Inject;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class AndroidDriverManager extends DriverManager {

    // create by injector of DriverManagerFactory
    @Inject
    private Service service;

    public AppiumDriver<WebElement> getDriver()  {

        if (driver != null)
            return driver;

        Map<String, Object> map = service.loadCapability();

        DesiredCapabilities capabilities = new DesiredCapabilities(map);
        String appiumServer = (String) map.get("appium_server");
        try {
            driver = new AndroidDriver<>(new URL(appiumServer), capabilities);
        } catch (MalformedURLException e) {
            throw new DriverInitException(e.getMessage(), e);
        }
        return driver;
    }

}
