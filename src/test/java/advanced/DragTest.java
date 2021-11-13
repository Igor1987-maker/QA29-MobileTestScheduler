package advanced;

import advancedconfig.AdvancedConfig;
import advancedpages.DragScreen;
import org.testng.annotations.Test;

public class DragTest extends AdvancedConfig {

@Test
    public void dragTestScreen(){
    new DragScreen(driver)
            .selectDragableBasic()
            .dragDown();

}

}
