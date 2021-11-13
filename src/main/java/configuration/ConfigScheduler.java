package configuration;

//"platformName": "Android",
//"deviceName": "Galaxy",
//"platformVersion": "8.1",
//"appPackage": "com.example.svetlana.scheduler",
//"appActivity": ".presentation.splashScreen.SplashScreenActivity"


import dto.Credentials;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ConfigScheduler {

    protected AppiumDriver<MobileElement> driver;
    Logger logger = LoggerFactory.getLogger(ConfigScheduler.class);

    @BeforeSuite

    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
        capabilities.setCapability("deviceName", "Galaxy");
        capabilities.setCapability("appPackage", "com.example.svetlana.scheduler");
        capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");


        driver = new AppiumDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new AppiumListener());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
