class GStringTest {
    /**
     * 在 Groovy 中，由单引号所创建的字面量属于 String 类型对象，
     * 而双引号创建的字面量则可能是 String 或 GString 对象，
     * 具体分类由字面量中是否有插值来决定。
     * @param args
     */
    static void main(args){
        assert 'c'.getClass()==String
        assert "c".getClass()==String
        assert "c${1}".getClass() in GString
    }
}
