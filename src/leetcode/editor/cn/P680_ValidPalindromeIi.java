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
        solution.validPalindrome("abceba");
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            // 最多删除一个字符
            // 在遇到不同的时候,移除一个元素（左/右）
            int i = 0;
            int j = s.length()-1;
            while(i<j){
                if (s.charAt(i)!=s.charAt(j)){
                    return isStr(s,i,j-1)||isStr(s,i+1,j);
                }
                i++;
                j--;
            }
            return true;
        }
        // 判断是否是回文字符串
        public boolean isStr(String str,int i,int j){
            while(i<j){
                if (str.charAt(i)!=str.charAt(j)){
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}