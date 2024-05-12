package texoit.stepdefinitions;

import org.openqa.selenium.WebDriver;

import texoit.context.TestContext;

public class MyStepDefinitions {
    private final WebDriver driver;

    public MyStepDefinitions(TestContext context){
        driver = context.driver;
    }
}
