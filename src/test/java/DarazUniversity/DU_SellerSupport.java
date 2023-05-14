package DarazUniversity;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
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

public class DU_SellerSupport {

    public DU_SellerSupport(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()=\"Seller Support\" and @class=\"recommend-trigger\"]")
    public WebElement SellerSupportTab;

    @FindBy(xpath = "//*[text()=\"Support Center\"]")
    public WebElement SupportCenter;

    @FindBy(xpath = "//*[text()=\"Support Center\"]")
    public WebElement SCPageData;


    public void SellerSupport(WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {


            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Seller Support\" and @class=\"recommend-trigger\"]")));
            Thread.sleep(5000);
            Actions action = new Actions(driver);
            action.moveToElement(SellerSupportTab).perform();
            Allure.step("Hovered Seller Support tab");

            Thread.sleep(1500);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Support Center\"]")));
            SupportCenter.click();
            Allure.step("Clicked on the Support Center button");

            Thread.sleep(1500);

            if (driver.findElements(By.xpath("//*[@id=\"topicCards\"]//div[@class=\"item\"]")).size() > 0) {
                System.out.println("**********************************************");
                System.out.println("Check 1: All Support Center Sections Available");
                Allure.step("All the Data is available in the Support Center");
                System.out.println("Case 26: Support Center Module Passed");
                System.out.println("*************************************");
                System.out.println("");
                Allure.step("Support Center Module Passed");

            } else {
                System.out.println("***************************************************");
                System.out.println("Check 2: Support Center Sections are not Available");
                Allure.step("No Data is available in the Support Center");
                System.out.println("Case 26: Support Center Module Failed");
                System.out.println("*************************************");
                System.out.println("");
                Allure.step("Support Center Module Failed");
                softAssert.assertTrue(false, "No Data is available in the Support Center");

            }
        }catch (Exception e)
        {
            System.out.println("Case 26: Support Center Module Failed");
            e.printStackTrace();
        }
        softAssert.assertAll();
    }
}