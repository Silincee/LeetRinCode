package Array;

/**
 * @description: 674 最长连续递增序列[动态规划]
 * @param: 给定一个未经排序的整数数组，找到最长且连续的的递增序列
 * @return: 并返回该序列的长度。
 * @author: Silince
 * @date: 2020-07-20
 */
public class Test674 {
    private static int findLengthOfLCIS(int[] nums) {
        // nums[anchor] 处开始一个新的递增子序列
        // ans 当前子序列长度
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i-1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {9,6,7,8,9,1,2,3};
        System.out.println(findLengthOfLCIS(arr));
    }
}
