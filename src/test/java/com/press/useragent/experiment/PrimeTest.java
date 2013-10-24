package com.press.useragent.experiment;

import org.junit.runners.Parameterized;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class PrimeTest extends TestBase {
    private Integer prime;
    private Boolean expect;
    private InnerPrimeValidator innerPrimeValidator;

    @BeforeClass public static void beforeClass() { System.out.println("Before"); }

    @Before public void beforeMethod() {
        innerPrimeValidator = new InnerPrimeValidator();
        System.out.println(prime + " " + expect);
    }

    // Each parameter should be placed as an argument here
    // Every time runner triggers, it will pass the arguments from parameters we defined
    public PrimeTest(Integer primeNumber, Boolean expectedValidation) {
        this.prime = primeNumber;
        this.expect = expectedValidation;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers() {
        return Arrays.asList(new Object[][] {
                { 2, true },
                { 6, false },
                { 19, true },
                { 22, false},
                { 7, true }
        });
    }

    // This test will run 4 times since we have 4 parameters defined
    @Test
    public void testPrimeNumberValidator() {
        assertEquals(expect, innerPrimeValidator.validate(prime));
    }
    
    class InnerPrimeValidator {
        public Boolean validate(final Integer primeNumber) {
            for (int i = 2; i < (primeNumber / 2); i++) {
                if (primeNumber % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}