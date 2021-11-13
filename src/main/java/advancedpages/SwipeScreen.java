package advancedpages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SwipeScreen extends DragScreen{

    public SwipeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/button'][2]")
MobileElement selectSwipableBasic;

  public SwipableBasicScreen selectSwipableBasicScreen(){
      selectSwipableBasic.click();

      return new SwipableBasicScreen(driver);
  }


}
