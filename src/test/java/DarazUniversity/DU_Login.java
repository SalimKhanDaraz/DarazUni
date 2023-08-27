package DarazUniversity;

import io.qameta.allure.Allure;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.Base64;

import static DarazUniversity.DU_Portal.Venture;

public class DU_Login extends ExcelData  {


    /*
    public DU_Login(WebDriver driver) {
       DU_Wait.driver = driver;
        PageFactory.initElements(driver, this);
    }

     */

    public DU_Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@class=\"wt-mask\"]")
    public WebElement Popupclose;

    @FindBy(xpath="//*[@class=\"content page-body-pc\"]//*[text()=\"Login\"]")
    public WebElement LoginButton;

    @FindBy(xpath="//*[@placeholder=\"Please enter\" and @type=\"text\"]")
    public WebElement UserID;

    @FindBy(xpath="//*[@placeholder=\"Please enter\" and @type=\"password\"]")
    public WebElement Password;

    @FindBy(xpath="//*[@id=\"topSideContent\"]/div/div[2]/div[2]/div")
    public WebElement LoginClick;
/*
    public void getrowcount() throws IOException {

        excelpath = System.getProperty("user.dir");
        workbook = new XSSFWorkbook(excelpath+"/excel/data.xlsx");
        sheet = workbook.getSheet("Credentials");
        int rowcount = sheet.getPhysicalNumberOfRows();
        System.out.println(rowcount);

    }

    public String getcelldata1() throws IOException {

        excelpath = System.getProperty("user.dir");
        workbook = new XSSFWorkbook(excelpath+"/excel/data.xlsx");
        sheet = workbook.getSheet("Credentials");
        String cellData1 = sheet.getRow(1).getCell(0).getStringCellValue();
        workbook.close();
        return cellData1;
    }

    public String getcelldata2() throws IOException {

        excelpath = System.getProperty("user.dir");
        workbook = new XSSFWorkbook(excelpath+"/excel/data.xlsx");
        sheet = workbook.getSheet("Credentials");
        String cellData2 = sheet.getRow(1).getCell(1).getStringCellValue();
        workbook.close();
        return cellData2;
    }
 */

    // Testing

    public void Login1 (WebDriver driver,String U_ID, String PSW) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"step-close\"]")));
        Popupclose.click();
        Allure.step("Closed the Popup Window on the Home Page");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[1]/header/div/button[1]")));
        LoginButton.click();
        Allure.step("Clicked on Login button on the Home Page to redirect to the Login Page");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder=\"Please enter\" and @type=\"text\"]")));
        UserID.sendKeys(U_ID);
        Allure.step("Entered the User Name in text field");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder=\"Please enter\" and @type=\"password\"]")));
        Password.sendKeys(PSW);
        Allure.step("Entered the Password in text field");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"topSideContent\"]/div/div[2]/div[2]/div")));
        LoginClick.click();
        Allure.step("Clicked on the Login button");

        System.out.println("************************************");
        System.out.println("Daraz University Launched Successful");
        System.out.println("************************************");
        System.out.println("");
        System.out.println("**************************");
        System.out.println("Case 1: Login Successfully");
        System.out.println("**************************");
        Allure.step("Login Successfully");
        System.out.println("");
        //Thread.sleep(2000);

    }

    static String decodedusername( String username)
    {
        byte[] decodedpassword = Base64.getDecoder().decode(username);
        return (new String(decodedpassword));
    }

    static String decodedpassword( String password)
    {
        byte[] decodedpassword = Base64.getDecoder().decode(password);
        return (new String(decodedpassword));
    }

    public void Login2 (WebDriver driver) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        /*
        Thread.sleep(1500);
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"step-close\"]")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"wt-mask\"]")));
        Popupclose.click();
        Allure.step("Closed the Popup Window on the Home Page");

 */


        switch (Venture) {
            case "PK":

                driver.get("https://sellercenter.daraz.pk/v2/seller/login?redirect_url=https%3A%2F%2Funiversity.daraz.pk%2FpersonalRecommend\n");

                break;

            case "LK":

                driver.get("https://sellercenter.daraz.lk/v2/seller/login?redirect_url=https%3A%2F%2Funiversity.daraz.lk%2FpersonalRecommend");

                break;

            case "NP":

                driver.get("https://sellercenter.daraz.com.np/v2/seller/login?redirect_url=https%3A%2F%2Funiversity.daraz.com.np%2FpersonalRecommend");

                break;

            case "BD":

                driver.get("https://sellercenter.daraz.com.bd/v2/seller/login?redirect_url=https%3A%2F%2Funiversity.daraz.com.bd%2FpersonalRecommend");

                break;
        }



/*
        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"content page-body-pc\"]//*[text()=\"Login\"]")));
        LoginButton.click();
        Allure.step("Clicked on Login button on the Home Page to redirect to the Login Page");


 */
        Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder=\"Please enter\" and @type=\"text\"]")));
        UserID.sendKeys(decodedusername("c3RyZXNzdGVzdDI3MkBzZ2xpdmV0ZXN0LmNvbQ=="));
        Allure.step("Entered the User Name in text field");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder=\"Please enter\" and @type=\"password\"]")));
        Password.sendKeys(decodedpassword("bHpkQDEyMzQ="));
        Allure.step("Entered the Password in text field");

        Thread.sleep(1500);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"topSideContent\"]/div/div[2]/div[2]/div")));
        LoginClick.click();
        Allure.step("Clicked on the Login button");

        System.out.println("************************************");
        System.out.println("Daraz University Launched Successful");
        System.out.println("************************************");
        System.out.println("");
        System.out.println("**************************");
        System.out.println("Case 1: Login Successfully");
        System.out.println("**************************");
        Allure.step("Login Successfully");
        System.out.println("");
        //Thread.sleep(2000);

    }

}
