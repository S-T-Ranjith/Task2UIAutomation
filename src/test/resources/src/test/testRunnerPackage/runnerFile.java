package src.test.testRunnerPackage;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/UiTest.feature"}, glue = "src/test/structure/steps",
        plugin = {"pretty", "html:target/Cucumberreport.html"}, monochrome = true)
public class runnerFile {

}
