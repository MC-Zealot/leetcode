package com.leetcode_2th;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zealot
 * @date 2016年6月11日 上午8:54:41 
 *
 */
public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows==0){
        	return res;
        }
        
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        res.add(list1);
        if(numRows==1){
        	return res;
        }
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(1);
        list2.add(1);
        res.add(list2);
        if(numRows==2){
        	return res;
        }
        List<Integer> pre = new ArrayList<Integer>(list2);
        for(int i = 3; i <= numRows; i++) {
        	List<Integer> list = new ArrayList<Integer>();
        	
        	for(int j = 0; j < i; j++) {
        		if(j==0||j==i - 1){
        			list.add(1);
        		}else{
        			list.add(pre.get(j-1)+pre.get(j));
        		}
        	}
        	pre = new ArrayList<Integer>(list);
        	res.add(list);
        }
		return res;
    }
	public static void main(String[] args) {
		PascalsTriangle p = new PascalsTriangle();
		p.generate(4);
	}
}
