package DarazUniversity;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DU_SS_PoliciesAndGuidelines {

    public DU_SS_PoliciesAndGuidelines(WebDriver driver) {PageFactory.initElements(driver, this);}

    String PageTitle;

    @FindBy(xpath="//*[text()=\"Seller Support\" and @class=\"recommend-trigger\"]")
    public WebElement SellerSupport;

    @FindBy(xpath="//*[text()=\"Policies & Guidelines\"]")
    public WebElement PoliciesAndGuidlines;

    @FindBy(xpath="//*[text()=\"Seller Claims Policy\"]")
    public WebElement SellerClaimsPolicy;

    @FindBy(xpath="//*[text()=\"Reference Material\"]")
    public WebElement TutorailMaterial;

    public void DU_PoliciesAndGuideline (WebDriver driver) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Seller Support\" and @class=\"recommend-trigger\"]")));
        Actions action = new Actions(driver);
        action.moveToElement(SellerSupport).perform();
        SellerSupport.click();
        Allure.step("Hovered on the Seller Support Tab on the Navigation bar");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Policies & Guidelines\"]")));
        PoliciesAndGuidlines.click();
        Allure.step("Clicked on the Policies & Guidelines Module");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Seller Claims Policy\"]")));
        SellerClaimsPolicy.click();
        Allure.step("Clicked on the Seller Claims Policy Content");

        Thread.sleep(1000);
        boolean Material;

        try
        {
            Material = TutorailMaterial.isDisplayed();;
        }
        catch(Exception e)
        {
            Material = false;
        }

        if (Material)
        {
            System.out.println("************************************");
            System.out.println("Check 1: Tutorial Material Available");
            Allure.step("Tutorial Material Available");

        }
        else
        {
            System.out.println("Check 2: This Tutorial has no Material Not");
            Allure.step("Tutorial Material Not Found");

        }
        System.out.println("Case 27: Policy & Guidelines Module Passed");
        System.out.println("******************************************");
        Allure.step("Policies & Guidelines Module Passed");
        System.out.println("");
    }

}
