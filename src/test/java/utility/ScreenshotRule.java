package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;


public class ScreenshotRule extends BasePage{
	String path = "C:/workSpaceEclipse/screenshots/";
	public static final Logger log = Logger.getLogger(ScreenshotRule.class.getName());
	public void takeScreenshot(String nameSS)
	{
		log.info("taking ss");
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss");
		String time = formatter.format(calendar.getTime());
		File SSFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File disFile = new File((String) path + nameSS +"_" + time + ".png");
		
		Reporter.log("<a href='" + disFile.getAbsolutePath() + "'><img src='" + disFile.getAbsolutePath()
		+ "' height='100' width='100'/></a>");
		try {
			FileUtils.copyFile(SSFile, disFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
