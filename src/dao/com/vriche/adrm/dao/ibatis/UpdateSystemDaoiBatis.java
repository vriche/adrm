package com.vriche.adrm.dao.ibatis;


//import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;

import javax.sql.DataSource;

import com.ibatis.common.jdbc.ScriptRunner;
import com.ibatis.common.resources.Resources;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.UpdateSystemDao;
import com.vriche.adrm.model.SysMenu;

public class UpdateSystemDaoiBatis extends BaseDaoiBATIS implements UpdateSystemDao {

 public void excuteUpdate1(){
	 try{
		 getSqlMapClientTemplate().queryForObject("opinionFromTable",null);
		 	
	 	}catch(Exception e1){
	 		addCloumnFromTable();
	 		
	 	} 
		 	
	}
	
	
	

	private void addCloumnFromTable() {
	// TODO Auto-generated method stub
		
		 try{
			 getSqlMapClientTemplate().queryForObject("addCloumnFromTable",null);
			 	
		 	}catch(Exception e1){
		 		System.out.print(11);
		 		
		 	} 
}




	public void excuteUpdate3() {
		// TODO Auto-generated method stub
		 try{
			 	getSqlMapClientTemplate().queryForObject("opinionFromSysOry",null);
			 	
		 	}catch(Exception e1){
		 		addLogoTable();
		 		
		 	} 
	}




	private void addLogoTable() {
		// TODO Auto-generated method stub
		
	 	 try{
	 		getSqlMapClientTemplate().queryForObject("addLogo",null);
		 	getSqlMapClientTemplate().queryForObject("addLogoType",null);
			 	
		 	}catch(Exception e1){
		 		System.out.print(11);
		 		
		 	} 
	}




	public void excuteUpdate2() {
		 try{
			 	getSqlMapClientTemplate().queryForObject("get_tb_foret_arrearage",null);
			 	
		 	}catch(Exception e1){
		 		createTableForetArrearag();
		 		
		 	} 
	}

	private void createTableForetArrearag() {
		// TODO Auto-generated method stub
		
	 	 try{
	 		getSqlMapClientTemplate().queryForObject("create_tb_foret_arrearage",null);
			 	
		 	}catch(Exception e1){
		 		System.out.print(11);
		 		
		 	} 
	}




