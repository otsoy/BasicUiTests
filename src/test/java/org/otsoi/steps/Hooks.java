package org.otsoi.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.otsoi.context.TestContext;
import org.otsoi.utils.ConfigReader;

public class Hooks extends BaseTestSteps {

    public Hooks(TestContext testContext, ConfigReader configReader){
        super(testContext, configReader);
    }
    @Before
    public void before() {
        super.beforeEach();
    }
    @After
    public void after() {
        super.afterEach();
    }
}
