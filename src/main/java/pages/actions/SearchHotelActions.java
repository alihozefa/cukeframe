package pages.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.locators.SeachHotelLocators;
import utils.SeleniumDriver;
import utils.SeleniumHelper;

public class SearchHotelActions extends SeleniumHelper {

    SeachHotelLocators seachHotelLocators = null;

    public SearchHotelActions(){

        this.seachHotelLocators = PageFactory.initElements(SeleniumDriver.getDriver(), SeachHotelLocators.class);
    }

    public void searchHotel(String keywords){
        clickElement(seachHotelLocators.searchbox);
        seachHotelLocators.searchboxInput.sendKeys(keywords);
        waitForElement(seachHotelLocators.searchResults);
        waitFor(1000);
        seachHotelLocators.searchbox.sendKeys(Keys.ARROW_DOWN);
        seachHotelLocators.searchbox.sendKeys(Keys.TAB);
    }

    public void enterCheckInDate(String checkin){
        seachHotelLocators.checkin.sendKeys(checkin);
    }

    public void enterCheckOutDate(String checkout){
        seachHotelLocators.checkout.sendKeys(checkout);
    }


    public void clickSearchBtn(){
        clickElement(seachHotelLocators.button);
    }

}
