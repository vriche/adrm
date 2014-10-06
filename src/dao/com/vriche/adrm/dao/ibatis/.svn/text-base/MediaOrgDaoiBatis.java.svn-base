
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.MediaOrgDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.MediaOrg;

import org.springframework.orm.ObjectRetrievalFailureException;

public class MediaOrgDaoiBatis extends BaseDaoiBATIS implements MediaOrgDao {

    /**
     * @see com.vriche.adrm.adres.dao.MediaOrgDao#getMediaOrgs(com.vriche.adrm.adres.model.MediaOrg)
     */
    public List getMediaOrgs(final MediaOrg mediaOrg) {
          return getSqlMapClientTemplate().queryForList("getMediaOrgs", mediaOrg);
    }
    /**
     * @see com.vriche.adrm.adres.dao.MediaOrgDao#getMediaOrgsByIdList(com.vriche.adrm.adres.model.MediaOrg)
     */
    public List getMediaOrgsByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getMediaOrgsByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.adres.dao.MediaOrgDao#getMediaOrg(Long id)
     */
    public MediaOrg getMediaOrg(Long id) {
        MediaOrg mediaOrg = (MediaOrg) getSqlMapClientTemplate().queryForObject("getMediaOrg", id);

        if (mediaOrg == null) {
            throw new ObjectRetrievalFailureException(MediaOrg.class, id);
        }

        return mediaOrg;
    }

    /**
     * @see com.vriche.adrm.adres.dao.MediaOrgDao#saveMediaOrg(MediaOrg mediaOrg)
     */    
    public void saveMediaOrg(final MediaOrg mediaOrg) {
        Long id = mediaOrg.getId();
        // check for new record
        if (id == null) {
            id = (Long) getSqlMapClientTemplate().insert("addMediaOrg", mediaOrg);
        } else {
            getSqlMapClientTemplate().update("updateMediaOrg", mediaOrg);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(MediaOrg.class, id);
        }
    }

    /**
     * @see com.vriche.adrm.adres.dao.MediaOrgDao#removeMediaOrg(Long id)
     */
    public void removeMediaOrg(Long id) {
        getSqlMapClientTemplate().update("deleteMediaOrg", id);
    }
    /**
     * @see com.vriche.adrm.adres.dao.MediaOrgDAO#removeMediaOrgs(String ids)
     */
    public void removeMediaOrgs(final Map idList) {
        getSqlMapClientTemplate().update("deleteMediaOrgs", idList);
    }    
}
