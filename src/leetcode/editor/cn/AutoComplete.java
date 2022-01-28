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

import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

/**
 * @author Yewei Wang
 */
class Solution {
    public static void main(String[] args) {
        Autocomplete a = new Autocomplete(new String[]{"abc", "acd", "bcd", "def", "a", "aba"});
        System.out.println(a.getWordsForPrefix("a"));
        System.out.println(a.getWordsForPrefix("ab"));
        System.out.println(a.getWordsForPrefix("b"));
        System.out.println(a.getWordsForPrefix("f"));
    }
}

class Autocomplete {

    private class Node {
        String prefix;
        Map<Character, Node> children;
        boolean isWord;

        private Node(String prefix) {
            this.prefix = prefix;
            this.children = new HashMap<Character, Node>();
        }
    }

    // The trie
    private Node trie;

    // Construct the trie from the dictionary
    public Autocomplete(String[] dict) {
        trie = new Node("");
        for (String s : dict) insertWord(s);
    }

    // Insert a word into the trie
    private void insertWord(String s) {
        Node cur = trie;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new Node(s.substring(0, i+1)));
            }
            cur = cur.children.get(c);
            if (i == s.length() - 1) cur.isWord = true;
        }
    }

    // Find all words in trie that start with prefix
    public List<String> getWordsForPrefix(String pre) {
        List<String> results = new LinkedList<String>();
        Node cur = trie;
        for (int i = 0; i < pre.length(); i++) {
            if (cur.children.containsKey(pre.charAt(i))) {
                cur = cur.children.get(pre.charAt(i));
            } else {
                return results;
            }
        }

        findAllPrefix(cur, results);
        return results;
    }

    public void findAllPrefix(Node cur, List<String> results) {
        if (cur.isWord) {
            results.add(cur.prefix);
        }
        for (Character c : cur.children.keySet()) {
            findAllPrefix(cur.children.get(c), results);
        }
    }

}






