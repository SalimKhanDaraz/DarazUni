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
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Objects;
import java.util.Set;

public class DU_FT_HelpCenter {

    public DU_FT_HelpCenter(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class=\"menu-link\" and text()=\"Help Center\"]")
    public WebElement HelpCenter_Button;

    public void FT_HelpCenter(WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"menu-link\" and text()=\"Help Center\"]")));
        js.executeScript("arguments[0].scrollIntoView();", HelpCenter_Button);

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"menu-link\" and text()=\"Help Center\"]")));
        HelpCenter_Button.click();

        Thread.sleep(8000);
        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();

        for (String handle : handles)
        {
            if (!handle.equals(currentHandle))
            {
                driver.switchTo().window(handle);
            }
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Seller Help Center\"]")));
        Thread.sleep(5000);

        String ActualPageTitle = driver.getTitle();
        String ExpectedPageTitle = "Help Center";

        if(Objects.equals(ActualPageTitle, ExpectedPageTitle))
        {
            System.out.println("*********************************************************");
            System.out.println("Check 1: Seller Redirected to the HelpCenter Successfully");
            Allure.step("Seller Redirected to the HelpCenter Successfully");
            Allure.step("HelpCenter Redirection is Passed");
            System.out.println("Case 32: HelpCenter Redirection is Passed");
            System.out.println("*****************************************");
        }
        else
        {
            System.out.println("****************************************************");
            System.out.println("Check 1: Seller Redirection to the HelpCenter Failed");
            Allure.step("Seller Redirection to the HelpCenter Failed");
            Allure.step("HelpCenter Redirection is Failed");
            System.out.println("Case 32: HelpCenter Redirection is Failed");
            System.out.println("*****************************************");

            softAssert.assertFalse(true, "HelpCenter Redirection Failed");

        }

        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(currentHandle);
        softAssert.assertAll();

    }
}
