package leetcode.editor.cn.doc;

/**
 * @program: LeetCode
 * @description:
 * @author: Silince
 * @create: 2020-12-02 22:09
 **/
public class Singleton {

    private static volatile Singleton instance;

    private Singleton() {

    }

   private static class SingletonInstance{
        private static final Singleton INSTANCE = new Singleton();
   }

   public static Singleton getInstance(){
        return SingletonInstance.INSTANCE;
   }
}
