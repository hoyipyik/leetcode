package runtime;

import java.util.List;

public class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> holder =  s.majorityElement(new int[]{3,2,3});
        System.out.println(holder.toString());

    }
}