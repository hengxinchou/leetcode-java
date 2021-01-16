/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] 反转字符串
 */
// @lc code=start
class Solution344 {
    public void reverseString(char[] s) {
        int n = s.length ;
        for( int i = 0 ; i < n / 2; i++) {
            char tmp = s[n-1-i];
           s[n-1-i]  = s[i];
           s[i] = tmp;
        }
    }
    public static void main(String[] args) {
        Solution344 solution = new Solution344();
        char[] s = "hello".toCharArray();;
        solution.reverseString(s);
        System.out.println(s);
    }
}
// @lc code=end

