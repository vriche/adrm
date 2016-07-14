
package com.vriche.adrm.dao.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.vriche.adrm.dao.DayInfoDao;
import com.vriche.adrm.model.DayInfo;


public class DayInfoDaoiBatis extends BaseDaoiBATIS implements DayInfoDao {

    /**
     * @see com.vriche.adrm.adres.dao.DayInfoDao#getDayInfos(com.vriche.adrm.adres.model.DayInfo)
     */
    public List getDayInfos(final DayInfo dayInfo) {
          return getSqlMapClientTemplate().queryForList("getDayInfos", dayInfo);
    }
    
    
    public List getDayInfosFromOrder(final DayInfo dayInfo) {
        return getSqlMapClientTemplate().queryForList("getDayInfosFromOrder", dayInfo);
  }  
    
     
    
    /**
     * @see com.vriche.adrm.adres.dao.DayInfoDao#getDayInfosForFree(com.vriche.adrm.adres.model.DayInfo)
     */
    public List getDayInfosForFree(final DayInfo dayInfo) {
          return getSqlMapClientTemplate().queryForList("getDayInfosForFree", dayInfo);
    }
    
    
    /**
     * @see com.vriche.adrm.adres.dao.DayInfoDao#getDayInfosByIdList(com.vriche.adrm.adres.model.DayInfo)
     */
    public List getDayInfosByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getDayInfosByIdList", idList);
    }

    
    /**
     * @see com.vriche.adrm.adres.dao.DayInfoDao#getDayInfo(Long id)
     */
    public DayInfo getDayInfo(Long id) {
        DayInfo dayInfo = (DayInfo) getSqlMapClientTemplate().queryForObject("getDayInfo", id);

        if (dayInfo == null) {
            throw new ObjectRetrievalFailureException(DayInfo.class, id);
        }

        return dayInfo;
    }

    /**
     * @see com.vriche.adrm.adres.dao.DayInfoDao#saveDayInfo(DayInfo dayInfo)
     */    
    public void saveDayInfo(final DayInfo dayInfo) {
        Long id = dayInfo.getId();
        Integer version = dayInfo.getVersion();
        
        // check for new record
       
        if (id == null && id.equals("0")) {
            if (version.intValue() != 2){
                id = (Long) getSqlMapClientTemplate().insert("addDayInfo", dayInfo);
            }
        } else {
            if (version.equals("2") || version.intValue() == 2 || version.toString() == "2"){
                if(dayInfo.getPublishDate().intValue()>0 || dayInfo.getPublishDate() != null){
                    getSqlMapClientTemplate().update("updateDayInfo-saveOrderDetail", dayInfo);
                }
            }else{
                
                getSqlMapClientTemplate().update("updateDayInfo", dayInfo);
            }
        }
//        if( id == null ) {
//            throw new ObjectRetrievalFailureException(DayInfo.class, id);
//        }
    }
    
    
    public void saveDayInfo2(final DayInfo[] dayInfos) {
    	try {
			getSqlMapClientTemplate().getSqlMapClient().startBatch();
			
			for(int i = 0;i < dayInfos.length;i++){
				 DayInfo  dayInfo = dayInfos[i];
				 String changeValue = getNullValue(dayInfo.getChangedValue(),"0");
				 if(!"0".equals(changeValue) && !"0.0".equals(changeValue)){
					 getSqlMapClientTemplate().getSqlMapClient().update("updateDayInfo-saveOrderDetail-new", dayInfo); 
				 }
			}
			
			getSqlMapClientTemplate().getSqlMapClient().executeBatch();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    
    
    
    
    private  String getNullValue(Object obj,String def) {
		try {
			String i = String.valueOf (obj);
//			i = i.equals("null")||i.equals("undefined")||i.equals("")?def:i;
			i = "null".equals(i)||"undefined".equals(i)||"".equals(i)?def:i;
			return i;
		} catch (Exception ex) {
			String j = def;
			return j;
		}
   }  
    
    public void saveDayInfo2(final Map newResMap) {
    	try {
			getSqlMapClientTemplate().getSqlMapClient().startBatch();
			Iterator it = newResMap.values().iterator();

			while(it.hasNext()){
				 DayInfo day = (DayInfo)it.next();
				 double used = Double.parseDouble(day.getUsed())+day.getChangedValue().doubleValue();
//				 if(used == 0)
				 day.setUsed(String.valueOf(used));
				 String changeValue = getNullValue(day.getChangedValue(),"0");
//				 if(!"0".equals(changeValue) && !"0.0".equals(changeValue) || !"".equals(day.getSpecific())){
					 getSqlMapClientTemplate().getSqlMapClient().update("updateDayInfo-saveOrderDetail", day); 
//				 }
//				 System.out.println("saveResourceInfo getResourceId>>>>>>>>>>>>>>>>>>>>>>"+day.getResourceId());
//				 System.out.println("saveResourceInfo getPublishDate>>>>>>>>>>>>>>>>>>>>>>"+day.getPublishDate());
//				 System.out.println("saveResourceInfo getUsed>>>>>>>>>>>>>>>>>>>>>>"+day.getUsed());
//				 System.out.println("saveResourceInfo getSpecific>>>>>>>>>>>>>>>>>>>>>>"+day.getSpecific());
//				 System.out.println("saveResourceInfo getChangedValue>>>>>>>>>>>>>>>>>>>>>>"+day.getChangedValue());
//				 System.out.println("saveResourceInfo xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx>>>>>>>>>>>>>>>>>>>>>>");
			 }				

			getSqlMapClientTemplate().getSqlMapClient().executeBatch();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    } 
    
    
//    public void saveDayInfo3(final Map newResMap) {
//    	try {
//			getSqlMapClientTemplate().getSqlMapClient().startBatch();
//			Iterator it = newResMap.values().iterator();
//
//			while(it.hasNext()){
//				 DayInfo day = (DayInfo)it.next();
//				 double used = Double.parseDouble(day.getUsed())+day.getChangedValue().doubleValue();
////				 if(used == 0)
//				 day.setUsed(String.valueOf(used));
//				 String changeValue = getNullValue(day.getChangedValue(),"0");
//				 getSqlMapClientTemplate().getSqlMapClient().update("updateDayInfo-saveOrderDetail", day); 
//			 }				
//
//			getSqlMapClientTemplate().getSqlMapClient().executeBatch();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//    }  
    
    

    /**
     * @see com.vriche.adrm.adres.dao.DayInfoDao#removeDayInfo(Long id)
     */
    public void removeDayInfo(Long id) {
        getSqlMapClientTemplate().update("deleteDayInfo", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.DayInfoDAO#removeDayInfos(String ids)
     */
    public void removeDayInfos(final Map idList) {
        getSqlMapClientTemplate().update("deleteDayInfos", idList);
    }    
    
    
    /**
     * @see com.vriche.adrm.adres.dao.DayInfoDao#getGroupLeftTime(com.vriche.adrm.adres.model.DayInfo)
     */
    public List getGroupLeftTime(final DayInfo dayInfo) {
          return getSqlMapClientTemplate().queryForList("getGroupLeftTime", dayInfo);
    }


    public List getDayInfos2(final DayInfo dayInfo) {
        return getSqlMapClientTemplate().queryForList("getDayInfos2", dayInfo);
  }


	public void updateDayInfoLock(Map mp) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().update("updateDayInfoLock", mp);
	}


	public List getResDayInfosByOrderDetail2(Map mp) {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getResDayInfosByOrderDetail2", mp);
	}
	
	
	
}
