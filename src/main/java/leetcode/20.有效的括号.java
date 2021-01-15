/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
package leetcode;

import java.util.Stack;
import java.util.Map;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

class Solution20 {
    public void print(Stack<Character> stack ){
       for (int i = 0; i < stack.size(); i++){
           System.out.printf("%c ", stack.get(i));
       }
        System.out.println();
    }

    // leetcode的参考范例
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};// 这是什么语法
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    // ashley.zhou 的实现
    public boolean isValid1(String s) {

        Stack<Character> stack = new Stack<Character>(); // deque 是双边队列
        int length = s.length();
        for (int i = 0 ; i < length; i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{' ) {
                stack.add(s.charAt(i));
            } else {
                if (stack.size() == 0 ){
//                    System.out.println(deque);
//                    print(stack);
                    return false;
                }
                char prev = stack.pop();
                String tmp = new StringBuffer().append(prev).append(s.charAt(i)).toString();
                if(tmp.equals("()") || tmp.equals("[]") || tmp.equals("{}")){
                    continue;
                } else {
                    System.out.printf("this end, tmp is %s\n", tmp);
                    return false;
                }
            }
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s ;
        Solution20 solution20 = new Solution20();
        s = "()()()";
        System.out.printf("%s, %b\n", s, solution20.isValid(s));

        s = "(())";
        System.out.printf("%s, %b\n", s, solution20.isValid(s));

        s = "()[]{}";
        System.out.printf("%s, %b\n", s, solution20.isValid(s));

        s= "([)]";
        System.out.printf("%s, %b\n", s, solution20.isValid(s));
    }
}
// @lc code=end

