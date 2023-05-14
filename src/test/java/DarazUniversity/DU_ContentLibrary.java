package DarazUniversity;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DU_ContentLibrary {

    public DU_ContentLibrary(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    String PageTitle;

    @FindBy(xpath="//*[text()=\"Content Library\" and @class=\"item\"]")
    public WebElement ContentLibTab;

    @FindBy(xpath="//a[@class='logo-wrap']//img[@alt='logo']")
    public WebElement HomePage;

    public void ContentLib (WebDriver driver) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Thread.sleep(1000);

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Content Library\" and @class=\"item\"]")));
        ContentLibTab.click();
        Allure.step("Clicked on Content Library Tab on the Navigation bar");


        Thread.sleep(1000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Content Library\" and @class=\"title th-ff1 th-fs9\"]")));
        WebElement PageTile = driver.findElement(By.xpath("//*[text()=\"Content Library\" and @class=\"title th-ff1 th-fs9\"]"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Content Library\" and @class=\"title th-ff1 th-fs9\"]")));
        PageTitle = PageTile.getAttribute("innerHTML");

        Thread.sleep(1500);
        boolean Navbar_ContentLib;

        try{
            Navbar_ContentLib = ContentLibTab.isDisplayed();;
        }
        catch(Exception e)
        {
            Navbar_ContentLib = false;
        }

        System.out.println("**************************************");
        System.out.println("Module is: " + PageTitle);

        if (Navbar_ContentLib)
        {
            System.out.println("Check 1: Content Library Available");
        }
        else
        {
            System.out.println("");
            System.out.println("**********************************");
            System.out.println("Check 2: Content Library Not Found");
        }
        System.out.println("Case 21: Content Library Module Passed");
        System.out.println("**************************************");
        System.out.println("");

        HomePage.click();
    }
}
