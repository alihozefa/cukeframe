package pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.locators.HomePageLocators;
import utils.SeleniumDriver;
import utils.SeleniumHelper;

public class HomePageActions extends SeleniumHelper {

    HomePageLocators homePageLocators;

    public HomePageActions() {
        this.homePageLocators = PageFactory.initElements(SeleniumDriver.getDriver(),HomePageLocators.class);
    }

    public void clickLoginLink(){
        clickElement(homePageLocators.myAccount);
        waitForElement(homePageLocators.login);
        clickElement(homePageLocators.login);
    }

    public void clickJoinVelocityLink(){
        clickElement(homePageLocators.login);
    }
}
