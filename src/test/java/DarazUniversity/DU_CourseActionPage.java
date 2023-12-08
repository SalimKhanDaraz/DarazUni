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

public class DU_CourseActionPage {

    public DU_CourseActionPage(WebDriver driver) {PageFactory.initElements(driver, this);}



    @FindBy(xpath="//div[@class=\"dada-main-page\"]")
    public WebElement ActionDetailsPage;

    public void ActionPage (WebDriver driver) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        SoftAssert softAssert = new SoftAssert();

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


        boolean ActionPage;

        try {

            Thread.sleep(5000);
            wait.until(ExpectedConditions.visibilityOf(ActionDetailsPage)).isDisplayed();
            ActionPage  = ActionDetailsPage.isDisplayed();

        }catch (Exception e){

            ActionPage = false;
        }

        if (ActionPage)
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

        driver.close();
        softAssert.assertAll();

        driver.switchTo().window(tabs.get(0));
    }

}
