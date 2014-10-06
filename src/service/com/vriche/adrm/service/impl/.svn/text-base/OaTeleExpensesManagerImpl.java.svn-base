
package com.vriche.adrm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.model.OaTeleExpenses;
import com.vriche.adrm.dao.OaTeleExpensesDao;
import com.vriche.adrm.service.OaTeleExpensesManager;

public class OaTeleExpensesManagerImpl extends BaseManager implements OaTeleExpensesManager {
    private OaTeleExpensesDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setOaTeleExpensesDao(OaTeleExpensesDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.OaTeleExpensesManager#getOaTeleExpensess(com.vriche.adrm.model.OaTeleExpenses)
     */
    public List getOaTeleExpensess(final OaTeleExpenses oaTeleExpenses) {
        return dao.getOaTeleExpensess(oaTeleExpenses);
    }
   /**
     * @see com.vriche.adrm.service.OaTeleExpensesManager#getOaTeleExpensessCount(com.vriche.adrm.model.OaTeleExpenses)
     */
    public String getOaTeleExpensessCount(final OaTeleExpenses oaTeleExpenses) {
        return dao.getOaTeleExpensessCount(oaTeleExpenses).toString();
    }    

   /**
     * @see com.vriche.adrm.service.OaTeleExpensesManager#getOaTeleExpensessCount(com.vriche.adrm.model.OaTeleExpenses)
     */    
	public PaginatedList getOaTeleExpensessPage(final OaTeleExpenses oaTeleExpenses,String pageIndex, String pageSize) {
		return dao.getOaTeleExpensessPage(oaTeleExpenses,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    

    /**
     * @see com.vriche.adrm.service.OaTeleExpensesManager#getOaTeleExpenses(String id)
     */
    public OaTeleExpenses getOaTeleExpenses(final String id) {
        return dao.getOaTeleExpenses(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.OaTeleExpensesManager#getOaTeleExpensessByIdList(final Map idList)
     */
    public List getOaTeleExpensessByIdList(final Map idList) {
        return dao.getOaTeleExpensessByIdList(idList);
    }    

    /**
     * @see com.vriche.adrm.service.OaTeleExpensesManager#saveOaTeleExpenses(OaTeleExpenses oaTeleExpenses)
     */
    public String saveOaTeleExpenses(OaTeleExpenses oaTeleExpenses) {
        return dao.saveOaTeleExpenses(oaTeleExpenses).toString();
    }

    /**
     * @see com.vriche.adrm.service.OaTeleExpensesManager#removeOaTeleExpenses(String id)
     */
    public void removeOaTeleExpenses(final String id) {
        dao.removeOaTeleExpenses(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.OaTeleExpensesManager#removeOaTeleExpensess(String Map)
     */
    public void removeOaTeleExpensess(final Map idList) {
        dao.removeOaTeleExpensess(idList);
    }
	public PaginatedList getOaTeleExpensesByBeginAndEndDate(String beginDate,String endDate,String pageIndex,String pageSize){
		
		Map mp = new HashMap();

		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);
		
		
		return dao.getOaTeleExpensesByBeginAndEndDate(mp,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}
	public String getOaTeleExpensessCountByBeginAndEndDate(String beginDate, String endDate) {
		Map mp = new HashMap();

		mp.put("beginDate",beginDate);
		mp.put("endDate",endDate);
		
		return dao.getOaTeleExpensessCountByBeginAndEndDate(mp).toString();
	}    
}
