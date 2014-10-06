/**
 * 
 */
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.vriche.adrm.dao.ProAnalyzeDao;
import com.vriche.adrm.model.ParamClass;

/**
 * @author vriche
 *
 */
public class ProAnalyzeDaoiBatis extends BaseDaoiBATIS implements ProAnalyzeDao {

	/**
     * @see com.vriche.adrm.dao.ProOrderDao#getProOrders(com.vriche.adrm.model.ProOrder)
     */
    public List getProOrders(final ParamClass paramClass) {
          return getSqlMapClientTemplate().queryForList("getProOrders", paramClass);
    }
     /**
     * @see com.vriche.adrm.dao.ProOrderDao#getProOrdersCount(com.vriche.adrm.model.ProOrder)
     */
    public Integer getProOrdersCount(final ParamClass paramClass) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getProOrdersCount", paramClass);
    }

    /**
     * @see com.vriche.adrm.dao.ProOrderDao#getProOrdersPage(com.vriche.adrm.model.ProOrder)
     */   
  	public List getProOrdersPage(final ParamClass paramClass,int pageIndex, int pageSize) {
		 int skip = pageIndex * pageSize;
		 return getSqlMapClientTemplate().queryForList("getProOrders",paramClass,skip,pageSize);
	}  

    /**
     * @see com.vriche.adrm.dao.ProOrderDao#getProOrder(Long id)
     */
    public ParamClass getProOrder(Long id) {
    	ParamClass paramClass = (ParamClass) getSqlMapClientTemplate().queryForObject("getProOrder", id);

        if (paramClass == null) {
            throw new ObjectRetrievalFailureException(ParamClass.class, id);
        }

        return paramClass;
    }
    
    public List getProOrderByObject(final ParamClass paramClass) {
    	return  getSqlMapClientTemplate().queryForList("getProOrdersByProgramName",paramClass);
	}
    
    //节目收视分析
	public List getProAudienceAnalyzeList(ParamClass paramClass,int pageIndex, int pageSize) {
		 int skip = pageIndex * pageSize;
		return  getSqlMapClientTemplate().queryForList("getProAudienceAnalyzeList",paramClass,skip,pageSize);
	}
	public List getProAudienceAnalyzes(ParamClass paramClass) {
		return getSqlMapClientTemplate().queryForList("getProAudienceAnalyzeList", paramClass);
	}
	//节目成本分析
	public List getProCostAnalyzeList(ParamClass paramClass, int pageIndex, int pageSize) {
		int skip = pageIndex * pageSize;
    	return  getSqlMapClientTemplate().queryForList("getProCostAnalyzeList",paramClass,skip,pageSize);
	}
	public Integer getProCostAnalyzeCount(ParamClass paramClass) {
		return (Integer)getSqlMapClientTemplate().queryForObject("getProCostAnalyzeCount", paramClass);
	}
	public List getProCostAnalyzes(ParamClass paramClass) {
		

		return getSqlMapClientTemplate().queryForList("getProCostAnalyzeList", paramClass);
	}
	//节目收入分析
	public List getResourcesIdByIdList(Map map) {
		return getSqlMapClientTemplate().queryForList("getResourcesIdByIdList", map);
	}
	public List getCarrierParentIdList(ParamClass paramClass) {
		return getSqlMapClientTemplate().queryForList("getCarrierParentIdList", paramClass);
	}
	
	public List getCarrierMemo(Map map) {
		return getSqlMapClientTemplate().queryForList("getCarrierMemo", map);
	}
	public List getProPlanDateList(ParamClass paramClass) {
		return getSqlMapClientTemplate().queryForList("getProPlanDateList", paramClass);
	}
	public List getCarrierMoney(Map map) {
		return getSqlMapClientTemplate().queryForList("getCarrierMoney", map);
	}
	
	public double getCarrierMoneyByProgramId(ParamClass  paramClass) {
		Double middleMoney=(Double)getSqlMapClientTemplate().queryForObject("getCarrierMoneyByMiddle", paramClass);
		Double upMoney=(Double)getSqlMapClientTemplate().queryForObject("getCarrierMoneyByUp", paramClass);
		Double downMoney=(Double)getSqlMapClientTemplate().queryForObject("getCarrierMoneyByDown", paramClass);
		double middle=middleMoney==null?0:middleMoney.doubleValue();
		double up=upMoney==null?0:upMoney.doubleValue();
		double down=downMoney==null?0:downMoney.doubleValue();
		return middle+up+down;
	}
	
	
	public List getProProgramNameList(ParamClass paramClass,int pageIndex, int pageSize) {
		int skip = pageIndex * pageSize;
		return getSqlMapClientTemplate().queryForList("getProProgramNameList", paramClass,skip,pageSize);
	}
	public List getProProgramNameList(ParamClass paramClass) {
		return getSqlMapClientTemplate().queryForList("getProProgramNameList", paramClass);
	}
	public Integer getProProgramNameCount(ParamClass paramClass) {
		return (Integer)getSqlMapClientTemplate().queryForObject("getProProgramNameCount", paramClass);
	}
}
