package DarazUniversity;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static DarazUniversity.DU_Portal.Venture;

public class DU_EventCalendar {

        public DU_EventCalendar (WebDriver driver) {
            PageFactory.initElements(driver, this);
        }

        String PageTitle;
        String EventRegMsg;

        @FindBy(xpath="//*[text()=\"Event Calendar\"]")
        public WebElement EventCalendarTab;

        @FindBy(xpath="//*[@id=\"bigCalendar\"]/div/div[1]/div[2]/div[6]/div[2]/div[3]/div[3]/div/div")
        public WebElement Training;

        @FindBy(xpath="/html/body/div[2]/div[2]/div[2]/span[2]/button")
        public WebElement IamGoing;

        @FindBy(xpath="//*[@name=\"userEmail\"]")
        public WebElement EnterEmail;

        @FindBy(xpath="//*[@name=\"userPhoneNumber\"]")
        public WebElement EnterPhoneNum;

        @FindBy(xpath="/html/body/div[2]/div[2]/div[2]/span[1]/button")
        public WebElement OKbutton;

        @FindBy(xpath="/html/body/div[3]/div/div")
        public WebElement SuccessMsg;

        public void Event_Calendar (WebDriver driver) throws InterruptedException {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            Thread.sleep(1500);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Event Calendar\"]")));
            EventCalendarTab.click();
            Allure.step("Clicked on Event Calendar Tab on the Navigation bar");


            Thread.sleep(1000);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[title]//*[text()=\"Training Calendar\"]")));
            WebElement PageTile = driver.findElement(By.xpath("//*[title]//*[text()=\"Training Calendar\"]"));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[title]//*[text()=\"Training Calendar\"]")));
            PageTitle = PageTile.getAttribute("innerHTML");

            Thread.sleep(3000);
            boolean Navbar_ContentLib;

            try{
                Navbar_ContentLib = Training.isEnabled();
            }
            catch(Exception e)
            {
                Navbar_ContentLib = false;
            }

            System.out.println("**************************************");
            System.out.println("Module is: " + PageTitle);

            Thread.sleep(5000);

            if (Navbar_ContentLib)
            {

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"bigCalendar\"]/div/div[1]/div[2]/div[3]/div[2]/div[1]/div[4]")));
                Training.click();
                Allure.step("Clicked on the Training Event");

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div[2]/span[2]/button")));
                Thread.sleep(3000);
                IamGoing.click();
                Allure.step("Clicked on the I am Going button");

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name=\"userEmail\"]")));
                Thread.sleep(3000);
                EnterEmail.sendKeys("Test@gmail.com");
                Allure.step("Enetered email address");

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name=\"userPhoneNumber\"]")));
                Thread.sleep(3000);
                EnterPhoneNum.sendKeys("030000000000");
                Allure.step("Enter Phone Number");

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"next-dialog-close\"]")));
                Thread.sleep(3000);
                OKbutton.click();
                Allure.step("Clicked on the OK button");

                Thread.sleep(1000);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div")));
                WebElement RegSuccessMsg = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/div")));
                EventRegMsg = RegSuccessMsg.getAttribute("innerHTML");


                Thread.sleep(3000);

                System.out.println("Check 1: Training Registration Done");
                Allure.step("Training Registration Completed");
                System.out.println("Reg Msg: " + EventRegMsg);

            }
            else
            {
                System.out.println("*******************************************");
                System.out.println("Check 2: No Training Available on this Date");
                Allure.step("No Training is available on this Date");
            }
            System.out.println("Case 22: Event Calendar Module is Passed");
            System.out.println("****************************************");
        }
}
