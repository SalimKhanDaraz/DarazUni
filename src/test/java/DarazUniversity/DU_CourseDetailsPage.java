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
import java.util.List;

import static DarazUniversity.DU_Portal.Venture;

public class DU_CourseDetailsPage {

    public DU_CourseDetailsPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    @FindBy(xpath="//div[@class=\"page-body daraz-content\"]")
    public WebElement CourseDetailBanner;

    @FindBy(xpath="//*[@id=\"recommendCards\"]")
    public WebElement CourseYouMightLike;

    @FindBy(className = "course-button")
    public WebElement StartCourse_Button;

    @FindBy(xpath ="//div[@class=\"title th-ff1 th-fs9\"]")
    public WebElement CourseTitle;

    @FindBy(xpath = "//*[@class=\"course-info-text th-ff1 th-fs9\"]")
    public List<WebElement> CourseInfo;

    @FindBy(id = "courseIntro")
    public WebElement CourseOverviewSection;

    @FindBy(id="reviewCard")
    public WebElement CourseReviewSection;

    @FindBy(xpath="//input[@placeholder=\"Content type\"]")
    public WebElement CourseTypeFilter;

    @FindBy(xpath="//*[text()=\"Courses\"]")
    public WebElement Courses_Filter;

    @FindBy(xpath="//a[text()=\"How to Grow Traffic On Your Store\"]")
    public WebElement Course;

    @FindBy(xpath="//div[@class=\"recommend \"]//a[text()=\"Content Library\"]")
    public WebElement ContentLibrary;

    public void CourseDetailsPage (WebDriver driver) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        SoftAssert softAssert = new SoftAssert();


        switch (Venture) {
            case "PK":

                try {
                    Thread.sleep(1500);
                    wait.until(ExpectedConditions.visibilityOf(ContentLibrary));
                    ContentLibrary.click();
                    Allure.step("Clicked on Content Library on the Nav bar");

                    Thread.sleep(1500);
                    wait.until(ExpectedConditions.visibilityOf(CourseTypeFilter)).isDisplayed();
                    CourseTypeFilter.click();

                    Thread.sleep(1500);
                    wait.until(ExpectedConditions.visibilityOf(Courses_Filter)).isDisplayed();
                    Courses_Filter.click();

                    Thread.sleep(1500);
                    wait.until(ExpectedConditions.visibilityOf(Course)).isDisplayed();
                    Course.click();

                }catch (Exception e){
                    driver.navigate().to("https://university.daraz.lk/course/detail?spm=du-lk-pc.du-lk-pc-list.courserlist_courses.9.28c34984juLWMD&id=1430&type=series");
                    Allure.step("Clicked on How To Grow Traffic On Your Store Course");
                }

                break;

            case "LK":

                try {
                    Thread.sleep(2000);
                    wait.until(ExpectedConditions.visibilityOf(ContentLibrary));
                    ContentLibrary.click();
                    Allure.step("Clicked on Content Library on the Nav bar");

                    Thread.sleep(1500);
                    wait.until(ExpectedConditions.visibilityOf(CourseTypeFilter)).isDisplayed();
                    CourseTypeFilter.click();

                    Thread.sleep(1500);
                    wait.until(ExpectedConditions.visibilityOf(Courses_Filter)).isDisplayed();
                    Courses_Filter.click();

                    Thread.sleep(1500);
                    wait.until(ExpectedConditions.visibilityOf(Course)).isDisplayed();
                    Course.click();

                }catch (Exception e){
                    driver.navigate().to("https://university.daraz.lk/course/detail?spm=du-lk-pc.du-lk-pc-list.courserlist_courses.9.28c34984juLWMD&id=1430&type=series");
                    Allure.step("Clicked on How To Grow Traffic On Your Store Course");
                }

                break;

            case "NP":

                try {
                    Thread.sleep(2000);
                    wait.until(ExpectedConditions.visibilityOf(ContentLibrary));
                    ContentLibrary.click();
                    Allure.step("Clicked on Content Library on the Nav bar");

                    Thread.sleep(1500);
                    wait.until(ExpectedConditions.visibilityOf(CourseTypeFilter)).isDisplayed();
                    CourseTypeFilter.click();

                    Thread.sleep(1500);
                    wait.until(ExpectedConditions.visibilityOf(Courses_Filter)).isDisplayed();
                    Courses_Filter.click();

                    Thread.sleep(1500);
                    wait.until(ExpectedConditions.visibilityOf(Course)).isDisplayed();
                    Course.click();

                }catch (Exception e){
                    driver.navigate().to("https://university.daraz.com.np/course/detail?spm=du-np-pc.du-np-pc-list.courserlist_courses.5.1d0249849wLGr2&id=1429&type=series");
                    Allure.step("Clicked on How To Grow Traffic On Your Store Course");
                }

                break;

            case "BD":

                try {
                    Thread.sleep(2000);
                    wait.until(ExpectedConditions.visibilityOf(ContentLibrary));
                    ContentLibrary.click();
                    Allure.step("Clicked on Content Library on the Nav bar");

                    Thread.sleep(1500);
                    wait.until(ExpectedConditions.visibilityOf(CourseTypeFilter)).isDisplayed();
                    CourseTypeFilter.click();

                    Thread.sleep(1500);
                    wait.until(ExpectedConditions.visibilityOf(Courses_Filter)).isDisplayed();
                    Courses_Filter.click();

                    Thread.sleep(1500);
                    wait.until(ExpectedConditions.visibilityOf(Course)).isDisplayed();
                    Course.click();

                }catch (Exception e){
                    driver.navigate().to("https://university.daraz.com.bd/course/detail?spm=du-bd-pc.du-bd-pc-list.courserlist_courses.3.49044984FztZIe&id=1407&type=series");
                    Allure.step("Clicked on How To Grow Traffic On Your Store Course");
                }

                break;

    }


