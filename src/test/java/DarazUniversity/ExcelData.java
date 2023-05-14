package DarazUniversity;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelData {

    String excelpath;
    XSSFWorkbook workbook;

    XSSFSheet sheet;

    public void getrowcount() throws IOException {

        excelpath = System.getProperty("user.dir");
        workbook = new XSSFWorkbook(excelpath+"/excel/data.xlsx");
        sheet = workbook.getSheet("Credentials");
        int rowcount = sheet.getPhysicalNumberOfRows();
       // System.out.println(rowcount);

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
}
