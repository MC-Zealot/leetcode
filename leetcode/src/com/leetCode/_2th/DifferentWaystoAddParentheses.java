package com.leetCode._2th;

import java.util.ArrayList;
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
分治
 * 
 * @author Zealot
 * @date 2016年4月7日 上午10:03:09 
 *
 */
public class DifferentWaystoAddParentheses {
	 public List<Integer> diffWaysToCompute(String input) {
	        return helper(input);
	    }

	    public List<Integer> helper(String input) {
	        int length = input.length();
	        List<Integer> res = new ArrayList<>();
	        for (int i = 0; i < length; i++) {
	            char curc = input.charAt(i);
	            if (Character.isDigit(curc)) {
	                continue;
	            }
	            List<Integer> left = helper(input.substring(0, i));
	            List<Integer> right = helper(input.substring(i + 1, length));
	            merge(left, right, curc, res);
	        }
	        if (res.size() == 0) {
	            res.add(Integer.parseInt(input));
	        }
	        return res;
	    }

	    public void merge(List<Integer> left, List<Integer> right, char op, List<Integer> resList) {
	        int lengthLeft = left.size();
	        int lengthRight = right.size();
	        for (int i = 0; i < lengthLeft; i++) {
	            for (int j = 0; j < lengthRight; j++) {
	                int curRes = left.get(i);
	                int curRight = right.get(j);
	                if (op == '+') curRes += curRight;
	                else if (op == '-') curRes -= curRight;
	                else curRes *= curRight;
	                resList.add(curRes);
	            }
	        }
	    }
}
