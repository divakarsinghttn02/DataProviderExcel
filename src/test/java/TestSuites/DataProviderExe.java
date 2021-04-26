package TestSuites;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataProviderExe {

    @Test(dataProvider = "data")
    public void integrationTest(Map<Object, Object> map) {
        System.out.println("-------------Test case started ----------------");
        System.out.println(map.get("UserName"));
        System.out.println(map.get("Password"));


        System.out.println("-------------Test case Ended ----------------");

    }

    @DataProvider(name = "data")
    public Object[][] dataSupplier() throws IOException {

        File file = new File("/home/ttn/Assignment/src/test/TestData/sample1.xlsx");
        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(1);
        wb.close();
        int lastRowNum = sheet.getLastRowNum();
        int lastCellNum = sheet.getRow(0).getLastCellNum();
        Object[][] obj = new Object[lastRowNum][1];

        for (int i = 0; i < lastRowNum; i++) {
            Map<Object, Object> dataMap = new HashMap<>();
            for (int j = 0; j < lastCellNum; j++) {
                dataMap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i + 1).getCell(j).toString());
            }
            obj[i][0] = dataMap;

        }
        return obj;
    }

}
