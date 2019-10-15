package pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.locators.LoginPageLocators;
import utils.SeleniumDriver;
import utils.SeleniumHelper;

public class LoginPageActions extends SeleniumHelper {

    LoginPageLocators loginPageLocators = null;

    public  LoginPageActions(){

        this.loginPageLocators = PageFactory.initElements(SeleniumDriver.getDriver(),LoginPageLocators.class);
    }

    public void enterUsername(String username){
        loginPageLocators.username.sendKeys(username);
    }

    public void enterPassword(String password){
        loginPageLocators.password.sendKeys(password);
    }

    public void clickLogInBtn(){
        clickElement(loginPageLocators.logInBtn);
    }

    public void verifyTitle(String title){
        waitFor(1000);
        Assert.assertEquals(title.toUpperCase(), SeleniumDriver.getDriver().getTitle().toUpperCase(),"User is not logged in successfully!");
    }

}
