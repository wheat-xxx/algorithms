package java_basic.inner_class;

/**
 * 匿名内部类（Anonymous Inner Class）： 匿名内部类是没有名字的局部内部类，通常用于实现接口或抽象类的匿名实例。
 * @author wheat
 * @date 2023/11/29  16:15
 */
public class AnonymousInnerClass {

    public void anonymousMethod() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous inner class");
            }
        };

        Thread thread = new Thread(runnable);
        thread.run();
    }

}
