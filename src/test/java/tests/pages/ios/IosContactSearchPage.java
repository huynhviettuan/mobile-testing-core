package tests.pages.ios;

import com.google.inject.Inject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import core.annotation.FindElement;
import core.drivermanager.DriverManager;
import core.element.BaseElement;
import core.element.LocatorType;
import tests.pages.abstractpages.ContactSearchPage;

public class IosContactSearchPage extends ContactSearchPage {

    @Inject
    public IosContactSearchPage(DriverManager manager)  {
        AppiumDriver<WebElement> driver = manager.getDriver();
        initElement(driver);
    }

    @FindElement(type = LocatorType.XPATH, value = "//XCUIElementTypeSearchField[@name='Search for contact']")
    private BaseElement searchField;

    @FindElement(type = LocatorType.XPATH, value = "//XCUIElementTypeTable[@name=\"Search results\"]/XCUIElementTypeCell/XCUIElementTypeStaticText")
    private BaseElement firstSearchResultName;

    public void search(String name) {
        searchField.click();
        searchField.sendKeys(name);
    }

    public void navigateToSearchResultDetails() {
        firstSearchResultName.click();
    }

    public String getFirstContact() {
        return firstSearchResultName.getText();
    }

    @Override
    public void select(String name) {

    }
}
