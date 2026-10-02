package java_basic.design_pattern;

/**
 * 单例模式
 * @author wheat
 * @date 2024/10/16  11:28
 */
public class Singleton {

    private static volatile Singleton instance = null;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

}
