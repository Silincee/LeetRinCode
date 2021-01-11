//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 846 👎 0


package leetcode.editor.cn;

//最小覆盖子串

import java.util.Arrays;
import java.util.HashMap;

public class P76_MinimumWindowSubstring {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P76_MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public String minWindow(String s, String t) {
		// 需要返回的结果
		int start = 0;
		int len = Integer.MAX_VALUE;


		// 需要的字符散列表 全部初始化为1(表示需要)
		HashMap<Character, Integer> need = new HashMap<>();
		for (char key : t.toCharArray()) {
			need.put(key, need.getOrDefault(key, 0) + 1);
		}
		HashMap<Character, Integer> window = new HashMap<>();// 用于记录「窗口」中的相应字符的出现次数

		int left = 0, right = 0;
		int valid = 0; // 表示窗口中满足need条件的字符个数
		char[] sArray = s.toCharArray();

		while (right < sArray.length) {
			// c 是将移入窗口的字符
			char c = sArray[right];
			// 右移窗口
			right++;
			// 进行窗口内数据的一系列更新
			if (need.containsKey(c)){
				window.put(c,window.getOrDefault(c,0)+1);
				// 更新valid参数
				if (window.get(c).equals(need.get(c))){
					valid++;
				}
			}

			/*** debug 输出的位置 ***/
			System.out.println("window: [" + left + "," + right + "]\n");
			/********************/

			// 判断左侧窗口是否要收缩
			while (valid == need.size()) {
				// 收缩的时候更新子串
				if (right-left<left){
					start = left;
					len = right-left;
				}

				// d 是将移出窗口的字符
				char d = sArray[left];
				// 左移窗口
				left++;
				// 进行窗口内数据的一系列更新
				if (need.containsKey(d)){
					if (window.get(d).equals(need.get(d))){
						valid--;
					}
					window.put(d,window.get(d)-1);
				}
			}
		}
		return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}