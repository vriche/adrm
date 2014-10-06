package com.vriche.adrm.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.OaWorkFlowCheckDao;
import com.vriche.adrm.dao.OrderDao;
import com.vriche.adrm.dao.OrderLogDao;
import com.vriche.adrm.model.Industry;
import com.vriche.adrm.model.OaWorkFlowCheck;
import com.vriche.adrm.model.Order;
import com.vriche.adrm.model.OrderCategory;
import com.vriche.adrm.model.OrderDayInfo;
import com.vriche.adrm.model.OrderDetail;
import com.vriche.adrm.model.OrderLog;
import com.vriche.adrm.model.RequestObject;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.model.Specific;

public class OrderLogUtil {
	
	public static boolean comparaOrderValue(StringBuffer sb,String clientIp,Order orderBackUp, Order order,OrderLogDao orderLogDao){
		String old_order_state = orderBackUp.getIsCkecked().toString();
		boolean permitModAdverParam = SysParamUtil.getPermitModAdverParam();
		boolean isCkecked ="1".equals(old_order_state)||"2".equals(old_order_state)||"3".equals(old_order_state);
		boolean updateOrderState = false;
		Map orderDetailMap_bak = new HashMap();  
		Map orderDetailMap_cur  = new HashMap();  
		 
	
		OrderDetail[] orderDetails = orderBackUp.getOrderDetailsObj();
		if(orderDetails != null){
			 for(int k =0;k< orderDetails.length;k++){ 
					OrderDetail orderDetail = orderDetails[k];
					orderDetailMap_bak.put(orderDetail.getId(),orderDetail);
			  }		
		}	
		OrderDetail[] orderDetails2 = order.getOrderDetailsObj();
		if(orderDetails2 != null){
			 for(int k =0;k< orderDetails2.length;k++){ 
					OrderDetail orderDetail = orderDetails2[k];
					orderDetailMap_cur.put(orderDetail.getId(),orderDetail);
			  }		
		}			
		
	
		
		//�����ж�
//		String orderRelationCode_old = orderBackUp.getRelationCode();
//		String orderRelationCode_cur = order.getRelationCode();
		//�������
		String orderCategoryMain_old = orderBackUp.getCategoryId().toString();
		String orderCategoryMain_cur = order.getCategoryId().toString();
		String orderCateName_old = getOrderCategoryNameById(orderCategoryMain_old);
		String orderCateName_cur = getOrderCategoryNameById(orderCategoryMain_cur);
		
		//�ͻ�����
		String customerNameMain_old = orderBackUp.getCustomer().getCustomerName().toString();
		String customerNameMain_cur = order.getCustomer().getCustomerName().toString();
		
		//ҵ��Ա
		String userNameMain_old_id = orderBackUp.getUserId().toString();
		String userNameMain_cur_id = order.getUserId().toString();
		String userName_old = UserUtil.getUserFullNameById(userNameMain_old_id);
		String userName_cur = UserUtil.getUserFullNameById(userNameMain_cur_id);

		//��Ӧ�����
		String moneyRealpaySumMain_old = StringUtil.doubleFormat2(orderBackUp.getOrderPublic().getMoneyRealpay());
		String moneyRealpaySumMain_cur =  StringUtil.doubleFormat2(order.getOrderPublic().getMoneyRealpay());
		
		//������ע
//		String orderMenoMain_old = orderBackUp.getOrderMeno().toString();
//		String orderMenoMain_cur = order.getOrderMeno().toString();	

		//������𡾡�
		if(!orderCategoryMain_old.equals(orderCategoryMain_cur)){
			sb.append(getValue("�������",orderCateName_old,orderCateName_cur));	
			 updateOrderState = true;
		}
			
		//�ͻ�����
		if(!customerNameMain_old.equals(customerNameMain_cur)){
			sb.append(getValue("�ͻ�����",customerNameMain_old,customerNameMain_cur));
			 updateOrderState = true;
		}
				
		//ҵ��Ա
		if(!userNameMain_old_id.equals(userNameMain_cur_id)){
			sb.append(getValue("ҵ��Ա",userName_old,userName_cur));			
			 updateOrderState = true;
		}

		//������ע
//		if(!orderRelationCode_old.equals(orderRelationCode_cur)){
//			sb.append(getValue("��ϵ���",orderRelationCode_old,orderRelationCode_cur));			
//			if(!permitModAdverParam && isCkecked) updateOrderState = true;
//		}

		//������ע
//		if(!orderMenoMain_old.equals(orderMenoMain_cur)){
//			sb.append(getValue("������ע",orderMenoMain_old,orderMenoMain_cur));
//			if(!permitModAdverParam && isCkecked) updateOrderState = true;
//		}
		
		//��Ӧ�����
		if(!moneyRealpaySumMain_old.equals(moneyRealpaySumMain_cur)){
			sb.append(getValue("Ӧ�����",moneyRealpaySumMain_old,moneyRealpaySumMain_cur));		
			 updateOrderState = true;
		}
		System.out.println("updateOrderState>>>>>  aaaaaaaaaaaaaaaaaaaaaaa   vvvvvvvvvvvvvvvvvvvvvvv   cccccccccccccccccccccccccc  "+updateOrderState) ;
		
		
//		String changeContent_order ="";
//			
//		if(updateOrderState){
//			changeContent_order = sb.toString();
//		}
		
		
		
		boolean saveOrderLog =false;
		Iterator it = orderDetailMap_bak.keySet().iterator();
		while(it.hasNext()){
			Long key =(Long) it.next();
			OrderDetail oldOrderDetail = (OrderDetail)orderDetailMap_bak.get(key);
			Object obj = orderDetailMap_cur.get(key);
			if(obj != null){
				OrderDetail curOrderDetail = (OrderDetail)orderDetailMap_cur.get(key);
				StringBuffer sb2 = new StringBuffer();
				boolean updateDeatilState = comparaDetailValue(sb2, oldOrderDetail,  curOrderDetail, permitModAdverParam,isCkecked);
				
				
				System.out.println("AAAAAAAAAAA  updateDeatilState>>>>>  aaaaaaaaaaaaaaaaaaaaaaa   vvvvvvvvvvvvvvvvvvvvvvv   cccccccccccccccccccccccccc  "+updateDeatilState) ;
				
				Long   orderId = orderBackUp.getId();
				
				
				if((updateDeatilState||updateOrderState)){
					String changeContent ="";
					if(updateOrderState && !saveOrderLog){
						sb.append(sb2.toString());
						saveOrderLog = true;
						changeContent = sb.toString();
					}else{
						changeContent =  sb2.toString();
					}
					
					
					Long   orderDetailId = oldOrderDetail.getId();
					Long   modifyBy = curOrderDetail.getModifyBy();
					Date   modifyDate = curOrderDetail.getModifyDate();
					if(modifyDate==null){
						 modifyBy = curOrderDetail.getCreateBy();
						 modifyDate = curOrderDetail.getCreateDate();
					}
					
					OrderLog orderLog= new OrderLog();
					orderLog.getLog().setClientIp(clientIp);
					orderLog.getLog().setModifyBy(modifyBy);
					orderLog.getLog().setModifyDate(new Date());
					orderLog.setOrderId(orderId);
					orderLog.setChangeContent(changeContent);
					orderLog.setOrderDetailId(orderDetailId);
					orderLogDao.saveOrderLog(orderLog); 
					
			       //����޸Ķ�����ϸ ,���޸Ķ���state 4 �˻�
//					if(curOrderDetail.getId() != null && !"hntv".equals(tvName)){
//						this.saveOrderDetailCheckState(curOrderDetail.getId().toString(),"4");
//					}

				}				
			}
		
		}
				


		return false;
	}
	
