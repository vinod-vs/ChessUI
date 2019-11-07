package helper;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.eo.Se;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import stepdefs.EntitySteps;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class hooks {

    private WebDriver driver;
    private static boolean startBrowser = false;
    private SeleniumHelper seleniumHelper;
    private static final Logger LOGGER = Logger.getLogger(hooks.class.getName());

    public hooks(SeleniumHelper seleniumHelper) {
        this.seleniumHelper = seleniumHelper;
    }

    @Before("@web")
    public void openBrowser(Scenario scenario) throws MalformedURLException {
        System.out.println(scenario.getName());
        if (!startBrowser) {
            LOGGER.info("Opening Browser");
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
            driver = new ChromeDriver();
            seleniumHelper.setDriver(driver);
            startBrowser = true;
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        }
    }
    @After("@web")
    public void afterScenario(Scenario scenario) {
         System.out.println(scenario.getStatus());
         driver.quit();

    }
}