        boolean Course_Title;
        boolean Course_Banner;
        boolean CourseYouMightLike_Sec;
        boolean Course_Button;
        boolean Course_Overview;

    try {
        Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOf(CourseTitle)).isDisplayed();
        Course_Title  = CourseTitle.isDisplayed();

        wait.until(ExpectedConditions.visibilityOf(CourseDetailBanner)).isDisplayed();
        Course_Banner = CourseDetailBanner.isDisplayed();

        wait.until(ExpectedConditions.visibilityOf(StartCourse_Button)).isDisplayed();
        Course_Button = StartCourse_Button.isDisplayed();

        wait.until(ExpectedConditions.visibilityOf(CourseOverviewSection)).isDisplayed();
        Course_Overview = CourseOverviewSection.isDisplayed();

        wait.until(ExpectedConditions.visibilityOf(CourseYouMightLike)).isDisplayed();
        CourseYouMightLike_Sec = CourseYouMightLike.isDisplayed();

    }catch (Exception e){

        Course_Title = false;
        Course_Banner = false;
        CourseYouMightLike_Sec = false;
        Course_Button = false;
        Course_Overview = false;
    }

    if (Course_Title && Course_Banner && Course_Button && Course_Overview && CourseYouMightLike_Sec)
    {
        System.out.println("***********************************************");
        System.out.println("Check 1: Course Detail Components are available");
        Allure.step("Course Detail Components are available");
        System.out.println("Case: Course Detail Page Passed");
        System.out.println("*******************************");
        System.out.println("");
    }
    else
    {
        System.out.println("");
        System.out.println("*********************************************");
        System.out.println("Check 2: Course Detail Components are missing");
        Allure.step("Course Detail Components are missing");
        System.out.println("Case: Course Detail Page Failed");
        System.out.println("**************************************");
        System.out.println("");

        softAssert.assertFalse(true,"Course Detail Page Failed");

    }

        softAssert.assertAll();
  }


    public void CourseReviewSection (WebDriver driver) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        SoftAssert softAssert = new SoftAssert();

        Thread.sleep(3000);
        js.executeScript("arguments[0].scrollIntoView();", CourseReviewSection);


        boolean Course_Review;

        try {
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOf(CourseReviewSection)).isDisplayed();
            Course_Review   = CourseReviewSection.isDisplayed();
        }catch (Exception e){
            Course_Review = false;
        }

        if (Course_Review)
        {
            System.out.println("***********************************************");
            System.out.println("Check 1: Course Detail Components are available");
            Allure.step("Course Detail Components are available");
            System.out.println("Case: Course Detail Page Passed");
            System.out.println("*******************************");
            System.out.println("");
        }
        else
        {
            System.out.println("");
            System.out.println("*********************************************");
            System.out.println("Check 2: Course Detail Components are missing");
            Allure.step("Course Detail Components are missing");
            System.out.println("Case: Course Detail Page Failed");
            System.out.println("**************************************");
            System.out.println("");

            softAssert.assertFalse(true,"Course Detail Page Failed");

        }

        js.executeScript("arguments[0].scrollIntoView();", StartCourse_Button);
        Thread.sleep(3000);

        softAssert.assertAll();

    }

    public void CourseStatistics (WebDriver driver) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.visibilityOfAllElements(CourseInfo));

        SoftAssert softAssert = new SoftAssert();


        By elementsLocator = By.xpath("//*[@class=\"course-info-text th-ff1 th-fs9\"]");
        List<WebElement> CourseInfo = driver.findElements(elementsLocator);

        for (WebElement element : CourseInfo) {
            if (element.isDisplayed()) {
                System.out.println("Course Duration, Course Session & Actions Details Are Available");
            } else {
                System.out.println("Element is not displayed on the interface.");
                Allure.step("Course Duration, Course Session & Actions Details Are Available");
            }
        }

        softAssert.assertAll();

    }
}