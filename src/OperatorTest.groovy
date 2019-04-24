class OperatorTest {
    static void main(args) {
        //Groovy支持?.安全占位符，这个运算符主要用于避免空指针异常，譬如：
        def person = Person.find { it.id == 123 }
        def name = person?.name
        assert name == null
    }
}
