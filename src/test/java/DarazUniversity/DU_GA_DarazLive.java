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

public class DU_GA_DarazLive {

    public DU_GA_DarazLive(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[text()=\"Growth Assistant\"]")
    public WebElement GrowthAssistant;

    @FindBy(xpath="//*[text()=\"DarazLive\"]")
    public WebElement DarazLive;

    public void Daraz_Live(WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Growth Assistant\"]")));
        Actions action = new Actions(driver);
        action.moveToElement(GrowthAssistant).perform();
        GrowthAssistant.click();
        Allure.step("Hovered on the Growth Assistant Tab on the Navigation bar");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"DarazLive\"]")));
        DarazLive.click();
        Allure.step("Clicked on the Daraz Live module");


        Thread.sleep(1500);

        if (driver.findElements(By.xpath("//*[@id=\"root\"]")).size()>0)
        {
            System.out.println("*********************************************");
            System.out.println("Check 1: Data in Daraz Live Page is Available");
            Allure.step("Data or Content in Daraz Live Page is Available");
            Allure.step("Daraz Advertising Solution Module is Passed");
            System.out.println("Case 25: Daraz Advertising Solution Module Passed");
            System.out.println("*************************************************");

        }
        else
        {
            System.out.println("");
            System.out.println("*************************************************");
            System.out.println("Check 2: Data in Daraz Live Page is Not Available");
            Allure.step("Data or Content in Daraz Live Page is Not Available");
            System.out.println("Case 25: Daraz Advertising Solution Module Failed");
            System.out.println("*************************************************");
            softAssert.assertFalse(true, "Content in Daraz Live Page is Not Available");
        }
        softAssert.assertAll();
    }
}
