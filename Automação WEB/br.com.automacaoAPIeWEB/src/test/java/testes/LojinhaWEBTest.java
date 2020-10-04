package testes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LojinhaWEBTest {

    private WebDriver navegador;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "c://Drivers/chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.get("http://165.227.93.41/lojinha-web/");

        //Login com usuario adm e senha adm
        navegador.findElement(By.cssSelector("#usuario")).sendKeys("admin");
        navegador.findElement(By.id("senha")).sendKeys("admin");
        navegador.findElement(By.cssSelector(".btn")).click();
    }

    @Test
    public void testValidarDadosDeUmProduto(){
        //Acessar um produto PS4 na lista de produtos
        navegador.findElements(By.linkText("PS4")).get(0).click();

        //Validação do nome do produto e do nome do primeiro Componente
        String produtoNome = navegador.findElement(By.id("produtonome")).getAttribute("value");
        Assert.assertEquals("PS4", produtoNome);

        String componenteNome = navegador.findElements(By.cssSelector(".title")).get(0).getText();
        Assert.assertEquals("Lojinha controle", componenteNome);
    }

    @Test
    public void testAdicionarUmNovoProduto(){
        //clicar em adicionar novo produto
        navegador.findElement(By.linkText("ADICIONAR PRODUTO")).click();

        //preencher os dados do produto e salvar
        navegador.findElement(By.id("produtonome")).sendKeys("PS12");
        navegador.findElement(By.id("produtovalor")).sendKeys("30000");
        navegador.findElement(By.id("produtocores")).sendKeys("Branco, Preto");
        navegador.findElements(By.cssSelector(".btn")).get(0).click();

        //validar se a mensagem de produto adicionado foi informado
        String msgConfirmacao = navegador.findElement(By.cssSelector(".toast")).getText();
        Assert.assertEquals("Produto adicionado com sucesso", msgConfirmacao);

    }

    @After
    public void tearDown(){
        //fechar o navegador
        navegador.quit();
    }
}
