//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 416 👎 0


package leetcode.editor.cn;

//找到字符串中所有字母异位词

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P438_FindAllAnagramsInAString {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P438_FindAllAnagramsInAString().new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc").toString());
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            char[] sArray = s.toCharArray();
            char[] pArray = p.toCharArray();

            HashMap<Character, Integer> need = new HashMap<>();
            HashMap<Character, Integer> window = new HashMap<>();
            for (char c : pArray) {
                need.put(c,need.getOrDefault(c,0)+1);
            }

            int left = 0; int right = 0;
            int count = 0;
            List<Integer> res = new ArrayList<>();

            while (right<s.length()){
                Character c = sArray[right];
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c))){
                    count++;
                }
                right++;

                while (right-left>p.length()){
                    Character d = sArray[left];
                    if (window.get(d).equals(need.get(d))){
                        count--;
                    }
                    window.put(d,window.get(d)-1);
                    left++;
                }

                // 后处理
                if (count==need.keySet().size()){
                    res.add(left);
                }
            }

            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}