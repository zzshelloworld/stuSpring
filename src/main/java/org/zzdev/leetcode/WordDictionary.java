package org.zzdev.leetcode;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class WordDictionary {
    private Map<String, String> dataStructure = new ConcurrentHashMap<>();

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {

    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        dataStructure.put(word, "");
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one
     * letter.
     */
    public boolean search(String word) {
        boolean allFlag = false;
        for (Entry<String, String> entry : dataStructure.entrySet()) {
            boolean flag = true;
            String key = entry.getKey();
            if (key.equals(word)) {
                return true;
            }
            if (key.length() != word.length()) {
                return false;
            }

            char[] aArr = word.toCharArray();
            char[] bArr = key.toCharArray();
            for (int i = 0; i < aArr.length; i++) {
                if (aArr[i] == '.') {
                    continue;
                } else {
                    if (aArr[i] != bArr[i]) {
                        flag = false;
                        break;
                    }
                }

            }
            if (flag) {
                return true;
            }
        }
        return allFlag;
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        System.out.println(wd.search("pad"));
        System.out.println(wd.search("bad"));
        System.out.println(wd.search(".ad"));
        System.out.println(wd.search("b.."));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
