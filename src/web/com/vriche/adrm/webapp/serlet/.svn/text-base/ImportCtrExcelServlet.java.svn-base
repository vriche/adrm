package com.vriche.adrm.webapp.serlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.model.DayInfo;
import com.vriche.adrm.model.Matter;
import com.vriche.adrm.model.Order;
import com.vriche.adrm.model.OrderDayInfo;
import com.vriche.adrm.model.OrderDetail;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.service.MatterManager;
import com.vriche.adrm.service.PriceManager;
import com.vriche.adrm.service.PriceRegularManager;
import com.vriche.adrm.service.WorkspanManager;
import com.vriche.adrm.util.JsonUtil;
import com.vriche.adrm.util.JsonUtil2;
import com.vriche.adrm.util.ServiceLocator;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.webapp.ajaxupload.MonitoredDiskFileItemFactory;
import com.vriche.adrm.webapp.ajaxupload.UploadListener;

public class ImportCtrExcelServlet extends HttpServlet {
	
	private String uploadPath = "D:\\temp"; // 上传文件的目录

	private String tempPath = "d:\\temp\\buffer\\"; // 临时文件目录

	private static boolean isPass=true;
	private static String lastCarrierId="";
	private static String lastPublishDate="";
	
	File tempPathFile;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		
		List resList = new ArrayList();
		List carrierList = new ArrayList();
		
		
//		 StringBuffer json = new StringBuffer();  
		 StringBuffer json2 = new StringBuffer();
//		 json.append("{'["); 
//		 json.append("["); 
		 json2.append("["); 
	
//		 
//		
//		 json.append("{'res':");  
		
		String tvname = SysParamUtil.getTvNameParam();
		String bro_date = request.getParameter("broDate");  
		
//		System.out.println("tvname____________________________________________________________________"+tvname);  
		
//		try {
//			Connection conns = ServiceLocator.getDao().getDefaultDataSource().getConnection();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		try {
			UploadListener listener = new UploadListener(request, 30);
			FileItemFactory factory = new MonitoredDiskFileItemFactory(listener);
			ServletFileUpload upload = new ServletFileUpload(factory);
			// Set overall request size constraint
			upload.setSizeMax(41943040); // 设置最大文件尺寸，这里是40MB
	  
			Connection conn = ServiceLocator.getDao().getDefaultDataSource().getConnection();
			
//			System.out.println("tvname____________________________________________________________________"+tvname);  
			
