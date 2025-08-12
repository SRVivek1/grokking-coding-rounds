package com.srvivek.besttimetobuysellstock;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BestTimeToBuySellStock1Test {

    private final BestTimeToBuySellStock1 solution = new BestTimeToBuySellStock1();

    @Test
    public void testWithIncreasingPrices() {
        int[] prices = {1, 2, 3, 4, 5};
        assertEquals(4, solution.maxProfit(prices));
    }

    @Test
    public void testWithDecreasingPrices() {
        int[] prices = {5, 4, 3, 2, 1};
        assertEquals(0, solution.maxProfit(prices));
    }

    @Test
    public void testWithMultiplePeaksAndValleys() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        assertEquals(5, solution.maxProfit(prices)); // Buy at 1, sell at 6
    }

    @Test
    public void testWithEmptyArray() {
        int[] prices = {};
        assertEquals(0, solution.maxProfit(prices));
    }

    @Test
    public void testWithSingleElementArray() {
        int[] prices = {10};
        assertEquals(0, solution.maxProfit(prices));
    }

    @Test
    public void testWithNullArray() {
        int[] prices = null;
        assertEquals(0, solution.maxProfit(prices));
    }

    @Test
    public void testWithNoProfitPossible() {
        int[] prices = {2, 1};
        assertEquals(0, solution.maxProfit(prices));
    }

    @Test
    public void testWithFlatPrices() {
        int[] prices = {5, 5, 5, 5, 5};
        assertEquals(0, solution.maxProfit(prices));
    }
}
