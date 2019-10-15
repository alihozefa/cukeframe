package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageLocators {

    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button[contains(@class,'loginbtn')]")
    public WebElement logInBtn;

    @FindBy(id = "remember-me")
    public WebElement rememberme;

    @FindBy(xpath = "//a[@href='#ForgetPassword']")
    public WebElement forgotPassword;
}
