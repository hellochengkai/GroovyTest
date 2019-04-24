class MapsTest {
    /**
     * Groovy 定义 Map 的方式非常简洁，
     * 通过中括号包含key、val的形式，key和value以冒号分隔([key:value])。
     * Groovy中的Map其实就是java.util.Map，
     * 实现类默认使用的是java.util.LinkedHashMap。
     */
    static void main(args){
// key虽然没有加引号，不过Groovy会默认将其转换为字符串
        def colors = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']

        assert colors['red'] == '#FF0000' // 使用中括号访问
        assert colors.green == '#00FF00' // 使用点表达式访问
        colors['pink'] = '#FF00FF' // 使用中括号添加元素，相当于Java Map 的 put(key,value)方法
        colors.yellow = '#FFFF00'// 使用点表达式添加元素
        assert colors.pink == '#FF00FF'
        assert colors['yellow'] == '#FFFF00'
        assert colors instanceof java.util.LinkedHashMap // 默认使用LinkedHashMap类型

// Groovy Map的key默认语法不支持变量，这里的key实际上是字符串'keyVal'而不是keyVal变量的值'name'
        def keyVal = 'name'
        def persons = [keyVal: 'Guillaume']
        assert !persons.containsKey('name')
        assert persons.containsKey('keyVal')
        println( persons )
//要使用变量作为key，需要使用括号
        def keyVal1 = 'name'
        def persons1 = [(keyVal1): 'Guillaume']
        assert persons1.containsKey('name')
        assert !persons1.containsKey('keyVal')
        println( persons1 )

        def map = [:]
//引用标示符中出现空格也是对的
        map."an identifier with a space and double quotes" = "ALLOWED"
//引用标示符中出现横线也是对的
        map.'with-dash-signs-and-single-quotes' = "ALLOWED"

        assert map."an identifier with a space and double quotes" == "ALLOWED"
        assert map.'with-dash-signs-and-single-quotes' == "ALLOWED"

        println(map)


        //如下类型字符串作为引用标识符都是对的
        map.'single quote'
        map."double quote"
        map.'''triple single quote'''
        map."""triple double quote"""
        map./slashy string/
        map.$/dollar slashy string/$

//稍微特殊的GString，也是对的
        def firstname = "Homer"
        map."Simson-${firstname}" = "Homer Simson"

        assert map.'Simson-Homer' == "Homer Simson"

        println(map)
    }
}
