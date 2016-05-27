package com.util;

import java.util.Random;

public class Test {
	public static void main(String[] args) {
		Random r = new Random();
		System.out.println(r.nextDouble());
		int n = 10;
		double[] a = new double[n];
		for(int i = 0; i < n; i++) {
			a[i] = r.nextDouble();
		}
		
	}
}
