package advancedpages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DraggablebasicScreen extends BaseScreenADVN {


    public DraggablebasicScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/drag_handle']")
    List<MobileElement> list;

    public DraggablebasicScreen dragDown() {
        MobileElement el = list.get(0);
        Dimension window = driver.manage().window().getSize();
        System.out.println(window.getWidth() + window.getHeight());
        Rectangle rec = el.getRect();
        int x = rec.getX() + rec.getWidth() / 2;
        int y = rec.getY() + rec.getHeight() / 2;

        int xTo = x;
        int yTo = y + rec.getHeight();
        //int yTo = window.getHeight() - rec.getHeight()/2;


        TouchAction<?> touchaction = new TouchAction<>(driver);
        touchaction.longPress(PointOption.point(x, y)).moveTo(PointOption.point(xTo, yTo))
                .release()
                .perform();
        return this;
    }

    public DraggablebasicScreen dragUp(int index) {
        MobileElement el = list.get(index);
        Rectangle rec = el.getRect();
        int x = rec.getX() + rec.getWidth() / 2;
        int yFrom = rec.getY() + rec.getHeight() / 2;
        int yTo = yFrom - rec.getHeight();
        TouchAction<?> touchaction = new TouchAction<>(driver);
        touchaction.longPress(PointOption.point(x, yFrom)).moveTo(PointOption.point(x, yTo))
                .release()
                .perform();


        return this;
    }
    public DraggablebasicScreen dragDownCount(int count){
        MobileElement el = list.get(0);
        Dimension window = driver.manage().window().getSize();
        System.out.println("Size of window"+ window.getWidth()+"   " + window.getHeight());

        Rectangle rect = el.getRect();
        System.out.println("X>>" +rect.getX()+ "Y>>>"+rect.getY());
        int x = rect.getX() + rect.getWidth()/2;
        int y = rect.getY() + rect.getHeight()/2;

        int xTo =x;
        int yTo = y + rect.getHeight()*count;

        TouchAction <?>  touchAction = new TouchAction<>(driver);
        touchAction .longPress(PointOption.point(x,y))
                .moveTo(PointOption.point(xTo,yTo))
                .release()
                .perform();

        return this;

    }
    public DraggablebasicScreen dragDownWindow(){
        MobileElement el = list.get(0);
        Dimension window = driver.manage().window().getSize();
        System.out.println("Size of window"+ window.getWidth()+"   " + window.getHeight());

        Rectangle rect = el.getRect();
        System.out.println("X>>" +rect.getX()+ "Y>>>"+rect.getY());
        int x = rect.getX() + rect.getWidth()/2;
        int y = rect.getY() + rect.getHeight()/2;

        int xTo =x;
        int yTo = window.getHeight() - rect.getHeight()/2;

        TouchAction <?>  touchAction = new TouchAction<>(driver);
        touchAction .longPress(PointOption.point(x,y))
                .moveTo(PointOption.point(xTo,yTo))
                .release()
                .perform();

        return this;

    }
}