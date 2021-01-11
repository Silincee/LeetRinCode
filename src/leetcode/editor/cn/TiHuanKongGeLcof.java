//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 55 👎 0


package leetcode.editor.cn;

//替换空格

public class TiHuanKongGeLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new TiHuanKongGeLcof().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
			StringBuilder res = new StringBuilder();
			for (char c : s.toCharArray()) {
				if (c==' ') res.append("%20");
				else  res.append(c);
			}
			return res.toString();

		}
    }
//leetcode submit region end(Prohibit modification and deletion)

}