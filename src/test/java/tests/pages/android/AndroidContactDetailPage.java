package tests.pages.android;

import com.google.inject.Inject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import core.annotation.FindElement;
import core.drivermanager.DriverManager;
import core.element.BaseElement;
import core.element.LocatorType;
import tests.pages.abstractpages.ContactDetailPage;

public class AndroidContactDetailPage extends ContactDetailPage {

    @Inject
    public AndroidContactDetailPage(DriverManager manager)  {
        AppiumDriver<WebElement> driver = manager.getDriver();
        initElement(driver);
    }

    @FindElement(type = LocatorType.ID, value = "detail_name")
    private BaseElement contactName;

    @Override
    public String getContactName() {
        return contactName.getText();
    }

}
