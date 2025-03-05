package tests.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.CareersPage;
import pageobjects.JobSearchPage;
import utils.ConfigLoader;

public class JobSearchTest {
  WebDriver driver;
  HomePage homePage;
  CareersPage careersPage;
  JobSearchPage jobSearchPage;

  @BeforeClass
  public void setUp() {
    ConfigLoader.loadProperties();
    System.setProperty("webdriver.chrome.driver", ConfigLoader.getProperty("webdriver.chrome.driver"));
    driver = new ChromeDriver();
    driver.get(ConfigLoader.getProperty("baseUrl"));
    homePage = new HomePage(driver);
    careersPage = new CareersPage(driver);
    jobSearchPage = new JobSearchPage(driver);
  }

  @Test
  public void testJobSearch() {
    homePage.navigateToCareers();
    careersPage.clickSearchJobs();
    jobSearchPage.searchForJob("automation tester");
    Assert.assertTrue(jobSearchPage.hasResults(), "No search results found!");
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }
}