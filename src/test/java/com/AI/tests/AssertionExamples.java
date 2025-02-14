package com.AI.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.*;

public class AssertionExamples {

    /*
    * Sure! Here's the comparison between **Hard Assertions** and **Soft Assertions** in a point-wise format:

### **Hard Assertions:**
1. **Execution Flow:**
   - Stops the test execution immediately when an assertion fails.
   - The subsequent assertions in the test are not executed if one fails.

2. **Assertion Methods:**
   - Uses standard assertion methods such as `Assert.assertTrue()`, `Assert.assertEquals()`, etc.

3. **Test Failure:**
   - The test case fails immediately when an assertion fails.
   - The test terminates right away on the first failure.

4. **Failure Handling:**
   - No further checks or assertions are executed after a failure.

5. **Use Case:**
   - Ideal for critical checks where failure at any point indicates that further tests are not meaningful.

6. **Example:**
   ```java
   Assert.assertTrue(5 > 6);  // Fails here, test stops
   Assert.assertTrue(10 > 5); // This line is never reached.
   ```

7. **Reporting:**
   - TestNG reports the failure immediately after the first failure is encountered.

8. **Impact on Test Case:**
   - The test case is considered a failure, and the test execution halts immediately.

---

### **Soft Assertions:**
1. **Execution Flow:**
   - The test continues to execute even if an assertion fails.
   - The subsequent assertions in the test are still executed even after a failure.

2. **Assertion Methods:**
   - Uses the `SoftAssert` class for assertions, such as `softAssert.assertTrue()`, `softAssert.assertEquals()`, etc.

3. **Test Failure:**
   - The test case does not fail immediately when an assertion fails.
   - Test only fails at the end if `assertAll()` is called, collecting all failures in one place.

4. **Failure Handling:**
   - Collects all assertion failures and does not terminate the test.
   - Failures are reported after invoking `softAssert.assertAll()`.

5. **Use Case:**
   - Ideal for non-critical checks where we want to execute all assertions and collect failure results at the end.

6. **Example:**
   ```java
   SoftAssert softAssert = new SoftAssert();
   softAssert.assertTrue(5 > 6);  // Fails here, but test continues
   softAssert.assertTrue(10 > 5); // This line is executed even after the first failure
   softAssert.assertAll(); // Reports all failures at the end
   ```

7. **Reporting:**
   - Failures are reported only when `softAssert.assertAll()` is called at the end.

8. **Impact on Test Case:**
   - The test case continues even if there are failures, and all failures are reported together after `assertAll()`.

---

### **Key Differences Summary:**
- **Test Execution on Failure:**
   - **Hard Assertion**: Stops immediately at the first failure.
   - **Soft Assertion**: Continues execution and reports all failures later.

- **When to Use:**
   - **Hard Assertion**: For critical validations where further execution doesn’t make sense if one condition fails.
   - **Soft Assertion**: For non-critical validations where we want to collect all failures before failing the test.

- **Example Scenarios:**
   - **Hard Assertion**: Checking if a value is within a valid range (e.g., `Assert.assertTrue(age > 0);`).
   - **Soft Assertion**: Collecting multiple warnings or validations that can be checked together at the end of the test.

---

### **Conclusion:**
- **Hard Assertions**: Stop test execution immediately upon failure and are used when the test can't proceed if a condition fails.
- **Soft Assertions**: Allow the test to continue and report all assertion failures after execution, useful for validating multiple conditions without terminating the test prematurely.

If you need more examples or clarification, feel free to ask!*/

