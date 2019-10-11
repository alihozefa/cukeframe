package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SeachHotelLocators {

    @FindBy(xpath = "//div[contains(@class,'locationlistthhotels')]//a")
    public WebElement searchbox;

    @FindBy(xpath = "//input[@id='s2id_autogen5']")
    public WebElement searchboxInput;

    @FindBy(xpath = "//ul[@class='select2-results']//li")
    public WebElement searchResults;

    @FindBy(xpath = "//div[@id='dpd1']//input[@placeholder='Check in']")
    public WebElement checkin;

    @FindBy(xpath = "//input[@placeholder='Check out']")
    public WebElement checkout;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-block btn-primary pfb0 loader']")
    public WebElement button;

}
