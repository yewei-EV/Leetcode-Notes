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
// PingPong game
// For each round, the probability of A win is Pa,  the probability of A win is Pb
// Find the probability of A win the game
public class PingPong {
    public static void main(String[] args) {
        double result = findProbabilityOfWin(0.4, 0.6);
        System.out.println(result);
    }

    public static double findProbabilityOfWin(double Pa, double Pb) {
        double[][] dp = new double[12][12];
        dp[0][0] = 0;
        dp[1][0] = Pa;
        dp[0][1] = Pb;
        for (int i = 1; i <= 11; i++) {
            for (int j = 1; j <= 11; j++) {
                dp[i][j] = dp[i - 1][j] * Pa + dp[i][j - 1] * Pb;
            }
        }
        double ans = 0;
        for (int k = 1; k <= 11; k++) {
            ans += dp[11][k];
        }
        return ans;
    }

}
