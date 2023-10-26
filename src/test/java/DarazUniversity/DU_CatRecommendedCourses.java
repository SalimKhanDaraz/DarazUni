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

    public class DU_CatRecommendedCourses {

        public DU_CatRecommendedCourses(WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        String PageTitle;

        @FindBy(xpath="//a[@class='logo-wrap']//img[@alt='logo']")
        public WebElement HomePage;

        @FindBy(xpath="//*[text()=\"Categories\"]")
        public WebElement Categories;

        @FindBy(xpath="//*[text()=\"Finance\"]")
        public WebElement Finance;

        @FindBy(xpath="//*[text()=\"View all \"]")
        public WebElement Viewall;

        @FindBy(xpath="//*[text()=\"Introduction to Daraz Finance\"]")
        public WebElement IntroToDarazFinance;

        @FindBy(xpath="//*[text()=\"Recommended Courses\"]")
        public WebElement RecommendedCourses;

        @FindBy(xpath="//*[text()=\"Content Library\" and @class=\"item\"]")
        public WebElement ContentLibrary;


        public void RecommendedCourseSec (WebDriver driver) throws InterruptedException {

            SoftAssert softAssert = new SoftAssert();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            Thread.sleep(1500);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Categories\"]")));
            Categories.click();
            Allure.step("Clicked on Categories Tab on the Navigation bar");

            Thread.sleep(1500);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Finance\"]")));
            Finance.click();
            Allure.step("Clicked on the Finance module");


            Thread.sleep(1500);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"View all \"]")));
            Viewall.click();
            Allure.step("Clicked on the View All button");

            Thread.sleep(1000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//head//*[text()=\"Finance\"]")));
            WebElement PageTile = driver.findElement(By.xpath("//head//*[text()=\"Finance\"]"));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//head//*[text()=\"Finance\"]")));
            PageTitle = PageTile.getAttribute("innerHTML");

            Thread.sleep(1500);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Introduction to Daraz Finance\"]")));
            IntroToDarazFinance.click();
            Allure.step("Clicked on the Introduction to Daraz Finance course");

            Thread.sleep(1500);
            boolean RecommendedCoursesSec;

            try
            {
                RecommendedCoursesSec = RecommendedCourses.isDisplayed();
                Thread.sleep(1000);
                js.executeScript("arguments[0].scrollIntoView();", RecommendedCourses);
                Thread.sleep(1000);
                Allure.step("Scrolled to the Recommended Course section");
            }
            catch(Exception e)
            {
                RecommendedCoursesSec = false;
            }

            System.out.println("**************************************************");
            System.out.println("Module is: " + PageTitle);

            if (RecommendedCoursesSec)
            {

                System.out.println("Check 1: Recommended Courses Section Available");
                Allure.step("Scrolled to the Recommended Course section");
                System.out.println("Case 20: Recommended Courses Module Passed");
                System.out.println("******************************************");
                Allure.step("Recommended Courses Module Passed");
                System.out.println("");
                js.executeScript("arguments[0].scrollIntoView();", ContentLibrary);

                Thread.sleep(1500);
                HomePage.click();

            }else {
                System.out.println("");
                System.out.println("**********************************************");
                System.out.println("Check 2: Recommended Courses Section Not Found");
                Allure.step("Recommended Courses Section Not Found");
                System.out.println("Case 20: Recommended Courses Module Failed");
                System.out.println("******************************************");
                Allure.step("Recommended Courses Module Failed");
                System.out.println("");
                js.executeScript("arguments[0].scrollIntoView();", ContentLibrary);

                softAssert.assertFalse(true, "Recommended Courses Section Not Found");

                Thread.sleep(1500);
                HomePage.click();

            }
            softAssert.assertAll();
        }

}
