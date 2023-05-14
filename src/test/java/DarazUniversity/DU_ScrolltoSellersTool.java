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

public class DU_ScrolltoSellersTool {

    public DU_ScrolltoSellersTool(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[text()=\"Seller Tools\"]")
    public WebElement SellerToolsSec;

    public void ScrolltoST(WebDriver driver) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Seller Tools\"]")));
        js.executeScript("arguments[0].scrollIntoView();", SellerToolsSec);

        Thread.sleep(1000);

        System.out.println("***************************************************");
        System.out.println("Case 7: Scrolling Completed to Seller Tools Section");
        System.out.println("***************************************************");
        System.out.println("");
        Allure.step("Scrolled to Seller Tools Section on Home Page");

    }
}
