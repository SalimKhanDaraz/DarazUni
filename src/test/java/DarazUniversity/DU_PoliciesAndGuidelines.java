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
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DU_PoliciesAndGuidelines {

    public DU_PoliciesAndGuidelines(WebDriver driver) {
        PageFactory.initElements(driver, this);}

    @FindBy(xpath="//*[text()=\"Policies & Guidelines\"]")
    public WebElement PolicyAndGuide;

    @FindBy(xpath="//*[text()=\"Marketplace Agreement\"]")
    public WebElement Div1;

    @FindBy(xpath="//*[text()=\"Seller Code of Conduct\"]")
    public WebElement Div2;

    @FindBy(xpath="//*[text()=\"Marketplace Commission Structure\"]")
    public WebElement Div3;

    @FindBy(xpath="//*[text()=\"List of Prohibited Items\"]")
    public WebElement Div4;

    @FindBy(xpath="//*[text()=\"Seller Scorecard Policy \"]")
    public WebElement Div5;

    public void PoliciesAndGuidlinesSec(WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Thread.sleep(1500);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Policies & Guidelines\"]")));
        js.executeScript("arguments[0].scrollIntoView();", PolicyAndGuide);
        Allure.step("Scrolled to Policies & Guideline Section on the Home Page");


        Thread.sleep(1500);

        boolean Div1Text;
        boolean Div2Text;
        boolean Div3Text;
        boolean Div4Text;
        boolean Div5Text;

        try
        {
            Div1Text = Div1.isDisplayed();
            Div2Text = Div2.isDisplayed();
            Div3Text = Div3.isDisplayed();
            Div4Text = Div4.isDisplayed();
            Div5Text = Div5.isDisplayed();
        }
        catch(Exception e)
        {
            Div1Text = false;
            Div2Text = false;
            Div3Text = false;
            Div4Text = false;
            Div5Text = false;
        }

        Thread.sleep(1500);

        if (Div1Text == true && Div2Text == true && Div3Text == true && Div4Text == true && Div5Text == true)
        {
            System.out.println("**************************************************************");
            System.out.println("Check 1: All Policies & Guidlines Sections Available Available");
            Allure.step("All the Data in the Policies & Guidlines Section is Available");
            System.out.println("Case 9: Policies & Guidelines Section Passed");
            System.out.println("*******************************************");
            System.out.println("");
            Allure.step("Policies & Guidelines Section Passed");

        }
        else if (!Div1Text == false && !Div2Text == false && !Div3Text == false && !Div4Text == false && !Div5Text == false)
        {
            System.out.println("********************************************************");
            System.out.println("Check 2: Policies & Guidlines Sections are not Available");
            Allure.step("No Data in the Policies & Guidelines Section is Available");
            System.out.println("Case 9: Policies & Guidelines Section is Failed");
            System.out.println("***********************************************");
            Allure.step("Policies & Guidelines Section Failed");
            softAssert.assertFalse(true, "Policies & Guidelines Section is Failed");

        }
        else
        {
            System.out.println("************************************************************");
            System.out.println("Check 3: Some of the Policies & Guidlines Sections Available");
            Allure.step("Some of the Data in the Policies & Guidlines Section is Available");
            System.out.println("Case 9: Policies & Guidelines Section Passed");
            System.out.println("********************************************");
            System.out.println("");
            Allure.step("Policies & Guidelines Section Passed");

        }
        softAssert.assertAll();
    }
}
