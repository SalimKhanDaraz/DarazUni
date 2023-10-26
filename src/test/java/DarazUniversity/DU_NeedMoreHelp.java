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

public class DU_NeedMoreHelp {

    public DU_NeedMoreHelp(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[text()=\"Need more help?\"]")
    public WebElement NMHSection;

    @FindBy(xpath="//*[@src=\"https://img.alicdn.com/tfs/TB1aVlWu4n1gK0jSZKPXXXvUXXa-183-193.png\"]")
    public WebElement Div1;

    @FindBy(xpath="//*[@src=\"https://img.alicdn.com/tfs/TB1vkjouebviK0jSZFNXXaApXXa-183-193.png\"]")
    public WebElement Div2;

    @FindBy(xpath="//*[@src=\"https://img.alicdn.com/tfs/TB1Vm81uYj1gK0jSZFuXXcrHpXa-191-196.png\"]")
    public WebElement Div3;

    @FindBy(xpath="//*[@src=\"https://img.alicdn.com/tfs/TB1A380uYY1gK0jSZTEXXXDQVXa-190-196.png\"]")
    public WebElement Div4;

    public void NeedMoreHelpSection(WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        Thread.sleep(1500);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Need more help?\"]")));
        js.executeScript("arguments[0].scrollIntoView();", NMHSection);
        Allure.step("Scrolled to Need More Help Section on the Home Page");


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

        if (Div1Text || Div2Text || Div3Text || Div4Text)
        {
            System.out.println("**********************************************");
            System.out.println("Check 1: All Need More Help Sections Available");
            Allure.step("All the Data in the Need More Help Section is Available");
            System.out.println("Case 10: Need More Help Section Passed");
            System.out.println("**************************************");
            System.out.println("");
            Allure.step("Need More Help Section is Passed");

        }
        else if (!!Div1Text || !!Div2Text || !!Div3Text || !!Div4Text)
        {
            System.out.println("**************************************************");
            System.out.println("Check 2: Need More Help Sections are not Available");
            Allure.step("No Data in the Need More Help Section is Available");
            System.out.println("Case 10: Need More Help Section Failed");
            System.out.println("**************************************");
            System.out.println("");
            Allure.step("Need More Help Section is Failed");
            softAssert.assertFalse(true, "Need More Help Section is Failed");

        }
        else
        {
            System.out.println("******************************************************");
            System.out.println("Check 3: Some of the Need More Help Sections Available");
            Allure.step("Some of the Data in Need More Help Section is Available");
            System.out.println("Case 10: Need More Help Section Passed");
            System.out.println("**************************************");
            Allure.step("Need More Help Section is Passed");
            System.out.println("");

        }
        softAssert.assertAll();
    }
}
