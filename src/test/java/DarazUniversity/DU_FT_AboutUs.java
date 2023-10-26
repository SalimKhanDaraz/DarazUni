package DarazUniversity;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import io.github.sukgu.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DU_FT_AboutUs {

    public DU_FT_AboutUs(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[text()=\"About Us\"]")
    public WebElement AboutUS;

    @FindBy(xpath="/html/body/div[2]")
    public WebElement Div1;

    @FindBy(xpath="//div[@id='J_9574160420']//img[@class='thumb']")
    public WebElement Div2;

    @FindBy(xpath="//div[@id='J_4860962540']//img[@class='thumb']")
    public WebElement Div3;

    @FindBy(xpath="//div[@id='J_3484615650']//img[@class='thumb']")
    public WebElement Div4;

    @FindBy(xpath="//div[@id='J_1908751410']//img[@class='thumb']")
    public WebElement Div5;

    @FindBy(xpath="//div[@id='J_5116931460']//img[@class='thumb']")
    public WebElement Div6;

    @FindBy(xpath="//div[@class='ve-backgroundImage']//img")
    public WebElement Div7;

    @FindBy(xpath="//div[@id='J_2868611060']//img[@class='thumb']")
    public WebElement Div8;

    public void AboutUs (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(3000);

        js.executeScript("arguments[0].scrollIntoView();", AboutUS);
      //js.executeScript("arguments[0].scrollIntoView();", AboutUS);

        Thread.sleep(4000);
        AboutUS.click();
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
      //  driver.switchTo().window(tabs.get(1));

        Thread.sleep(3000);
/*
        Shadow shadow = new Shadow(driver);
        Thread.sleep(2000);
        WebElement ele = driver.findElement(By.cssSelector("div.airship-html-prompt-shadow"));
        shadow.getShadowElement(ele, "div.airship-prompt-container div.airship-alert div.airship-alert-buttons button.airship-btn-deny").click();


 */
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

        if (driver.findElements(By.xpath("//*[@class=\"mui-zebra-module\"]")).size()>1)
        {
            System.out.println("*****************************************************");
            System.out.println("Check 1: All the Data in About Us module is Available");
            Allure.step("All of the Data in the About Us module is Available");
            System.out.println("Case 4: About Us module Passed");
            System.out.println("******************************");
            System.out.println("");
            Allure.step("About Us module Passed");
        }

        else
        {
            System.out.println("****************************************************");
            System.out.println("Check 2: No data in the About Us module is Available");
            Allure.step("No data in the About Us module is Available");
            System.out.println("Case 30: About Us Module Failed");
            System.out.println("*******************************");
            System.out.println("");
            Allure.step("About Us module Failed");
        }

        driver.close();
        softAssert.assertAll();

        driver.switchTo().window(tabs.get(0));
        //driver.switchTo().window(currentHandle);
    }
}
