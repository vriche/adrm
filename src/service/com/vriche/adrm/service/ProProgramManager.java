
package com.vriche.adrm.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.service.Manager;
import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.ProCustomer;
import com.vriche.adrm.model.ProProgram;
import com.vriche.adrm.model.ProProgramDetail;
import com.vriche.adrm.dao.ProProgramDao;

public interface ProProgramManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setProProgramDao(ProProgramDao proProgramDAO);

    /**
     * Retrieves all of the proPrograms
     */
    public List getProPrograms(ProProgram proProgram);
    
    public String getProgramNameByOrderXML(ProProgram proProgram);
    
    /**
     * Retrieves all of the getProProgramsAll
     */
    public List getProProgramsAll(final ProProgram proProgram);
    
    /**
     * Retrieves all of the getProCustomerXML
     */
    public ProCustomer getProCustomerXML(final String id);
    /**
     * Retrieves all of the getProProgramId
     */
    public ProProgram getProProgramId(final ProProgram proProgram);
     /**
     * Retrieves all of the proProgramsCount
     */
    public String getProProgramsCount(ProProgram proProgram);
    /**
     * Retrieves all of the proProgramsCount
     */
    public String getProProgramsCountByName(ProProgram proProgram,String dateType);
     /**
     * Retrieves all of the proProgramsCount
     */    
    public List getProProgramsPage(ProProgram proProgram,String pageIndex,String pageSize);
     /**
     * Retrieves all of the proProgramsPageXML
     */   
    public String getProProgramsPageXML(ProProgram proProgram,String pageIndex,String pageSize);
     /**
     * Retrieves all of the proProgramsByMap
     */
    public List getProProgramsByMap(final Map mp);
    /**
     * Retrieves all of the getProgramNameXML
     */   
    public String getProgramNameXML(ProProgram proProgram);
    
    /**
     * Retrieves all of the getCopyrightNumXML
     */   
    public String getCopyrightNumXML(ProProgram proProgram);
    
    public String getProgramByCustomerXML(String customerName);
    /**
     * Retrieves all of the getProgramsPageXML
     */   
    public String getProgramsPageXML(final ProProgram proProgram,String dateType,String pageIndex, String pageSize);

    /**
     * Gets proProgram's information based on id.
     * @param id the proProgram's id
     * @return proProgram populated proProgram object
     */
    public ProProgram getProProgram(final String id);

    /**
     * Saves a proProgram's information
     * @param proProgram the object to be saved
     */
    public String saveProProgram(ProProgram proProgram);
    
    public void saveProProgramStatus(ProProgram proProgram);
    /**
     * Saves a proProgram's information
     * @param proProgram the object to be saved
     */
//    public String saveProProgramByName(ProProgram proProgram,String customername);
    public String saveProProgramByName(ProProgram proProgram,String customername,String customerTypeId);

    /**
     * Removes a proProgram from the database by id
     * @param id the proProgram's id
     */
    public void removeProProgram(final String id);
     /**
     * Removes a proProgram from the database by id
     * @param idList
     */
    public void removeProPrograms(final Map mp);
    
    public void removeProgramDetail(final Long id);
    
    public void saveProProgramDetail(ProProgramDetail proProgramDetail);
    
    public String getProgramDetailXML(ProProgramDetail proProgramDetail);
    
    public ProProgramDetail getProgramDetail(ProProgramDetail proProgramDetail);
    
    public Map getProProgramAllFromMap(ProProgram proProgram, boolean enable,boolean needZeroId);
    
    public Collection getCollections(final String queryString,String type);
    
    public FusionChartObject[] getProProgramChartObjs(String queryString);
}

