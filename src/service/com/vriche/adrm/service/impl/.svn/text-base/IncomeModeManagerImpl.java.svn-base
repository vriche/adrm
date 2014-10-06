
package com.vriche.adrm.service.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.IncomeModeDao;
import com.vriche.adrm.model.IncomeMode;
import com.vriche.adrm.model.Specific;
import com.vriche.adrm.service.IncomeModeManager;
import com.vriche.adrm.service.impl.BaseManager;

public class IncomeModeManagerImpl extends BaseManager implements IncomeModeManager {
    private IncomeModeDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setIncomeModeDao(IncomeModeDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.finance.service.IncomeModeManager#getIncomeModesByIdList(final Map idList)
     */
    public List getIncomeModesByIdList(final Map idList) {
        return dao.getIncomeModesByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.finance.service.IncomeModeManager#getIncomeModes(com.vriche.adrm.finance.model.IncomeMode)
     */
    public List getIncomeModes(final IncomeMode incomeMode) {
        return dao.getIncomeModes(incomeMode);
    }

    /**
     * @see com.vriche.adrm.finance.service.IncomeModeManager#getIncomeMode(String id)
     */
    public IncomeMode getIncomeMode(final String id) {
        return dao.getIncomeMode(new Long(id));
    }

    /**
     * @see com.vriche.adrm.finance.service.IncomeModeManager#saveIncomeMode(IncomeMode incomeMode)
     */
    public void saveIncomeMode(IncomeMode incomeMode) {
        dao.saveIncomeMode(incomeMode);
    }

    /**
     * @see com.vriche.adrm.finance.service.IncomeModeManager#removeIncomeMode(String id)
     */
    public void removeIncomeMode(final String id) {
        dao.removeIncomeMode(new Long(id));
    }

     /**
     * @see com.vriche.adrm.finance.service.IncomeModeManager#removeIncomeModes(String Map)
     */
    public void removeIncomeModes(final Map idList) {
        dao.removeIncomeModes(idList);
    }

	public Map getIncomeModeSelect(IncomeMode incomeMode) {
		List ls = this.getIncomeModes(incomeMode);
		
	    Map reply = new LinkedHashMap();
	    Iterator it = ls.iterator();
	    
	    while(it.hasNext()){
	    	IncomeMode incomeModes = new IncomeMode();
	    	incomeModes = (IncomeMode) it.next();
	    	
	    	reply.put("0","");
	    	reply.put(incomeModes.getId(),incomeModes.getName());
	    }
		return reply;
	}

	public Map getIncomeModeFromMap(IncomeMode incomeMode) {
		List ls = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_INCOME_MODE);
		
		Map reply = new LinkedHashMap();
		reply.put("0","==Ыљга==");
	    Iterator it = ls.iterator();
	    
	    while(it.hasNext()){
	    	IncomeMode incomeModes = new IncomeMode();
	    	incomeModes = (IncomeMode) it.next();
	    	reply.put(incomeModes.getId(),incomeModes.getName());
	    }
		return reply;
	}    
}
