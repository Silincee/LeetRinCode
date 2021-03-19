//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1230 👎 0


package leetcode.editor.cn;

//LRU 缓存机制

import java.util.HashMap;
import java.util.concurrent.Executors;

public class P146_LruCache {
    public static void main(String[] args) {
        
        //测试代码
//        LRUCache lruCache = new LRUCache(2);
//        lruCache.put(1,1);
//        lruCache.put(2,2);
//        lruCache.get(1);
//        lruCache.put(3,3);
//        lruCache.get(2);
//        lruCache.put(4,4);
//        lruCache.get(1);
//        lruCache.get(3);
//        lruCache.get(4);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    private HashMap<Integer,DLinkedNode> cache = new HashMap<>();
    private int size; // 链表当前当长度(排除伪节点)
    private int capacity; // LRU容量
    private DLinkedNode dummyHead; // 伪头部
    private DLinkedNode dummyTail; // 伪尾部

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 初始化伪节点并且建立引用
        this.dummyHead = new DLinkedNode();
        this.dummyTail = new DLinkedNode();
        this.dummyHead.next = this.dummyTail;
        this.dummyTail.prev = this.dummyHead;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node==null){
            return -1;
        }
        // 如果缓存存在，将它移动到链表头部
        moveToHead(node);
        return node.value;
    }


    // 插入逻辑
    public void put(int key, int value) {
        // 如果存在就通过cache快速找到node，更新值后移动到链表的头部
        DLinkedNode node = this.cache.get(key);
        if (node!=null){
            node.value = value;
            moveToHead(node);
        }else {
            // 不存在则创建节点放入链表的头部并放入cache，然后判断列表容量是否已满，满了的话需要删除链表中的尾节点和cache
            node = new DLinkedNode(key,value);
            addToHead(node);
            size++;
            cache.put(key,node);
            if (size>capacity){
                // 删除链表中的尾节点和cache
                DLinkedNode tailNode = this.dummyTail.prev;
                removeNode(tailNode);
                this.cache.remove(tailNode.key);
                size--;
            }
        }


    }

    // 将该节点移动到头部
    private void moveToHead(DLinkedNode node) {
        // 先删除该节点 让它的前驱节点指向后继节点
        removeNode(node);
        // 将该节点插入到伪头部之后
        addToHead(node);
    }

    private void addToHead(DLinkedNode node) {
        node.prev = this.dummyHead;
        node.next = this.dummyHead.next;
        this.dummyHead.next.prev = node;
        this.dummyHead.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}