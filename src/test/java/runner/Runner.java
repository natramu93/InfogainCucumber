package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/features/Login.feature","src/test/resources/features/InvalidLogin.feature"}, 
glue="steps", 
dryRun=false,
plugin= {"html:Reports.html","json:report.json"},
monochrome=true,
tags="@s1 or @invalid")
public class Runner {

}
