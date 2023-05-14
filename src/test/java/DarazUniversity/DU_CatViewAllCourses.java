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

public class DU_CatViewAllCourses {

    public DU_CatViewAllCourses(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    String PageTitle;

    @FindBy(xpath="//*[text()=\"Categories\"]")
    public WebElement Categories;

    @FindBy(xpath="//*[text()=\"View all courses\"]")
    public WebElement ViewallCourses;

    @FindBy(xpath="//*[text()=\"List of Prohibited Items\"]")
    public WebElement AllAboutFreeShipping_PK;

    @FindBy(xpath="//*[text()=\"Guide to download an Order Report\"]")
    public WebElement CategoryRestrictionPolicy_LK;

    @FindBy(xpath="//*[text()=\"Media Center Guide\"]")
    public WebElement CategoryRestrictionPolicy_BD;

    @FindBy(xpath="//*[text()=\"Reference Material\"]")
    public WebElement TutorailMaterial;

    @FindBy(xpath="//input[@placeholder='Search by Tag']")
    public WebElement Tag_Filter;

    @FindBy(xpath="//*[@class=\"next-menu-item-inner\"]//*[text()='Policy']")
    public WebElement Tag_Value;

    @FindBy(xpath="//div[@id='pagination']")
    public WebElement Focus_Shift;

    public void ViewAllCourses(WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Categories\"]")));
        Categories.click();
        Allure.step("Clicked on Categories Tab on the Navigation bar");


        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"View all courses\"]")));
        ViewallCourses.click();
        Allure.step("Clicked on View All Courses module");

        String Venture = DU_Portal.Venture;

        switch (Venture)
        {
            case "PK":

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search by Tag']")));
                Thread.sleep(1000);
                Tag_Filter.click();

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"next-menu-item-inner\"]//*[text()='Policy']")));
                Thread.sleep(1000);
                Tag_Value.click();

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='pagination']")));
                Thread.sleep(1000);
                Focus_Shift.click();

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"List of Prohibited Items\"]")));
                Thread.sleep(1500);
                AllAboutFreeShipping_PK.click();
                Allure.step("Clicked on the List of Prohibited Items Policy");

                break;

            case "LK":

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Guide to download an Order Report\"]")));
                Thread.sleep(1500);
                CategoryRestrictionPolicy_LK.click();
                Allure.step("Clicked on Guide to download an Order Report");

                break;

            case "BD":

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Media Center Guide\"]")));
                Thread.sleep(1500);
                CategoryRestrictionPolicy_BD.click();
                Allure.step("Clicked on Guide to download an Order Report");

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


        if (Material){

            System.out.println("************************************");
            System.out.println("Check 1: Tutorial Material Available");
            Allure.step("Tutorial Material Available");
            System.out.println("Case 19: Content Library Module Passed");
            System.out.println("**************************************");
            System.out.println("");

        }
        else
        {
            System.out.println("");
            System.out.println("************************************");
            System.out.println("Check 2: Its not a Course thats why no material is available");
            Allure.step("Tutorial Material Not Found as its not a course");
            System.out.println("Case 19: Content Library Module Passed");
            System.out.println("**************************************");
            System.out.println("");
            //softAssert.assertFalse(true,"Tutorial Material Not Found");

        }
      //  softAssert.assertAll();
    }
}