	public static boolean comparaDetailValue(StringBuffer sb,OrderDetail oldOrderDetail, OrderDetail curOrderDetail,boolean permitModAdverParam,boolean isCkecked){
//		StringBuffer sb2 = new StringBuffer();
		boolean updateOrderState = false;
		String orderCategorySub_old = oldOrderDetail.getOrderCategoryId().toString();
		String orderCategorySub_cur = curOrderDetail.getOrderCategoryId().toString();
		
		String orderCategoryName_old = getOrderCategoryNameById(orderCategorySub_old);
		String orderCategoryName_cur = getOrderCategoryNameById(orderCategorySub_cur);
		//�������
		String matterId_old = StringUtil.getNullValue(oldOrderDetail.getMatterId(),"");
		String matterId_cur =  StringUtil.getNullValue(curOrderDetail.getMatterId(),"");
		//���汾
		String matterEditMain_old = oldOrderDetail.getMatter().getEdit().toString();
		String matterEditMain_cur = curOrderDetail.getMatter().getEdit().toString();
		
		String matterLengthMain_old = oldOrderDetail.getMatter().getLength().toString();
		String matterLengthMain_cur = curOrderDetail.getMatter().getLength().toString();
	
		String orderCateName_old = oldOrderDetail.getOrderCategoryMain();
		String orderCateName_cur = curOrderDetail.getOrderCategoryMain();	
		
		//��ע
		String publishMemoMain_old = StringUtil.getNullValue(oldOrderDetail.getPublishMemo(),"");
		String publishMemoMain_cur = StringUtil.getNullValue(curOrderDetail.getPublishMemo(),"");
		//���λ��
		String resourceIdMain_old = oldOrderDetail.getResourceInfoId().toString();
		String resourceIdMain_cur = curOrderDetail.getResourceInfoId().toString();
		//ָ��λ��
		String specificIdMain_old = oldOrderDetail.getResourceSpecificId().toString();
		String specificIdMain_cur = curOrderDetail.getResourceSpecificId().toString();
		//�Ƿ񴮿�
		boolean spaceAdverMain_old = oldOrderDetail.getIsSpaceAdver().booleanValue();
		boolean spaceAdverMain_cur = curOrderDetail.getIsSpaceAdver().booleanValue();
		//�ۿ�
		double favourRateMain_old = oldOrderDetail.getFavourRate().doubleValue();
		double favourRateMain_cur = curOrderDetail.getFavourRate().doubleValue();
		//����
		double appRateMain_old = oldOrderDetail.getAppRate().doubleValue();
		double appRateMain_cur = curOrderDetail.getAppRate().doubleValue();
		//����
		String sumTimesMain_old = oldOrderDetail.getSumTimes().toString();
		String sumTimesMain_cur = curOrderDetail.getSumTimes().toString();
		
		//����
		double moneyBalance_old = oldOrderDetail.getMoneyBalance().doubleValue();
		double moneyBalance_cur =  curOrderDetail.getMoneyBalance().doubleValue();

		//���ۼ۸�
		double execPrice_old = oldOrderDetail.getExecPrice().doubleValue();	
		double execPrice_cur = curOrderDetail.getExecPrice().doubleValue();	
		
		double moneyRealpay_old = oldOrderDetail.getMoneyRealpay().doubleValue();	
		double moneyRealpay_cur = curOrderDetail.getMoneyRealpay().doubleValue();	
		
		
//		if("��������".equals(orderCateName_cur)){
			if(moneyRealpay_old != moneyRealpay_cur){
				sb.append(getValue("Ӧ���ܼ�",moneyRealpay_old+"",moneyRealpay_cur+""));		
				 updateOrderState = true;
			}	
//		}
		
		//�������
		if(!orderCategoryName_old.equals(orderCategoryName_cur)){
			sb.append(getValue("��������",orderCategoryName_old,orderCategoryName_cur));	
			 updateOrderState = true;
		}
		
		
		


		//���汾
		if(!matterId_old.equals(matterId_cur)){
			sb.append(getValue("���汾",matterEditMain_old,matterEditMain_cur));		
			 updateOrderState = true;
		}

		//��泤��
		if(!matterLengthMain_old.equals(matterLengthMain_cur)){
			sb.append(getValue("��泤��",matterLengthMain_old,matterLengthMain_cur));	
			 updateOrderState = true;
		}

		//��ע
		if(!publishMemoMain_old.equals(publishMemoMain_cur)){
			sb.append(getValue("������ע",publishMemoMain_old,publishMemoMain_cur));
			 updateOrderState = true;
		}

		//���λ��
		if(!resourceIdMain_old.equals(resourceIdMain_cur)){
			String resourceNameOld = getResourceNameById(resourceIdMain_old);
			String resourceNameCur = getResourceNameById(resourceIdMain_cur);
			sb.append(getValue("���λ��",resourceNameOld,resourceNameCur));
			 updateOrderState = true;
		}
			
		//ָ��λ��
		if(!specificIdMain_old.equals(specificIdMain_cur)){
			String speNameOld = specificIdMain_old.equals("0")?"":getSpecificNameById(specificIdMain_old);
			String speNameCur = specificIdMain_cur.equals("0")?"":getSpecificNameById(specificIdMain_cur);
			sb.append(getValue("ָ��λ��",speNameOld,speNameCur));
			 updateOrderState = true;
		}
		//������ѡ��״̬
		if(spaceAdverMain_old!=spaceAdverMain_cur){
			if(spaceAdverMain_old){
				sb.append(getValue("����","��","��"));
			}
			if(spaceAdverMain_cur){
				sb.append(getValue("����","��","��"));
			}
			 updateOrderState = true;
		}
		
		//���ۼ۸�
		if(execPrice_old != execPrice_cur){
			sb.append(getValue("���ۼ۸�",execPrice_old+"",execPrice_cur+""));		
			updateOrderState = true;
		}
		//�ۿ�

		if(favourRateMain_old!=favourRateMain_cur && "��������".equals(orderCateName_cur)){
			Double favourRate_old = new Double(favourRateMain_old*100);
			Double favourRate_cur = new Double(favourRateMain_cur*100);
			sb.append(getValue("�ۿ�",StringUtil.doubleFormat2(favourRate_old),StringUtil.doubleFormat2(favourRate_cur)));
			 updateOrderState = true;
		}
		//����
		if(appRateMain_old!=appRateMain_cur){
			Double appRate_old = new Double(appRateMain_old*100);
			Double appRate_cur = new Double(appRateMain_cur*100);
			sb.append(getValue("����",StringUtil.doubleFormat2(appRate_old),StringUtil.doubleFormat2(appRate_cur)));
			 updateOrderState = true;
		}
		//����
		if(!sumTimesMain_old.equals(sumTimesMain_cur)){
			sb.append(getValue("�ܴ���",sumTimesMain_old,sumTimesMain_cur));		
			updateOrderState = true;
		}
		
		//����
		if(moneyBalance_old != moneyBalance_cur){
			sb.append(getValue("����",moneyBalance_old+"",moneyBalance_cur+""));		
			 updateOrderState = true;
		}	
		
//		System.out.println("loginUser_cur>>>>>  aaaaaaaaaaaaaaaaaaaaaaa   vvvvvvvvvvvvvvvvvvvvvvv   cccccccccccccccccccccccccc  "+updateOrderState) ;
		

		boolean bb = comparaDayInfos(sb,oldOrderDetail,curOrderDetail);		
		if(!updateOrderState) updateOrderState = bb;
//		System.out.println("loginUser_cur>>>>>  aaaaaaaaaaaaaaaaaaaaaaa   vvvvvvvvvvvvvvvvvvvvvvv   cccccccccccccccccccccccccc  "+updateOrderState) ;
		
		return updateOrderState;

	}
	
