//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 202 👎 0


package leetcode.editor.cn;

//字符串的排列

import java.util.HashMap;
import java.util.Map;

public class P567_PermutationInString {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P567_PermutationInString().new Solution();
        System.out.println(solution.checkInclusion("abac","ccabaa"));    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            HashMap<Character, Integer> window = new HashMap<>();
            HashMap<Character, Integer> need = new HashMap<>();

            for (char c : s1.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            int left = 0;
            int right = 0;
            int valid = 0;


            while (right < s2.length()) {
                char c = s2.charAt(right);
                right++;
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    // 更新valid
                    if (window.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }

                // 何时缩小窗口
                while ((right - left) >= s1.length()) {

                    if (valid == need.size()) return true;

                    char d = s2.charAt(left);
                    left++;

                    if (need.containsKey(d)) {
                        if (window.get(d).equals(need.get(d))) {
                            valid--;
                        }
                        window.put(d,window.get(d)-1);
                    }
                }

            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}