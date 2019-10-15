package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.actions.NavigationActions;
import pages.actions.SearchHotelActions;
import utils.SeleniumDriver;

public class SearchHotelSteps {

    NavigationActions navigationActions = new NavigationActions();
    SearchHotelActions searchHotelActions = new SearchHotelActions();

    @Given("^user is at the home page \"([^\"]*)\"$")
    public void userIsAtTheHomePage(String title) {
        navigationActions.navigateHome();
        Assert.assertEquals(SeleniumDriver.getDriver().getTitle(), title, "User is not at the hope page!!");
    }

    @When("^user select the \"([^\"]*)\" tab$")
    public void userSelectTheTab(String arg0) {
        navigationActions.navigateTo(arg0);
    }

    @And("^search hotel or city name \"([^\"]*)\"$")
    public void searchHotelOrCityName(String arg0) {
        searchHotelActions.searchHotel(arg0);
    }

    @And("^enter check-in date \"([^\"]*)\"$")
    public void enterCheckInDate(String arg0) {
        searchHotelActions.enterCheckInDate(arg0);
    }

    @And("^enter check-out date \"([^\"]*)\"$")
    public void enterCheckOutDate(String arg0) {
        searchHotelActions.enterCheckOutDate(arg0);
    }

    @And("^click search button$")
    public void clickSearchButton() {
        searchHotelActions.clickSearchBtn();
    }
}