	public static boolean comparaValue(StringBuffer sb,OrderDetail oldOrderDetail, OrderDetail curOrderDetail){
		
		StringBuffer sb2 = new StringBuffer();
		 
        String loginUser = curOrderDetail.getOrder().getLoginUser();
//        String loginUser_cur = "";
//        String loginUser_old = oldOrderDetail.getOrder().getModUser().getFullName();

        
//        System.out.println("loginUser_cur>>>>>  aaaaaaaaaaaaaaaaaaaaaaa  "+loginUser_cur) ;
//        System.out.println("loginUser_old>>>>>  aaaaaaaaaaaaaaaaaaaaaaa  "+loginUser_old) ;
        
    	String old_order_state = oldOrderDetail.getOrder().getIsCkecked().toString();
    	
		boolean updateOrderState = false;
//		boolean tag_order_force_modify = UserUtil.isGrandedRes(loginUser,"tag_order_force_modify");
//		boolean allowModiyPassedOrderParam = SysParamUtil.getAllowModiyPassedOrderParam();
		boolean permitModAdverParam = SysParamUtil.getPermitModAdverParam();
		boolean isCkecked ="1".equals(old_order_state)||"2".equals(old_order_state)||"3".equals(old_order_state);
		
		
		if("1".equals(curOrderDetail.getMoidType())){
			sb.delete(0,sb.length());
//			sb.append(getValue("ͣ����ʼʱ��",StringUtil.getNullValue(oldOrderDetail.getOrderPublic().getPublishStartDate(),""),StringUtil.getNullValue(curOrderDetail.getOrderPublic().getPublishStartDate(),"")));	
//			sb.append(getValue("ͣ������ʱ��",StringUtil.getNullValue(oldOrderDetail.getOrderPublic().getPublishEndDate(),""),StringUtil.getNullValue(curOrderDetail.getOrderPublic().getPublishEndDate(),"")));	
			
//			sb.append(getValue("ͣ������",StringUtil.getNullValue(oldOrderDetail.getOrderPublic().getTimes(),""),StringUtil.getNullValue(curOrderDetail.getOrderPublic().getTimes(),"")));	
//			
//			sb.append(getValue("ͣ�����",StringUtil.getNullValue(StringUtil.doubleFormat2(oldOrderDetail.getMoneyRealpay()),""),StringUtil.getNullValue(StringUtil.doubleFormat2(curOrderDetail.getMoneyRealpay()),"")));	
			OrderDayInfo[]  orderDayInfos_bak = oldOrderDetail.getOrderDayInfos();
			for(int i=0;i<orderDayInfos_bak.length;i++){
				String dd = DateUtil.SetDateFormat(orderDayInfos_bak[i].getPublishDate().toString(),"yyyy/MM/dd");
				String key = dd+"  "+orderDayInfos_bak[i].getAdDayTimes()+" ��";
				String key2 = " 0 "+" ��";
				
				sb.append(getValue("ͣ��",key,key2));	

		
//				System.out.println(">>>>>  orderDayInfos_bak aaaaaaaaaaaaaaaaaaa "+ orderDayInfos_bak[i].getPublishDate()+">>"+ orderDayInfos_bak[i].getAdDayTimes()) ;
			}
			
			
			if(isCkecked) updateOrderState = true;
			
		}else if("2".equals(curOrderDetail.getMoidType())){
			sb.delete(0,sb.length());
			String dt11 =  DateUtil.SetDateFormat(oldOrderDetail.getPublishStartDate().toString(),"yyyy/MM/dd");
			String dt12 =  DateUtil.SetDateFormat(oldOrderDetail.getPublishEndDate().toString(),"yyyy/MM/dd");
			dt11 = dt11 +"��"+dt12;
			
			String dt21 =  DateUtil.SetDateFormat(curOrderDetail.getPublishStartDate().toString(),"yyyy/MM/dd");
			String dt22 =  DateUtil.SetDateFormat(curOrderDetail.getPublishEndDate().toString(),"yyyy/MM/dd");
			dt21 = dt21 +"��"+dt22;
			
			sb.append(getValue("����ָ��", dt11+ "{"+oldOrderDetail.getMemo()+"}",dt21+ "{"+curOrderDetail.getMemo())+"}");
			
		}else if("3".equals(curOrderDetail.getMoidType())){
			sb.delete(0,sb.length());
			String type = oldOrderDetail.getMemo();
			if("1".equals(type)){
				sb.append(getValue("���ۼ۸�", ""+oldOrderDetail.getExecPrice()+"", ""+curOrderDetail.getExecPrice())+"");	
			}else{
				if(oldOrderDetail.getFavourRate().doubleValue()>0){
					sb.append(getValue("�ۿ���", ""+oldOrderDetail.getFavourRate().doubleValue()*100+"%", ""+curOrderDetail.getFavourRate().doubleValue()*100+"%")+"");	
				}
				
				if(oldOrderDetail.getAppRate().doubleValue()>0){
					sb.append(getValue("������", ""+oldOrderDetail.getAppRate().doubleValue()*100+"%", ""+curOrderDetail.getAppRate().doubleValue()*100+"%")+"");	
				}	
			}
			
			
//			String dt11 =  DateUtil.SetDateFormat(oldOrderDetail.getPublishStartDate().toString(),"yyyy/MM/dd");
//			String dt12 =  DateUtil.SetDateFormat(oldOrderDetail.getPublishEndDate().toString(),"yyyy/MM/dd");
//			dt11 = dt11 +"��"+dt12;
//			
//			String dt21 =  DateUtil.SetDateFormat(curOrderDetail.getPublishStartDate().toString(),"yyyy/MM/dd");
//			String dt22 =  DateUtil.SetDateFormat(curOrderDetail.getPublishEndDate().toString(),"yyyy/MM/dd");
//			dt21 = dt21 +"��"+dt22;
//			
//			sb.append(getValue("����ָ��", dt11+ "{"+oldOrderDetail.getMemo()+"}",dt21+ "{"+curOrderDetail.getMemo())+"}");	
		}else{
		
		
		//�����ж�
		String orderRelationCode_old = oldOrderDetail.getOrder().getRelationCode();
		String orderRelationCode_cur = curOrderDetail.getOrder().getRelationCode();
		//�������
		String orderCategoryMain_old = oldOrderDetail.getOrder().getCategoryId().toString();
		String orderCategoryMain_cur = curOrderDetail.getOrder().getCategoryId().toString();
		
		String orderCateName_old = getOrderCategoryNameById(orderCategoryMain_old);
		String orderCateName_cur = getOrderCategoryNameById(orderCategoryMain_cur);
		
		//�ͻ�����
		String customerNameMain_old = oldOrderDetail.getOrder().getCustomer().getCustomerName().toString();
		String customerNameMain_cur = curOrderDetail.getOrder().getCustomer().getCustomerName().toString();
		
		//ҵ��Ա
		String userNameMain_old_id = oldOrderDetail.getOrder().getUserId().toString();
		String userNameMain_cur_id = curOrderDetail.getOrder().getUserId().toString();
		
		String userName_old = UserUtil.getUserFullNameById(userNameMain_old_id);
		String userName_cur = UserUtil.getUserFullNameById(userNameMain_cur_id);
		

		//��Ӧ�����
		String moneyRealpaySumMain_old = StringUtil.doubleFormat2(oldOrderDetail.getOrder().getOrderPublic().getMoneyRealpay());
		String moneyRealpaySumMain_cur =  StringUtil.doubleFormat2(curOrderDetail.getOrder().getOrderPublic().getMoneyRealpay());
		
		
		//������ע
		String orderMenoMain_old = oldOrderDetail.getOrder().getOrderMeno().toString();
		String orderMenoMain_cur = curOrderDetail.getOrder().getOrderMeno().toString();	
		

		
		//������𡾡�
		if(!orderCategoryMain_old.equals(orderCategoryMain_cur)){
			sb.append(getValue("�������",orderCateName_old,orderCateName_cur));	
			if(isCkecked) updateOrderState = true;
		}
			
		//�ͻ�����
		if(!customerNameMain_old.equals(customerNameMain_cur)){
			sb.append(getValue("�ͻ�����",customerNameMain_old,customerNameMain_cur));
			if(isCkecked) updateOrderState = true;
		}
				
		//ҵ��Ա
		if(!userNameMain_old_id.equals(userNameMain_cur_id)){
			sb.append(getValue("ҵ��Ա",userName_old,userName_cur));			
			if(isCkecked) updateOrderState = true;
		}

		//������ע
		if(!orderRelationCode_old.equals(orderRelationCode_cur)){
			sb.append(getValue("��ϵ���",orderRelationCode_old,orderRelationCode_cur));			
			if(!permitModAdverParam && isCkecked) updateOrderState = true;
		}

		//������ע
		if(!orderMenoMain_old.equals(orderMenoMain_cur)){
			sb.append(getValue("������ע",orderMenoMain_old,orderMenoMain_cur));
			if(!permitModAdverParam && isCkecked) updateOrderState = true;
		}
		
		//��Ӧ�����
		if(!moneyRealpaySumMain_old.equals(moneyRealpaySumMain_cur)){
			sb.append(getValue("Ӧ�����",moneyRealpaySumMain_old,moneyRealpaySumMain_cur));		
			if(isCkecked) updateOrderState = true;
		}

		//�޸���
//		if(!loginUser_old.equals(loginUser_cur)){
//			sb.append(getValue("�޸���",loginUser_old,loginUser_cur));
//		}		
		//������ϸ�ж�
		//�������
//		System.out.println("oldOrderDetail.getOrderCategoryId()>>>>>>>>>>>>"+ oldOrderDetail.getOrderCategoryId());
//		System.out.println("oldOrderDetail.getOrderCategoryId()>>>>>>>>>>>>"+ curOrderDetail.getOrderCategoryId());
		
		String orderCategorySub_old = oldOrderDetail.getOrderCategoryId().toString();
		String orderCategorySub_cur = curOrderDetail.getOrderCategoryId().toString();
		
		String orderCategoryName_old = getOrderCategoryNameById(orderCategorySub_old);
		String orderCategoryName_cur = getOrderCategoryNameById(orderCategorySub_cur);
		//�������
		String matterNameMain_old = oldOrderDetail.getMatter().getName().toString();
		String matterNameMain_cur = curOrderDetail.getMatter().getName().toString();
		//���汾
		String matterEditMain_old = oldOrderDetail.getMatter().getEdit().toString();
		String matterEditMain_cur = curOrderDetail.getMatter().getEdit().toString();
		
//		System.out.println("matterEditMain_old>>>>>>55555555555555555555555555555555555555>>>>>>"+matterEditMain_old);
//		System.out.println("matterEditMain_cur>>>>>>6666666666666666666666666666666666666>>>>>>"+matterEditMain_cur);
		
		String matterLengthMain_old = oldOrderDetail.getMatter().getLength().toString();
		String matterLengthMain_cur = curOrderDetail.getMatter().getLength().toString();
		//��ҵ���
		String industryTypeMain_old = oldOrderDetail.getIndustryTypeId().toString();
		String industryTypeMain_cur = curOrderDetail.getIndustryTypeId().toString();
		
		String industryName_old = getIndustryNameById(industryTypeMain_old);
		String industryName_cur = getIndustryNameById(industryTypeMain_cur);
		//�۸����
		String priceType_old = oldOrderDetail.getResourcePriceType().toString();
		String priceType_cur = curOrderDetail.getResourcePriceType().toString();		
		
		
		//��ע
		String publishMemoMain_old = StringUtil.getNullValue(oldOrderDetail.getPublishMemo(),"");
		String publishMemoMain_cur = StringUtil.getNullValue(curOrderDetail.getPublishMemo(),"");
		//���λ��
		String resourceIdMain_old = oldOrderDetail.getResourceInfoId().toString();
		String resourceIdMain_cur = curOrderDetail.getResourceInfoId().toString();
		//ָ��λ��
		String specificIdMain_old = oldOrderDetail.getResourceSpecificId().toString();
		String specificIdMain_cur = curOrderDetail.getResourceSpecificId().toString();
		//�Ƿ񴮿�
		boolean spaceAdverMain_old = oldOrderDetail.getIsSpaceAdver().booleanValue();
		boolean spaceAdverMain_cur = curOrderDetail.getIsSpaceAdver().booleanValue();
		//�ۿ�
		double favourRateMain_old = oldOrderDetail.getFavourRate().doubleValue();
		double favourRateMain_cur = curOrderDetail.getFavourRate().doubleValue();
		//����
		double appRateMain_old = oldOrderDetail.getAppRate().doubleValue();
		double appRateMain_cur = curOrderDetail.getAppRate().doubleValue();
		//����
		String sumTimesMain_old = oldOrderDetail.getOrderPublic().getTimes().toString();
		String sumTimesMain_cur = curOrderDetail.getOrderPublic().getTimes().toString();
		//�������
		if(!orderCategoryName_old.equals(orderCategoryName_cur)){
			sb.append(getValue("��������",orderCategoryName_old,orderCategoryName_cur));	
			if(isCkecked) updateOrderState = true;
		}

		//�������
		if(!matterNameMain_old.equals(matterNameMain_cur)){
			sb.append(getValue("�������",matterNameMain_old,matterNameMain_cur));		
			if(isCkecked) updateOrderState = true;
		}

		//���汾
		if(!matterEditMain_old.equals(matterEditMain_cur)){
			sb.append(getValue("���汾",matterEditMain_old,matterEditMain_cur));		
			if(!permitModAdverParam && isCkecked) updateOrderState = true;
		}

		//��泤��
		if(!matterLengthMain_old.equals(matterLengthMain_cur)){
			sb.append(getValue("��泤��",matterLengthMain_old,matterLengthMain_cur));	
			if(isCkecked) updateOrderState = true;
		}

		//��ҵ���
//		if(!industryName_old.equals(industryName_cur)){
//			sb.append(getValue("��ҵ���",industryName_old,industryName_cur));	
//			if(!permitModAdverParam && isCkecked) updateOrderState = true;
//		}

		//�۸����
		if(!priceType_old.equals(priceType_cur)){
			sb.append(getValue("�۸����",SysParamUtil.getPriceTypeNameById(priceType_old),SysParamUtil.getPriceTypeNameById(priceType_cur)));	
			if(isCkecked) updateOrderState = true;
		}
		

		
		
		//��ע
		if(!publishMemoMain_old.equals(publishMemoMain_cur)){
			sb.append(getValue("������ע",publishMemoMain_old,publishMemoMain_cur));
			if(!permitModAdverParam && isCkecked) updateOrderState = true;
		}

		//���λ��
		if(!resourceIdMain_old.equals(resourceIdMain_cur)){
			String resourceNameOld = getResourceNameById(resourceIdMain_old);
			String resourceNameCur = getResourceNameById(resourceIdMain_cur);
			sb.append(getValue("���λ��",resourceNameOld,resourceNameCur));
			if(isCkecked) updateOrderState = true;
		}
			
		//ָ��λ��
		if(!specificIdMain_old.equals(specificIdMain_cur)){
			String speNameOld = specificIdMain_old.equals("0")?"":getSpecificNameById(specificIdMain_old);
			String speNameCur = specificIdMain_cur.equals("0")?"":getSpecificNameById(specificIdMain_cur);
			sb.append(getValue("ָ��λ��",speNameOld,speNameCur));
			if(isCkecked) updateOrderState = true;
		}
		//������ѡ��״̬
		if(spaceAdverMain_old!=spaceAdverMain_cur){
			if(spaceAdverMain_old){
				sb.append(getValue("����","��","��"));
			}
			if(spaceAdverMain_cur){
				sb.append(getValue("����","��","��"));
			}
			if(isCkecked) updateOrderState = true;
		}
		//�ۿ�
		if(favourRateMain_old!=favourRateMain_cur && "��������".equals(orderCateName_cur)){
			Double favourRate_old = new Double(favourRateMain_old*100);
			Double favourRate_cur = new Double(favourRateMain_cur*100);
			sb.append(getValue("�ۿ�",StringUtil.doubleFormat2(favourRate_old),StringUtil.doubleFormat2(favourRate_cur)));
			if(isCkecked) updateOrderState = true;
		}
		//����
		if(appRateMain_old!=appRateMain_cur){
			Double appRate_old = new Double(appRateMain_old*100);
			Double appRate_cur = new Double(appRateMain_cur*100);
			sb.append(getValue("����",StringUtil.doubleFormat2(appRate_old),StringUtil.doubleFormat2(appRate_cur)));
			if(isCkecked) updateOrderState = true;
		}
		//����
		if(!sumTimesMain_old.equals(sumTimesMain_cur)){
			sb.append(getValue("����",sumTimesMain_old,sumTimesMain_cur));		
			if(isCkecked) updateOrderState = true;
		}

			
			comparaDayInfos(sb2,oldOrderDetail,curOrderDetail);
		}
		

		
		String str = sb2.toString();
		
		if(!"".equals(str)){
			sb.append(str);
			if(isCkecked) updateOrderState = true;
		}
		
		
		
//		System.out.println(">>>>>  orderDayInfos_cur aaaaaaaaaaaaaaaaaaa "+sb.toString()) ;
		
		return updateOrderState;
	}
	
