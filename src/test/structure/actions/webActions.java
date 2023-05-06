package src.test.structure.actions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.testng.Assert;
import src.test.structure.objects.webObjects;
import src.test.structure.utils.testDataReader;

import java.util.Objects;

import static java.lang.String.valueOf;
import static src.test.structure.utils.WebFactory.*;


public class webActions {
    /**
     * Method to click element by xpath
     * @param buttonType name
     */
    public static void clickButtonWebByXpath(String buttonType) {
        try {
            switch (buttonType) {
                case "SINGLE_USER" -> findElementByXpathAndClick(webObjects.singleUsers);
                case "LIST_USER" -> findElementByXpathAndClick(webObjects.listUser);
                case "SINGLE_USER_NOT_FOUND" -> findElementByXpathAndClick(webObjects.singleUserNotFound);
                case "CREATE_USER" -> findElementByXpathAndClick(webObjects.createUser);
                case "REGISTER_USER" -> findElementByXpathAndClick(webObjects.registerUser);
                case "UPDATE_USER" -> findElementByXpathAndClick(webObjects.updateUser);
                default ->
                        throw new AssertionError("No Button with name ---" + buttonType + "------- Exist in in this page");
            }
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("clickButtonWebByXpath failed " + e);
        }
    }

    /**
     * Scroll element
     * @param apiName name
     */
    public static void scrollToElement(String apiName)  {
        try{
        boolean elementState = false;
            switch (apiName) {
                case "SINGLE_USER" -> {
                    elementState = scrollDownTillXpathVisible(webObjects.singleUsers);
                    System.out.println("elementState--" + elementState);
                    Assert.assertTrue(elementState, " ---Page not scrolled--- ");
                }
                case "LIST_USER" -> {
                    elementState = scrollDownTillXpathVisible(webObjects.listUser);
                    System.out.println("elementState--" + elementState);
                    Assert.assertTrue(elementState, " ---Page not scrolled--- ");
                }
                case "SINGLE_USER_NOT_FOUND" -> {
                    elementState = scrollDownTillXpathVisible(webObjects.singleUserNotFound);
                    System.out.println("elementState--" + elementState);
                    Assert.assertTrue(elementState, " ---Page not scrolled--- ");
                }
                case "CREATE_USER" -> {
                    elementState = scrollDownTillXpathVisible(webObjects.createUser);
                    System.out.println("elementState--" + elementState);
                    Assert.assertTrue(elementState, " ---Page not  scrolled--- ");
                }
                case "REGISTER_USER" -> {
                    elementState = scrollDownTillXpathVisible(webObjects.registerUser);
                    System.out.println("elementState--" + elementState);
                    Assert.assertTrue(elementState, " ---Page not  scrolled--- ");
                }
                case "UPDATE_USER" -> {
                    elementState = scrollDownTillXpathVisible(webObjects.updateUser);
                    System.out.println("elementState--" + elementState);
                    Assert.assertTrue(elementState, " ---Page not  scrolled--- ");
                }
                default ->
                        throw new AssertionError("No element with name ---" + apiName + "------- Exist in in this page");
            }
    } catch (Exception e) {
        System.out.println("scrollToElement failed " + e);
    }
    }

    /**
     * Launch URL
     */
    public static void navigateToUrl() throws Exception {
        launchUrl();
    }

