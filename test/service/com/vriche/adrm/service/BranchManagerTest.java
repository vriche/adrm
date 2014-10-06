
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.BranchDao;
import com.vriche.adrm.model.Branch;
import com.vriche.adrm.service.impl.BranchManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class BranchManagerTest extends BaseManagerTestCase {
    private final String branchId = "1";
    private BranchManagerImpl branchManager = new BranchManagerImpl();
    private Mock branchDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        branchDao = new Mock(BranchDao.class);
        branchManager.setBranchDao((BranchDao) branchDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        branchManager = null;
    }

    public void testGetBranchs() throws Exception {
        List results = new ArrayList();
        Branch branch = new Branch();
        results.add(branch);

        // set expected behavior on dao
        branchDao.expects(once()).method("getBranchs")
            .will(returnValue(results));

        List branchs = branchManager.getBranchs(null);
        assertTrue(branchs.size() == 1);
        branchDao.verify();
    }

    public void testGetBranch() throws Exception {
        // set expected behavior on dao
        branchDao.expects(once()).method("getBranch")
            .will(returnValue(new Branch()));
        Branch branch = branchManager.getBranch(branchId);
        assertTrue(branch != null);
        branchDao.verify();
    }

    public void testSaveBranch() throws Exception {
        Branch branch = new Branch();

        // set expected behavior on dao
        branchDao.expects(once()).method("saveBranch")
            .with(same(branch)).isVoid();

        branchManager.saveBranch(branch);
        branchDao.verify();
    }

    public void testAddAndRemoveBranch() throws Exception {
        Branch branch = new Branch();

        // set required fields
        branch.setName("ImVqNmGjRuXgRkUsIwThHsAqSwIrRvUc");
        branch.setDisplayNo(new Integer(362670735));

        // set expected behavior on dao
        branchDao.expects(once()).method("saveBranch")
            .with(same(branch)).isVoid();
        branchManager.saveBranch(branch);
        branchDao.verify();

        // reset expectations
        branchDao.reset();

        branchDao.expects(once()).method("removeBranch").with(eq(new Long(branchId)));
        branchManager.removeBranch(branchId);
        branchDao.verify();

        // reset expectations
        branchDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(Branch.class, branch.getId());
        branchDao.expects(once()).method("removeBranch").isVoid();
        branchDao.expects(once()).method("getBranch").will(throwException(ex));
        branchManager.removeBranch(branchId);
        try {
            branchManager.getBranch(branchId);
            fail("Branch with identifier '" + branchId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        branchDao.verify();
    }
}
