package leetcode.editor.cn.doc;

import java.util.LinkedHashMap;

/**
 * @program: LeetCode
 * @description:
 * @author: Silince
 * @create: 2021-01-13 20:27
 **/
public class LRUCache extends LinkedHashMap {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return (int)super.get(key);
    }

    public void put(int key, int value) {

    }
}
