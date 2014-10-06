package com.vriche.adrm.webapp.serlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
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
import com.vriche.adrm.model.OrderPublic;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.service.ContractPaymentManager;
import com.vriche.adrm.service.CustomerManager;
import com.vriche.adrm.service.MatterManager;
import com.vriche.adrm.service.OrderDetailManager;
import com.vriche.adrm.service.OrderManager;
import com.vriche.adrm.service.PriceManager;
import com.vriche.adrm.service.PriceRegularManager;
import com.vriche.adrm.service.ProAudienceRatManager;
import com.vriche.adrm.service.WorkspanManager;
import com.vriche.adrm.util.ImportOrderUtil;
import com.vriche.adrm.util.ProAudienceRatUtil;
import com.vriche.adrm.util.ReadExcelByPoi;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;
import com.vriche.adrm.webapp.ajaxupload.MonitoredDiskFileItemFactory;
import com.vriche.adrm.webapp.ajaxupload.UploadListener;

public class ImportExcelServlet extends HttpServlet {
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
		try {
			UploadListener listener = new UploadListener(request, 30);
			// Create a factory for disk-based file items
			// DiskFileItemFactory factory = new DiskFileItemFactory();
			FileItemFactory factory = new MonitoredDiskFileItemFactory(listener);
			// DiskFileItemFactory factory = new DiskFileItemFactory();
			// Set factory constraints
			// factory.setSizeThreshold(4096); // 设置缓冲区大小，这里是4kb
			// factory.setRepository(tempPathFile);//设置缓冲区目录

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);
			// factory.setAllowFiles(".txt;.jpg;.rm");//ahxu扩展后：设置允许的上传文件类型

