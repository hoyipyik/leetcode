import java.util.Deque;
import java.util.LinkedList;

/**
 * 150. Evaluate Reverse Polish Notation
 * Medium
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, and /. Each operand may be an integer or another
 * expression.
 * 
 * Note that division between two integers should truncate toward zero.
 * 
 * It is guaranteed that the given RPN expression is always valid. That means
 * the expression would always evaluate to a result, and there will not be any
 * division by zero operation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * 
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * 
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * 
 * 
 * Constraints:
 * 
 * 1 <= tokens.length <= 104
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the
 * range [-200, 200].
 */

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            String e = tokens[i];
            if (e.equals("/") || e.equals("+") || e.equals("-") || e.equals("*")) {
                int holder = 0;
                int b = stack.pop();
                int a = stack.pop();
                if (e.equals("/"))
                    holder = a / b;
                if (e.equals("+"))
                    holder = a + b;
                if (e.equals("-"))
                    holder = a - b;
                if (e.equals("*"))
                    holder = a * b;
                stack.push(holder);
                System.out.println(holder);
            } else {
                // System.out.println(e);
                stack.push(Integer.parseInt(e));
            }
        }
        return stack.pop();
    }
}

/**
 * Runtime: 80 ms, faster than 5.09% of Java online submissions for Evaluate
 * Reverse Polish Notation.
 * Memory Usage: 46.4 MB, less than 6.52% of Java online submissions for
 * Evaluate Reverse Polish Notation.
 */

class SameSolution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String s : tokens) {
            if ("+".equals(s)) { // leetcode 内置jdk的问题，不能使用==判断字符串是否相等
                stack.push(stack.pop() + stack.pop()); // 注意 - 和/ 需要特殊处理
            } else if ("-".equals(s)) {
                stack.push(-stack.pop() + stack.pop());
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
