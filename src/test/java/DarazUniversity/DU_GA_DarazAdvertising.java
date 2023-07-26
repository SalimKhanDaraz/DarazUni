package DarazUniversity;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DU_GA_DarazAdvertising {

    public DU_GA_DarazAdvertising(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[normalize-space()='Growth Assistant']")
    public WebElement GrowthAssistant;

    @FindBy(xpath="//*[text()=\"Daraz Advertising Solutions\"]")
    public WebElement DarazAdvertising;

    public void DarazAdvertisingSol(WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        ArrayList<String> Tab = new ArrayList<String>(driver.getWindowHandles());

        Thread.sleep(1500);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space()='Growth Assistant']")));
        Actions action = new Actions(driver);
        action.moveToElement(GrowthAssistant).perform();
        GrowthAssistant.click();
        Allure.step("Hovered on the Growth Assistant Tab on the Navigation bar");

        Thread.sleep(1500);
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Daraz Advertising Solutions\"]")));
        DarazAdvertising.click();
        Allure.step("Clicked on the Daraz Advertising Solution module");

        Thread.sleep(3000);
        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();

        for (String handle : handles)
        {
            if (!handle.equals(currentHandle))
            {
                driver.switchTo().window(handle);
            }
        }

        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Content Library\"]")));
        Thread.sleep(10000);

        driver.switchTo().frame(0);


        if (driver.findElements(By.xpath("//*[@class=\"col-md-12 text-center\"]")).size()>0)
        {
            System.out.println("****************************************************");
            System.out.println("Check 1: Data in Daraz Advertising Page is Available");
            Allure.step("Data in Daraz Advertising Page is Available");

            System.out.println("Case 24: Daraz Advertising Solution Module Passed");
            Allure.step("Daraz Advertising Solution Module Passed");
            System.out.println("*************************************************");

            Thread.sleep(2000);

        }
        else
        {
            System.out.println("");
            System.out.println("*************************************************");
            System.out.println("Check 2: Data in Daraz Live Page is Not Available");
            Allure.step("Data in Daraz Advertising Page is not Available");

            System.out.println("Case 24: Daraz Advertising Solution Module Failed");
            Allure.step("Daraz Advertising Solution Module Failed");
            System.out.println("*************************************************");
            softAssert.assertFalse(true,"Data in Daraz Advertising Page is not Available");
            Thread.sleep(2000);
        }
        driver.close();
        driver.switchTo().window(Tab.get(0));
        softAssert.assertAll();
    }
}
