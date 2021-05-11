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
        public int lengthOfLongestSubstring(String s){

            char[] array = s.toCharArray();
            HashMap<Character, Integer> window = new HashMap<>();
            for (char c : array) {
                window.put(c,0);
            }

            int left = 0;
            int right = 0;
            int res = 0;

            while (right<array.length){
                char c = array[right];
                window.put(c,window.get(c)+1);
                right++;

                while (window.get(c)>1){
                    char d = array[left];
                    left++;
                    window.put(d,window.get(d)-1);
                }

                res = Math.max(res,right-left);

            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}