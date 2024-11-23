package com.AI.utils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class DataProviderUtils {

	private static List<Map<String,String>> list = new ArrayList<>();
	//@DataProvider(name = "testDataProvider")
	public Object[]  getData(Method m) throws IOException {

		String 	testcasename = 	m.getName();
		//BIGLIST 
		if(list.isEmpty()) {
			list = ExcelUtils.getTestDetails("data");
	}		//SMALL LIST 
		List<Map<String,String>>  smalllist = new ArrayList<>(list);   // both are same now old method return type and this small list will be same type 
		Predicate<Map<String,String>>      testcasenamenotmatching =  element -> !element.get("testcasename").equalsIgnoreCase(testcasename);
		Predicate<Map<String,String>>     isExecuteColoumnNO =  e -> e.get("execute").equalsIgnoreCase("no");
		smalllist.removeIf(testcasenamenotmatching.or(isExecuteColoumnNO));
		return smalllist.toArray();

	}

}
