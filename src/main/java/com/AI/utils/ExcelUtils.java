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


	public static List<Map<String,String>>  getTestDetails(String sheetname) throws IOException {


		//initalising the list , as this is going to be our return type
		List<Map<String,String>>   list = null;     //  [           ]

		//later return type will give list like below
		// [{},{},{}]


		//telling machine to go to excel path
		FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelpath()); // 	private static final String EXCELFILEPATH = "C:\\Users\\kranthi.katta\\OneDrive\\Desktop\\testdatafordataprovider.xlsx";

		// openeng workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// getting sheet inside the work book

		XSSFSheet sheet = 	wb.getSheet(sheetname);

		//getting last rows count
		int rownumber = 	sheet.getLastRowNum();

		//getting last column count
		int columnnumber = sheet.getRow(0).getLastCellNum();


		// inside list we are string map of string , string or string , object or object .object
		Map<String,String>  map = null;

		//initialise the array list also here
		list = new ArrayList<>();



		// in excel sheet how row and column works .

		// FOR EXAMPLE
		//  0,0 | 0,1    | 0,2
		//0 A   |   B    |C
		//1
		//2
		//3


//		| (0,0) | (0,1) | (0,2) | (0,3) | (0,4) | (0,5) | (0,6) | (0,7) | (0,8) | (0,9)  |
//|-------|-------|-------|-------|-------|-------|-------|-------|-------|--------|
//| (1,0) | (1,1) | (1,2) | (1,3) | (1,4) | (1,5) | (1,6) | (1,7) | (1,8) | (1,9)  |
//| (2,0) | (2,1) | (2,2) | (2,3) | (2,4) | (2,5) | (2,6) | (2,7) | (2,8) | (2,9)  |
//| (3,0) | (3,1) | (3,2) | (3,3) | (3,4) | (3,5) | (3,6) | (3,7) | (3,8) | (3,9)  |
//| (4,0) | (4,1) | (4,2) | (4,3) | (4,4) | (4,5) | (4,6) | (4,7) | (4,8) | (4,9)  |
//| (5,0) | (5,1) | (5,2) | (5,3) | (5,4) | (5,5) | (5,6) | (5,7) | (5,8) | (5,9)  |
//| (6,0) | (6,1) | (6,2) | (6,3) | (6,4) | (6,5) | (6,6) | (6,7) | (6,8) | (6,9)  |
//| (7,0) | (7,1) | (7,2) | (7,3) | (7,4) | (7,5) | (7,6) | (7,7) | (7,8) | (7,9)  |
//| (8,0) | (8,1) | (8,2) | (8,3) | (8,4) | (8,5) | (8,6) | (8,7) | (8,8) | (8,9)  |
//| (9,0) | (9,1) | (9,2) | (9,3) | (9,4) | (9,5) | (9,6) | (9,7) | (9,8) | (9,9)  |



		for(int i = 1 ; i <= rownumber ; i++) {



			map  = new HashMap<>();

			// {   }

//[  { "tester": "kranthi", "testcase": "1", "execute": "yes", "browser": "chrome", "specialchar": "?" },  { "tester": "shravan", "testcase": "2", "execute": "no", "browser": "firefox", "specialchar": "" }]


			//tester	testcase	execute	browser	specialchar
			//kranthi	1	yes	chrome	?
			//shravan	2	no	firefox


			for(int j = 0 ; j<= columnnumber ;j++) {

				//Explanation of getRow() and getCell()
				//getRow(int rowIndex):
				//
				//This method retrieves a specific row from the sheet.

				//**************************  GETROW(0) BASCIALLY MEANS GETTING FIRSTROW CELL VALUE
				//The index starts from 0, so getRow(0) gets the first row, getRow(1) gets the second row, and so on.
				//getCell(int cellIndex):
				//
				//This method retrieves a specific cell from the row.
				//The index also starts from 0, so getCell(0) gets the first cell in the row, getCell(1) gets the second cell, etc.
				//How It Works in Your Code
				//Outer Loop (for (int i = 1; i <= rownumber; i++)):
				//
				//Starts from 1 because 0 is typically reserved for the header row (in your case).
				//Each iteration corresponds to a different row in your sheet.
				//Inner Loop (for (int j = 0; j <= columnnumber; j++)):
				//
				//Iterates through each column in the current row i.
				//Retrieves the column name (key) from the header row using sheet.getRow(0).getCell(j).
				//Retrieves the value from the current row i and column j using sheet.getRow(i).getCell(j).
				//Summary of Your Code's Purpose
				//You are building a Map where:
				//The key is the name of the column (e.g., "tester", "testcase", "execute", etc.), taken from the first row.
				//The value is the corresponding cell value from the current row (indexed by i).
				//Why You Call getRow(0) Again
				//You call getRow(0) again because you want to access the header row, which contains the keys for your map. Each inner loop iteration gives you the values from the respective cells in the current row while always referring to the first row for the keys.
				//
				//Example
				//Given your table structure:
				//
				//lua
				//Copy code
				//| tester  | testcase | execute | browser | specialchar |
				//|---------|----------|---------|---------|--------------|
				//| kranthi | 1        | yes     | chrome  | ?            |
				//| shravan | 2        | no      | firefox |              |
				//In the first iteration of the outer loop (i = 1):
				//key will be "tester" and value will be "kranthi".
				//key will be "testcase" and value will be "1".
				//This continues until all columns for the first row are processed.
				//Let me know if you need any further clarification or help with this code!

				String key = sheet.getRow(0).getCell(j).getStringCellValue();

				System.out.println("got the key as : " + key);
				String value =  sheet.getRow(i).getCell(j).getStringCellValue();

				System.out.println("got the value as : " + value);

				System.out.println("storing inside the map");

				map.put(key, value);



			}

			list.add(map);
		}


		System.out.println(list.size());


		return list ;



	}
}
