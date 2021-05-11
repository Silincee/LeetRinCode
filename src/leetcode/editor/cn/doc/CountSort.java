package leetcode.editor.cn.doc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: LeetCode
 * @description:
 * @author: Silince
 * @create: 2021-03-26 10:42
 **/
public class CountSort {
    public static void main(String[] args) {
        CountSort.countSort(new int[]{10,30,20,50,40});
    }

    private static int[]  countSort(int[] nums){
        ArrayList<Integer> res = new ArrayList<>();
        List<Integer>[] buckets = new ArrayList[101];

        for (int num : nums) {
            if (buckets[num]==null) buckets[num] = new ArrayList<Integer>();
            buckets[num].add(num);
        }

        for (List bucket : buckets) {
            if (bucket!=null){
                for (Object o : bucket) {
                    res.add((Integer) o);
                }
            }
        }


        return res.stream().mapToInt(Integer::intValue).toArray();

    }
}
