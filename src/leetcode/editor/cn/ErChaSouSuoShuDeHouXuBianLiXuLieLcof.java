//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 171 👎 0


package leetcode.editor.cn;

//二叉搜索树的后序遍历序列

public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion) https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
class Solution {
    public boolean verifyPostorder(int[] postorder) { // [1 3 2 6 5]
		return recur(postorder,0,postorder.length-1);
    }

	private boolean recur(int[] postorder, int i, int j) {
    	if (i>=j) return true;

    	int	p = i;
    	while (postorder[p]<postorder[j]) p++; // 左子树区间 [i,m−1] 内的所有节点都应 < postorder[j]
    	int m = p; // 遍历后序遍历的 [i,j] 区间元素，寻找 第一个大于根节点 的节点，索引记为 m
    	while (postorder[p]>postorder[j]) p++; // 右子树区间 [m,j−1] 内的所有节点都应 > postorder[j]
    	return p==j&&recur(postorder,i,m-1)&&recur(postorder,m,j-1);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}