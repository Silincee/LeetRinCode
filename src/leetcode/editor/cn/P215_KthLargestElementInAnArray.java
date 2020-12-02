//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 704 👎 0


package leetcode.editor.cn;

//数组中的第K个最大元素

import java.util.Random;

public class P215_KthLargestElementInAnArray {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P215_KthLargestElementInAnArray().new Solution();
        int kthLargest = solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 7, 5, 6}, 4);
        System.out.println(kthLargest);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    // 方法一
    class Solution {
        Random random = new Random();

        public int findKthLargest(int[] nums, int k) {
            // 快速排序,随机获得轴值
            int left = 0;
            int right = nums.length-1;
            int index = nums.length-k;

            return quickSelect(nums,left,right,index);
        }

        public int quickSelect(int[] nums,int left,int right,int index){
            // 随机生成轴值并得到新的轴值下标
            int q = randomPartition(nums,left,right);
            if (q==index){
                return nums[q];
            }else{
                return q<index?quickSelect(nums,q+1,right,index):quickSelect(nums,left,q-1,index);
            }

        }

        // 随机选择轴值
        public int randomPartition(int nums[], int left, int right){
            int i = random.nextInt(right-left+1)+left;
            swap(nums,i,right);
            return partition(nums,left,right);
        }

        // 把小于轴值的元素都放到左边,返回新轴值下标
        public int partition(int nums[], int left, int right){
            int x = nums[right];
            int i = left-1;
            for (int j = left; j <= right; j++) {
                if (nums[j]<x){
                    i++;
                    swap(nums,i,j);
                }
            }
            swap(nums,i+1,right);
            return i+1;
        }

        public void swap(int[] nums,int i,int j ){
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }


    }

//leetcode submit region end(Prohibit modification and deletion)
}
