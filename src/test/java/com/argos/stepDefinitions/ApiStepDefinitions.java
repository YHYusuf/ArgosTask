package com.argos.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasItem;

public class ApiStepDefinitions {
    Response response;
    Long petId;


    @Given("the the user has logged in")
    public void the_the_user_has_logged_in() {
        given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().queryParam("username", "yusuf")
                .and().queryParam("password", "yusuf")
                .when().get("/user/login")
                .then().statusCode(200);

    }

    @When("the user posts a new pet")
    public void the_user_posts_a_new_pet() {
        String jsonBody = "{\n" +
                "        \"id\": 0,\n" +
                "        \"category\": {\n" +
                "            \"id\": 0,\n" +
                "            \"name\": \"string\"\n" +
                "        },\n" +
                "        \"name\": \"doggie\",\n" +
                "        \"photoUrls\": [\n" +
                "            \"string\"\n" +
                "        ],\n" +
                "        \"tags\": [\n" +
                "            {\n" +
                "                \"id\": 0,\n" +
                "                \"name\": \"string\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"status\": \"available\"\n" +
                "    }";
        response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(jsonBody)
                .when().post("/pet");
    }

    @Then("status code should be {int}, content type {string}")
    public void status_code_should_be_content_type(int statusCode, String format) {
        Assert.assertEquals(statusCode,response.statusCode());
        Assert.assertTrue(response.contentType().contains(format));
        petId=response.path("id");
        System.out.println(petId);
    }

    @Then("newly created pet should be under {string} pets")
    public void newly_created_pet_should_be_under_pets(String availability) {
        given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().queryParam("status",availability)
                .when().get("/pet/findByStatus")
                .then().assertThat().statusCode(200)
                .and().contentType(ContentType.JSON)
                .body("id",hasItem(petId));
//        l;kdsajf;lj
//                as;dlfjas;ldfj
//                'asdf;jl;ladskjf
//    asd;fljkas;ldfj
//    \sfad;ljkas;ldfj
//    saf'j

    }
}
