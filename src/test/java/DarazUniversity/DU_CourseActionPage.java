package DarazUniversity;

import io.qameta.allure.Allure;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static DarazUniversity.DU_Portal.Venture;

public class DU_CourseActionPage {

    public DU_CourseActionPage(WebDriver driver) {PageFactory.initElements(driver, this);}



    @FindBy(xpath="//div[@class=\"dada-main-page\"]")
    public WebElement ActionDetailsPage;

    @FindBy(xpath="//span[@class=\"action-type\"]")
    public WebElement ActionPage_Button;


    @FindBy(className="button")
    public WebElement ActionPageDone_Button;

    public void ActionPage (WebDriver driver) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        SoftAssert softAssert = new SoftAssert();

        boolean ActionPage;
        boolean ActionPageDoneButton;

       // wait.until(ExpectedConditions.visibilityOf(ActionPage_Button)).isDisplayed();
        //ActionPage_Button.click();

        switch (Venture) {

            case "PK":

        driver.navigate().to("https://university.daraz.pk/course/action?id=5518&cid=5518&sid=942");
        /*
        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();

        for (String handle : handles)
        {
            if (!handle.equals(currentHandle))
            {
                driver.switchTo().window(handle);

            }
        }

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
         */



        try {

            Thread.sleep(5000);
            wait.until(ExpectedConditions.visibilityOf(ActionDetailsPage)).isDisplayed();
            ActionPage  = ActionDetailsPage.isDisplayed();

            wait.until(ExpectedConditions.visibilityOf(ActionPageDone_Button)).isDisplayed();
            ActionPageDoneButton  = ActionPageDone_Button.isDisplayed();

        }catch (Exception e){
            ActionPage = false;
            ActionPageDoneButton = false;
        }

        if (ActionPage && ActionPageDoneButton)
        {
            System.out.println("******************************************");
            System.out.println("Check 1: Action Page Details are available");
            Allure.step("Action Page Details are available");
            System.out.println("Case: Action Page Details Passed");
            System.out.println("********************************");
            System.out.println("");
        }else {
            System.out.println("");
            System.out.println("****************************************");
            System.out.println("Check 2: Action Page Details are missing");
            Allure.step("Action Page Details are missing");
            System.out.println("Case: Action Page Details Failed");
            System.out.println("********************************");
            System.out.println("");

            softAssert.assertFalse(true,"Action Page Details Failed");
        }
                break;

            case "LK":

                driver.navigate().to("https://university.daraz.lk/course/action?id=13702&cid=13702&sid=1424");

                try {

                    Thread.sleep(5000);
                    wait.until(ExpectedConditions.visibilityOf(ActionDetailsPage)).isDisplayed();
                    ActionPage  = ActionDetailsPage.isDisplayed();

                    wait.until(ExpectedConditions.visibilityOf(ActionPageDone_Button)).isDisplayed();
                    ActionPageDoneButton  = ActionPageDone_Button.isDisplayed();

                }catch (Exception e){
                    ActionPage = false;
                    ActionPageDoneButton = false;
                }

                if (ActionPage && ActionPageDoneButton)
                {
                    System.out.println("******************************************");
                    System.out.println("Check 1: Action Page Details are available");
                    Allure.step("Action Page Details are available");
                    System.out.println("Case: Action Page Details Passed");
                    System.out.println("********************************");
                    System.out.println("");
                }else {
                    System.out.println("");
                    System.out.println("****************************************");
                    System.out.println("Check 2: Action Page Details are missing");
                    Allure.step("Action Page Details are missing");
                    System.out.println("Case: Action Page Details Failed");
                    System.out.println("********************************");
                    System.out.println("");

                    softAssert.assertFalse(true,"Action Page Details Failed");
                }
                break;

            case "BD":

                driver.navigate().to("https://university.daraz.com.bd/course/action?id=13992&cid=13726&sid=1426");

                try {

                    Thread.sleep(5000);
                    wait.until(ExpectedConditions.visibilityOf(ActionDetailsPage)).isDisplayed();
                    ActionPage  = ActionDetailsPage.isDisplayed();

                    wait.until(ExpectedConditions.visibilityOf(ActionPageDone_Button)).isDisplayed();
                    ActionPageDoneButton  = ActionPageDone_Button.isDisplayed();

                }catch (Exception e){
                    ActionPage = false;
                    ActionPageDoneButton = false;
                }

                if (ActionPage && ActionPageDoneButton)
                {
                    System.out.println("******************************************");
                    System.out.println("Check 1: Action Page Details are available");
                    Allure.step("Action Page Details are available");
                    System.out.println("Case: Action Page Details Passed");
                    System.out.println("********************************");
                    System.out.println("");
                }else {
                    System.out.println("");
                    System.out.println("****************************************");
                    System.out.println("Check 2: Action Page Details are missing");
                    Allure.step("Action Page Details are missing");
                    System.out.println("Case: Action Page Details Failed");
                    System.out.println("********************************");
                    System.out.println("");

                    softAssert.assertFalse(true,"Action Page Details Failed");
                }
                break;

            case "NP":

                driver.navigate().to("https://university.daraz.com.np/course/action?id=13461&cid=13461&sid=1404");

                try {

                    Thread.sleep(5000);
                    wait.until(ExpectedConditions.visibilityOf(ActionDetailsPage)).isDisplayed();
                    ActionPage  = ActionDetailsPage.isDisplayed();

                    wait.until(ExpectedConditions.visibilityOf(ActionPageDone_Button)).isDisplayed();
                    ActionPageDoneButton  = ActionPageDone_Button.isDisplayed();

                }catch (Exception e){
                    ActionPage = false;
                    ActionPageDoneButton = false;
                }

                if (ActionPage && ActionPageDoneButton)
                {
                    System.out.println("******************************************");
                    System.out.println("Check 1: Action Page Details are available");
                    Allure.step("Action Page Details are available");
                    System.out.println("Case: Action Page Details Passed");
                    System.out.println("********************************");
                    System.out.println("");
                }else {
                    System.out.println("");
                    System.out.println("****************************************");
                    System.out.println("Check 2: Action Page Details are missing");
                    Allure.step("Action Page Details are missing");
                    System.out.println("Case: Action Page Details Failed");
                    System.out.println("********************************");
                    System.out.println("");

                    softAssert.assertFalse(true,"Action Page Details Failed");
                }
                break;


        }

        //driver.close();

        ActionPageDone_Button.click();
        Thread.sleep(3000);

        softAssert.assertAll();

        //driver.switchTo().window(tabs.get(0));
        //driver.navigate().back();
    }

}
