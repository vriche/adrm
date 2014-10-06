
package com.vriche.adrm.service.impl;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.PriceDao;
import com.vriche.adrm.dao.PriceRegularDao;
import com.vriche.adrm.model.PriceRegular;
import com.vriche.adrm.service.PriceExistsException;
import com.vriche.adrm.service.PriceRegularManager;
import com.vriche.adrm.util.StringUtil;

public class PriceRegularManagerImpl extends BaseManager implements PriceRegularManager {
    private PriceRegularDao dao;
    private PriceDao priceDao;
    
    

    public void setPriceDao(PriceDao priceDao) {
		this.priceDao = priceDao;
	}

	/**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setPriceRegularDao(PriceRegularDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.adres.service.PriceRegularManager#getPriceRegularsByIdList(final Map idList)
     */
    public List getPriceRegularsByIdList(final Map idList) {
        return dao.getPriceRegularsByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.adres.service.PriceRegularManager#getPriceRegulars(com.vriche.adrm.adres.model.PriceRegular)
     */
    public List getPriceRegulars(final PriceRegular priceRegular) {
        return dao.getPriceRegulars(priceRegular);
    }

    /**
     * @see com.vriche.adrm.adres.service.PriceRegularManager#getPriceRegular(String id)
     */
    public PriceRegular getPriceRegular(final String id) {
    	PriceRegular priceRegular = new PriceRegular();
    	priceRegular.setId(new Long(id));
        return this.getPriceRegularByObj(priceRegular);
    }
    
    public PriceRegular getPriceRegularByObj(final PriceRegular priceRegular) {
        return dao.getPriceRegular(priceRegular);
    }
    
    public String getPriceRegularByName(final String resourceId,String priceTypeId,String priceRegularName) throws PriceExistsException{
    	PriceRegular priceRegular = new PriceRegular();
    	priceRegular.setName(priceRegularName);
    	
    	PriceRegular regular =  getPriceRegularByObj(priceRegular);
//    	System.out.println("getPriceRegularByName ------------------------------------" + regular.toString());
    	
    	Double baseLength = new Double(0);
    	Double otherLength = new Double(0);
//    	Double multiple = new Double(1);
        String rex = "(a)+b";
        String exp ="";
    	
    	if(regular != null){
    		baseLength = regular.getMultiBase();
    		otherLength = regular.getOtherBase();
//    		multiple = regular.getMultiply();
    		
    		
    		baseLength = baseLength == null?new Double(0):baseLength;
    		otherLength = otherLength == null?new Double(0):otherLength;
//    		multiple = multiple == null?new Double(1):multiple;
//    		multiple = multiple.doubleValue() == 0?new Double(1):multiple;
    		
    	
    		exp = regular.getRegularExpr();
    		exp = (exp == null||"".equals(exp))?rex:exp;
    		
    		double baseLengthInt= baseLength.doubleValue()- baseLength.intValue();
    		double otherLengthInt= otherLength.doubleValue()- otherLength.intValue();
    		String baseLengthStr ="0";
    		String otherLengthStr ="0";
    		
//      		System.out.println(">>>>>>>>>>baseLengthInt>>>>>>>>>" +baseLengthInt);
//    		System.out.println(">>>>>>>>>>otherLengthInt>>>>>>>>>" +otherLengthInt);
    		
    		baseLengthStr = baseLengthInt == 0? String.valueOf(baseLength.intValue()):String.valueOf(baseLength.doubleValue());
    		otherLengthStr = otherLengthInt == 0? String.valueOf(otherLength.intValue()):String.valueOf(otherLength.doubleValue());
    		Double bPrice = new Double(0);
    		Double oPrice = new Double(0);
    		  try {
    	    		 bPrice = priceDao.getPriceByResourceIdAndLength(new Long(resourceId),baseLengthStr,new Long(priceTypeId));
    	    		 oPrice = priceDao.getPriceByResourceIdAndLength(new Long(resourceId),otherLengthStr,new Long(priceTypeId));
    		  }catch (Exception e) {
    			  
  	            throw new PriceExistsException("读取价格出错，可能此段位的价格类别不唯一,请通知管理员检查时段维护的价格信息！");
   	       	}

    		
    		bPrice = bPrice == null?new Double(0):bPrice;
    		oPrice = oPrice == null?new Double(0):oPrice;
    		 
//    		System.out.println(">>>>>>>>>>baseLength>>>>>>>>>" +baseLength.toString());
//    		System.out.println(">>>>>>>>>>otherLength>>>>>>>>>" +otherLength.toString());
//    		
//    		System.out.println(">>>>>>>>>>bPrice>>>>>>>>>" +bPrice.doubleValue());
//    		System.out.println(">>>>>>>>>>oPrice>>>>>>>>>" +oPrice.doubleValue());
    		
    		exp =  StringUtil.oldReplace(exp, "a", String.valueOf(bPrice.doubleValue()));
//    		exp = StringUtil.oldReplace(exp, "m", String.valueOf(multiple));
    		exp = StringUtil.oldReplace(exp, "b", String.valueOf(oPrice.doubleValue()));
    	}
    	
		return exp;
    }

    /**
     * @see com.vriche.adrm.adres.service.PriceRegularManager#savePriceRegular(PriceRegular priceRegular)
     */
    public void savePriceRegular(PriceRegular priceRegular) {
        dao.savePriceRegular(priceRegular);
    }

    /**
     * @see com.vriche.adrm.adres.service.PriceRegularManager#removePriceRegular(String id)
     */
    public void removePriceRegular(final String id) {
        dao.removePriceRegular(new Long(id));
    }

     /**
     * @see com.vriche.adrm.adres.service.PriceRegularManager#removePriceRegulars(String Map)
     */
    public void removePriceRegulars(final Map idList) {
        dao.removePriceRegulars(idList);
    }    
}
