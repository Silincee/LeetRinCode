//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// 👍 194 👎 0


package leetcode.editor.cn;

//和为s的连续正数序列

import java.util.ArrayList;
import java.util.List;

public class HeWeiSdeLianXuZhengShuXuLieLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new HeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
    }

    //力扣代码 https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/shi-yao-shi-hua-dong-chuang-kou-yi-ji-ru-he-yong-h/
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[][] findContinuousSequence(int target) { //[1,2,3,4,5]
            int i = 1, j = 1, sum = 0;
            ArrayList<int[]> res = new ArrayList<>();

            while (i <= target / 2) {
                if (sum < target) {
                    sum += j;
                    j++;
                } else if (sum > target) {
                    sum -= i;
                    i++;
                } else {
                    int[] arr = new int[j - 1];
                    for (int k = i; k < j; k++) {
                        arr[k - i] = k;
                    }
                    res.add(arr);
                }
            }
            return res.toArray(new int[res.size()][]);
        }

    }


//leetcode submit region end(Prohibit modification and deletion)

}