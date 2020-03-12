package remoteTesting.dockerValidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class ChromeTest2 {

	@Test 
	public void test2() throws MalformedURLException {
			DesiredCapabilities cap =DesiredCapabilities.chrome();
			URL url= new URL("http://localhost:4444/wd/hub");
			RemoteWebDriver driver =new RemoteWebDriver(url,cap);
			driver.get("https://www.gmail.com/");
			System.out.println(driver.getTitle());
	}
				

		

	}