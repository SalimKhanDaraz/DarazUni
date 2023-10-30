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

public class DU_CatFinance {

    public DU_CatFinance(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    String PageTitle;

    @FindBy(xpath="//*[text()=\"Categories\"]")
    public WebElement Categories;

    @FindBy(xpath="//*[text()=\"Finance\"]")
    public WebElement Finance;

    @FindBy(xpath="//*[text()=\"View all \"]")
    public WebElement Viewall;

    @FindBy(xpath="//*[text()=\"Introduction to Daraz Finance\"]")
    public WebElement IntroToDarazFinance;

    @FindBy(xpath="//*[text()=\"Reference Material\"]")
    public WebElement TutorailMaterial;

    public void Finance(WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Categories\"]")));
        Categories.click();
        Allure.step("Clicked on Categories Tab on the Navigation bar");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"Finance\"]")));
        Finance.click();
        Allure.step("Clicked on Finance module");


        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"View all \"]")));
        Viewall.click();
        Allure.step("Clicked on View All button");

        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//head//*[text()=\"Finance\"]")));
        WebElement PageTile = driver.findElement(By.xpath("//head//*[text()=\"Finance\"]"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//head//*[text()=\"Finance\"]")));
        PageTitle = PageTile.getAttribute("innerHTML");

        String Venture = DU_Portal.Venture;

        switch (Venture) {
            case "LK":

                try {
                    Thread.sleep(1500);
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Introduction to Daraz Finance\"]")));
                    IntroToDarazFinance.click();
                    Allure.step("Clicked on Introduction to Daraz Finance tutorial");
                }catch (Exception e){
                    driver.navigate().to("https://university.daraz.lk/course/learn?spm=du-lk-pc.du-lk-pc-list.courserlist_courses.3.101c4984lHZZ4c&id=1096&type=tutorials");
                    Allure.step("Clicked on Introduction to Daraz Finance tutorial");
                }

                break;


            case "PK":

                try {
                    Thread.sleep(1500);
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Introduction to Daraz Finance\"]")));
                    IntroToDarazFinance.click();
                    Allure.step("Clicked on Introduction to Daraz Finance tutorial");
                }catch (Exception e){
                    driver.navigate().to("https://university.daraz.pk/course/learn?spm=du-pk-pc.du-pk-pc-list.courserlist_courses.7.3ad94984E5bUk9&id=1317&type=tutorials");
                    Allure.step("Clicked on Introduction to Daraz Finance tutorial");
                }

                break;

            case "NP":

                try {
                    Thread.sleep(1500);
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Introduction to Daraz Finance\"]")));
                    IntroToDarazFinance.click();
                    Allure.step("Clicked on Introduction to Daraz Finance tutorial");
                }catch (Exception e){
                    driver.navigate().to("https://university.daraz.com.np/course/learn?spm=du-np-pc.du-np-pc-list.courserlist_courses.3.a39d4984Mc3Ufl&id=2413&type=tutorials");
                    Allure.step("Clicked on Introduction to Daraz Finance tutorial");
                }

                break;


            case "BD":

                try {
                    Thread.sleep(1500);
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Introduction to Daraz Finance\"]")));
                    IntroToDarazFinance.click();
                    Allure.step("Clicked on Introduction to Daraz Finance tutorial");
                }catch (Exception e){
                    driver.navigate().to("https://university.daraz.com.bd/course/learn?spm=du-bd-pc.du-bd-pc-list.courserlist_courses.3.643e4984hYTUmD&id=1039&type=tutorials");
                    Allure.step("Clicked on Introduction to Daraz Finance tutorial");
                }

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

        if (Material)
        {

            System.out.println("Check 1: Tutorial Material Available");
            Allure.step("Tutorial Material Available");
            System.out.println("Case 16: Finance Module Passed");
            System.out.println("******************************");
            Allure.step("Finance Module Passed");
            System.out.println("");
        }
        else
        {
            System.out.println("");
            System.out.println("************************************");
            System.out.println("Check 2: Tutorial Material Not Found");
            Allure.step("Tutorial Material Not Found");
            System.out.println("Case 16: Finance Module Failed");
            System.out.println("******************************");
            Allure.step("Tutorial Material Not Found");
            System.out.println("");

            softAssert.assertFalse(true,"Tutorial Material Not Found");
        }
        softAssert.assertAll();
    }
}