	private static boolean comparaDayInfos(StringBuffer sb,OrderDetail oldOrderDetail, OrderDetail curOrderDetail){
		boolean updateOrderState = false;
		OrderDayInfo[]  orderDayInfos_cur = curOrderDetail.getOrderDayInfos();
		OrderDayInfo[]  orderDayInfos_bak = oldOrderDetail.getOrderDayInfos();
        Map mpCur = new HashMap(); Map mpBak = new HashMap(); Map mpNewBak = new HashMap(); Map mpNewCur = new HashMap();
        List bList = new ArrayList();  List cList = new ArrayList();

		
		for(int i=0;i<orderDayInfos_bak.length;i++){
			String key = orderDayInfos_bak[i].getPublishDate()+"_"+orderDayInfos_bak[i].getAdDayTimes();
			mpBak.put(key,orderDayInfos_bak[i]);
			bList.add(key);
//			System.out.println(">>>>>  orderDayInfos_bak aaaaaaaaaaaaaaaaaaa "+ orderDayInfos_bak[i].getPublishDate()+">>"+ orderDayInfos_bak[i].getAdDayTimes()) ;
		}
		
		for(int i=0;i<orderDayInfos_cur.length;i++){
			String key = orderDayInfos_cur[i].getPublishDate()+"_"+orderDayInfos_cur[i].getAdDayTimes();
			cList.add(key);
		    mpCur.put(key,orderDayInfos_cur[i]);
//			System.out.println(">>>>>  orderDayInfos_cur bbbbbbbbbbbbbbbbbbb "+ orderDayInfos_cur[i].getPublishDate()+">>"+ orderDayInfos_cur[i].getAdDayTimes()) ;
		}		
		
//		  boolean  isContained  =  CollectionUtils.containsAny(aList, bList);
		 //����
//		  Collection  intersectionList  =  CollectionUtils.intersection(bList, cList);  
		  //�����Ĳ���
		  Collection   disjunctionList  =  CollectionUtils.disjunction(bList, cList);
		  
//		  Collections.sort((List)disjunctionList);
		  
		  
		  
//		  System.out.println(">>>>>  disjunctionList.size() bbbbbbbbbbbbbbbbbbb "+ disjunctionList.size()) ;
			
		  
		  if( disjunctionList.size() >0){
			  Iterator it  = disjunctionList.iterator();
			  
			  String times_bak = "";
			  String times_cur = "";
			  while(it.hasNext()){
				  String key = (String)it.next();
				  String date = DateUtil.SetDateFormat(key.substring(0,8),DateUtil.getDatePattern());

				  Object objBak = mpBak.get(key);Object objCur= mpCur.get(key);
				  if(objBak != null){
					   times_bak = StringUtil.getNullValue(((OrderDayInfo)objBak).getAdDayTimes(),"");
					   if(!"".equals(times_bak)) {
						   times_bak +="��";  
					   }
				  }else{
					  times_bak ="";
				  }
				  
//				  System.out.println(">>>>>  orderDayInfos_cur aaaaaaaaaaaaaaaaaaa "+date+"_"+times_bak) ;
				  
				  if(mpNewBak.containsKey(date)){
					  if(!"".equals(times_bak)){
						  mpNewBak.put(date,times_bak);
						 
					  }
				  }else{
					  mpNewBak.put(date,times_bak);
				  }
				  

				  if(objCur != null){
					  times_cur = StringUtil.getNullValue(((OrderDayInfo)objCur).getAdDayTimes(),"");
					  if(!"".equals(times_cur)){
						  times_cur +="��";mpNewCur.put(date,times_cur);
					  }
				  }else{
					  times_cur ="";
				  }


			  }
			  
			  Object[] keys = mpNewBak.keySet().toArray();
			  Arrays.sort(keys);   
			  
			  
			 
			  
			  for(int   i   =   0;   i   <   keys.length;   i++)   {  
	                  String date = (String)keys[i];
	                  times_bak = StringUtil.getNullValue(mpNewBak.get(date),"");
	                  times_cur = StringUtil.getNullValue(mpNewCur.get(date),"");
	                  String add ="";
	                  if("".equals(times_bak) && !"".equals(times_cur)){
	                	  add ="��";
	                  }
	                  
	                  if(!"".equals(times_bak) && "".equals(times_cur)){
	                	  add ="��";
	                  }
	                  
	                  sb.append(getValue(date+" "+add,times_bak,times_cur));	
	                  
//	                  System.out.println(">>>>>  bbbbbbbbbbbbbbbbbbb "+ getValue(date+"",add+""+times_bak,times_cur)) ;
	                  
	                  updateOrderState = true;
	                  
//	                  System.out.println(">>>>>  bbbbbbbbbbbbbbbbbbb  updateOrderState.booleanValue"+ updateOrderState.booleanValue()) ;
	         }   

			  
			  
			  

		  }
		  
		  
		  
		  return updateOrderState;
		  
		  
		  
//		  sb.append(getValue(date+"",times_bak,times_cur));	
		  
		  
		  //��������
//		  if(bList.size()>=0 && intersectionList.size() < bList.size()){
//			  Collection   subtractList_bak  =  CollectionUtils.subtract(disjunctionList, bList);
//			  Collection   subtractList_cur  =  CollectionUtils.subtract(disjunctionList, cList);
//			 
//		  }
	
		
//		if(!mpCur.keySet().iterator().)
//			sb.append(getValue("����",sumTimesMain_old,sumTimesMain_cur));	
		 
	}
	
