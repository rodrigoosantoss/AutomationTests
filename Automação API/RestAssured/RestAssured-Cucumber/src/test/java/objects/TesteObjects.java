package objects;

import core.BaseTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class TesteObjects extends BaseTest {

    //Parametros endPoint a formatação de como sairá o resultado

    private Response response;
    private String endpoint;

    /***********************************************/

    public void marcaVeiculo(){
        endpoint = "/carros/marcas/23";
    }

    public void modeloVeiculo(){
        endpoint += "/modelos/5635";
    }

    public void anoVeiculo(){
        endpoint += "/anos/2016-1";
    }

    public void enviarPayload(){
            response = given().when().get("https://parallelum.com.br/fipe/api/v1"+endpoint);
    }

    public void validarResponse(){
        ExtractableResponse json = response.then()
                .statusCode(200)
                .assertThat()
                .body("Modelo", Matchers.equalTo("CRUZE LT 1.8 16V FlexPower 4p Aut."))
                .and()
                .body("AnoModelo", Matchers.equalTo(2016))
                .and()
                .body("Marca", Matchers.equalTo("GM - Chevrolet"))
                .extract();

        Map<String, Object> map = json.body().as(HashMap.class);

        for (Map.Entry<String, Object> item : map.entrySet()){
        	System.out.println("----------------------------------------");
            System.out.println("["+item.getKey()+"] --> "+ item.getValue());
        }
        	System.out.println("---------FIM PESQUISA ----------------");
        	System.out.println("");
    }

}
