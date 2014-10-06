
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.MatterType;

public interface MatterTypeDao extends Dao {

    /**
     * Retrieves all of the matterTypes
     */
    public List getMatterTypes(MatterType matterType);
    /**
     * Retrieves all of the getMatterTypesCount
     */
    public Integer getMatterTypesCount(MatterType matterType);   
    /**
     * Retrieves all of the getMatterTypesPage
     */        
    public PaginatedList getMatterTypesPage(MatterType matterType,int pageIndex,int pageSize);
    /**
     * Retrieves all of the matterTypesByIdList
     */
    public List getMatterTypesByIdList(final Map idList);

    /**
     * Gets matterType's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the matterType's id
     * @return matterType populated matterType object
     */
    public MatterType getMatterType(final Long id);

    /**
     * Saves a matterType's information
     * @param matterType the object to be saved
     */    
    public Long saveMatterType(MatterType matterType);

    /**
     * Removes a matterType from the database by id
     * @param id the matterType's id
     */
    public void removeMatterType(final Long id);
	/**
     * Removes matterTypes from the database by ids
     * @param ids the matterType's id eg:"'1','2','3'"
     */
    public void removeMatterTypes(final Map idList);
}

