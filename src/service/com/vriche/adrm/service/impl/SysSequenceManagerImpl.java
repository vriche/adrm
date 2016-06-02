
package com.vriche.adrm.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.SysSequenceDao;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.model.SysSequence;
import com.vriche.adrm.service.SysSequenceManager;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.SysParamUtil;

public class SysSequenceManagerImpl extends BaseManager implements SysSequenceManager {
    private SysSequenceDao dao;

    /** 
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setSysSequenceDao(SysSequenceDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.SysSequenceManager#getSysSequences(com.vriche.adrm.model.SysSequence)
     */
    public List getSysSequences(final SysSequence sysSequence) {
        return dao.getSysSequences(sysSequence);
    }
   /**
     * @see com.vriche.adrm.service.SysSequenceManager#getSysSequencesCount(com.vriche.adrm.model.SysSequence)
     */
    public String getSysSequencesCount(final SysSequence sysSequence) {
        return dao.getSysSequencesCount(sysSequence).toString();
    }    

   /**
     * @see com.vriche.adrm.service.SysSequenceManager#getSysSequencesCount(com.vriche.adrm.model.SysSequence)
     */    
	public PaginatedList getSysSequencesPage(final SysSequence sysSequence,String pageIndex, String pageSize) {
		return dao.getSysSequencesPage(sysSequence,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.SysSequenceManager#getSysSequence(String sequenceID)
     */
    public SysSequence getSysSequence(final String sequenceID) {
        return dao.getSysSequence(new String(sequenceID));
    }
    /**
     * @see com.vriche.adrm.service.SysSequenceManager#getSysSequencesByIdList(final Map idList)
     */
    public List getSysSequencesByIdList(final Map idList) {
        return dao.getSysSequencesByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.SysSequenceManager#saveSysSequence(SysSequence sysSequence)
     */
    public String saveSysSequence(SysSequence sysSequence) {
    	

    	
        return dao.saveSysSequence(sysSequence).toString();
    }

    /**
     * @see com.vriche.adrm.service.SysSequenceManager#removeSysSequence(String sequenceID)
     */
    public void removeSysSequence(final String sequenceID) {
        dao.removeSysSequence(new String(sequenceID));
    }

     /**
     * @see com.vriche.adrm.service.SysSequenceManager#removeSysSequences(String Map)
     */
    public void removeSysSequences(final Map idList) {
        dao.removeSysSequences(idList);
    }    
    
    
    public  synchronized String getSysSequenceByObject2(String name) {
    	SysSequence sequence = new SysSequence();
    	sequence.setName(name);
    	SysSequence sysSequence = dao.getSysSequenceByObject(sequence);
    	String currentNext = (sysSequence == null)?"待定...":sysSequence.getCurrentNext().toString();
    	return currentNext;
    }
    
    public synchronized String getSysSequenceByObject(String orgId,String name) {
    	SysSequence sequence = new SysSequence();
    	SysSequence sysSequence = new SysSequence();
    	String date = DateUtil.getDate();
    	String autoCode ="";
    	String tvName = SysParamUtil.getTvNameParam();
    	boolean fztv = SysParamUtil.isFZTVParam(tvName);
//    	boolean xmtv = SysParamUtil.isXMTVParam(tvName);
		int startNo = 5;
		String nextIncomeCode = "1";
    	String datecode = date.substring(2,6);
    	
    	if(log.isDebugEnabled()){
        	System.out.println("getSysSequenceByObject>>>>>name>>>>>>>>>>>>>>>>>>>>>>>>>>  "+name );
        	System.out.println("getSysSequenceByObject>>>>orgId>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+orgId );
    	}

    	
    	sequence.setName(name);
    	sequence.setVersion(new Integer(orgId));
    	sysSequence = dao.getSysSequenceByObject(sequence);
    	
    	String currentNext = (sysSequence == null)?null:sysSequence.getCurrentNext().toString();
    	String prefix = (sysSequence==null)?"":sysSequence.getPrefix();
    	prefix = prefix == null?"":prefix;
    	
//    	if(xmtv && Constants.SEQUENCE_TB_ORDER_RELATION.equals(name)){
//    		String s[] = name.split(",");
//    		String resType =  s[1];
//    		String ageType =  s[2];
//    		name = s[0];
//    	}
    	
    	//如果有前缀
//    	if(prefix!=null) datecode = prefix;
    	
//    	if(fztv){
//    		datecode = year;
//    		startNo = 4;
//    	}
   

    	if(currentNext == null){
    		SysSequence sysobj = new SysSequence();
//    		if(fztv && Constants.SEQUENCE_TB_INCOME.equals(name)){
//    			try {
//					dao.getDefaultDataSource().getConnection().createStatement().execute("update tb_income set income_code =income_id");
//					ResultSet rs = dao.getDefaultDataSource().getConnection().createStatement().executeQuery("select max(income_code)+1 as id from tb_income");
//					while (rs.next()){nextIncomeCode = (String)rs.getString("id");}
//
//					sysobj.setCurrentNext( new Long(Long.valueOf(nextIncomeCode).longValue()+1));
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//    			
//    		}else{
    			sysobj.setCurrentNext(new Long("2"));
//    		}
    		sysobj.setVersion(new Integer(orgId));
    		sysobj.setName(name);
    		sysobj.setStartNo(new Long(startNo));
    		saveSysSequence(sysobj);
    		currentNext = "1";
    	}else{
    		startNo = sysSequence.getStartNo().intValue();
	    	Long curNext = new Long(currentNext);
	    	sysSequence.setCurrentNext(new Long(curNext.longValue()+1));
	    	sysSequence.setVersion(new Integer(orgId));
	    	nextIncomeCode = String.valueOf(curNext.longValue());
	    	saveSysSequence(sysSequence);
    	}
    	while(currentNext.length()!= startNo){
    		currentNext = "0"+currentNext;
    	}
    	
    	
    	


    	if(Constants.SEQUENCE_TB_ADVER_MATTER.equals(name)){
    		autoCode = prefix + currentNext;
    	}
    	
    	if(Constants.SEQUENCE_TB_CONTRACT.equals(name)|| Constants.SEQUENCE_TB_ORDER.equals(name)){
    		autoCode = prefix + datecode + currentNext;
    	}
    	
    	if(Constants.SEQUENCE_TB_INCOME.equals(name)){
    		autoCode = nextIncomeCode;
    	}

       return autoCode;
    }
    
 	
 	public synchronized SysSequence getSysSequenceByObject(SysSequence sysSequence){
 		return dao.getSysSequenceByObject(sysSequence);
 	}
    public synchronized String getSysSequenceByObject(String orgId,String name,String year) {
    	SysSequence sequence = new SysSequence();
    	SysSequence sysSequence = new SysSequence();
    	String date = DateUtil.getDate();
    	String autoCode ="";
    	String yy="";
    	String mm="";
    	
    	String tvName = SysParamUtil.getTvNameParam();
    	boolean fztv = SysParamUtil.isFZTVParam(tvName);
    	boolean xmtv = SysParamUtil.isXMTVParam(tvName);
    	boolean qztv = SysParamUtil.isQZTVParam(tvName);
    	boolean hbtv = SysParamUtil.isHBTVParam(tvName);
    	boolean sxtv = SysParamUtil.isSXTVParam(tvName);

    	
		int startNo = 5;
		
		if((xmtv||qztv||hbtv||sxtv) && Constants.SEQUENCE_TB_INCOME.equals(name)){
			yy = year.substring(2,4);
			mm = year.substring(4,6);
		}else{
			yy = year.substring(2,4);
			mm = date.substring(4,6);
			if(!year.equals(date.substring(0,4))) mm = "01";
		}

		
		
//		System.out.println("year1111111111111  "+year == date.substring(0,4));
//		
//		System.out.println("year1111111111111  "+year.endsWith(date.substring(0,4)));
//		
//		
//		System.out.println("year1111111111111  "+date.substring(0,4));
//		
//		System.out.println("date1111111111111  "+date.substring(0,4));
		if(log.isDebugEnabled()){
			System.out.println("orgId>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+orgId);
		}

		
//    	String datecode = date.substring(2,6);
    	String datecode = yy + mm;
    	if(fztv){
    		datecode = yy;
    		startNo = 4;
    	}
    	
    	if((xmtv||qztv||hbtv||sxtv)){
    		if(Constants.SEQUENCE_TB_INCOME.equals(name)){
        		startNo = 4;	
    		}else{
        		datecode = year;
        		startNo = 5;
    		}
    	}	
    	
    	
    	sequence.setVersion(new Integer(orgId));
    	sequence.setName(name);
    	
    	if((xmtv||qztv||hbtv||sxtv) && Constants.SEQUENCE_TB_INCOME.equals(name)){
        	sequence.setSuffix(datecode);
    	}else{
        	sequence.setSuffix(year);
    	}

    	
    	sysSequence = dao.getSysSequenceByObject(sequence);
    	
    	String currentNext = (sysSequence == null)?null:sysSequence.getCurrentNext().toString();
    	String prefix = (sysSequence==null)?"":sysSequence.getPrefix();
    	prefix = prefix == null?"":prefix;
    	
    	//如果有前缀
//    	if(prefix!=null) datecode = prefix;
   
//    	System.out.println("1111111111111  "+currentNext);
    	if(currentNext == null){
    		SysSequence sysobj = new SysSequence();
    		sysobj.setCurrentNext(new Long("2"));
    		sysobj.setName(name);
    		if((xmtv||qztv||hbtv||sxtv) && Constants.SEQUENCE_TB_INCOME.equals(name)){
    			sysobj.setSuffix(datecode);
    			System.out.println("setSuffix>>>>>>datecode>>>>>>>>>>>>>>>>>>>>>  "+datecode);
    		}else{
    			sysobj.setSuffix(year);
    			System.out.println("setSuffix>>>>>>>>>>>year>>>>>>>>>>>>>>>>  "+year);
    		}
    
    		
    		sysobj.setStartNo(new Long(startNo));
    		sysobj.setVersion(new Integer(orgId));
    		saveSysSequence(sysobj);
    		currentNext = "1";
    	}else{
    		startNo = sysSequence.getStartNo().intValue();
	    	Long curNext = new Long(currentNext);
	    	sysSequence.setCurrentNext(new Long(curNext.longValue()+1));
	    	sysSequence.setVersion(new Integer(orgId));
	    	saveSysSequence(sysSequence);
    	}
    	while(currentNext.length()!= startNo){
    		currentNext = "0"+currentNext;
    	}

    	
    	if(Constants.SEQUENCE_TB_CONTRACT.equals(name)|| Constants.SEQUENCE_TB_ORDER.equals(name)){
    		autoCode = prefix + datecode + currentNext;
    	}
    	
    	if(Constants.SEQUENCE_TB_PRO_ORDER_X.equals(name)){
    		autoCode = "X" + datecode + currentNext;
    	}
    	
    	if(Constants.SEQUENCE_TB_PRO_ORDER_C.equals(name)){
    		autoCode = "C" + datecode + currentNext;
    	}
    	
    	if(Constants.SEQUENCE_TB_INCOME.equals(name)){
    		autoCode = datecode + currentNext;
    	}
    	
       return autoCode;
    }
    
    
    public synchronized String getSysSequenceRelationCode(String temStr,String name,String year) {
//    	temStr  0 组织编号 1 时段类型（1时段 3栏目）2、客户类型
    	String tem[] = temStr.split(",");
    	String orgId = tem[0];
    	String resourceSortCode = "P";  //时段 P 栏目 L
    	
    	String customerCategoryId = tem[2]; //代理 A 直接 C  其它E
    	
    	String customerCategoryCode ="E"; //代理 A 直接 C  其它E
    	
        if("3".equals(tem[1])) resourceSortCode = "L";
    	if("2".equals(customerCategoryId)) customerCategoryCode ="A";
    	if("3".equals(customerCategoryId) ) customerCategoryCode ="C";
    	if("4".equals(customerCategoryId)) customerCategoryCode ="E";
    	
    	String preFix = resourceSortCode+customerCategoryCode;
    	
    	
    	if (log.isDebugEnabled()){
        	log.info("customerCategoryId>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+customerCategoryId);
        	log.info("preFix>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+preFix);
    	}
    	
    	int startNo = 5;
    	
    	SysSequence sequence = new SysSequence();
    	sequence.setVersion(new Integer(orgId));
    	sequence.setName(name);
    	sequence.setPrefix(preFix);
    	sequence.setSuffix(year);
    	SysSequence sysSequence  = dao.getSysSequenceByObject(sequence);
    	
    	Long currentNext = (sysSequence == null)?null:sysSequence.getCurrentNext();
//    	String prefix = (sysSequence==null)?"":sysSequence.getPrefix();
//    	prefix = prefix == null?"":prefix;
    	
    	

    	
    	
    	
    	long nextIncomeCode = 0;
    	if(currentNext == null){
    		
    	    String sql = "select max(substring(O.relation_code,7)) as id from tb_order O " +
    	    		" left outer join tb_customer_info C  on O.customer_id = C.customer_id " +
    	    		" where substring(O.relation_code,1,2) = '"  + preFix +"' AND  C.sys_org_id =" +orgId;
			ResultSet rs;
			try {
				rs = dao.getDefaultDataSource().getConnection().createStatement().executeQuery(sql);
				while (rs.next()){nextIncomeCode = rs.getLong("id");}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("nextIncomeCode>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+nextIncomeCode);
			
    		if(nextIncomeCode == 0){
        		if("PA".equals(preFix)){
        			currentNext = new Long("10000");
         		}else if("PC".equals(preFix)){
        			currentNext = new Long("20000");
        		}else if("LA".equals(preFix)){
        			currentNext = new Long("30000");
        		}else if("LC".equals(preFix)){
        			currentNext = new Long("40000");
        		}else if("PE".equals(preFix)){
        			currentNext = new Long("50000");
        		}else if("LE".equals(preFix)){
        			currentNext = new Long("60000");
        		}   			
    		}else{
    			currentNext = new Long(nextIncomeCode);
    	
    		}

    		System.out.println("orgId>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+orgId);
    		SysSequence sysobj = new SysSequence();
    		sysobj.setVersion(new Integer(orgId));
    		sysobj.setName(name);
    		sysobj.setPrefix(preFix);
    		sysobj.setSuffix(year);
    		sysobj.setStartNo(new Long(startNo));
    		currentNext = new Long(currentNext.longValue()+1);
    		sysobj.setCurrentNext(new Long(currentNext.longValue()+1));
    		
    		saveSysSequence(sysobj);
    		
    	}else{
//    		startNo = sysSequence.getStartNo().intValue();
//    		currentNext = new Long(currentNext.longValue()+1);
	    	sysSequence.setCurrentNext(new Long(currentNext.longValue()+1));
	    	sysSequence.setVersion(new Integer(orgId));
	    	
	    	saveSysSequence(sysSequence); 
    	} 	
    	
    	
//    	String code = currentNext.toString();
//    	while(code.length()!= startNo){code = "0"+ code;}    	
//    	code = year + code;
    	
    	System.out.println("relcode>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+currentNext.toString());
    	
    	return preFix + year + currentNext.toString();
    	
    }
	public String getSysSequenceByObjectNew(String orgId, String name, String year) {
		
		return getSysSequenceByObject( orgId, name, year);

	}
}
