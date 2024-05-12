package java_basic.inner_class;

/**
 * 局部内部类（Local Inner Class）： 局部内部类是定义在方法或作用域内的类。它只能在定义它的方法或作用域内使用
 * @author wheat
 * @date 2023/11/29  16:11
 */
public class LocalInnerClass {

    public void outerMethod() {
        class InnerClass {
            public void localInnerMethod() {
                System.out.println("Local inner method");
            }
        }

        InnerClass innerClass = new InnerClass();
        innerClass.localInnerMethod();
    }

}
