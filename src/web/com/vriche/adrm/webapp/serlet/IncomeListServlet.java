package com.vriche.adrm.webapp.serlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.xerces.dom.DocumentImpl;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.vriche.adrm.model.Income;
import com.vriche.adrm.model.IncomePull;
import com.vriche.adrm.model.ResourceChannel;
import com.vriche.adrm.service.IncomeManager;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;

public class IncomeListServlet  extends HttpServlet {
	
	public void service(HttpServletRequest request,	HttpServletResponse response) throws IOException, ServletException
	{
		
		
		 
		IncomeManager mgr = (IncomeManager) getBean("incomeManager");
		
		String tvName = SysParamUtil.getTvNameParam();
		
		String strQueryString = request.getQueryString();
		
//		System.out.println("PaymentListServlet>>>>>>>> strQueryString>>>>>>>>>>>>>>a:"+strQueryString);
		
//		System.out.println("PaymentListServlet>>>>>>>> strQueryString>>>>>>>>>>>>>>b:" +StringUtil.getParamFromUrl(strQueryString,"posStart"));
		
		
		int posStart =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"posStart"),"0"));
//		System.out.println("PaymentListServlet>>>>>>>> strQueryString>>>>>>>>>>>>>>c:");
		int scrollTop = Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"scrollTop"),"0"));
		int count =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"count"),"30"));	
//		System.out.println("PaymentListServlet>>>>>>>> strQueryString>>>>>>>>>>>>>>d:");
		int  resultSize = 0;
      	resultSize = Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"total_count"),"0")) ;
//      	 System.out.println(">>>>>>>>>>>>fromEdit>>>>>>>>>>>33333333333333333333>>>>>>>>>>>>>>>>>>>>>>>>>" + StringUtil.getParamFromUrl(strQueryString,"fromEdit"));   
      	int fromEdit =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"fromEdit"),"0"));
      	
    	int fromEditRowId =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"fromEditRowId"),"0"));
      	
    	
    	System.out.println("PaymentListServlet>>>>>>>> fromEditRowId>>>>>>>>>>>>>>e:"+fromEditRowId);
		
