
package com.vriche.adrm.service.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.PriceTypeDao;
import com.vriche.adrm.model.PriceType;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.service.PriceTypeManager;
import com.vriche.adrm.service.impl.BaseManager;

public class PriceTypeManagerImpl extends BaseManager implements PriceTypeManager {
    private PriceTypeDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setPriceTypeDao(PriceTypeDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.adres.service.PriceTypeManager#getPriceTypesByIdList(final Map idList)
     */
    public List getPriceTypesByIdList(final Map idList) {
        return dao.getPriceTypesByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.adres.service.PriceTypeManager#getPriceTypes(com.vriche.adrm.adres.model.PriceType)
     */
    public List getPriceTypes(final PriceType priceType) {
        return dao.getPriceTypes(priceType);
    }

    /**
     * @see com.vriche.adrm.adres.service.PriceTypeManager#getPriceType(String id)
     */
    public PriceType getPriceType(final String id) {
        return dao.getPriceType(new Long(id));
    }

    /**
     * @see com.vriche.adrm.adres.service.PriceTypeManager#savePriceType(PriceType priceType)
     */
    public void savePriceType(PriceType priceType) {
        dao.savePriceType(priceType);
    }

    /**
     * @see com.vriche.adrm.adres.service.PriceTypeManager#removePriceType(String id)
     */
    public void removePriceType(final String id) {
        dao.removePriceType(new Long(id));
    }

     /**
     * @see com.vriche.adrm.adres.service.PriceTypeManager#removePriceTypes(String Map)
     */
    public void removePriceTypes(final Map idList) {
        dao.removePriceTypes(idList);
    }

	public Map getPriceTypeSelect(PriceType priceType) {
		List ls = this.getPriceTypes(priceType);
		
	    Map reply = new LinkedHashMap();
	    Iterator it = ls.iterator();
	    
	    while(it.hasNext()){
	    	PriceType priceTypes = (PriceType) it.next();
	    	String value = priceTypes.getValue();
//	    	reply.put("0","");
			if(!"0".equals(value)){
				reply.put(priceTypes.getId(),priceTypes.getPriceTypeName()+"||"+value);
			}
	    }
		return reply;
	}

	public Map getPriceTypeSelectFromMap(PriceType priceType) {
		// TODO Auto-generated method stub
		List priceTypeList = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_PRICETYPE);
		Iterator it = priceTypeList.iterator();
		Map reply = new LinkedHashMap();
//		reply.put("0","");
		while(it.hasNext()){
			PriceType priTypes = (PriceType) it.next();
			String value = priTypes.getValue();
			if(!"0".equals(value)){
				reply.put(priTypes.getId(),priTypes.getPriceTypeName()+"||"+value);
			}

		}
		return reply;
	}  
	
	
	public List getPriceTypeSelectFromMap2(PriceType priceType) {
		// TODO Auto-generated method stub
		List priceTypeList = (List)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_PRICETYPE);

		return priceTypeList;
	}
}
