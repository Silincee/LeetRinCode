//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"012
//3"都表示数值，但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。 
//
// 
// Related Topics 数学 
// 👍 141 👎 0


package leetcode.editor.cn;

//表示数值的字符串

import java.util.HashMap;
import java.util.Map;

public class BiaoShiShuZhiDeZiFuChuanLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new BiaoShiShuZhiDeZiFuChuanLcof().new Solution();
	 	 solution.isNumber("a");
	 }
//力扣代码 https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/solution/mian-shi-ti-20-biao-shi-shu-zhi-de-zi-fu-chuan-y-2/
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNumber(String s) {
		Map[] states = {
			new HashMap<>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
			new HashMap<>() {{ put('d', 2); put('.', 4); }},                           // 1.
			new HashMap<>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
			new HashMap<>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
			new HashMap<>() {{ put('d', 3); }},                                        // 4.
			new HashMap<>() {{ put('s', 6); put('d', 7); }},                           // 5.
			new HashMap<>() {{ put('d', 7); }},                                        // 6.
			new HashMap<>() {{ put('d', 7); put(' ', 8); }},                           // 7.
			new HashMap<>() {{ put(' ', 8); }}                                         // 8.
		};
		int p = 0; // 表示当前状态
		char t;
		for(char c : s.toCharArray()) {
			if(c >= '0' && c <= '9') t = 'd';
			else if(c == '+' || c == '-') t = 's';
			else if(c == 'e' || c == 'E') t = 'e';
			else if(c == '.' || c == ' ') t = c; // 即用字符本身表示字符类型
			else t = '?';
			if(!states[p].containsKey(t)) return false;
			p = (int)states[p].get(t);
		}
		return p == 2 || p == 3 || p == 7 || p == 8;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}