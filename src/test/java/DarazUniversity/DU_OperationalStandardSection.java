package DarazUniversity;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DU_OperationalStandardSection {

    public DU_OperationalStandardSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[text()=\"Standard OOS\"]")
    public WebElement Div1;

    @FindBy(xpath="//*[text()=\"Standard QRR\"]")
    public WebElement Div2;

    @FindBy(xpath="//*[text()=\"Standard RTS time\"]")
    public WebElement Div3;

    public void OperationalStandardSec() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        boolean Div1Text;
        boolean Div2Text;
        boolean Div3Text;

        try
        {
            Div1Text = Div1.isDisplayed();
            Div2Text = Div2.isDisplayed();
            Div3Text = Div3.isDisplayed();
        }
        catch(Exception e)
        {
            Div1Text = false;
            Div2Text = false;
            Div3Text = false;
        }

        Thread.sleep(2000);

        if (Div1Text == true && Div2Text == true && Div3Text == true)
        {
            System.out.println("******************************************************");
            System.out.println("Check 1: All Operational Standard Section is Available");
            Allure.step("All the Data in the Operational Standard Section is Available");
            System.out.println("Case 6: Operational Standard Section Validated");
            System.out.println("**********************************************");
            System.out.println("");
            Allure.step("Operational Standard Section Passed");

        }
        else if (!Div1Text == false && !Div2Text == false && !Div3Text == false)
        {
            System.out.println("********************************************************");
            System.out.println("Check 2: Operational Standard Sections are not Available");
            Allure.step("No Data in the Operational Standard Section is Available");
            System.out.println("Case 6: Operational Standard Section Failed");
            System.out.println("*******************************************");
            System.out.println("");
            Allure.step("Operational Standard Section Failed");
            softAssert.assertFalse(true, "Operational Standard Section is Failed");

        }
        else
        {
            System.out.println("************************************************************");
            System.out.println("Check 3: Some of the Operational Standard Sections Available");
            Allure.step("Some of the Data in the Operational Standard Section is Available");
            System.out.println("Case 6: Operational Standard Section Validated");
            System.out.println("**********************************************");
            System.out.println("");
            Allure.step("Operational Standard Section Passed");

        }
        softAssert.assertAll();
    }
}
