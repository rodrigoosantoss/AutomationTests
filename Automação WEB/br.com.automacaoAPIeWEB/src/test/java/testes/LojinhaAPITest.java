package testes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


public class LojinhaAPITest {
    private String token;

    @Before
    public void setUp() {

        RestAssured.baseURI = "http://165.227.93.41";
        RestAssured.basePath = "/lojinha";

        token = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"usuariologin\": \"rodrigo.caetano\",\n" +
                        "    \"usuariosenha\": \"123456\"\n" +
                        "}")
                .when()
                .post("login")
                .then()
                .extract()
                .path("data.token");
    }
    @Test
    public void testBuscarDadosDeUmProdutoEspecifico() {

        RestAssured
                .given()
                  .header("token", token)
                .when()
                    .get("produto/8268")
                .then()
                    .assertThat()
                        .statusCode(200)
                        .body("data.produtonome", Matchers.equalTo("RodrigoPS4"))
                        .body("data.componentes[0].componentenome", Matchers.equalTo("controle"))
                        .body("message", Matchers.equalTo("Detalhando dados do produto"));
    }

    @Test
    public void testValidarBuscaComponenteIdEComponenteQuantidade(){
        RestAssured
                .given()
                    .header("token", token)
                .when()
                    .get("produto")
                .then()
                    .assertThat()
                        .statusCode(200)
                        .body("data.componentes[0].componenteid", Matchers.contains(3251))
                        .body("data.componentes[0].componentequantidade", Matchers.contains(2));
    }

}
