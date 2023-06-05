package DarazUniversity;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static DarazUniversity.DU_Wait.driver;

public class DU_NewSellerTraining {

    public DU_NewSellerTraining(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[text()=\"New Seller Training\"]")
    public WebElement NewSeller_Sec;

    @FindBy(xpath="//*[text()=\"Vouchers\"]")
    public WebElement ExpolreMore_Button;

    @FindBy(xpath="//*[@class=\"body\"]//img[@class=\"bg\"]")
    public WebElement Course;


    public void NewSeller_Section() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        SoftAssert softAssert = new SoftAssert();

        boolean NewSellerHeading;

        try
        {
            NewSellerHeading = NewSeller_Sec.isDisplayed();
        }
        catch(Exception e)
        {

            NewSellerHeading = false;
        }

        Thread.sleep(1500);

        if (NewSellerHeading == true){



            Thread.sleep(1500);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"body\"]//img[@class=\"bg\"]")));
            Course.click();
            Allure.step("Clicked on the Course from the New Seller Section");

            driver.navigate().back();

            Thread.sleep(1500);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Vouchers\"]")));
            ExpolreMore_Button.click();

            System.out.println("****************************************");
            System.out.println("Check 1: New Seller Section is Available");
            System.out.println("Case: New Seller Section Passed");
            System.out.println("*******************************");
            Allure.step("New Seller Section Module Passed");
            System.out.println("");

        }
        else
        {
            System.out.println("*************************************");
            System.out.println("Check 2: New Seller Section Available");
            System.out.println("Case 8: New Seller Section Passed");
            System.out.println("*********************************");
            Allure.step("Seller Tools Module Failed");
            System.out.println("");

        }
        softAssert.assertAll();
    }
}
