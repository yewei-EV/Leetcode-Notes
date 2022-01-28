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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yewei Wang
 */
// 實現一個最小化交易次數的賬務系統的核心邏輯。輸入是不同個體之間相互欠款的額度，
// 輸出是最小化交易次數後不同个体需要做出的最終交易額度。例如：甲欠乙三錢，
// 乙欠丙五錢，丙欠甲一錢，那麼最終最優的交易方案可能是：丙向甲收取二錢，
// 再向乙收取二錢，如此總交易次數便從三次減至兩次。
public class MinimumTrading {
    public static void main(String[] args) {
        List<Map<Integer, Integer>> input = new ArrayList<>();
        input.add(new HashMap<Integer, Integer>() {{
            put(0, 0);
            put(1, -3);
            put(2, 1);
        }});
        input.add(new HashMap<Integer, Integer>() {{
            put(0, 3);
            put(1, 0);
            put(2, -5);
        }});
        input.add(new HashMap<Integer, Integer>() {{
            put(0, -1);
            put(1, 5);
            put(2, 0);
        }});
        Map<String, Integer> ans = minimumTrading(input);
        System.out.println(ans);
    }

    public static Map<String, Integer> minimumTrading(List<Map<Integer, Integer>> input) {
        Map<String, Integer> ans = new HashMap<>();
        int n = input.size();
        int[] record = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                record[i] += input.get(j).get(i);
            }
        }
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (record[i] > 0) {
                pos.add(i);
            } else if (record[i] < 0) {
                neg.add(i);
            }
        }
        for (Integer i : pos) {
            for (Integer j : neg) {
                if (record[i] == 0 || record[j] == 0) {
                    continue;
                }
                if (record[i] >= -record[j]) {
                    String index = i+"->"+j;
                    ans.put(index, ans.getOrDefault(index, 0) - record[j]);
                    record[i] = record[i] + record[j];
                    record[j] = 0;
                } else {
                    String index = i+"->"+j;
                    ans.put(index, ans.getOrDefault(index, 0) + record[i]);
                    record[j] = record[j] + record[i];
                    record[i] = 0;
                }
            }
        }
        return ans;
    }
}
