package remoteTesting.dockerValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StartDocker {

	
	@Test
	public void startFile() throws IOException,InterruptedException {
		boolean flag=false;
		
		 Runtime runtime=Runtime.getRuntime();
		 runtime.exec("cmd /c start dockerUp.bat");

		
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
			if(currentLine.contains(" Registering the node to the hub"))
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
		runtime.exec("cmd /c start scale.bat");
		
		Thread.sleep(5000);
		
	}
	}
	
	
	

 