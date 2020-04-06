package com.nowcoder;

import java.util.Scanner;

public class SetLampsTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int totalNumber;
//		int[] roadLens;
		int[] result;
		String[] roadStrings = null;
		
		
		totalNumber = in.nextInt();
//		roadLens = new int[totalNumber];
		result = new int[totalNumber];
		roadStrings = new String[totalNumber];
		for (int i = 0; i < totalNumber; i++) {
//			roadLens[i] = in.nextInt();
			roadStrings[i] = new String(in.next()); 				
		}

		
		for (int i = 0; i < roadStrings.length; i++) {
			for (int j = 0; j < roadStrings[i].length(); j++) {
				if ('.' == roadStrings[i].charAt(j)) {
					result[i] += 1;
					j += 3;
				}
			}
		}
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
	}
		
		
		

}
