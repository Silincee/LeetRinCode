package leetcode.editor.cn.doc;

/**
 * @program: LeetCode
 * @description: 小根堆
 * @author: Silince
 * @create: 2021-03-21 17:39
 **/
public class MinHeapSort {
    public static void sort(int[] arr) {
        buildHeap(arr);

        int length = arr.length;
        for (int i = arr.length-1; i > 0 ; i--) {
            int temp  = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            length--;
            sink(arr,0,length);
        }
    }

    private static void sink(int[] arr, int index, int length) {
        int leftChild = index*2+1;
        int rightChild  = index*2+2;
        int present = index;

        if (leftChild<length && arr[leftChild]<arr[present]){
            present = leftChild;
        }
        if (rightChild<length && arr[rightChild]<arr[present]){
            present = rightChild;
        }

        if (present!=index){
            int temp = arr[present];
            arr[present]  = arr[index];
            arr[index] = temp;
            sink(arr,present,length);

        }
    }

    private static void buildHeap(int[] arr) {
        for (int i = arr.length/2; i >= 0 ; i--) {
            sink(arr,i,arr.length);
        }
    }


    public static void main(String[] args) {
        //[ 8，2，5，9，7，3 ]
        int[] arr = new int[]{8, 2, 5, 9, 7, 3};
        sort(arr);
        for (int i : arr) {
            System.out.print(i);
        }
    }
}
