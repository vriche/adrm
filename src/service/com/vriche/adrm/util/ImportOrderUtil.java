package com.vriche.adrm.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.model.DayInfo;
import com.vriche.adrm.model.Matter;
import com.vriche.adrm.model.Order;
import com.vriche.adrm.model.OrderDayInfo;
import com.vriche.adrm.model.OrderDetail;
import com.vriche.adrm.model.ProAudienceRat;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.service.PriceManager;
import com.vriche.adrm.service.PriceRegularManager;
import com.vriche.adrm.service.WorkspanManager;

import org.apache.commons.collections.CollectionUtils;
public class ImportOrderUtil {
	
	public static void getOrderDataFromExcel(List ls,List orderList,List orderDetalList,WorkspanManager workspanManager,PriceManager priceManager,PriceRegularManager priceRegularManager,String paymentId,String contractId,String moneyPay,String customerId,String customerName,String userId){
		int rows = ls.size();
		
		if(rows > 0){
			int cols = 0;
			cols = ((String[])ls.get(0)).length;
			String[][] strArray = new String[rows][cols];  
			
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
					order.setCustomerId(new Long(customerId));
					order.setContractId(new Long(contractId));
					order.setCategoryId(new Long(3));
					order.setUserId(new Long(userId));
					order.setOrderMeno("导入广告订单");
					order.setPublishMemo(publishDate+carrierName);  
					order.setIsCkecked(new Long(3));
					order.setPaymentId(new Long(paymentId));
					order.setCreateBy(new Long(userId));
					if(arr[0].equals(customerName)){
						orderList.add(order);
					}
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
					mat.setMatterType(new Integer(1));
					mat.setBrandId(new Long(1));
					
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
						orderDetail.setMatter(mat);
						orderDetail.setVersion(new Integer(publishDate.substring(0,4)));
						orderDetail.setOrderCategoryId("13");
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
						orderDetail.setMoneyRealpay(new Double(moneyPay));
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
						orderDetail.setOrderCategoryMain("0");            
						orderDetail.setPaymentId(new Long(paymentId));
						orderDetail.setCreateBy(new Long(UserUtil.getCurrentPrincipalUserId())); 
						//下面是在orderdayinfo中的信息。   
						OrderDayInfo orderDayInfo =new OrderDayInfo();   
						    System.out.println(dayInfos[j]+">>>>>>>>"+orderDetail.getSumTimes().intValue()); 
						dayInfos[j].setUsed(""+(Double.parseDouble(dayInfos[j].getUsed())+orderDetail.getSumTimes().intValue()*Double.parseDouble(matterLength)));
						//如果加入该广告时段广告会超时，则不加入。   
//						if(dayInfos[j].getTotal()!=null&&Integer.parseInt(dayInfos[j].getTotal())<Integer.parseInt(dayInfos[j].getUsed())) continue;
	
						orderDayInfo.setDayInfo(dayInfos[j]);           
						orderDayInfo.setVersion(new Integer(publishDate.substring(0,4)));
						orderDayInfo.setPublishDate(new Integer(publishDate));
						orderDayInfo.setDayRelIncome(new Double(0));
						orderDayInfo.setAdDayTimes(orderDetail.getSumTimes());  
						orderDayInfo.setIsPublished(new Integer(0));
						orderDayInfo.setContractId(new Long(0));  
						
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
