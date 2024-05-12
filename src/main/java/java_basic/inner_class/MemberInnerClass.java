package java_basic.inner_class;

/**
 * 成员内部类（Member Inner Class）： 成员内部类是定义在另一个类的内部的类。它可以访问外部类的所有成员，包括私有成员
 * @author wheat
 * @date 2023/11/29  16:07
 */
public class MemberInnerClass {

    private int outerVar;

    public class InnerClass {
        public void innerMethod(){
            outerVar = 10;    // 访问外部类的成员
            System.out.println("Inner method");
        }
    }

}
