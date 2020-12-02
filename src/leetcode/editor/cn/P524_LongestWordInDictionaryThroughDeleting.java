//给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符
//串。如果答案不存在，则返回空字符串。 
//
// 示例 1: 
//
// 
//输入:
//s = "abpcplea", d = ["ale","apple","monkey","plea"]
//
//输出: 
//"apple"
// 
//
// 示例 2: 
//
// 
//输入:
//s = "abpcplea", d = ["a","b","c"]
//
//输出: 
//"a"
// 
//
// 说明: 
//
// 
// 所有输入的字符串只包含小写字母。 
// 字典的大小不会超过 1000。 
// 所有输入的字符串长度不会超过 1000。 
// 
// Related Topics 排序 双指针 
// 👍 94 👎 0


package leetcode.editor.cn;

//通过删除字母匹配到字典里最长单词

import java.util.List;

public class P524_LongestWordInDictionaryThroughDeleting{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P524_LongestWordInDictionaryThroughDeleting().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	// s = "abpcplea", d = ["ale","apple","monkey","plea"]
    public String findLongestWord(String s, List<String> d) {
    	// 定义连个指针，一个指向s字符串，一个指向s1
		String str = "";
		for (String s1 : d) {
			// 每一次查找过程中,i依次后移，若i,j对应的两个字符相等，则j后移，如果j可以移到s1.length()，
			// 那么说明s1中对应的字符s中都有，即s中删除一些字符后，可以得到s1字符串，
			for (int i=0,j=0;i<s.length()&&j<s1.length();i++){
				if (s.charAt(i)==s1.charAt(j)) j++;
				if (j==s1.length()){
					// 比较当前的结果字符与找到的s1字符，按照题目的需求来决定是否改变结果字符
					// 找到字典里面最长的字符串;如果答案不止一个，返回长度最长且字典顺序(字母顺序)最小的字符串
					if (s1.length()>str.length()||(s1.length()==str.length()&&str.compareTo(s1)>0)){
						str=s1;
					}
				}
			}
		}
    	return str;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}