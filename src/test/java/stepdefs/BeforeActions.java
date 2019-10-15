package stepdefs;

import cucumber.api.java.Before;
import pages.actions.HomePageActions;
import pages.actions.LoginPageActions;
import utils.ProjectConfig;
import utils.SeleniumDriver;

import java.util.Properties;

public class BeforeActions {

    Properties properties;

    @Before
    public void setUp() {
        SeleniumDriver.setUpDriver();
        SeleniumDriver.openPage("https://www.phptravels.net/");
    }

    @Before("@requireLogin")
    public void defaultLogin() {
        properties = ProjectConfig.getConfig();
        SeleniumDriver.setUpDriver();
        LoginPageActions loginPageActions = new LoginPageActions();
        HomePageActions homePageActions = new HomePageActions();
        SeleniumDriver.openPage(properties.getProperty("URL"));
        homePageActions.clickLoginLink();
        loginPageActions.enterUsername(properties.getProperty("username"));
        loginPageActions.enterPassword(properties.getProperty("password"));
        loginPageActions.clickLogInBtn();
        loginPageActions.verifyTitle("My Account");
    }
}
