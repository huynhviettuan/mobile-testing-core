package tests;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import core.BaseTest;
import core.capability.Capability;
import core.drivermanager.DriverModule;
import tests.pages.abstractpages.ContactDetailPage;
import tests.pages.abstractpages.ContactSearchPage;

import java.lang.reflect.Method;


/**
 * OOP
 * - Abstract
 * - Polymorphism
 * - Inheritance
 * - Encapsulation
 * <p>
 * Dependency
 * Class A -> Class B
 * Method A -> method B
 * Method A -> Class B
 * Project A -> project B
 */

@Guice(modules = {DriverModule.class, PageModule.class})
public class ContactSearchTest extends BaseTest {
    private ContactSearchPage searchPage;
    private ContactDetailPage detailPage;

    private AppiumDriver<WebElement> driver;

    private Capability extra;

    @Inject
    @Named("platform")
    private String platform;

    @BeforeMethod
    public void setupTest(Method method) {

        log.debug("platform: " + platform);

        String testcaseName = method.getName();

        log.debug(testcaseName);

        // khởi tạo 1 extra capability với tham số (dependency) là Method method
        extra = new ExtraCapability(method);

        // add extra capability và service
        service.add(extra);

        // khi khởi tạo 1 page đầu tiên, thì driver instance duoc khoi tao ~ application duoc start o page dau tien cua test case/suite
        searchPage = injector.getInstance(ContactSearchPage.class);
        detailPage = injector.getInstance(ContactDetailPage.class);
    }

    @AfterMethod
    public void teardownTest() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

        // notify result
    }

    @Test
    public void searchContact() {
        // add capability
        // testcase = searchContact

        //Search for contact
        searchPage.search("Sara");

        //Verify result
        Assert.assertEquals(searchPage.getFirstContact(), "Sara Alston");

        //Navigate to detail page
        searchPage.navigateToSearchResultDetails();

        //Verify that correct page is displayed
        Assert.assertEquals(detailPage.getContactName(), "Sara Alston");

//        searchPage.select("Jenny Cherry");
//        searchPage.select("Nadia Patten");
    }

}
