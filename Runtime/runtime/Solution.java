package runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        var ans = new ArrayList<Integer>();
        var map = new HashMap<Integer, Integer>();
        var addedMap = new HashMap<Integer, Boolean>();
        int threashold = nums.length / 3;
        for (int i : nums) {
            addedMap.putIfAbsent(i, false);
            map.computeIfPresent(i, (k,v) -> v +1);
            map.putIfAbsent(i, 1);
            int curn = map.get(i);    
            if (curn > threashold && !addedMap.get(i)){
                ans.add(i);
                addedMap.put(i, true);
            }
        }
        return ans;
    }
}

