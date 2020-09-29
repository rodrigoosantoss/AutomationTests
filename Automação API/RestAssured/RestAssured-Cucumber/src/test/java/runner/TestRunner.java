package runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)


@CucumberOptions(features = "src\\test\\java\\features",
        glue = {"steps"},
        plugin = {"pretty",
                "json:reports/cucumber-results.json",
                "html:reports/cucumber-results.html"},
        tags = {},
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class TestRunner {
}
