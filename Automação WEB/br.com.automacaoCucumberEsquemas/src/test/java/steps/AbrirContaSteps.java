package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbrirContaSteps {

    protected WebDriver driver;

    @Dado("^que estou acessando a aplicação$")
    public void que_estou_acessando_a_aplicação() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://srbarriga.herokuapp.com");
        driver.manage().window().maximize();
    }

    @Quando("^informo o usuário \"([^\"]*)\"$")
    public void informo_o_usuário(String arg1) throws Throwable {
        driver.findElement(By.id("email")).sendKeys(arg1);
    }

    @Quando("^a senha \"([^\"]*)\"$")
    public void a_senha(String arg1) throws Throwable {
        driver.findElement(By.name("senha")).sendKeys(arg1);
    }

    @Quando("^seleciono entrar$")
    public void seleciono_entrar() throws Throwable {
        driver.findElement(By.tagName("button")).click();
    }

    @Então("^visualizo a página inicial$")
    public void visualizo_a_página_inicial() throws Throwable {
        String bemVindo = driver.findElement(By.xpath("//div[contains(text(),'Bem vindo, rodrigocaetano!')]")).getText();
        Assert.assertEquals(bemVindo, "Bem vindo, rodrigocaetano!");
    }

    @Quando("^seleciono Contas$")
    public void seleciono_Contas() throws Throwable {
        driver.findElement(By.linkText("Contas")).click();
    }

    @Quando("^seleciono Adicionar$")
    public void seleciono_Adicionar() throws Throwable {
        driver.findElement(By.linkText("Adicionar")).click();
    }

    @Quando("^iinformo a conta (.*)$")
    public void iinformo_a_conta(String arg1) throws Throwable {
        driver.findElement(By.id("nome")).sendKeys(arg1);
    }

    @Quando("^seleciono Salvar$")
    public void seleciono_Salvar() throws Throwable {
        driver.findElement(By.tagName("button")).click();
    }

    @Então("^a conta é inserida com sucesso$")
    public void a_conta_é_inserida_com_sucesso() throws Throwable {
        String msgSucessoCadastro = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(msgSucessoCadastro, "Conta adicionada com sucesso!");
        driver.close();
    }

    @Quando("^informo a conta$")
    public void informo_a_conta(String arg1) throws Throwable {
        driver.findElement(By.id("nome")).sendKeys(arg1);
    }

    @Então("^sou notificado que o nome da conta é obrigatório$")
    public void vou_notificar_que_o_nome_da_conta_é_obrigatório() throws Throwable {
        String msgErroCampoEmBrancoInvalido = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals("Informe o nome da conta", msgErroCampoEmBrancoInvalido);
    }

    @Então("^recebo a mensagem (.*)$")
    public void receboAMensagem(String arg1) throws Throwable {
        String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-')]")).getText();
        Assert.assertEquals(arg1, texto);

    }

    @Before
    public void inicio(){
        System.out.println("Começando aqui");
    }

    @After
    public void fecharBrowser(){
        driver.quit();
        System.out.println("Terminando aqui");
    }

}
