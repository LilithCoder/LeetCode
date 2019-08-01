package com.company;

//Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
//
//        get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
//        put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
//        it should invalidate the least recently used item before inserting a new item.
//
//        The cache is initialized with a positive capacity.
//
//        Follow up:
//        Could you do both operations in O(1) time complexity?
//
//        Example:
//
//        LRUCache cache = new LRUCache( 2 /* capacity */ );
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    //Hashmap + Double linkedlist
    //Hashmap: find if the target node exists in constant time
    //Double linkedlist: remove the target node in constant time
    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int size;
    private Node dummyHead;
    private Node dummyTail;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        //Does not matter what the key and value of the dummy node is
        dummyHead = new Node(-1, -1);
        dummyTail = new Node(-1, -1);

        //link two dummy nodes
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;


        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(key);
        addHead(key, node.value);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(key);
            addHead(key, value);
        } else {
            addHead(key,value);
        }

    }

    //helper methods
    private void remove(int key){

        //remove the target node and link the previous node of the target and the next node of target
        Node currNode = map.get(key);
        Node prevNode = currNode.prev;
        Node nextNode = currNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        map.remove(key);
        size--;
    }

    private void addHead(int key, int value) {
        Node newNode = new Node(key, value);

        //insert the new node between the head and the next node of the head
        newNode.next = dummyHead.next;
        dummyHead.next.prev = newNode;
        dummyHead.next = newNode;
        newNode.prev = dummyHead;

        map.put(key, newNode);

        //check if the current size overhead the capacity, otherwise remove the previous node of the dummy head
        size++;
        if(size > capacity) {
            Node prevTailNode = dummyTail.prev;
            remove(prevTailNode.key);
        }
    }

    public static void main(String[] args){
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

