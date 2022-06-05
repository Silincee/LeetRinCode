package leetcode.editor.cn.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description: 测试
 * @author: zhongye
 * @create: 2021-06-07 10:03
 **/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Test {
    // 现在他给了你一个可重集合，并希望你从中选出一个尽可能大的子集使得其中没有两个数是“连续”的（连续是指即这两个数之差的绝对值不超过1）。
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int count = sc.nextInt();
            int[] arr = new int[count];
            for (int i = 0; i < count; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(getResult(arr));
        }
    }
    // 6
    //-1 3 -5 2 -1 3
    public static int getResult(int[] arr){
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>0){
                int temp = getReverseArr(Arrays.copyOfRange(arr, i, arr.length));
                if(temp>res){
                    res = temp;
                }
            }
        }
        return res;
    }

    // 3 -5 2 -1 3
    private static int getReverseArr(int[] arr) {
        int res = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>0){
                left = i;
            }
            if(arr[i]<0){
                right = i;
                int temp = getMaxSum(arr,left,right);
                if(temp>res){
                    res = temp;
                }
            }
        }
        return res;
    }

    private static int getMaxSum(int[] arr, int left, int right) {
        int[] nums = new int[arr.length];
        for (int i = 0; i < left; i++) {
            nums[i] = arr[i];
        }
        for (int i = right+1; i < arr.length; i++) {
            nums[i] = arr[i];
        }
        for (int i = right; i >=left; i--) {
            nums[left+(right-i)] = arr[i];
        }

        int n = nums.length;
        if(n==0){
            return 0;
        }
        int dp0 = nums[0];
        int dp1 = 0;
        int res = dp0;
        for (int i = 0; i < n; i++) {
            dp1 = Math.max(nums[i],nums[i]+dp0);
            dp0 = dp1;
            res = Math.max(res,dp1);
        }
        return res;

    }

}
