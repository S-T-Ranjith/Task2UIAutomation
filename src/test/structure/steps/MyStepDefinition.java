package src.test.structure.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import src.test.structure.actions.webActions;

public class MyStepDefinition {

    @Given("User navigate to home page")
    public void userNavigateToHomePage() throws Exception {
        webActions.navigateToUrl();
    }

    @Then("User scroll down to {string}")
    public void userScrollDownTo(String apiName) {
        webActions.scrollToElement(apiName);
    }

    @And("User click the {string} endpoint")
    public void userClickTheEndpoint(String endPoint)  {
        webActions.clickButtonWebByXpath(endPoint);
    }

    @And("User verifies the {string} request data is {string}")
    public void userVerifiesTheRequestDataIs(String apiName, String availability)  {
        webActions.verifySampleRequestData(apiName, availability);
    }

    @And("User verifies the output data for {string}")
    public void userVerifiesTheOutputDataFor(String apiName) throws Exception {
        Thread.sleep(2000);
        webActions.verifyOutputData(apiName);
    }

    @And("User verifies the response code for {string}")
    public void userVerifiesTheResponseCodeFor(String apiName) throws Exception {
        Thread.sleep(2000);
        webActions.verifyResponseCode(apiName);
    }

    @And("User verifies the request path for {string}")
    public void userVerifiedTheRequestPathFor(String apiName) throws InterruptedException, JsonProcessingException {
        Thread.sleep(2000);
        webActions.verifyURLPath(apiName);
    }
}
