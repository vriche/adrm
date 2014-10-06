
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.OaAreaCity;
import com.vriche.adrm.dao.OaAreaCityDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaAreaCityDaoiBatis extends BaseDaoiBATIS implements OaAreaCityDao {

    /**
     * @see com.vriche.adrm.dao.OaAreaCityDao#getOaAreaCitys(com.vriche.adrm.model.OaAreaCity)
     */
    public List getOaAreaCitys(final OaAreaCity oaAreaCity) {
          return getSqlMapClientTemplate().queryForList("getOaAreaCitys", oaAreaCity);
    }
     /**
     * @see com.vriche.adrm.dao.OaAreaCityDao#getOaAreaCitysCount(com.vriche.adrm.model.OaAreaCity)
     */
    public Integer getOaAreaCitysCount(final OaAreaCity oaAreaCity) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getOaAreaCitysCount", oaAreaCity);
    }
     /**
     * @see com.vriche.adrm.dao.OaAreaCityDao#getOaAreaCitysPage(com.vriche.adrm.model.OaAreaCity)
     */   
  	public PaginatedList getOaAreaCitysPage(final OaAreaCity oaAreaCity,int pageIndex, int pageSize) {
	   	 PaginatedList pageList = getSqlMapClientTemplate().queryForPaginatedList("getOaAreaCitys",oaAreaCity,pageSize);
	     pageList.gotoPage(pageIndex-1);
		 return pageList;
	}  
    /**
     * @see com.vriche.adrm.dao.OaAreaCityDao#getOaAreaCitysByIdList(com.vriche.adrm.model.OaAreaCity)
     */
    public List getOaAreaCitysByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getOaAreaCitysByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.dao.OaAreaCityDao#getOaAreaCity(Long id)
     */
    public OaAreaCity getOaAreaCity(Long id) {
        OaAreaCity oaAreaCity = (OaAreaCity) getSqlMapClientTemplate().queryForObject("getOaAreaCity", id);

        if (oaAreaCity == null) {
            throw new ObjectRetrievalFailureException(OaAreaCity.class, id);
        }

        return oaAreaCity;
    }

    /**
     * @see com.vriche.adrm.dao.OaAreaCityDao#saveOaAreaCity(OaAreaCity oaAreaCity)
     */    
    public Long saveOaAreaCity(final OaAreaCity oaAreaCity) {
        Long id = oaAreaCity.getId();
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addOaAreaCity", oaAreaCity);
        } else {
            getSqlMapClientTemplate().update("updateOaAreaCity", oaAreaCity);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(OaAreaCity.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.OaAreaCityDao#removeOaAreaCity(Long id)
     */
    public void removeOaAreaCity(Long id) {
        getSqlMapClientTemplate().update("deleteOaAreaCity", id);
    }
    /**
     * @see com.vriche.adrm.dao.OaAreaCityDAO#removeOaAreaCitys(String ids)
     */
    public void removeOaAreaCitys(final Map idList) {
        getSqlMapClientTemplate().update("deleteOaAreaCitys", idList);
    }    
}
