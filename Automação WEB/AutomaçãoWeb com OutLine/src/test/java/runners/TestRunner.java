package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//aqui é o main do teste, aonde sinaliza como será rodado, utilizando as features, usará um "glue"
// unir/integrar com o pageSteps

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\features", glue = { "pageStep" }, plugin = { "pretty",
        "json:reports/cucumber-reports/cucumber.json", "html:reports/cucumber-reports/cucumber.html",
        "rerun:target/rerun.txt" }, monochrome = true)
public class TestRunner {}