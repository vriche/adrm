package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.Org;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OrgDaoTest extends BaseDaoTestCase {
    private Long orgId = new Long("1");
    private OrgDao dao = null;

    public void setOrgDao(OrgDao dao) {
        this.dao = dao;
    }

    public void testAddOrg() throws Exception {
        Org org = new Org();

        // set required fields

        dao.saveOrg(org);

        // verify a primary key was assigned
        assertNotNull(org.getId());

        // verify set fields are same after save
    }

    public void testGetOrg() throws Exception {
        Org org = dao.getOrg(orgId);
        assertNotNull(org);
    }

    public void testGetOrgs() throws Exception {
        Org org = new Org();

        List results = dao.getOrgs(org);
        assertTrue(results.size() > 0);
    }

    public void testSaveOrg() throws Exception {
        Org org = dao.getOrg(orgId);

        // update required fields

        dao.saveOrg(org);

    }

    public void testRemoveOrg() throws Exception {
        Long removeId = new Long("3");
        dao.removeOrg(removeId);
        try {
            dao.getOrg(removeId);
            fail("org found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOrgs(final Map idList) throws Exception {
        try {
        	dao.removeOrgs(idList);
            fail("org found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