    @Test
    public void testAssertions() {

        // Create an instance of SoftAssert
        SoftAssert softAssert = new SoftAssert();   // object holds all the erros , once we do assert all it will fail

        // 1. assertEquals (for primitives) - Hard Assertions
        Assert.assertEquals(5, 5);  // This will pass because 5 is equal to 5
        Assert.assertEquals(5.0, 5.0, 0.01);  // This will pass because 5.0 is equal to 5.0 with delta 0.01
        Assert.assertEquals(5f, 5f, 0.01f);  // This will pass because 5f is equal to 5f with delta 0.01f
        Assert.assertEquals('a', 'a');  // This will pass because 'a' is equal to 'a'
        Assert.assertEquals(true, true);  // This will pass because true is equal to true

        // 2. assertEquals (for objects) - Hard Assertions
        Assert.assertEquals(Integer.valueOf(5), Integer.valueOf(5));  // This will pass because Integer(5) equals Integer(5)
        Assert.assertEquals("Hello", "Hello");  // This will pass because "Hello" equals "Hello"
        Assert.assertEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});  // This will fail because arrays are compared by reference, not value
        Assert.assertEquals(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3));  // This will pass because lists are compared by value

        // 3. assertNotEquals - Hard Assertions
        Assert.assertNotEquals(5, 6);  // This will pass because 5 is not equal to 6
        Assert.assertNotEquals("Hello", "World");  // This will pass because "Hello" is not equal to "World"
        Assert.assertNotEquals(new int[]{1, 2, 3}, new int[]{1, 2, 4});  // This will fail because arrays are compared by reference, not value

        // 4. assertFalse - Hard Assertions
        Assert.assertFalse(5 > 6);  // This will pass because 5 is not greater than 6, so the condition is false

        // 5. assertTrue - Hard Assertions
        Assert.assertTrue(5 > 4);  // This will pass because 5 is greater than 4, so the condition is true

        // 6. assertNull - Hard Assertions
        Object obj = null;
        Assert.assertNull(obj);  // This will pass because obj is null

        // 7. assertNotNull - Hard Assertions
        Object notNullObj = new Object();
        Assert.assertNotNull(notNullObj);  // This will pass because notNullObj is not null

        // 8. assertSame - Hard Assertions
        Object a = new Object();
        Object b = a;
        Assert.assertSame(a, b);  // This will pass because a and b reference the same object

        // 9. assertNotSame - Hard Assertions
        Object c = new Object();
        Assert.assertNotSame(a, c);  // This will pass because a and c reference different objects

        // 10. assertThrows (with exception type) - Hard Assertions
        Assert.assertThrows(NullPointerException.class, () -> {  // This will pass because a NullPointerException is thrown
            throw new NullPointerException();
        });

        // 11. assertThrows (with message) - Hard Assertions
        Assert.assertThrows(NullPointerException.class, () -> {  // This will pass because a NullPointerException with message is thrown
            throw new NullPointerException("Test");
        });

        // 12. fail (with message) - Hard Assertions
        Assert.fail("Test failed intentionally");  // This will fail because fail() explicitly causes the test to fail with the given message

        // 13. assertEqualsNoOrder (for arrays) - Hard Assertions
        Assert.assertEqualsNoOrder(new Integer[]{1, 2, 3}, new Integer[]{3, 1, 2});  // This will pass because arrays contain the same elements in any order

        // 14. assertEqualsNoOrder (for collections with message) - Hard Assertions
        Assert.assertEqualsNoOrder(Arrays.asList(1, 2, 3), Arrays.asList(3, 1, 2), "Order should not matter");  // This will pass because collections contain the same elements in any order

        // 15. assertListContains - Soft Assertions
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        softAssert.assertTrue(list.contains("banana"), "List should contain 'banana'");  // Soft assert: This will pass because the list contains "banana"

        // 16. assertListNotContains - Soft Assertions
        softAssert.assertFalse(list.contains("orange"), "List should not contain 'orange'");  // Soft assert: This will pass because the list does not contain "orange"

        // 17. assertEqualsDeep (TestNG does not have a built-in deep equals, so we use custom checks or libraries) - Soft Assertions
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("one", 1);
        map1.put("two", 2);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("one", 1);
        map2.put("two", 2);
        softAssert.assertEquals(map1, map2, "Maps should be deeply equal");  // Soft assert: This will pass because maps have equal keys and values

       /* // 18. expectThrows (TestNG has no direct equivalent for expectThrows, so we use assertThrows) - Soft Assertions
        NullPointerException exception = softAssert.expectThrows(NullPointerException.class, () -> {  // Soft assert: This will pass because a NullPointerException is thrown
            throw new NullPointerException("Test exception");
        });
        softAssert.assertEquals(exception.getMessage(), "Test exception");  // Soft assert: This will pass because the exception message matches "Test exception"
*/        // End of soft asserts, now assert all soft assertions
        softAssert.assertAll();  // This will report any soft assertion failures at the end of the test
    }
}
