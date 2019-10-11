package pages.actions;

import org.openqa.selenium.support.PageFactory;
import pages.locators.CommonPageLocators;
import utils.SeleniumDriver;
import utils.SeleniumHelper;

public class CommonPageActions extends SeleniumHelper {

    CommonPageLocators commonPageLocators = null;
    public CommonPageActions(){
        this.commonPageLocators = PageFactory.initElements(SeleniumDriver.getDriver(),CommonPageLocators.class);
    }

}
