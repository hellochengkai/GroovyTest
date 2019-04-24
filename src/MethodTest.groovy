class MethodTest {
    /**
     * Groovy 方法的默认访问修饰符是public，
     * 方法的返回类型可以不需要声明，但需添加def关键字。
     * 有返回值的方法return可以被省略，默认返回最后一行代码的运行结果，
     * 如果使用了return关键字则返回指定的返回值。
     */
    static String method1() {
        return 'hello'
    }
    static def method2() {
        return 'hello'
    }
    static def method3() {
        'hello'
    }
    static void main(args) {
        assert method1() == 'hello';
        assert method2() == 'hello';
        assert method3() == 'hello';
    }

    /**
     * Groovy 方法的参数类型可以被省略，默认为Object类型。
     */
    def add(int a, int b) {
        return a + b
    }
    //与上面的等价
    def add(a, b) {
        a + b
    }
}
