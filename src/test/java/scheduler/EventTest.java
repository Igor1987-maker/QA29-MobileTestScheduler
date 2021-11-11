package scheduler;

import configuration.ConfigScheduler;
import configuration.ListenerTestNG;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.SplashScreen;

@Listeners(ListenerTestNG.class)


public class EventTest extends ConfigScheduler {
@BeforeMethod
    public void preCondition(){
    new SplashScreen(driver)
            .checkVersion("0.0.3")
            .fillEmail("IgorP@gmail.ru")
            .fillPassword("As1234!~")
            .clickLoginButton()
            .skipWizard()
            .isFabAddButtonPresent();

}

@Test
    public void createEvent(){


}

}
