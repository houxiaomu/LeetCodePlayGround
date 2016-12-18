package houxiaomu.leetcodeplayground.concatenated_words;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.*;

/**
 * Created by Simon on 2016/12/18.
 */
public class Solution extends BaseSolution {


    class TrieNode {
        boolean end;
        TrieNode[] children;

        // Initialize your data structure here.
        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode t = root;
            int pos = 0;
            while (true) {
                int childIndex = word.charAt(pos) - 'a';
                if (t.children[childIndex] == null) {
                    t.children[childIndex] = new TrieNode();
                }
                t = t.children[childIndex];
                pos++;
                if (pos == word.length()) {
                    t.end = true;
                    break;
                }
            }
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode t = root;
            int pos = 0;
            while (true) {
                int childIndex = word.charAt(pos) - 'a';
                if (t.children[childIndex] == null) {
                    return false;
                }
                t = t.children[childIndex];
                pos++;
                if (pos == word.length()) {
                    return t.end;
                }
            }
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode t = root;
            int pos = 0;
            while (pos < prefix.length()) {
                int childIndex = prefix.charAt(pos) - 'a';
                if (t.children[childIndex] == null) {
                    return false;
                }
                t = t.children[childIndex];
                pos++;
            }
            return true;
        }

        public boolean hasConcatenatedWord(String word, int start) {
            TrieNode t = root;
            int pos = start;
            while (pos < word.length()) {
                int childIndex = word.charAt(pos) - 'a';
                if (t.children[childIndex] == null) {
                    return false;
                }
                t = t.children[childIndex];
                pos++;
                if (pos == word.length()) {
                    return t.end;
                }
                if (t.end) {
                    if (hasConcatenatedWord(word, pos)) return true;
                }
            }
            return false;
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) return result;

        List<String> list = Arrays.asList(words);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        Trie trie = new Trie();
        for (String s : words) {
            if (s.isEmpty()) continue;
            if (trie.hasConcatenatedWord(s, 0)) {
                result.add(s);
            }
            trie.insert(s);
        }
        return result;
    }
}
