package com.leetcode_2th;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.leetCode.CommonStructure.Interval;

/**
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 * 
 * @author Zealot
 * @date 2016年6月13日 下午12:07:22 
 *
 */
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<Interval>();
		if(intervals==null||intervals.size()==0){
			return res;
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(Interval i: intervals){
			int start = i.start;
			int end = i.end;
			if(end>max){
				max = end;
			}
			if(start<min){
				min = start;
			}
		}
		boolean[] isVisted = new boolean[max - min + 1 + 2];
		for (Interval i : intervals) {
			int start = i.start;
			int end = i.end;
			for (; start <= end; start++) {
				isVisted[start - min + 1] = true;
			}
		}
		int start = 0;
		
		for (int i = 1; i < isVisted.length; i++) {
			if (isVisted[i] == false && isVisted[i - 1] == true) {
				Interval interval = new Interval();
				interval.start = start + min - 1;
				interval.end = i - 1 + min - 1;
				res.add(interval);
			}
			if(isVisted[i] == true && isVisted[i - 1] == false){
				start = i;
			}
		}
		
		return res;
    }

	public ArrayList<Interval> merge2(ArrayList<Interval> intervals) {
		ArrayList<Interval> res = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0)
			return intervals;
		Comparator<Interval> comp = new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				if (i1.start == i2.start)
					return i1.end - i2.end;
				return i1.start - i2.start;
			}
		};
		Collections.sort(intervals, comp);

		res.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			if (res.get(res.size() - 1).end >= intervals.get(i).start) {
				res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, intervals.get(i).end);
			} else {
				res.add(intervals.get(i));
			}
		}
		return res;
	}  
	public static void main(String[] args) {
		int num1, num2, num3;
        Scanner scanner = new Scanner(System.in);
        //1 2 3
        System.out.println("請輸入三個數字(以空白鍵分開)：");
//        num1 = scanner.nextInt();
//        num2 = scanner.nextInt();
//        num3 = scanner.nextInt();
        String a = scanner.nextLine();
        int b = -1;
        if(scanner.hasNextInt()){
        	b = scanner.nextInt();
        }
        System.out.println(a);
        
        System.out.println(b);
//        scanner.
//        System.out.println("您輸入第一個數字為：" + num1 );
//        System.out.println("您輸入第二個數字為：" + num2 );
//        System.out.println("您輸入第三個數字為：" + num3 );
        scanner.close();
	}
}
