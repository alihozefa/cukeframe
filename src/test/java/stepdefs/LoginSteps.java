package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.actions.HomePageActions;
import pages.actions.LoginPageActions;
import utils.ExcelUtils;
import utils.ProjectConfig;
import utils.SeleniumDriver;
import utils.network.CreateMembers;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class LoginSteps {

    HomePageActions homePageActions = new HomePageActions();
    LoginPageActions loginPageActions = new LoginPageActions();
    List<HashMap<String,String>> testData;

    @Given("^user is on home page \"([^\"]*)\"$")
    public void user_is_on_home_page(String websiteURL) {
        SeleniumDriver.openPage(websiteURL);
    }

    @When("user clicks on Log_In link")
    public void user_clicks_on_Log_In_link() {
        homePageActions.clickLoginLink();
    }

    @And("^enter \"([^\"]*)\" in velocity number field$")
    public void enter_in_velocity_number_field(String username) {
        loginPageActions.enterUsername(username);
    }

    @And("^enter \"([^\"]*)\" in password field$")
    public void enter_in_password_field(String password) {
        loginPageActions.enterPassword(password);
    }

    @And("click on Log_In button")
    public void click_on_Log_In_button() {
        loginPageActions.clickLogInBtn();
    }

    @Then("I am at \"([^\"]*)\"")
    public void user_should_be_able_to_login_successfully(String title) {
        loginPageActions.verifyTitle(title);
    }

    @Given("^I am already logged in and at \"([^\"]*)\"$")
    public void iAmAlreadyLoggedInAndAt(String title) throws Throwable {
        loginPageActions.verifyTitle(title);
    }

    @And("^enter credentials of newly created member$")
    public void enterCredentialsOfNewlyCreatedMember() {
        String memberId = new CreateMembers().createMember();
        loginPageActions.enterUsername(memberId);
        loginPageActions.enterPassword(ProjectConfig.getConfig().getProperty("password"));
    }
}
