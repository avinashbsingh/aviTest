package steps.api;


import com.fasterxml.jackson.databind.JsonNode;
import endpoints.EmpEndpoint;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;
import utils.*;

import java.io.IOException;


public class apiSteps {
    Report report = (Report) MasterData.getContext(Keys.REPORT);

    String endPointURL = null;
    Response response = null;
    JsonNode requestJsonNode = null;

    private String CREATEEMP = "src/main/resources/employee/createEmp.json";

    @And("^Employee Hit (GET|POST|PUT|DELETE) call$")
    public void HitGETCall(String method) {
        String baseURI = "http://dummy.restapiexample.com/";
        String request = MasterData.getContext(Keys.REQUEST) != null ? MasterData.getContext(Keys.REQUEST).toString() : "";
        response = ApiUtils.getGenericRequest(method, baseURI, endPointURL, request);
        MasterData.setContext(Keys.RESPONSE, response);
        report.reportlog("<b><i>Response Json<i><b>" + response.prettyPrint());
    }

    @Given("Employee Get endpoint URL as {string} with {string}")
    public void employeeGetEndpointURLAsWith(String endpoint, String arg) {
        switch (endpoint.toLowerCase()) {
            case "getemp":
                endPointURL = EmpEndpoint.EMP_GET;
                break;
            case "getempbyid":
                endPointURL = EmpEndpoint.EMPBYID_GET.replace("{id}", arg);
                break;

        }
    }

    @Then("Expect the Status Code as {string}")
    public void verifyTheStatusCodeAs(String statusCode) {
        response = (Response) MasterData.getContext(Keys.RESPONSE);
        Assert.assertEquals(response.getStatusCode() + "", statusCode);

    }

    @Given("Employee Create Request for {string} with {string} as {string}")
    public void employeeCreateRequestForWithAs(String endPoint, String attribute, String value) throws IOException {
        switch (endPoint.toLowerCase()) {
            case "createemp":
                requestJsonNode = JsonReader.readJsonFile(CREATEEMP);
                requestJsonNode = JsonReader.setJsonNodeValue(requestJsonNode,attribute,value);
                endPointURL = EmpEndpoint.EMPCREATE_POST;
                break;
        }
        MasterData.setContext(Keys.REQUEST, requestJsonNode);
        report.reportlog("<b><i>Request Json<i><b>" + requestJsonNode.toString());
    }
}

