package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"classpath:steps"},
        plugin = {"pretty", "html:target/report-html"},
        tags = "~@ignore",
        snippets = SnippetType.CAMELCASE)


public class MainTest {

    @BeforeClass
    public static void reset(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://srbarriga.herokuapp.com");
        driver.findElement(By.id("email")).sendKeys("rodrigo@terra.com.br");
        driver.findElement(By.name("senha")).sendKeys("rodrigo");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("reset")).click();
        driver.quit();


    }

}
