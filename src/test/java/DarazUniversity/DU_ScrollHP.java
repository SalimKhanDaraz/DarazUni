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


public class DU_ScrollHP extends DU_Wait{

    public DU_ScrollHP(WebDriver driver) {
       // DU_Wait.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@class=\"prefix\"]")
    public WebElement Footer;

    @FindBy(xpath="//*[@role=\"searchbox\"]")
    public WebElement SearchField;

    public void ScrolltoContLib(WebDriver driver) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Thread.sleep(1500);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"prefix\"]")));
        js.executeScript("arguments[0].scrollIntoView();", Footer);
        js.executeScript("arguments[0].scrollIntoView();", Footer);
        Allure.step("Scrolled to Footer");

        Thread.sleep(1500);

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@role=\"searchbox\"]")));
        js1.executeScript("arguments[0].scrollIntoView();", SearchField);
        js1.executeScript("arguments[0].scrollIntoView();", SearchField);
        Allure.step("Scrolled to Header");

        System.out.println("*******************");
        System.out.println("Scrolling Completed");
        System.out.println("*******************");
        System.out.println("");
        Allure.step("Scrolling Completed");

    }
}
