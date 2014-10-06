
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.WorkspanDao;
import com.vriche.adrm.model.Workspan;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.WorkspanManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class WorkspanManagerTest extends BaseManagerTestCase {
    private final String workspanId = "1";
    private WorkspanManagerImpl workspanManager = new WorkspanManagerImpl();
    private Mock workspanDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        workspanDao = new Mock(WorkspanDao.class);
        workspanManager.setWorkspanDao((WorkspanDao) workspanDao.proxy());
    }

    
    
    protected void tearDown() throws Exception {
        super.tearDown();
        workspanManager = null;
    }

    public void testGetWorkspans() throws Exception {
        List results = new ArrayList();
        Workspan workspan = new Workspan();
        results.add(workspan);

        // set expected behavior on dao
        workspanDao.expects(once()).method("getWorkspans")
            .will(returnValue(results));

        List workspans = workspanManager.getWorkspans(null);
        assertTrue(workspans.size() == 1);
        workspanDao.verify();
    }

    public void testGetWorkspan() throws Exception {
        // set expected behavior on dao
        workspanDao.expects(once()).method("getWorkspan")
            .will(returnValue(new Workspan()));
        Workspan workspan = workspanManager.getWorkspan(workspanId);
        assertTrue(workspan != null);
        workspanDao.verify();
    }

    public void testSaveWorkspan() throws Exception {
        Workspan workspan = new Workspan();

        // set expected behavior on dao
        workspanDao.expects(once()).method("saveWorkspan")
            .with(same(workspan)).isVoid();

        workspanManager.saveWorkspan(workspan);
        workspanDao.verify();
    }

    public void testAddAndRemoveWorkspan() throws Exception {
        Workspan workspan = new Workspan();

        // set required fields

        // set expected behavior on dao
        workspanDao.expects(once()).method("saveWorkspan")
            .with(same(workspan)).isVoid();
        workspanManager.saveWorkspan(workspan);
        workspanDao.verify();

        // reset expectations
        workspanDao.reset();

        workspanDao.expects(once()).method("removeWorkspan").with(eq(new Long(workspanId)));
        workspanManager.removeWorkspan(workspanId);
        workspanDao.verify();

        // reset expectations
        workspanDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(Workspan.class, workspan.getId());
        workspanDao.expects(once()).method("removeWorkspan").isVoid();
        workspanDao.expects(once()).method("getWorkspan").will(throwException(ex));
        workspanManager.removeWorkspan(workspanId);
        try {
            workspanManager.getWorkspan(workspanId);
            fail("Workspan with identifier '" + workspanId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        workspanDao.verify();
    }
}
