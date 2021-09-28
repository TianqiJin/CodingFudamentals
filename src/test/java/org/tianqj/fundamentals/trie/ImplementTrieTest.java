package org.tianqj.fundamentals.trie;

import org.junit.Test;

public class ImplementTrieTest {

    @Test
    public void test() {
        ImplementTrie trie = new ImplementTrie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));// returns true
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
