//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的子串。 
//
// 示例1: 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 
//
// 示例2: 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 注意： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 202 👎 0


package leetcode.editor.cn;

//字符串的排列

import java.util.HashMap;
import java.util.Map;

public class P567_PermutationInString {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P567_PermutationInString().new Solution();
        System.out.println(solution.checkInclusion("aba","aacbaa"));    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {

            // need 和 window 散列表 初始化need
            HashMap<Character, Integer> need = new HashMap<>();
            for (char key : s1.toCharArray()) {
                need.put(key, need.getOrDefault(key, 0) + 1);
            }
            for (Map.Entry<Character, Integer> characterIntegerEntry : need.entrySet()) {
                System.out.println(characterIntegerEntry);
            }

            HashMap<Character, Integer> window = new HashMap<>();

            // 滑动窗口指针 left/right 统计参数valid
            int left = 0;
            int right = 0;
            int valid = 0;

            // 开始滑动
            char[] sArray = s2.toCharArray();
            while (right < sArray.length) {
                // right 增加
                Character c = sArray[right];
                right++;
                // 进行一系列的更新
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    // 更新valid
                    if (window.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }

                // 缩小窗口的时机： 窗口大小>=s1.length,因为排列必须保持长度一致
                while ((right - left) >= s1.length()) {
                    // 当发现 valid == need.size() 时，就说明窗口中就是一个合法的排列，所以立即返回 true
                    // 注意 need.size()和s1.length() 是不相等的，因为s1中可能有重复字符
                    if (valid == need.size()) {

                        return true;
                    }

                    Character d = sArray[left];
                    left++;
                    // 进行一系列的更新
                    if (need.containsKey(d)) {
                        // 更新valid
                        if (window.get(d).equals(need.get(d))) {
                            valid--;
                        }
                        window.put(d, window.get(d) - 1);
                    }
                }
            }
            return false; //未找到子串
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}