    /**
     * Method to compare sample request data
     *
     * @param apiName name
     * @param availability should present or not
     */
    public static void verifySampleRequestData(String apiName, String availability)  {
        try {
            boolean visibleCheck = false;
            Thread.sleep(2000);
            visibleCheck = isElementDisplayedByXPATH(webObjects.outPutRequest);
            System.out.println("Request data ---Expected--" + availability + ". Actual is: " + visibleCheck);
            if (visibleCheck && availability.equals("VISIBLE")) {
                String emailRequest = null;
                String passwordRequest = null;
                String nameRequest = null;
                String jobRequest = null;
                String expectedFirstName = null;
                String expectedPassword = null;
                String expectedEmail = null;
                String expectedJob = null;
                JSONObject data;
                data = Objects.requireNonNull(testDataReader.testData()).getJSONObject("data");
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode2 = objectMapper.readTree(valueOf(data));
                if (apiName.equalsIgnoreCase("REGISTER_USER")) {
                    emailRequest = valueOf(getOutRequestJson().get("email")).replaceAll("\"", "");
                    passwordRequest = valueOf(getOutRequestJson().get("password")).replaceAll("\"", "");
                    expectedEmail = valueOf(jsonNode2.get("register_user").get("RequestData").get("email")).replaceAll("\"", "");
                    expectedPassword = valueOf(jsonNode2.get("register_user").get("RequestData").get("password")).replaceAll("\"", "");
                    System.out.println("Request data----  Expected email: " + expectedEmail + ". Actual: " + emailRequest);
                    System.out.println("Request data----  Expected password : " + expectedPassword + ". Actual: " + passwordRequest);
                    if (emailRequest.equalsIgnoreCase(expectedEmail) && passwordRequest.equalsIgnoreCase(expectedPassword)) {
                        Assert.assertTrue(visibleCheck, "Sample request data is visible..! Data validated..!");
                    } else {
                        Assert.fail("Request data found. but unable to match the data");
                    }
                } else if (apiName.equalsIgnoreCase("CREATE_USER")) {
                    nameRequest = valueOf(getOutRequestJson().get("name")).replaceAll("\"", "");
                    jobRequest = valueOf(getOutRequestJson().get("job")).replaceAll("\"", "");
                    expectedFirstName = valueOf(jsonNode2.get("create").get("RequestData").get("name")).replaceAll("\"", "");
                    expectedJob = valueOf(jsonNode2.get("create").get("RequestData").get("job")).replaceAll("\"", "");
                    System.out.println("Request data----  Expected name: " + expectedFirstName + ". Actual: " + nameRequest);
                    System.out.println("Request data----  Expected job : " + expectedJob + ". Actual: " + jobRequest);
                } else if (apiName.equalsIgnoreCase("UPDATE_USER")) {
                    nameRequest = valueOf(getOutRequestJson().get("name")).replaceAll("\"", "");
                    jobRequest = valueOf(getOutRequestJson().get("job")).replaceAll("\"", "");
                    expectedFirstName = valueOf(jsonNode2.get("update_user").get("RequestData").get("name")).replaceAll("\"", "");
                    expectedJob = valueOf(jsonNode2.get("update_user").get("RequestData").get("job")).replaceAll("\"", "");
                    System.out.println("Request data----  Expected name: " + expectedFirstName + ". Actual: " + nameRequest);
                    System.out.println("Request data----  Expected job : " + expectedJob + ". Actual: " + jobRequest);
                    if ((nameRequest.equalsIgnoreCase(expectedFirstName) && jobRequest.equalsIgnoreCase(expectedJob))) {
                        Assert.assertTrue(visibleCheck, "Sample request data is visible..! Data validated..!");
                    } else {
                        Assert.fail("Request data found. but unable to match the data");
                    }
                }
            } else if (!visibleCheck && availability.equals("NOT_VISIBLE")) {
                Assert.assertTrue(true, "Sample request data is not visible. Test pass");
            } else {
                Assert.fail();
            }
        } catch (Exception e) {
            System.out.println("verifySampleRequestData failed: " + e);
        }
    }

    /**
     * Method to compare response code
     *
     * @param apiName name
     */
    public static void verifyResponseCode(String apiName) {
        try {
            JSONObject data = Objects.requireNonNull(testDataReader.testData()).getJSONObject("data");
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode2 = objectMapper.readTree(valueOf(data));
            String expectedResponseCode = null;
            String actualResponseCode = null;
            if (isElementDisplayedByXPATH(webObjects.goodResponse)) {
                actualResponseCode = getGoodResponseCode();
            } else if (isElementDisplayedByXPATH(webObjects.badResponse)) {
                actualResponseCode = getOtherResponseCode();
            }
            switch (apiName) {
                case "SINGLE_USER" -> {
                    expectedResponseCode = valueOf(jsonNode2.get("single_user").get("Response"));
                    System.out.println("Expected ResponseCode : " + expectedResponseCode);
                    System.out.println("Actual ResponseCode : " + actualResponseCode);
                    Assert.assertTrue(expectedResponseCode.equalsIgnoreCase(actualResponseCode), "ResponseCode verified");
                }
                case "LIST_USER" -> {
                    expectedResponseCode = valueOf(jsonNode2.get("list_user").get("Response"));
                    System.out.println("expectedResponseCode : " + expectedResponseCode);
                    System.out.println("actualResponseCode : " + actualResponseCode);
                    Assert.assertTrue(expectedResponseCode.equalsIgnoreCase(actualResponseCode), "ResponseCode verified for " + apiName);
                }
                case "SINGLE_USER_NOT_FOUND" -> {
                    expectedResponseCode = valueOf(jsonNode2.get("single_user_not_Found").get("Response"));
                    System.out.println("expectedResponseCode : " + expectedResponseCode);
                    System.out.println("actualResponseCode : " + actualResponseCode);
                    Assert.assertTrue(expectedResponseCode.equalsIgnoreCase(actualResponseCode), "ResponseCode verified for " + apiName);
                }
                case "CREATE_USER" -> {
                    expectedResponseCode = valueOf(jsonNode2.get("create").get("Response"));
                    System.out.println("expectedResponseCode : " + expectedResponseCode);
                    System.out.println("actualResponseCode : " + actualResponseCode);
                    Assert.assertTrue(expectedResponseCode.equalsIgnoreCase(actualResponseCode), "ResponseCode verified for " + apiName);
                }
                case "REGISTER_USER" -> {
                    expectedResponseCode = valueOf(jsonNode2.get("register_user").get("Response"));
                    System.out.println("expectedResponseCode : " + expectedResponseCode);
                    System.out.println("actualResponseCode : " + actualResponseCode);
                    Assert.assertTrue(expectedResponseCode.equalsIgnoreCase(actualResponseCode), "ResponseCode verified for " + apiName);
                }
                case "UPDATE_USER" -> {
                    expectedResponseCode = valueOf(jsonNode2.get("update_user").get("Response"));
                    System.out.println("expectedResponseCode : " + expectedResponseCode);
                    System.out.println("actualResponseCode : " + actualResponseCode);
                    Assert.assertTrue(expectedResponseCode.equalsIgnoreCase(actualResponseCode), "ResponseCode verified for " + apiName);
                }
                default -> throw new AssertionError("No API present with this name!");
            }
        } catch (Exception e) {
            System.out.println("verifyResponseCode failed: " + e);
        }

    }

