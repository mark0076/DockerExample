package remoteTesting.dockerValidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeStandaloneTest {
	public static void main(String args[]) throws MalformedURLException {
		DesiredCapabilities cap =DesiredCapabilities.chrome();
		URL url= new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver =new RemoteWebDriver(url,cap);
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		
		
		
	}

}
