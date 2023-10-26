package DarazUniversity;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DU_ScrollOSSSection {

    public DU_ScrollOSSSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[text()=\"Operational Performance & Standards\"]")
    public WebElement OSS;

    public void ScrolltoOSS(WebDriver driver) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", OSS);
        //js.executeScript("arguments[0].scrollIntoView();", OSS);

        Thread.sleep(1500);

        System.out.println("******************************************");
        System.out.println("Case 5: Scrolling Completed to OSS Section");
        System.out.println("******************************************");
        System.out.println("");
        Allure.step("Scrolled to Operational Standard Section");

    }
}
