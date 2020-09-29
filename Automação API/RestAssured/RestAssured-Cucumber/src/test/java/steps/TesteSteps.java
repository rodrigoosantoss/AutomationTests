package steps;

import objects.TesteObjects;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class TesteSteps extends TesteObjects {

    @Dado("que eu sei a marca do carro")
    public void queEuSeiAMarcaDoCarro() {
        marcaVeiculo();
    }

    @Dado("o modelo")
    public void oModelo() {
        modeloVeiculo();
    }

    @Dado("o ano do veículo")
    public void oAnoDoVeiculo() {
        anoVeiculo();
    }

    @Quando("eu realizar uma consulta")
    public void euRealizarUmaConsulta() {
        enviarPayload();
    }

    @Então("é possivel obter o seu atual valor de mercado")
    public void ePossivelObterOSeuAtualValorDeMercado() {
        validarResponse();
    }
}
