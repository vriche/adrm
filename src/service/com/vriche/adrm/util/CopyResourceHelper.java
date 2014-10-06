package com.vriche.adrm.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.vriche.adrm.dao.CarrierDao;
import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.service.impl.BaseManager;

public class CopyResourceHelper extends BaseManager {
	
	static Integer versionSource = 2013;
	static Integer versionTarg = 2014;
	
	public static void copyCarrier(){
		
		String s1 = "delete  from tb_ad_resource_carrier where version=" + versionTarg;
		excuteConn(s1,versionTarg.toString());
		
		Carrier carPar = new Carrier();
		carPar.setVersion(versionSource);
		CarrierDao dao = ServiceLocator.getCarrierDao();
		List ls = dao.getCarriers(carPar);
		Iterator it = ls.iterator();
		while(it.hasNext()){
			Carrier carrier = (Carrier)it.next();
			carrier.setVersion(versionTarg);
			carrier.setId(null);
			dao.saveCarrier(carrier);
		}
	}
	
	
	
	
	
	public static void copyRes(){
		 String s1 = "select * from tb_ad_resource_carrier where version=" + versionSource;
		 String s2 = "select * from tb_ad_resource_info where version " + versionSource;
	}
	public static void excuteConn(String sql,String version){
		Dao dao = ServiceLocator.getDao();
		try {
			dao.getDefaultDataSource().getConnection().createStatement().execute(sql);
		} catch (SQLException e) {
			 System.out.println(sql+"/n;系统数据库升级到"+ version +"失败");
//			e.printStackTrace();
		}
	}
	
	private ResultSet executeQuery(String sql){
		try {
			return dao.getDefaultDataSource().getConnection().createStatement().executeQuery(sql);
		} catch (SQLException e) {
			return null;
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
	
	
}
