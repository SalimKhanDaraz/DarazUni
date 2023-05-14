package DarazUniversity;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class DU_SS_ContactUs {

    public DU_SS_ContactUs(WebDriver driver) {PageFactory.initElements(driver, this);}

    @FindBy(xpath="//*[text()=\"Seller Support\" and @class=\"recommend-trigger\"]")
    public WebElement SellerSupport;

    @FindBy(xpath= "//span[@class='next-menu-item-text']//a[contains(text(),'Contact Us')]")
    public WebElement ContactUs;

    @FindBy(xpath= "//*[text()=\"Be a Part of Daraz Seller Community\"]")
    public WebElement PageData1;

    @FindBy(xpath= "//*[text()=\"Have any questions, complaints or feedback?\"]")
    public WebElement PageData2;


    public void DU_ContactUs (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        ArrayList<String> Tab = new ArrayList<String>(driver.getWindowHandles());

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Seller Support\" and @class=\"recommend-trigger\"]")));
        Actions action = new Actions(driver);
        action.moveToElement(SellerSupport).perform();
        Allure.step("Hovered Seller Support tab on the Navigation Bar");

        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='next-menu-item-text']//a[contains(text(),'Contact Us')]")));
        ContactUs.click();
        Allure.step("Clicked on the Contact Us button");

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

        Thread.sleep(3000);
        if (driver.findElements(By.xpath("//*[@id=\"root\"]")).size()>0)
        {
            System.out.println("*********************************************");
            System.out.println("Check 1: Data in Contact Us Page is Available");
            Allure.step("Data in Contact Us Page is Available");
            System.out.println("Case 28: Contact Us Module Passed");
            System.out.println("*********************************");
            Allure.step("Contact Us Module Passed");
            Thread.sleep(2000);

        }
        else
        {
            System.out.println("");
            System.out.println("*************************************************");
            System.out.println("Check 2: Data in Contact Us Page is Not Available");
            Allure.step("Data in Contact Us Page is Not Available");
            System.out.println("Case 28: Contact Us Module Failed");
            System.out.println("*********************************");
            Allure.step("Contact Us Module Failed");
            Thread.sleep(2000);
            softAssert.assertTrue(false, "Data in Contact Us Page is Not Available");

        }
        driver.close();
        softAssert.assertAll();
        driver.switchTo().window(Tab.get(0));
    }
}
