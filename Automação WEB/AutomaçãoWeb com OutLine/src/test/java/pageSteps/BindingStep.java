package pageSteps;

import core.DriverFactory;
import core.ProjectProperties;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.FixReport;
import utils.Report;

import static core.DriverFactory.getDriver;

public class BindingStep {
    public static Scenario scenario;

    @Before
    public void init(Scenario scenario) {
        this.scenario = scenario;
        Report.startTest(scenario.getName());
    }

    @Before("@First")
    public void start() {
        getDriver();
    }


    @After(value ="@Last", order=0)
    public void finish() {
        if(ProjectProperties.CLOSE_BROWSER) {
            DriverFactory.killDriver();
        }
        Report.close();
        FixReport.fixReport();
    }
}
