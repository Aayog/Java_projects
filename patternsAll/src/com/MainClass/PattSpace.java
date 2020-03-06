package com.MainClass;

public class PattSpace {

	public static String sp(int numSpace) {
		String returnStr = "";
		for (int i = 0;i<numSpace;i++) {
			returnStr += " ";
		}
		return returnStr;
	}
	public static String pa(int numSpace) {
		String pattReturn = "";
		for (int i = 0;i<numSpace;i++) {
			pattReturn += "*"; 
		}
		return pattReturn;
	}
	public void patt(String[] arg) {
		int count;
		String toPrint = "";
		for (int i = 1;i <50;i++) {
			count = 0 ;
			for (String j : arg) {
				if(j.equals(""+i))count++;
			}
			if (count > 0)toPrint += "*";
			else toPrint += " ";
		}
		System.out.print(toPrint);
	}
}
