//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 668 👎 0


package leetcode.editor.cn;

//N 皇后

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P51_NQueens {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P51_NQueens().new Solution();

    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<String>> res = new LinkedList<>();

        /* 输入棋盘边长 n，返回所有合法的放置 */
        public List<List<String>> solveNQueens(int n) {
            // '.' 表示空，'Q' 表示皇后，初始化空棋盘。
            //初始化数组
            char[][] board = new char[n][n];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    board[i][j] = '.';
                }
            }

            backtrack(board, 0);
            return res;


        }

        // row 行   col 列
        // 路径：board 中小于 row 的那些行都已经成功放置了皇后
        // 选择列表：第 row 行的所有列都是放置皇后的选择
        // 结束条件：row 超过 board 的最后一行
        public void backtrack(char[][] board, int row) {
            // 触发结束条件,最后一行都走完了，说明找到了一组，把它加入到集合res中
            if (row == board.length) {
                res.add(construct(board));
                return;
            }


            // 遍历选择列表
            for (int col = 0; col < board.length; col++) {
                if (isValid(board, row, col)) {
                    // 做选择
                    board[row][col] = 'Q';
                    // backtrack(路径，选择列表)
                    backtrack(board, row + 1);
                    // 撤销选择
                    board[row][col] = '.';
                }

            }


        }

        private boolean isValid(char[][] board, int row, int col) {

            for (int i = 0; i < row; i++) {
                if (board[i][col] == 'Q') return false;
            }

            // 右上
            for (int i = row - 1, j = col + 1; i >= 0 && j <= board.length; i--, j++) {
                if (board[i][col] == 'Q') return false;
            }

            // 左上
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board[i][col] == 'Q') return false;
            }

            return true;
        }

        //把数组转为list
        private List<String> construct(char[][] board) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                list.add(new String(board[i]));
            }
            return list;
        }


    }


//leetcode submit region end(Prohibit modification and deletion)

}