package pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.locators.NavigationLocators;
import utils.SeleniumDriver;
import utils.SeleniumHelper;

public class NavigationActions extends SeleniumHelper {

    NavigationLocators navigationLocators = null;

    public NavigationActions() {
        this.navigationLocators = PageFactory.initElements(SeleniumDriver.getDriver(),NavigationLocators.class);
    }

    public void navigateTo(String link){

        switch (link){
            case "Hotels" :
                clickElement(navigationLocators.hotelsLink);
                break;
            case "Flights" :
                clickElement(navigationLocators.flightsLink);
                break;
            case "Tours" :
                clickElement(navigationLocators.toursLink);
                break;
            case "Cars" :
                clickElement(navigationLocators.carsLink);
                break;
            case "Blog" :
                clickElement(navigationLocators.blogLink);
                break;
            case "Offers" :
                clickElement(navigationLocators.offersLink);
                break;
        }
    }

    public void navigateHome(){
        clickElement(navigationLocators.logo);
    }
}
