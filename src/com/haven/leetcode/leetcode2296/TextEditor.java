package com.haven.leetcode.leetcode2296;

public class TextEditor {
    Node root, cur;

    public TextEditor() {
        root = cur = new Node(); // 哨兵节点
        root.prev = root;
        root.next = root; // 初始化双向链表，下面判断节点的 next 若为 root，则表示 next 为空
    }

    public void addText(String text) {
        for (int i = 0; i < text.length(); i++)
            cur = cur.insert(new Node(text.charAt(i)));
    }

    public int deleteText(int k) {
        int k0 = k;
        for (; k > 0 && cur != root; --k) {
            cur = cur.prev;
            cur.next.remove();
        }
        return k0 - k;
    }

    String text() {
        StringBuilder s = new StringBuilder();
        Node cur = this.cur;
        for (int k = 10; k > 0 && cur != root; --k) {
            s.append(cur.ch);
            cur = cur.prev;
        }
        return s.reverse().toString();
    }

    public String cursorLeft(int k) {
        for (; k > 0 && cur != root; --k)
            cur = cur.prev;
        return text();
    }

    public String cursorRight(int k) {
        for (; k > 0 && cur.next != root; --k)
            cur = cur.next;
        return text();
    }
}

// 手写双向链表
class Node {
    Node prev, next;
    char ch;

    Node() {}

    Node(char ch) {
        this.ch = ch;
    }

    // 在 this 后插入 node，并返回该 node
    Node insert(Node node) {
        node.prev = this;
        node.next = this.next;
        node.prev.next = node;
        node.next.prev = node;
        return node;
    }

    // 从链表中移除 this
    void remove() {
        this.prev.next = this.next;
        this.next.prev = this.prev;
    }
}
