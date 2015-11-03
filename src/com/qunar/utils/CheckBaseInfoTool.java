package com.qunar.utils;

public class CheckBaseInfoTool {
	public static String trim(String base,String split){
		String[] bases=base.split(split);
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<bases.length;i++){
			sb.append(bases[i]);
		}
		return sb.toString();
	}
}
