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

public class DU_CatMaximisingSales {

    public DU_CatMaximisingSales(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    String PageTitle;

    @FindBy(xpath="//*[text()=\"Categories\"]")
    public WebElement Categories;

    @FindBy(xpath="//*[text()=\"Maximising Sales\"]")
    public WebElement MaximisingSalesModule;

    @FindBy(xpath="//*[text()=\"View all \"]")
    public WebElement Viewall;

    @FindBy(xpath="//input[@placeholder='Search by Tag']")
    public WebElement Tag_Filter;

    @FindBy(xpath="//span[normalize-space()='Management']")
    public WebElement Tag_Value;

    @FindBy(xpath="//div[@id='pagination']")
    public WebElement Focus_Shift;

    @FindBy(xpath="//*[text()='Why is Customer Service Important?']")
    public WebElement Tutorial_PK;

    @FindBy(xpath="//*[text()=\"Guide to creating Collectible Vouchers\"]")
    public WebElement Tutorial_LK;

    @FindBy(xpath="//*[text()=\"Boost your Products using Seller Picks \"]")
    public WebElement Tutorial_BD;

    @FindBy(xpath="//*[text()=\"Boost your Products using Seller Picks \"]")
    public WebElement Tutorial_NP;

    @FindBy(xpath="//*[text()=\"Reference Material\"]")
    public WebElement TutorialMaterial1;


    public void MaximisingSales(WebDriver driver) throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Categories\"]")));
        Categories.click();
        Allure.step("Clicked on Categories Tab on the Navigation bar");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Maximising Sales\"]")));
        MaximisingSalesModule.click();
        Allure.step("Clicked on Maximising Sales module");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"View all \"]")));
        Viewall.click();
        Allure.step("Clicked on View All button");

        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//head//*[text()=\"Maximising Sales\"]")));
        WebElement PageTile = driver.findElement(By.xpath("//head//*[text()=\"Maximising Sales\"]"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//head//*[text()=\"Maximising Sales\"]")));
        PageTitle = PageTile.getAttribute("innerHTML");

        String Venture = DU_Portal.Venture;

        switch (Venture)
        {
            case "PK":

                Thread.sleep(1500);
                Tag_Filter.click();

                Thread.sleep(1500);
                Tag_Value.click();

                Thread.sleep(1500);
                Focus_Shift.click();

                Thread.sleep(1500);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Why is Customer Service Important?']")));
                Tutorial_PK.click();
                Allure.step("Clicked on Guide to Creating Collectible Vouchers tutorial");

                break;


            case "BD":

                Thread.sleep(1500);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Boost your Products using Seller Picks \"]")));
                Tutorial_BD.click();
                Allure.step("Clicked on Guide to Creating Collectible Vouchers tutorial");

                break;

            case "LK":

                Thread.sleep(1500);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("Guide to creating Collectible Vouchers\"]")));
                Tutorial_LK.click();
                Allure.step("Clicked on Guide to Creating Collectible Vouchers tutorial");

                break;

            case "NP":

                Thread.sleep(1500);
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Boost your Products using Seller Picks \"]")));
                Tutorial_NP.click();
                Allure.step("Clicked on Guide to Creating Collectible Vouchers tutorial");

                break;
        }

        Thread.sleep(1500);
        boolean Material1;

        try
        {
            Material1 = TutorialMaterial1.isDisplayed();
        }
        catch(Exception e)
        {
            Material1 = false;
        }

        System.out.println("************************************");
        System.out.println("Module is: " + PageTitle);

        if (Material1)
        {
            System.out.println("Check 1: Tutorial Material Available");
            Allure.step("Tutorial Material Available");
            System.out.println("Case 14: Maximising Sales Module Passed");
            System.out.println("***************************************");
            Allure.step("Maximising Sales Module Passed");
            System.out.println("");

        }
        else
        {
            System.out.println("");
            System.out.println("************************************");
            System.out.println("Check 2: Tutorial Material Not Found");
            Allure.step("Tutorial Material Not Found");
            System.out.println("Case 14: Maximising Sales Module Failed");
            System.out.println("***************************************");
            Allure.step("Maximising Sales Module Failed");
            System.out.println("");

            softAssert.assertFalse(true, "Tutorial Material Not Found");
        }
        softAssert.assertAll();
    }
}

