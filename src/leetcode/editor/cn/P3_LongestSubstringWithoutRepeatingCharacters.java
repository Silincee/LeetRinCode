//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4656 👎 0


package leetcode.editor.cn;

//无重复字符的最长子串

import java.util.HashMap;

public class P3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            // window计数器
            HashMap<Character, Integer> window = new HashMap<>();

            int left = 0;int right = 0;
            int result = 0; // 记录结果

            char[] sArray = s.toCharArray();
            while (right < s.length()) {
            	// right扩大
                Character c = sArray[right];
                right++;
				// 进行窗口内数据的一系列更新
                window.put(c, window.getOrDefault(c, 0) + 1);

                // 何时收缩？ 当前字符计数值大于1时收缩
                while (window.get(c) > 1) {
                    Character d = sArray[left];
                    left++;
					// 进行窗口内数据的一系列更新
                    window.put(d, window.get(d) - 1);
                }

                // 收缩结束 已经没有重复字符(在这里更新答案)
                result = Math.max(result, right - left);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}