//		Map searchMap = StringUtil.convertQueryStringtoMap(strQueryString);
		
		Map searchMap = mgr.buildsearchMap(strQueryString);


		System.out.println("PaymentListServlet>>>>>>>> strQueryString>>>>>>>>>>>>>>:"+strQueryString);
	
		
	
		Income objSum =  new Income();
		
		if(posStart == 0 || fromEdit > 0){
//        	 System.out.println("search orders>xxxxxxxxx objSum xxxxxxxx>>>"+objSum);
	    	 objSum = mgr.getCountSum(searchMap);
	    	
		}else{
//        	 System.out.println("search orders>xxxxxxxxx resultSize xxxxxxxx>>>"+resultSize);
        	objSum.setId( new Long(resultSize));
        }
          System.out.println("search orders>xxxxxxxxx resultSize xxxxxxxx>>>"+resultSize);
         List pageList = (List) mgr.getCollections(searchMap,"1",posStart,count);
        System.out.println("PaymentListServlet>>>>>>>> pageList>>>>>>>>>>>>>>:"+pageList.size());


        try {
    
			this.createXML(request,response,pageList,objSum,posStart,count,scrollTop,fromEdit,tvName,fromEditRowId);
		

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
//	 Get base XML for grid
	public void createXML(HttpServletRequest request,HttpServletResponse response,List pageList,Income  objSum,int posStart,int count,int scrollTop,int fromEdit,String tvName,int fromEditRowId) throws IOException, ClassNotFoundException, SQLException{

//		boolean isOrderDisplayIncomeParam = SysParamUtil.getOrderDisplayIncomeParam();
		
		Document xmldoc = new DocumentImpl();
		 Element head,afterInit,call,param,param1,param2,row,cell,userdata;
//		 Node n;
		 
	     String strQueryString = request.getQueryString();
	     
		 int  total_count  = Integer.parseInt(objSum.getId().toString());
		 
		 if(posStart == 0 && pageList.size()>0){
//			 System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>posStart>>>>>>>>>>>>>"+ posStart);
			 strQueryString =  StringUtil.oldReplace(strQueryString,"total_count=0","total_count="+total_count);
//			 System.out.println("strQueryString>root>>>>>>>>>>>>>>>>>>>>>>new>>>>>>>>>>>>>"+ strQueryString);
		 }


		System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>posStart>>>>>>>>>>>>>"+ posStart);
		System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>total_count>>>>>>>>>>>>>"+ total_count);
		System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>count>>>>>>>>>>>>>"+ count);
		System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>scrollTop>>>>>>>>>>>>>"+ scrollTop);
		System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>fromEdit>>>>>>>>>>>>>"+ fromEdit);



	   response.setContentType("text/xml; charset=UTF-8"); 

	    
	    PrintWriter out = response.getWriter();
	    
	
//	    n = xmldoc.createTextNode("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

		System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>aaaaaaaaaaaaa>>>>>>>>>>>>>"+ fromEdit);
		
		Element root = xmldoc.createElement("rows");
		root.setAttribute("pos",""+posStart);
		root.setAttribute("total_count",""+total_count);
		root.setAttribute("scrollTop",""+scrollTop);

//		 int coun =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"count"),"0"));	

		System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>0000000000>>>>>>>>>>>>>"+ fromEdit);
		
		
		
		if(posStart == 0 && pageList.size()>0 ||fromEdit > 0){
//		if(posStart == 0  ||fromEdit > 0){
			System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>11111111111>>>>>>>>>>>>>"+ fromEdit);
			String  realSum = StringUtil.doubleFormat2(objSum.getIncomeMoney());
			System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>11111111111>>>>>>>>>>>>>"+ realSum);
			String  moneyIn = StringUtil.doubleFormat2(objSum.getIncomeUsed());
			System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>11111111111>>>>>>>>>>>>>"+ moneyIn);
			String  releave = StringUtil.doubleFormat2(new Double(new Double(realSum).doubleValue()-new Double(moneyIn).doubleValue()));
			System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>11111111111>>>>>>>>>>>>>"+ fromEdit);
			 DecimalFormat df = new DecimalFormat();
			 String style = "##0.##";
	         df.applyPattern(style);
	        
	        String sumTitle ="合计";
	 		double realSum2 =0;
	 		double moneyIn2 =0;
	 		double releave2 =0;

			realSum2 =Double.parseDouble(realSum);
			moneyIn2 =Double.parseDouble(moneyIn); 
			releave2 =Double.parseDouble(releave); 
//			String realSum2 = StringUtil.doubleFormat2(objSum.getIncomeMoney());
//			String moneyIn2 =StringUtil.doubleFormat2(objSum.getIncomeUsed()); 
//			String releave2 =StringUtil.doubleFormat2(new Double(objSum.getIncomeMoney().doubleValue()-objSum.getIncomeMoney().doubleValue())); 

			head = xmldoc.createElementNS(null,"head");
			root.appendChild(head);
			afterInit = xmldoc.createElementNS(null,"afterInit");
			head.appendChild(afterInit);
			call = xmldoc.createElementNS(null,"call");
//			call.setAttribute("command","attachFooter");
			call.setAttribute("command","attachHeader");
			
			afterInit.appendChild(call);
			
			param = xmldoc.createElementNS(null,"param");
//			param.appendChild(xmldoc.createTextNode(" ,"+ sumTitle +":,"+ total_count +"条 , , , ,"+ df.format(realSum2)  +" ,"+ df.format(moneyIn2)+" ,"+ df.format(releave2)+" , , , ,"));	

//			param.appendChild(xmldoc.createTextNode(sumTitle +":,"+ total_count +"条 , , , ,"+ df.format(realSum2)  +" ,"+ df.format(moneyIn2)+" ,"+ df.format(releave2)+" , , , ,"));	      
			param.appendChild(xmldoc.createTextNode(" *"+ sumTitle +":*"+ total_count +"笔*****"+ StringUtil.doubleFormat3(new Double(realSum2))  +"*"+ StringUtil.doubleFormat3(new Double(moneyIn2)) +" *"+ StringUtil.doubleFormat3(new Double(releave2)) +" * * * *"));	
			

			
			call.appendChild(param);
			
			param1 = xmldoc.createElementNS(null,"param");//background-color:lightgrey;
			
			param1.appendChild(xmldoc.createTextNode("color:black;*color:black;*color:black;*color:black;*color:black;*color:black;*color:black;*color:black;text-align:right;font-size: 11px;*color:black;text-align:right;font-size: 11px;*color:black;height:20px;text-align:right;font-size: 11px;*color:black;text-align:right;font-size: 11px;*color:black;text-align:right;font-size: 11px;*color:black;text-align:right;font-size: 11px;*color:black;text-align:right;font-size: 12px;*color:black;"));			
			
//			param1.appendChild(xmldoc.createTextNode("color:black;,color:black;,color:black;,color:black;,color:black;,color:black;,color:black;height:20px;text-align:right;font-size: 11px;,color:black;text-align:right;font-size: 11px;,color:black;text-align:right;font-size: 11px;,color:black;text-align:right;font-size: 11px;,color:black;text-align:right;font-size: 12px;,color:black;"));			
			
			call.appendChild(param1);
		
			param2 = xmldoc.createElementNS(null,"param");
			param2.appendChild(xmldoc.createTextNode("_aFoot"));
			call.appendChild(param2);
		}
		
		
//		Element head,afterInit,call,param,param1,param2,row,cell,userdata;
		
		
		
		
		
		
		
		

		
	

//		String loginUser = objSum.getLoginUser();


		
		System.out.println(">>>>>>>>>>>>>>>>>>>>tag_order_submitbtn>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  ");
//		System.out.println(">>>>>>>>>>>>>>>>>>>>tag_orderList_check>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+tag_orderList_check);
		
		
		Iterator it = pageList.iterator();
		int k = 1;
		while (it.hasNext()){
	
		
			
//			Income income =(Income)it.next();
			
			IncomePull incomePull =(IncomePull)it.next();
			Income income = incomePull.getIncome();
			ResourceChannel resourceChannel = incomePull.getCarrier().getResourceChannel();
			
			
//			System.out.println(">>>>>>>>>>>>>>>>>>>>tag_orderList_check>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  ");
			
			
			
			
			row = xmldoc.createElementNS(null,"row");
			row.setAttributeNS(null,"id",income.getId().toString());
			
//			if(fromEditRowId > 0){
//				
//			}
			
			
			//给不同订单状态上色
//			String orderDetailRowCss = getOrderRowCss(k++,orderStates,order.getIsCkecked().toString());
//			row.setAttributeNS(null,"class",orderDetailRowCss);


//			Map mp = StringUtil.convertQueryStringtoMap(strQueryString);
			
//			System.out.println(">>>>>>>>>>>>>>>>>>>>tag_order_submitbtn>>>>>>>>>>>>>>>>>>>>>>2>>>>>>>>>>>>>>>>>>>>>>>>  ");
			

//			mp.put("id",income.getId());
//			strQueryString = StringUtil.map2QueryString(mp);

//			String url1 = strQueryString ;
//
//			String url2 = "parent.location.href=\""+ request.getContextPath()+ "/editOrder.html?"+ strQueryString +"\"";
//			String url3 = "edit_order(\""+ income.getId() +"\")";

//			userdata = xmldoc.createElementNS(null,"userdata");
//			userdata.setAttribute("name","href");
//			userdata.appendChild(xmldoc.createTextNode(url1));
//			row.appendChild(userdata);
			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","incomeUsed");
			userdata.appendChild(xmldoc.createTextNode(StringUtil.getNullValue(income.getIncomeUsed(),"0")));
			row.appendChild(userdata);			
			
			
			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","incomeId");
			userdata.appendChild(xmldoc.createTextNode(StringUtil.getNullValue(income.getId(),"0")));
			row.appendChild(userdata);	
			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","pullId");
			userdata.appendChild(xmldoc.createTextNode(StringUtil.getNullValue(incomePull.getId(),"0")));
			row.appendChild(userdata);	
			
			

			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","incomeCode");
			userdata.appendChild(xmldoc.createTextNode(income.getIncomeCode()));
			row.appendChild(userdata);	
			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","resourceCarrierId");
			userdata.appendChild(xmldoc.createTextNode(StringUtil.getNullValue(incomePull.getResourceCarrierId(),"0")));
			row.appendChild(userdata);		
			
			
			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","channelId");
			userdata.appendChild(xmldoc.createTextNode(StringUtil.getNullValue(resourceChannel.getId(),"0")));
			row.appendChild(userdata);				
			
//			userdata = xmldoc.createElementNS(null,"userdata");
//			userdata.setAttribute("name","resourceTypeId");
//			userdata.appendChild(xmldoc.createTextNode(StringUtil.getNullValue(incomePull.getResourceCarrierId(),"0")));
//			row.appendChild(userdata);	
			
			
//			userdata = xmldoc.createElementNS(null,"userdata");
//			userdata.setAttribute("name","pullId");
//			userdata.appendChild(xmldoc.createTextNode(StringUtil.getNullValue(incomePull.getId(),"0")));
//			row.appendChild(userdata);	
			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","customerId");
			userdata.appendChild(xmldoc.createTextNode(StringUtil.getNullValue(income.getCustomerId(),"0")));
			row.appendChild(userdata);		
			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","userId");
			userdata.appendChild(xmldoc.createTextNode(StringUtil.getNullValue(income.getUserId(),"0")));
			row.appendChild(userdata);	
			
			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","incomeMoney");
			userdata.appendChild(xmldoc.createTextNode(StringUtil.getNullValue(income.getIncomeMoney(),"0")));
			row.appendChild(userdata);		
			
			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","leaveMoney");
			double vvv = Double.parseDouble(StringUtil.getNullValue(income.getIncomeMoney(),"0")) - Double.parseDouble(StringUtil.getNullValue(income.getIncomeUsed(),"0"));
			userdata.appendChild(xmldoc.createTextNode(String.valueOf(vvv)));
			row.appendChild(userdata);	
			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","moneyIn");
			userdata.appendChild(xmldoc.createTextNode(StringUtil.getNullValue(new Double(StringUtil.getNullValue(income.getIncomeUsed(),"0")),"0")));
			row.appendChild(userdata);			
//			System.out.println(">>>>>>>>>>>>>>>>>>>>tag_orderList_check>>>>>>>>>"+ income.getId().toString() +">>>>>>>>>>>>>>"+StringUtil.getNullValue(incomePull.getId(),"0"));
			

//			System.out.println("getAuthorList2>root>>>>>>>>"+ url);  
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(String.valueOf((k++)+posStart)));	
			row.appendChild(cell);


	
//			String pull_idd = StringUtil.getNullValue(incomePull.getId(),"0");
//			if("0".equals(pull_idd)){
//				cell.appendChild(xmldoc.createTextNode("****"));	k++;
//			}else{
//				cell.appendChild(xmldoc.createTextNode(String.valueOf((k++)+posStart)));	
//			}
//			
//			row.appendChild(cell);			

//			cell = xmldoc.createElementNS(null,"cell");
//			cell.setAttribute("type","link");
//			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(income.getIncomeCode())+"^javascript:"+ url3+";^_self"));
//			row.appendChild(cell);
			

			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(income.getIncomeCode())));
			row.appendChild(cell);


			
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(DateUtil.SetDateFormat(income.getIncomeDate().toString(),"yyyy/MM/dd")));
			row.appendChild(cell);	
			

			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(DateUtil.SetDateFormat(income.getIncomePullDate().toString(),"yyyy")));
			row.appendChild(cell);	
			
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(income.getCustomer().getCustomerName())));
			row.appendChild(cell);
			
			
			
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(income.getUser().getFullName())));
			row.appendChild(cell);
			
