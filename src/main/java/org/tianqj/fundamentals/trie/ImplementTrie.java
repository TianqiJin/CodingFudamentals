package org.tianqj.fundamentals.trie;

import org.apache.commons.lang3.StringUtils;
import org.tianqj.fundamentals.models.TrieTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 */
public class ImplementTrie {

    public TrieTreeNode root;

    public ImplementTrie() {
        root = new TrieTreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }

        char[] wordsInChar = word.toCharArray();
        TrieTreeNode current = root;
        for (int i = 0; i < wordsInChar.length; i ++) {
            int pos = wordsInChar[i] - 'a';
            if (current.children[pos] == null) {
                current.children[pos] = new TrieTreeNode(wordsInChar[i]);
                current.children[pos].ancestor = current;
            }else {
                current.children[pos].nCount++;
            }
            if (i == wordsInChar.length - 1) {
                current.children[pos].isEnd = true;
            }
            current = current.children[pos];
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        TrieTreeNode current = root;
        char[] wordsInChar = word.toCharArray();
        for (int i = 0; i < wordsInChar.length; i++) {
            int pos = wordsInChar[i] - 'a';
            if (current.children[pos] == null) {
                return false;
            }else {
                if (i == wordsInChar.length - 1 && !current.children[pos].isEnd) {
                    return false;
                }
                current = current.children[pos];
            }
        }

        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        TrieTreeNode current = root;
        char[] wordsInChar = prefix.toCharArray();

        for (char c : wordsInChar) {
            int pos = c - 'a';
            if (current.children[pos] == null) {
                return false;
            }
            current = current.children[pos];
        }

        return true;
    }

    public List<String> searchAllWords() {

        List<String> result = new ArrayList<>();

        TrieTreeNode current = root;
        Stack<TrieTreeNode > stack = new Stack<>();
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                stack.push(root.children[i]);
            }
        }
        StringBuilder sb = null;
        while(!stack.isEmpty()) {
            TrieTreeNode top = stack.pop();
            if (top.ancestor == root) {
                sb = new StringBuilder();
            }
            sb.append(top.ch);
            for(TrieTreeNode child: top.children) {
                stack.push(child);
            }
            if (top.isEnd) {
                result.add(sb.toString());
                sb.setLength(sb.length() - 1);
            }
        }

        return result;
    }
}
