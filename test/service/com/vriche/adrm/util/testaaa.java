package com.vriche.adrm.util;

import junit.framework.TestCase;

import org.apache.axis2.AxisFault;

public class testaaa extends TestCase {

	public static void main(String[] args) {
	  GetWSByAxis2 ws = new GetWSByAxis2();
	  ws.WSUrl = "http://121.28.83.134:8081/adrm/services/webService";
	  String result;
	  try {
//	  result = ws.getStr("getIndustrys", "peipan");
	  result = ws.get("getIndustrys");
	  System.out.println(result);
	  } catch (AxisFault e) {
	  e.printStackTrace();
	  }
	}

}
