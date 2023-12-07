import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.add(10);
        stringBox.add("Hello World");

        System.out.println("Integer Value: " + integerBox.get());
        System.out.println("String Value:" + stringBox.get());

        List<String> list = new ArrayList<String>();
        list.add("Hello");
        System.out.println(list.get(0));

    }
}
