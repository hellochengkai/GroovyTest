class ArrayListTest {
    static void main(args){
        //List 默认是java.util.ArrayList
        def numbers = [1, 2, 3]
        //Array
        String[] arrStr = ['Ananas', 'Banana', 'Kiwi'] //直接声明类型为数组类型  String[]

        def numArr = [1, 2, 3] as int[]     //通过as关键字指定类型为数组类型 int[]

        //List中存储任意类型
        def heterogeneous = [1, "a", true]

        //判断List默认类型
        def arrayList = [1, 2, 3]
        assert arrayList instanceof java.util.ArrayList

        //使用as强转类型
        def linkedList = [2, 3, 4] as LinkedList
        assert linkedList instanceof java.util.LinkedList
        //定义指定类型List
        LinkedList otherLinked = [3, 4, 5]

        //定义List使用
        def letters = ['a', 'b', 'c', 'd']
        //判断item值
        assert letters[0] == 'a'
        assert letters[1] == 'b'
        //负数下标则从右向左index
        assert letters[-1] == 'd'
        assert letters[-2] == 'c'

        //给List追加item
        letters << 'e'
        assert letters[ 4] == 'e'
        assert letters[-1] == 'e'
    }
}
