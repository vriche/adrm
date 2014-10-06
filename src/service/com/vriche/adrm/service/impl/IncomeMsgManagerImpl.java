package com.vriche.adrm.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Message;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.dao.OrderDao;
import com.vriche.adrm.model.ContractPayment;
import com.vriche.adrm.model.Income;
import com.vriche.adrm.service.IncomeMsgManager;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.SmackUtil;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.UserUtil;

public class IncomeMsgManagerImpl implements IncomeMsgManager {
	
	private OrderDao orderDao;
	
//	private  static XMPPConnection connection = null;
	
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	

	public Map getMessage(Income inc,Income incomeBak) {

		Long customerId = inc.getCustomerId();
		String customerName = inc.getCustomer().getCustomerName();
		double newMoney   = inc.getIncomeMoney().doubleValue();
		boolean isMoneyChanged = false;
		
		String messagePrefix1 ="";
		String messagePrefix2 ="";
		String messageBody ="";
		
		if(incomeBak.getId() == null){
			messagePrefix1 ="进帐提示";
			messagePrefix2 =",请相关人员及时查看客户欠款，并进行相应平帐!";
			messageBody="进款编号:【"+inc.getIncomeCode()+ "】"+"\r\n";
			messageBody =messageBody + "到款时间:【"+ DateUtil.SetDateFormat(inc.getIncomeDate().toString(),"yyyy-MM-dd") +"】"+"\r\n";
			messageBody =messageBody + "客户名称:【"+ customerName +"】"+"\r\n";
			messageBody =messageBody + "进款金额:【"+ StringUtil.doubleFormat(String.valueOf(newMoney)) +"】元"+"\r\n";
			isMoneyChanged = true;
		}else{
			messagePrefix1 ="修改进款!";
			double oldMoney = incomeBak.getIncomeMoney().doubleValue();
			double moneyIn = incomeBak.getIncomeUsed().doubleValue();
			double leaveMoney = newMoney - moneyIn;
			if(newMoney != oldMoney){
				messageBody="进款编号:【"+inc.getIncomeCode()+ "】"+"\r\n";
				messageBody =messageBody + "到款时间:【"+ DateUtil.SetDateFormat(inc.getIncomeDate().toString(),"yyyy-MM-dd") +"】"+"\r\n";
				messageBody =messageBody + "客户名称:【"+ customerName +"】"+"\r\n";
				messageBody =messageBody + "改前金额:【"+ StringUtil.doubleFormat(String.valueOf(oldMoney)) +"】元"+"\r\n";
				messageBody =messageBody + "改后金额:【"+ StringUtil.doubleFormat(String.valueOf(newMoney)) +"】元"+"\r\n";
				if(leaveMoney != newMoney){
					messageBody =messageBody + "剩余金额:【"+ StringUtil.doubleFormat(String.valueOf(leaveMoney)) +"】元"+"\r\n";
				}
				
				isMoneyChanged = true;
			}
		}
		

		if(isMoneyChanged){
			XMPPConnection con = SmackUtil.getHelperIncConnection();
			String serviceName = "@" + con.getServiceName();

			List ls = getOpenfireUsers(customerId);
			if(ls.size() == 0) {
				messagePrefix2 ="";
				messageBody =messageBody + "此客户在系统中没有找到相应的订单!"+"\r\n";
				
				List allInOrderUsers = getOpenfireUsers(null);
				if(allInOrderUsers.size()>0) ls.addAll(allInOrderUsers);
			}
			String msg = messagePrefix1+messagePrefix2+"\r\n"+ messageBody+"\r\n";
			Message newMessage = getMessage(msg);
			
			List ls2 = UserUtil.getMsgAlertUser("1");
			if(ls2.size()>0) ls.addAll(ls2);
			List ls3 = new ArrayList();
			StringUtil.getCollectionFromList(ls,ls3);
			System.out.println("ls3>>>>>>>"+ls3.size());
			Iterator it = ls3.iterator();
			while(it.hasNext()){
				String user = (String)it.next()+ serviceName;
				System.out.println("user>>>>>>>"+user);
				SmackUtil.sendMessage(con,user,newMessage);
			}
		}

//		connection.close();
		// TODO Auto-generated method stub
		
		return null;

	}
	
	private Message getMessage(String msg) {
		Message newMessage = new Message();
		newMessage.setBody(msg);
		newMessage.setProperty("favoriteColor", "red");
        return newMessage;
	}


	public void setDao(Dao dao) {
		// TODO Auto-generated method stub

	}

	public List getObjects(Class clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getObject(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveObject(Object o) {
		// TODO Auto-generated method stub

	}

	public void removeObject(Class clazz, Serializable id) {
		// TODO Auto-generated method stub

	}
	
	private List getOpenfireUsers(Long customerId){
		Map mp = new HashMap();
		mp.put("customerId",customerId);
		return orderDao.getOrderSignUsersForOpenFire(mp);
	}
	


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public boolean sendCuiKuan2SignUser(ContractPayment[] payments,String loginUser) {
		boolean b = true;
		XMPPConnection con = SmackUtil.getHelperCuikConnection();
		Map mp = new HashMap();
		
		
		
		for(int i=0;i<payments.length;i++){
			String userName = payments[i].getOrderUser().getUsername();
			mp.put(userName,userName);
		}
		
		Iterator it = mp.keySet().iterator();
		while(it.hasNext()){
			String user = (String)it.next();
			user = user +"@" + con.getServiceName();
			if(!user.equals(loginUser)){
				String messagePrefix1 ="<"+UserUtil.getCurUser(loginUser).getFullName() +">通知您向以下客户催款";
				StringBuffer sb = new StringBuffer();
				sb.append(messagePrefix1);
				sb.append("\r\n");
				
				for(int i=0;i<payments.length;i++){
					String OrderCode = StringUtil.null2String(payments[i].getOrderCode());
					String conno = StringUtil.null2String(payments[i].getContractCode());
					String customerName = payments[i].getCustomerName();
					String advName = payments[i].getMemo();//广告名称
		//			String userName = payments[i].getOrderUser().getUsername();
					double dmoneyPay = payments[i].getMoneyPay().doubleValue();
					double dmoneyIn = payments[i].getMoneyIn().doubleValue();
					double dcuiKuanMoney = dmoneyPay -dmoneyIn;
					String moneyPay = StringUtil.doubleFormat(String.valueOf(dmoneyPay));
					String cuiKuanMoney =StringUtil.doubleFormat( String.valueOf(dcuiKuanMoney));
					
					sb.append("【"+customerName+"：" + advName+"】");
					sb.append("\r\n");
					
					if(conno.equals("")){
						sb.append("【订单号："+OrderCode +"   ");
					}else{
						sb.append("【合同号："+OrderCode +"   ");
					}

					sb.append("应付:"+moneyPay+"   ");
					sb.append("欠款:"+cuiKuanMoney+"】");
					
					sb.append("\r\n");sb.append("\r\n");
				}
				Message newMessage = getMessage(sb.toString());
				b = SmackUtil.sendMessage(con,user,newMessage);
			}
			
		
		}
		return b;
	}
  
	
}
