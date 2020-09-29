package pageObjects;

import core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

public class SimuladorInvestimentoPageObject extends BasePage {
    // Link de acesso a página principal
    String loginPage = "https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/";

    //Elementos de mapeamento da pagina
    By valida_pagina = By.xpath("//h2[@class='sessaoTitulo']");
    By perfil_pravc = By.xpath("//div[text()='Para você']");
    By perfil_praempresa = By.xpath("//div[text()='Para sua empresa ou agronegócio']");
    By campoValorAplicarID = By.id("valorAplicar");
    By campoValorAAplicar = By.xpath("//input[@id='valorAplicar']");
    By valorPouparMes = By.xpath("//input[@id='valorInvestir']");
    By qtoTempoQuerPoupar = By.xpath("//input[@id='tempo']");
    By seta = By.xpath("//span[@class='seta']");
    By setaMes = By.xpath("//a[contains(text(),'Meses')]");
    By setaAnos = By.xpath("//a[contains(text(),'Anos')]");
    By btnLimpar = By.xpath("//a[@class='btn btnLimpar']");
    By btnSimular = By.xpath("//form[@id='formInvestimento']//div//ul//li//button");
    By validaPagSimula = By.xpath("//div[@class='maisOpcoes']");
    By valorMinimoAplicarErro = By.xpath("//label[@id='valorAplicar-error']");
    By valorInvestirMinimoErro = By.xpath("//label[@id='valorInvestir-error']");
    By tempoError = By.xpath("//label[@id='tempo-error']");

    /*****************/
    //Valido se a página está no ar
    public void acessarPaginaSimulaInvestimento() {
        utils.goToUrl(loginPage);
    }

    //Valido se a página carregou
    public void validoSeAPaginaSimulaInvestimentoCarregou(String comportamento) {
        try {
            utils.waitElementIsVisible(valida_pagina, 30);
            String textoValidacao = utils.getText(valida_pagina);

            // transformando os dois erros separados por vírgula em uma lista
            List<String> erros = Arrays.asList(comportamento.split(","));
            erros.forEach(this::validarErros);

        } catch (Exception e) {
            utils.logFail("Não foi possivel validar a página de Investimento Sicredi");
            e.printStackTrace();
        }
    }

    private void validarErros(String comportamento) {
        if (comportamento.equalsIgnoreCase("ERRO - Valor Minimo")) {
            Assert.assertEquals("Valor mínimo de 20.00", utils.getText(valorMinimoAplicarErro));
        } else if (comportamento.equalsIgnoreCase("ERRO - Valor Minimo Poupar")) {
            Assert.assertEquals("Valor mínimo de 20.00", utils.getText(valorInvestirMinimoErro));
        } else if (comportamento.equalsIgnoreCase("ERRO - Valor Obrigatorio")) {
            Assert.assertEquals("Obrigatório", utils.getText(tempoError));
        } else {
            Assert.assertEquals("Simulador de Investimento - Poupança", utils.getText(valida_pagina));
        }
    }

    //valido perfil do investidor
    public void selecionarPerfil(String perfil) {
        By perfilSelecionado = null;
        switch (perfil) {
            case "voce":
                perfilSelecionado = perfil_pravc;
                break;
            case "empresa":
                perfilSelecionado = perfil_praempresa;
                break;
            default:
        }

        try {
            utils.clickAction(perfilSelecionado);
        } catch (Exception e) {
            utils.logFail("Não foi possivel validar a página de Investimento Sicredi");
            e.printStackTrace();
        }
    }

    public void clicarCampoQuerAplicar(String valorAAplicar) {
        utils.sendKeysJS(campoValorAplicarID, valorAAplicar);
    }

    public void clicarNoCampoQuerPoupar(String valorPorMes) {
        utils.sendKeysJS(valorPouparMes, valorPorMes);
    }

    public void clicarNoCampoQuantoTempo(String valor, String medida) {
        By medidaSelecionada = null;

        switch (medida) {
            case "mes":
                medidaSelecionada = setaMes;
            case "ano":
                medidaSelecionada = setaAnos;
            default:
        }

        try {
            utils.clickAction(medidaSelecionada);
        } catch (Exception e) {
            utils.logFail("Não foi possivel validar a página de Investimento Sicredi");
            e.printStackTrace();
        }

        String valorInserido = valor.equals("00") ? "" : valor;
        utils.sendKeysJS(qtoTempoQuerPoupar, valorInserido);
    }

    public void clicarBtn() {
        utils.clickAction(btnSimular);
    }
}