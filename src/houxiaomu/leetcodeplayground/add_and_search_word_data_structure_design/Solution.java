package houxiaomu.leetcodeplayground.add_and_search_word_data_structure_design;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/10.
 */
public class Solution extends BaseSolution {
    @Override
    public boolean runCustomizedTestCases() {
        addWord("bad");
        addWord("dad");
        addWord("mad");
        System.out.println("search :" + search("pad"));
        System.out.println("search :" + search("bad"));
        System.out.println("search :" + search(".ad"));
        System.out.println("search :" + search("b.."));
        System.out.println("search :" + search("b."));
        return true;
    }

    class TrieNode {
        boolean end;
        TrieNode[] children = new TrieNode[26];
    }

    TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        int pos = 0;
        TrieNode node = root;
        while (pos < word.length()) {
            int i = word.charAt(pos) - 'a';
            if (node.children[i] == null) {
                node.children[i] = new TrieNode();
            }
            pos++;
            node = node.children[i];
        }
        node.end = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, 0, root);
    }

    public boolean search(String word, int pos, TrieNode node) {
        while (pos < word.length()) {
            char c = word.charAt(pos);
            if (c == '.') {
                boolean ret = false;
                for (int i = 0; i < 26; i++) {
                    if (node.children[i] != null) {
                        if (search(word, pos + 1, node.children[i])) {
                            ret = true;
                            break;
                        }
                    }
                }
                return ret;

            } else {
                int i = c - 'a';
                if (node.children[i] == null) {
                    return false;
                }
                pos++;
                node = node.children[i];
            }
        }
        return node.end;
    }

}
