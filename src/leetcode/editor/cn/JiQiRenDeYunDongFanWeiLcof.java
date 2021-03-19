//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// 👍 201 👎 0


package leetcode.editor.cn;

//机器人的运动范围

import java.util.LinkedList;

public class JiQiRenDeYunDongFanWeiLcof {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new JiQiRenDeYunDongFanWeiLcof().new Solution();
		System.out.println(solution.movingCount(3, 4, 2));
	}

    //力扣代码 https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/mian-shi-ti-13-ji-qi-ren-de-yun-dong-fan-wei-dfs-b/
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int movingCount(int m, int n, int k) {
			boolean[][] visited = new boolean[m][n];
			int res = 0;

			LinkedList<int[]> queue = new LinkedList<>();
			queue.offer(new int[]{0,0,0,0});
			while (queue.size()>0){
				int[] x  =queue.poll();
				int i = x[0],j=x[1],si=x[2],sj=x[3];
				if(i >= m || j >= n || k < si + sj || visited[i][j]) continue;
				visited[i][j] = true;
				res++;
				queue.offer(new int[] { i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj });
				queue.offer(new int[] { i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8 });
		}
			return res;
		}

    }
//leetcode submit region end(Prohibit modification and deletion)

}