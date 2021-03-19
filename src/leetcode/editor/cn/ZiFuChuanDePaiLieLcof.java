//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 165 👎 0


package leetcode.editor.cn;

//字符串的排列

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ZiFuChuanDePaiLieLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	List<String> res = new LinkedList<>();
	char[] c;

	public String[] permutation(String s) {
		c = s.toCharArray();
		dfs(0);
		return res.toArray(new String[res.size()]);
	}

	void dfs(int x) {
		if(x == c.length - 1) {
			res.add(String.valueOf(c)); // 添加排列方案
			return;
		}
		HashSet<Character> set = new HashSet<>();
		for(int i = x; i < c.length; i++) {
			if(set.contains(c[i])) continue; // 重复，因此剪枝
			set.add(c[i]);
			swap(i, x); // 交换，将 c[i] 固定在第 x 位
			dfs(x + 1); // 开启固定第 x + 1 位字符
			// 每次向下递归会交换两字符，回溯上来时，要把字符列表恢复至“交换前”的排序，这样才能保证下次交换是按照“全排列”的顺序进行的。
			// 例如 abc ，a 交换的顺序应该是 a和b交换、a和c交换；那么在a和b交换完后就需要恢复，这样才能进行 a和c交换~
			swap(i, x); // 恢复交换
		}
	}

	void swap(int a, int b) {
		char tmp = c[a];
		c[a] = c[b];
		c[b] = tmp;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}