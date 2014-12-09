package com.vriche.adrm.util;

import java.util.Comparator;


import com.vriche.adrm.model.PublishArrangeDetail;


public class ArrayBrandComparator implements Comparator<PublishArrangeDetail> {
	
	
	
//	public int compare(Object a, Object b) {
//		PublishArrangeDetail left = (PublishArrangeDetail) a;
//		PublishArrangeDetail right = (PublishArrangeDetail) b;
//		
//		if (a == null || b == null) {
//			 return 0;
//		}
//		
//		 if (left.getSpecificValue() != null || right.getSpecificValue() != null) {
//			  return 0;
//		 }
//		
////		String left_specificValue = left.getSpecificValue();
////		String right_specificValue = right.getSpecificValue();
//		
//		long left_T = left.getBrandId();
//		long right_T = right.getBrandId();
//		
//		int res = left_T == right_T?1:0;
//		 
//		return res;
//		
//	}
	
	 public int compare(PublishArrangeDetail u1, PublishArrangeDetail u2) {
		    int comparison = -1;
			String u1_specificValue = u1.getSpecificValue();
		    String u2_specificValue = u2.getSpecificValue();
		    
//		    System.out.println("u1.equals(u2)>>>>>>>>>>>>>>>>>>>>>"+u1.equals(u2)) ;
//		    System.out.println("u1_specificValue>>>>>>>>>>>>>>>>>>>>>"+u1_specificValue) ;
//		    System.out.println("u2_specificValue>>>>>>>>>>>>>>>>>>>>>"+u2_specificValue) ;
		    
//		    System.out.println( u1.getBrandId()+">>>"+ u1.getPublishSort()+"_"+u1.getMatterName()+"      "+ u1.getBrandId()+"_"+ u2.getPublishSort()+"_"+u2.getMatterName()) ;
	
		    
//		    int res = u1.getBrandId().compareTo(u2.getBrandId());
		    
//		    if (u1.equals(u2)||u1_specificValue!=null||u2_specificValue!=null){
	        if (u1.getBrandId() == u2.getBrandId()){    
	        	 return 0;
	        } else if (u1.getBrandId() != u2.getBrandId() ){
	            return 1;
	        }else {
	            return -1;
	        }
	    }
}
//	 public int compare(PublishArrangeDetail u1, PublishArrangeDetail u2) {
//		    int comparison = -1;
//			String u1_specificValue = u1.getSpecificValue();
//		    String u2_specificValue = u2.getSpecificValue();
//		    
//		    
//		    System.out.println(">>>"+ u1.getPublishSort()+"_"+u1.getMatterName()+"    "+ u2.getPublishSort()+"_"+u2.getMatterName()) ;
////		    if (u1.getBrandId() == u2.getBrandId()){
////		    	comparison = u1.getMatterId().compareTo(u2.getMatterId());
//////		    	comparison =  1;
////		    }else{
////		    	comparison =  0;
////		    }
//		    
////		    if(u1.equals(u2)){
////		    	comparison = 0;
////		    }
////		    
////		    if(u1_specificValue!=null || u2_specificValue!=null){
////		    	comparison = -1;
////		    }
////		    
////		    if (u1.getBrandId() == u2.getBrandId()){
////		    	comparison = 1;
////		    }
//		    
//		    return comparison;
//
//	    }
//}


