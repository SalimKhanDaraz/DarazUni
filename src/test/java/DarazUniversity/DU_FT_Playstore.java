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

public class DU_FT_Playstore {

    public DU_FT_Playstore(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class=\"item\" and @data-spm=\"0\"]")
    public WebElement Playstore_Icon;

    @FindBy(xpath = "")
    public WebElement PlayStore_Element;

    public void FT_Playstore(WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(3000);
        js.executeScript("arguments[0].scrollIntoView();", Playstore_Icon);

        Thread.sleep(2000);
        Playstore_Icon.click();

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

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"VAgTTd LMcLV\"]//*[@class=\"VfPpkd-Jh9lGc\"]")));

//      Thread.sleep(4000);

        String ActualPageTitle = driver.getTitle();
        String ExpectedPageTitle = "Daraz Seller Center - Apps on Google Play";
        System.out.println(ActualPageTitle);
        System.out.println(ExpectedPageTitle);

        if(Objects.equals(ActualPageTitle, ExpectedPageTitle))
        {
            System.out.println("********************************************************");
            System.out.println("Check 1: Seller Redirected to the Playstore Successfully");
            Allure.step("Seller Redirected to the Playstore Successfully");
            Allure.step("Playstore Redirection is Passed");
            System.out.println("Case 32: Playstore Redirection is Passed");
            System.out.println("****************************************");
        }
        else
        {
            System.out.println("***************************************************");
            System.out.println("Check 1: Seller Redirection to the Playstore Failed");
            Allure.step("Seller Redirection to the Playstore Failed");
            Allure.step("Playstore Redirection is Failed");
            System.out.println("Case 32: Playstore Redirection is Failed");
            System.out.println("****************************************");

            softAssert.assertFalse(true, "Playstore Redirection Failed");

        }
        driver.close();
        softAssert.assertAll();

        Thread.sleep(1000);
        driver.switchTo().window(currentHandle);

    }
}
