package leetcode.editor.cn.doc;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.WeakHashMap;

/**
 * @program: LeetCode
 * @description: 合并k个有序数组
 * @author: Silince
 * @create: 2021-04-04 21:43
 **/
// JDK 实现方式
class MinHeapNode {
    public int row, col, val;

    public MinHeapNode(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

public class MergerKArr {

    public static void main(String[] args) {
        MergerKArr m = new MergerKArr();
        int[][] arr = {{1, 3, 5, 7}, {2, 4, 6}, {0, 8, 9, 10, 11}};
        int[] res = m.mergeKSortedArrays(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }


    public int[] mergeKSortedArrays(int[][] arr) {
        if (arr == null) {
            return new int[0];
        }

        int sum = 0; // 结果数组总长度
        // 创建小根堆
        Queue<MinHeapNode> q = new PriorityQueue<>(arr.length, (o1, o2) -> o1.val - o2.val);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length > 0) {
                // 小根堆的大小为k(数组的数量)
                MinHeapNode e = new MinHeapNode(i, 0, arr[i][0]);
                q.add(e);
                sum += arr[i].length; // 记录结果数组总长度
            }
        }

        int[] res = new int[sum];
        int index = 0;
        while (!q.isEmpty()) {
            MinHeapNode e = q.poll(); //弹出堆顶最小值
            res[index++] = e.val;
            // 当前结点被 PriorityQueue 抛出来后，当前行的第二个结点加入 PriorityQueue
            if (e.col + 1 < arr[e.row].length) {     //将当前最小所在数组的下一个元素存入pq
                q.add(new MinHeapNode(e.row, e.col + 1, arr[e.row][e.col + 1]));
            }
        }

        return res;
    }


}


