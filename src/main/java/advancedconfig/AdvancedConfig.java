package advancedconfig;

import configuration.AppiumListener;
import configuration.ConfigScheduler;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class AdvancedConfig {

    protected AppiumDriver<MobileElement> driver;
    Logger logger = LoggerFactory.getLogger(AdvancedConfig.class);

    @BeforeSuite

    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
        capabilities.setCapability("deviceName", "Galaxy");
        capabilities.setCapability("appPackage", "com.h6ah4i.android.example.advrecyclerview");
        capabilities.setCapability("appActivity", ".launcher.MainActivity");


        driver = new AppiumDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new AppiumListener());
        logger.info("Start super scheduler");
    }

    @BeforeMethod
    public void startLogger(Method m) {

        logger.info("Method" + m.getName() + "started");
    }

    @AfterMethod
    public void stopLogger(Method m) {

        logger.info("Stop method ------>" + m.getName());
    }
}
