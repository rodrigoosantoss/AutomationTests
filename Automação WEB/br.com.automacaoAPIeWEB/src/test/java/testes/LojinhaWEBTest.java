package testes;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LojinhaWEBTest {
    @Test
    public void testValidarDadosDeUmProduto(){
        //preparação
        System.setProperty("webdriver.chrome.driver", "c://Drivers/chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.get("http://165.227.93.41/lojinha-web/");

        //Login com usuario adm e senha adm
        navegador.findElement(By.cssSelector("#usuario")).sendKeys("admin");
        navegador.findElement(By.id("senha")).sendKeys("admin");
        navegador.findElement(By.cssSelector(".btn")).click();

        //Acessar um produto PS4 na lista de produtos

        //Validação do nome do produto e do nome do primeiro Componente

    }
}
