package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.Branch;

import org.springframework.orm.ObjectRetrievalFailureException;

public class BranchDaoTest extends BaseDaoTestCase {
    private Long branchId = new Long("1");
    private BranchDao dao = null;

    public void setBranchDao(BranchDao dao) {
        this.dao = dao;
    }

    public void testAddBranch() throws Exception {
        Branch branch = new Branch();

        // set required fields

        java.lang.String name = "WkMtXgWoGoDkWzLpVcVlQxIyRqCsFvGa";
        branch.setName(name);        

        java.lang.Integer displayNo = new Integer(2047561767);
        branch.setDisplayNo(displayNo);        

        dao.saveBranch(branch);

        // verify a primary key was assigned
        assertNotNull(branch.getId());

        // verify set fields are same after save
        assertEquals(name, branch.getName());
        assertEquals(displayNo, branch.getDisplayNo());
    }

    public void testGetBranch() throws Exception {
        Branch branch = dao.getBranch(branchId);
        assertNotNull(branch);
    }

    public void testGetBranchs() throws Exception {
        Branch branch = new Branch();

        List results = dao.getBranchs(branch);
        assertTrue(results.size() > 0);
    }

    public void testSaveBranch() throws Exception {
        Branch branch = dao.getBranch(branchId);

        // update required fields
        java.lang.String name = "HtIpRfSvQyVjSqJmPqJtNuQlKvYyIbXv";
        branch.setName(name);        
        java.lang.Integer displayNo = new Integer(436342349);
        branch.setDisplayNo(displayNo);        

        dao.saveBranch(branch);

        assertEquals(name, branch.getName());
        assertEquals(displayNo, branch.getDisplayNo());
    }

//    public void testRemoveBranch() throws Exception {
//        Long removeId = new Long("3");
//        dao.removeBranch(removeId);
//        try {
//            dao.getBranch(removeId);
//            fail("branch found in database");
//        } catch (ObjectRetrievalFailureException e) {
//            assertNotNull(e.getMessage());
//        }
//    }
   public void testRemoveBranchs(final Map idList) throws Exception {
        try {
        	dao.removeBranchs(idList);
            fail("branch found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
