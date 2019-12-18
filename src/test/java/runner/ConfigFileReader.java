package runner;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConfigFileReader {

  private static final String propertyFilePath = "./src/test/resources/config/config.properties";
  private static Properties properties = new Properties();


  static {
      try (InputStream in = new FileInputStream(propertyFilePath);
           Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
           BufferedReader br = new BufferedReader(reader)) {
          properties.load(br);
      } catch (IOException e) {
    	  e.printStackTrace();
      }
  }

  public static long getImplicitlyWait() {
      String implicitlyWait = properties.getProperty("implicitlyWait");
      if (implicitlyWait != null) return Long.parseLong(implicitlyWait);
      else return 5;
  }

  public static String getApplicationUrl() {
      String url = System.getenv("URL");
      if(url == null)
          url = properties.getProperty("url");
      if (url != null) return url;
      else throw new NullPointerException("url not specified in the Configuration.properties file.");
  }
}