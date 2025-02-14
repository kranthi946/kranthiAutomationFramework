package com.AI.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.AI.constants.FrameworkConstants;

public class ExcelUtils {
	private ExcelUtils() {
	}


	public static List<Map<String, String>> getTestDetails(String sheetname) throws IOException {


		//initalising the list , as this is going to be our return type
		List<Map<String, String>> list = null;     //  [           ]

		//later return type will give list like below
		// [{},{},{}]


		//telling machine to go to excel path
		FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelpath()); // 	private static final String EXCELFILEPATH = "C:\\Users\\kranthi.katta\\OneDrive\\Desktop\\testdatafordataprovider.xlsx";

		// openeng workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// getting sheet inside the work book

		XSSFSheet sheet = wb.getSheet(sheetname);

		//getting last rows count
		int rownumber = sheet.getLastRowNum();

		//getting last column count
		int columnnumber = sheet.getRow(0).getLastCellNum();


		// inside list we are storing  map of string , string or string , object or object .object
		Map<String, String> map = null;

		//initialise the array list also here
		list = new ArrayList<>();



	/*	The first row in the Excel UI (Row 1) is Row 0 in code.
		The second row in the Excel UI (Row 2) is Row 1 in code.*/

		/*
		* Excel UI (User Interface):

Row 1: Is where you have the headers (e.g., tester, testcase, execute, etc.).
Row 2 onwards: Is where you have your actual data (e.g., kranthi, 1, yes, chrome, ?).
		* */

		for (int i = 1; i <= rownumber; i++) {  // Start from 1 because row 0 is header


			map = new HashMap<>();

			for (int j = 0; j < columnnumber; j++) {  // Loop through columns (start from 0)
				// Row 0 contains the header values (e.g., "tester", "testcase")
				String key = sheet.getRow(0).getCell(j).getStringCellValue();  // Column header
				// Row i contains the actual data values (e.g., "kranthi", "1", etc.)
				String value = sheet.getRow(i).getCell(j).getStringCellValue();  // Data for current row
				map.put(key, value);
			}

			// Add this map (which contains key-value pairs for each row) to the list
			list.add(map);
		}

//[  { "tester": "kranthi", "testcase": "1", "execute": "yes", "browser": "chrome", "specialchar": "?" },
//
//
// { "tester": "shravan", "testcase": "2", "execute": "no", "browser": "firefox", "specialchar": "" }]


			//tester	testcase	execute	browser	specialchar
			//kranthi	1	yes	chrome	?
			//shravan	2	no	firefox

			System.out.println(list.size());


			return list;


		}
	}





	/*
	*
	* //		| (0,0) | (0,1) | (0,2) | (0,3) | (0,4) | (0,5) | (0,6) | (0,7) | (0,8) | (0,9)  |
//|-------|-------|-------|-------|-------|-------|-------|-------|-------|--------|
//| (1,0) | (1,1) | (1,2) | (1,3) | (1,4) | (1,5) | (1,6) | (1,7) | (1,8) | (1,9)  |     1 row looks like but in programming 0 based so its 0 row , where our tester testcase present so i value starts from i = 1
//| (2,0) | (2,1) | (2,2) | (2,3) | (2,4) | (2,5) | (2,6) | (2,7) | (2,8) | (2,9)  |     j have to starts from 0 because our (k,v) looks header as key  and    2 , 3 , 4row as value
//| (3,0) | (3,1) | (3,2) | (3,3) | (3,4) | (3,5) | (3,6) | (3,7) | (3,8) | (3,9)  |
//| (4,0) | (4,1) | (4,2) | (4,3) | (4,4) | (4,5) | (4,6) | (4,7) | (4,8) | (4,9)  |
//| (5,0) | (5,1) | (5,2) | (5,3) | (5,4) | (5,5) | (5,6) | (5,7) | (5,8) | (5,9)  |
//| (6,0) | (6,1) | (6,2) | (6,3) | (6,4) | (6,5) | (6,6) | (6,7) | (6,8) | (6,9)  |
//| (7,0) | (7,1) | (7,2) | (7,3) | (7,4) | (7,5) | (7,6) | (7,7) | (7,8) | (7,9)  |
//| (8,0) | (8,1) | (8,2) | (8,3) | (8,4) | (8,5) | (8,6) | (8,7) | (8,8) | (8,9)  |
//| (9,0) | (9,1) | (9,2) | (9,3) | (9,4) | (9,5) | (9,6) | (9,7) | (9,8) | (9,9)  |
*
*
* */


/*
*
* tester 	0,0 	key 	row i 0 , j 0   -> (k,v)  -> (tester ,v)
	        1,0	value 	row 1 , j 0       -> (k,v)  -> (tester ,kranthi)
	*
	*
	* */


/*
always string wont be available :

import org.apache.poi.ss.usermodel.*;

public static List<Map<String, String>> getTestDetails(String sheetname) throws IOException {
    List<Map<String, String>> list = new ArrayList<>();

    // Open the Excel file
    FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelpath());
    XSSFWorkbook wb = new XSSFWorkbook(fis);

    // Get the sheet
    XSSFSheet sheet = wb.getSheet(sheetname);

    int rownumber = sheet.getLastRowNum();
    int columnnumber = sheet.getRow(0).getLastCellNum();

    Map<String, String> map = null;

    // Loop through the rows
    for (int i = 1; i <= rownumber; i++) {
        map = new HashMap<>();

        // Loop through the columns
        for (int j = 0; j < columnnumber; j++) {

            // Get the column header from row 0 (header row)
            String key = sheet.getRow(0).getCell(j).getStringCellValue();

            // Get the value from the current row and column
            String value = getCellValueAsString(sheet.getRow(i).getCell(j));

            // Put the key-value pair in the map
            map.put(key, value);
        }

        // Add the map to the list
        list.add(map);
    }

    return list;
}

// Method to handle different cell types and convert to String
private static String getCellValueAsString(Cell cell) {
    if (cell == null) {
        return "";  // Return an empty string for null cells
    }

    // Handle different cell types
    switch (cell.getCellTypeEnum()) {
        case STRING:
            return cell.getStringCellValue(); // Get string value
        case NUMERIC:
            // Check if it's a date
            if (DateUtil.isCellDateFormatted(cell)) {
                return cell.getDateCellValue().toString(); // Convert date to string
            } else {
                return String.valueOf(cell.getNumericCellValue()); // Convert number to string
            }
        case BOOLEAN:
            return String.valueOf(cell.getBooleanCellValue()); // Convert boolean to string
        case FORMULA:
            return cell.getCellFormula(); // Get formula (as a string)
        case BLANK:
            return "";  // Return an empty string for blank cells
        default:
            return "";  // Return an empty string if the type is unknown
    }
}
*/





