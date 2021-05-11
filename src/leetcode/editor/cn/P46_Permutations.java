//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 994 👎 0


package leetcode.editor.cn;

//全排列

import java.util.LinkedList;
import java.util.List;

public class P46_Permutations {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P46_Permutations().new Solution();
        solution.permute(new int[]{1,2,3});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
   List<List<Integer>> res = new LinkedList<>();

   public List<List<Integer>> permute(int[] nums) {

       LinkedList<Integer> list = new LinkedList<>();
       backtrack(list,nums);
       return res;
   }

   public void backtrack(LinkedList<Integer> list,int[] arr){
       if (list.size()==arr.length){
           res.add(new LinkedList<>(list));
           return;
       }

       for (int num : arr) {
           if (!list.contains(num)){
               list.add(num);
               backtrack(list,arr);
               list.removeLast();
           }
       }
   }


}
//leetcode submit region end(Prohibit modification and deletion)

}