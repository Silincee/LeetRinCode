package leetcode.editor.cn.doc;


import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class Test {
    private static LinkedList<Integer> res = new LinkedList<>();
    private static LinkedList<Integer> path = new LinkedList<>();
    private static int minMilk = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int count = sc.nextInt(); // 多少组测试数据
            for (int i = 0; i < count; i++) {
                int n = sc.nextInt(); // n个需求
                int[][] arr = new int[n][2];
                for (int j = 0; j < n; j++) {
                    arr[j][0] = sc.nextInt();
                    arr[j][1] = sc.nextInt();
                }
                backTrack(arr,path,0);
                minMilk = Integer.MAX_VALUE;

                System.out.println();
                for (Integer integer : res) {
                    System.out.print(integer+1+" ");
                }
                if (i<=count-1){
                    System.out.println();
                }

            }

        }
    }

    private static void backTrack(int[][] arr,LinkedList<Integer> path,int milk) {
        if (path.size() ==arr.length){
           if (milk<minMilk){
               minMilk = milk;
               res = new LinkedList<>(path);
           }
        }
        // 选择列表 做选择
        for (int i = 0; i < arr.length; i++) {
            if (!path.contains(i)){
                path.add(i);

                int nowDays = 0;
                int nowMilk = 0;
                if (path.size()==1){
                    milk = 0;
                }else {
                    for (int index : path) {
                        nowMilk = nowMilk + arr[index][1] * nowDays;
                        if (nowMilk>minMilk){
                            continue;
                        }
                        nowDays += arr[index][0];
                    }
                }

                backTrack(arr,path,nowMilk);
                path.removeLast();
            }
        }
    }


}

//4
//4
//3 4
//1 100
//2 2
//5 5
//3
//1 1
//2 2
//3 3
//5
//3 2
//3 5
//365 999
//2 3
//1 1
//3
//123 123
//3 3
//5 5