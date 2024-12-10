package configreader;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;
	static {
		try {
			FileInputStream fr = new FileInputStream("C:\\Users\\KIIT\\eclipse-workspace\\com.or.HRMS\\src\\test\\java\\configreader.properties");
			prop = new Properties();
			prop.load(fr);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
}
