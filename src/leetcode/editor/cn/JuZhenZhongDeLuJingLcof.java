//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果
//一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。 
//
// [["a","b","c","e"], 
//["s","f","c","s"], 
//["a","d","e","e"]] 
//
// 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 深度优先搜索 
// 👍 219 👎 0


package leetcode.editor.cn;

//矩阵中的路径

public class JuZhenZhongDeLuJingLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new JuZhenZhongDeLuJingLcof().new Solution();
    }

    //力扣代码 https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
    	// board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
		public boolean exist(char[][] board, String word) {
			char[] words = word.toCharArray();
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (dfs(board, words, i, j, 0)) return true;
				}
			}
			return false;
		}

		boolean dfs(char[][] board, char[] word, int i, int j, int k) {
			if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
			if (k==word.length-1) return true;

			// 标记当前矩阵元素： 将 board[i][j] 修改为 空字符 '\0' ，代表此元素已访问过，防止之后搜索时重复访问。
			board[i][j] = '\0';

			// 搜索下一单元格： 朝当前元素的 上、下、左、右 四个方向开启下层递归，
			// 使用 或 连接 （代表只需找到一条可行路径就直接返回，不再做后续 DFS ），并记录结果至 res 。
			boolean res = dfs(board,word,i-1,j,k+1)|| dfs(board,word,i+1,j,k+1) ||
					dfs(board,word,i,j-1,k+1) || dfs(board,word,i,j+1,k+1);

			// 还原当前矩阵元素： 将 board[i][j] 元素还原至初始值，即 word[k] 。
			board[i][j] = word[k];

			return res;
		}
    }
//leetcode submit region end(Prohibit modification and deletion)

}