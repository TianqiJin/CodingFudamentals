package org.tianqj.fundamentals.models;


public class TrieTreeNode {
    public int nCount;
    public char ch;
    public TrieTreeNode[] children;
    public TrieTreeNode ancestor;
    public boolean isEnd;

    public TrieTreeNode(char ch) {
        this.ch = ch;
        children = new TrieTreeNode[26];
        nCount = 1;
    }

    public TrieTreeNode() {
        children = new TrieTreeNode[26];
        nCount = 1;
    }
}
