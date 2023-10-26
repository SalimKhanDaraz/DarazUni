package DarazUniversity;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DU_FT_DarazBlog {

    public DU_FT_DarazBlog(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[@class=\"menu-link\" and text()=\"Daraz Blog\"]")
    public WebElement DarazBlog_Button;

    public void DarazBlog (WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(3000);

        js.executeScript("arguments[0].scrollIntoView();", DarazBlog_Button);
        //js.executeScript("arguments[0].scrollIntoView();", AboutUS);

        Thread.sleep(2000);
        DarazBlog_Button.click();
       // System.out.println("Daraz Blog Page 1: "+driver.getTitle());

        Thread.sleep(2000);
        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();

        for (String handle : handles)
        {
            if (!handle.equals(currentHandle))
            {
                driver.switchTo().window(handle);
            }
        }

       // System.out.println("Daraz Blog Page 2: "+driver.getTitle());
      //  List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //driver.switchTo().window(tabs.get(3));

        Thread.sleep(8000);

        String Venture = DU_Portal.Venture;

        switch (Venture)
        {

            case "PK":

        if (driver.findElements(By.xpath("//div[@class=\"swiper-wrapper\"]")).size()>0)
        {
            System.out.println("*******************************************************");
            System.out.println("Check 1: All the Data in Daraz Blog module is Available");
            Allure.step("All of the Data in the Daraz Blog module is Available");
            System.out.println("Case 4: Daraz Blog module Passed");
            System.out.println("*********************************");
            System.out.println("");
            Allure.step("Daraz Blog module Passed");
        }
        else
        {
            System.out.println("*******************************************************");
            System.out.println("Check 2: No data in the Daraz Blog module is Available");
            Allure.step("No data in the Daraz Cares Blog is Available");
            System.out.println("Case 30: Daraz Cares Blog Failed");
            System.out.println("**********************************");
            System.out.println("");
            Allure.step("Daraz Blog module Failed");

            }
        break;


            case "BD":

                if (driver.findElements(By.xpath("//div[@class=\"vc_row wpb_row vc_row-fluid\"]")).size()>0)
                {
                    System.out.println("*******************************************************");
                    System.out.println("Check 1: All the Data in Daraz Blog module is Available");
                    Allure.step("All of the Data in the Daraz Blog module is Available");
                    System.out.println("Case 4: Daraz Blog module Passed");
                    System.out.println("*********************************");
                    System.out.println("");
                    Allure.step("Daraz Blog module Passed");
                }
                else
                {
                    System.out.println("*******************************************************");
                    System.out.println("Check 2: No data in the Daraz Blog module is Available");
                    Allure.step("No data in the Daraz Cares Blog is Available");
                    System.out.println("Case 30: Daraz Cares Blog Failed");
                    System.out.println("**********************************");
                    System.out.println("");
                    Allure.step("Daraz Blog module Failed");

                }
                break;

            case "LK":

                if (driver.findElements(By.xpath("//*[@class=\"elementor-widget-container\"]")).size()>0)
                {
                    System.out.println("*******************************************************");
                    System.out.println("Check 1: All the Data in Daraz Blog module is Available");
                    Allure.step("All of the Data in the Daraz Blog module is Available");
                    System.out.println("Case 4: Daraz Blog module Passed");
                    System.out.println("*********************************");
                    System.out.println("");
                    Allure.step("Daraz Blog module Passed");
                }
                else
                {
                    System.out.println("*******************************************************");
                    System.out.println("Check 2: No data in the Daraz Blog module is Available");
                    Allure.step("No data in the Daraz Cares Blog is Available");
                    System.out.println("Case 30: Daraz Cares Blog Failed");
                    System.out.println("**********************************");
                    System.out.println("");
                    Allure.step("Daraz Blog module Failed");

                }
                break;

            case "NP":

                if (driver.findElements(By.xpath("//div[@class=\"wpb_wrapper\"]")).size()>0)
                {
                    System.out.println("*******************************************************");
                    System.out.println("Check 1: All the Data in Daraz Blog module is Available");
                    Allure.step("All of the Data in the Daraz Blog module is Available");
                    System.out.println("Case 4: Daraz Blog module Passed");
                    System.out.println("*********************************");
                    System.out.println("");
                    Allure.step("Daraz Blog module Passed");
                }
                else
                {
                    System.out.println("*******************************************************");
                    System.out.println("Check 2: No data in the Daraz Blog module is Available");
                    Allure.step("No data in the Daraz Cares Blog is Available");
                    System.out.println("Case 30: Daraz Cares Blog Failed");
                    System.out.println("**********************************");
                    System.out.println("");
                    Allure.step("Daraz Blog module Failed");

                }
                break;

        }

       // driver.close();
        softAssert.assertAll();

        driver.close();
        driver.switchTo().window(currentHandle);
    }
}
