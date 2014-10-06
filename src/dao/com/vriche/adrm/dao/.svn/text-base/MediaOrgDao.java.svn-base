
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.MediaOrg;

public interface MediaOrgDao extends Dao {

    /**
     * Retrieves all of the mediaOrgs
     */
    public List getMediaOrgs(MediaOrg mediaOrg);

    /**
     * Retrieves all of the mediaOrgsByIdList
     */
    public List getMediaOrgsByIdList(final Map idList);

    /**
     * Gets mediaOrg's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the mediaOrg's id
     * @return mediaOrg populated mediaOrg object
     */
    public MediaOrg getMediaOrg(final Long id);

    /**
     * Saves a mediaOrg's information
     * @param mediaOrg the object to be saved
     */    
    public void saveMediaOrg(MediaOrg mediaOrg);

    /**
     * Removes a mediaOrg from the database by id
     * @param id the mediaOrg's id
     */
    public void removeMediaOrg(final Long id);
	/**
     * Removes mediaOrgs from the database by ids
     * @param ids the mediaOrg's id eg:"'1','2','3'"
     */
    public void removeMediaOrgs(final Map idList);
}

