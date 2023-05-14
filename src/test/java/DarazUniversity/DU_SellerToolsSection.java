package DarazUniversity;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class DU_SellerToolsSection {

    public DU_SellerToolsSection(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[text()=\"Seller Tools\"]")
    public WebElement SellerToolsSec;

    @FindBy(xpath="//*[text()=\"IM\"]")
    public WebElement Div1;

    @FindBy(xpath="//*[text()=\"Vouchers\"]")
    public WebElement Div2;

    @FindBy(xpath="//*[text()=\"Seller Picks\"]")
    public WebElement Div3;

    @FindBy(xpath="//*[text()=\"Bundles\"]")
    public WebElement Div4;

    public void SellerToolsSec() throws InterruptedException {

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
        catch(Exception e)
        {
            Div1Text = false;
            Div2Text = false;
            Div3Text = false;
            Div4Text = false;
        }

        Thread.sleep(1500);

        if (Div1Text == true && Div2Text == true && Div3Text == true && Div4Text == true){
            System.out.println("********************************************");
            System.out.println("Check 1: All Seller Tools Sections Available");
            Allure.step("All the Data in the  Seller Tools Section is Available on the Home Page");
            System.out.println("Case 8: Seller Tools Section Section Passed");
            System.out.println("*******************************************");
            Allure.step("Seller Tools Module Passed");
            System.out.println("");

        }
        else if (!Div1Text == false && !Div2Text == false && !Div3Text == false && !Div4Text == false)
        {
            System.out.println("************************************************");
            System.out.println("Check 2: Seller Tools Sections are not Available");
            Allure.step("No Data in the  Seller Tools Section is Available on the HomePage");
            System.out.println("Case 8: Seller Tools Section Section Passed");
            System.out.println("*******************************************");
            Allure.step("Seller Tools Module Failed");
            System.out.println("");
            softAssert.assertTrue(false, "No Data in the  Seller Tools Section is Available on the HomePage");

        }
        else
        {
            System.out.println("****************************************************");
            System.out.println("Check 3: Some of the Seller Tools Sections Available");
            Allure.step("Some of the Data in the  Seller Tools Section is Available on the Home Page");
            System.out.println("Case 8: Seller Tools Section Section Passed");
            System.out.println("*******************************************");
            Allure.step("Seller Tools Module Passed");
            System.out.println("");

        }
        softAssert.assertAll();
    }
}
