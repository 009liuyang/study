package com.ly.study.algorithm.LRU;

import java.util.HashMap;

/**
 * @describe
 * HashMap 中存储每个key 对应的节点Node<key，value>， Node节点之间再通过 prev、next 链接，实现有序的双向链表
 *
 * @author yang.liu
 * @date 2020-04-08
 */
public class UseHashMap {

    // 双向链表节点结构
    private class Node {
        public Node pre;
        public Node next;
        public int key;
        public int val;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
            this.pre = null;
            this.next = null;
        }
    }

    // 双向链表 头部是最老的
    private class DoublyLinkedList {
        public Node head;
        public Node tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void moveToTail(Node n) {
            // 将节点移动至尾部
            if (n == null || n == tail) return;
            if (head == n) {
                head = n.next;
                head.pre = null;
            } else {
                n.pre.next = n.next;
                n.next.pre = n.pre;
            }

            tail.next = n;
            n.pre = tail;
            n.next = null;
            tail = tail.next;
        }

        public void addToTail(Node n) {
            if (n == null) return;
            // 添加新的节点
            if (head == null) {
                head = n;
                tail = n;
            } else {
                tail.next = n;
                n.pre = tail;
                tail = n;
            }
        }

        public Node removeHead() {
            // 删除头部（最老的）节点
            if (head == null) return null;
            Node n = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.pre = null;
            }
            return n;
        }
    }

    private DoublyLinkedList list;
    private HashMap<Integer, Node> map;
    private int capacity;

    public UseHashMap(int capacity) {
        this.list = new DoublyLinkedList();
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node n = map.get(key);
        list.moveToTail(n);
        return n.val;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node n = new Node(key, value);
            map.put(key, n);
            list.addToTail(n);

            if (map.size() > capacity) {
                Node rmv = list.removeHead();
                map.remove(rmv.key);
            }
        } else {
            Node n = map.get(key);
            n.val = value;
            list.moveToTail(n);
        }
    }
}
