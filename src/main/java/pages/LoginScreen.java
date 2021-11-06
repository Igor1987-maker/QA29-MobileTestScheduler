package pages;

import dto.FieldsWithoutLombok;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginScreen extends BaseScreen{


    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(how = How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement emailEditText;

    @FindBy(how = How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordEditText;

    @AndroidFindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;

public LoginScreen fillEmail(String email){
    new WebDriverWait(driver,20)
            .until(ExpectedConditions.visibilityOf(emailEditText));
    type(emailEditText,email);
    return this;

}
    public LoginScreen fillPassword(String password){
        type(passwordEditText,password);
        return this;

    }


    public WizardScreen clickLoginButton(){
        hideKeyboard();
        loginButton.click();
        return new WizardScreen(driver);
    }

    public LoginScreen loginForm(FieldsWithoutLombok fwl){
        new WebDriverWait(driver,20)
                .until(ExpectedConditions.visibilityOf(emailEditText));
        type(emailEditText, fwl.getEmail());
        type(passwordEditText, fwl.getPassword());
        return this;

    }


}
