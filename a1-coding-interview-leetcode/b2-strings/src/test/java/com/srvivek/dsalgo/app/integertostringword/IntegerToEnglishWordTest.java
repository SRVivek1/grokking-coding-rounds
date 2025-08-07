package com.srvivek.dsalgo.app.integertostringword;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegerToEnglishWordTest {

    IntegerToEnglishWord object = new IntegerToEnglishWord();

    @Test
    public void nullTest() {
        String res = object.integerToEnglish(null);
        Assertions.assertEquals("", res);

        res = object.integerToEnglishImprovedCpuTime(null);
        Assertions.assertEquals("", res);
    }

    @Test
    public void zeroTest() {
        String res = object.integerToEnglish(0);
        Assertions.assertTrue("Zero".equalsIgnoreCase(res));

        object.integerToEnglishImprovedCpuTime(0);
        Assertions.assertTrue("Zero".equalsIgnoreCase(res));
    }

    @Test
    public void singleDigitNum1Test() {
        int t = 1;
        String res = object.integerToEnglish(t);
        Assertions.assertTrue("One".equalsIgnoreCase(res));

        res = object.integerToEnglishImprovedCpuTime(t);
        Assertions.assertTrue("One".equalsIgnoreCase(res));
    }

    @Test
    public void singleDigitNum9Test() {
        int t = 9;
        String res = object.integerToEnglish(t);
        Assertions.assertTrue("nine".equalsIgnoreCase(res));

        res = object.integerToEnglishImprovedCpuTime(t);
        Assertions.assertTrue("nine".equalsIgnoreCase(res));
    }

    @Test
    public void doubleDigitNum10Test() {
        int t = 10;
        String res = object.integerToEnglish(t);
        Assertions.assertTrue("ten".equalsIgnoreCase(res));

        res = object.integerToEnglishImprovedCpuTime(t);
        Assertions.assertTrue("ten".equalsIgnoreCase(res));
    }

    @Test
    public void doubleDigitNum11Test() {
        int t = 11;
        String res = object.integerToEnglish(t);
        Assertions.assertTrue("eleven".equalsIgnoreCase(res));

        res = object.integerToEnglishImprovedCpuTime(t);
        Assertions.assertTrue("eleven".equalsIgnoreCase(res));
    }

    @Test
    public void doubleDigitNum19Test() {
        int t = 19;
        String res = object.integerToEnglish(t);
        Assertions.assertTrue("nineteen".equalsIgnoreCase(res));

        res = object.integerToEnglishImprovedCpuTime(t);
        Assertions.assertTrue("nineteen".equalsIgnoreCase(res));
    }

    @Test
    public void doubleDigitNum37Test() {
        int t = 37;
        String res = object.integerToEnglish(t);
        Assertions.assertTrue("thirty seven".equalsIgnoreCase(res));

        res = object.integerToEnglishImprovedCpuTime(t);
        Assertions.assertTrue("thirty seven".equalsIgnoreCase(res));
    }

    @Test
    public void doubleDigitNum99Test() {
        int t = 99;
        String res = object.integerToEnglish(t);
        Assertions.assertTrue("ninety nine".equalsIgnoreCase(res));

        res = object.integerToEnglishImprovedCpuTime(t);
        Assertions.assertTrue("ninety nine".equalsIgnoreCase(res));
    }

    @Test
    public void threeDigitNumTest() {
        int t = 123;
        String res = object.integerToEnglish(t);
        Assertions.assertTrue("One Hundred Twenty Three".equalsIgnoreCase(res));

        res = object.integerToEnglishImprovedCpuTime(t);
        Assertions.assertTrue("One Hundred Twenty Three".equalsIgnoreCase(res));
    }

    @Test
    public void threeDigitMaxNumTest() {
        int t = 999;
        String res = object.integerToEnglish(t);
        Assertions.assertTrue("Nine Hundred Ninety Nine".equalsIgnoreCase(res));

        res = object.integerToEnglishImprovedCpuTime(t);
        Assertions.assertTrue("Nine Hundred Ninety Nine".equalsIgnoreCase(res));
    }

    @Test
    public void fourDigitNum1000Test() {
        int t = 1000;
        String res = object.integerToEnglish(t);
        Assertions.assertTrue("One thousand".equalsIgnoreCase(res));

        res = object.integerToEnglishImprovedCpuTime(t);
        Assertions.assertTrue("One thousand".equalsIgnoreCase(res));
    }

    @Test
    public void fourDigitNum1001Test() {
        int t = 1001;
        String res = object.integerToEnglish(t);
        Assertions.assertTrue("One thousand one".equalsIgnoreCase(res));

        res = object.integerToEnglishImprovedCpuTime(t);
        Assertions.assertTrue("One thousand one".equalsIgnoreCase(res));
    }

    @Test
    public void fourDigitNum9999Test() {
        int t = 9999;
        String res = object.integerToEnglish(t);
        Assertions.assertTrue("Nine thousand nine Hundred Ninety Nine".equalsIgnoreCase(res));

        res = object.integerToEnglishImprovedCpuTime(t);
        Assertions.assertTrue("Nine thousand nine Hundred Ninety Nine".equalsIgnoreCase(res));
    }

    @Test
    public void millionValueTest() {
        int t = 1000000;
        String res = object.integerToEnglish(t);
        Assertions.assertTrue("One million".equalsIgnoreCase(res));

        res = object.integerToEnglishImprovedCpuTime(t);
        Assertions.assertTrue("One million".equalsIgnoreCase(res));
    }

    @Test
    public void millionValueTest2() {
        int t = 999999999;
        String res = object.integerToEnglish(t);
        Assertions.assertTrue("Nine hundred ninety nine million Nine hundred ninety nine thousand Nine hundred ninety nine".equalsIgnoreCase(res));

        res = object.integerToEnglishImprovedCpuTime(t);
        Assertions.assertTrue("Nine hundred ninety nine million Nine hundred ninety nine thousand Nine hundred ninety nine".equalsIgnoreCase(res));
    }
}
