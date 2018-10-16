import java.util.Enumeration;
import java.util.Properties;

public class TestClass {

    public static void main(String[] args) {
        Properties properties = System.getProperties();

        Enumeration<?> enumeration = properties.propertyNames();

        while(enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }

        System.out.println(System.getProperty("java.io.tmpdir"));
    }

}
