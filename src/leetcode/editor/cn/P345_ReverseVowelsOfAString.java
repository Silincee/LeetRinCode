//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 113 👎 0


package leetcode.editor.cn;

//反转字符串中的元音字母

import java.util.Arrays;

public class P345_ReverseVowelsOfAString {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P345_ReverseVowelsOfAString().new Solution();
        solution.reverseVowels("ccAccEcUccOc");
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            String str = "aeuioAEUIO";
            // cc a cc e c u cc o c  -->  cc o cc u c e cc a c
            int i = 0;
            int j = s.length() - 1;

            char[] chars = s.toCharArray();

            while (i < j) {
                if (str.indexOf(chars[i]) != -1) { // 判断元音 String s = "aeiouAEIOU"; s.indexOf(ch)!=-1
                    if (str.indexOf(chars[j]) != -1) {
                        char temp = chars[i];
                        chars[i] = chars[j];
                        chars[j] = temp;
						i++;
						j--;
                    }else {
						j--; //j 不是元音 ++
					}
                } else {i++;} // i 不是元音 ++
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}