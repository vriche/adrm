package com.vriche.adrm.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.vriche.adrm.service.UpdateSystemManager;
import com.vriche.adrm.dao.UpdateSystemDao;


public class UpdateSystemManagerImpl extends BaseManager implements UpdateSystemManager {
	
	private UpdateSystemDao updateSystemDao;

	public void setUpdateSystemDao(UpdateSystemDao updateSystemDao) {
		this.updateSystemDao = updateSystemDao;
	}

	public void excuteSqlMermDB() {
		updateSystemDao.excuteUpdate11();
	}
	public void excuteSqlDistanceDB() {
		updateSystemDao.excuteUpdate12();
	}

	public void excuteSqlClearDataDB() {
		updateSystemDao.excuteUpdate13();
	}
	
	public void excuteSqlClearDataDBorder() {
		updateSystemDao.excuteUpdate13_1();
	}

	public void excuteSqlTransferDataDB() {
		updateSystemDao.excuteUpdate14();
	}
	
	public void clearOrderByYear(String year) {
		
		int count = 0;
		int limit = 10000;
		int size = 0;
//		String sql2 = "select 1;";
//		this.excuteSql(sql2);
		//创建临时表
		String sql = "DROP TABLE IF EXISTS tb_temp;";
		this.excuteSql(sql);
		sql = "CREATE TABLE tb_temp (id bigint(20) DEFAULT NULL) ENGINE=myisam DEFAULT CHARSET=gbk";
		this.excuteSql(sql);
		
		sql = "DROP TABLE IF EXISTS tb_temp2";
		this.excuteSql(sql);
		sql = "CREATE TABLE tb_temp2 (id bigint(20) DEFAULT NULL) ENGINE=myisam DEFAULT CHARSET=gbk";
		this.excuteSql(sql);
		
		sql = "DROP TABLE IF EXISTS tb_temp3";
		this.excuteSql(sql);
		sql = "CREATE TABLE tb_temp3 (id bigint(20) DEFAULT NULL) ENGINE=myisam DEFAULT CHARSET=gbk";
		this.excuteSql(sql);
		
		//删除订单及合同审核
		sql = "UPDATE tb_oa_work_flow_check A INNER JOIN ";
		sql =  sql+" (select t1.work_flow_check_id from tb_oa_work_flow_check t1 ";
		sql =  sql+"    INNER JOIN tb_oa_work_flow_result_order t2 on t1.work_flow_check_id = t2.work_flow_check_id ";
		sql =  sql+"    INNER JOIN tb_order t3 on  t2.order_id =t3.order_id and t3.version=@year) as B ";
		sql =  sql+"  ON A.work_flow_check_id = B.work_flow_check_id ";
		sql =  sql+" SET A.version = "+year;

		sql = "UPDATE tb_oa_work_flow_check A INNER JOIN ";
		sql =  sql+" (select t1.work_flow_check_id from tb_oa_work_flow_check t1 ";
		sql =  sql+"    INNER JOIN tb_oa_work_flow_result_contract t2 on t1.work_flow_check_id = t2.work_flow_check_id ";
		sql =  sql+"    INNER JOIN tb_order t3 on  t2.contract_id =t3.contract_id and t3.version=@year) as B ";
		sql =  sql+"  ON A.work_flow_check_id = B.work_flow_check_id ";
		sql =  sql+" SET A.version = "+year;

		sql = "delete from tb_oa_work_flow_result_order where order_id in(select order_id from tb_order where version="+ year+")";
		this.excuteSql(sql);
		sql = "delete from tb_oa_work_flow_result_contract where contract_id in(select contract_id from tb_order where version="+ year+")";
		this.excuteSql(sql);
		sql = "delete from tb_oa_work_flow_check where version ="+year;
		this.excuteSql(sql);
		

		//财务信息
//		sql = "truncate table tb_temp";
//		this.excuteSql(sql);
//		sql ="insert into tb_temp  select distinct income_pull_id as id from tb_income_used U where order_day_info_id in(";
//		sql = sql + "SELECT A.order_day_info_id FROM tb_order_day_info A ";
//		sql = sql + " INNER JOIN tb_order_detail B ON A.order_detail_id = B.order_detail_id AND B.version ="+ year;
//		this.excuteSql(sql);	
//		sql ="insert into tb_temp3 select distinct income_id as id  from tb_income_pull PULL where income_pull_id in(SELECT id FROM tb_temp)";
//		this.excuteSql(sql);	

//		sql = "select count(*)  from tb_income_used  where  order_day_info_id in(";
//		sql = sql +"select A.order_day_info_id from tb_order_day_info  A ";
//		sql = sql +" INNER JOIN tb_order_detail  B ON A.order_detail_id = B.order_detail_id AND B.version="+ year +")";
//		count = executeQuery(sql);
//		if(count >0){
//			size = count/limit+1;
//			 System.out.println("count>>>>>>>>>>>"+count);
//			 System.out.println("size>>>>>>>>>>>"+size);
//			for(int i=0;i<size;i++){
//				sql = "delete from tb_income_used where order_day_info_id in(";
//				sql = sql +"select A.order_day_info_id from tb_order_day_info  A ";
//				sql = sql +" INNER JOIN tb_order_detail  B ON A.order_detail_id = B.order_detail_id AND B.version="+ year +") limit "+limit;		
//				this.excuteSql(sql);			
//			}	
//		}	
		

		sql = "select count(*) from tb_income_used where income_pull_id in (select A.income_pull_id FROM tb_income_pull A,tb_income B where A.income_id=B.income_id  AND year(B.income_pull_date)="+ year +")";
		count = executeQuery(sql);
		if(count >0){
			size = count/limit+1;
			 System.out.println("count>>>>>>>>>>>"+count);
			 System.out.println("size>>>>>>>>>>>"+size);
			for(int i=0;i<size;i++){
				 System.out.println("i>>>>>>>>>>>"+i);
				sql = "delete from tb_income_used where income_pull_id in(";
				sql = sql +"select A.income_pull_id FROM tb_income_pull A,tb_income B where A.income_id=B.income_id  AND year(B.income_pull_date)="+ year +") limit "+limit;	
				this.excuteSql(sql);			
			}	
		}		
		
		
		
	
		
		
		
		
		
//		select count(*) from tb_income_used where income_pull_id in (select income_pull_id from tb_income_pull where version=2012);
		
		sql = "truncate table tb_temp";
		this.excuteSql(sql);	
		sql ="insert into tb_temp  select  income_id as id from tb_income  where year(income_pull_date)="+year;
		this.excuteSql(sql);
//		sql = "delete t1 from tb_income_used t1,tb_temp t2 where t1.income_id=t2.id";
//		this.excuteSql(sql);
//		sql = "delete  from tb_income_pull  where income_id in(select income_id from tb_income where version="+ year +")";
		sql = "delete t1 from tb_income_pull as t1, tb_temp as t2 where t1.income_id = t2.id";
		this.excuteSql(sql);	
		
		sql = "delete  from tb_income   where year(income_pull_date)="+year;
		this.excuteSql(sql);			
		
//		sql = "delete  from tb_income where version="+ year;
//		this.excuteSql(sql);
		
		
		
		sql = "truncate table tb_temp";
		this.excuteSql(sql);
		sql ="insert into tb_temp SELECT distinct P.contract_payment_id as id FROM tb_contract_payment P INNER JOIN tb_order O ON O.order_id = P.order_id AND O.version ="+ year;
		this.excuteSql(sql);
		sql ="insert into tb_temp SELECT distinct P.contract_payment_id as id FROM tb_contract_payment P INNER JOIN tb_contract C ON C.contract_id = P.contract_id AND C.version ="+ year;
		this.excuteSql(sql);
		sql = "delete t1 from tb_contract_payment as t1, tb_temp as t2 where t1.contract_payment_id = t2.id";
		this.excuteSql(sql);	
		
		
		//删除划归年份与订单不同年份
		sql = "truncate table tb_temp3";
		this.excuteSql(sql);
		sql = "insert into tb_temp3  select  distinct t1.income_pull_id from tb_income_used t1,tb_temp t2 where   t1.payment_id= t2.id" ;
		this.excuteSql(sql);
		sql = "truncate table tb_temp2";
		this.excuteSql(sql);
		sql = "insert into tb_temp2  select t1.income_id from tb_income_pull t1,tb_temp3 t2 where   t1.income_pull_id= t2.id";
		this.excuteSql(sql);
		sql = "delete t1 from tb_income_used t1,tb_temp3 t2 where   t1.income_pull_id= t2.id";
		this.excuteSql(sql);
		sql = "delete t1 from tb_income_pull t1,tb_temp3 t2 where   t1.income_pull_id= t2.id";
		this.excuteSql(sql);
		sql = "delete t1 from tb_income t1,tb_temp2 t2 where  t1.income_id= t2.id";	
		this.excuteSql(sql);
		
		
		sql = "select count(*)  from tb_income_used  where  order_day_info_id in(";
		sql = sql +"select A.order_day_info_id from tb_order_day_info  A ";
		sql = sql +" INNER JOIN tb_order_detail  B ON A.order_detail_id = B.order_detail_id AND B.version="+ year +")";
		count = executeQuery(sql);
		if(count >0){
			size = count/limit+1;
			 System.out.println("count>>>>>>>>>>>"+count);
			 System.out.println("size>>>>>>>>>>>"+size);
			for(int i=0;i<size;i++){
				sql = "delete from tb_income_used where order_day_info_id in(";
				sql = sql +"select A.order_day_info_id from tb_order_day_info  A ";
				sql = sql +" INNER JOIN tb_order_detail  B ON A.order_detail_id = B.order_detail_id AND B.version="+ year +") limit "+limit;		
				this.excuteSql(sql);			
			}	
		}		
		
		
		


		sql = "truncate table tb_temp";
		this.excuteSql(sql);
		sql ="insert into tb_temp select  arrange_id as id from tb_published_arrang where  year(publish_date) ="+year;
		this.excuteSql(sql);	
		sql = "delete t1 from tb_published_arrang_detail as t1, tb_temp as t2 where t1.arrange_id = t2.id";
		this.excuteSql(sql);	
		sql = "delete from tb_published_arrang where  year(publish_date) ="+year;
		this.excuteSql(sql);	


//		sql = "delete from tb_order_log where order_id in (select id from tb_temp)";
//		sql = "truncate table tb_temp";
//		this.excuteSql(sql);
//		sql ="insert into tb_temp select  order_id as id from tb_order where  version ="+year;
//		this.excuteSql(sql);
		
	
		sql = "select count(*)  from tb_order_log t1 ";
		sql = sql +" inner join tb_order t2 on  t1.order_id=t2.order_id and t2.version="+year;
		count = executeQuery(sql);
		
		if(count >0){
			size = count/limit+1;
			 System.out.println("count>>>>>>>>>>>"+count);
			 System.out.println("size>>>>>>>>>>>"+size);
			 
			for(int i=0;i<size;i++){
				 System.out.println("i>>>>>>>>>>>"+i);
//				sql = "delete  from tb_order_log where year(modify_date)="+ year +" limit "+limit;
				sql = "delete  from tb_order_log where order_id in(select order_id from tb_order where  version ="+ year+") limit "+limit;
//				sql = "delete t1 from tb_order_log AS t1, tb_order as t2 WHERE t2.order_id = t1.order_id and t2.version="+ year +" limit " + start +"," + end;
				this.excuteSql(sql);			
			}			
		}


		sql = "select count(*)  from tb_order_day_info  where  order_detail_id in(select order_detail_id from tb_order_detail where  version ="+ year+")";
		count = executeQuery(sql);
		if(count >0){
			size = count/limit+1;
			 System.out.println("count>>>>>>>>>>>"+count);
			 System.out.println("size>>>>>>>>>>>"+size);
			for(int i=0;i<size;i++){
				 System.out.println("i>>>>>>>>>>>"+i);
				sql = "delete from tb_order_day_info where order_detail_id in(select order_detail_id from tb_order_detail where  version ="+ year+") limit "+limit;
				this.excuteSql(sql);			
			}				
		}		
	
		

		sql = "select count(*)  from tb_order_detail  where  version ="+ year;
		count = executeQuery(sql);
		if(count >0){
			size = count/limit+1;
			 System.out.println("count>>>>>>>>>>>"+count);
			 System.out.println("size>>>>>>>>>>>"+size);
			for(int i=0;i<size;i++){
				 System.out.println("i>>>>>>>>>>>"+i);
				sql = "delete from tb_order_detail where version="+ year +" limit "+limit;
				this.excuteSql(sql);			
			}
		}		
		


		sql = "delete from tb_order where  version ="+ year;
		this.excuteSql(sql);
		
		
//		sql = "truncate table tb_temp3";
//		this.excuteSql(sql);
//		sql ="insert into tb_temp3 select  order_detail_id as id from tb_order_detail where  order_id in(select id from tb_temp)";
//		this.excuteSql(sql);	
//		sql = "delete from tb_order_day_info where order_detail_id in (select id from tb_temp3)";
//		sql = "delete from tb_order_detail where order_id in (select id from tb_temp)";
		

		//广告素材
		sql = "delete t1 from tb_adver_matter t1 where t1.adver_matter_id not in(select adver_matter_id  from tb_order_detail)";
		this.excuteSql(sql);
//		sql = "truncate table tb_temp3";
//		this.excuteSql(sql);
//		sql ="insert into tb_temp3 select  adver_matter_id as id from tb_order_detail where  order_id in(select id from tb_temp)";
//		this.excuteSql(sql);
		
//		sql = "truncate table tb_temp";
//		sql ="insert into tb_temp select  adver_matter_id as id from tb_order_detail where  order_id in(select  order_id from tb_order where  version !="+year+")";
//		this.excuteSql(sql);
//		
//		sql = "delete from tb_adver_matter where adver_matter_id in (select id from tb_temp2 and id not in(select id from tb_temp))";
//		this.excuteSql(sql);
		
		
		
//		set @year = 2009;
//		delete t1 from tb_ad_resource_price_detail_rel t1,tb_ad_resource_price t2 where t1.ad_resource_price_id = t2.ad_resource_price_id and t2.version= @year;
//		delete t1 from tb_ad_resource_compages_price_rel t1,tb_ad_resource_price t2 where t1.ad_resource_price_id = t2.ad_resource_price_id and t2.version= @year;
//		delete t1 from tb_ad_resource_price_rel t1,tb_ad_resource_price t2 where t1.ad_resource_price_id = t2.ad_resource_price_id and t2.version= @year;
//
//		delete t1 from tb_ad_resource_day_info t1,tb_ad_resource_info t2 where t1.ad_resource_info_id = t2.ad_resource_info_id and t2.version= @year;
//		delete t1 from tb_ad_resource_package_pos_rel t1,tb_ad_resource_info t2 where t1.ad_resource_info_id = t2.ad_resource_info_id and t2.version=@year;
//		delete t1 from tb_ad_resource_workspan t1,tb_ad_resource_info t2 where t1.ad_resource_info_id = t2.ad_resource_info_id and t2.version= @year;
//
//		delete  from tb_ad_resource_price_detail where version= @year;
//		delete  from tb_ad_resource_price where version= @year;
//		delete   from tb_ad_resource_compages where version= @year;
//		delete   from tb_ad_resource_info where version= @year;
		
		
		//删除价格信息
		sql ="delete t1 from tb_ad_resource_price_detail_rel t1,tb_ad_resource_price t2 where t1.ad_resource_price_id = t2.ad_resource_price_id and t2.version="+ year;
		this.excuteSql(sql);
		sql ="delete t1 from tb_ad_resource_compages_price_rel t1,tb_ad_resource_price t2 where t1.ad_resource_price_id = t2.ad_resource_price_id and t2.version="+ year;
		this.excuteSql(sql);
		sql ="delete t1 from tb_ad_resource_price_rel t1,tb_ad_resource_price t2 where t1.ad_resource_price_id = t2.ad_resource_price_id and t2.version="+ year;
		this.excuteSql(sql);
		sql ="delete t1 from tb_ad_resource_package_pos_rel t1,tb_ad_resource_price t2 where t1.ad_resource_info_id = t2.ad_resource_price_id and t2.version="+ year;
		this.excuteSql(sql);
		
		sql = "select count(t1.*)  from tb_ad_resource_day_info t1 ,tb_ad_resource_info t2 where t1.ad_resource_info_id = t2.ad_resource_info_id and t2.version="+ year;
		count = executeQuery(sql);
		if(count >0){
			size = count/limit+1;
			 System.out.println("count>>>>>>>>>>>"+count);
			 System.out.println("size>>>>>>>>>>>"+size);
			for(int i=0;i<size;i++){
				 System.out.println("i>>>>>>>>>>>"+i);
				 sql ="delete t1 from tb_ad_resource_day_info t1,tb_ad_resource_info t2 where t1.ad_resource_info_id = t2.ad_resource_info_id and t2.version="+ year;
				 this.excuteSql(sql);		
			}
		}			
		

		
		sql ="delete t1 from tb_ad_resource_workspan t1,tb_ad_resource_info t2 where t1.ad_resource_info_id = t2.ad_resource_info_id and t2.version="+ year;
		this.excuteSql(sql);
		
		sql ="delete  from tb_ad_resource_price_detail where version="+ year;
		this.excuteSql(sql);
		sql ="delete  from tb_ad_resource_price where version="+ year;
		this.excuteSql(sql);
		sql ="delete  from tb_ad_resource_compages where version="+ year;
		this.excuteSql(sql);
		sql ="delete  from tb_ad_resource_info where version="+ year;
		this.excuteSql(sql);
		sql ="delete  from tb_ad_resource_carrier where node_level=2 and version="+ year;
		this.excuteSql(sql);
		
		//删除时段
		
		

	}
	
	private void excuteSql(String sql){
		System.out.println(sql);
		try {
			updateSystemDao.getDefaultDataSource().getConnection().createStatement().execute(sql);
		} catch (SQLException e) {
			 System.out.println("执行失败");
			e.printStackTrace();
		}
	}
	
	private int executeQuery(String sql){
		System.out.println(sql);
		
		int count = 0;
		try {
			ResultSet rs = updateSystemDao.getDefaultDataSource().getConnection().createStatement().executeQuery(sql);
			if (rs.next()){ count = rs.getInt(1); }
		} catch (SQLException e) {
			 System.out.println("执行失败");
			e.printStackTrace();
		}
		return count;
	}
	
}
