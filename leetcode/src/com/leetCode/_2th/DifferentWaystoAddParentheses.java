package com.leetCode._2th;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to
 *  group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
分而治之。对于输入字符串，若其中有运算符，则将其分为两部分，分别递归计算其值，然后将左值集合与右值集合进行交叉运算，将运算结果放入结果集中；若没有运算符，则直接将字符串转化为整型数放入结果集中。
 * 
 * @author Zealot
 * @date 2016年4月7日 上午10:03:09 
 *
 */
public class DifferentWaystoAddParentheses {
	public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ret = new LinkedList<Integer>();
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == '-' ||
                input.charAt(i) == '*' ||
                input.charAt(i) == '+' ) {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
                for (Integer p1 :   part1Ret) {
                    for (Integer p2 :   part2Ret) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+': c = p1+p2;
                                break;
                            case '-': c = p1-p2;
                                break;
                            case '*': c = p1*p2;
                                break;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));
        }
        return ret;
    }
	public static void main(String[] args) {
		String s  = "2-1-1*3";
		DifferentWaystoAddParentheses d = new DifferentWaystoAddParentheses();
		System.out.println(d.diffWaysToCompute(s));
	}
}
