package pageSteps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.bson.assertions.Assertions;
import pageObjects.SimuladorInvestimentoPageObject;

public class SimuladorInvestimentoStepDefinitions {

    //instancio o objeto
    private SimuladorInvestimentoPageObject simuladorInvestimentoPageObject = new SimuladorInvestimentoPageObject();

    //determino que um cenário deve ser feito a antes dos demais testes
    @Before
    public void acessaPaginaInvestimento() {
        simuladorInvestimentoPageObject.acessarPaginaSimulaInvestimento();
    }

    @Given("que o usuário de perfil {string} quer aplicar {string} reais")
    public void que_o_usuario_perfil_quer_aplicar(String perfil, String valorAAplicar) {
        simuladorInvestimentoPageObject.selecionarPerfil(perfil);
        simuladorInvestimentoPageObject.clicarCampoQuerAplicar(valorAAplicar);
    }

    @And("quer aplicar {string} por mês")
    public void querAplicarValorPorMes(String aplicacaoPorMes) {
        simuladorInvestimentoPageObject.clicarNoCampoQuerPoupar(aplicacaoPorMes);
    }

    @And("quer aplicar por {string} durante {string}")
    public void querAplicarPorDurante(String valor, String medida) {
        simuladorInvestimentoPageObject.clicarNoCampoQuantoTempo(valor, medida);
    }

    @When("ele apertar o botão de simular")
    public void apertarOBotaoDeSimular() {
        simuladorInvestimentoPageObject.clicarBtn();
    }

    @Then("ele receberá a {string}")
    public void eleReceberaComportamento(String comportamentoEsperado) {
        simuladorInvestimentoPageObject.validoSeAPaginaSimulaInvestimentoCarregou(comportamentoEsperado);
    }
}