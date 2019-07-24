package com.leetcode_3th.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

 * 
 * @author Zealot
 * @date Jul 24, 2019 2:27:49 PM 
 *
 */
public class LetterCombinationsofaPhoneNumber {
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<String>();
		if(digits==null || digits.length()==0) {
			return res;
		}
		dfs(digits, new  ArrayList<Character>(), res, 0);
		return res;
    }
	public static List<Character> getChars(Character number){
		List<Character> res = new ArrayList<Character>();
		if(number=='2') {
			res.add('a');
			res.add('b');
			res.add('c');
		}else if(number=='3') {
			res.add('d');
			res.add('e');
			res.add('f');
		}else if(number=='4') {
			res.add('g');
			res.add('h');
			res.add('i');
		}else if(number=='5') {
			res.add('j');
			res.add('k');
			res.add('l');
		}else if(number=='6') {
			res.add('m');
			res.add('n');
			res.add('o');
		}else if(number=='7') {
			res.add('p');
			res.add('q');
			res.add('r');
			res.add('s');
		}else if(number=='8') {
			res.add('t');
			res.add('u');
			res.add('v');
		}else if(number=='9') {
			res.add('w');
			res.add('x');
			res.add('y');
			res.add('z');
		}
		return res;
	}
	public void dfs(String digits, List<Character> tmp, List<String> res, int idx) {
		if(tmp.size()==digits.length()) {
			StringBuilder sb = new StringBuilder(); 
			  
	        // Appends characters one by one 
	        for (Character ch : tmp) { 
	            sb.append(ch); 
	        } 
	        // convert in string 
			res.add(sb.toString());
			return;
		}
		for(int i = 0; i < getChars(digits.charAt(idx)).size(); i++) {
			tmp.add(getChars(digits.charAt(idx)).get(i));
			idx+=1;
			dfs(digits, tmp, res,idx);
			tmp.remove(tmp.size()-1);
			idx-=1;
		}
	}
	public static void main(String[] args) {
		LetterCombinationsofaPhoneNumber l = new LetterCombinationsofaPhoneNumber();
		
		System.out.println(l.letterCombinations("7").toString());
	}
}
