
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.OaAreaPc;

public interface OaAreaPcDao extends Dao {

    /**
     * Retrieves all of the oaAreaPcs
     */
    public List getOaAreaPcs(OaAreaPc oaAreaPc);
    /**
     * Retrieves all of the getOaAreaPcsCount
     */
    public Integer getOaAreaPcsCount(OaAreaPc oaAreaPc);   
    /**
     * Retrieves all of the getOaAreaPcsPage
     */        
    public PaginatedList getOaAreaPcsPage(OaAreaPc oaAreaPc,int pageIndex,int pageSize);
    /**
     * Retrieves all of the oaAreaPcsByIdList
     */
    public List getOaAreaPcsByIdList(final Map idList);

    /**
     * Gets oaAreaPc's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the oaAreaPc's id
     * @return oaAreaPc populated oaAreaPc object
     */
    public OaAreaPc getOaAreaPc(final Long id);

    /**
     * Saves a oaAreaPc's information
     * @param oaAreaPc the object to be saved
     */    
    public Long saveOaAreaPc(OaAreaPc oaAreaPc);

    /**
     * Removes a oaAreaPc from the database by id
     * @param id the oaAreaPc's id
     */
    public void removeOaAreaPc(final Long id);
	/**
     * Removes oaAreaPcs from the database by ids
     * @param ids the oaAreaPc's id eg:"'1','2','3'"
     */
    public void removeOaAreaPcs(final Map idList);
}

