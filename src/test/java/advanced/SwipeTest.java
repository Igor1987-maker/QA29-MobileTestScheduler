package advanced;

import advancedconfig.AdvancedConfig;
import advancedpages.DragScreen;
import org.testng.annotations.Test;

public class SwipeTest extends AdvancedConfig {

    @Test
    public void swipeIconTest(){
        new DragScreen(driver)
                .selecSwipeScreen()
                .selectSwipableBasicScreen()
                .removeItem();

    }

    @Test
    public void pinneIconTest(){
        new DragScreen(driver)
                .selecSwipeScreen()
                .selectSwipableBasicScreen()
                .toPinneItem();

    }
}
