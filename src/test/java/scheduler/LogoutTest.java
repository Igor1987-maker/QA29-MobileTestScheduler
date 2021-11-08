package scheduler;

import configuration.ConfigScheduler;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomeScreen;
import pages.SplashScreen;

public class LogoutTest extends ConfigScheduler {

    @BeforeMethod
    public void preConditions(){
        new SplashScreen(driver)
               .checkVersion("0.0.3")
                .fillEmail("IgorP@gmail.ru")
                .fillPassword("As1234!~")
                .clickLoginButton()
                .skipWizard();

    }

    @Test
    public void logOut(){
        boolean isLogOutHappend = new HomeScreen(driver)
                .clickMenuButton()
                .clickLogOutButton()
                .isLogitButtonPresent();
        Assert.assertTrue(isLogOutHappend);
    }

}
