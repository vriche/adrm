
package com.vriche.adrm.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ObjectRetrievalFailureException;

import com.vriche.adrm.dao.ResourceChannelDao;
import com.vriche.adrm.model.ResourceChannel;
import com.vriche.adrm.model.ResourceChannelConfig;

public class ResourceChannelDaoiBatis extends BaseDaoiBATIS implements ResourceChannelDao {

    /**
     * @see com.vriche.adrm.adres.dao.ResourceChannelDao#getResourceChannels(com.vriche.adrm.adres.model.ResourceChannel)
     */
    public List getResourceChannels(final ResourceChannel resourceChannel) {
          return getSqlMapClientTemplate().queryForList("getResourceChannels", resourceChannel);
    }
    /**
     * @see com.vriche.adrm.adres.dao.ResourceChannelDao#getResourceChannelsByIdList(com.vriche.adrm.adres.model.ResourceChannel)
     */
    public List getResourceChannelsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getResourceChannelsByIdList", idList);
    }
    
    public List getResourceChannelConfigs(final Map mp) {
        return getSqlMapClientTemplate().queryForList("getResourceChannelConfigs", mp);
  }
    

    /**
     * @see com.vriche.adrm.adres.dao.ResourceChannelDao#getResourceChannel(Long id)
     */
    public ResourceChannel getResourceChannel(Long id) {
        ResourceChannel resourceChannel = (ResourceChannel) getSqlMapClientTemplate().queryForObject("getResourceChannel", id);

        if (resourceChannel == null) {
            throw new ObjectRetrievalFailureException(ResourceChannel.class, id);
        }

        return resourceChannel;
    }

    /**
     * @see com.vriche.adrm.adres.dao.ResourceChannelDao#saveResourceChannel(ResourceChannel resourceChannel)
     */    
    public void saveResourceChannel(final ResourceChannel resourceChannel) {
        Long id = resourceChannel.getId();
        // check for new record
        if (id == null) {
            id = (Long) getSqlMapClientTemplate().insert("addResourceChannel", resourceChannel);
        } else {
            getSqlMapClientTemplate().update("updateResourceChannel", resourceChannel);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ResourceChannel.class, id);
        }
    }

    /**
     * @see com.vriche.adrm.adres.dao.ResourceChannelDao#removeResourceChannel(Long id)
     */
    public void removeResourceChannel(Long id) {
        getSqlMapClientTemplate().update("deleteResourceChannel", id);
    }
    /**
     * @see com.vriche.adrm.adres.dao.ResourceChannelDAO#removeResourceChannels(String ids)
     */
    public void removeResourceChannels(final Map idList) {
        getSqlMapClientTemplate().update("deleteResourceChannels", idList);
    }
    
    public void removeResourceChannelConfig(final Map mp) {

		 getSqlMapClientTemplate().update("removeResourceChannelConfig", mp);
    }
    
	public void saveChannelConfig(ResourceChannelConfig channelConfig) {
		

		 
		 Long id = (Long) getSqlMapClientTemplate().insert("addResourceChannelConfig", channelConfig);
	
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ResourceChannel.class, id);
        }
		
	}    
}
