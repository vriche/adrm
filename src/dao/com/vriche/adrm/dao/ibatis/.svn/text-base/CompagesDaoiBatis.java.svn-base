
package com.vriche.adrm.dao.ibatis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.CompagesDao;
import com.vriche.adrm.dao.ibatis.BaseDaoiBATIS;
import com.vriche.adrm.model.Compages;

import org.springframework.orm.ObjectRetrievalFailureException;

public class CompagesDaoiBatis extends BaseDaoiBATIS implements CompagesDao {

    /**
     * @see com.vriche.adrm.adres.dao.CompagesDao#getCompagess(com.vriche.adrm.adres.model.Compages)
     */
    public List getCompagess(final Compages compages) {
          return getSqlMapClientTemplate().queryForList("getCompagess", compages);
    }
    /**
     * @see com.vriche.adrm.adres.dao.CompagesDao#getCompagessByIdList(com.vriche.adrm.adres.model.Compages)
     */
    public List getCompagessByIdList(final Map idList) {
          return getSqlMapClientTemplate().queryForList("getCompagessByIdList", idList);
    }

    /**
     * @see com.vriche.adrm.adres.dao.CompagesDao#getCompages(Long id)
     */
    public Compages getCompages(Long id) {
        Compages compages = (Compages) getSqlMapClientTemplate().queryForObject("getCompages", id);

        if (compages == null) {
            throw new ObjectRetrievalFailureException(Compages.class, id);
        }

        return compages;
    }

    /**
     * @see com.vriche.adrm.adres.dao.CompagesDao#saveCompages(Compages compages)
     */    
    public Long saveCompages(final Compages compages) {
        Long id = compages.getId();
        
        // check for new record
        if (id == null || id.toString().equals("0")) {
//        	System.out.println("=========================");
            id = (Long) getSqlMapClientTemplate().insert("addCompages", compages);
//            System.out.println("id-------------" + id);
        } else {
            getSqlMapClientTemplate().update("updateCompages", compages);
        }
        if( id == null ) {
            throw new ObjectRetrievalFailureException(Compages.class, id);
        }
//        System.out.println("id-------------" + id);
        
        return id;
    }

    /**
     * @see com.vriche.adrm.adres.dao.CompagesDao#removeCompages(Long id)
     */
    public void removeCompages(Long id) {
        getSqlMapClientTemplate().update("deleteCompages", id);
    }
    /**
     * @see com.vriche.adrm.order.dao.CompagesDAO#removeCompagess(String ids)
     */
    public void removeCompagess(final Map idList) {
        getSqlMapClientTemplate().update("deleteCompagess", idList);
    }
    
	public void saveCompagesAndResource(Compages compages, Long id) {
//		System.out.println("00000--00000");

		getSqlMapClientTemplate().update("deleteCompagesAndResources", id);
		
		Iterator it = compages.getResources().iterator();
//		System.out.println("it--=--" + compages.getResources());
		while (it.hasNext()) {
			Integer i = new Integer(it.next().toString());
//			System.out.println("i======--=--==" +i);
			if (i.intValue() != -1) {
				Map mp = new HashMap();
			
				mp.put("resourceId",i);
				mp.put("compagesId",id);
				
				getSqlMapClientTemplate().insert("addCompagesAndResources", mp);
			}
		}  
	}
	public void removeCompagesAndResources(final Long id) {
		getSqlMapClientTemplate().update("deleteCompagesAndResources", id);
	}
	public void removeCompagesAndPrices(Long id) {
		getSqlMapClientTemplate().update("deleteCompagesAndPrices", id);
	}
	
}
