package org.otsoi.steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.otsoi.context.TestContext;
import org.otsoi.enums.InputFieldActions;
import org.otsoi.pages.MainPage;
import org.otsoi.entities.Result;
import org.otsoi.utils.ConfigReader;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RandomIntegerSteps extends BaseTestSteps {

    private final int MIN_DEFAULT_VALUE = 1;
    private final int MAX_DEFAULT_VALUE = 100;
    private MainPage mainPage;
    private int min = MIN_DEFAULT_VALUE;
    private int max = MAX_DEFAULT_VALUE;

    public RandomIntegerSteps(TestContext testContext,
                              ConfigReader configReader){
       super(testContext, configReader);
    }

    @Given("the user is on the Main page")
    public void userIsOnTheMainPage(){
        String url =this.configReader.getApplicationUrl();
        this.getDriver().get(this.configReader.getApplicationUrl());
        mainPage = new MainPage(getDriver());
    }

    @When("user sets {string} in Min field")
    public void userSetsInMinField(String minValue) {
        mainPage.setMinValue(minValue);
        try{
            min = Integer.parseInt(minValue);
        }
        catch(NumberFormatException ignored){}

    }

    @And("user sets {string} in Max field")
    public void userSetsInMaxField(String maxValue) {
        mainPage.setMaxValue(maxValue);
        try{
            max = Integer.parseInt(maxValue);
        }
        catch(NumberFormatException ignored){}
    }

    @And("user presses <Generate> button")
    public void userPressesGenerateButton() {
        mainPage.pressGenerate();
    }

    @Then("random value is generated in chosen range")
    public void randomValueIsGeneratedInChosenRange() {
        Result result = mainPage.getResult();
        assertTrue( String.format("Result value %d is outside the range ( %d, %d)", result.value(), min, max),
                result.value() <= max && result.value() >= min);
    }

    @And("min value is correct in Result section")
    public void minValueIsCorrectInResultSection() {
        Result result = mainPage.getResult();
        assertEquals(min, result.minValue());
    }

    @And("max value is correct in Result section")
    public void maxValueIsCorrectInResultSection() {
        Result result = mainPage.getResult();
        assertEquals(max, result.maxValue());
    }

    @And("min value has default value in input field")
    public void minValueHasDefaultValueInInputField() {
        assertEquals(MIN_DEFAULT_VALUE + "", mainPage.getInputMinValue());
    }

    @And("max value has default value in input field")
    public void maxValueHasDefaultValueInInputField() {
        assertEquals(MAX_DEFAULT_VALUE + "", mainPage.getInputMaxValue());
    }

    @And("min value has {string} value in input field")
    public void minValueHasDefaultValueInInputField(String value) {
        assertEquals(value, mainPage.getInputMinValue());
    }

    @And("max value has {string} value in input field")
    public void maxValueHasDefaultValueInInputField(String value) {
        assertEquals(value, mainPage.getInputMaxValue());
    }

    @And("max value is updated in Result section")
    public void maxValueIsUpdatedInResultSection() {
        max = min + 1;
        Result result = mainPage.getResult();
        assertEquals(max, result.maxValue());
    }

    @Then("error text is {string}")
    public void errorTextIs(String errorText) {
        assertEquals(errorText, mainPage.getErrorText());
    }

    @And("user refreshes browser page")
    public void userRefreshesBrowserPage() {
        this.getDriver().navigate().refresh();
        mainPage = new MainPage(this.getDriver());
    }

    @And("user presses {string} in Min field <number> times")
    public void userPressesInMinFieldNumberTimes(String arg0) {
    }

    @And("user presses {string} in Min field {int} times")
    public void userPressesInMin(String action, int numberOfTimes) {
        IntStream.rangeClosed(1, numberOfTimes)
                .forEach(i -> mainPage.pressKeyInMin(InputFieldActions.valueOf(action)));
    }

    @And("user presses {string} in Max field {int} times")
    public void userPressesInMax(String action, int numberOfTimes) {
        IntStream.rangeClosed(1, numberOfTimes)
                .forEach(i -> mainPage.pressKeyInMax(InputFieldActions.valueOf(action)));
    }
}
