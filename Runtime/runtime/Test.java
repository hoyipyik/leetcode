package runtime;

import java.util.List;

public class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] holder = s.sortArrayByParity(new int[]{3,1,2,4});
        System.out.println(holder.toString());

    }
}