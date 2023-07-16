package DarazUniversity;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DU_FT_SellOnDaraz {

    public DU_FT_SellOnDaraz(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[normalize-space()='Sell on Daraz']")
    public WebElement SellonDaraz_Button;

    public void SellonDaraz (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(3000);

        js.executeScript("arguments[0].scrollIntoView();", SellonDaraz_Button);
        js.executeScript("arguments[0].scrollIntoView();", SellonDaraz_Button);
        //js.executeScript("arguments[0].scrollIntoView();", AboutUS);

        Thread.sleep(4000);
        SellonDaraz_Button.click();

        Thread.sleep(5000);
        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();

        for (String handle : handles)
        {
            if (!handle.equals(currentHandle))
            {
                driver.switchTo().window(handle);

            }
        }

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
       // driver.switchTo().window(tabs.get(4));

        Thread.sleep(5000);

        if (driver.findElements(By.xpath("//*[@class=\"flex-item\"]")).size()>0)
        {
            System.out.println("********************************************************");
            System.out.println("Check 1: Data in the Sell on Daraz module is Available");
            Allure.step("Data in the Sell on Daraz module is Available");
            System.out.println("Case 39: Sell on Daraz module Passed");
            System.out.println("*********************************");
            System.out.println("");
            Allure.step("Sell on Daraz module Passed");
        }
        else
        {
            System.out.println("*******************************************************");
            System.out.println("Check 2: No data in the Sell on Daraz module is Available");
            Allure.step("No data in the Sell on Daraz module is Available");
            System.out.println("Case 30: Sell on Daraz Module Failed");
            System.out.println("************************************");
            System.out.println("");
            Allure.step("Sell on Daraz module Failed");
        }

        driver.close();
        softAssert.assertAll();

        driver.switchTo().window(tabs.get(0));
       // driver.switchTo().window(currentHandle);
    }
}
