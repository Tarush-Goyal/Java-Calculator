package com.example.springboot;

import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EquationIT {

    @LocalServerPort
    private int serverPort;

    @Test
    public void APITest() throws JSONException {

        JSONObject input = new JSONObject();
        input.put("equation", "a+b");
        JSONObject variables = new JSONObject();
        variables.put("a",1);
        variables.put("b",2);
        input.put("variables", variables);

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(input.toString())
                .log().all()
                .when()
                .get("http://localhost:"+serverPort+"/calserv/equation")
                .then()
                .assertThat().statusCode(200)
                .body("equation", equalTo("a+b"))
                .body("variables.a",equalTo(1f))
                .body("variables.b",equalTo(2f))
                .body("result", equalTo(3f))
                .log().all();
    }
}
