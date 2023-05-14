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
import java.util.Set;

public class DU_FT_ContactUS {

    public DU_FT_ContactUS(WebDriver driver) {
        PageFactory.initElements(driver, this);}

    @FindBy(xpath="//*[text()=\"Seller Support\" and @class=\"recommend-trigger\"]")
    public WebElement SellerSupport;

    @FindBy(xpath="//*[text()=\"Seller Claims\"]")
    public WebElement SellerClaim;

    @FindBy(xpath="//*[text()=\"Please select\"]")
    public WebElement Dropdown1;

    @FindBy(xpath="//li[normalize-space()='Local Seller']")
    public WebElement LocalSeller;

    @FindBy(xpath="//div[@id='root_chooseATopicYouWantUsToHelpYouWith']//div[@class='ant-select-selection__placeholder'][normalize-space()='Please select an option from the dropdown menu']")
    public WebElement Dropdown2;

    @FindBy(xpath="//li[normalize-space()='Delivery']")
    public WebElement Delivery;

    @FindBy(xpath="//*[text()=\"Dex - FBD pickup pending\"]")
    public WebElement DexCheckBox;

    @FindBy(xpath="//div[@id='root_inboundOrderNumber']//div[@class='ant-select-selection__rendered']")
    public WebElement Dropdown3;

    @FindBy(xpath="//*[text()='IO0220210928242043985313']")
    public WebElement DropdownData;

    @FindBy(xpath="//input[@class='ant-calendar-picker-input ant-input']")
    public WebElement Dropdown4;

    @FindBy(xpath="//*[@class=\"ant-calendar-today-btn \"]")
    public WebElement NowButton;

    @FindBy(xpath="//textarea[@placeholder='Please help us understand the problem.']")
    public WebElement ComplaintBox;

    public void DU_SellerClaims (WebDriver driver) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // ArrayList<String> Tab = new ArrayList<String>(driver.getWindowHandles());

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Seller Support\" and @class=\"recommend-trigger\"]")));
        Actions action = new Actions(driver);
        action.moveToElement(SellerSupport).perform();
        Allure.step("Hovered on the Seller Support Tab on the Navigation bar");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Seller Claims\"]")));
        SellerClaim.click();
        Allure.step("Clicked on the Seller Claims Module");

        Thread.sleep(8000);
        Set<String> handles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();

        for (String handle : handles)
        {
            if (!handle.equals(currentHandle))
            {
                driver.switchTo().window(handle);
            }
        }

        Thread.sleep(1500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Please select\"]")));
        //driver.switchTo().frame(Dropdown1);
        Dropdown1.click();
        Allure.step("Clicked on the Sellers Type");


        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[normalize-space()='Local Seller']")));
        LocalSeller.click();
        Allure.step("Selected the Local Seller from the Seller Type dropdown");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='root_chooseATopicYouWantUsToHelpYouWith']//div[@class='ant-select-selection__placeholder'][normalize-space()='Please select an option from the dropdown menu']")));
        Dropdown2.click();
        Allure.step("Clicked on the Topic selection dropdown");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[normalize-space()='Delivery']")));
        Delivery.click();
        Allure.step("Selected the Delivery topic from the Topic dropdown");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Dex - FBD pickup pending\"]")));
        DexCheckBox.click();
        Allure.step("Clicked on the Dex Checkbox from the Problem type list");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='root_inboundOrderNumber']//div[@class='ant-select-selection__rendered']")));
        Dropdown3.click();
        Allure.step("Clicked on the Inbound Order Number dropdown");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='IO0220210928242043985313']")));
        DropdownData.click();
        Allure.step("Selected the Inbound Order Number from the Order Numbers list");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='ant-calendar-picker-input ant-input']")));
        Dropdown4.click();
        Allure.step("Clicked on the Calender to Select the Time slot");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"ant-calendar-today-btn \"]")));
        NowButton.click();
        Allure.step("Selected the time slot");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@placeholder='Please help us understand the problem.']")));
        ComplaintBox.sendKeys("Test Complain");
        Allure.step("Entered the text in the Complaint Box");

        System.out.println("************************************");
        System.out.println("Case 29: Seller Claims Module Passed");
        System.out.println("************************************");
        Allure.step("Contact US Module Passed");

        Thread.sleep(2000);
        driver.close();
        //driver.switchTo().window(Tab.get(0));
        driver.switchTo().window(currentHandle);

    }
}
