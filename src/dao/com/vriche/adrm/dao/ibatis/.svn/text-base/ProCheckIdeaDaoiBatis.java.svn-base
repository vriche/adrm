
package com.vriche.adrm.dao.ibatis;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.ProCheckIdea;
import com.vriche.adrm.dao.ProCheckIdeaDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ProCheckIdeaDaoiBatis extends BaseDaoiBATIS implements ProCheckIdeaDao {

    /**
     * @see com.vriche.adrm.dao.ProCheckIdeaDao#getProCheckIdeas(com.vriche.adrm.model.ProCheckIdea)
     */
    public List getProCheckIdeas(final ProCheckIdea proCheckIdea) {
          return getSqlMapClientTemplate().queryForList("getProCheckIdeas", proCheckIdea);
    }
     /**
     * @see com.vriche.adrm.dao.ProCheckIdeaDao#getProCheckIdeasCount(com.vriche.adrm.model.ProCheckIdea)
     */
    public Integer getProCheckIdeasCount(final ProCheckIdea proCheckIdea) {
          return (Integer)getSqlMapClientTemplate().queryForObject("getProCheckIdeasCount", proCheckIdea);
    }
     /**
     * @see com.vriche.adrm.dao.ProCheckIdeaDao#getProCheckIdeasPage(com.vriche.adrm.model.ProCheckIdea)
     */   
  	public List getProCheckIdeasPage(final ProCheckIdea proCheckIdea,int pageIndex, int pageSize) {
		 int skip = pageIndex * pageSize;
		 return getSqlMapClientTemplate().queryForList("getProCheckIdeas",proCheckIdea,skip,pageSize);
	}  
    /**
     * @see com.vriche.adrm.dao.ProCheckIdeaDao#getProCheckIdeasByIdList(com.vriche.adrm.model.ProCheckIdea)
     */
    public List getProCheckIdeasByMap(final Map mp) {
          return getSqlMapClientTemplate().queryForList("getProCheckIdeasByMap", mp);
    }

    /**
     * @see com.vriche.adrm.dao.ProCheckIdeaDao#getProCheckIdea(Long id)
     */
    public ProCheckIdea getProCheckIdea(Long id) {
        ProCheckIdea proCheckIdea = (ProCheckIdea) getSqlMapClientTemplate().queryForObject("getProCheckIdea", id);

        if (proCheckIdea == null) {
            throw new ObjectRetrievalFailureException(ProCheckIdea.class, id);
        }

        return proCheckIdea;
    }

    /**
     * @see com.vriche.adrm.dao.ProCheckIdeaDao#saveProCheckIdea(ProCheckIdea proCheckIdea)
     */    
    public Long saveProCheckIdea(final ProCheckIdea proCheckIdea) {
        Long id = proCheckIdea.getId();
        System.out.println("obj.getProgramId()<<<<<<<<11111111111111<<<<<<<<<<"+id);
        // check for new record
        if (id == null || id.toString().equals("0")) {
            id = (Long) getSqlMapClientTemplate().insert("addProCheckIdea", proCheckIdea);
        } else {
            getSqlMapClientTemplate().update("updateProCheckIdea", proCheckIdea);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(ProCheckIdea.class, id);
        }
        return  id;
    }

    /**
     * @see com.vriche.adrm.dao.ProCheckIdeaDao#removeProCheckIdea(Long id)
     */
    public void removeProCheckIdea(Long id) {
        getSqlMapClientTemplate().update("deleteProCheckIdea", id);
    }
    /**
     * @see com.vriche.adrm.dao.ProCheckIdeaDAO#removeProCheckIdeas(String ids)
     */
    public void removeProCheckIdeas(final Map idList) {
        getSqlMapClientTemplate().update("deleteProCheckIdeas", idList);
    }

}
