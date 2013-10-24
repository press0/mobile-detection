package com.press.useragent.experiment;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FibonacciTest {
    private Integer input;
    private Integer expected;
    private InnerFibonacci innerFibonacci;

    @BeforeClass public static void beforeClass() { System.out.println("Before"); }

    @Before public void beforeMethod() {
    	innerFibonacci = new InnerFibonacci();
        System.out.println(input + " " + expected);
    }
    public FibonacciTest(Integer input, Integer expected)
    {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static List<Integer[]> data()
    {
        return Arrays.asList(new Integer[][] { { 0, 1 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 } });
    }

    @Test
    public void testFibonacci()
    {
        System.out.println("Input: " + input + ". Expected: " + expected);
        assertEquals(expected, (Integer) innerFibonacci.compute(input));
    }

    class InnerFibonacci {
    	int compute(int k) {

    		// Base Case:
    		//   If k <= 2 then fib(k) = 1.
    		if (k <= 2) {
    		    return 1;
    		}
    		// Recursive Case:
    		//   If k > 2 then fib(k) = fib(k-1) + fib(k-2).
    		else {
    		    return compute(k-1) + compute(k-2);
    		} 
        }
    }
}