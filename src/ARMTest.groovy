import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class ARMTest {
    static String testPath = "/media/chengkai/HardDisk4T/chengkai/GitHub/gradle/GroovyTest/test.txt"
    static void test1() {
        Path file = Paths.get(testPath)
        Charset charset = Charset.forName("UTF-8")
        try {
            BufferedReader reader = Files.newBufferedReader(file, charset)
            String line
            while ((line = reader.readLine()) != null) {
                System.out.println(line)
            }
        } catch (IOException e) {
            e.printStackTrace()
        }
    }

    static void test2() {
        new File(testPath).withReader('UTF-8') { reader ->
            reader.eachLine {
                println it
            }
        }
    }

    static void test3() {
        print new File(testPath).text
    }

    static void test4() {
        new File(testPath).eachLine('UTF-8') {
            println it
        }
    }

    static void main(args) {
        test1()
        test2()
        test3()
        test4()
    }
}
