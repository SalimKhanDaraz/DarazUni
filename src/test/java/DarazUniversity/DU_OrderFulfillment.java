package DarazUniversity;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import static DarazUniversity.DU_Wait.waitforelement;

public class DU_OrderFulfillment {


    public DU_OrderFulfillment(WebDriver driver)

    {
        DU_Wait.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String PageTitle;

    @FindBy(xpath="//*[text()=\"Categories\"]")
    public WebElement Categories;

    @FindBy(xpath="//*[text()=\"Order Fulfillment\"]")
    public WebElement OrderFulfillmentModule;

    @FindBy(xpath="//*[text()=\"View all \"]")
    public WebElement Viewall;

    @FindBy(xpath="//a[text()=\"Packaging Guidelines\" and @data-spm=\"1\"]")
    public WebElement PackagGuidTutorial_LK;

    @FindBy(xpath="//*[text()=\"Packaging Guidelines 2.0 \"]")
    public WebElement PackagGuidTutorial_BD;

    @FindBy(xpath="//*[text()=\"Reference Material\"]")
    public WebElement TutorailMaterial;

    @FindBy(xpath = "//a[1][@class=\"image-card\"]")
    public WebElement PlayButton;

    public void OrderFulfill (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Categories);
        Thread.sleep(1000);

        Thread.sleep(1500);
        waitforelement().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Categories\"]")));
        Categories.click();
        Allure.step("Clicked on Categories Tab on the Navigation bar");

        Thread.sleep(1500);
        waitforelement().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Order Fulfillment\"]")));
        OrderFulfillmentModule.click();
        Allure.step("Clicked on Order Fulfillment module");

        Thread.sleep(1500);
        waitforelement().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"View all \"]")));
        Viewall.click();
        Allure.step("Clicked on View All button");

        Thread.sleep(1000);
        waitforelement().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//head//*[text()=\"Order Fulfillment\"]")));
        WebElement PageTile = driver.findElement(By.xpath("//head//*[text()=\"Order Fulfillment\"]"));
        waitforelement().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//head//*[text()=\"Order Fulfillment\"]")));
        PageTitle = PageTile.getAttribute("innerHTML");

        String Venture = DU_Portal.Venture;

        switch (Venture)
        {
            case "LK":

                Thread.sleep(4000);
                waitforelement().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\"Packaging Guidelines\" and @data-spm=\"1\"]")));
                PackagGuidTutorial_LK.click();
                Allure.step("Clicked on Order Report course");

                break;

            case "NP":

                Thread.sleep(4000);
                waitforelement().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Packaging Guidelines 2.0 \"]")));
                PackagGuidTutorial_BD.click();
                Allure.step("Clicked on Order Report course");

                break;

        }


        boolean Material = TutorailMaterial.isDisplayed();

        try
        {
            Material = TutorailMaterial.isDisplayed();
        }
        catch(Exception e)
        {
            Material = false;
        }

        System.out.println("************************************");
        System.out.println("Module is: " + PageTitle);

        if (Material)
        {
            System.out.println("Check 1: Tutorial Material Available");
            Allure.step("Tutorial Material Available");
            System.out.println("Case 11: Order Fulfillment Module Passed");
            System.out.println("****************************************");
            Allure.step("Order Fulfillment Module Passed");

            System.out.println("");

        }
        else
        {
            System.out.println("");
            System.out.println("************************************");
            System.out.println("Check 2: Tutorial Material Not Found");
            Allure.step("Tutorial Material Not Found");
            System.out.println("Case 11: Order Fulfillment Module Failed");
            System.out.println("****************************************");
            Allure.step("Order Fulfillment Module Failed");

            softAssert.assertFalse(true, "Tutorial Material Not Found");
        }
        softAssert.assertAll();
    }
}
