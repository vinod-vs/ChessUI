package runner;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import helper.SeleniumHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import java.net.MalformedURLException;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"stepdefs" ,"helper"}, features = "src/test/resources/features", plugin = {
        "pretty", "json:target/report.json", "de.monochromata.cucumber.report.PrettyReports:target/pretty-cucumber"
})
public class Runner {

}


