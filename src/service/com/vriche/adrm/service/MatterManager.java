
package com.vriche.adrm.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.MatterDao;
import com.vriche.adrm.model.Matter;
import com.vriche.adrm.model.OrderDetail;

public interface MatterManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setMatterDao(MatterDao matterDAO);

    /**
     * Retrieves all of the matters
     */
    public List getMatters(Matter matter);
    
    
    public List getMattersByOrderId(final Matter matter);
    
    public List getMattersByCustomerIdAndLength(final Matter matter);
    
    public Matter getMatterByTapCode(Matter matter) ;
    public Matter getCheckMatter(Matter matter);
    
    public PaginatedList getMattersPage(Matter matter,String pageIndex,String pageSize);
    
    public String getMattersCount(Matter matter);
    
    public String getMattersSerachCount(String orgId,String customerName,String edit,String matterName,Integer matterType) ;
    
    public List getMattersSerachPage(String orgId,String customerName,String edit,String matterName,Integer matterType, String pageIndex, String pageSize);
    
    public String getMattersCountByDate(String beginDate,String startOrend) ;
    
    public PaginatedList getMattersByDate(String beginDate,String startOrend,String pageIndex,String pageSize) ;
        /**
     * Retrieves all of the mattersByIdList
     */
    public List getMattersByIdList(final Map idList);

    /**
     * Gets matter's information based on id.
     * @param id the matter's id
     * @return matter populated matter object
     */
    public Matter getMatter(final String id);
    
    public Matter getMatter(Matter matter);

    public Matter getMatterByObj(Matter matter);
    /**
     * Saves a matter's information
     * @param matter the object to be saved
     */
    public String saveMatter(Matter matter);
    
    public String saveMatterForm(Matter matter) ;
    
    public Matter saveMatter(Long customerId,String tapeCode,String name,String version,String length,Long createBy,Integer type,String meno,boolean enable,Long industryType,Long brandId,Integer pos);

    public Matter saveMatter3(Matter matter);
    
    public Matter saveMatterTest(OrderDetail orderDetail);       
    /**
     * Removes a matter from the database by id
     * @param id the matter's id
     */
    public void removeMatter(final String id);
     /**
     * Removes a matter from the database by id
     * @param idList
     */
    public void removeMatters(final Map idList);
    
    public String getMatterXML(Matter matter,String IdPrefix);
    
    public List getAllMatters(Matter matter);
    
    public void getMattersByAdvMatterType(Integer advType,StringBuffer sb,String IdPrefix);
    
    public List getMattersDIV(Matter matter);
    
    public String getMatterNameXML(Matter matter);
    
    public Collection getMatterReport(Matter matter);
    
    public String getMattersListXML(Matter matter);
    
    public Map getMatterName(Matter matter);
    
    public Map getMatterEditOrLength(Matter matter);
    
    public String saveMatter2(Matter matter);
    public Map getStoreMatterLengthByName(Matter matter);
    
    public List getMatterNamesStore(Matter matter);

    public List getMattersNews(final String strQueryString);
    public String getMattersNewsPageXML(String strQueryString);
    
//    public String saveMatter2Dayang(Matter matter,int importOption) ;
    
//    public void saveMattersAll2dayang();
    
    public void saveMattersAll2dayang2(Matter mtParam,String url_address);
     
    public void saveMattersAllindayang2zero();
    
    public void saveMattersAll2dayang2_test(String total,String ansy);
    
    
   
}

