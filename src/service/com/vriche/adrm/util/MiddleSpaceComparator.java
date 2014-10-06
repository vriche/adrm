package com.vriche.adrm.util;

import java.util.Comparator;

import com.vriche.adrm.model.PublishArrangeDetail;

public class MiddleSpaceComparator implements Comparator {

	public int compare(Object a, Object b) {
		
		if ((Integer)a instanceof Integer){
			return compare( (Integer) a, (Integer) b);  
		}else if(a instanceof PublishArrangeDetail){
			return compare( (PublishArrangeDetail) a, (PublishArrangeDetail) b);  
		}else{
			System.err.println("未找到合适的比较器");  
			return 1; 
		}
	}	

	public int compare(Integer o1,Integer o2){
		int val1 = o1.intValue();
		int val2 = o2.intValue();
		return (val1 == val2 ? -1 : (val1 == val2 ? 0 : 1));  
	}

//		boolean isDesc = false;
//		
//		PublishArrangeDetail left = (PublishArrangeDetail) a;
//		PublishArrangeDetail right = (PublishArrangeDetail) b;
//	    //数值为null,提示错误的信息
//	    if (a == null || b == null) {
//	      System.out.println("Error: left, right = " + left + "," + right);
//	      return 0;
//	    }
//	    
//	    if (left.getOrderDetailId() == null || right.getOrderDetailId() == null) {
//	    	System.out.println("Error: left.adv, right.adv = " +
//	                    left.getOrderDetailId() + "," +
//	                    right.getOrderDetailId());
//	      return 0;
//	    }
//	    
//	    System.out.println("info: left.adv, right.adv = " +
//                left.getPublishSort() + "," +
//                right.getPublishSort());
//	    
////		 boolean isSpaceAdver = left.getSpaceAdver().booleanValue();
////		 boolean right_T = right.isSpaceAdver();
//		 Integer    left_T= left.getPublishSort();
//		 Integer    right_T = left.getPublishSort();	
//		 
//		 Long    left_T_id = left.getOrderDetailId();
//		 Long    right_T_id = left.getOrderDetailId();
//		 
//	 
//
//
//		 if(left_T_id == right_T_id) isDesc = true;
//
//		 int res = isDesc?right_T.compareTo(left_T):left_T.compareTo(right_T);
//		 
//		 return res;
	
}
