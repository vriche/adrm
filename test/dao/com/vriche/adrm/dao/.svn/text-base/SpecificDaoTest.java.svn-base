package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.Specific;
import com.vriche.adrm.dao.SpecificDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class SpecificDaoTest extends BaseDaoTestCase {
    private Long specificId = new Long("1");
    private SpecificDao dao = null;

    public void setSpecificDao(SpecificDao dao) {
        this.dao = dao;
    }

    public void testAddSpecific() throws Exception {
        Specific specific = new Specific();

        // set required fields

        dao.saveSpecific(specific);

        // verify a primary key was assigned
        assertNotNull(specific.getId());

        // verify set fields are same after save
    }

    public void testGetSpecific() throws Exception {
        Specific specific = dao.getSpecific(specificId);
        assertNotNull(specific);
    }

    public void testGetSpecifics() throws Exception {
        Specific specific = new Specific();

        List results = dao.getSpecifics(specific);
        assertTrue(results.size() > 0);
    }

    public void testSaveSpecific() throws Exception {
        Specific specific = dao.getSpecific(specificId);

        // update required fields

        dao.saveSpecific(specific);

    }

    public void testRemoveSpecific() throws Exception {
        Long removeId = new Long("3");
        dao.removeSpecific(removeId);
        try {
            dao.getSpecific(removeId);
            fail("specific found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveSpecifics(final Map idList) throws Exception {
        try {
        	dao.removeSpecifics(idList);
            fail("specific found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
