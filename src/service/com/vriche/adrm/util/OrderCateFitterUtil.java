package com.vriche.adrm.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.SysParamDao;



public class OrderCateFitterUtil {

	public static void saveFitterSwit(String swit){
	
		 //审计过滤开关
		if("".equals(swit) || "0".equals(swit)|| "false".equals(swit)) {
			swit= "0";
		}else{
			swit= "1";
		}

		SysParamDao dao = ServiceLocator.getSysParamDao();

		String sql = "update tb_sys_param set value = '"+ swit +"' where name='" + Constants.FINANCIA_AUDIT_PARAM +"'";

		try {
			dao.getDefaultDataSource().getConnection().createStatement().execute(sql);
	
			 //过滤开关
			Constants.APPLACTION_MAP.put(Constants.FINANCIAL_AUDIT_SWITCH,swit);
			
			 System.out.println(sql+"/n;修改" +Constants.FINANCIA_AUDIT_PARAM +"_"+ swit +"成功");
			 
		} catch (SQLException e) {
			System.out.println(sql+"/n;修改" +Constants.FINANCIA_AUDIT_PARAM +"_"+ swit +"失败");
		}
		

	}
	
	public static void saveOrderCateFitterParam2(String version ,String str1,String str2){
		SysParamDao dao = ServiceLocator.getSysParamDao();
		List ls1 = new ArrayList();
		List ls2 = new ArrayList();

		List ls3 = new ArrayList();
		List ls4 = new ArrayList();
		  
		String sql="";
		try {
			 //过滤订单类别
			sql = "delete from  tb_fitter_ordercate   where version =" + version;
			dao.getDefaultDataSource().getConnection().createStatement().execute(sql);
			if(!"".equals(str1)){
				String[] s = str1.split("@");
				if(s.length >1){
					Object[] values =  s[0].split(",");
					for(int i = 0;i<values.length;i++){
						if(!"".equals(values[i])){
							 sql = "insert into  tb_fitter_ordercate (version,order_cate_id) values ("+ version+","+ values[i]+")";
								dao.getDefaultDataSource().getConnection().createStatement().execute(sql);
								ls1.add(values[i]);
								System.out.println(sql+"/n;");
						}

					}
				}
				if(s.length ==2){
					Object[] values = s[1].split(",");
					CollectionUtils.addAll(ls3,values);
//					System.out.println("saveOrderCateFitterParam2>>>****************************************>>>>>str2 >>>>>>>"+ls3);
				}

			}			
			
			 //过滤到款用途
			boolean notloadTree = !"notloadTree".equals(str2);
			if(notloadTree){
				sql = "delete from  tb_fitter_incomepurpose   where version =" + version;
				dao.getDefaultDataSource().getConnection().createStatement().execute(sql);
				if(!"".equals(str2)){
					String[] s = str2.split("@");
					if(s.length >1){
						Object[] values = s[0].split(",");
//						System.out.println("saveOrderCateFitterParam2>>>****************************************>>>>>str2 >>>>>>>"+s.length);
//						System.out.println("saveOrderCateFitterParam2>>>****************************************>>>>>str[0] >>>>>>>"+values.length);
						for(int i = 0;i<values.length;i++){
							if(!"".equals(values[i])){
								 sql = "insert into  tb_fitter_incomepurpose (version,income_purpose_id) values ("+ version+","+ values[i]+")";
									dao.getDefaultDataSource().getConnection().createStatement().execute(sql);
									ls2.add(values[i]);
									System.out.println(sql+"/n;");
							}

						}
					}
					if(s.length ==2){
						Object[] values = s[1].split(",");
						CollectionUtils.addAll(ls4,values);
					}
				}	
			}


			Map  mp = (Map)Constants.APPLACTION_MAP.get(Constants.FITTER_ORDER_SUBCATES_WITHOUT);
			if(mp == null) mp = new HashMap();
			mp.put(version,ls1);
			
			if(notloadTree){
				Map  mp2 = (Map)Constants.APPLACTION_MAP.get(Constants.FITTER_INCOME_POURS_WITHOUT);
				if(mp2 == null) mp2 = new HashMap();
				mp2.put(version,ls2);			
			}

			
			Map  mp3 = (Map)Constants.APPLACTION_MAP.get(Constants.FITTER_ORDER_SUBCATES);
			if(mp3 == null) mp3 = new HashMap();
			mp3.put(version,ls3);	
			
			if(notloadTree){
				Map  mp4 = (Map)Constants.APPLACTION_MAP.get(Constants.FITTER_INCOME_POURS);
				if(mp4 == null) mp4 = new HashMap();
				mp4.put(version,ls4);	
			}

	
			 
		} catch (SQLException e) {
			System.out.println(sql+"/n;修改updateOrderCateFitterParam2失败");
		}
		
		
	}	

	
	
	
	
