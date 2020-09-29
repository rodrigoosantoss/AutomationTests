package core;

import org.junit.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.builder.*;


public class BaseTest implements Constants{
	
	@BeforeClass
	public static void setup() {
		
		/*
		 * Nestas primeiras linhas estao indicados o tipo de requisi��o a ser usado
		 */
		RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
		requestBuilder.setContentType(API_CONTENT_TYPE);
		RestAssured.requestSpecification = requestBuilder.build();
		
		/*
		 * Percebi que uma das boas pr�ticas � a aplica��o de timeOut para
		 * determinar o tempo m�ximo que o RestAssured ir� aguardar um response
		 */
		ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder();
		responseBuilder.expectResponseTime(Matchers.lessThan(MAX_TIME_OUT));
		RestAssured.requestSpecification = requestBuilder.build();
	}
}