			try {
				
				java.sql.Statement sm = conn.createStatement();
				
//				this.excuteSql("delete from tb_ctr_data where bro_date = " + bro_date);
				
//				this.excuteSql("TRUNCATE TABLE tb_ctr_data");
				sm.execute("TRUNCATE TABLE tb_ctr_data");
				sm.close();
				
				conn.setAutoCommit(false);
//				
//				java.sql.Statement sm = conn.createStatement();
				
				PreparedStatement pstmt = conn.prepareStatement("insert into tb_ctr_data(carrider_name,bro_date,bro_start_time,adv_contents,bro_adv_length) values (?,?,?,?,?)");

		
// 				pstmt.executeBatch();
 				
				// process uploads ..
				List items = upload.parseRequest(request);  
				
//				System.out.println("items.size()____________________________________________________________________"+items.size());  
				
				Iterator its = items.iterator();
				
				while (its.hasNext()) {

					
//
//					Map parmap = new HashMap();

					FileItem fi = (FileItem) its.next();  
//					BufferedReader br = new BufferedReader(new InputStreamReader(fi.getInputStream()));
					String fileName = fi.getName();
					
//					System.out.println("fileName____________________________________________________________________"+fileName);  

					if (!fi.isFormField() && fi.getName().length() > 0 && fileName != null) {  

						Workbook book = Workbook.getWorkbook(fi.getInputStream());
						int sheetNum = book.getNumberOfSheets()-1;
						
						
//						sm.execute("delete from tb_ctr_data where bro_date = " + bro_date);
//						sm.close();
						
						
//						System.out.println("sheetNum____________________________________________________________________"+sheetNum);  
						
//						int sheetNum = book.getNumberOfSheets();
						
						StringBuffer sb = new StringBuffer();
						String sql = "";
						int bb = 0;
						for(int k = 1;k<sheetNum;k++){
								Sheet sheet = book.getSheet(k);
								String channelName = sheet.getName();
								Carrier carr = new Carrier();
								carr.setId(new Long(k));
								carr.setCarrierName(channelName);
								carrierList.add(carr);
								
//								 json2.append("{'channelName':"+JsonUtil.encodeString(channelName)+",'id':"+ k +"}");
								 
								 json2.append("["+ k +","+JsonUtil.encodeString(channelName)+"]");
//								 json2.append("["+k+","+channelName+"]");
								 
								 if(k<sheetNum-1)  json2.append(","); 
								 
//								 json.append("{'channelName':"+JsonUtil.encodeString(channelName)+",'objs':[");
								 
								
					
								 
//								System.out.println(sheet.getCell(2,2).getContents());
//							 System.out.println();
							   int columns = sheet.getColumns();
							   
							   for (int i = 7; i < sheet.getRows(); i++) {
//							    for (int j = 0; j < columns; j++){
//							    		System.out.print(sheet.getCell(j, i).getContents()+ "\t\t\t\t");
//							    		} ,2013-01-01,23:49:55,
							    		String broDate = StringUtil.getNullValue(sheet.getCell(0, i).getContents(),"0").trim();
							    		
							    		broDate = broDate.substring(0,4)+broDate.substring(5,7)+broDate.substring(8,10);
							    		String brotime = StringUtil.getNullValue(sheet.getCell(1, i).getContents(),"0").trim();
							 
							    		String[] brotimes = brotime.split(":");
							
							    		
							    		brotime = ""+(Integer.parseInt(brotimes[0])*3600 + Integer.parseInt(brotimes[1])*60+ Integer.parseInt(brotimes[2]));
							    		String advContents = StringUtil.getNullValue(sheet.getCell(2, i).getContents(),"").trim();
//							    		String advContents = StringUtilsv.trimLeft(StringUtil.getNullValue(sheet.getCell(2, i).getContents(),"")).trim();
							    		String broLength = StringUtil.getNullValue(sheet.getCell(3, i).getContents(),"0").trim();
							    		
//							    	String broDate = StringUtil.sheet.getCell(j, i).getContents();
							    		
							    	
							    		
//							     sql = "insert into tb_ctr_data(carrider_name,bro_date,bro_start_time,adv_contents,bro_adv_length) values ('"+ channelName  +"',"+ broDate +","+ brotime +",'"+ advContents +"',"+ broLength+");";
//
//							 				System.out.print(sql);
							    		
							 				pstmt.setString(1,channelName);
							 				pstmt.setInt(2,Integer.parseInt(broDate));
							 				pstmt.setInt(3,Integer.parseInt(brotime));
							 				pstmt.setString(4,advContents);
							 				pstmt.setInt(5,Integer.parseInt(broLength));
							 				
//							 				Resource res = new Resource();
//							 				res.setId(new Long(brotime));
//							 				res.setResourceName(advContents);
//							 				res.setMemo(broLength);
//							 				resList.add(res);
							 				
//							 				 json.append("{");  
//							 				 json.append("'channelName':"+ JsonUtil.encodeString(channelName)); 
//							 				 json.append(",");  
//							 				 json.append("'broDate':'"+broDate+"'"); 
//							 				json.append(",");  
//							 				 json.append("'brotime':'"+brotime+"'"); 
//							 				json.append(",");  
//							 				 json.append("'advContents':"+JsonUtil.encodeString(advContents));
//							 				json.append(",");  
//							 				 json.append("'broLength':'"+broLength+"'"); 
//							 				 json.append("}"); 
							 				 
							 				 
//							 				 json.append("[");
//							 				 json.append("'"+(bb++)+"'"); 
//							 				 json.append(",");
//							 				 json.append(JsonUtil.encodeString(channelName)); 
//							 				 json.append(",");  
//							 				 json.append("'"+broDate+"'"); 
//							 				json.append(",");  
//							 				 json.append("'"+brotime+"'"); 
//							 				json.append(",");  
//							 				 json.append(JsonUtil.encodeString(advContents));
//							 				json.append(",");  
//							 				 json.append("'"+broLength+"'"); 
//							 				 json.append("]"); 
							 				 
							 				 
							 				 
//							 				 if(i<sheet.getRows()-1)  json.append(","); 
							 				 
							 				pstmt.addBatch();
							 			     
							 
//							 				pstmt.executeUpdate(sql);
						
							 				
//							 				pstmt.setString(1, channelName);
							 			
//							 				 System.out.println();
//							 				conn.createStatement().execute(sql);
//							     sb.append(sql);
							 				
							 				 
							    
							   		}				
//							   json.append("]}"); 
//							   if(k<sheetNum-1)  json.append(","); 
							     
						}
						
						
						pstmt.executeBatch(); 
						conn.commit();
						conn.setAutoCommit(true); 

						
//						System.out.println(sb.toString());
//						this.excuteSql(sql);

//						System.out.println("sheetNum_____________________________________________________________________");  
						 

						// listener.done();

//						ReadExcelByPoi readExcel = new ReadExcelByPoi();
//						readExcel.setIndex(0);
//						readExcel.setBeginRow(0);
//						readExcel.setBeginCol(0);
//						readExcel.setURL(savedFile.getPath());
						
//						System.out.println("savedFile.getAbsolutePath()______________________________________________________________________"+savedFile.getPath());  
						 
//						List ls =  readExcel.readAll();
//
//
//							Iterator it = ls.iterator();
//							
//							int kk =0;
//							
//							while(it.hasNext()){
//								
//								String[][] strArr2 =(String[][])it.next();
//								List ls2 = readExcel.getNewArrList(strArr2);
//								if("hbtv".equals(tvname) && kk ==1){
//									ProAudienceRatUtil.getProAudienceRatDataFromExcelForHBTV(ls2, resList, parmap);
//								}
//								kk++;
//							}
//							
//							ProAudienceRatManager mgr = (ProAudienceRatManager) getBean("proAudienceRatManager");
//
//							mgr.saveProAudienceRats(resList, parmap);
							
						}
					}
				
				 response.setContentType("text/html; charset=UTF-8"); 
//	            response.setContentType("text/html");// 必须设置返回类型为text，否则ext无法正确解析json字符串  
//	            response.setCharacterEncoding("UTF-8");//设置编码字符集为utf-8，否则ext无法正确解析  
	            PrintWriter outs = response.getWriter();  
	            
	            
//	            json.append("]"); 
	            json2.append("]"); 
//	       	 System.out.println(json.toString());
	            
//	            JsonUtil.setExcludeFields(new String[]{"carrierName"});
//		        	String json1 = JsonUtil.encodeCollection(carrierList);
		           
	        
//	           JsonUtil.setExcludeFields(new String[]{"parentId"});
//	           
//	           String json2 = JsonUtil.encodeCollection(resList);
	           

	           
//	            JsonUtil.encodeString(channelName)
//	           outs.write("{success:"+ json2 +"}"); 
	           
	            outs.write("{success:true,carrierLable:"+ json2.toString() +"}");  
	            
//	           outs.write("{success:true,carrierLable:"+ json2.toString() +",res:"+ json.toString() +"}");  
	           
//	           	System.out.println(json.toString());
	       	 
//	            outs.write(json2.toString()); 
//	            outs.write("{success:true}");  
	            outs.close(); 
				
				request.setAttribute("message", "save file successful!");

			} catch (FileUploadException e) {
				e.printStackTrace(); // To change body of catch statement use
				request.setAttribute("message", "save file failed!");  
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", "save file failed!");
			}

		} catch (Exception e) {
			// 可以跳转出错页面
			e.printStackTrace();
		}
	}

	private void excuteSql(String sql){
		try {

			ServiceLocator.getDao().getDefaultDataSource().getConnection().createStatement().execute(sql);

		} catch (SQLException e) {
			 System.out.println(sql+"/n;失败");
//			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	public void init() throws ServletException {
		uploadPath = this.getServletContext().getRealPath("/upload");
		tempPath = this.getServletContext().getRealPath("/upload/temp");
		File uploadFile = new File(uploadPath);
		if (!uploadFile.exists()) {
			uploadFile.mkdirs();
		}
		File tempPathFile = new File(tempPath);
		if (!tempPathFile.exists()) {
			tempPathFile.mkdirs();
		}
	}

	public Object getBean(String name) {
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletConfig()
						.getServletContext());
		return ctx.getBean(name);
	}
	
	
	
	public  void getOrderDataFromExcel(List ls,List orderList,List orderDetalList,WorkspanManager workspanManager,PriceManager priceManager,PriceRegularManager priceRegularManager,String userId,List newMatterList,List carrierIdList){
		int rows = ls.size();
		MatterManager matterManager = (MatterManager) getBean("matterManager");
		if(rows > 0){
			int cols = 0;
			cols = ((String[])ls.get(0)).length;
			String[][] strArray = new String[rows][cols];  
			long s1 = System.currentTimeMillis();
			int i = 0;
			Order order =new Order();
			String publishDate="";
			String matterLength ="";
			String carrierName=""; 
			Long[] resourceIds=null;
			DayInfo[] dayInfos=null;
			for(Iterator it = ls.iterator();it.hasNext();){
				String[] arr = (String[])it.next();
				
				//设置订单信息--start  
				if(i==0){
					int t=arr[0].indexOf("台");
					int pd=arr[0].indexOf("频道");
					carrierName = arr[0].substring(t+1,pd+2);
					order.setVersion(new Integer(arr[0].substring(0,4)));
				}
              
				if(i==1){
					int index1=  arr[0].indexOf("年");
					int index2=  arr[0].indexOf("月");
					int index3=  arr[0].indexOf("星期")-2;  

					String year = arr[0].substring(index1-4,index1); 
					String month = arr[0].substring(index1+1,index2);
					String day = arr[0].substring(index2+1,index3);
					publishDate = year+(month.length()==1?"0"+month:month)+(day.length()==1?"0"+day:day);
				}
				
				if(!it.hasNext()){

					order.setCustomer(new Customer(arr[0]));
					order.setContractId(new Long(0));
					order.setCategoryId(new Long(1));
					order.setUserId(new Long(userId));
					order.setOrderMeno("导入广告订单");
					order.setPublishMemo(publishDate+carrierName);  
					order.setIsCkecked(new Long(3));
					order.setPaymentId(new Long(0));
					order.setCreateBy(new Long(userId));
					orderList.add(order);
				} 
				//设置订单信息--end

				if(i==3){
					resourceIds=new Long[arr.length-2];
					dayInfos = new DayInfo[arr.length-2];     
					//得到该频道今年的资源
					List resourceList = new ArrayList();
					List carrs = (List) Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_ALL);
					Map carrierMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIER_CHILD);
					Map resourceMap  =  (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_RESOURCE_MAP);
					for(Iterator its=carrs.iterator();its.hasNext();){
						Carrier carr = (Carrier)its.next();
						if(carr.getCarrierName().equals(carrierName)){
							carrierIdList.add(carr.getId().toString());
							List childCarrier = (List)carrierMap.get(carr.getId());
							for(Iterator itss=childCarrier.iterator();itss.hasNext();){
								Carrier child = (Carrier)itss.next();
								if(child.getVersion().equals(order.getVersion())){
									CollectionUtils.addAll(resourceList,((List)resourceMap.get(child.getId())).iterator());
								}
							}
							
						}
					}
					
					for(int j = 3 ; j < arr.length-2 ; j++){
						for(Iterator its=resourceList.iterator();its.hasNext();){
							Resource res = (Resource)its.next();  
//							if(arr[j].indexOf(res.getMemo())!=-1){ 
							if(res.getEnable().booleanValue()&&arr[j].substring(5).equals(res.getMemo())){
								//得到各个列对应resourceId          
								resourceIds[j]=res.getId();
								
								//得到dayInfo的相关信息
								List dayInfoList = workspanManager.getResourceDayInfo(new Integer(publishDate),res.getId());
								DayInfo dayInfo  = (DayInfo) dayInfoList.get(0);
								dayInfos[j]= dayInfo;
							}
						}
					}
					
					
				}
				
				if(i>=4&&i<rows-5){
					Matter mat =new Matter();
					matterLength =""+(int)Double.parseDouble(arr[2]);  
					mat.setName(arr[0]);
					mat.setEdit(arr[1]); 
					mat.setLength(matterLength);
					Matter matter = matterManager.getMatter(mat);
					
					if(matter == null){
						newMatterList.add(mat);
						matter = mat;
					}
					for(int j = 3 ; j < arr.length-2 ; j++){
						if(arr[j]=="") continue;
						OrderDetail orderDetail =new OrderDetail();
//						Double sysPrice = priceManager.getSysPriceByResId(resourceIds[j],matterLength,new Long(1));
//						if(sysPrice==null){
//							String price = priceRegularManager.getPriceRegularByName(resourceIds[j].toString(),"1",matterLength);
//							if(price!=""){
//								int index = price.indexOf("*");
//								if(index!=-1){
//									price = ""+(Double.parseDouble(price.substring(0,index))*Double.parseDouble(price.substring(index+1)));
//								}else{
//									index=price.indexOf("+");         
//									if(index!=-1){ 
//										price = ""+(Double.parseDouble(price.substring(0,index))+Double.parseDouble(price.substring(index+1)));
//									}
//								}
//							}    
//							sysPrice = price==""?new Double(0):new Double(price);
//						}
						//下面保存在订单明细中的信息
						orderDetail.setMatter(matter);         
						orderDetail.setVersion(new Integer(publishDate.substring(0,4)));
						orderDetail.setOrderCategoryId("4");
						orderDetail.setResourceType(new Integer(1));
						orderDetail.setResourceInfoId(resourceIds[j]);
						orderDetail.setResourceSpecificId(new Long(0));
						orderDetail.setMatterLength(matterLength);    
						orderDetail.setIndustryTypeId(new Long(1));
						orderDetail.setPublishMemo("+");
						orderDetail.setResourcePriceType(new Long(1));
//						orderDetail.setSysPrice(sysPrice);     
//						orderDetail.setExecPrice(sysPrice);
						orderDetail.setSysPrice(new Double(0));
						orderDetail.setExecPrice(new Double(0));
						orderDetail.setAppRate(new Double(0));
						orderDetail.setFavourRate(new Double(0)); 
						orderDetail.setMoneyBalance(new Double(0));
//						orderDetail.setMoneyRealpay(new Double(sysPrice.doubleValue()*Double.parseDouble(arr[j])));
						orderDetail.setMoneyRealpay(new Double(0));
						orderDetail.setIsCkecked(new Long(0));
						orderDetail.setParentId(new Long(0));
						orderDetail.setResourceSortId(new Long(1));
						orderDetail.setAgeRate(new Double(0));
						orderDetail.setCompagesId(new Long(0));
						orderDetail.setIsSpaceAdver(new Boolean(false));
						orderDetail.setMoneyIn(new Double(0));
						orderDetail.setPublishStartDate(new Integer(publishDate));
						orderDetail.setPublishEndDate(new Integer(publishDate));
						orderDetail.setSumTimes(new Integer((int)Double.parseDouble(arr[j])));
						orderDetail.setIsSaveOrderDayInfo(new Boolean(true));
						orderDetail.setOrderCategoryMain("1");            
						orderDetail.setPaymentId(new Long(0));
						orderDetail.setCreateBy(new Long(userId));
						//下面是在orderdayinfo中的信息。   
						OrderDayInfo orderDayInfo =new OrderDayInfo();
						dayInfos[j].setUsed(""+(Integer.parseInt(dayInfos[j].getUsed())+orderDetail.getSumTimes().intValue()*Integer.parseInt(matterLength)));
						//如果加入该广告时段广告会超时，则不加入。   
//						if(dayInfos[j].getTotal()!=null&&Integer.parseInt(dayInfos[j].getTotal())<Integer.parseInt(dayInfos[j].getUsed())) continue;
	
						orderDayInfo.setDayInfo(dayInfos[j]);           
						orderDayInfo.setVersion(new Integer(publishDate.substring(0,4)));
						orderDayInfo.setPublishDate(new Integer(publishDate));
						orderDayInfo.setDayRelIncome(new Double(0));
						orderDayInfo.setAdDayTimes(orderDetail.getSumTimes());  
						orderDayInfo.setIsPublished(new Integer(1));
						orderDayInfo.setContractId(new Long(0));
						orderDayInfo.setNeedPublish(new Integer(0));
						
						OrderDayInfo[] orderDayInfos=new OrderDayInfo[1];
						orderDayInfos[0] =orderDayInfo;  

						orderDetail.setOrderDayInfos(orderDayInfos);
						  
						orderDetalList.add(orderDetail);
					}
				}
				i++;  
			}
		}
	}
}
