package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.restassured.module.jsv.JsonSchemaValidator;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class BaseSteps {
    @And("verify json schema {string}")
    public void verifyJsonSchema(String jsonSchemaFilePath) {
        restAssuredThat(response -> response.body(JsonSchemaValidator.matchesJsonSchemaInClasspath(jsonSchemaFilePath)));
    }
}
