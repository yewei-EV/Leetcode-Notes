/*
 * Copyright (c) 2016 Tianbao Travel Ltd.
 * www.tianbaotravel.com
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Tianbao Travel Ltd. ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you
 * entered into with Tianbao Travel Ltd.
 */
package leetcode.editor.cn;

/**
 * @author Yewei Wang
 */
//The interns at Amazon were asked to review the company's stock value over a period.
// Given the stock prices of n months, the net price change for the 𝑖𝑡ℎith month is
// defined as the absolute difference between the average of stock prices for the first
// i months and for the remaining (n - i) months where 1≤𝑖<𝑛1≤i<n. Note that these
// averages are rounded down to an integer.Given an array of stock prices, find the
// month at which the net price change is minimum. If there are several such months,
// return the earliest month.Note: The average of a set of integers here is defined as
// the sum of integers divided by the number of integers, rounded down to the nearest
// integer. For example, the average of [1, 2, 3, 4] is the floor of
// (1 + 2 + 3 + 4) / 4 = 2.5 and the floor of 2.5 is 2.
public class MinimumNetPriceChange {
    public static void main(String[] args) {
        int result = minimumChange(new int[]{1, 3, 2, 3});
        System.out.println(result);
    }

    public static int minimumChange(int[] stockPrice) {
        int n = stockPrice.length;
        int[] sum = new int[n+1];
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp += stockPrice[i];
            sum[i+1] = temp;
        }
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for (int index = 1; index < n - 1; index++) {
            int diff = Math.abs((sum[index])/index - (sum[n] - sum[index])/(n - index));
            if (diff < min) {
                min = diff;
                ans = index;
            }
        }
        return ans;
    }
}
