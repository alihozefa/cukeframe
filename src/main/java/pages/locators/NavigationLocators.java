package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationLocators {

    @FindBy(xpath = "//a[@href='https://www.phptravels.net/']")
    public WebElement logo;

    @FindBy(linkText = "Hotels")
    public WebElement hotelsLink;

    @FindBy(linkText = "Flights")
    public WebElement flightsLink;

    @FindBy(linkText = "Tours")
    public WebElement toursLink;

    @FindBy(linkText = "Cars")
    public WebElement carsLink;

    @FindBy(linkText = "Blog")
    public WebElement blogLink;

    @FindBy(linkText = "Offers")
    public WebElement offersLink;
}