    /**
     * Method to compare the endpoint
     *
     * @param apiName name
     */
    public static void verifyURLPath(String apiName) {
        try {
            JSONObject data = Objects.requireNonNull(testDataReader.testData()).getJSONObject("data");
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode2;
            jsonNode2 = objectMapper.readTree(valueOf(data));
            String expectedRequestURL = null;
            String actualurl = null;
            actualurl = getRequestURL();
            switch (apiName) {
                case "SINGLE_USER" -> {
                    expectedRequestURL = valueOf(jsonNode2.get("single_user").get("requestURL")).replaceAll("\"", "");
                    System.out.println("Expected URL Path : " + expectedRequestURL);
                    System.out.println("Actual URL path : " + actualurl);
                    Assert.assertTrue(expectedRequestURL.equalsIgnoreCase(actualurl), "URL verified");
                }
                case "LIST_USER" -> {
                    expectedRequestURL = valueOf(jsonNode2.get("list_user").get("requestURL")).replaceAll("\"", "");
                    System.out.println("Expected URL Path : " + expectedRequestURL);
                    System.out.println("Actual URL path : " + actualurl);
                    Assert.assertTrue(expectedRequestURL.equalsIgnoreCase(actualurl), "URL verified");
                }
                case "SINGLE_USER_NOT_FOUND" -> {
                    expectedRequestURL = valueOf(jsonNode2.get("single_user_not_Found").get("requestURL")).replaceAll("\"", "");
                    System.out.println("Expected URL Path : " + expectedRequestURL);
                    System.out.println("Actual URL path : " + actualurl);
                    Assert.assertTrue(expectedRequestURL.equalsIgnoreCase(actualurl), "URL verified");
                }
                case "CREATE_USER" -> {
                    expectedRequestURL = valueOf(jsonNode2.get("create").get("requestURL")).replaceAll("\"", "");
                    System.out.println("Expected URL Path : " + expectedRequestURL);
                    System.out.println("Actual URL path : " + actualurl);
                    Assert.assertTrue(expectedRequestURL.equalsIgnoreCase(actualurl), "URL verified");
                }
                case "REGISTER_USER" -> {
                    expectedRequestURL = valueOf(jsonNode2.get("register_user").get("requestURL")).replaceAll("\"", "");
                    System.out.println("Expected URL Path : " + expectedRequestURL);
                    System.out.println("Actual URL path : " + actualurl);
                    Assert.assertTrue(expectedRequestURL.equalsIgnoreCase(actualurl), "URL verified");
                }
                case "UPDATE_USER" -> {
                    expectedRequestURL = valueOf(jsonNode2.get("update_user").get("requestURL")).replaceAll("\"", "");
                    System.out.println("Expected URL Path : " + expectedRequestURL);
                    System.out.println("Actual URL path : " + actualurl);
                    Assert.assertTrue(expectedRequestURL.equalsIgnoreCase(actualurl), "URL verified");
                }
                default -> throw new AssertionError("No API present with this name!");
            }
        } catch (Exception e) {
            System.out.println("verifyURLPath failed: " + e);
        }
    }

