package env.runtime;

public class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
        // var holder = s.findDisappearedNumbers(new int[]{10,2,5,10,9,1,1,4,3,7});
        var holder = s.findDisappearedNumbers(new int[]{1,1,2,2});
        System.out.println(holder.toString());
    }
}