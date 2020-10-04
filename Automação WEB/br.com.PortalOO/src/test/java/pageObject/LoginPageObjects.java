package pageObject;


import com.aventstack.extentreports.Status;
import core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import util.Report;

import java.util.ArrayList;

public class LoginPageObjects extends BasePage {

    //TODO: Reminder => Change URL and Login before run tests

    // Link
    String loginPage = "https://conciliador-hg.auttar.com.br/AutenticadorWeb/";
    // Elementos
    By validacao_BemVindo = By.xpath("//p[contains(text(),'Bem-vindo ao Portal!')]");
    By validacao_MensagemLogin = By.xpath("//h1[contains(text(),'Faça seu login')]");
    By input_login = By.xpath("//input[@id='loginUsuario']");
    By input_senha = By.xpath("//input[@id='loginSenha']");
    By button_entrar = By.xpath("//button[@id='btnEntrar']");

    By frame_sessaoAtiva = By.xpath("//span[contains(text(),'Deslogar sessão ativa')]");
    By frame_btnSim = By.xpath("//button/span[text()='Sim']");

    By esqueciMinhaSenha = By.xpath("//a[text()='Esqueci minha senha']");

    /*******************************************************/

    public void acessarLoginPageAuttar() {
        try {
            utils.goToUrl(loginPage);
        } catch (Exception e) {
            utils.logFail("Não foi possível acessar a url informada.");
            e.printStackTrace();
        } finally {
            utils.logPass("Página acessada \"" + loginPage + "\" com sucesso.");
        }
    }

    public void validarLoginPageAuttar() {
        try {
            utils.waitElementIsVisible(validacao_BemVindo, 30);
            Assert.assertEquals("Bem-vindo ao Portal!", utils.getText(validacao_BemVindo));
        } catch (Exception e) {
            utils.logFail("Não foi possivel validar a página de Login do Portal.");
            e.printStackTrace();
        } finally {
            utils.logPass("Página de Login do Portal validada com sucesso!");
        }
    }

    public void preencherCampoUsuario(String param) {
        try {
            String email = "automacaoauttar+9999@gmail.com";

//            String login = "admin";
            String login = "bf97058";
            String login_oldsv = "testeautomacaoauttar";

            utils.waitElementIsVisible(input_login, 30);

            switch (param) {
                case "email":
                    utils.sendKeysJS(input_login, email);
                    break;
                case "Login":
                    utils.sendKeysJS(input_login, login);
                    break;

                default:
                    utils.logFail("Erro na parametrização de campo na tela de Login.");
            }
        } catch (Exception e) {
            utils.logFail("Erro ao preencher campo \'"+param+"\' na página de Login.");
            e.printStackTrace();
        }
    }

    public void clicarBotaoTelaLogin(String btnName) {
        switch (btnName) {
            case "Entrar":
                try {
                    utils.waitElementIsVisible(button_entrar, 30);
                    utils.clickButton(button_entrar);
                    //90: antes era isEnabled()
                    if (utils.isDisplayed(frame_sessaoAtiva)) {
                        utils.clickButton(frame_btnSim);
                    }
                } catch (NoSuchElementException | InterruptedException e) {
                    System.err.println("Já existe uma sessão ativa.\nInteragindo com o Modal de Sessão ativa.");
                    Report.log(Status.INFO, "Já existe uma sessão ativa.\nInteragindo com o Modal de Sessão ativa.");
                }
                break;
            case "Esqueci minha senha":
                try {
                    utils.waitElementIsVisible(esqueciMinhaSenha, 30);
                    utils.clickJS(esqueciMinhaSenha);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void inserirSenha() {
        try {
//            String senha = "meta@1234$";
            String senha = "0a306c18cccX*{}";
            utils.sendKeysJS(input_senha, senha);
        } catch (Exception e) {
            utils.logFail("Falhou a inserir senha no campo \"Senha\" na pagina de Login.");
            e.printStackTrace();
        }
    }

   /* public void validarRegistroLoginBancoDeDados() {
        try {
            // Conteúdo que será utilizado para efetuar consulta e validar a mesma

            System.out.println("Debug no método de acesso ao banco de dados.");

            String login = "bf97058";
            String message = "Logado Com Sucesso!!!";
            String event = "Autenticacao";
            String application = "Portal";
            String data_log = utils.localDate();

            /********************************************************************/

            /*ArrayList<ViewAccess> result = OracleDAO.selectAllFromTableWhere("view_access", "login", "bf97058");

            if (result == null) {
                System.out.println("\nConsulta não retornou nenhum resultado.");
            } else {
                System.out.println("\nConsulta retornou resultados.");
            }

            String[] dateToValidate;

            for (ViewAccess item : result) {

                //Print query content result
                System.out.println("\n" + item.toString() + "\n");

                //Modifica o formato da string que contém a data para que o formato seja compativel com a data de validação
                dateToValidate = item.getData_log().split(" ");

                if (dateToValidate[0].equals(data_log)) {

                    Assert.assertEquals(dateToValidate[0].replace("-", "/"), data_log);

                    Assert.assertEquals(item.getLogin(), login);
                    Assert.assertEquals(item.getMessage(), message);
                    Assert.assertEquals(item.getEvent(), event);
                    Assert.assertEquals(item.getApplication(), application);

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            utils.logFail("Não foi possível validar no banco de dados se existe registro de ação de Login.");
        }
    }
*/
        }


