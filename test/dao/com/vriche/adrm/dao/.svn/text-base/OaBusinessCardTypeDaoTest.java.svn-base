package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaBusinessCardType;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaBusinessCardTypeDaoTest extends BaseDaoTestCase {
    private Long oaBusinessCardTypeId = new Long("1");
    private OaBusinessCardTypeDao dao = null;

    public void setOaBusinessCardTypeDao(OaBusinessCardTypeDao dao) {
        this.dao = dao;
    }

    public void testAddOaBusinessCardType() throws Exception {
        OaBusinessCardType oaBusinessCardType = new OaBusinessCardType();

        // set required fields

        dao.saveOaBusinessCardType(oaBusinessCardType);

        // verify a primary key was assigned
        assertNotNull(oaBusinessCardType.getId());

        // verify set fields are same after save
    }

    public void testGetOaBusinessCardType() throws Exception {
        OaBusinessCardType oaBusinessCardType = dao.getOaBusinessCardType(oaBusinessCardTypeId);
        assertNotNull(oaBusinessCardType);
    }

    public void testGetOaBusinessCardTypes() throws Exception {
        OaBusinessCardType oaBusinessCardType = new OaBusinessCardType();

        List results = dao.getOaBusinessCardTypes(oaBusinessCardType);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaBusinessCardType() throws Exception {
        OaBusinessCardType oaBusinessCardType = dao.getOaBusinessCardType(oaBusinessCardTypeId);

        // update required fields

        dao.saveOaBusinessCardType(oaBusinessCardType);

    }

    public void testRemoveOaBusinessCardType() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaBusinessCardType(removeId);
        try {
            dao.getOaBusinessCardType(removeId);
            fail("oaBusinessCardType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaBusinessCardTypes(final Map idList) throws Exception {
        try {
        	dao.removeOaBusinessCardTypes(idList);
            fail("oaBusinessCardType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
