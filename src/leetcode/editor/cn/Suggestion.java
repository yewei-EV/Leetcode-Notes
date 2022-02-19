package leetcode.editor.cn;/*
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

/**
 * @author Yewei Wang
 */
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    public static class Trie {

        public class TrieNode {
            Map<Character, TrieNode> node;
            boolean isLeaf;

            public TrieNode() {
                this.node = new HashMap<>();
            }
        }

        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        };

        public void insert(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (!current.node.containsKey(c)) {
                    current.node.put(c, new TrieNode());
                }
                current = current.node.get(c);
            }
            current.isLeaf = true;
        }

        public List<List<String>> search(String word) {
            List<List<String>> result = new ArrayList<>();
            TrieNode current = root;
            StringBuffer temp = new StringBuffer();
            for (int i = 0; i < word.length(); ++i) {
                if (i == 0) {
                    if (root.node.containsKey(word.charAt(0))) {
                        current = root.node.get(word.charAt(0));
                        temp.append(word.charAt(0));
                        continue;
                    } else {
                        return result;
                    }
                }

                if (current.node.containsKey(word.charAt(i))) {
                    temp.append(word.charAt(i));
                    current = current.node.get(word.charAt(i));
                    List<String> eachResult = new ArrayList<>();
                    helper(eachResult, current, temp);
                    List<String> sortedResult = eachResult.stream().sorted().limit(3).collect(Collectors.toList());
                    result.add(sortedResult);
                } else {
                    return result;
                }
            }
            return result;
        }

        public void helper(List<String> result, TrieNode cur, StringBuffer sb) {
            if (cur.isLeaf) {
                result.add(sb.toString());
            }
            if (cur.node == null) {
                return;
            }
            for (Map.Entry<Character, TrieNode> entry : cur.node.entrySet()) {
                helper(result, entry.getValue(), sb.append(entry.getKey()));
                sb.setLength(sb.length() - 1);
            }
        }
    }

    /*
     * Complete the 'searchSuggestions' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY repository
     *  2. STRING customerQuery
     */

    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        // Write your code here
        Trie trie = new Trie();
        for (String r : repository) {
            trie.insert(r);
        }
        return trie.search(customerQuery);
    }


}

public class Suggestion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int repositoryCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> repository = IntStream.range(0, repositoryCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        String customerQuery = bufferedReader.readLine();

        List<List<String>> result = Result.searchSuggestions(repository, customerQuery);

        result.stream()
                .map(
                        r -> r.stream()
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
