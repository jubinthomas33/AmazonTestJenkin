import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class AmazonTestJenkins {
	WebDriver driver;

	@Parameters("browser")
	@Test
	public void testAmazon(String browser) throws MalformedURLException, URISyntaxException {

		String gridURL = "http://localhost:4444/wd/hub";
		DesiredCapabilities capabilities = new DesiredCapabilities();

		if (browser.equalsIgnoreCase("chrome")) {
			capabilities.setBrowserName("chrome");
		} else if (browser.equalsIgnoreCase("firefox")) {
			capabilities.setBrowserName("firefox");
		} else if (browser.equalsIgnoreCase("edge")) {
			capabilities.setBrowserName("MicrosoftEdge");
		}
		driver = new RemoteWebDriver(new URI(gridURL).toURL(), capabilities);

		// Open Amazon
		driver.get("https://www.amazon.com");
		System.out.println("Page title is: " + driver.getTitle());

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}