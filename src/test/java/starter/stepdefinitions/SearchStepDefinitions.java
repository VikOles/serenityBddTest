package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class SearchStepDefinitions extends BaseApi{
    private String searchUri = BASE_URI+API+VERSION+"/search/demo";

    public Response response;


    @When("he calls endpoint {string}")
    public void heCallsEndpoint(String searchWord) {
        SerenityRest
                .given()
                .baseUri(searchUri)
                .basePath("/"+searchWord)
                .get();
    }

    @Then("he sees the results displayed for apple")
    public void heSeesTheResultsDisplayedForApple() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Then("he sees the results displayed for {string}")
    public void heSeesTheResultsDisplayedForMango(String searchWord) {
        restAssuredThat(response -> response.body("title", hasItem(containsStringIgnoringCase(searchWord))));
    }


    @Then("he does not see the results")
    public void heDoesNotSeeThe_Results() {
        restAssuredThat(response -> response.body("detail.error",equalTo(true)));

    }
}
