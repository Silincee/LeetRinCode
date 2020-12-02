//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 994 👎 0


package leetcode.editor.cn;

//全排列

import java.util.LinkedList;
import java.util.List;

public class P46_Permutations {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P46_Permutations().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> res = new LinkedList<>();


        /* 主函数，输入一组不重复的数字，返回它们的全排列 */
       public List<List<Integer>> permute(int[] nums) {
            // 记录「路径」
            LinkedList<Integer> track = new LinkedList<>();
            backtrack(nums, track);
            return res;
        }


        // 路径：记录在 track 中
        // 选择列表：nums 中不存在于 track 的那些元素
        // 结束条件：nums 中的元素全都在 track 中出现
        public void backtrack(int[] nums, LinkedList<Integer> track) {
            // 触发结束条件
            if (track.size() == nums.length) {
                res.add(new LinkedList(track));
                return;
            }


            for (int i = 0; i < nums.length; i++) {
                // 排除不合法的选择
                if (!track.contains(nums[i]))
                {
                // 做选择
                track.add(nums[i]);
                // 进入下一层决策树
                backtrack(nums, track);
                // 取消选择
                track.removeLast();}
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}