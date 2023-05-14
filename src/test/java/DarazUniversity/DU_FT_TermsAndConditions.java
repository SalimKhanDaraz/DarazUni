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

public class DU_FT_TermsAndConditions {

    public DU_FT_TermsAndConditions(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[text()=\"Terms & Conditions\"]")
    public WebElement TermsAndConditions_Button;

    @FindBy(xpath="//*[@id=\"courseIntro\"]/div/div")
    public WebElement Content;

    public void TermsAndConditions (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        ArrayList<String> Tab = new ArrayList<String>(driver.getWindowHandles());

        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(2000);

        js.executeScript("arguments[0].scrollIntoView();", TermsAndConditions_Button);
        Thread.sleep(2000);
        TermsAndConditions_Button.click();

        Thread.sleep(10000);
        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();

        for (String handle : handles)
        {
            if (!handle.equals(currentHandle))
            {
                driver.switchTo().window(handle);
            }
        }

        boolean All_Content;

        try
        {
            All_Content = Content.isDisplayed();
        }
        catch (Exception e)
        {
            All_Content = false;
        }

        Thread.sleep(5000);

        if (All_Content == true)
        {
            System.out.println("*******************************************************");
            System.out.println("Check 1: Data in Terms & Conditions module is Available");
            Allure.step("Data in Terms & Conditions module is Available");
            System.out.println("Case 31: Terms & Conditions module Passed");
            System.out.println("**********************************");
            System.out.println("");
            Allure.step("Terms & Conditions module Passed");
        }
        else
        {
            System.out.println("***********************************************************");
            System.out.println("Check 2: No content in Terms & Conditions module is available");
            Allure.step("No content in Terms & Conditions module is available");
            System.out.println("Case 31: No content in Terms & Conditions module is available");
            System.out.println("**********************************");
            System.out.println("");
            Allure.step("Terms & Conditions module failed");

            softAssert.assertFalse(true, "No content in Terms & Conditions module is available");
        }
        softAssert.assertAll();
       // driver.close();
       // driver.switchTo().window(currentHandle);
        driver.switchTo().window(Tab.get(0));
        Thread.sleep(1000);
    }

}
