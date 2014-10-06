package com.vriche.adrm.util;

import java.util.Comparator;

import com.vriche.adrm.model.CustomerAnalyzeColl;

public class CustomerAnalyzeCollComparator implements Comparator {
	
	public int compare(Object a, Object b) {
		CustomerAnalyzeColl left = (CustomerAnalyzeColl) a;
		CustomerAnalyzeColl right = (CustomerAnalyzeColl) b;
		String sor = left.getSortStr();
		sor = sor == null?"0,ASC":sor;
		String[] sorStr =left.getSortStr().split(",");
		

		int colIndex = Integer.parseInt(sorStr[0].toString());
		int sortType = sorStr[1].toString().equals("ASC")?0:1;  //ASC DESC
		
//		System.out.println("colIndex>>>>>>>>>>>>>>>>>>>>>"+colIndex) ;
//		System.out.println("sortType>>>>>>>>>>>>>>>>>>>>>"+sortType) ;
		
		
		switch(colIndex){

			case 1:
//				System.out.println("colIndex>>>>>>>>>>>>>>>>>>>>>"+1) ;
				
				 double  left_1 = Double.parseDouble(left.getCustomerIncome());
				 double  right_1 = Double.parseDouble(right.getCustomerIncome());
				 int res1 = 0;
				 
				 if(sortType == 1){
					 res1 = left_1 < right_1?1:0;
				 }else{
					 res1 = left_1 > right_1?1:0;
				 }
				 return res1;
				 
			
				
			case 2:
//				System.out.println("colIndex>>>>>>>>>>>>>>>>>>>>>"+2) ;
				
				 double  left_2 = Double.parseDouble(left.getDayRelIncome());
				 double  right_2 = Double.parseDouble(right.getDayRelIncome());
				 int res2 = 0;
				 
				 if(sortType == 1){
					 res2 = left_2 < right_2?1:0;
				 }else{
					 res2 = left_2 > right_2?1:0;
				 }
				 return res2;
				 
			
				
			case 3:
				 double  left_3 = Double.parseDouble(left.getDayRelPuton());
				 double  right_3 = Double.parseDouble(right.getDayRelPuton());
				 int res3 = 0;
				 
				 if(sortType == 1){
					 res3 = left_3 < right_3?1:0;
				 }else{
					 res3 = left_3 > right_3?1:0;
				 }
				 return res3;
				 
			
				
			case 4:
				 double  left_4 = Double.parseDouble(left.getDayPayMoney());
				 double  right_4 = Double.parseDouble(right.getDayPayMoney());
				 int res4 = 0;
				 
				 if(sortType == 1){
					 res4 = left_4 < right_4?1:0;
				 }else{
					 res4 = left_4 > right_4?1:0;
				 }
				 return res4;
				 
					
				
			case 5:
				 double  left_5 = Double.parseDouble(left.getAdSumTimes());
				 double  right_5 = Double.parseDouble(right.getAdSumTimes());
				 int res5 = 0;
				 
				 if(sortType == 1){
					 res5 = left_5 < right_5?1:0;
				 }else{
					 res5 = left_5 > right_5?1:0;
				 }
				 return res5;
				 
				
				
			default :
//				System.out.println("colIndex>>>>>>>>>>>>>>>>>>>>>"+0) ;
				
				 String  left_0 = left.getCustomerName();
				 String  right_0 = right.getCustomerName();
				 
				 if(left_0.indexOf("ÔÂ")>-1){
					 return sortCustomMonth(left_0,right_0,sortType);
				 }else if(left_0.indexOf("¼¾¶È")>-1){
					 return sortCustomQuerter(left_0,right_0,sortType);
				 }else{
					 if(sortType == 1){
						 return right_0.compareTo(left_0);
					 }else{
						 return left_0.compareTo(right_0);
					 } 
				 }
		}

	}
	
	
	public int sortCustomMonth(String a,String b,int sortType){
		int n = StringUtil.convercnMonth2Num(a);
		int m = StringUtil.convercnMonth2Num(b);
		if(sortType == 0) return n>m?1:-1; else return n<m?1:-1; 
	}
	public int sortCustomQuerter(String a,String b,int sortType){
		int n = StringUtil.convercnQuerter2Num(a);
		int m = StringUtil.convercnQuerter2Num(b);
		if(sortType == 0) return n>m?1:-1; else return n<m?1:-1; 
	}
	
	
	
}
