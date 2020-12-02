//给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下： 
//
// 
// 二叉树的根是数组中的最大元素。 
// 左子树是通过数组中最大值左边部分构造出的最大二叉树。 
// 右子树是通过数组中最大值右边部分构造出的最大二叉树。 
// 
//
// 通过给定的数组构建最大二叉树，并且输出这个树的根节点。 
//
// 
//
// 示例 ： 
//
// 输入：[3,2,1,6,0,5]
//输出：返回下面这棵树的根节点：
//
//      6
//    /   \
//   3     5
//    \    / 
//     2  0   
//       \
//        1
// 
//
// 
//
// 提示： 
//
// 
// 给定的数组的大小在 [1, 1000] 之间。 
// 
// Related Topics 树 
// 👍 203 👎 0


package leetcode.editor.cn;

//最大二叉树

import leetcode.editor.cn.utils.TreeNode;

import javax.swing.*;

public class P654_MaximumBinaryTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P654_MaximumBinaryTree().new Solution();
        solution.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            // 迭代构造二叉树
            if (nums.length==0) return null;
            return build(nums,0,nums.length-1);
        }

        // 迭代生成子树
        public TreeNode build(int[] nums, int low, int high) {
            // 终止条件
            if (low>high) return null;
            // 找到最大值的值和索引
            int maxVal = Integer.MIN_VALUE;
            int maxIndex = -1;
            for (int i = low; i <=high; i++) {
                if (nums[i]>maxVal){
                    maxIndex=i;
                    maxVal = nums[i];
                }
            }
            TreeNode root = new TreeNode(maxVal);
            root.left=build(nums,low,maxIndex-1);
            root.right=build(nums,maxIndex+1,high);

            return root;

        }


    }


//leetcode submit region end(Prohibit modification and deletion)

}