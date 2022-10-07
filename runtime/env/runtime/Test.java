import java.util.LinkedList;

class Test{
    public static void main(String[] args) {
        String[] str = new String[]{"12","312", "3127"};
        var stack = new LinkedList<String>();
        for (int i = 0; i < str.length; i++) {
            stack.push(str[i]);
        }
        for (int i = 0; i < str.length; i++) {
            System.err.println(stack.pop());
        }
        // System.out.println(stack.toString());
    }
}