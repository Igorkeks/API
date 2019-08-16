package ot.test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class Helpers extends Links {

    public Cookie cookies;


    @BeforeTest
    public Helpers LoginCookeis() {

        JSONObject loginBody = new JSONObject();
        loginBody.put("username", "tytyschtt");
        loginBody.put("password", "1234");

        this.cookies = given().
                body(loginBody.toJSONString()).
                log().all().
                contentType("application/json").
                accept("application/json").
                baseUri(login).
                post().
                then().assertThat().
                extract().detailedCookie("connect.sid");
        System.out.println(cookies);

        return this;
    }






}