package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Logerutility {
  public static  Logger  getLogger(Class<?>clazz) {
	  
	  return LogManager.getLogger(clazz);
  }
}
