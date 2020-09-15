//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 727 👎 0


package leetcode.editor.cn;

//多数元素

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P169_MajorityElement {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P169_MajorityElement().new Solution();
		System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
	}

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
/*    	// 计数法  merge
		int limit = nums.length/2;
    	// 1 遍历整个数组放入HashMap key为数值，value为次数
		Map<Integer,Integer> map = new HashMap<>(); //构造一个具有指定初始容量和默认负载因子（0.75）的空HashMap。
		for (int num : nums) {
			map.merge(num,1,(o_val,n_val)->{return o_val+n_val;}); //它将新的值赋值给到key中（如果不存在）或更新具有给定值的现有key（UPSERT）
		}
		// 2 遍历HashMap中的每个Entry 寻找value大于半数的值
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue()>limit) return entry.getKey();
		}
    	return -1;*/

/*    	// 排序
		Arrays.sort(nums);
		return nums[nums.length/2];*/

            // 摩尔投票法，遇到相同的数，就投一票，遇到不同的数，就减一票，最后还存在票的数就是众数
            int count = 0;
            int candidate = 0;

            for (int num : nums) { // int[]{2, 2, 1, 1, 1, 2, 2}
                if (count == 0) {
                    candidate = num;
                }
                count += (num == candidate) ? 1 : -1;
            }
            return candidate;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}