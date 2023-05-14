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

public class DU_FT_AppStore {

    public DU_FT_AppStore(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class=\"item\" and @data-spm=\"1\"]")
    public WebElement Appstore_Icon;

    public void FT_Appstore(WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));


        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"item\" and @data-spm=\"1\"]")));
        js.executeScript("arguments[0].scrollIntoView();", Appstore_Icon);

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class=\"item\" and @data-spm=\"1\"]")));
        Appstore_Icon.click();

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

        Thread.sleep(5000);

        String ActualPageTitle = driver.getTitle();
        String ExpectedPageTitle = "Daraz Seller Center on the App Store";
        //System.out.println(ActualPageTitle);
        //System.out.println(ExpectedPageTitle);

        if(Objects.equals(ActualPageTitle, ExpectedPageTitle))
        {
            System.out.println("*******************************************************");
            System.out.println("Check 1: Seller Redirected to the Appstore Successfully");
            Allure.step("Seller Redirected to the Appstore Successfully");
            Allure.step("Appstore Redirection is Passed");
            System.out.println("Case 32: Appstore Redirection is Passed");
            System.out.println("****************************************");
        }
        else
        {
            System.out.println("**************************************************");
            System.out.println("Check 1: Seller Redirection to the Appstore Failed");
            Allure.step("Seller Redirection to the Playstore Failed");
            Allure.step("Playstore Redirection is Failed");
            System.out.println("Case 32: Playstore Appstore is Failed");
            System.out.println("*************************************");

            softAssert.assertFalse(true, "Appstore Redirection Failed");
        }
        Thread.sleep(1000);
        driver.close();
        driver.switchTo().window(currentHandle);
        softAssert.assertAll();
    }
}
