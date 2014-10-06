package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.Workspan;
import com.vriche.adrm.dao.WorkspanDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class WorkspanDaoTest extends BaseDaoTestCase {
    private Long workspanId = new Long("21");
    private WorkspanDao dao = null;

    public void setWorkspanDao(WorkspanDao dao) {
        this.dao = dao;
    }

    public void testAddWorkspan() throws Exception {
        Workspan workspan = new Workspan();

        // set required fields

        dao.saveWorkspan(workspan);

        // verify a primary key was assigned
        assertNotNull(workspan.getId());

        // verify set fields are same after save
    }

    public void testGetWorkspan() throws Exception {
        Workspan workspan = dao.getWorkspan(workspanId);
        assertNotNull(workspan);
    }

    public void testGetWorkspans() throws Exception {
        Workspan workspan = new Workspan();

        List results = dao.getWorkspans(workspan);
        assertTrue(results.size() > 0);
    }

    public void testSaveWorkspan() throws Exception {
        Workspan workspan = dao.getWorkspan(workspanId);

        // update required fields

        dao.saveWorkspan(workspan);

    }

    public void testRemoveWorkspan() throws Exception {
        Long removeId = new Long("3");
        dao.removeWorkspan(removeId);
        try {
            dao.getWorkspan(removeId);
            fail("workspan found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveWorkspans(final Map idList) throws Exception {
        try {
        	dao.removeWorkspans(idList);
            fail("workspan found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
