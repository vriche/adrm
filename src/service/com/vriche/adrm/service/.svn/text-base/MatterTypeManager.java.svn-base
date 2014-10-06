
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.MatterType;
import com.vriche.adrm.model.OaWorkFlowCheckState;
import com.vriche.adrm.dao.MatterTypeDao;

public interface MatterTypeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setMatterTypeDao(MatterTypeDao matterTypeDAO);

    /**
     * Retrieves all of the matterTypes
     */
    public List getMatterTypes(MatterType matterType);
     /**
     * Retrieves all of the matterTypesCount
     */
    public String getMatterTypesCount(MatterType matterType);
     /**
     * Retrieves all of the matterTypesCount
     */    
    public PaginatedList getMatterTypesPage(MatterType matterType,String pageIndex,String pageSize);
     /**
     * Retrieves all of the matterTypesByIdList
     */
    public List getMatterTypesByIdList(final Map idList);

    /**
     * Gets matterType's information based on id.
     * @param id the matterType's id
     * @return matterType populated matterType object
     */
    public MatterType getMatterType(final String id);

    /**
     * Saves a matterType's information
     * @param matterType the object to be saved
     */
    public String saveMatterType(MatterType matterType);

    /**
     * Removes a matterType from the database by id
     * @param id the matterType's id
     */
    public void removeMatterType(final String id);
     /**
     * Removes a matterType from the database by id
     * @param idList
     */
    public void removeMatterTypes(final Map idList);
    
    public Map getMatterTypeSelect(MatterType matterType) ;
    
    public String getMatterTypeXML(MatterType matterType, String typeIdPrefix,String matterIdPrefix);
}

