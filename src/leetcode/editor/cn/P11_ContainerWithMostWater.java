//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针 
// 👍 1826 👎 0


package leetcode.editor.cn;

//盛最多水的容器

public class P11_ContainerWithMostWater {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P11_ContainerWithMostWater().new Solution();
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            // 双指针 + 更新最大值
            int i = 0;
            int j = height.length-1;
            int maxArea = 0;

            // 移动短板 更新最大值
            while (i<j){
                maxArea=height[i]<height[j]?
                        Math.max(maxArea,(j-i)*height[i++])
                        :Math.max(maxArea,(j-i)*height[j--]);
            }

            return maxArea;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}