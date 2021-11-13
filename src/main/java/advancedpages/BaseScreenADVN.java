package advancedpages;

import com.google.common.io.Files;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BaseScreenADVN {
    AppiumDriver<MobileElement> driver;

    public BaseScreenADVN(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


    public void type(MobileElement element, String text){
        element.click();
        element.clear();
        element.sendKeys(text);

    }

    public void hideKeyboard(){

        driver.hideKeyboard();
    }

    public void shouldHave(MobileElement element,String text,long timeout){
        new WebDriverWait(driver,timeout)
                .until(ExpectedConditions.textToBePresentInElement(element,text));
    }

    public boolean isDisplayedWithoutExp(MobileElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
    public void takeScreenShot(String pathToFile){
        File temp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File screenshot = new File(pathToFile);
        try{
            Files.copy(temp,screenshot);
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    public void should ( MobileElement element, long time){
        new WebDriverWait( driver,time)
                .until(ExpectedConditions.visibilityOf(element));
    }

}
