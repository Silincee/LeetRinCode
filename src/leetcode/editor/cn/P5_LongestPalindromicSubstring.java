//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3496 👎 0


package leetcode.editor.cn;

//最长回文子串

public class P5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P5_LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("babad"));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private String res = "";

        // babad
        public String longestPalindrome(String s) {
            for (int i = 0; i < s.length(); i++) {
                palindrome(s, i, i);
                palindrome(s, i, i + 1);
            }
            return res;
        }

        // 寻找最长回文串函数
        private void palindrome(String s, int left, int right) {
            while (left >= 0 && right < s.length()&&s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
            }
            res = s.substring(left + 1, right + 1 - 1).length() > res.length() ? s.substring(left + 1, right + 1 - 1) : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}