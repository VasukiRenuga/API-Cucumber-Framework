package com.training.runner;




import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src\\test\\resources\\Simple.Feature"},
glue= {"com.training.steps"})

public class TestRunner extends AbstractTestNGCucumberTests {

}