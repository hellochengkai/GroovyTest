class GStringTest {
    /**
     * 在 Groovy 中，由单引号所创建的字面量属于 String 类型对象，
     * 而双引号创建的字面量则可能是 String 或 GString 对象，
     * 具体分类由字面量中是否有插值来决定。
     * @param args
     */
    static void main(args){
        /**
         * 在Groovy种有两种字符串类型，
         * 普通字符串（java.lang.String）
         * 和插值字符串（groovy.lang.GString）。
         * 双引号字符串支持站位插值操作，如果双引号字符串中不包含站位符则是java.lang.String类型的，
         * 如果双引号字符串中包含站位符则是groovy.lang.GString类型的。
         */
        def name = '张三'
        println "hello name" // java.lang.String
        println "hello $name"//groovy.lang.GString
        println "hello ${name}"//groovy.lang.GString
        println 'hello $name'//java.lang.String
        def sOneParamClosure = "1 + 2 == ${w -> w << 3}"//支持闭包

        println sOneParamClosure

        def sum = "The sum of 2 and 3 equals ${2 + 3}"
        assert sum.toString() == 'The sum of 2 and 3 equals 5'

        def person = [name: 'Guillaume', age: 36]
        assert "$person.name is $person.age years old" == 'Guillaume is 36 years old'

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

        def number = 1
        def eagerGString = "value == ${number}"//直接取number的值并且赋值
        def lazyGString = "value == ${{ -> number}}"//使用闭包延迟获取number的值

        assert eagerGString == "value == 1"
        assert lazyGString ==  "value == 1"

        number = 2
        assert eagerGString == "value == 1"
        assert lazyGString ==  "value == 2"

        assert "one: ${1}".hashCode() != "one: 1".hashCode()
    }
}
