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

    public void mouseHoverAndNavigateTo(String mouseHoverLink){
        //mouseHover(navigationLocators.myActivityLink);
        //clickElement(navigationLocators.transactionActivityLink);

        switch (mouseHoverLink){
            case "Hotels" :
                mouseHover(navigationLocators.hotelsLink);
                break;
            case "Flights" :
                mouseHover(navigationLocators.flightsLink);
                break;
            case "Tours" :
                mouseHover(navigationLocators.toursLink);
                break;
            case "Cars" :
                mouseHover(navigationLocators.carsLink);
                break;
            case "Blog" :
                mouseHover(navigationLocators.blogLink);
                break;
            case "Offers" :
                mouseHover(navigationLocators.offersLink);
                break;
        }
    }
}
