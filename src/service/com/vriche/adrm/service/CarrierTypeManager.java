
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.CarrierTypeDao;
import com.vriche.adrm.model.CarrierType;
import com.vriche.adrm.model.TreeNode;
import com.vriche.adrm.service.Manager;

public interface CarrierTypeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setCarrierTypeDao(CarrierTypeDao carrierTypeDAO);

    /**
     * Retrieves all of the carrierTypes
     */
    public List getCarrierTypes(CarrierType carrierType);
        /**
     * Retrieves all of the carrierTypesByIdList
     */
    public List getCarrierTypesByIdList(final Map idList);

    /**
     * Gets carrierType's information based on id.
     * @param id the carrierType's id
     * @return carrierType populated carrierType object
     */
    public CarrierType getCarrierType(final String id);

    /**
     * Saves a carrierType's information
     * @param carrierType the object to be saved
     */
    public String saveCarrierType(CarrierType carrierType);

    /**
     * Removes a carrierType from the database by id
     * @param id the carrierType's id
     */
    public void removeCarrierType(final String id);
     /**
     * Removes a carrierType from the database by id
     * @param idList
     */
    public void removeCarrierTypes(final Map idList);
    
    public String getCarrierTypeXML(CarrierType carrierType, String IdPrefix,String carrierIdPrefix,String resourceIdPrefix);
    
    public String getCarrierTypeXMLByYear(CarrierType carrierType, String IdPrefix,String carrierIdPrefix,String resourceIdPrefix,String year);

    public String getCarrierTypeXMLByYear2(CarrierType carrierType, String IdPrefix,String carrierIdPrefix,String resourceIdPrefix,String year);
    
    public String getCarrierTypeXMLFromMapByYear(CarrierType carrierType, String IdPrefix,String carrierIdPrefix,String resourceIdPrefix,String year);
    
    public String getCarrierTypeXMLForArrange(CarrierType carrierType, String IdPrefix,String carrierIdPrefix,String resourceIdPrefix,String publishDate);
    
    public Map getCarrierTypeSelectItem(CarrierType carrierType);
    
    public String getTreeXMLResourceAnalyze(CarrierType carrierType, String IdPrefix,String carrierIdPrefix,String resourceIdPrefix,String carrierId,String resourceTypeId);

    public String getUserCarrirXML(CarrierType carrierType, String IdPrefix,String carrierIdPrefix);
    
    public String getTreeXMLForChannel(CarrierType carrierType, String IdPrefix,String carrierIdPrefix,String resourceIdPrefix,int channelModelParam);
    
    public String getCarrierTypeXMLFromMapByYear2(CarrierType carrierType, String IdPrefix,String carrierIdPrefix,String resourceIdPrefix,String year,boolean isAccountRes);
    
    public Map getCarrierTypeByLoginUser(String loginUser,int all);
    
    public List getTreeForJosin(TreeNode node,CarrierType carrierType);
    

}

