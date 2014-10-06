
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.ResourceDao;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.ResourceManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class ResourceManagerTest extends BaseManagerTestCase {
    private final String resourceId = "1";
    private ResourceManagerImpl resourceManager = new ResourceManagerImpl();
    private Mock resourceDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        resourceDao = new Mock(ResourceDao.class);
        resourceManager.setResourceDao((ResourceDao) resourceDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        resourceManager = null;
    }

    public void testGetResources() throws Exception {
        List results = new ArrayList();
        Resource resource = new Resource();
        results.add(resource);

        // set expected behavior on dao
        resourceDao.expects(once()).method("getResources")
            .will(returnValue(results));

        List resources = resourceManager.getResources(null);
        assertTrue(resources.size() == 1);
        resourceDao.verify();
    }

    public void testGetResource() throws Exception {
        // set expected behavior on dao
        resourceDao.expects(once()).method("getResource")
            .will(returnValue(new Resource()));
        Resource resource = resourceManager.getResource(resourceId);
        assertTrue(resource != null);
        resourceDao.verify();
    }

    public void testSaveResource() throws Exception {
        Resource resource = new Resource();

        // set expected behavior on dao
        resourceDao.expects(once()).method("saveResource")
            .with(same(resource)).isVoid();

        resourceManager.saveResource(resource);
        resourceDao.verify();
    }

    public void testAddAndRemoveResource() throws Exception {
        Resource resource = new Resource();

        // set required fields
        resource.setCarrierId(new Long(481185631));
        resource.setResourceName("PrErKiWuZnVxIzViSkAyJbCjCkLoSjDx");

        // set expected behavior on dao
        resourceDao.expects(once()).method("saveResource")
            .with(same(resource)).isVoid();
        resourceManager.saveResource(resource);
        resourceDao.verify();

        // reset expectations
        resourceDao.reset();

        resourceDao.expects(once()).method("removeResource").with(eq(new Long(resourceId)));
        resourceManager.removeResource(resourceId);
        resourceDao.verify();

        // reset expectations
        resourceDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(Resource.class, resource.getId());
        resourceDao.expects(once()).method("removeResource").isVoid();
        resourceDao.expects(once()).method("getResource").will(throwException(ex));
        resourceManager.removeResource(resourceId);
        try {
            resourceManager.getResource(resourceId);
            fail("Resource with identifier '" + resourceId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        resourceDao.verify();
    }
}