	public void excuteUpdate4() {
	 	 try{

	 		 
	 		 	//getSqlMapClientTemplate().getSqlMapClient().startBatch();
	 		 	
	 		 	getSqlMapClientTemplate().queryForObject("updateSystem_version_1",null);
	 		 	
	 		 	
		 		getSqlMapClientTemplate().queryForObject("updateSystem_1",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_2",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_3",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_4",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_5",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_5_1",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_6",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_7",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_8",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_9",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_10",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_11",null);
		 		
		 		
		 		//西安
		 		getSqlMapClientTemplate().queryForObject("updateSystem_11_1",null); //********
		 		getSqlMapClientTemplate().queryForObject("updateSystem_12",null);  //**********
		 		getSqlMapClientTemplate().queryForObject("updateSystem_12_0",null); //**********
		 		getSqlMapClientTemplate().queryForObject("updateSystem_12_1",null); 
		 		getSqlMapClientTemplate().queryForObject("updateSystem_12_2",null);
		 		
		 		getSqlMapClientTemplate().queryForObject("updateSystem_13",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_14",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_15",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_16",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_17",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_18",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_19",null);
		 		
		 		getSqlMapClientTemplate().queryForObject("updateSystem_20",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_21",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_22",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_23",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_24",null);		 		
		 		getSqlMapClientTemplate().queryForObject("updateSystem_25",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_26",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_27",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_28",null);	 
		 		getSqlMapClientTemplate().queryForObject("updateSystem_29",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_30",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_31",null);
		 		
		 		//getSqlMapClientTemplate().getSqlMapClient().executeBatch();
				 	
			 	}catch(Exception e1){
			 		System.out.print(11);
			 		
			 	} 
		
	}



 
	public void excuteUpdate5() {
		 try{
	 		 	getSqlMapClientTemplate().queryForObject("updateSystem_version_2",null);
		 		getSqlMapClientTemplate().queryForObject("updateSystem_32",null);

		 	}catch(Exception e1){
		 		System.out.print(11);
		
	}
	
	}




	public void excuteUpdate6() {
		 try{
			 
			  
			  //**************
		 		System.out.print(" updateSystem_11_2");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_11_2",null);
		 		System.out.print(" updateSystem_11_3");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_11_3",null);
		 		System.out.print(" updateSystem_31_1");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_31_1",null);
		 		
			    
		 		
		 		System.out.print(" updateSystem_19_0");
			    getSqlMapClientTemplate().queryForObject("updateSystem_19_0",null);
			    
			    System.out.print(" updateSystem_19_1");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_19_1",null);
		 		
		 		System.out.print(" updateSystem_19_2");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_19_2",null);
		 		
		 		System.out.print(" updateSystem_19_3");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_19_3",null);
		 		
		 		System.out.print(" updateSystem_19_4");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_19_4",null);
		 		
		 		
		 		
		 		System.out.print(" updateSystem_19_5");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_19_5",null);
		 		System.out.print(" updateSystem_19_6");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_19_6",null);
		 		System.out.print(" updateSystem_19_7");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_19_7",null);
		 		System.out.print(" updateSystem_19_8");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_19_8",null);
		 		System.out.print(" updateSystem_19_9");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_19_9",null);
		 		
		 		System.out.print(" updateSystem_version_3");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_version_3",null);
		 		
		 		System.out.print(" 升级成功");

		 	}catch(Exception e1){
		 		System.out.print(" 升级问题");
		
	}
		
	}




	public void excuteUpdate7() {
		 try{
		 		System.out.print(" updateSystem_33");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_33",null);
		 		
		 		System.out.print(" updateSystem_1_1");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_1_1",null);	
		 		
		 		System.out.print(" updateSystem_34");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_34",null);		
		 		
		 		System.out.print(" updateSystem_35");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_35",null);			 		
		 		
		 		

		 		System.out.print(" updateSystem_version_4");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_version_4",null);
		 		
		 		System.out.print(" 升级成功");

		 	}catch(Exception e1){
		 		System.out.print(" 升级问题");
		
	}
		
	}




	public void excuteUpdate8() {
		 try{
		 		System.out.print(" updateSystem_36");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_36",null);
		 		
		 		System.out.print(" updateSystem_37");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_37",null);
		 		

		 		System.out.print(" updateSystem_version_5");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_version_5",null);
		 		
		 		System.out.print(" 升级成功");

		 	}catch(Exception e1){
		 		System.out.print(" 升级问题");
		
	}
		
	}




	public void excuteUpdate9() {
		 try{
		 		System.out.print(" updateSystem_38");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_38",null);
		 		
		 		System.out.print(" updateSystem_39");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_39",null);
		 		
		 		System.out.print(" updateSystem_40");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_40",null);
		 		
		 		System.out.print(" updateSystem_41");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_41",null);
		 		
		 		System.out.print(" updateSystem_42");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_42",null);
		 		
		 		System.out.print(" updateSystem_43");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_43",null);
		 		
		 		System.out.print(" updateSystem_44");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_44",null);
		 		
		 		System.out.print(" updateSystem_version_6");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_version_6",null);
		 		
		 		System.out.print(" 升级成功");

		 	}catch(Exception e1){
		 		System.out.print(" 升级问题");
		
	}
		
	}




	public void excuteUpdate10() {
		 try{
				String filePath = Constants.FILE_PATH_SQL_SCRIPT + "adrm-20090508.xml";
			    executeUpdateScript(filePath);
		 		
		 		System.out.print(" updateSystem_version_7");
		 		getSqlMapClientTemplate().queryForObject("updateSystem_version_7",null);

		 		System.out.print(" 升级成功");

		 	}catch(Exception e1){
		 		System.out.print(" 升级问题");
		
	}
		
	}
	
	
	
	
	
	
public int executeUpdateScript(String filePath) {
	
	 
	
		DataSource dataSource= this.getDefaultDataSource();
		try {
			Connection conn = dataSource.getConnection();
//			System.out.println("conn>>>>>>>>>>>>>>>"+conn.toString());
			try {
				File file =   Resources.getResourceAsFile(filePath);
				InputStream sqlFileIn = new FileInputStream(file);
				InputStreamReader reader= new InputStreamReader(sqlFileIn, "UTF-8");  
				ScriptRunner runner = new ScriptRunner(conn, false, false);
				runner.setLogWriter(null);
				runner.setErrorLogWriter(null);
				runner.runScript(reader);
				conn.commit();
				reader.close();  
//				System.out.println(">>>>>>>>>>>>>>> ok");
			} finally {
				conn.close();
			}  
		}catch (Exception e) {  
			       throw new RuntimeException("Description.  Cause: " + e, e);  

		}  
		return 1;
	}




public void excuteUpdate11() {
	
	try{
		String filePath = Constants.FILE_PATH_SQL_SCRIPT + "adrm-merm-default.xml";
		executeUpdateScript(filePath);
		System.out.print("初始化数据表成功!");
	}catch(Exception e1){
 		System.out.print("初始化数据表出错!");
	}
		
}
public void excuteUpdate12() {
	
	try{
		String filePath = Constants.FILE_PATH_SQL_SCRIPT + "adrm-20091009.xml";
		executeUpdateScript(filePath);
		System.out.print("初始化远程签单成功!");
	}catch(Exception e1){
 		System.out.print("初始化远程签单出错!");
	}	
}
public void excuteUpdate13() {
	
	try{
		String filePath = Constants.FILE_PATH_SQL_SCRIPT + "adrm-empty-data.xml";
		executeUpdateScript(filePath);
		System.out.print("清空业务数据成功!");
	}catch(Exception e1){
 		System.out.print("清空业务数据出错!");
	}	
}
public void excuteUpdate13_1() {
	
	try{
		String filePath = Constants.FILE_PATH_SQL_SCRIPT + "adrm-empty-data-order.xml";
		executeUpdateScript(filePath);
		System.out.print("清空合同数据成功!");
	}catch(Exception e1){
 		System.out.print("清空合同数据出错!");
	}	
}
public void excuteUpdate14() {
	
	try{
		String filePath = Constants.FILE_PATH_SQL_SCRIPT + "adrm-bak-arrange-data.xml";
		executeUpdateScript(filePath);
		System.out.print("转移数据成功!");
	}catch(Exception e1){
 		System.out.print("转移数据出错!");
	}	
}

//public void excuteUpdate15() {
//	
//	try{
//		String filePath = Constants.FILE_PATH_SQL_SCRIPT + "adrm-20110701.xml";
//		executeUpdateScript(filePath);
//		System.out.print("数据校对成功!");
//	}catch(Exception e1){
// 		System.out.print("数据校对出错!");
//	}	
//}

}
