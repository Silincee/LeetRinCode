package leetcode.editor.cn.domain;

/**
 * @program: LeetCode
 * @description: Definition for a binary tree node.
 * @author: Silince
 * @create: 2020-09-25 09:21
 **/
public class TreeFactory {

    public static TreeNode creatTree() {
        // 前序遍历 preorder = [3,9,20,15,7]
        //中序遍历 inorder = [9,3,15,20,7]
        int[] preorder = new int[]{1,2,4,3,2,4,4}; // 1243244
        int[] inorder = new int[]{4,2,1,4,2,3,4};

        return buildTree(preorder,inorder);
    }



    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1);
    }


    // 若前序遍历数组为 preorder[preStart..preEnd]，
    // 中续遍历数组为 inorder[inStart..inEnd]，
    // 构造二叉树，返回该二叉树的根节点
    private static TreeNode build(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
        // 递归出口
        if (preStart>preEnd){
            return null;
        }

        // 先构建根节点 再递归生成左右子树
        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 再中序数组中的索引
        int index = 0;
        for (int i = inStart; i <= inEnd ; i++) {
            if (inorder[i]==rootVal){
                index=i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);

        // 递归构造左右子树
        int leftSize = index-inStart;
        root.left = build(preorder,preStart+1,preStart+leftSize,inorder,inStart,index-1);
        root.right = build(preorder,preStart+leftSize+1,preEnd,inorder,index+1,inEnd);

        return root;

    }
}

