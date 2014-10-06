package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.ResourceLimit;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ResourceLimitDaoTest extends BaseDaoTestCase {
    private Long resourceLimitId = new Long("1");
    private ResourceLimitDao dao = null;

    public void setResourceLimitDao(ResourceLimitDao dao) {
        this.dao = dao;
    }

    public void testAddResourceLimit() throws Exception {
        ResourceLimit resourceLimit = new ResourceLimit();

        // set required fields

        java.lang.Integer startTime = new Integer(1392348743);
        resourceLimit.setStartTime(startTime);        

        java.lang.Integer endTime = new Integer(1496612186);
        resourceLimit.setEndTime(endTime);        

        java.lang.Integer limitTime = new Integer(1371990150);
        resourceLimit.setLimitTime(limitTime);        

        dao.saveResourceLimit(resourceLimit);

        // verify a primary key was assigned
        assertNotNull(resourceLimit.getId());

        // verify set fields are same after save
        assertEquals(startTime, resourceLimit.getStartTime());
        assertEquals(endTime, resourceLimit.getEndTime());
        assertEquals(limitTime, resourceLimit.getLimitTime());
    }

    public void testGetResourceLimit() throws Exception {
        ResourceLimit resourceLimit = dao.getResourceLimit(resourceLimitId);
        assertNotNull(resourceLimit);
    }

    public void testGetResourceLimits() throws Exception {
        ResourceLimit resourceLimit = new ResourceLimit();

        List results = dao.getResourceLimits(resourceLimit);
        assertTrue(results.size() > 0);
    }

    public void testSaveResourceLimit() throws Exception {
        ResourceLimit resourceLimit = dao.getResourceLimit(resourceLimitId);

        // update required fields
        java.lang.Integer startTime = new Integer(1424112695);
        resourceLimit.setStartTime(startTime);        
        java.lang.Integer endTime = new Integer(1402369149);
        resourceLimit.setEndTime(endTime);        
        java.lang.Integer limitTime = new Integer(993531864);
        resourceLimit.setLimitTime(limitTime);        

        dao.saveResourceLimit(resourceLimit);

        assertEquals(startTime, resourceLimit.getStartTime());
        assertEquals(endTime, resourceLimit.getEndTime());
        assertEquals(limitTime, resourceLimit.getLimitTime());
    }

    public void testRemoveResourceLimit() throws Exception {
        Long removeId = new Long("3");
        dao.removeResourceLimit(removeId);
        try {
            dao.getResourceLimit(removeId);
            fail("resourceLimit found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveResourceLimits(final Map idList) throws Exception {
        try {
        	dao.removeResourceLimits(idList);
            fail("resourceLimit found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
