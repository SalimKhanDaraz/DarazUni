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
import org.testng.asserts.SoftAssert;
import java.time.Duration;


public class DU_CourseDetailsListPage {

    public DU_CourseDetailsListPage(WebDriver driver) {PageFactory.initElements(driver, this);}


    @FindBy(xpath="//a[@class=\"course-button\"]")
    public WebElement StartCourse_Button;

    @FindBy(xpath="//div[@class=\"dada-common-container page-left\"]")
    public WebElement CourseModuleList;

    @FindBy(xpath="//div[@class=\"dada-common-container page-right\"]")
    public WebElement CourseIntro;

    @FindBy(xpath="//span[@class=\"action-type\"]")
    public WebElement ActionPage_Button;

    public void ModuleListPage (WebDriver driver) throws InterruptedException {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        SoftAssert softAssert = new SoftAssert();

        Thread.sleep(3000);
        StartCourse_Button.click();

        boolean ModulesList;
        boolean CourseIntroduction;

        try {

            Thread.sleep(5000);
            wait.until(ExpectedConditions.visibilityOf(CourseModuleList)).isDisplayed();
            ModulesList  = CourseModuleList.isDisplayed();

            wait.until(ExpectedConditions.visibilityOf(CourseIntro)).isDisplayed();
            CourseIntroduction  = CourseIntro.isDisplayed();

        }catch (Exception e){

            ModulesList = false;
            CourseIntroduction = false;

        }

        if (ModulesList && CourseIntroduction)
        {
            System.out.println("**********************************************************");
            System.out.println("Check 1: Modules List & Course Intro Details are available");
            Allure.step("Modules List & Course Intro Details are available");
            System.out.println("Case: Course Details List Page Passed");
            System.out.println("*************************************");
            System.out.println("");
        }else {
            System.out.println("");
            System.out.println("********************************************************");
            System.out.println("Check 2: Modules List & Course Intro Details are missing");
            Allure.step("Modules List & Course Intro Details are missing");
            System.out.println("Case: Course Details List Page Failed");
            System.out.println("**************************************");
            System.out.println("");

            softAssert.assertFalse(true,"Course Details List Page Failed");
        }

      //  ActionPage_Button.click();

        softAssert.assertAll();

    }
}
