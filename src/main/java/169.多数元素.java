/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;

class Solution169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : nums){
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        Map.Entry<Integer, Integer> entryMajority = null;
        for(Map.Entry<Integer, Integer> entry: map.entrySet() ){
           if(entryMajority == null || entry.getValue() > entryMajority.getValue()){
              entryMajority = entry;
           }
        }
        return entryMajority.getKey();
    }

    public static void main(String[] args) {
        int[] a ;
        int result ;

        Solution169 solution = new Solution169();
        a = new int[]{3,2,3};
        result = solution.majorityElement(a);
        System.out.println(result);

        a = new int[]{1};
        result = solution.majorityElement(a);
        System.out.println(result);

        a = new int[]{2, 2, 1, 1, 1, 2, 2};
        result = solution.majorityElement(a);
        System.out.println(result);
    }
}
// @lc code=end

