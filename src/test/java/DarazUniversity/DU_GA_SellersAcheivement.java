package DarazUniversity;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DU_GA_SellersAcheivement {
    public DU_GA_SellersAcheivement(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[text()=\"Growth Assistant\"]")
    public WebElement GrowthAssistant;

    @FindBy(xpath="//*[text()=\"Seller Achievements\"]")
    public WebElement SellersAcheivement;

    @FindBy(xpath="//*[text()=\"Take this Course and Get a Certificate Now!\"]")
    public WebElement AvailableCourses;

    public void GrowthAssistant(WebDriver driver) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Growth Assistant\"]")));
        Actions action = new Actions(driver);
        action.moveToElement(GrowthAssistant).perform();
        Allure.step("Hovered the Growth Assistant tab on the Navigation bar");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Seller Achievements\"]")));
        SellersAcheivement.click();
        Allure.step("Clicked on the Seller Achievements Module");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Take this Course and Get a Certificate Now!\"]")));
        int CoursesCount = AvailableCourses.findElements(By.xpath("//*[text()=\"Take this Course and Get a Certificate Now!\"]")).size();
        System.out.println("***********************************");
        System.out.println("Seller Can Attempt "+CoursesCount+" More Courses");
        Allure.step("Seller Can attempt " +CoursesCount+ " more courses");

        System.out.println("Case 23: Seller Achievements Module");
        System.out.println("***********************************");
        Allure.step("Seller Achievements Module Passed");

    }
}
