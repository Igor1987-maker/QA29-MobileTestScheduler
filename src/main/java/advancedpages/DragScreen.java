package advancedpages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class DragScreen extends BaseScreenADVN{
    public DragScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/button'][2]")
    MobileElement selectDraggable;
    @FindBy(xpath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc='Swipe']/android.widget.TextView")
    MobileElement selectSwipeScreen;

    public DraggablebasicScreen selectDragableBasic(){
        selectDraggable.click();

        return new DraggablebasicScreen(driver);
    }

    public SwipeScreen selecSwipeScreen(){
        selectSwipeScreen.click();

        return new SwipeScreen(driver);
    }

}
