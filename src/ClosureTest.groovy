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
        eachLine('a'..'g') { printf it }
        eachA_Z {println it}
    }
}
