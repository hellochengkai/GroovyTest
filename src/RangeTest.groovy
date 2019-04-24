class RangeTest {
    static void main(args){
        /**
         * 在 Groovy 中可以使用..操作符来定义一个区间对象，简化范围操作的代码。
         */
        def range = 0..5
        assert (0..5).collect() == [0, 1, 2, 3, 4, 5]
        assert (0..<5).collect() == [0, 1, 2, 3, 4] // 相当于左闭右开区间
        assert (0..5) instanceof List // Range实际上是List接口的实现
        assert (0..5).size() == 6
        assert ('a'..'d').collect() == ['a','b','c','d']//也可以是字符类型
        //常见使用场景
        for (x in 1..<10) {
            println x
        }
        ('a'..'z').each {
            println it
        }

        def age = 18;
        switch (age) {
            case 0..17:
                println '未成年'
                break
            case 18..30:
                println '青年'
                break
            case 31..50:
                println '中年'
                break
            default:
                println '老年'
        }
    }
}