	public static String[]  getFitterIds(String version){
		String[] str = new String[3];
		str[0] = getFitterIds1(version,0);
		str[1] = getFitterIds1(version,1);
		str[2] = getFitterIds1(version,2);
		
//		System.out.println("getFitterIds>>>>>>>>str[0] >>>>>>>"+str[0]);
//		System.out.println("getFitterIds>>>>>>>>str[1] >>>>>>>"+str[1]);
//		System.out.println("getFitterIds>>>>>>>>str[2] >>>>>>>"+str[2]);
		return str;
	}
	
	
	public static String  getFitterIds1(String version,int type){
	
		 if(type == 0){
			 System.out.println("FINANCIA_AUDIT_PARAM>>>>>>> >>>>>>>"+Constants.APPLACTION_MAP.get(Constants.FINANCIAL_AUDIT_SWITCH));
			 return (String) Constants.APPLACTION_MAP.get(Constants.FINANCIAL_AUDIT_SWITCH);
		 }else{
			    List ls = getFitterIds2(version,type);
			    StringBuffer sb = new StringBuffer();
				Iterator it = ls.iterator();
				int size = ls.size();
				int i = 0;
				while(it.hasNext()){
					String id = (String)it.next();
					i++;
					sb.append(id);
					if(i < size) sb.append(",");
				}
				return sb.toString();
		 }
	}
	
	
public static List  getFitterIds2(String version,int type){
		
		List ls   = new ArrayList();
		String sql = "";

		 
		 if(type ==1 || type ==3){
				SysParamDao dao = ServiceLocator.getSysParamDao();
				ResultSet rs;
				try {
					if(type ==1){
						sql ="select order_cate_id from tb_fitter_ordercate where version="+ version;
					}else{
						sql ="select  A.order_category_id as order_cate_id  from tb_order_category  A "
						+" WHERE A.order_category_id NOT IN(select order_cate_id from tb_fitter_ordercate where version="+ version +")"
						+"	and  A.version = 0 OR  A.version ="+ version;	
					}

					rs = dao.getDefaultDataSource().getConnection().createStatement().executeQuery(sql);

					
					while (rs.next()){
						String id = (String)rs.getString("order_cate_id");
						ls.add(id);
				
					}
				} catch (SQLException e) {

					e.printStackTrace();
				}
		 }
		 
		 if(type ==2||type ==4){
				SysParamDao dao = ServiceLocator.getSysParamDao();
				 ResultSet rs;
				try {
					rs = dao.getDefaultDataSource().getConnection().createStatement().executeQuery("select income_purpose_id from tb_fitter_incomepurpose where version="+ version);

					if(type ==2){
						sql ="select income_purpose_id from tb_fitter_incomepurpose where version="+ version;
					}else{
						sql ="select  A.income_purpose_id from tb_income_purpose  A "
						+" WHERE A.income_purpose_id NOT IN(select income_purpose_id from tb_fitter_incomepurpose where version="+ version +")";
					}					

					rs = dao.getDefaultDataSource().getConnection().createStatement().executeQuery(sql);
					
					while (rs.next()){
						String id = (String)rs.getString("income_purpose_id");
						ls.add(id);
					}
				} catch (SQLException e) {
	
					e.printStackTrace();
				}
				
		 }		 
		 
         return ls;

		 
		 
	}
	
	public static Map  getFitterIds3(int type){
		Map mp = new HashMap();
		SysParamDao dao = ServiceLocator.getSysParamDao();
		 ResultSet rs;
			try {
				if(type ==1 || type ==3){
					rs = dao.getDefaultDataSource().getConnection().createStatement().executeQuery("select distinct version from tb_fitter_ordercate");
				}else{
					rs = dao.getDefaultDataSource().getConnection().createStatement().executeQuery("select distinct version from tb_fitter_incomepurpose");
				}
				
//				else if(type ==3){
//					rs = dao.getDefaultDataSource().getConnection().createStatement().executeQuery("select  order_category_id  from tb_order_category  A WHERE order_category_id NOT IN(select  order_cate_id   from  tb_fitter_ordercate B)");
//				}else{
//					rs = dao.getDefaultDataSource().getConnection().createStatement().executeQuery("select distinct version from tb_fitter_incomepurpose");
//				}

				while (rs.next()){
					String version = (String)rs.getString("version");
				    List ls = getFitterIds2(version,type);
				    mp.put(version,ls);
			
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		 return mp;
		 
		 
	}
	
	
}
	