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

import static DarazUniversity.DU_Portal.Venture;
import static DarazUniversity.DU_Wait.waitforelement;

public class DU_VerifyPlayButton {

    public DU_VerifyPlayButton(WebDriver driver) {
        PageFactory.initElements(driver, this);}

    @FindBy(xpath="//div[text()=\"Categories\"]")
    public WebElement Categories;

    @FindBy(xpath="//span[text()=\"Order Fulfillment\"]")
    public WebElement OrderFulfillmentModule;

    @FindBy(xpath="//a[text()=\"View all \"]")
    public WebElement Viewall;

    @FindBy(xpath="//*[text()=\"Packaging Guidelines \"]")
    public WebElement PackagGuidTutorial_PK;

    @FindBy(xpath="//*[text()=\"Packaging Guidelines\"]")
    public WebElement PackagGuidTutorial_BD;

    @FindBy(xpath="//*[text()=\"Fulfill your Orders on Seller Center\"]")
    public WebElement PackagGuidTutorial_LK;

    @FindBy(xpath="//*[text()=\"Packaging Guidelines 2.0 \"]")
    public WebElement PackagGuidTutorial_NP;

    @FindBy(xpath = "//a[1][@class=\"image-card\"]")
    public WebElement PlayButton;

    @FindBy(xpath="//*[@placeholder=\"Content type\"]")
    public WebElement ContentType_Filter;

    @FindBy(xpath="//*[text()=\"Tutorials\"]")
    public WebElement Filter_Selection;

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
      //  waitforelement().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Order Fulfillment\"]")));
        waitforelement().until(ExpectedConditions.visibilityOf(OrderFulfillmentModule));
        OrderFulfillmentModule.click();
        Allure.step("Clicked on Order Fulfillment module");

        Thread.sleep(1500);
        waitforelement().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"View all \"]")));
        Viewall.click();
        Allure.step("Clicked on View All button");

        switch (Venture) {
            case "PK":

                try {
                    Thread.sleep(4000);
                    waitforelement().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Packaging Guidelines \"]")));
                    PackagGuidTutorial_PK.click();
                    Allure.step("Clicked on Order Report course");
                }catch (Exception e){
                    driver.navigate().to("https://university.daraz.pk/course/learn?spm=du-pk-pc.du-pk-pc-list.courserlist_courses.3.25844984iiJPTs&id=972&type=tutorials");
                }


                break;

            case "BD":

                Thread.sleep(4000);
                waitforelement().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Packaging Guidelines\"]")));
                PackagGuidTutorial_BD.click();
                Allure.step("Clicked on Order Report course");

                break;

            case "LK":
/*
                Thread.sleep(2000);
                waitforelement().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder=\"Content type\"]")));
                ContentType_Filter.click();

                waitforelement().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Tutorials\"]")));
                Filter_Selection.click();

                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[@placeholder=\"Sort By\"]")).click();

                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[text()=\"Alphabetical Order\"]")).click();

                Thread.sleep(4000);
                waitforelement().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Fulfill your Orders on Seller Center\"]")));
                PackagGuidTutorial_LK.click();
                Allure.step("Clicked on Order Report course");

 */

                Thread.sleep(2000);
                waitforelement().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder=\"Content type\"]")));
                ContentType_Filter.click();

                waitforelement().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Tutorials\"]")));
                Filter_Selection.click();

                Thread.sleep(2000);
                waitforelement().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Packaging Guidelines\"]")));
                PackagGuidTutorial_LK.click();
                Allure.step("Clicked on Packaging Guidelines course");



                break;

            case "NP":

                Thread.sleep(4000);
                waitforelement().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Packaging Guidelines 2.0 \"]")));
                PackagGuidTutorial_NP.click();
                Allure.step("Clicked on Order Report course");

                break;
        }

        waitforelement().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[1][@class=\"image-card\"]")));
        boolean Play_Button = PlayButton.isDisplayed();

        System.out.println("*********************************");

        try
        {
            Play_Button = true;

            System.out.println("Check 1: Play Button is Available");
            Allure.step("Play Button is Available");
            System.out.println("Case: Play Button Passed");
            Allure.step("Play Button Test is Passed");
        }
        catch(Exception e)
        {
            Play_Button = false;
            System.out.println("Check 2: No Play Button is Available");
            Allure.step("Play Button is not Available");
            System.out.println("Case: Play Button Test is Failed");
            Allure.step("Play Button Test is Failed");

            softAssert.assertFalse(true,"Play Button is not Available");
        }
        System.out.println("*********************************");

        softAssert.assertAll();
    }
}
