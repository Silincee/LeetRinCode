//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串 
// 👍 259 👎 0


package leetcode.editor.cn;

//验证回文字符串 Ⅱ

public class P680_ValidPalindromeIi {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P680_ValidPalindromeIi().new Solution();
        System.out.println(solution.validPalindrome("abac"));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            char[] array = s.toCharArray();
            int left = 0;
            int right = array.length-1;

            while (array[left]==array[right]){
                if (left>=right) return true;
                left++;
                right--;
            }

            return isValid(array,left+1,right)||isValid(array,left,right-1);
        }

        private boolean isValid(char[] array, int left, int right) {
            while (array[left]==array[right]){
                if (left>=right) return true;
                left++;
                right--;
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}