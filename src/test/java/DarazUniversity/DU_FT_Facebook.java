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

public class DU_FT_Facebook {

    public DU_FT_Facebook(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@alt='contact logo']")
    public WebElement FB_Icon;

    public void FT_Facebook(WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(3000);
        js.executeScript("arguments[0].scrollIntoView();", FB_Icon);

        Thread.sleep(2000);
        FB_Icon.click();

        Thread.sleep(8000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"click.daraz.com.bd\"]")));

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
        String ExpectedPageTitle_PK = "Daraz Sellers - Home | Facebook";
        String ExpectedPageTitle_LK = "Daraz Seller Community | Facebook";
        String ExpectedPageTitle_BD = "Daraz Sellers - BD";
        System.out.println(ActualPageTitle);

        switch (DU_Portal.Venture)
        {
            case "PK":

                if(Objects.equals(ActualPageTitle, ExpectedPageTitle_PK))
                {
                    System.out.println("*******************************************************");
                    System.out.println("Check 1: Seller Redirected to the Facebook Successfully");
                    Allure.step("Seller Redirected to the Facebook Successfully");
                    Allure.step("Facebook Redirection is Passed");
                    System.out.println("Case 32: Facebook Redirection is Passed");
                    System.out.println("***************************************");
                }
                else
                {
                    System.out.println("**************************************************");
                    System.out.println("Check 2: Seller Redirection to the Facebook Failed");
                    Allure.step("Seller Redirection to the Facebook Failed");
                    Allure.step("Facebook Redirection is Failed");
                    System.out.println("Case 32: Facebook Redirection is Failed");
                    System.out.println("***************************************");

                    softAssert.assertFalse(true, "Facebook Redirection Failed");
                }
                break;

            case "LK":

                if(Objects.equals(ActualPageTitle, ExpectedPageTitle_LK))
                {
                    System.out.println("*******************************************************");
                    System.out.println("Check 1: Seller Redirected to the Facebook Successfully");
                    Allure.step("Seller Redirected to the Facebook Successfully");
                    Allure.step("Facebook Redirection is Passed");
                    System.out.println("Case 32: Facebook Redirection is Passed");
                    System.out.println("***************************************");
                }
                else
                {
                    System.out.println("**************************************************");
                    System.out.println("Check 2: Seller Redirection to the Facebook Failed");
                    Allure.step("Seller Redirection to the Facebook Failed");
                    Allure.step("Facebook Redirection is Failed");
                    System.out.println("Case 32: Facebook Redirection is Failed");
                    System.out.println("***************************************");

                    softAssert.assertFalse(true, "Facebook Redirection Failed");
                }

                break;

            case "BD":

                if(Objects.equals(ActualPageTitle, ExpectedPageTitle_BD))
                {
                    System.out.println("*******************************************************");
                    System.out.println("Check 1: Seller Redirected to the Facebook Successfully");
                    Allure.step("Seller Redirected to the Facebook Successfully");
                    Allure.step("Facebook Redirection is Passed");
                    System.out.println("Case 32: Facebook Redirection is Passed");
                    System.out.println("***************************************");
                }
                else
                {
                    System.out.println("**************************************************");
                    System.out.println("Check 2: Seller Redirection to the Facebook Failed");
                    Allure.step("Seller Redirection to the Facebook Failed");
                    Allure.step("Facebook Redirection is Failed");
                    System.out.println("Case 32: Facebook Redirection is Failed");
                    System.out.println("***************************************");

                    softAssert.assertFalse(true, "Facebook Redirection Failed");
                }

                break;
        }
        /*
        if(Objects.equals(ActualPageTitle, ExpectedPageTitle_PK))
        {
            System.out.println("*******************************************************");
            System.out.println("Check 1: Seller Redirected to the Facebook Successfully");
            Allure.step("Seller Redirected to the Facebook Successfully");
            Allure.step("Facebook Redirection is Passed");
            System.out.println("Case 32: Facebook Redirection is Passed");
            System.out.println("***************************************");
        }
        else
        {
            System.out.println("**************************************************");
            System.out.println("Check 2: Seller Redirection to the Facebook Failed");
            Allure.step("Seller Redirection to the Facebook Failed");
            Allure.step("Facebook Redirection is Failed");
            System.out.println("Case 32: Facebook Redirection is Failed");
            System.out.println("***************************************");

            softAssert.assertFalse(true, "Facebook Redirection Failed");
        }

         */
        driver.close();
        softAssert.assertAll();
        driver.switchTo().window(currentHandle);
    }
}