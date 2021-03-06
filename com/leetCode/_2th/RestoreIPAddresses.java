package com.leetCode._2th;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * For example: Given "25525511135",
 * 
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * 
 * 
 * @author Zealot
 * @date 2016年3月12日 下午2:48:53
 *
 */
public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		ArrayList<String> res = new ArrayList<String>();
		if (s == null || s.length() == 0)
			return res;
		helper(s, 0, 1, "", res);
		return res;
	}

	private void helper(String s, int index, int segment, String item,
			ArrayList<String> res) {
		if (index >= s.length())
			return;
		if (segment == 4) {
			String str = s.substring(index);
			if (isValid(str)) {
				res.add(item + "." + str);
			}
			return;
		}
		for (int i = 1; i < 4 && (i + index <= s.length()); i++) {
			String str = s.substring(index, index + i);
			if (isValid(str)) {
				if (segment == 1)
					helper(s, index + i, segment + 1, str, res);
				else
					helper(s, index + i, segment + 1, item + "." + str, res);
			}
		}
	}

	private boolean isValid(String str) {
		if (str == null || str.length() > 3)
			return false;
		int num = Integer.parseInt(str);
		if (str.charAt(0) == '0' && str.length() > 1)
			return false;
		if (num >= 0 && num <= 255)
			return true;
		return false;
	}
}
