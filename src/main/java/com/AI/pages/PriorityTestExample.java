package com.AI.pages;


import org.testng.annotations.Test;

public class PriorityTestExample {

    @Test(priority = -2)
    public void testPriorityMinusTwo() {
        System.out.println("Test with priority -2");
    }

    @Test(priority = -1)
    public void testPriorityMinusOne() {
        System.out.println("Test with priority -1");
    }

    @Test(priority = 0)
    public void testPriorityZero() {
        System.out.println("Test with priority 0");
    }

    @Test(priority = 1)
    public void testPriorityOne() {
        System.out.println("Test with priority 1");
    }

    @Test(priority = 2)
    public void testPriorityTwo() {
        System.out.println("Test with priority 2");
    }

    @Test
    public void testNoPriority() {
        System.out.println("Test with no priority (default priority 0)");
    }
}



/*
*
* Expected Output (Order of Execution):
testPriorityMinusTwo() (priority = -2)
testPriorityMinusOne() (priority = -1)
testPriorityZero() (priority = 0)
testNoPriority() (default priority = 0, runs after negative tests)
testPriorityOne() (priority = 1)
testPriorityTwo() (priority = 2)
*
* */