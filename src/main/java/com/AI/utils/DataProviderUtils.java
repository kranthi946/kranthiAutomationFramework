package com.AI.utils;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DataProviderUtils {

	private static List<Map<String,String>> list = new ArrayList<>();



	/*@Test(dataProvider = "testDataProvider", dataProviderClass = DataProviderUtils.class)
public void testCase1(Map<String, String> testData) {
    System.out.println("Browser: " + testData.get("browser"));
}

	* */
	@DataProvider(name = "testDataProvider")
	public Object[]  getData(Method m) throws IOException {




				String testcasename = m.getName();

				// Check if the list is empty, and load data if needed

		//This approach guarantees that you won't encounter a NullPointerException when calling isEmpty().
		if (list == null) {
			// Load the data if list is null
			list = ExcelUtils.getTestDetails("data");

			// If list is still null or empty, log an error and return an empty array
			if (list == null || list.isEmpty()) {
				System.err.println("No data found in the Excel file.");
				return new Object[0];  // Exit the method early with an empty array
			}
		}

				// Create a small list that holds the filtered results
				List<Map<String, String>> smalllist = new ArrayList<>(list);


	/*	List<Map<String, String>>	filteredArrayofsmalllist = smalllist.stream().filter(element -> !element.get("testcasename").equalsIgnoreCase(testcasename) || element.get("execute").equalsIgnoreCase("no")).map(Map::copyOf).toArray(Map[]::new);
			return filteredArrayofsmalllist;*/

		// Define predicates for filtering
				Predicate<Map<String, String>> testcasenamenotmatching = element -> !element.get("testcasename").equalsIgnoreCase(testcasename);
				Predicate<Map<String, String>> isExecuteColoumnNO = e -> e.get("execute").equalsIgnoreCase("no");

				// Remove elements that don't match the test case name or have "execute" as "no"
				smalllist.removeIf(testcasenamenotmatching.or(isExecuteColoumnNO));

				// Convert to an array of Maps and return

		/*
		//Map[] array = 	smalllist.toArray(new Map[smalllist.size()]);

		Map<String, String>[] array = 	smalllist.toArray(Map[]::new);
		* */
				return smalllist.toArray(new Map[0]);    // if we wont provide map here then the resultant will be array object form , so when you call this

		//map in the test class , you cant call through key and value using get method.

			}
		}


		/*This is not recommended because toArray() without a type argument returns an Object[], which is not type-safe. You should specify the type of array explicitly to ensure the returned array has the correct type.
Better Approach: You can use:
return smalllist.toArray(new Map[smalllist.size()]);
This ensures that the returned array is of type Map<String, String>[] and avoids any potential casting issues later.*/

	//	return smalllist.toArray();


		// Map<String, String>[] smallArray = smalllist.toArray(new Map[smalllist.size()]);





//Another way of writing code :
/*

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class YourClass {

    // Assuming this list is populated from an external source, e.g., Excel
    private static List<Map<String, String>> list = new ArrayList<>();

    //@DataProvider(name = "testDataProvider")
    public Object[] getData(Method m) throws IOException {
        String testcasename = m.getName();

        // If the list is empty, fetch test details (Excel or similar source)
        if (list.isEmpty()) {
            list = ExcelUtils.getTestDetails("data");
        }

        // Filtering the list without using Predicate
        List<Map<String, String>> smalllist = new ArrayList<>(list);

        // Directly use filter() with the lambda expressions for your conditions
        Map<String, String>[] filteredArray = smalllist.stream()
            // Apply the filtering conditions directly in the filter method
            .filter(element -> !element.get("testcasename").equalsIgnoreCase(testcasename)
                || element.get("execute").equalsIgnoreCase("no"))
            // Optionally make each map unmodifiable
            .map(Map::copyOf)  // Java 10+ method for creating unmodifiable maps   or        .map(Collections::unmodifiableMap)
            .toArray(Map[]::new);  // Collect the results into an array

        // Optionally print the array to verify the result
        System.out.println(Arrays.toString(filteredArray));

        return filteredArray;
    }
}

* */


/*1. What is a List in Java?
A List in Java is a collection that can hold multiple items. These items are ordered, and you can add, remove, and access them by their position in the list.

For example, let's say you have a list of numbers:

java
Copy code
List<Integer> numberList = new ArrayList<>();
numberList.add(1);
numberList.add(2);
numberList.add(3);
So, numberList looks like this:

csharp
Copy code
[1, 2, 3]
2. What is an Array in Java?
An Array in Java is a fixed-size container that can hold elements of a specific type (e.g., int[], String[], etc.). Once you create an array, its size cannot change.

For example:

java
Copy code
int[] numberArray = new int[3];
This array has a fixed size of 3, and you can only store 3 integers in it.

3. How to Convert a List to an Array?
Now, we will convert a List to an Array. The key thing to remember here is that the list is a dynamic, flexible collection, but an array is fixed in size, so we need to specify the size of the array when converting.

4. The toArray() Method
Java provides a method called toArray() to convert a list into an array. This method works in two main ways:

4.1. Using toArray() without Parameters
If you call toArray() without parameters, the method returns an Object[] array, which is a bit generic. So it’s usually better to specify the type of the array when converting the list.

Example:

java
Copy code
List<Integer> numberList = new ArrayList<>();
numberList.add(1);
numberList.add(2);
numberList.add(3);

// Convert to array (with Object[] type)
Object[] numberArray = numberList.toArray();
The downside of this approach is that the array type is Object[], so you'll need to cast it back to the specific type (like Integer[]), which can be tricky and not very safe.

4.2. Using toArray() with a Parameter
To get a proper array type (like Integer[]), you pass a new array of the same type as a parameter. The list will then fill this array with the elements from the list.

Example:

java
Copy code
List<Integer> numberList = new ArrayList<>();
numberList.add(1);
numberList.add(2);
numberList.add(3);

// Convert to array (Integer[])
Integer[] numberArray = numberList.toArray(new Integer[0]);
Here’s what’s happening:

new Integer[0] is the type of the array that we want (Integer[]).
The toArray(new Integer[0]) method will fill this array with the elements of the list.
The 0 inside the array (i.e., new Integer[0]) doesn't really matter. Java will internally figure out the right size based on the list, but it’s a convention to pass a 0-sized array.
Now, numberArray will look like this:

csharp
Copy code
[1, 2, 3]
5. Why Do We Use new Integer[0]?
You might wonder: why do we pass new Integer[0] instead of something like new Integer[numberList.size()]?

If you use new Integer[numberList.size()], it works just fine, but it’s not as efficient as passing new Integer[0]. The method will return an array that’s just the right size, whether you pass a small-sized array or an empty one.
Here’s an alternative:

java
Copy code
Integer[] numberArray = numberList.toArray(new Integer[numberList.size()]);
This works too, but using new Integer[0] is more common in practice.

6. Putting It All Together:
Here’s the full example, from list to array:

java
Copy code
import java.util.*;

public class ListToArray {
    public static void main(String[] args) {
        // Step 1: Create a List and add elements
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);

        // Step 2: Convert List to Array using toArray() with a parameter
        Integer[] numberArray = numberList.toArray(new Integer[0]);

        // Step 3: Print the Array
        System.out.println(Arrays.toString(numberArray));
    }
}
Output:
csharp
Copy code
[1, 2, 3]
Now, we have successfully converted a List of integers into an Array.

Summary:
List to Array Conversion: To convert a List to an Array, you can use the toArray() method.
The best practice is to use toArray(new Type[0]), where Type is the type of the list (like Integer, String, etc.).
The array will have the same elements as the list, but it is a fixed-size container, unlike the dynamic list.
*/