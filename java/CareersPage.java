package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareersPage {
  WebDriver driver;

  @FindBy(linkText = "Search jobs")
  WebElement searchAllJobsLink;

  public CareersPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void clickSearchJobs() {
    searchAllJobsLink.click();
  }
}