package stepdefs;

import cucumber.api.java.en.Given;
import helper.SeleniumHelper;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.logging.Logger;

public class EntitySteps {
    private static final Logger LOGGER = Logger.getLogger(EntitySteps.class.getName());
    SeleniumHelper seleniumHelper;

    public EntitySteps(SeleniumHelper seleniumHelper) {
        this.seleniumHelper = seleniumHelper;
    }

    @Given("I am on the website with URL {string}")
    public void iAmOnTheWebsiteWithURL(String url) {
        seleniumHelper.getDriver().get(url);
        LOGGER.info("Opening the url " + url);
        System.out.println(seleniumHelper.getDriver().getTitle());
    }

    @Given("Step from {string} in {string} feature file")
    public void step(String scenario, String file) {
        System.out.format("Thread ID - %2d - %s from %s feature file.\n",
                Thread.currentThread().getId(), scenario,file);
    }
}
