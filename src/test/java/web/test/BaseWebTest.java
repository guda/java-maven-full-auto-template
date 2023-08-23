package web.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseWebTest {

  public WebDriver driver;

  @BeforeAll
  public static void initialize() {
    // Usually you do something needed once only per suite run here
  }

  @BeforeEach
  public void setup() {
    String headless = System.getProperty("headless");

    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--remote-allow-origins=*");

    if ("true".equals(headless)) {
      chromeOptions.addArguments("--headless");
    }

    driver = new ChromeDriver(chromeOptions);
  }

  @AfterEach
  public void quit() {
    if (null != driver) {
      driver.close();
      driver.quit();
    }
  }

  public WebDriver getDriver() {
    return driver;
  }
}
