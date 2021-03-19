//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数
//值排序之后中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例 1： 
//
// 输入：
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[]]
//输出：[null,null,null,1.50000,null,2.00000]
// 
//
// 示例 2： 
//
// 输入：
//["MedianFinder","addNum","findMedian","addNum","findMedian"]
//[[],[2],[],[3],[]]
//输出：[null,null,2.00000,null,2.50000] 
//
// 
//
// 限制： 
//
// 
// 最多会对 addNum、findMedian 进行 50000 次调用。 
// 
//
// 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-strea
//m/ 
// Related Topics 堆 设计 
// 👍 95 👎 0


package leetcode.editor.cn;

//数据流中的中位数

import java.util.PriorityQueue;

public class ShuJuLiuZhongDeZhongWeiShuLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 }
//力扣代码 undo
	//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {

    /** initialize your data structure here. */
    private PriorityQueue<Integer> minTopHeap; //小顶堆，保存较大的一半数据
    private PriorityQueue<Integer> maxTopHeap;// 大顶堆，保存较小的一半数据
    public MedianFinder() {
        minTopHeap = new PriorityQueue<>();
        maxTopHeap = new PriorityQueue<>((n,m)->m-n);
    }

    public void addNum(int num) {
        if(maxTopHeap.isEmpty()){
            maxTopHeap.offer(num); // 第一个数存在大顶堆中
        }else if(num<=maxTopHeap.peek()){
            maxTopHeap.offer(num); // 如果新数不大于大顶堆最大数，则也属于较小的一半
            if(maxTopHeap.size()-minTopHeap.size()==2) // 保持两个堆中数据个数差不大于1
                minTopHeap.offer(maxTopHeap.poll());
        }else {// 如果新数大于大顶堆最大数，则属于较大的一半
            minTopHeap.offer(num);
            if(minTopHeap.size()-maxTopHeap.size()==2) // 保持两个堆中数据个数差不大于1
                maxTopHeap.offer(minTopHeap.poll());
        }
    }

    public double findMedian() {
        if(minTopHeap.size()>maxTopHeap.size())
            return minTopHeap.peek();
        if(maxTopHeap.size()>minTopHeap.size())
            return maxTopHeap.peek();
        return (minTopHeap.peek()+maxTopHeap.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}