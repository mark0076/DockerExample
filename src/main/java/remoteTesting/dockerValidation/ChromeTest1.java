package remoteTesting.dockerValidation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ChromeTest1 {
	
	@BeforeTest
	public void startDockerScale() throws IOException, InterruptedException {
		
		File logFile = new File("output.txt");
		if(logFile.delete()) {
			System.out.println("File is deleted succesfully");
		}
		StartDocker startDocker = new StartDocker();
		startDocker.startFile();
		
	}
	@AfterTest
	public void stopDockerDeleteFile() throws IOException, InterruptedException {
		StopDocker stopDocker = new StopDocker();
		stopDocker.deleteFile();
	}
@Test 
public void test1() throws MalformedURLException {
		DesiredCapabilities cap =DesiredCapabilities.chrome();
		URL url= new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver =new RemoteWebDriver(url,cap);
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
}
			

	

}
