//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 64 👎 0


package leetcode.editor.cn;

//第一个只出现一次的字符

import java.util.HashMap;

public class DiYiGeZhiChuXianYiCiDeZiFuLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
	 }
//力扣代码 https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/solution/mian-shi-ti-50-di-yi-ge-zhi-chu-xian-yi-ci-de-zi-3/
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
		HashMap<Character, Boolean> dict = new HashMap<>();
		char[] sc = s.toCharArray();
		for (char c : sc) {
			dict.put(c,!dict.containsKey(c));
		}
		for (char c : sc) {
			if (dict.get(c)) return c;
		}
		return ' ';
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}