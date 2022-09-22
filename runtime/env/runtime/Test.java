package env.runtime;

import java.util.Arrays;

public class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
        var holder = s.findErrorNums(new int[]{2,3,2});
        System.out.println(Arrays.toString(holder));
    }
}