	public static String getValue(String name, String oldOrderDetail,String curOrderDetail){
		return name +","+replace(oldOrderDetail)+","+replace(curOrderDetail)+"\n\r";
	}
	
	public static String replace(String sour){
		return sour.replace(',',' ');
	}
	
	public static Map getIndustryMaps(){
		return (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_INDUSTRY_Map);
	}
	public static String getIndustryNameById(Map mp,String id){
		Industry industry = (Industry)mp.get(id);
		return industry.getName();
	}
	public static String getIndustryNameById(String id){
		Map mp = getIndustryMaps();
		return getIndustryNameById(mp,id);
	}
	
	public static Map getOrderCategoryMaps(){
		return (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_ORDER_CATELOGNAME_MAP);
	}
	public static String getOrderCategoryNameById(Map mp,String id){
		OrderCategory orderCate = (OrderCategory)mp.get(id);
		String name = orderCate == null?"":orderCate.getName();
		return name;
	}
	public static String getOrderCategoryNameById(String id){
		Map mp = getOrderCategoryMaps();
		return getOrderCategoryNameById(mp,id);
	}
	
	public static String getSpecificNameById(String id){
		Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_SOECUFUC_MAP);
		Specific specific = (Specific)mp.get(id);
		return specific.getName();
	}
	
	public static String getResourceNameById(String id){
		String resourceName ="";
		if(!"0".equals(id)){
			Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_RESOURCENAME_MAP);
			Resource resource = (Resource)mp.get(id);
//		    System.out.println(" getResourceNameById    resource.getCarrier()>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>kkkkkkkkkkkk>>id>"+ id+">>>>>>>>>>>>>>>>>>>>>>>>>" +  resource );
//			String carrierName = resource.getCarrier() != null?resource.getCarrier().getCarrierName()+"||":"";
		    resourceName =resource.getCarrier().getCarrierName()+"||"+resource.getMemo()+"("+resource.getResourceName()+")";
		}
		return resourceName;
	}
	
	
	public static  String makeGridXML(List all){
		StringBuffer sb  = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");  
		
		int i=1;
		for(Iterator it = all.iterator();it.hasNext();){
			OrderLog orderLog =(OrderLog) it.next();
			
			String incomeDate = DateUtil.getDateTime("yyyy/MM/dd HH:mm:ss",orderLog.getLog().getModifyDate());
			sb.append("<row  id=\""+ orderLog.getId()  +"\">");
			sb.append("<cell><![CDATA["+ i++  +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderLog.getLog().getUser().getFullName()  +"]]></cell>");
			sb.append("<cell><![CDATA["+ incomeDate +"]]></cell>");
			sb.append("<cell><![CDATA["+ orderLog.getLog().getClientIp() +"]]></cell>");
			sb.append("</row>");
		 }
		
		sb.append("</rows>");
		
		return sb.toString();
	}
	
	
	private static String getOrderByStateId(int id,boolean isWithoutSubmit){

		
		if(id == 0) return isWithoutSubmit?" ":" ";
			
		if(id == 1) return "δ����";
		
		if(id == 2) return "�����";
		
		if(id == 3) return "ͨ��";

		if(id == 4)return "���˻�";
		
		return "δ֪״̬";
	
	}
	
	
	public static boolean  comparaValueForChangeEdit(boolean updateOrderState,OrderDetail oldOrderDetail, OrderDetail curOrderDetail){
		StringBuffer sb = new StringBuffer();
		
		String loginUser = oldOrderDetail.getLoginUser();
		String old_order_state = oldOrderDetail.getIsCkecked().toString();
		boolean tag_order_force_modify = UserUtil.isGrandedRes(loginUser,"tag_order_force_modify");
		boolean allowModiyPassedOrderParam = SysParamUtil.getAllowModiyPassedOrderParam();
		boolean permitModAdverParam = SysParamUtil.getPermitModAdverParam();
		boolean isCkecked ="1".equals(old_order_state)||"2".equals(old_order_state)||"3".equals(old_order_state);
		
		System.out.println("oldOrderDetail.getMatterLength()>>>>>>>>>>>>>>>>>>>>>>" +oldOrderDetail.getMatterLength());
		System.out.println("curOrderDetail.getMatterLength()>>>>>>>>>>>>>>>>>>>>>>" +curOrderDetail.getMatterLength());
		
		oldOrderDetail.setMatterLength(StringUtil.getNullValue(oldOrderDetail.getMatterLength(),"0"));
		curOrderDetail.setMatterLength(StringUtil.getNullValue(curOrderDetail.getMatterLength(),"0"));
		
		oldOrderDetail.setMemo(StringUtil.getNullValue(oldOrderDetail.getMemo(),""));
		curOrderDetail.setMemo(StringUtil.getNullValue(curOrderDetail.getMemo(),""));
		
		boolean lenChanged = !oldOrderDetail.getMatterLength().equals(curOrderDetail.getMatterLength());
		boolean editChanged = !oldOrderDetail.getMemo().equals(curOrderDetail.getMemo());
		
		
		
//		System.out.println("tag_order_force_modify>>>>>>>>>>>>>>>>>>>>>>>tag_order_force_modify>>>>>>>>>>>" +tag_order_force_modify);
//		System.out.println("allowModiyPassedOrderParam>>>>>>>>>>>>>>>>>>>>>>>allowModiyPassedOrderParam>>>>>>>>>>>" +allowModiyPassedOrderParam);
//		System.out.println("permitModAdverParam>>>>>>>>>>>>>>>>>>>>>>>permitModAdverParam>>>>>>>>>>>" +permitModAdverParam);
		
		Integer start_date_old = oldOrderDetail.getPublishStartDate();
		Integer start_date_cur = curOrderDetail.getPublishStartDate();
		Integer end_date_old = oldOrderDetail.getPublishEndDate();
		Integer end_date_cur = curOrderDetail.getPublishEndDate();
		
		Long resource_id_old = oldOrderDetail.getResourceInfoId();
		Long resource_id_cur = curOrderDetail.getResourceInfoId();
		

		
		boolean startChanged = start_date_old.intValue() != start_date_cur.intValue();
		boolean endChanged =  end_date_old.intValue() != end_date_cur.intValue();
		boolean resIdChanged = !String.valueOf(resource_id_old).equals(String.valueOf(resource_id_cur));
		
		
		if(isCkecked && lenChanged) updateOrderState = true;
//		if(!permitModAdverParam && editChanged) updateOrderState = true;
		//��泤��
		if(lenChanged){
			sb.append(getValue("��泤��",oldOrderDetail.getMatterLength(),curOrderDetail.getMatterLength()));		
//			if(isCkecked && !updateOrderState) updateOrderState = true;
		}
		//���汾
		if(editChanged){
			sb.append(getValue("���汾",oldOrderDetail.getMemo(),curOrderDetail.getMemo() ));		
			if(isCkecked && !updateOrderState){
				if(permitModAdverParam || allowModiyPassedOrderParam || tag_order_force_modify){
					
				}else{
					updateOrderState = true;
				}
			}
			
//			if((permitModAdverParam || allowModiyPassedOrderParam || tag_order_force_modify) && isCkecked && !updateOrderState){ updateOrderState = true;
//			String publish_date = DateUtil.SetDateFormat(publishDate,"yyyy-MM-dd");
//			System.out.println("detailId>>>>>>>>>>>>>>>>>>>>>>>start_date_old>>>>>>>>>>>" +start_date_old);
//			System.out.println("detailId>>>>>>>>>>>>>>>>>>>>>>>start_date_cur>>>>>>>>>>>" +start_date_cur);
//			System.out.println("detailId>>>>>>>>>>>>>>>>>>>>>>>end_date_old>>>>>>>>>>>" +end_date_old);
					

		}

		String old ="";String cur ="";
		if(startChanged || endChanged){
			 old = DateUtil.SetDateFormat(start_date_old.toString(),"yyyy/MM/dd")+"��"+DateUtil.SetDateFormat(end_date_old.toString(),"yyyy/MM/dd");
			 cur = DateUtil.SetDateFormat(start_date_cur.toString(),"yyyy/MM/dd")+"��"+DateUtil.SetDateFormat(end_date_cur.toString(),"yyyy/MM/dd");
			sb.append(getValue(oldOrderDetail.getMemo()+" | ��ֹʱ��",old,cur));		
		}	

//		System.out.println("comparaValueForChangeEdit>>>>>>>>>>>>>>>>>>>>>>>updateOrderState>>>>>>>>>>>" +updateOrderState);	
		
		saveLog(oldOrderDetail, sb.toString());
		
		return updateOrderState;

	}
	

	
	public static void saveLog(OrderDetail   orderDetail,String changeContent){
		RequestObject requestObject = RequestUtil.getReqInfo();
		String clientIp = requestObject != null ? requestObject.getRemoteAddr(): "δ̽��";
		OrderLogDao orderLogDao = ServiceLocator.getOrderLogDao();
		Long   orderId = orderDetail.getOrderId();
		Long   orderDetailId = orderDetail.getId();
		if(changeContent!=null && !changeContent.equals("") && orderDetailId != null){
//				Long   orderDetailId = orderDetail.getId();
				Long   modifyBy = orderDetail.getModifyBy();
				OrderLog orderLog= new OrderLog();
				orderLog.getLog().setClientIp(clientIp);
				orderLog.getLog().setModifyBy(modifyBy);
				orderLog.getLog().setModifyDate(new Date());
				orderLog.setOrderId(orderId);
				orderLog.setChangeContent(changeContent);
				orderLog.setOrderDetailId(orderDetailId);
				orderLogDao.saveOrderLog(orderLog);
		}
	}

	public static  void saveCheckRest(List idList,Long checkUserId,Long checkStateIdOld,Long checkStateIdnew,String defMsg){
		OaWorkFlowCheckDao workFlowCheckDao = ServiceLocator.getOaWorkFlowCheckDao();
		boolean isWithoutSubmit = SysParamUtil.getWithoutSubmitParam();
        
		String oldState =  getOrderByStateId( checkStateIdOld.intValue(), isWithoutSubmit);
		String newState =  getOrderByStateId( checkStateIdnew.intValue(), isWithoutSubmit);
		
		OaWorkFlowCheck oaWorkFlowCheck = new OaWorkFlowCheck();
		oaWorkFlowCheck.setVersion(new Integer(0));
		oaWorkFlowCheck.setCheckIdea(defMsg + " ������״̬�ӡ�"+ oldState+"����Ϊ��"+ newState+"��");
		oaWorkFlowCheck.setCheckUserId(checkUserId);
		oaWorkFlowCheck.setWorkFlowTypeId(new Long(1));
		oaWorkFlowCheck.setCreateDate(new Date());
		oaWorkFlowCheck.setCheckStateId(checkStateIdnew);
		oaWorkFlowCheck.setWorkFlowId(new Long(1));
		Long checkId = workFlowCheckDao.saveOaWorkFlowCheck(oaWorkFlowCheck);
		Iterator it = idList.iterator();
		   while(it.hasNext()){
			   	Map mp = new HashMap();
				mp.put("checkId",checkId);
				mp.put("orderId",(String)it.next());
				workFlowCheckDao.saveOaWorkFlowCheckOrders(mp);	
		   }

	}	
	
	
	
//	public static void saveNewDetailLog(OrderDetail orderDetail){
//	    RequestObject requestObject = RequestUtil.getReqInfo();
//		String clientIp =requestObject!= null? requestObject.getRemoteAddr():"δ����";
//		StringBuffer sb = new StringBuffer();
//		
//		String changeContent = sb.toString();
//		Long   orderId = orderDetail.getOrderId();
//		
//		if(changeContent!=null&&!changeContent.equals("")){
//
//			Long   orderDetailId = orderDetail.getId();
//			Long   modifyBy = orderDetail.getModifyBy();
//			Date   modifyDate = new Date();
//	
//			
//			OrderLog orderLog= new OrderLog();
//			orderLog.getLog().setClientIp(clientIp);
//			orderLog.getLog().setModifyBy(modifyBy);
//			orderLog.getLog().setModifyDate(new Date());
//			orderLog.setOrderId(orderId);
//			orderLog.setChangeContent(changeContent);
//			orderLog.setOrderDetailId(orderDetailId);
//			orderLogDao.saveOrderLog(orderLog); 
//
//		}
//		
//	}
	

}
