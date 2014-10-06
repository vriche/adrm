
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.ResourceLimitDao;
import com.vriche.adrm.model.ResourceLimit;
import com.vriche.adrm.service.impl.ResourceLimitManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class ResourceLimitManagerTest extends BaseManagerTestCase {
    private final String resourceLimitId = "1";
    private ResourceLimitManagerImpl resourceLimitManager = new ResourceLimitManagerImpl();
    private Mock resourceLimitDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        resourceLimitDao = new Mock(ResourceLimitDao.class);
        resourceLimitManager.setResourceLimitDao((ResourceLimitDao) resourceLimitDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        resourceLimitManager = null;
    }

    public void testGetResourceLimits() throws Exception {
        List results = new ArrayList();
        ResourceLimit resourceLimit = new ResourceLimit();
        results.add(resourceLimit);

        // set expected behavior on dao
        resourceLimitDao.expects(once()).method("getResourceLimits")
            .will(returnValue(results));

        List resourceLimits = resourceLimitManager.getResourceLimits(null);
        assertTrue(resourceLimits.size() == 1);
        resourceLimitDao.verify();
    }

    public void testGetResourceLimit() throws Exception {
        // set expected behavior on dao
        resourceLimitDao.expects(once()).method("getResourceLimit")
            .will(returnValue(new ResourceLimit()));
        ResourceLimit resourceLimit = resourceLimitManager.getResourceLimit(resourceLimitId);
        assertTrue(resourceLimit != null);
        resourceLimitDao.verify();
    }

    public void testSaveResourceLimit() throws Exception {
        ResourceLimit resourceLimit = new ResourceLimit();

        // set expected behavior on dao
        resourceLimitDao.expects(once()).method("saveResourceLimit")
            .with(same(resourceLimit)).isVoid();

        resourceLimitManager.saveResourceLimit(resourceLimit);
        resourceLimitDao.verify();
    }

    public void testAddAndRemoveResourceLimit() throws Exception {
        ResourceLimit resourceLimit = new ResourceLimit();

        // set required fields
        resourceLimit.setStartTime(new Integer(2007628525));
        resourceLimit.setEndTime(new Integer(1737206580));
        resourceLimit.setLimitTime(new Integer(505761606));

        // set expected behavior on dao
        resourceLimitDao.expects(once()).method("saveResourceLimit")
            .with(same(resourceLimit)).isVoid();
        resourceLimitManager.saveResourceLimit(resourceLimit);
        resourceLimitDao.verify();

        // reset expectations
        resourceLimitDao.reset();

        resourceLimitDao.expects(once()).method("removeResourceLimit").with(eq(new Long(resourceLimitId)));
        resourceLimitManager.removeResourceLimit(resourceLimitId);
        resourceLimitDao.verify();

        // reset expectations
        resourceLimitDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(ResourceLimit.class, resourceLimit.getId());
        resourceLimitDao.expects(once()).method("removeResourceLimit").isVoid();
        resourceLimitDao.expects(once()).method("getResourceLimit").will(throwException(ex));
        resourceLimitManager.removeResourceLimit(resourceLimitId);
        try {
            resourceLimitManager.getResourceLimit(resourceLimitId);
            fail("ResourceLimit with identifier '" + resourceLimitId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        resourceLimitDao.verify();
    }
}
