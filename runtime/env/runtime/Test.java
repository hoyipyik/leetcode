import java.security.DrbgParameters.Reseed;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Test{
    public static void main(String[] args) {
        // Test obj = new Test();
        // var holder = obj.reverseString("abc");
        var listIn = new LinkedList<Integer>();
        for (int i = 0; i < 4; i++) {
            listIn.add(i);
        }
        int holder = listIn.removeLast();
        System.out.println(holder);
        // listIn.forEach(System.out::println);
    }
}