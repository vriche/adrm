
package com.vriche.adrm.service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.PublishArrangeDao;
import com.vriche.adrm.model.CtrData;
import com.vriche.adrm.model.PublishArrange;

public interface PublishArrangeManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setPublishArrangeDao(PublishArrangeDao publishArrangeDAO);

    /**
     * Retrieves all of the publishArranges
     */
    public List getPublishArranges(PublishArrange publishArrange);
    
    public List getPublishArrangesByIdListFromHistory(PublishArrange publishArrange);

     /**
     * Retrieves all of the publishArrangesCount
     */
    public String getPublishArrangesCount(PublishArrange publishArrange);
     /**
     * Retrieves all of the publishArrangesCount
     */    
    public PaginatedList getPublishArrangesPage(PublishArrange publishArrange,String pageIndex,String pageSize);
     /**
     * Retrieves all of the publishArrangesByIdList
     */
    public List getPublishArrangesByIdList(final Map idList);

    /**
     * Gets publishArrange's information based on id.
     * @param id the publishArrange's id
     * @return publishArrange populated publishArrange object
     */
    public PublishArrange getPublishArrange(final String id);

    /**
     * Saves a publishArrange's information
     * @param publishArrange the object to be saved
     */
    public String savePublishArrange(PublishArrange publishArrange);

    /**
     * Removes a publishArrange from the database by id
     * @param id the publishArrange's id
     */
    public void removePublishArrange(final String id);
     /**
     * Removes a publishArrange from the database by id
     * @param idList
     */
    public void removePublishArranges(final Map idList);
    
    public void savePublishArrangeObjArray(PublishArrange publishArrange,PublishArrange[] publishArranges);
    
    public void removePublishArranges(PublishArrange publishArrange);
    
    public String getTreeGrid(PublishArrange publishArrange,String resIdPrefix,String adverIdPrefix,boolean rebuild,boolean isRoll,boolean onlyHistory);
    
    public Map getPublishArrangeSelect(PublishArrange publishArrange) ;
    
    public void uploadFiles(String server,String port,String user,String pass,String fileName);
    public void downloadAdvers(PublishArrange publishArrange,int type);
    
    public Collection getReportColl(PublishArrange publishArrange, boolean rebuild,boolean isRoll,boolean onlyHistory);
    	
    public Collection getPulishArrangeFormColl(PublishArrange publishArrange);
    
    public Collection getCollections(final String queryString);   
    
    public void saveAllLock(Long carrierId,Integer publishDate);
    
    public void deleteArrangeAndDetail(Long id);
    
    public List getArrangedPublish(PublishArrange publishArrange,boolean rebuild,boolean isRoll,boolean onlyHistory);
    	
    public void moveArrangeAndDetailsToBak(final Integer curDate) throws IOException;
    
    
    public String getAdversByResourceId(String resourceId,String  publishDate,String  orgId);
    
    public String getArrangedAdversByResourceId(String queryString);
    
    public void saveArrangedAdversCtrTime(CtrData[] ctrDatas,String model);
}

