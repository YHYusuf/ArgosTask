package com.argos.stepDefinitions;

import com.argos.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.baseURI;


public class Hooks {
    @Before
    public void setup(){
        Driver.get().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();


    }
    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();

    }
    @Before("@api")
    public void setupApi(){
        baseURI = "https://petstore.swagger.io/v2";
    }

}
