package org.otsoi.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/org/otsoi",
        glue={"org.otsoi.steps"},
        plugin = { "pretty", "html:target/cucumber-reports"},
        monochrome = true)
public class Runner {
}