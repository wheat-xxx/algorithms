package java_basic.inner_class;

/**
 * 静态嵌套类（Static Nested Class）： 静态嵌套类是定义在另一个类的内部，但被声明为静态的类。它与普通的类类似，不依赖于外部类的实例
 * @author wheat
 * @date 2023/11/29  16:20
 */
public class StaticNestedClass {

    private static int outerVal;

    public class InnerClass{
        public void staticNestedClass() {
            outerVal = 10;  // 访问外部类的静态成员
            System.out.println("Static nested method");
        }
    }

}