    /**
     * VerifyOutputDataWithJson
     * @param apiName name
     */
    public static void verifyOutputData(String apiName) {
        try {
            JSONObject data = Objects.requireNonNull(testDataReader.testData()).getJSONObject("data");
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode2 = objectMapper.readTree(valueOf(data));
            String expectedLastName = null;
            String expectedEmail = null;
            String expectedFirstName = null;
            String uiFirstName = null;
            String uiLastName = null;
            String uiEmail = null;
            String expectedJob = null;
            String uiJob = null;
            switch (apiName) {
                case "SINGLE_USER":
                    expectedFirstName = valueOf(jsonNode2.get("single_user").get("ResponseData").get("data").get(0).get("data").get("first_name")).replaceAll("\"", "");
                    expectedLastName = valueOf(jsonNode2.get("single_user").get("ResponseData").get("data").get(0).get("data").get("last_name")).replaceAll("\"", "");
                    expectedEmail = valueOf(jsonNode2.get("single_user").get("ResponseData").get("data").get(0).get("data").get("email")).replaceAll("\"", "");
                    uiFirstName = getOutPutJson().get("data").get("first_name").asText();
                    uiLastName = getOutPutJson().get("data").get("last_name").asText();
                    uiEmail = getOutPutJson().get("data").get("email").asText();
                    System.out.println("First name-- Expected: " + expectedFirstName + ". Actual : " + uiFirstName);
                    System.out.println("Last name -- Expected: " + expectedLastName + ". Actual : " + uiLastName);
                    System.out.println("Email -- Expected : " + expectedEmail + ". Actual : " + uiEmail);
                    if (expectedEmail.equalsIgnoreCase(uiFirstName) && expectedLastName.equalsIgnoreCase(uiLastName) && expectedEmail.equalsIgnoreCase(uiEmail)) {
                        Assert.assertTrue(expectedEmail.equalsIgnoreCase(uiFirstName) && expectedLastName.equalsIgnoreCase(uiLastName) && expectedEmail.equalsIgnoreCase(uiEmail), "Data verified");
                    }
                    break;
                case "LIST_USER":
//                expectedResponseData = String.valueOf(jsonNode2.get("list_user").get("ResponseData"));
//                System.out.println("Expected response data : " + expectedResponseData);

                    break;
                case "SINGLE_USER_NOT_FOUND":
                    if (getOutPutJson().isEmpty() || getOutPutJson().size() == 0) {
                        Assert.assertTrue(true, "No data found. As expected..!");
                    } else {
                        Assert.fail();
                    }
                    break;
                case "CREATE_USER":
                    expectedFirstName = valueOf(jsonNode2.get("create").get("ResponseData").get("name")).replaceAll("\"", "");
                    expectedJob = valueOf(jsonNode2.get("create").get("ResponseData").get("job")).replaceAll("\"", "");
                    uiFirstName = valueOf(getOutPutJson().get("name")).replaceAll("\"", "");
                    uiJob = valueOf(getOutPutJson().get("job")).replaceAll("\"", "");
                    System.out.println("Name-- Expected: " + expectedFirstName + ". Actual : " + uiFirstName);
                    System.out.println("Job-- Expected: " + expectedJob + ". Actual : " + uiJob);
                    if (expectedFirstName.equalsIgnoreCase(uiFirstName) && expectedJob.equalsIgnoreCase(uiJob)) {
                        Assert.assertTrue(expectedFirstName.equalsIgnoreCase(uiFirstName) && expectedJob.equalsIgnoreCase(uiJob), "Data verified");
                    }
                    break;
                case "REGISTER_USER":
//                expectedResponseData = String.valueOf(jsonNode2.get("register_user").get("ResponseData"));
//                System.out.println("Expected response data : " + expectedResponseData);


                    break;
                case "UPDATE_USER":
//                expectedResponseData = String.valueOf(jsonNode2.get("update_user").get("ResponseData"));
//                System.out.println("Expected response data : " + expectedResponseData);
                    break;
                default:
                    throw new AssertionError("No API present with this name!");
            }
        } catch (Exception e) {
            System.out.println("verifyOutputData failed: " + e);
        }
    }


    /**
     * @return Methof to read UI response
     */
    public static JsonNode getOutPutJson() throws InterruptedException, JsonProcessingException {
        String outputUI = getJsonFromOutPut();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(outputUI);
    }

    /**
     *
     * @return json
     */
    public static JsonNode getOutRequestJson() throws InterruptedException, JsonProcessingException {
        String requestUI = getJsonRequest();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(requestUI);
    }
}





