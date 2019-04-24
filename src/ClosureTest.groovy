class ClosureTest {
    /**
     * Groovy 提供了闭包的支持，语法和 Lambda 表达式有些类似，
     * 简单来说就是一段可执行的代码块或函数指针。
     * 闭包在 Groovy 中是groovy.lang.Closure类的实例，
     * 这使得闭包可以赋值给变量，或者作为参数传递。
     * Groovy 定义闭包的语法很简单，就像下面这样。
     *
     * //闭包的参数为可选项
     * def closure = { [closureParameters -> ] statements }
     *
     * 1. 闭包可以访问外部变量，而方法（函数）则不能。
     * 在定义闭包以后引用的外部变量会在闭包中保存一份
     *
     *一个闭包的普通参数定义必须遵循如下一些原则：

     参数类型可选
     参数名字
     可选的参数默认值
     参数必须用逗号分隔
     *
     */

    static def eachLine(lines, closure) {
        for (String line : lines) {
            closure(line)
        }
    }
    static def eachA_Z(closure) {
        for ( line in ['a','d','f','o']) {
            closure("^_^" + line)
        }
    }

    static void main(args){
        def str = 'hello'
        def closure={
            println str
        }
        closure()//hello


        def closure1 = {
            param -> println param
        }

        closure1('hello')
        closure1.call('hello')
        closure1 'hello'

        def closure2 = { String x, int y ->
            println "hey ${x} the value is ${y}"
        }

        closure2.call("groovy",3)

        /**
         * 如果只有一个参数的话，也可省略参数的定义，Groovy提供了一个隐式的参数it来替代它。
         */
        //def closure3 = { it -> println it }
        //和上面是等价的
        def closure4 = { println it }
        closure4('hello')

        eachLine('a'..'f',{ println it })
        eachLine('a'..'h',closure4)
        //闭包可以作为参数传入，闭包作为方法的唯一参数或最后一个参数时可省略括号。
        //可省略括号，与上面等价
        //可以看见，当闭包作为闭包或方法的最后一个参数时我们可以将闭包从参数圆括号中提取出来接在最后，
        // 如果闭包是唯一的一个参数，则闭包或方法参数所在的圆括号也可以省略；对于有多个闭包参数的，
        // 只要是在参数声明最后的，均可以按上述方式省略。
        eachLine('a'..'g') { printf it }
        eachA_Z {println it}


        def closureWithOneArg = { str1 -> str1.toUpperCase() }
        assert closureWithOneArg('groovy') == 'GROOVY'

        def closureWithOneArgAndExplicitType = { String str1 -> str1.toUpperCase() }
        assert closureWithOneArgAndExplicitType('groovy') == 'GROOVY'

        def closureWithTwoArgs = { a,b -> a+b }
        assert closureWithTwoArgs(1,2) == 3

        def closureWithTwoArgsAndExplicitTypes = { int a, int b -> a+b }
        assert closureWithTwoArgsAndExplicitTypes(1,2) == 3

        def closureWithTwoArgsAndOptionalTypes = { a, int b -> a+b }
        assert closureWithTwoArgsAndOptionalTypes(1,2) == 3

        //可选的参数默认值
        def closureWithTwoArgAndDefaultValue = { int a, int b=2 -> a+b }
        assert closureWithTwoArgAndDefaultValue(1) == 3
        assert closureWithTwoArgAndDefaultValue(1,1) == 3
    }
}
