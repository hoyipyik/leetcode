package runtime;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] holder = s.findErrorNums(new int[]{1,2,2, 4});
        System.out.println(Arrays.toString(holder));

    }
}