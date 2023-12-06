import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> myClass = MyClass.class; //mi prendo il tipo di classe
        //System.out.println(myClass.toString());
        Constructor<?> constructors = myClass.getConstructor();
        Method[] methods = myClass.getMethods();
        Field[] fields = myClass.getFields();

        MyClass myObject = (MyClass) constructors.newInstance();

        System.out.println(myClass.getFields("id"));
    }
}
