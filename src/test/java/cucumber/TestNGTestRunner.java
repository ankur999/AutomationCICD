package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",
glue="ankurgoyal.stepdefination",
monochrome=true,
tags= "@Regression",
plugin= {"html:target/cumcumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	
	

}
