//你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
// 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 
//
// 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。 
//
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 
//
// 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。 
//
// 
//
// 示例 1: 
//
// 
//输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//输出：6
//解释：
//可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
//注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
//因为当拨动到 "0102" 时这个锁就会被锁定。
// 
//
// 示例 2: 
//
// 
//输入: deadends = ["8888"], target = "0009"
//输出：1
//解释：
//把最后一位反向旋转一次即可 "0000" -> "0009"。
// 
//
// 示例 3: 
//
// 
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], targ
//et = "8888"
//输出：-1
//解释：
//无法旋转到目标数字且不被锁定。
// 
//
// 示例 4: 
//
// 
//输入: deadends = ["0000"], target = "8888"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 死亡列表 deadends 的长度范围为 [1, 500]。 
// 目标数字 target 不会在 deadends 之中。 
// 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。 
// 
// Related Topics 广度优先搜索 
// 👍 190 👎 0


package leetcode.editor.cn;

//打开转盘锁

import java.util.HashSet;

public class P752_OpenTheLock{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P752_OpenTheLock().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	// BFS 框架，打印出所有可能的密码
    public int openLock(String[] deadends, String target) {

		HashSet<String> deads = new HashSet<>();
		for (String s : deadends) {
			deads.add(s);
		}
		// 用集合不用队列，可以快速判断元素是否存在
		HashSet<String> q1 = new HashSet<>();
		HashSet<String> q2 = new HashSet<>();
		HashSet<String> visited = new HashSet<>();

		int step = 0;
		q1.add("0000");
		q2.add(target);

		while (!q1.isEmpty()&&!q2.isEmpty()){
			// 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
			HashSet<String> temp = new HashSet<>();

			/* 将 q1 中的所有节点向周围扩散 */
			for (String cur : q1) {
				/* 判断是否到达终点 */
				if (deads.contains(cur))
					continue;
				if (q2.contains(cur))
					return step;
				visited.add(cur);

				/* 将一个节点的未遍历相邻节点加入集合 */
				for (int j = 0; j < 4; j++) {
					String up = plusOne(cur, j);
					if (!visited.contains(up))
						temp.add(up);
					String down = minusOne(cur, j);
					if (!visited.contains(down))
						temp.add(down);
				}
			}
			/* 在这里增加步数 */
			step++;
			// temp 相当于 q1
			// 这里交换 q1 q2，下一轮 while 就是扩散 q2
			q1 = q2;
			q2 = temp;
		}
		return -1;
	}

	// 将 s[j] 向上拨动一次
	private String plusOne(String s, int j) {
		char[] chars = s.toCharArray();
		if (chars[j]=='9'){ chars[j]='0';}else {chars[j]+=1;}
		return new String(chars);
	}

	// 将 s[i] 向下拨动一次
	private String minusOne(String s, int j) {
		char[] chars = s.toCharArray();
		if (chars[j]=='0'){ chars[j]='9';}else {chars[j]-=1;}
		return new String(chars);
	}


}
//leetcode submit region end(Prohibit modification and deletion)

}