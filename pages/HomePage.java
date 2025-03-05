package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
  WebDriver driver;

  @FindBy(linkText = "About Us")
  WebElement aboutUsLink;

  @FindBy(linkText = "Careers")
  WebElement careersLink;

  public HomePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void navigateToCareers() {
    Actions actions = new Actions(driver);
    actions.moveToElement(aboutUsLink).perform();
    careersLink.click();
  }
}