
package com.vriche.adrm.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.ProOrder;
import com.vriche.adrm.dao.ProOrderDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ProOrderDaoiBatis extends BaseDaoiBATIS implements ProOrderDao {

    /**
     * @see com.vriche.adrm.dao.ProOrderDao#getProOrders(com.vriche.adrm.model.ProOrder)
     */
    public List getProOrders(final ProOrder proOrder) {
          return getSqlMapClientTemplate().queryForList("getProOrders", proOrder);
    }
     /**
     * @see com.vriche.adrm.dao.ProOrderDao#getProOrdersCount(com.vriche.adrm.model.ProOrder)
     */
    public Integer getProOrdersCount(final ProOrder proOrder) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getProOrdersCount", proOrder);
    }
    
    public Integer getProOrdersCountByName(final ProOrder proOrder) {
        return (Integer)getSqlMapClientTemplate().queryForObject("getProOrdersCountByName", proOrder);
  }
    public Integer getProOrdersCountBySellName(final ProOrder proOrder) {
        return (Integer)getSqlMapClientTemplate().queryForObject("getProOrdersCountBySellName", proOrder);
  }
    
	public Integer getProCountByObject(ProOrder proOrder) {
		 return (Integer)getSqlMapClientTemplate().queryForObject("getProCountByObject", proOrder);
	}  
	
	public Integer getProPayCountByObject(ProOrder proOrder) {
		 return (Integer)getSqlMapClientTemplate().queryForObject("getProPayCountByObject", proOrder);
	} 
     /**
     * @see com.vriche.adrm.dao.ProOrderDao#getProOrdersPage(com.vriche.adrm.model.ProOrder)
     */   
  	public List getProOrdersPage(final ProOrder proOrder,int pageIndex, int pageSize) {
		 int skip = pageIndex * pageSize;
		 return getSqlMapClientTemplate().queryForList("getProOrdersByObject",proOrder,skip,pageSize);
	} 
    /**
     * @see com.vriche.adrm.dao.ProOrderDao#getProOrdersSellPage(com.vriche.adrm.model.ProOrder)
     */   
  	public List getProOrdersSellPage(final ProOrder proOrder,int pageIndex, int pageSize) {
		 int skip = pageIndex * pageSize;
		 return getSqlMapClientTemplate().queryForList("getProOrdersBySellObject",proOrder,skip,pageSize);
	}
  	 /**
     * @see com.vriche.adrm.dao.ProOrderDao#getProOrdersC(com.vriche.adrm.model.ProOrder)
     */   
  	public List getProOrdersC(final ProOrder proOrder) {
		 return getSqlMapClientTemplate().queryForList("getProOrdersByObject",proOrder);
	}
  	/**
     * @see com.vriche.adrm.dao.ProOrderDao#getProOrdersC(com.vriche.adrm.model.ProOrder)
     */   
  	public List getProOrdersX(final ProOrder proOrder) {
		 return getSqlMapClientTemplate().queryForList("getProOrdersBySellObject",proOrder);
	}
    /**
     * @see com.vriche.adrm.dao.ProOrderDao#getProOrdersByIdList(com.vriche.adrm.model.ProOrder)
     */
    public List getProOrdersByMap(final Map mp) {
          return getSqlMapClientTemplate().queryForList("getProOrdersByIdList", mp);
    }

    /**
     * @see com.vriche.adrm.dao.ProOrderDao#getProOrder(Long id)
     */
    public ProOrder getProOrder(Long id) {
        ProOrder proOrder = (ProOrder) getSqlMapClientTemplate().queryForObject("getProOrder", id);

        if (proOrder == null) {
            throw new ObjectRetrievalFailureException(ProOrder.class, id);
        }

        return proOrder;
    }

    /**
     * @see com.vriche.adrm.dao.ProOrderDao#saveProOrder(ProOrder proOrder)
     */    
    public Long saveProOrder(final ProOrder proOrder) {
        Long id = proOrder.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addProOrder", proOrder);
        } else {
            getSqlMapClientTemplate().update("updateProOrder", proOrder);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ProOrder.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.ProOrderDao#removeProOrder(Long id)
     */
    public void removeProOrder(Long id) {
        getSqlMapClientTemplate().update("deleteProOrder", id);
    }
    /**
     * @see com.vriche.adrm.dao.ProOrderDAO#removeProOrders(String ids)
     */
    public void removeProOrders(final Map idList) {
        getSqlMapClientTemplate().update("deleteProOrders", idList);
    }
    
    public List getProOrderByObject(final ProOrder proOrder) {
    	return  getSqlMapClientTemplate().queryForList("getProOrdersByObject",proOrder);
	}
	public void saveProIncomePulls(ProOrder[] proOrders) {
		try {
			
		  for(int i = 0;i < proOrders.length;i++){
			  ProOrder  proOrder = proOrders[i];
			
			  		Long id = proOrder.getId();
			  		Double paidMoney = proOrder.getPaidMoney()==null?new Double(0):proOrder.getPaidMoney(); 
			  		Integer paidDate = proOrder.getPaidDate()==null?new Integer(0):proOrder.getPaidDate(); 
			  		
			  		ProOrder  pOrder = new ProOrder();
			  		pOrder.setId(id);
			  		pOrder.setPaidMoney(paidMoney);
			  		pOrder.setPaidDate(paidDate);
			  		
					getSqlMapClientTemplate().update("updateProIncomePull",pOrder);
			}	
		  
			getSqlMapClientTemplate().getSqlMapClient().executeBatch();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
