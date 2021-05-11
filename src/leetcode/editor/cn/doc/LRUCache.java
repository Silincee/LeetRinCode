package leetcode.editor.cn.doc;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @program: LeetCode
 * @description:
 * @author: Silince
 * @create: 2021-01-13 20:27
 **/
public class LRUCache {

    private int capacity; // LRU容量
    private int size; // 当前大小
    private HashMap<Integer,DLinkedListNode> cache= new HashMap<>();;
    DLinkedListNode dummyHead = new DLinkedListNode();
    DLinkedListNode dummyTail = new DLinkedListNode();

    public LRUCache(int capacity) {
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
        this.capacity = capacity;
        this.size=0;

    }

    public void put(int key, int value){
        DLinkedListNode node = cache.get(key);
        // 1 存在，直接把原node移到最前
        if (node!=null){
            node.value = value;
            moveToHead(node);
        }else{
            // 2 不存在，创建节点插入
            node = new DLinkedListNode(key,value);
            cache.put(key,node);
            size++;

            // 2-1 容量没满 直接put 并且放到链表最前
            addToHead(node);

            if (size>capacity){
                // 2-2容量满了，移除最后的node，把自己放到最前
                DLinkedListNode node1 = dummyTail.prev;
                cache.remove(node1.key);
                deleteNode(node1);
                size--;

            }

        }



    }

    public int get(int key) {
        DLinkedListNode node = cache.get(key);
        // 不存在自己返回
        if (node==null){
            return -1;
        }else{
            // 存在返回，并移到头部
            moveToHead(node);
            return node.value;
        }


    }

    private void moveToHead(DLinkedListNode node) {
        // 先断开自己
        deleteNode(node);
        // 放到虚拟头节点之后
        addToHead(node);
    }

    private void deleteNode(DLinkedListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DLinkedListNode node) {
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }



    class DLinkedListNode {
        int key;
        int value;
        DLinkedListNode prev;
        DLinkedListNode next;

        public DLinkedListNode() {
        }

        public DLinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
