package core;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;

public class BaseTest implements IConstants {
    @BeforeClass
    public static void setup() {

        /*
         * The next 3 lines indicates the URL, BASE PATH and API PORT from the domain that will be tested
         * informed into the interface Contatans.java
         */

//        RestAssured.baseURI = API_BASEBO_URL;
//        RestAssured.basePath = API_BASE_PATH;
//        RestAssured.port = API_PORT;

        /*
         * The next 3 lines indicates the content type from the request.
         */
        RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
        requestBuilder.setContentType(API_CONTENT_TYPE);
        RestAssured.requestSpecification = requestBuilder.build();

        /*
         * The next 3 lines indicates the maximum time out that RestAssured should wait
         * for a response to be returned.
         */
        ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder();
        responseBuilder.expectResponseTime(Matchers.lessThan(MAX_TIME_OUT));
        RestAssured.requestSpecification = requestBuilder.build();
    }
}
