//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
// 输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
// 输出: [1]
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 515 👎 0


package leetcode.editor.cn;

//前 K 个高频元素

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class P347_TopKFrequentElements{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P347_TopKFrequentElements().new Solution();
		 System.out.println(solution.topKFrequent(new int[]{1, 1, 1, 2, 2,3 ,3,3}, 2));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

		// 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (map.containsKey(num)){
				map.put(num,map.get(num)+1);
			}else{
				map.put(num,1);
			}
		}

		// 桶排序 将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
		// 把频率作为桶/数组下标，再存入对应的数
		List<Integer>[] list = new List[nums.length+1]; // 最大频率为nums.length
		for (Integer key : map.keySet()) {
			// 获取出现的次数作为下标
			int i = map.get(key);
			if (list[i]==null){
				list[i]=new ArrayList<>();
			}
			list[i].add(key);
		}

		// 倒序遍历数组获取出现顺序从大到小的排列
		List<Integer> res = new ArrayList();
		for(int i = list.length - 1;i >= 0 && res.size() < k;i--){
			if(list[i] == null) continue;
			res.addAll(list[i]);
		}

		// list转数组
		int[] arr = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			arr[i]= res.get(i);
		}

    	return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}