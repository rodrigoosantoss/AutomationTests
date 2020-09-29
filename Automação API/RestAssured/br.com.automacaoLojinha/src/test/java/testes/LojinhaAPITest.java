package testes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class LojinhaAPITest {
    private String token;

    @Before
    public void setUp(){

        RestAssured.baseURI = "http://165.227.93.41";
        RestAssured.basePath = "/lojinha";

        token = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"usuariologin\": \"elvercioneto\",\n" +
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
        RestAssured.baseURI = "http://165.227.93.41";
        RestAssured.basePath = "/lojinha";

        RestAssured
                .given()
                    .header("token", token)
                .when()
                    .get("produto/8097")
                .then()
                    .assertThat()
                        .statusCode(200)
                        .body("data.produtonome", Matchers.equalTo("XBox360"))
                        .body("data.componentes[0].componentenome", Matchers.equalTo("Controle"))
                        .body("message", Matchers.equalTo("Detalhando dados do produto"));
    }
    @Test
    public void testBuscarDadosDeUmComponenteDeProduto() {
        RestAssured
                .given()
                    .header("token", token)
                .when()
                    .get("produto/8097/componente/3094")
                .then()
                    .assertThat()
                        .statusCode(200)
                         .body("data.componentenome", Matchers.equalTo("Kinect"))
                         .body("data.componentequantidade", Matchers.equalTo(1))
                         .body("message", Matchers.equalTo("Detalhando dados do componente de produto"));
    }

}