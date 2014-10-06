
package com.vriche.adrm.dao.ibatis;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.FinanceTarget;
import com.vriche.adrm.dao.FinanceTargetDao;
import org.springframework.orm.ObjectRetrievalFailureException;

public class FinanceTargetDaoiBatis extends BaseDaoiBATIS implements FinanceTargetDao {

    /**
     * @see com.vriche.adrm.dao.FinanceTargetDao#getFinanceTargets(com.vriche.adrm.model.FinanceTarget)
     */
    public List getFinanceTargets(final FinanceTarget financeTarget) {
          return getSqlMapClientTemplate().queryForList("getFinanceTargets", financeTarget);
    }
     /**
     * @see com.vriche.adrm.dao.FinanceTargetDao#getFinanceTargetsCount(com.vriche.adrm.model.FinanceTarget)
     */
    public Integer getFinanceTargetsCount(final FinanceTarget financeTarget) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getFinanceTargetsCount", financeTarget);
    }
     /**
     * @see com.vriche.adrm.dao.FinanceTargetDao#getFinanceTargetsPage(com.vriche.adrm.model.FinanceTarget)
     */   
  	public List getFinanceTargetsPage(final FinanceTarget financeTarget,int pageIndex, int pageSize) {
		 int skip = pageIndex * pageSize;
		 return getSqlMapClientTemplate().queryForList("getFinanceTargets",financeTarget,skip,pageSize);
	}  
    /**
     * @see com.vriche.adrm.dao.FinanceTargetDao#getFinanceTargetsByIdList(com.vriche.adrm.model.FinanceTarget)
     */
    public List getFinanceTargetsByMap(Map mp) {
          return getSqlMapClientTemplate().queryForList("getFinanceTargetsByIdList", mp);
    }
    
    public List getCarrierTargetsByMap(Map mp) {
        return getSqlMapClientTemplate().queryForList("getCarrierTargetsByMap", mp);
    }
    
    
    public List getYearTargetsAnalyze(final Map mp) {
    	 return getSqlMapClientTemplate().queryForList("getYearTargetsAnalyze", mp);
    }	
    public List getYearRelPutAnalyze(final Map mp) {
    	return getSqlMapClientTemplate().queryForList("getYearRelPutAnalyze", mp);
   }
   public List getYearRelTimeAnalyze(final Map mp) {
   	return getSqlMapClientTemplate().queryForList("getYearRelTimeAnalyze", mp);
  }
    public List getYearRelIcomeAnalyze(final Map mp) {
    	return getSqlMapClientTemplate().queryForList("getYearRelIcomeAnalyze", mp);
   }
    
    public List getCustomerYearRelPutAnalyze(final Map mp) {
      	return getSqlMapClientTemplate().queryForList("getCustomerYearRelPutAnalyze", mp);
     }
     public List getCustomerYearRelTimeAnalyze(final Map mp) {
     	return getSqlMapClientTemplate().queryForList("getCustomerYearRelTimeAnalyze", mp);
    }
      public List getCustomerYearRelIcomeAnalyze(final Map mp) {
      	return getSqlMapClientTemplate().queryForList("getCustomerYearRelIcomeAnalyze", mp);
     }
    /**
     * @see com.vriche.adrm.dao.FinanceTargetDao#getFinanceTarget(Long id)
     */
    public FinanceTarget getFinanceTarget(Long id) {
        FinanceTarget financeTarget = (FinanceTarget) getSqlMapClientTemplate().queryForObject("getFinanceTarget", id);

        if (financeTarget == null) {
            throw new ObjectRetrievalFailureException(FinanceTarget.class, id);
        }

        return financeTarget;
    }

    /**
     * @see com.vriche.adrm.dao.FinanceTargetDao#saveFinanceTarget(FinanceTarget financeTarget)
     */    
    public Long saveFinanceTarget(final FinanceTarget financeTarget) {
        Long id = financeTarget.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addFinanceTarget", financeTarget);
        } else {
            getSqlMapClientTemplate().update("updateFinanceTarget", financeTarget);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(FinanceTarget.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.FinanceTargetDao#removeFinanceTarget(Long id)
     */
    public void removeFinanceTarget(Long id) {
        getSqlMapClientTemplate().update("deleteFinanceTarget", id);
    }
    
    public void removeFinanceTarget(FinanceTarget financeTarget){
    	getSqlMapClientTemplate().update("deleteFinanceTarget", financeTarget);
    }
    /**
     * @see com.vriche.adrm.dao.FinanceTargetDAO#removeFinanceTargets(String ids)
     */
    public void removeFinanceTargets(final Map idList) {
        getSqlMapClientTemplate().update("deleteFinanceTargets", idList);
    }    
    
public void saveFinanceTargetInfos(FinanceTarget[] financeTargets,List carrierIdList) {
		
		try {
			getSqlMapClientTemplate().getSqlMapClient().startBatch();
			
//			  for(int i = 0;i < financeTargets.length;i++){
//				  FinanceTarget  financeTarget = financeTargets[i];
//				  FinanceTarget  target = new FinanceTarget();
//				  
//					 target.setTargetDateYear(financeTarget.getTargetDateYear());
//					 target.setCarrierId(financeTarget.getCarrierId());
//					 target.setCarrierIdList(carrierIdList);
//					 getSqlMapClientTemplate().getSqlMapClient().update("deleteFinanceTarget",target);	
//			  }
			
			 if(financeTargets.length > 0){
				 FinanceTarget  target = new FinanceTarget();
				 Integer targetDateYear = financeTargets[0].getTargetDateYear();
				 target.setTargetDateYear(targetDateYear);
			  	 target.setCarrierIdList(carrierIdList);
				 getSqlMapClientTemplate().getSqlMapClient().update("deleteFinanceTarget",target);	
			 }
			
		  for(int i = 0;i < financeTargets.length;i++){
			  FinanceTarget  financeTarget = financeTargets[i];
			
			
					Long carrierId = financeTarget.getCarrierId();
					Integer targetDateYear = financeTarget.getTargetDateYear();
					String [] targetMoney = financeTarget.getTarMonths();
					for(int j = 0;j < 12;j++){
						
						  FinanceTarget  fTarget = new FinanceTarget();
						  
						if(!targetMoney[j].equals("0")){
							fTarget.setCarrierId(carrierId);
							fTarget.setTargetDateYear(targetDateYear);
							fTarget.setTargetDateMonth(new Integer(j+1));
							fTarget.setTargetMoney(new Double(targetMoney[j]));
							getSqlMapClientTemplate().getSqlMapClient().insert("addFinanceTarget", fTarget);
						}
						
					}
			}	
		  
			getSqlMapClientTemplate().getSqlMapClient().executeBatch();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
public List getFinanceTargetYear(FinanceTarget financeTarget) {
	
	 return getSqlMapClientTemplate().queryForList("getFinanceTargetYear", financeTarget);
  }

public List getCustomerYear(FinanceTarget financeTarget) {
	
	 return getSqlMapClientTemplate().queryForList("getCustomerYear", financeTarget);
 }

public List getCarrierTargetList(final Map idList){
	
	return getSqlMapClientTemplate().queryForList("getCarrierTargets", idList);
  }


public List  getArrearsList(Map mp){
	return getSqlMapClientTemplate().queryForList("getArrearsList", mp);
}

public Map getChannelTarget(Map mp) {
	// TODO Auto-generated method stub
	return getSqlMapClientTemplate().queryForMap("getChannelTarget", mp,"id");
}
public Map getChannelIncome(Map mp) {
	// TODO Auto-generated method stub
	return getSqlMapClientTemplate().queryForMap("getChannelIncome", mp,"id");
}
public Map getChannelRealPay(Map mp) {
	// TODO Auto-generated method stub
	return getSqlMapClientTemplate().queryForMap("getChannelRealPay", mp,"id");
}
public Map getChannelRealPuton(Map mp) {
	// TODO Auto-generated method stub
	return getSqlMapClientTemplate().queryForMap("getChannelRealPuton", mp,"id");
}
public Map getChannelOrderRealPay(Map mp) {
	// TODO Auto-generated method stub
	return getSqlMapClientTemplate().queryForMap("getChannelOrderRealPay", mp,"id");
}
public Map getChannelOrderRealPuton(Map mp) {
	// TODO Auto-generated method stub
	return getSqlMapClientTemplate().queryForMap("getChannelOrderRealPuton", mp,"id");
}


}
