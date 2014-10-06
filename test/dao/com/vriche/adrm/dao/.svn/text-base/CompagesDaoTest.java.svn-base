package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.Compages;
import com.vriche.adrm.dao.CompagesDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class CompagesDaoTest extends BaseDaoTestCase {
    private Long compagesId = new Long("1");
    private CompagesDao dao = null;

    public void setCompagesDao(CompagesDao dao) {
        this.dao = dao;
    }

    public void testAddCompages() throws Exception {
        Compages compages = new Compages();

        // set required fields

        dao.saveCompages(compages);

        // verify a primary key was assigned
        assertNotNull(compages.getId());

        // verify set fields are same after save
    }

    public void testGetCompages() throws Exception {
        Compages compages = dao.getCompages(compagesId);
        assertNotNull(compages);
    }

    public void testGetCompagess() throws Exception {
        Compages compages = new Compages();

        List results = dao.getCompagess(compages);
        assertTrue(results.size() > 0);
    }

    public void testSaveCompages() throws Exception {
        Compages compages = dao.getCompages(compagesId);

        // update required fields

        dao.saveCompages(compages);

    }

    public void testRemoveCompages() throws Exception {
        Long removeId = new Long("3");
        dao.removeCompages(removeId);
        try {
            dao.getCompages(removeId);
            fail("compages found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveCompagess(final Map idList) throws Exception {
        try {
        	dao.removeCompagess(idList);
            fail("compages found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
