
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OrgDao;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.service.impl.OrgManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OrgManagerTest extends BaseManagerTestCase {
    private final String orgId = "1";
    private OrgManagerImpl orgManager = new OrgManagerImpl();
    private Mock orgDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        orgDao = new Mock(OrgDao.class);
        orgManager.setOrgDao((OrgDao) orgDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        orgManager = null;
    }

    public void testGetOrgs() throws Exception {
        List results = new ArrayList();
        Org org = new Org();
        results.add(org);

        // set expected behavior on dao
        orgDao.expects(once()).method("getOrgs")
            .will(returnValue(results));

        List orgs = orgManager.getOrgs(null);
        assertTrue(orgs.size() == 1);
        orgDao.verify();
    }

    public void testGetOrg() throws Exception {
        // set expected behavior on dao
        orgDao.expects(once()).method("getOrg")
            .will(returnValue(new Org()));
        Org org = orgManager.getOrg(orgId);
        assertTrue(org != null);
        orgDao.verify();
    }

    public void testSaveOrg() throws Exception {
        Org org = new Org();

        // set expected behavior on dao
        orgDao.expects(once()).method("saveOrg")
            .with(same(org)).isVoid();

        orgManager.saveOrg(org);
        orgDao.verify();
    }

    public void testAddAndRemoveOrg() throws Exception {
        Org org = new Org();

        // set required fields

        // set expected behavior on dao
        orgDao.expects(once()).method("saveOrg")
            .with(same(org)).isVoid();
        orgManager.saveOrg(org);
        orgDao.verify();

        // reset expectations
        orgDao.reset();

        orgDao.expects(once()).method("removeOrg").with(eq(new Long(orgId)));
        orgManager.removeOrg(orgId);
        orgDao.verify();

        // reset expectations
        orgDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(Org.class, org.getId());
        orgDao.expects(once()).method("removeOrg").isVoid();
        orgDao.expects(once()).method("getOrg").will(throwException(ex));
        orgManager.removeOrg(orgId);
        try {
            orgManager.getOrg(orgId);
            fail("Org with identifier '" + orgId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        orgDao.verify();
    }
}
