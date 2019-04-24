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

        /**
         * 在Groovy种有两种字符串类型，
         * 普通字符串（java.lang.String）
         * 和插值字符串（groovy.lang.GString）。
         */
        def name = '张三'
        println "hello $name"
        println 'hello $name'
        /**
         * 除此之外，还支持三单引号的写法，可以保留文本的换行及缩进格式
         */

        def strippedFirstNewline =
                '''
line one
line two
line three
'''
        println strippedFirstNewline
// 可以写成下面这种形式，可读性更好
        def strippedFirstNewline2 =
                '''/
line one
line two
line three
'''
        println strippedFirstNewline2

        /**
         * 字符
         在 Groovy 中并没有明确的字符字面量表示形式，需要显示的指定，有三种方式
         */
        char c1 = 'A' // 声明类型
        assert c1 instanceof Character

        def c2 = 'B' as char // 用as关键字
        assert c2 instanceof Character

        def c3 = (char) 'C' // 强制类型转换
        assert c3 instanceof Character
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

