package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".\\FeatureFiles\\bank.feature",glue="stepdefi9nitions")
public class TestRunner {

}


