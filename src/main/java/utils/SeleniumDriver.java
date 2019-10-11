package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class SeleniumDriver {

    private static SeleniumDriver seleniumDriver;

    private static WebDriver driver;

    private final static int TIMEOUT = 30;
    private final static int PAGE_LOAD_TIMEOUT = 30;
    public static Logger log;
    public String browserType;

    private SeleniumDriver() {

        BasicConfigurator.configure();
        log = Logger.getLogger("devpinoyLogger");

        //Set browser type
        if (System.getenv("browserType") != null) {
            browserType = System.getenv("browserType");
        } else {
            browserType = ProjectConfig.getConfig().getProperty("browserType");
        }

        //Instantiate appropriate WebDriver
        if (browserType.equalsIgnoreCase("chrome")) {
            getChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            getFirefoxDriver();
        } else if (browserType.equalsIgnoreCase("ie")) {
            getIEDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }

    public static void openPage(String url) {
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {
        if (seleniumDriver == null) {
            seleniumDriver = new SeleniumDriver();
        }
    }

    public static void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
        seleniumDriver = null;
    }

    private void getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        log.info("Chrome instantiated!");
    }

    private void getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        log.info("firefox instantiated!");
    }

    private void getIEDriver() {
        WebDriverManager.iedriver().arch32().setup();
        driver = new InternetExplorerDriver();
        log.info("IE instantiated!");
    }

}
