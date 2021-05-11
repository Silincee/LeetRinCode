//猜数字游戏的规则如下： 
//
// 
// 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。 
// 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。 
// 
//
// 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）： 
//
// 
// -1：我选出的数字比你猜的数字小 pick < num 
// 1：我选出的数字比你猜的数字大 pick > num 
// 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num 
// 
//
// 返回我选出的数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10, pick = 6
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 1, pick = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：n = 2, pick = 1
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：n = 2, pick = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 1 <= pick <= n 
// 
// Related Topics 二分查找 
// 👍 115 👎 0


package leetcode.editor.cn;

//猜数字大小

public class P374_GuessNumberHigherOrLower{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P374_GuessNumberHigherOrLower().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)


public class Solution  {
    public int guessNumber(int n) {
        int left = 0;
        int right = n;

        while (left<=right){
			int m = (right-left)/2+left;

        	if (guess(m)==1){
        		left = m+1;
			}else if(guess(m)==-1){
        		right=m-1;
			}else if (guess(m)==0){
        		return m;
			}
		}
        return -1;
    }

	private int guess(int m) {
    	return -1;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}