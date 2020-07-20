package Array;

/**
 * @description: 1051 高度检查器 [桶排序]
 * @param: [heights]
 * @return: int 让所有学生以 非递减 高度排列的最小必要移动人数
 * @author: Silince
 * @date: 2020-07-20
 */
public class Test1051 {
    private static int heightChecker(int[] heights) {
        int[] arr = new int[101];

        for (int height : heights) {
            arr[height]++;
        }

        int count = 0;
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i) count++;
            }
        }


        return count;
    }

    public static void main(String[] args) {
        // aim: [1,1,1,2,3,4]
        System.out.println(heightChecker(new int[]{1, 1, 4, 2, 1, 3}));

    }
}
