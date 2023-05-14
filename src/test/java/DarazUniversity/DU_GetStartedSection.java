package DarazUniversity;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class DU_GetStartedSection {

    public DU_GetStartedSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[text()=\" About Seller Center\"]")
    public WebElement Div1;

    @FindBy(xpath="//*[text()=\"Product Listing \"]")
    public WebElement Div2;

    @FindBy(xpath="//*[text()=\"Order Management \"]")
    public WebElement Div3;

    @FindBy(xpath="//*[text()=\"Campaign Participation\"]")
    public WebElement Div4;

    public void GetStartSec() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        boolean Div1Text;
        boolean Div2Text;
        boolean Div3Text;
        boolean Div4Text;

        try
        {
            Div1Text = Div1.isDisplayed();
            Div2Text = Div2.isDisplayed();
            Div3Text = Div3.isDisplayed();
            Div4Text = Div4.isDisplayed();
        }
        catch (Exception e)
        {
            Div1Text = false;
            Div2Text = false;
            Div3Text = false;
            Div4Text = false;
        }

        Thread.sleep(1500);

        if (Div1Text == true && Div2Text == true && Div3Text == true && Div4Text == true)
        {
            System.out.println("***********************************************");
            System.out.println("Check 1: All Get Started Sections are Available ");
            Allure.step("All of the Data in the Get Started Section is Available");
            System.out.println("Case 4: Get Started Section Passed");
            System.out.println("**********************************");
            System.out.println("");
            Allure.step("Get Started Section Passed");
        }
        else if (!Div1Text == false && !Div2Text == false && !Div3Text == false && !Div4Text == false)
        {
            System.out.println("***********************************************");
            System.out.println("Check 2: Get Started Sections are not Available");
            Allure.step("Get Started Sections are not Available");
            System.out.println("Case 4: Get Started Section Failed");
            System.out.println("**********************************");
            System.out.println("");
            softAssert.assertFalse(true, "Get Started Sections are not Available");

        }
        else
        {
            System.out.println("***************************************************");
            System.out.println("Check 3: Some of the Get Started Sections Available");
            Allure.step("Some of the Data in the Get Started Section is Available");
            System.out.println("Case 4: Get Started Section Passed");
            System.out.println("**********************************");
            System.out.println("");
        }
        softAssert.assertAll();
    }
}
