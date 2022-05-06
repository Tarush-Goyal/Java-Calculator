package com.example.springboot;

import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class AddAPITest {
    @Test
    public void APITest() throws JSONException {

        JSONObject data = new JSONObject();

//        data.put("operation", "addition");
        data.put("num1", "3");
        data.put("num2", "4");
//        data.put("result", "7");


        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(data.toString())
                .log().all()
                .when()
                .get("http://localhost:8080/calserv/add")
                .then()
                .assertThat().statusCode(200)
                .body("operation", equalTo("addition"))
                .body("num1", equalTo(3f))
                .body("num2", equalTo(4f))
                .body("result", equalTo(7f))
                .log().all();
    }
}
