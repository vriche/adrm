
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.OaAreaPc;
import com.vriche.adrm.dao.OaAreaPcDao;

public interface OaAreaPcManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setOaAreaPcDao(OaAreaPcDao oaAreaPcDAO);

    /**
     * Retrieves all of the oaAreaPcs
     */
    public List getOaAreaPcs(OaAreaPc oaAreaPc);
     /**
     * Retrieves all of the oaAreaPcsCount
     */
    public String getOaAreaPcsCount(OaAreaPc oaAreaPc);
     /**
     * Retrieves all of the oaAreaPcsCount
     */    
    public PaginatedList getOaAreaPcsPage(OaAreaPc oaAreaPc,String pageIndex,String pageSize);
     /**
     * Retrieves all of the oaAreaPcsByIdList
     */
    public List getOaAreaPcsByIdList(final Map idList);

    /**
     * Gets oaAreaPc's information based on id.
     * @param id the oaAreaPc's id
     * @return oaAreaPc populated oaAreaPc object
     */
    public OaAreaPc getOaAreaPc(final String id);

    /**
     * Saves a oaAreaPc's information
     * @param oaAreaPc the object to be saved
     */
    public String saveOaAreaPc(OaAreaPc oaAreaPc);

    /**
     * Removes a oaAreaPc from the database by id
     * @param id the oaAreaPc's id
     */
    public void removeOaAreaPc(final String id);
     /**
     * Removes a oaAreaPc from the database by id
     * @param idList
     */
    public void removeOaAreaPcs(final Map idList);
}

