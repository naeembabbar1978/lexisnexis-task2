package tests.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageobjects.HomePage;
import pageobjects.CareersPage;
import pageobjects.JobSearchPage;
import utils.ConfigLoader;

public class JobSearchSteps {
  WebDriver driver;

  @Steps
  HomePage homePage;

  @Steps
  CareersPage careersPage;

  @Steps
  JobSearchPage jobSearchPage;

  @Given("the user is on the LexisNexis homepage")
  public void theUserIsOnTheLexisNexisHomepage() {
    ConfigLoader.loadProperties();
    System.setProperty("webdriver.chrome.driver", ConfigLoader.getProperty("webdriver.chrome.driver"));
    driver = new ChromeDriver();
    driver.get(ConfigLoader.getProperty("baseUrl"));
    homePage = new HomePage(driver);
    careersPage = new CareersPage(driver);
    jobSearchPage = new JobSearchPage(driver);
  }

  @When("the user navigates to the Careers page")
  public void theUserNavigatesToTheCareersPage() {
    homePage.navigateToCareers();
  }

  @When("the user clicks on {string}")
  public void theUserClicksOn(String linkText) {
    careersPage.clickSearchJobs();
  }

  @When("the user searches for {string}")
  public void theUserSearchesFor(String jobTitle) {
    jobSearchPage.searchForJob(jobTitle);
  }

  @Then("the user should see at least one search result")
  public void theUserShouldSeeAtLeastOneSearchResult() {
    Assert.assertTrue(jobSearchPage.hasResults(), "No search results found!");
    driver.quit();
  }
}