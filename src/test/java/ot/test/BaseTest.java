package ot.test;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class BaseTest extends Helpers {


    @Test
    public void test_NumberOfCircuits_ShouldBe20_UsingResponseSpec() {


        given().log().all().
                param("id",4597).
                cookie(cookies).
                contentType("application/json").
                accept("application/json").
                when().
                get(person).
                then().assertThat().
                body(matchesJsonSchemaInClasspath("schemas/person")).log().all();

    }

}
