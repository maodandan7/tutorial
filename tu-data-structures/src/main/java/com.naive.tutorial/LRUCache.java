package com.naive.tutorial;

import java.util.concurrent.ConcurrentHashMap;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/12/1
 * Description:
 */
public class LRUCache {

    private ConcurrentHashMap<Integer, Node> cacheMap = new ConcurrentHashMap<>();
    private int capacity;
    private Node head, tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cacheMap.get(key);
        if (node == null) {
            return -1;
        }
        moveNodeToHead(node);
        return node.getValue();
    }

    private void moveNodeToHead(Node node) {
        removeNode(node);
        addNodeToHead(node);
    }

    private void addNodeToHead(Node node) {
        if (node == null) {
            return;
        }
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;


    }

    private void removeNode(Node node) {
        if (node == null) {
            return;
        }
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void put(int key, int value) {
        Node node = cacheMap.get(key);
        if (node == null) {
            if (cacheMap.size() >= capacity) {
                if (head.next != tail) {
                    this.cacheMap.remove(tail.pre.getKey());
                    removeNode(tail.pre);
                }
            }
            Node newNode = new Node(key, value);
            this.cacheMap.put(key, newNode);
            addNodeToHead(newNode);
        } else {
            node.setValue(value);
            moveNodeToHead(node);
        }
    }

    class Node {
        private int key;
        private int value;
        Node pre;
        Node next;

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }
}
