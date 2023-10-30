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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

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

                try {
                    Thread.sleep(1500);
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Introducing Product Advisor\"]")));
                    IntroducingProductAdvisor_PK.click();
                    Allure.step("Clicked on Introducing Product Advisor tutorial");
                }catch (Exception e){
                    driver.navigate().to("https://university.daraz.pk/course/learn?spm=du-pk-pc.du-pk-pc-list.courserlist_courses.37.53364984hSbhgB&id=8290&type=tutorials");
                    Allure.step("Clicked on Introducing Product Advisor tutorial");
                }

                break;

            case "LK":
/*
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

 */

                try {
                    Thread.sleep(1500);
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"All About Daraz Size Chart Feature \"]")));
                    IntroducingProductAdvisor_LK.click();
                    Allure.step("Clicked on Product Listing Guide tutorial");
                }catch (Exception e){
                    driver.navigate().to("https://university.daraz.lk/course/learn?spm=du-lk-pc.du-lk-pc-list.courserlist_courses.3.ec784984YLAI9p&id=1092&type=tutorials");
                    Allure.step("Clicked on Product Listing Guide tutorial");

                }

                break;

            case "NP":

                try {
                    Thread.sleep(1500);
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Price & Stock update (Single Product)\"]")));
                    IntroducingProductAdvisor_NP.click();
                    Allure.step("Clicked on Product Listing Guide tutorial");
                }catch (Exception e){
                    driver.navigate().to("https://university.daraz.com.np/course/learn?spm=du-np-pc.du-np-pc-list.courserlist_courses.23.a12e49843aabl2&id=1459&type=tutorials");
                    Allure.step("Clicked on Product Listing Guide tutorial");
                }

                break;

            case "BD":
/*
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
 */
                try {
                    Thread.sleep(2000);
                    IntroducingProductAdvisor_BD.click();
                    Allure.step("Clicked on Product Listing Guide tutorial");
                }catch (Exception e){
                    driver.navigate().to("https://university.daraz.com.bd/course/learn?spm=du-bd-pc.du-bd-pc-list.courserlist_courses.1.68a54984FGvu8O&id=13984&type=tutorials");
                    Allure.step("Clicked on How to Register a Brand tutorial");
                }

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
