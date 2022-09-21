package env.runtime;

public class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
        var holder = s.arrayNesting(new int[]{5,4,0,3,1,6,2});
        System.out.println(holder);
    }
}