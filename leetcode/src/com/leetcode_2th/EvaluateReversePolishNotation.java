package com.leetcode_2th;

import java.util.Stack;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月29日 下午8:28:21 
 *
 */
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for(String s: tokens) {
			if("+".equals(s)){
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a+b);
			} else if("-".equals(s)){
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b-a);
			} else if("*".equals(s)){
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a*b);
			} else if("/".equals(s)){
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b/a);
			} else{
				stack.push(Integer.parseInt(s));
			}
		}
		
		return stack.peek();
    }
}
