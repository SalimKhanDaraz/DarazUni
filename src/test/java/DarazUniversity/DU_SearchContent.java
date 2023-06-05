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

public class DU_SearchContent {

    public DU_SearchContent(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@placeholder=\"Search Daraz University by keyword, topic, or …\"]")
    public WebElement SearchField;

    @FindBy(xpath="//*[@type=\"button\" and @tabindex=\"0\"]")
    public WebElement SearchButton;

    @FindBy(xpath="//*[@class=\"logo-wrap\" and @href=\"/personalRecommend\"]")
    public WebElement HomeButton;

    @FindBy(xpath="//*[text()=\"Importance of Fragile Sticker\"]")
    public WebElement SearchContentResult;


    public void Search (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Thread.sleep(2000);
        SearchField.sendKeys("Importance of Fragile Sticker");
        Allure.step("Entered Data in the Search Field");

        Thread.sleep(1000);
        SearchButton.click();
        Allure.step("Clicked on the Searched Button");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Importance of Fragile Sticker\"]")));
        boolean SearchResult;

        try{
            SearchResult = SearchContentResult.isDisplayed();;
        }
        catch(Exception e)
        {
            SearchResult = false;
        }

        if (SearchResult)
        {
            System.out.println("***********************************");
            System.out.println("Check 1: Searched Data is Available");
            Assert.assertTrue(true, "Searched Data Found");
            Allure.step("Searched Data is Available");
            System.out.println("Case 3: Searching Done Successfully");
            System.out.println("***********************************");
            System.out.println("");
            Allure.step("Search Functionality Passed");
            Thread.sleep(2000);

        }
        else
        {
            System.out.println("");
            System.out.println("********************************");
            System.out.println("Check 2: Searched Data Not Found");
         //   Assert.assertTrue(false, "Searched Data Not Found");
            softAssert.assertTrue(false, "Searched Data Not Found");

            Allure.step("Searched Data Not Found");
            System.out.println("Case 3: Searching Failed");
            System.out.println("************************");
            System.out.println("");
            Allure.step("Search Functionality Failed");
            Thread.sleep(2000);
        }

        Thread.sleep(3000);
        HomeButton.click();
        softAssert.assertAll();

    }
}
