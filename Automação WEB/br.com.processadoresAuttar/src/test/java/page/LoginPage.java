package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import steps.LogarEAcessarEdi;

public class LoginPage extends RootPage {


    WebDriver driver;
    WebElement campoLogin = driver.findElement(By.xpath("//input[@id='loginUsuario']"));


    public LoginPage(WebDriver driver){
        driver = this.driver;
    }


}
