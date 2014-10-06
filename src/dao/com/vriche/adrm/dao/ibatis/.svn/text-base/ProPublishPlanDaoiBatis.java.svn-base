
package com.vriche.adrm.dao.ibatis;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.ProPublishPlan;
import com.vriche.adrm.model.ProPublishPlanDetail;
import com.vriche.adrm.dao.ProPublishPlanDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ProPublishPlanDaoiBatis extends BaseDaoiBATIS implements ProPublishPlanDao {

    /**
     * @see com.vriche.adrm.dao.ProPublishPlanDao#getProPublishPlans(com.vriche.adrm.model.ProPublishPlan)
     */
    public List getProPublishPlans(final ProPublishPlan proPublishPlan) {
          return getSqlMapClientTemplate().queryForList("getProPublishPlans", proPublishPlan);
    }
     /**
     * @see com.vriche.adrm.dao.ProPublishPlanDao#getProPublishPlansCount(com.vriche.adrm.model.ProPublishPlan)
     */
    public Integer getProPublishPlansCount(final ProPublishPlan proPublishPlan) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getProPublishPlansCount", proPublishPlan);
    }
     /**
     * @see com.vriche.adrm.dao.ProPublishPlanDao#getProPublishPlansPage(com.vriche.adrm.model.ProPublishPlan)
     */   
  	public List getProPublishPlansPage(final ProPublishPlan proPublishPlan,int pageIndex, int pageSize) {
		 int skip = pageIndex * pageSize;
		 return getSqlMapClientTemplate().queryForList("getProPublishPlans",proPublishPlan,skip,pageSize);
	}  
    /**
     * @see com.vriche.adrm.dao.ProPublishPlanDao#getProPublishPlansByIdList(com.vriche.adrm.model.ProPublishPlan)
     */
    public List getProPublishPlansByMap(final Map mp) {
          return getSqlMapClientTemplate().queryForList("getProPublishPlansByIdList", mp);
    }
    
    /**
     * @see com.vriche.adrm.dao.ProPublishPlanDao#proPublishPlanResultCollection(com.vriche.adrm.model.ProPublishPlan)
     */
    public List getProPublishPlanCollection(final ProPublishPlan proPublishPlan) {
          return getSqlMapClientTemplate().queryForList("getProPublishPlanCollection", proPublishPlan);
    }

    /**
     * @see com.vriche.adrm.dao.ProPublishPlanDao#getProPublishPlan(ProPublishPlan proPublishPlan)
     */
    public List getProPublishPlan(ProPublishPlan proPublishPlan) {
    	return getSqlMapClientTemplate().queryForList("getProPublishPlans",proPublishPlan);
    }
    
    /**
     * @see com.vriche.adrm.dao.ProPublishPlanDao#getProPublishPlan(Long id)
     */
    public ProPublishPlan getProPublishPlan(Long id) {
        ProPublishPlan proPublishPlan = (ProPublishPlan) getSqlMapClientTemplate().queryForObject("getProPublishPlan", id);

        if (proPublishPlan == null) {
            throw new ObjectRetrievalFailureException(ProPublishPlan.class, id);
        }

        return proPublishPlan;
    }

    /**
     * @see com.vriche.adrm.dao.ProPublishPlanDao#saveProPublishPlan(ProPublishPlan proPublishPlan)
     */    
    public Long saveProPublishPlan(final ProPublishPlan proPublishPlan) {
        Long id = proPublishPlan.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addProPublishPlan", proPublishPlan);
        } else {
            getSqlMapClientTemplate().update("updateProPublishPlan", proPublishPlan);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ProPublishPlan.class, id);
        }
        return  id;
    } 
    
    public static final Date convertStringToDate(String aMask, String strDate)
    throws ParseException {
      SimpleDateFormat df = null;
      Date date = null;
      df = new SimpleDateFormat(aMask);

      try {
          date = df.parse(strDate);
      } catch (ParseException pe) {
          //log.error("ParseException: " + pe);
          throw new ParseException(pe.getMessage(), pe.getErrorOffset());
      }

      return (date);
  }	
    public static String getWeekConvert(int week){
    	String weekStr = null;
		   switch(week){
				    case 1:
		 				weekStr = "星期日";
		 				break;
		   			case 2:
		   				weekStr = "星期一";
		   				break;
		   			case 3:
		   				weekStr = "星期二";
		   				break;
		   			case 4:
		   				weekStr = "星期三";
		   				break;
		   			case 5:
		   				weekStr = "星期四";
		   				break;
		   			case 6:
		   				weekStr = "星期五";
		   				break;
		   			case 7:
		   				weekStr = "星期六";
		   				break;
		   			}
		   return weekStr;
    }
    
    public void saveProPublishPlanDetail(ProPublishPlan proPlanDetail,List weeksPlanList) {
    	
		try {
			getSqlMapClientTemplate().getSqlMapClient().startBatch();
			
			Long id = proPlanDetail.getId();
			
				 getSqlMapClientTemplate().getSqlMapClient().update("deleteProPlanDetail",id);	
				 
			int startDate = proPlanDetail.getStartDate().intValue();
			int endDate = proPlanDetail.getEndDate().intValue();
			
		  for(int i = startDate;i <=endDate;i++){
			  
			  Date trialTime = new Date();
				try {
					trialTime = convertStringToDate("yyyyMMdd",new Integer(i).toString());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			  
			  Calendar calendar = new GregorianCalendar();
			   calendar.setTime(trialTime);
			   int week = calendar.get(Calendar.DAY_OF_WEEK);
			  
			   String weeks = getWeekConvert(week);
					for(Iterator it=weeksPlanList.iterator();it.hasNext();){

						Object obj1 = (Object)it.next();
						if(weeks.equals(obj1.toString())){
							ProPublishPlan  proPDetail = new ProPublishPlan();
							proPDetail.setId(id);
							proPDetail.setStartDate(new Integer(i));
							getSqlMapClientTemplate().getSqlMapClient().insert("addProPlanDetail", proPDetail);
						}
						
					}
			}	
		  
			getSqlMapClientTemplate().getSqlMapClient().executeBatch();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
        
        
        
    }

public void saveProPublishPlanDetail(ProPublishPlanDetail proPlanDetail) {

	List ls=getProPublishPlanDetail(proPlanDetail.getPublishPlanId().toString());
	List proLs=new ArrayList();
	for(Iterator it=ls.iterator();it.hasNext();){
		ProPublishPlanDetail pubDetail=(ProPublishPlanDetail)it.next();
		proLs.add(pubDetail.getPlanDate());
	}
		try {
			//getSqlMapClientTemplate().getSqlMapClient().startBatch();		
			String [] times = proPlanDetail.getTimes();
			
		  for(int i = 1;i <=31;i++){

			  ProPublishPlanDetail plan=new ProPublishPlanDetail();		  
			 // if(!times[i-1].equals("")){

				  plan.setDayTimes(new Integer(times[i-1]));
				  plan.setPublishPlanId(proPlanDetail.getPublishPlanId());
				  if(i<10){

					  plan.setPlanDate(new Integer(proPlanDetail.getPlanDate()+"0"+i));
				  }else{
					  plan.setPlanDate(new Integer(proPlanDetail.getPlanDate()+""+i));
				  }
				  boolean isExsit=proLs.contains(plan.getPlanDate());
					if(ls.size()==0&&plan.getDayTimes().intValue()!=0){
						 getSqlMapClientTemplate().insert("addPublishPlanDetail", plan);
					}else if(!isExsit&&plan.getDayTimes().intValue()!=0) {

						 getSqlMapClientTemplate().insert("addPublishPlanDetail", plan);
					}else if(isExsit&&plan.getDayTimes().intValue()!=0){		
						 getSqlMapClientTemplate().update("updatePublishPlanDetail", plan);	 
					}else if(isExsit&&plan.getDayTimes().intValue()==0){
						 getSqlMapClientTemplate().update("deletePublishPlanDetail", plan);
					}else{continue;}
				 
			 // }
			
					}
			
			//getSqlMapClientTemplate().getSqlMapClient().executeBatch();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    } 

    /**
     * @see com.vriche.adrm.dao.ProPublishPlanDao#removeProPublishPlan(Long id)
     */
    public void removeProPublishPlan(Long id) {
    	getSqlMapClientTemplate().update("deleteProPlanDetail", id);
        getSqlMapClientTemplate().update("deleteProPublishPlan", id);
    }
    /**
     * @see com.vriche.adrm.dao.ProPublishPlanDAO#removeProPublishPlans(String ids)
     */
    public void removeProPublishPlans(final Map idList) {
        getSqlMapClientTemplate().update("deleteProPublishPlans", idList);
    }
	public List getProPublishPlanDetail(String id) {
		return getSqlMapClientTemplate().queryForList("getProPublishPlanDetail", id);
	}
	public List getProPublishPlanDetails(String id) {
		return getSqlMapClientTemplate().queryForList("getProPublishPlanDetails", id);
	}
	public void removeProPublishPlanDetail(final Long id) {
		getSqlMapClientTemplate().update("deleteProPlanDetail",id);
		
	}
}
