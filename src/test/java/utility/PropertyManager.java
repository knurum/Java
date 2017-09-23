package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertyManager {
	private static Properties prop;
	private static InputStream input;
	private static OutputStream output;
	static String path;

	public PropertyManager(String fileName) {
		path = "C:/workSpaceEclipse/PerfectProjec/src/test/resources/" + fileName + ".properties";
		try {
			input = new FileInputStream(path);
			prop = new Properties();
			prop.load(input);
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeProperties(String key, String value) {
		try {
			output = new FileOutputStream(path);
			prop.setProperty(key, value);
			prop.store(output, null);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String readProperties(String key) {
		String value = null;
		try {
			value = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return value;
	}

}
