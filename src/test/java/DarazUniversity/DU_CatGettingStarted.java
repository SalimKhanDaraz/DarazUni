package DarazUniversity;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class DU_CatGettingStarted {

    public DU_CatGettingStarted(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    String PageTitle;

    @FindBy(xpath="//*[text()=\"Categories\"]")
    public WebElement Categories;

    @FindBy(xpath="//*[text()=\"Getting Started\"]")
    public WebElement GettingStartedModule;

    @FindBy(xpath="//*[text()=\"View all \"]")
    public WebElement Viewall;

    @FindBy(xpath="//*[text()=\"Getting Started On Daraz\"]")
    public WebElement GettingStartedOnDaraz_PK;

    @FindBy(xpath="//*[text()=\"Getting Started on Daraz\"]")
    public WebElement GettingStartedOnDaraz_LK;

    @FindBy(xpath="//*[text()=\"All About Seller Rating & Reviews \"]")
    public WebElement GettingStartedOnDaraz_BD;

    @FindBy(xpath="//*[text()=\"Getting Started on Daraz \"]")
    public WebElement GettingStartedOnDaraz_NP;

    @FindBy(xpath="//*[text()=\"Reference Material\"]")
    public WebElement TutorailMaterial;

    @FindBy(xpath="//input[@placeholder='Search by Tag']")
    public WebElement Tag_Filter;

    @FindBy(xpath="//*[text()=\"Sales\" and @class=\"next-menu-item-text\"]")
    public WebElement Tag_Sales;

    @FindBy(xpath="//div[@class='content page-body']")
    public WebElement Focus_Shift;

    public void GettingStarted(WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Categories\"]")));
        Categories.click();
        Allure.step("Clicked on Categories Tab on the Navigation bar");


        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Getting Started\"]")));
        GettingStartedModule.click();
        Allure.step("Clicked on Getting Started module");


        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"View all \"]")));
        Viewall.click();
        Allure.step("Clicked on View All button");


        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//head//*[text()=\"Getting Started\"]")));
        WebElement PageTile = driver.findElement(By.xpath("//head//*[text()=\"Getting Started\"]"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//head//*[text()=\"Getting Started\"]")));
        PageTitle = PageTile.getAttribute("innerHTML");

        String Venture = DU_Portal.Venture;

        switch (Venture)
        {
            case "PK":

                Thread.sleep(1500);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Getting Started On Daraz\"]")));
                GettingStartedOnDaraz_PK.click();
                Allure.step("Clicked on Getting Started On Daraz tutorial");

                break;

            case "LK":

                Thread.sleep(1500);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Getting Started on Daraz\"]")));
                GettingStartedOnDaraz_LK.click();
                Allure.step("Clicked on Getting Started On Daraz tutorial");

                break;


            case "BD":

                Thread.sleep(1500);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"All About Seller Rating & Reviews \"]")));
                GettingStartedOnDaraz_BD.click();
                Allure.step("Clicked on Getting Started On Daraz tutorial");

                break;

            case "NP":

                Thread.sleep(2000);
                Tag_Filter.click();

                Thread.sleep(1500);
                Tag_Sales.click();

                Thread.sleep(1000);
                Focus_Shift.click();

                Thread.sleep(1500);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Getting Started on Daraz \"]")));
                GettingStartedOnDaraz_NP.click();
                Allure.step("Clicked on Getting Started On Daraz tutorial");

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

        System.out.println("************************************");
        System.out.println("Module is: " + PageTitle);

        if (Material){

            System.out.println("Check 1: Tutorial Material Available");
            Allure.step("Tutorial Material Available");
            System.out.println("Case 12: Getting Started Module Passed");
            System.out.println("**************************************");
            Allure.step("Getting Started Module Passed");

            System.out.println("");

        }
        else
        {
            System.out.println("");
            System.out.println("************************************");
            System.out.println("Check 2: Tutorial Material Not Found");
            Allure.step("Tutorial Material Not Found");
            System.out.println("Case 12: Getting Started Module Passed");
            System.out.println("**************************************");
            Allure.step("Getting Started Module Failed");
            System.out.println("");

            softAssert.assertFalse(true,"Tutorial Material Not Found");
        }
        softAssert.assertAll();
    }
}
