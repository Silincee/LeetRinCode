package leetcode.editor.cn.doc;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: LeetCode
 * @description: 大数求和
 *      定义String变量str1和str2分别存储输入的两个大数，定义num1[]和num2[]两个int型数组，
 *      将两个字符串分别逐个字符逆序存入数组(因为要从后面加起)，定义sum[]数组存放求和结果，
 *      使用循环两个数组中的元素逐位相加，并判断是否进位，最后逆序输出数组sum[]中的每个元素。
 * @author: Silince
 * @create: 2021-04-09 19:32
 **/
public class BigSum {
    public static void main(String[] args) {
        System.out.println(new BigSum().largeIntegerSum("1933", "199"));
        System.out.println(1933+199);
    }

    private String largeIntegerSum(String numA, String numB) {
        // 将两数放入栈中
        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();
        Stack<Integer> res = new Stack<>(); // 存放结果和
        for (int i = 0; i < numA.length(); i++) {
            stackA.push(numA.charAt(i)-'0');
        }
        for (int i = 0; i < numB.length(); i++) {
            stackB.push(numB.charAt(i)-'0');
        }
        int c = 0; // 进位标志位

        // 求和
        while (!stackA.isEmpty()&&!stackB.isEmpty()){
            int add = c + stackA.pop() + stackB.pop();
            if (add<10){
                res.push(add);
                c = 0;
            }else {
                res.push(add%10);
                c = 1;
            }
        }
        // 继续加上不为空的栈
        Stack<Integer> remain = stackA.isEmpty()?stackB:stackA;
        while (!remain.isEmpty()){
            int add = c + remain.pop();
            if (add<10){
                res.push(add);
                c = 0;
            }else {
                res.push(add%10);
                c = 1;
            }

        }
        // 最高位有进位时,直接最后一个数为1
        if (c==1){
            res.push(1);
        }

        // 返回结果
        StringBuilder builder = new StringBuilder();
        while (!res.isEmpty()){
            builder.append(res.pop());
        }
        return builder.toString();
    }

    private String largeIntegerSum2(String numA, String numB) {
        int lenA = numA.length();
        int lenB = numB.length();
        int maxLen = Math.max(lenA, lenB)+1; // 多一位，因为可能会进位
        int[] arrayA = new int[maxLen];
        int[] arrayB = new int[maxLen];
        int[] result = new int[maxLen];

        // 将字符串逆序存储到数组中
        for (int i = 0; i < lenA; i++) {
            arrayA[i] = numA.charAt(lenA-i-1)-'0';
        }
        for (int i = 0; i < lenB; i++) {
            arrayB[i] = numB.charAt(lenB-i-1)-'0';
        }

        // 进行大数求和
        for (int i = 0; i < maxLen; i++) {
            int add = result[i]+ arrayA[i]+arrayB[i];
            if (add<10){ // 没有进位
                result[i] = add;
            }else { // 有进位
                int remainder = add%10; // 余数
                result[i] = remainder;
                // 放置进位,注意防止越界
                if (i!=maxLen-1){
                    result[i+1] = 1;
                }
            }
        }

        // 再将数组逆序得到最终的结果,先去掉末尾的0
        StringBuilder builder = new StringBuilder();
        int lastIndex = 0;
        for (int i = maxLen-1; i >=0 ; i--) {
            if (result[i]!=0){
                lastIndex = i;
                break;
            }
        }
        for (int i = lastIndex; i >=0 ; i--) {
            builder.append(result[i]);
        }

        return builder.toString();

    }
}
