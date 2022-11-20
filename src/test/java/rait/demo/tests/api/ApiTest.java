package rait.demo.tests.api;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import rait.demo.data.TestData;
import rait.demo.utils.Utils;
import static org.junit.jupiter.api.Assertions.*;

import static io.restassured.RestAssured.*;

public class ApiTest {

    @Test
    public void apiTest(){
        Response r = given().when().get(Utils.getAPIUrl());
        assertTrue(r.body().asString().contains(TestData.CITY_NAME));
    }

}
