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

import static DarazUniversity.DU_Portal.Venture;

public class DU_CatPoliciesAndGuidlines {

    public DU_CatPoliciesAndGuidlines(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    String PageTitle;

    @FindBy(xpath="//*[text()=\"Categories\"]")
    public WebElement Categories;

    @FindBy(xpath="//span[text()=\"Policies & Guidelines\"]")
    public WebElement PoliciesAndGuidlines;

    @FindBy(xpath="//*[text()=\"View all \"]")
    public WebElement Viewall;

    @FindBy(xpath="//*[text()=\"Seller Claims Policy\"]")
    public WebElement SellerClaimsPolicy_PK;

    @FindBy(xpath="//a[text()=\"Seller Compliance\"]")
    public WebElement SellerCompliance;

    @FindBy(xpath="//*[text()=\"Marketplace Commission Structure\"]")
    public WebElement SellerClaimsPolicy_BD;

    @FindBy(xpath="//*[text()=\"Reference Material\"]")
    public WebElement TutorailMaterial;

    @FindBy(xpath="//*[@placeholder=\"Content type\"]")
    public WebElement ContentType_Filter;

    @FindBy(xpath="//*[text()=\"Tutorials\"]")
    public WebElement Filter_Selection;

    public void PoliciesAndGuideline (WebDriver driver) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Categories\"]")));
        Categories.click();
        Allure.step("Clicked on Categories Tab on the Navigation bar");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"Policies & Guidelines\"]")));
        PoliciesAndGuidlines.click();
        Allure.step("Clicked on the Policies & Guidelines module");

        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"View all \"]")));
        Viewall.click();
        Allure.step("Clicked on the View All button");

        switch (Venture)
        {
            case "PK":

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Seller Claims Policy\"]")));
                Thread.sleep(1500);
                SellerClaimsPolicy_PK.click();
                Allure.step("Clicked on the Seller Claims Policy course");

                break;

            case "LK":

                Thread.sleep(2000);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder=\"Search by Tag\"]")));
                ContentType_Filter.click();

                Thread.sleep(1500);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Tutorials\"]")));
                Filter_Selection.click();

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\"Seller Compliance\"]")));
                Thread.sleep(1500);
                SellerCompliance.click();
                Allure.step("Clicked on the Seller Claims Policy course");

                break;


            case "BD":

                Thread.sleep(2000);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder=\"Search by Tag\"]")));
                ContentType_Filter.click();

                Thread.sleep(1500);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Tutorials\"]")));
                Filter_Selection.click();

                Thread.sleep(2000);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Marketplace Commission Structure\"]")));
                SellerClaimsPolicy_BD.click();
                Allure.step("Clicked on the Seller Claims Policy course");

                break;


        }


        Thread.sleep(1500);
        boolean Material;

        try{
            Material = TutorailMaterial.isDisplayed();;
        }
        catch(Exception e)
        {
            Material = false;
        }

        System.out.println("***************************************");
        System.out.println("Module is: " + PageTitle);

        if (Material){

            System.out.println("Check 1: Tutorial Material Available");
            Allure.step("Tutorial Material Available");
            System.out.println("Case 18: Policy & Guidelines Module Passed");
            System.out.println("******************************************");
            Allure.step("Policy & Guidelines Module Passed");

            System.out.println("");

        }
        else
        {
            System.out.println("Check 2: This Tutorial has no Tutorial Material");
            Allure.step("Tutorial Material Not Found");
            System.out.println("Case 18: Policy & Guidelines Module Passed");
            System.out.println("******************************************");
            Allure.step("Policy & Guidelines Module Passed");
            System.out.println("");

        }
    }
}
