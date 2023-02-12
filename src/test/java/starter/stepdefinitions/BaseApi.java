package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.restassured.module.jsv.JsonSchemaValidator;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class BaseApi {
    public final String BASE_URI="https://waarkoop-server.herokuapp.com";
    public final String API ="/api";
    public final String VERSION = "/v1";

}
