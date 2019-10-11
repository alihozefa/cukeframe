package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {

    @FindBy(linkText = "My Account")
    public WebElement myAccount;

    @FindBy(linkText = "Login")
    public WebElement login;
}
