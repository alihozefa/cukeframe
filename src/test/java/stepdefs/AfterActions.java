package stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.SeleniumDriver;

public class AfterActions {

    @After
    public void tearDown(Scenario scenario){

        WebDriver driver=SeleniumDriver.getDriver();
        if (scenario.isFailed()) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshotBytes, "image/png");

        }
        SeleniumDriver.tearDown();
    }
}
