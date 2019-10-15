package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {

    @FindBy(css = "nav li#li_myaccount>a")
    public WebElement myAccount;

    @FindBy(linkText = "Login")
    public WebElement login;
}
