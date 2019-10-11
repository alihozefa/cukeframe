package runner;

import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CucumberOptions(
        plugin = {"json:target/RunCuke/cucumber.json", "pretty", "html:target/RunCuke/cucumber.html","com.cucumber.listener.ExtentCucumberFormatter"},
        features = "src/test/resource",
        glue = "stepdefs",
        monochrome = true,
        tags = {"@smoke-test"}
)
public class RunCuke extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void setup() {
        // Initiates the extent report and generates the output in the output/Run_<unique timestamp>/report.html file by default.
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_hhmmss");
        Date curDate = new Date();
        String strDate = sdf.format(curDate);
        String fileName = System.getProperty("user.dir")+"\\target\\Extent_Reports\\" + strDate+".html";
        File newFile = new File(fileName);
        ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile,false);

        // User can add the system information as follows
        ExtentCucumberFormatter.addSystemInfo("Browser Name", "Chrome");
        ExtentCucumberFormatter.addSystemInfo("Browser version", "v74.0");
        ExtentCucumberFormatter.addSystemInfo("Selenium version", "v3.53.0");

        // Also you can add system information using a hash map
        Map systemInfo = new HashMap();
        systemInfo.put("Cucumber version", "v1.2.3");
        systemInfo.put("Extent Cucumber Reporter version", "v1.1.0");
        ExtentCucumberFormatter.addSystemInfo(systemInfo);
    }

}
