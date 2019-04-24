class HelloWorld {
    static int method(String arg) {
        return 1
    }

    static int method(Object arg) {
        return 2
    }

    static void main(args) {
        Object o = "Object"
        // Groovy 会在运行时实际调用方法时进行选择。因为调用的是 String 类型的对象，所以自然调用 String 版本的方法
        int result = method(o)
        println "result  " + result

        //数组初始化语法
        //int[] array = { 1, 2, 3}错误的，{...}大括号是留给闭包使用的
        int[] array = [1, 2, 3]

        def my = new Person(name: "chengkai") //?????
        println "Person name = " + my.getName()
    }
}
