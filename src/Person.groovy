import groovy.transform.PackageScope

//Groovy 默认会隐式的创建getter、setter方法，并且会提供带参的构造器，下面两者是等价的。
class Person {
    //Groovy 中默认是public的
    /**Groovy 定义变量的方式和 Java 是类似的，
     * 区别在于 Groovy 提供了def关键字供使用，
     * 它可以省略变量类型的定义，根据变量的值进行类型推导。**/
    def sex
    String name
    @PackageScope
    int age

    static String TAG = "Person"
    static void main(args) {
        /**
         * Groovy为 数字类型提供一种更简单的声明类型的方式：类型后缀
         - Integer 使用I或i
         - Long 使用L或l
         - BigInteger 使用G或g
         - BigDecimal 使用G或g
         - Double 使用D或d
         - Float 使用F或f
         */
        def a = 123I
        assert a instanceof Integer
        def b = 123L
        assert b instanceof Long
    }
}

// In Java
//public class Person {
//    private String name;
//    Person(String name) {
//        this.name = name
//    }
//    public String getName() {
//        return name
//    }
//    public void setName(String name) {
//        this.name = name
//    }
//}

