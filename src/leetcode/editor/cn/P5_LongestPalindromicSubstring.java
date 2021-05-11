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

public class P5_LongestPalindromicSubstring{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P5_LongestPalindromicSubstring().new Solution();
		 System.out.println(solution.longestPalindrome("babad"));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	// babad
    public String longestPalindrome(String s) {
    	String res="";
		for (int i = 0; i < s.length(); i++) {
			// 找到以 s[i] 为中心的回文串
			String s1 = palindrome(s,i,i);
			res = res.length()>s1.length()?res:s1;

			// 找到以 s[i] 和 s[i+1] 为中心的回文串
			String s2 = palindrome(s, i, i + 1);
			res = res.length()>s2.length()?res:s2;
		}
		return res;
    }

    // 寻找最长回文串函数
	private String palindrome(String s, int left, int right) {
    	// 防止索引越界
		while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
			// 双向展开
			left--;
			right++;
		}
		// 返回以s[left]和s[right]为中心的最长回文串
		return s.substring(left+1,right);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}