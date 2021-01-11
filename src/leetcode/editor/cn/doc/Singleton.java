package leetcode.editor.cn.doc;

/**
 * @program: LeetCode
 * @description:
 * @author: Silince
 * @create: 2020-12-02 22:09
 **/
public class Singleton {

    private static final Singleton instance = new Singleton();

    private Singleton(){}

    public static Singleton getSingleton() {
        return instance;
    }
}
