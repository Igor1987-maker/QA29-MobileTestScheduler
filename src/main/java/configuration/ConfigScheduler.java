package configuration;

//"platformName": "Android",
//"deviceName": "Galaxy",
//"platformVersion": "8.1",
//"appPackage": "com.example.svetlana.scheduler",
//"appActivity": ".presentation.splashScreen.SplashScreenActivity"


import dto.Credentials;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class ConfigScheduler {

    protected AppiumDriver<MobileElement> driver;

    @BeforeSuite

    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1");
        capabilities.setCapability("deviceName", "Galaxy");
        capabilities.setCapability("appPackage","com.example.svetlana.scheduler" );
        capabilities.setCapability("appActivity", ".presentation.splashScreen.SplashScreenActivity");


        driver = new AppiumDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);

    }


}
