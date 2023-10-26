package DarazUniversity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DU_SS_Newsletter {

    public DU_SS_Newsletter(WebDriver driver) {PageFactory.initElements(driver, this);}

    @FindBy(xpath="//*[text()=\"Seller Support\" and @class=\"recommend-trigger\"]")
    public WebElement SellerSupport;

    public void DU_Newsletter (WebDriver driver) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Seller Support\" and @class=\"recommend-trigger\"]")));
        Actions action = new Actions(driver);
        action.moveToElement(SellerSupport).perform();

   }
}
