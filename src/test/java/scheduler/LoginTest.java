package scheduler;

import configuration.ConfigScheduler;
import configuration.MyDataProvider;
import dto.Credentials;
import dto.FieldsWithoutLombok;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.SplashScreen;




public class LoginTest extends ConfigScheduler {

    @Test
    public  void loginTest(){

        boolean isFabPresent = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .fillEmail("IgorP@gmail.ru")
                .fillPassword("As1234!~")
                .clickLoginButton()
                .skipWizard()
                .isFabAddButtonPresent();
        Assert.assertTrue(isFabPresent);

    }

    @Test(dataProvider = "dataForLoginTest",dataProviderClass = MyDataProvider.class)
    public  void loginTestWithCredentials(String email,String password){
      /* Credentials credentials = Credentials.builder()
                .email(email)
                .password(password);*/

        FieldsWithoutLombok fwl = new FieldsWithoutLombok()
                .setEmail(email)
                .setPassword(password);

        boolean isFabPresent = new SplashScreen(driver)
                .checkVersion("0.0.3")
                .loginForm(fwl)
                .clickLoginButton()
                .skipWizard()
                .isFabAddButtonPresent();
        Assert.assertTrue(isFabPresent);

    }
}
