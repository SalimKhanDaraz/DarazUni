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

public class DU_CatListingProducts {

    public DU_CatListingProducts(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    String PageTitle;

    @FindBy(xpath="//*[text()=\"Categories\"]")
    public WebElement Categories;

    @FindBy(xpath="//*[text()=\"Listing Products\"]")
    public WebElement ListingProductsModule;

    @FindBy(xpath="//*[text()=\"View all \"]")
    public WebElement Viewall;

    @FindBy(xpath="//*[text()=\"Introducing Product Advisor\"]")
    public WebElement IntroducingProductAdvisor_PK;

    @FindBy(xpath="//*[text()=\"All About Daraz Size Chart Feature \"]")
    public WebElement IntroducingProductAdvisor_LK;

    @FindBy(xpath="//*[text()=\"Price & Stock update (Single Product)\"]")
    public WebElement IntroducingProductAdvisor_NP;

    @FindBy(xpath="//*[text()=\"All About Daraz Size Chart Feature \"]")
    public WebElement IntroducingProductAdvisor_BD;

    @FindBy(xpath="//*[text()=\"Reference Material\"]")
    public WebElement TutorailMaterial;

    @FindBy(xpath="//*[@placeholder=\"Content type\"]")
    public WebElement ContentType_Filter;

    @FindBy(xpath="//*[text()=\"Tutorials\"]")
    public WebElement Filter_Selection;

    public void ListingProducts(WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Categories\"]")));
        Categories.click();
        Allure.step("Clicked on Categories Tab on the Navigation bar");


        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Listing Products\"]")));
        ListingProductsModule.click();
        Allure.step("Clicked on Listing Products module");


        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"View all \"]")));
        Viewall.click();
        Allure.step("Clicked on View All button");


        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//head//*[text()=\"Listing Products\"]")));
        WebElement PageTile = driver.findElement(By.xpath("//head//*[text()=\"Listing Products\"]"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//head//*[text()=\"Listing Products\"]")));
        PageTitle = PageTile.getAttribute("innerHTML");

        String Venture = DU_Portal.Venture;

        switch (Venture)
        {
            case "PK":

                Thread.sleep(1500);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Introducing Product Advisor\"]")));
                IntroducingProductAdvisor_PK.click();
                Allure.step("Clicked on Introducing Product Advisor tutorial");

                break;

            case "LK":

                Thread.sleep(2000);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder=\"Content type\"]")));
                ContentType_Filter.click();

                Thread.sleep(1000);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Tutorials\"]")));
                Filter_Selection.click();

                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[@placeholder=\"Sort By\"]")).click();

                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[text()=\"Alphabetical Order\"]")).click();

                Thread.sleep(1500);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"All About Daraz Size Chart Feature \"]")));
                IntroducingProductAdvisor_LK.click();
                Allure.step("Clicked on Product Listing Guide tutorial");

                break;

            case "NP":

                Thread.sleep(1500);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Price & Stock update (Single Product)\"]")));
                IntroducingProductAdvisor_NP.click();
                Allure.step("Clicked on Product Listing Guide tutorial");

                break;

            case "BD":

                Thread.sleep(2000);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder=\"Content type\"]")));
                ContentType_Filter.click();

                Thread.sleep(1000);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Tutorials\"]")));
                Filter_Selection.click();

                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[@placeholder=\"Sort By\"]")).click();

                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[text()=\"Alphabetical Order\"]")).click();

                Thread.sleep(2000);
                IntroducingProductAdvisor_BD.click();
                Allure.step("Clicked on Product Listing Guide tutorial");

                break;

        }

        Thread.sleep(1500);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Reference Material\"]")));
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

        if (Material)
        {
            System.out.println("Check 1: Tutorial Material Available");
            Allure.step("Tutorial Material Available");
            System.out.println("Case 13: Listing Products Module Passed");
            System.out.println("***************************************");
            Allure.step("Listing Products Module Passed");

            System.out.println("");

        }
        else
        {
            System.out.println("");
            System.out.println("************************************");
            System.out.println("Check 2: Tutorial Material Not Found");
            Allure.step("Tutorial Material Not Found");
            System.out.println("Case 13: Listing Products Module Failed");
            System.out.println("***************************************");
            Allure.step("Listing Products Module Failed");
            System.out.println("");

            softAssert.assertFalse(true, "Tutorial Material Not Found");

        }
        softAssert.assertAll();
    }
}