//			cell = xmldoc.createElementNS(null,"cell");
//			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(incomePull.getCarrier().getCarrierName())));
//			row.appendChild(cell);	
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(resourceChannel.getName())));
			row.appendChild(cell);	
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.doubleFormat3(income.getIncomeMoney())));
			row.appendChild(cell);	
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.doubleFormat3(income.getIncomeUsed())));
			row.appendChild(cell);	
			
			cell = xmldoc.createElementNS(null,"cell");
			
			
			System.out.println(">>>>>>>>>>>>>>>>>>>>getIncomeMoney>>>>>>>>>>>>>>>>>>>>>>2>>>>>>>>>>>>>>>>>>>>>>>>  "+income.getIncomeMoney().doubleValue());
			System.out.println(">>>>>>>>>>>>>>>>>>>>getIncomeUsed>>>>>>>>>>>>>>>>>>>>>>2>>>>>>>>>>>>>>>>>>>>>>>>  "+income.getIncomeUsed().doubleValue());
			double lev_money = income.getIncomeMoney().doubleValue()-income.getIncomeUsed().doubleValue();
			lev_money = lev_money<0?0:lev_money;
			cell.appendChild(xmldoc.createTextNode(StringUtil.doubleFormat3(new Double(lev_money))));
			row.appendChild(cell);	

			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(income.getIncomePurpose().getName())));
			row.appendChild(cell);	
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(income.getIncomeMode().getName())));
			row.appendChild(cell);				

			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(income.getMemo())));
			row.appendChild(cell);	
			
//			System.out.println(">>>>>>>>>>>>>>>>>>>>tag_order_submitbtn>>>>>>>>>>>>>>>>>>>3>>>>>>>>>>>>>>>>>>>>>>>>>>>  ");
			
			root.appendChild(row);				
		}
	

		xmldoc.appendChild(root);
		
	    OutputFormat format = new OutputFormat(xmldoc);
	    format.setIndenting(true); 
	    XMLSerializer serializer = new XMLSerializer(out,format);
	    
//	    System.out.println(">>>>>>>>>>>>>>xmldoc>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+xmldoc);
		
	    

        try {
			serializer.asDOMSerializer();
			serializer.serialize(xmldoc);
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return;
	}	
	
	public Object getBean(String name) {
	    ApplicationContext ctx =  WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
	    return ctx.getBean(name);
	}
}
