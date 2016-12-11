package houxiaomu.leetcodeplayground.implement_trie_prefix_tree;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/10.
 */
public class Solution extends BaseSolution {
    @Override
    public boolean runCustomizedTestCases() {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("world");
        trie.insert("hell");
        System.out.println("search world " + trie.search("world"));
        System.out.println("search wor " + trie.search("wor"));
        System.out.println("search word " + trie.search("word"));
        System.out.println("search hello " + trie.search("hello"));
        System.out.println("search helloha " + trie.search("helloha"));
        System.out.println("search hello " + trie.search("hello"));

        System.out.println("startwith he " + trie.startsWith("he"));
        System.out.println("startwith or " + trie.startsWith("or"));
        return true;
    }

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
    }
}
