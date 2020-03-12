package remoteTesting.dockerValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StopDocker {

	
	@Test
	public void deleteFile() throws IOException,InterruptedException {
		boolean flag=false;
		
		 Runtime runtime=Runtime.getRuntime();
		 runtime.exec("cmd /c start dockerDown.bat");

		
		String file = "output.txt";
		
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.SECOND, 30);
		long stopNow = calendar.getTimeInMillis(); 
		Thread.sleep(3000);
		while(System.currentTimeMillis()<stopNow) {
			if(flag) 
			{
			break;
			}
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String currentLine=reader.readLine();
		
		while(currentLine!=null && !flag) {
			if(currentLine.contains("selenium-hub exited"))
			{
				System.out.println("my text is found");
				flag=true;
				break;
			}
			currentLine=reader.readLine();
		}
		reader.close();
		}
	
		Assert.assertTrue(flag);

		
		
	}
	}
	
	
	

 