package DarazUniversity;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DU_Logout extends DU_Wait{

    public DU_Logout(WebDriver driver) {
        DU_Wait.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//*[@class=\"username\"]")
    public WebElement username;

    @FindBy(xpath="//*[@id=\"root\"]/div/div[1]/header/div/div[2]/img[2]")
    public WebElement Logoutbutton;

    public void Logout(WebDriver driver) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"username\"]")));
        Thread.sleep(1000);
        username.click();
        Allure.step("Clicked on the Dropdown button");

        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[1]/header/div/div[2]/img[2]")));
        Logoutbutton.click();
        Allure.step("Clicked on the Logout button");

        System.out.println("********************");
        System.out.println("DU Logout Successful");
        System.out.println("********************");
        Allure.step("Logout Successfully");

    }
}
