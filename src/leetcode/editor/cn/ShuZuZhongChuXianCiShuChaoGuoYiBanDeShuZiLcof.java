//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 位运算 分治算法 
// 👍 97 👎 0


package leetcode.editor.cn;

//数组中出现次数超过一半的数字

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof().new Solution();
        System.out.println(solution.majorityElement(new int[]{1, 2, 3, 4, 4, 4, 4}));
    }

    //力扣代码 https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * @description: 摩尔投票法 核心就是对拼消耗
         */
        public int majorityElement(int[] nums) { // [1, 4, 4, 2, 3, 4, 4]
           int x = 0,votes=0;
			for (int num : nums) {
				if (votes==0) x=num;
				votes+=(num==x?1:-1);
			}
			return x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}