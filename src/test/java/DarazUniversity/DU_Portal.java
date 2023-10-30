package DarazUniversity;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static DarazUniversity.DU_Wait.driver;


public class DU_Portal {

    String excelpath;
    XSSFWorkbook workbook;

    XSSFSheet sheet;

    //public static String Venture = "NP";

    public static String Venture = System.getenv("Venture_Jenkins");

    public DU_Portal(WebDriver driver) {PageFactory.initElements(driver, this);}

/*
    public String getcellurl1() throws IOException {


        excelpath = System.getProperty("user.dir");
        workbook = new XSSFWorkbook(excelpath + "/excel/data.xlsx");

        sheet = workbook.getSheet("PKURL");
        // Venture = "PK";

        String cellData1 = sheet.getRow(0).getCell(0).getStringCellValue();
        workbook.close();
        return cellData1;
    }

 */

/*
    public String getcellurl2() throws IOException {

        excelpath = System.getProperty("user.dir");
        workbook = new XSSFWorkbook(excelpath+"/excel/data.xlsx");
        sheet = workbook.getSheet("LKURL");

        String cellData2 = sheet.getRow(0).getCell(1).getStringCellValue();
        workbook.close();
        System.out.println(cellData2);
        return cellData2;
    }
 */

    public void Portal(WebDriver driver) {


        switch (Venture) {
            case "PK":

                driver.get("https://university.daraz.pk/");
                System.out.println("Launched Daraz University PK Portal");
                Allure.step("Launched Daraz University PK Portal");

                break;

            case "LK":

                driver.get("https://university.daraz.lk/");
                System.out.println("Launched Daraz University LK Portal");
                Allure.step("Launched Daraz University LK Portal");


                break;

            case "NP":

                driver.get("https://university.daraz.com.np/");
                System.out.println("Launched Daraz University NP Portal");
                Allure.step("Launched Daraz University NP Portal");


                break;

            case "BD":

                driver.get("https://university.daraz.com.bd/");
                System.out.println("Launched Daraz University BD Portal");
                Allure.step("Launched Daraz University BD Portal");


                break;
        }

/*
             public void Portal (WebDriver driver, String PK_URL)
            {

                driver.get(PK_URL);
                Allure.step("Launched Daraz University Portal");
            }

 */
    }
}

