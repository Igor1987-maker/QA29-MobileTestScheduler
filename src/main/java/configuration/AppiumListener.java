package configuration;

import com.google.common.io.Files;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.events.api.general.AppiumWebDriverEventListener;
import org.openqa.selenium.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import pages.BaseScreen;

import java.io.File;
import java.io.IOException;


public class AppiumListener
        implements AppiumWebDriverEventListener {

    Logger logger = LoggerFactory.getLogger(AppiumListener.class);
    public AppiumListener() {
        super();
    }



    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {

    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {

    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {

    }

    @Override
    public void afterNavigateForward(WebDriver driver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Element was found" + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Element found --->" + by);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void onException(Throwable throwable,WebDriver driver /*AppiumDriver driver*/) {
        //super.onException(throwable, driver);
        logger.info("Something went wrong"+throwable.fillInStackTrace().getMessage());

        /*int b = (int) (System.currentTimeMillis()/1000%3600);
        String str = "src/test/screenshots/screen-"+b+".png";
        BaseScreen bs = new BaseScreen((AppiumDriver<MobileElement>) driver);
        bs.takeScreenShot(str);*/
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        int i = (int) (System.currentTimeMillis()/1000%3600);
        File screenshot = new File("src/test/screenshots/screen-"+i+".png");
        try{
            Files.copy(file,screenshot);
        }catch(IOException e){
            e.printStackTrace();
        }


    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {

    }
}
