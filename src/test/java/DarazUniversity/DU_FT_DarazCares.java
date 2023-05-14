package DarazUniversity;

import io.github.sukgu.Shadow;
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

public class DU_FT_DarazCares {

    public DU_FT_DarazCares(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[@class=\"menu-link\" and text()=\"Daraz Cares\"]")
    public WebElement DarazCares_Button;

    public void DarazCares (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(3000);

        js.executeScript("arguments[0].scrollIntoView();", DarazCares_Button);
        //js.executeScript("arguments[0].scrollIntoView();", AboutUS);

        Thread.sleep(4000);
        DarazCares_Button.click();

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

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //driver.switchTo().window(tabs.get(2));

        Thread.sleep(2000);

/*
        boolean Div1Text;
        boolean Div2Text;
        boolean Div3Text;
        boolean Div4Text;
        boolean Div5Text;
        boolean Div6Text;
        boolean Div7Text;
        boolean Div8Text;

        try
        {
            Div1Text = Div1.isDisplayed();
            Div2Text = Div2.isDisplayed();
            Div3Text = Div3.isDisplayed();
            Div4Text = Div4.isDisplayed();
            Div5Text = Div5.isDisplayed();
            Div6Text = Div6.isDisplayed();
            Div7Text = Div7.isDisplayed();
            Div8Text = Div8.isDisplayed();

        }
        catch (Exception e)
        {
            Div1Text = false;
            Div2Text = false;
            Div3Text = false;
            Div4Text = false;
            Div5Text = false;
            Div6Text = false;
            Div7Text = false;
            Div8Text = false;
 }
 */
        Thread.sleep(2000);

        if (driver.findElements(By.xpath("//*[@class=\"mui-zebra-module\"]")).size()>=17)
        {
            System.out.println("********************************************************");
            System.out.println("Check 1: All the Data in Daraz Cares module is Available");
            Allure.step("All of the Data in the Daraz Cares module is Available");
            System.out.println("Case 4: Daraz Cares module Passed");
            System.out.println("*********************************");
            System.out.println("");
            Allure.step("Daraz Cares module Passed");
        }
        else
        {
            System.out.println("*******************************************************");
            System.out.println("Check 2: No data in the Daraz Cares module is Available");
            Allure.step("No data in the Daraz Cares module is Available");
            System.out.println("Case 30: Daraz Cares Module Failed");
            System.out.println("**********************************");
            System.out.println("");
            Allure.step("Daraz Cares module Failed");
        }
        driver.close();
        softAssert.assertAll();
        driver.switchTo().window(tabs.get(0));
      //driver.switchTo().window(currentHandle);
    }
}
