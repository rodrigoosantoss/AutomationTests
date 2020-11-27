package steps;

import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.RootPage;

import java.util.concurrent.TimeUnit;

public class LogarEAcessarEdi extends RootPage {
    protected WebDriver driver;

    @Dado("^que acessei site Auttar conciliador-dev\\.auttar$")
    public void queAcesseiSiteAuttarConciliadorDevAuttar() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://conciliador-dev.auttar.com.br/AutenticadorWeb/login.jsf");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Dado("^informo o usuario \"([^\"]*)\"$")
    public void informoOUsuario(String arg1) throws Throwable {
        driver.findElement(By.xpath("//input[@id='loginUsuario']")).sendKeys(arg1);}

    @Dado("^senha \"([^\"]*)\"$")
    public void senha(String arg1) throws Throwable {
        driver.findElement(By.xpath("//input[@id='loginSenha']")).sendKeys(arg1);
    }

    @E("^clico no botão entrar$")
    public void clicoNoBotãoEntrar() throws Throwable {
        driver.findElement(By.xpath("//span[normalize-space()='Entrar']")).click();
    }

    @Dado("^clico no menu \"([^\"]*)\"$")
    public void clicoNoMenu(String arg1) throws Throwable {

        clicar(driver, driver.findElement(By.xpath("//a[text()='OK']")));
        clicar(driver, driver.findElement(By.xpath("(//span[text() = 'CONCILIADOR'])[1]")));

        String msgBoasVindasConciliador = obterTexto(driver, driver.findElement(By.xpath("//h1[text()='Seja bem vindo(a) ao Conciliador']")));

        Assert.assertEquals("Seja bem vindo(a) ao Conciliador", msgBoasVindasConciliador);
    }


//    @After(order=0)
//    public void fecharBrowser(){
//        driver.quit();
//        System.out.println("Terminando aqui");
//    }
}
