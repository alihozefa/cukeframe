package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonPageLocators {

    //Quick Links****************************************************

    @FindBy(xpath = "//a[@class='navbar-brand go-right']//img")
    public WebElement homepageLink;

    //***************************************************************
}