			// Set overall request size constraint
			upload.setSizeMax(41943040); // 设置最大文件尺寸，这里是40MB
			long s1 = System.currentTimeMillis();    
			try {
				// process uploads ..
				List items = upload.parseRequest(request);  
  
				Iterator its = items.iterator();

				String type="";  
//				String paymentId="";
//				String contractId="";
//				String moneyPay="";
//				String customerId="";
//				String customerName="";
				String userId = "";
				String publishDate = "";
				String carrierId = "";
				
				while (its.hasNext()) {

					List resList = new ArrayList();

					Map parmap = new HashMap();

					FileItem fi = (FileItem) its.next();  
					BufferedReader br = new BufferedReader(new InputStreamReader(fi.getInputStream()));
					String value  = br.readLine();
					String fileName = fi.getName();
					
					if(fi.getFieldName().equals("type")) type = value;
//					if(fi.getFieldName().equals("paymentId")) paymentId = value;
//					if(fi.getFieldName().equals("contractId")) contractId = value;  
//					if(fi.getFieldName().equals("moneyPay")) moneyPay = value;
//					if(fi.getFieldName().equals("customerId")) customerId = value;
//					if(fi.getFieldName().equals("customerName")) customerName = value;
					if(fi.getFieldName().equals("userId")) userId = value;  
					if(fi.getFieldName().equals("publishDates")) publishDate = value;    
					if(fi.getFieldName().equals("carrierIds")) carrierId = value;         

					if (!fi.isFormField() && fi.getName().length() > 0
							&& fileName != null) {  
						// File fullFile = new File(fi.getName());
						File savedFile = new File(uploadPath, fileName);
						fi.write(savedFile);

						// listener.done();

						ReadExcelByPoi readExcel = new ReadExcelByPoi();
						readExcel.setIndex(0);
						readExcel.setBeginRow(0);
						readExcel.setBeginCol(0);
						
						readExcel.setURL(savedFile.getPath());
						
						System.out.println("savedFile.getAbsolutePath()______________________________________________________________________"+savedFile.getPath());  
						 
						List ls =  readExcel.readAll();
						
						
						// 读某一个 Sheet
//						String[][] strArr2 = readExcel.read(savedFile);
						// ReadExcelByPoi.printArr(strArr2);
						
//						readExcel.setIndex(2);  
//						List ls = readExcel.getNewArrList(strArr2);
						    
						if (type.equals("1")) {
							
							List orderList = new ArrayList(); 
							List orderDetailList = new ArrayList();
							List newMatterList = new ArrayList();
							List carrierIdList = new ArrayList();
							WorkspanManager mgr = (WorkspanManager) getBean("workspanManager");
							PriceManager pm = (PriceManager) getBean("priceManager");
							PriceRegularManager pr = (PriceRegularManager) getBean("priceRegularManager");
							OrderManager orderManager = (OrderManager) getBean("orderManager");
							OrderDetailManager orderDetailManager = (OrderDetailManager) getBean("orderDetailManager");
							
							this.getOrderDataFromExcel(ls,orderList,orderDetailList,mgr,pm,pr,userId,newMatterList,carrierIdList); 
							
							if(carrierId.equals("root")&&carrierIdList.size()>0) carrierId="3_carrierId"+(String)carrierIdList.get(0);
							   
							String url = request.getContextPath()+ "/publishArranges.html?publishDate="+publishDate+"&carrierId="+carrierId;
							String  matterStr="";        
							if(lastPublishDate.equals(publishDate)&&lastCarrierId.equals(carrierId)){
								isPass=false;
							}else{
								isPass=true;
							}
							if(newMatterList.size()>0&&isPass){
								lastCarrierId = carrierId;               
								lastPublishDate = publishDate; 
								url = request.getContextPath()+ "/publishArranges.html?publishDate="+publishDate+"&amp;carrierId="+carrierId;
								for(Iterator it=newMatterList.iterator();it.hasNext();){
									Matter mat = (Matter)it.next();   
									matterStr+=("(广告名称:"+mat.getName()+" 广告版本:"+mat.getEdit()+"  广告长度:"+mat.getLength())+");";
								}
								response.setContentType("text/html;charset=utf-8");             
								PrintWriter out = response.getWriter();
					            out.println("<html>");
					            out.println("<head>");
					            out.println("<title>新版本广告提示</title>");       
					            out.println("<script type=\"text/javascript\">");
					            out.println("var isPassed = confirm('"+matterStr+"');");
					            out.println("if(isPassed){location.reload();}else{window.location.href='"+url+"';}");
					            out.println("</script>");               
					            out.println("</head>");
					            out.println("<body bgcolor=\"white\">");
					            out.println("</body>");
					            out.println("</html>");
					            out.close();
							}else{

								for(Iterator it=orderList.iterator();it.hasNext();){
									Order or =(Order)it.next();
									Order order  = orderManager.saveOrderReturnObj(or);
									orderDetailManager.saveImportOrderDetails(order.getId(),order.getCustomerId(),orderDetailList);
								}
								response.sendRedirect(url);
							}
 
//							for(Iterator it=orderList.iterator();it.hasNext();){
//								Order or =(Order)it.next();
//								Order order  = orderManager.saveOrderReturnObj(or);
//								orderDetailManager.saveImportOrderDetails(order.getId(),order.getCustomerId(),orderDetailList);
//								for(Iterator itss=orderDetailList.iterator();itss.hasNext();){
//									OrderDetail orderDetail =(OrderDetail)itss.next();
//									orderDetail.setOrderId(order.getId()); 
//									Matter mat = orderDetail.getMatter();
//									if(mat==null){   
//										mat = new Matter();
//										orderDetail.setIsNotInSeries(new Boolean(true));
//									}else{
//										orderDetail.setIsNotInSeries(new Boolean(false));
//									}
//									mat.setCustomerId(order.getCustomerId());
//									orderDetail.setMatter(mat);
//									OrderDayInfo[] orderDayInfos = orderDetail.getOrderDayInfos();
//									for(int i=0;i<orderDayInfos.length;i++){
//										orderDayInfos[i].setOrderId(order.getId());
//									}
//									orderDetail.setOrderDayInfos(orderDayInfos);           
////									if(itss.hasNext()){
//										
////									}
//									orderDetailManager.saveOrderDetailReturnObj(orderDetail);
//								}
//								OrderPublic orderPublic = orderManager.getOrderPublic(order.getId().toString());
//								
//								contractPaymentManager.saveContractPaymentByOrder("0",order.getId().toString(),order.getCustomerId().toString(),orderPublic.getMoneyRealpay().doubleValue(),true,"",order.getVersion().toString());
//							}
				          
						} else {  
							String tvname = SysParamUtil.getTvNameParam();
							Iterator it = ls.iterator();
							
							int kk =0;
							
							while(it.hasNext()){
								
								String[][] strArr2 =(String[][])it.next();
								
								List ls2 = readExcel.getNewArrList(strArr2);
								
								if("sjz".equals(tvname)||"fztv".equals(tvname)){
									ProAudienceRatUtil.getProAudienceRatDataFromExcel(ls2, resList, parmap);
								}
								
								
								if("hbtv".equals(tvname) && kk ==1){
									ProAudienceRatUtil.getProAudienceRatDataFromExcelForHBTV(ls2, resList, parmap);
								}
								kk++;
							}
							


							ProAudienceRatManager mgr = (ProAudienceRatManager) getBean("proAudienceRatManager");

							mgr.saveProAudienceRats(resList, parmap);
							
						}
					}

				} 
				request.setAttribute("message", "save file successful!");

//				 System.out.println(">>>>>>>>>>>>>>"+request.getRequestURL().toString());
				// response.sendRedirect(request.getRequestURL().toString());

				  
//				response.sendRedirect(request.getContextPath()
//						+ "/merm/audienceRatImport.jsp");
			} catch (FileUploadException e) {
				e.printStackTrace(); // To change body of catch statement use
										// File | Settings | File Templates.
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

	public void init() throws ServletException {
		// WebContext ctx = WebContextFactory.get();
		// uploadPath = ctx.getServletContext().getRealPath("/upload");
		// tempPath = ctx.getServletContext().getRealPath("/upload/temp");
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
		ApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(this.getServletConfig()
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
