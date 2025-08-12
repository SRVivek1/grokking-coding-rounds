package com.srvivek.besttimetobuysellstock;

public class BestTimeToBuySellStock1 {

    public int maxProfit(int[] prices) {

        if(prices == null || prices.length < 2) return 0;

        int min_price = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price: prices) {
            min_price = Math.min(min_price, price);
            maxProfit = Math.max(maxProfit, (price - min_price));
        }

        return maxProfit;
    }
}
