//给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "eleetminicoworoep"
//输出：13
//解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcodeisgreat"
//输出：5
//解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
// 
//
// 示例 3： 
//
// 
//输入：s = "bcbcbc"
//输出：6
//解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 x 10^5 
// s 只包含小写英文字母。 
// 
// Related Topics 字符串 
// 👍 340 👎 0


package leetcode.editor.cn;

//每个元音包含偶数次的最长子字符串

import java.util.Arrays;

public class P1371_FindTheLongestSubstringContainingVowelsInEvenCounts{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1371_FindTheLongestSubstringContainingVowelsInEvenCounts().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {// 1 4   4-1=3
	// eleetm   最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
    public int findTheLongestSubstring(String s) {

		int n = s.length();
		// 1左移5次 相当于2^5，从00000-11111种状态，代表5个元音字母的个数是否为偶数，0代表偶数，1代表奇数
		int[] pos = new int[1 << 5];
		Arrays.fill(pos, -1);
		int ans = 0, status = 0;
		pos[0] = 0;
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			if (ch == 'a') {
				status ^= (1 << 0);
			} else if (ch == 'e') {
				status ^= (1 << 1);
			} else if (ch == 'i') {
				status ^= (1 << 2);
			} else if (ch == 'o') {
				status ^= (1 << 3);
			} else if (ch == 'u') {
				status ^= (1 << 4);
			}
			if (pos[status] >= 0) {
				ans = Math.max(ans, i + 1 - pos[status]);
			} else {
				pos[status] = i + 1;
			}
		}
		return ans;

    }

    //
}
//leetcode submit region end(Prohibit modification and deletion)

}