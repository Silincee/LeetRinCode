//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 548 👎 0


package leetcode.editor.cn;

//回文子串

public class P647_PalindromicSubstrings{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P647_PalindromicSubstrings().new Solution();
		 System.out.println(solution.countSubstrings("aaa"));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	 	private  int res=0;
    public int countSubstrings(String s) {
		for (int i = 0; i < s.length(); i++) {
			palindrome(s,i,i);
			palindrome(s,i,i+1);
		}
    	return res;
    }

	private void palindrome(String s, int left, int right) {
    	while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
    		left--;
    		right++;
    		res++;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}