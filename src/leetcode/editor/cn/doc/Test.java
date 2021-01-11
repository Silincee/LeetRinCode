package leetcode.editor.cn.doc;


import java.util.Arrays;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[] { 5, 4, 8, 6, 3, 9, 0, 1, 7, 2 };
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (end <= start) { // 只有一个元素时终止
            return;
        }
        int low = start;
        int high = end;
        int pivot = arr[low]; // 枢纽点pivot选取第一个元素
        while (low < high) {
            // high指针往左寻找一个小于 pivot的数
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high]; // 将小于 pivot 的数放在低位

            // low指针往右寻找一个大于 pivot 的数
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low]; // 将大于 pivot 的数放在高位
        }
        // 复原 pivot的值
        arr[low] = pivot;
        quickSort(arr, start, low - 1); // 递归排序左半部分
        quickSort(arr, low + 1, end); // 递归排序右半部分
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

