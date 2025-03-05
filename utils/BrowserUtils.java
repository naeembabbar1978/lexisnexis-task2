package tests.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserUtils {
  public static WebDriver getDriver() {
    System.setProperty("webdriver.chrome.driver", ConfigLoader.getProperty("webdriver.chrome.driver"));
    return new ChromeDriver();
  }
}