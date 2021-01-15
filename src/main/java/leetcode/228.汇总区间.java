/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
 */

// @lc code=start
package leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution228 {
    public List<String> summaryRanges(int[] nums){

        List<String> list = new ArrayList<>();
        int n = nums.length;
        int i = 0;
        // 循环
        while(i < n){
            int low = i;
            i++;
            while( i < n && nums[i] == nums[i-1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuilder temp = new StringBuilder(Integer.toString(nums[low]));
            if(low < high){
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            list.add(temp.toString());
        }
        return list;
    }

    public List<String> summaryRanges1(int[] nums) {
        List<ArrayList<Integer>>  list = new ArrayList<ArrayList<Integer>>();
        for(int i = 0 ; i < nums.length ; i++ ){
            if ( i == 0 ){
                ArrayList<Integer> list1 = new ArrayList<Integer>();
                list1.add(nums[0]);
                list.add(list1);
            } else if (nums[i] == nums[i-1] + 1){
                ArrayList<Integer> list1 = list.get(list.size() - 1);
                list1.add(nums[i]);
            } else {
                ArrayList<Integer> list1 = new ArrayList<Integer>();
                list1.add(nums[i]);
                list.add(list1);
            }
        }

//        System.out.println(list);
        List<String> res = new ArrayList<String>();
        for (int i = 0 ; i < list.size() ; i++ ) {
            List<Integer> list1 = list.get(i);
            if (list1.size() == 1 ) {
                res.add(list1.get(0).toString());
            } else {
                res.add(list1.get(0).toString() + "->" + list1.get(list1.size()-1).toString());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a;
        List<String> b;
        a = new int[]{0,1,2,4,5,7};

        Solution228 solution = new Solution228();
        b = solution.summaryRanges(a);
        // for (String string : b) {
        //    System.out.println(string); 
        // }
        System.out.println(b);

        a = new int[]{0,2,3,4,6,8,9};

        solution = new Solution228();
        b = solution.summaryRanges(a);
        System.out.println(b);

        a = new int[]{};

        solution = new Solution228();
        b = solution.summaryRanges(a);
        System.out.println(b);

        a = new int[]{-1};

        solution = new Solution228();
        b = solution.summaryRanges(a);
        System.out.println(b);

        a = new int[]{0};

        solution = new Solution228();
        b = solution.summaryRanges(a);
        System.out.println(b);

    }
}
// @lc code=end

