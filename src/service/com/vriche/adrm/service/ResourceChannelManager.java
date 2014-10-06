
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.ResourceChannelDao;
import com.vriche.adrm.model.ResourceChannel;
import com.vriche.adrm.model.ResourceChannelConfig;

public interface ResourceChannelManager extends Manager {

    /**
     * Setter for DAO, convenient for unit testing
     */
    public void setResourceChannelDao(ResourceChannelDao resourceChannelDAO);

    /**
     * Retrieves all of the resourceChannels
     */
    public List getResourceChannels(ResourceChannel resourceChannel);
        /**
     * Retrieves all of the resourceChannelsByIdList
     */
    public List getResourceChannelsByIdList(final Map idList);

    /**
     * Gets resourceChannel's information based on id.
     * @param id the resourceChannel's id
     * @return resourceChannel populated resourceChannel object
     */
    public ResourceChannel getResourceChannel(final String id);

    /**
     * Saves a resourceChannel's information
     * @param resourceChannel the object to be saved
     */
    public void saveResourceChannel(ResourceChannel resourceChannel);
    
    public void saveChannelConfig(String channelId,ResourceChannelConfig[] channelConfigs);
    public String getResourceChannelConfigsGridXML(String channelId);
    public List getResourceChannelConfigs(String channelId);
   

    /**
     * Removes a resourceChannel from the database by id
     * @param id the resourceChannel's id
     */
    public void removeResourceChannel(final String id);
     /**
     * Removes a resourceChannel from the database by id
     * @param idList
     */
    public void removeResourceChannels(final Map idList);
    
    public Map getResourceChannelsSelectItem(ResourceChannel resourceChannel);
    
    public void removeResourceChannelConf(String id);
    
    
}

