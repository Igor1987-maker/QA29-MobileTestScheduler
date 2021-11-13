package advancedpages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SwipableBasicScreen extends SwipeScreen {
    public SwipableBasicScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    //*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/drag_handle']
    @FindBy(xpath = "//*[@resource-id='android:id/text1']")
    List<MobileElement> list;


    public SwipableBasicScreen removeItem() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOf(list.get(0)));
        MobileElement mobEl = list.get(0);
        Rectangle rec = mobEl.getRect();
        int x = rec.getX() + rec.getWidth() / 4;
        int y = rec.getY() + rec.getHeight() / 2;
        int xTo = x + (rec.getWidth() - x);
        int yTo = y;
        TouchAction<?> action = new TouchAction<>(driver);
        action.longPress(PointOption.point(x, y)).moveTo(PointOption.point(xTo, yTo))
                .release()
                .perform();

        return this;
    }

    public SwipableBasicScreen toPinneItem(){
new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOf(list.get(0)));
        MobileElement mobEl = list.get(0);
        Rectangle rec = mobEl.getRect();
       // int x = rec.getX() + rec.getWidth()-(rec.getWidth()/4);
       // int x = rec.getX() + ((rec.getWidth()*3)/4);
        int x = (rec.getWidth()*3)/4;
        int y = rec.getY() + rec.getHeight() / 2;
        int xTo = rec.getX();
        int yTo = y;
        TouchAction<?> action = new TouchAction<>(driver);
        action.longPress(PointOption.point(x, y)).moveTo(PointOption.point(xTo, yTo))
                .release()
                .perform();

        return this;
    }

}
