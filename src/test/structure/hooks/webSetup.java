package src.test.structure.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;

public class webSetup {

    @Before()
    public void setUpWeb() throws MalformedURLException {
        WebInitializer.webDriver = WebInitializer.launchWeb();
        System.out.println("Successfully Launched Web Driver");
    }

    @After()
    public void tearDownWeb()
    {
        WebInitializer.webDriver.quit();
        System.out.println("Successfully Ended Web Driver");
    }
}

