//给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。 
//
// 
//
// 示例： 
//
// 输入: "sea", "eat"
//输出: 2
//解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
// 
//
// 
//
// 提示： 
//
// 
// 给定单词的长度不超过500。 
// 给定单词中的字符只含有小写字母。 
// 
// Related Topics 字符串 
// 👍 164 👎 0


package leetcode.editor.cn;

//两个字符串的删除操作

public class P583_DeleteOperationForTwoStrings{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P583_DeleteOperationForTwoStrings().new Solution();
		 int a = solution.minDistance("", "a");
		 System.out.println(a);
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int lcs = longestCommonSubsequence(word1,word2,m,n);
		return m-lcs+n-lcs;

    }

    public int longestCommonSubsequence(String s1,String s2,int m,int n){
		int[][] dp = new int[m+1][n+1];

		for (int i = 1; i <=m; i++) {
			for (int j = 1; j <=n; j++) {
				if (s1.charAt(i-1)==s2.charAt(j-1)){
					dp[i][j]= dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}

			}

		}
		return dp[m][n];
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}