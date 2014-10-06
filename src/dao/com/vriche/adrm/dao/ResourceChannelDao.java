
package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.model.ResourceChannel;
import com.vriche.adrm.model.ResourceChannelConfig;

public interface ResourceChannelDao extends Dao {

    /**
     * Retrieves all of the resourceChannels
     */
    public List getResourceChannels(ResourceChannel resourceChannel);

    /**
     * Retrieves all of the resourceChannelsByIdList
     */
    public List getResourceChannelsByIdList(final Map idList);

    /**
     * Gets resourceChannel's information based on primary key. An
     * ObjectRetrievalFailureException Runtime Exception is thrown if 
     * nothing is found.
     * 
     * @param id the resourceChannel's id
     * @return resourceChannel populated resourceChannel object
     */
    public ResourceChannel getResourceChannel(final Long id);

    /**
     * Saves a resourceChannel's information
     * @param resourceChannel the object to be saved
     */    
    public void saveResourceChannel(ResourceChannel resourceChannel);
    
    
    public void removeResourceChannelConfig(final Map mp);
    public void saveChannelConfig(ResourceChannelConfig channelConfig);
    public List getResourceChannelConfigs(final Map mp);
    

    /**
     * Removes a resourceChannel from the database by id
     * @param id the resourceChannel's id
     */
    public void removeResourceChannel(final Long id);
	/**
     * Removes resourceChannels from the database by ids
     * @param ids the resourceChannel's id eg:"'1','2','3'"
     */
    public void removeResourceChannels(final Map idList);
}

