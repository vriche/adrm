
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.ResourceTypeDao;
import com.vriche.adrm.model.ResourceType;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.ResourceTypeManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class ResourceTypeManagerTest extends BaseManagerTestCase {
    private final String resourceTypeId = "1";
    private ResourceTypeManagerImpl resourceTypeManager = new ResourceTypeManagerImpl();
    private Mock resourceTypeDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        resourceTypeDao = new Mock(ResourceTypeDao.class);
        resourceTypeManager.setResourceTypeDao((ResourceTypeDao) resourceTypeDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        resourceTypeManager = null;
    }

    public void testGetResourceTypes() throws Exception {
        List results = new ArrayList();
        ResourceType resourceType = new ResourceType();
        results.add(resourceType);

        // set expected behavior on dao
        resourceTypeDao.expects(once()).method("getResourceTypes")
            .will(returnValue(results));

        List resourceTypes = resourceTypeManager.getResourceTypes(null);
        assertTrue(resourceTypes.size() == 1);
        resourceTypeDao.verify();
    }

    public void testGetResourceType() throws Exception {
        // set expected behavior on dao
        resourceTypeDao.expects(once()).method("getResourceType")
            .will(returnValue(new ResourceType()));
        ResourceType resourceType = resourceTypeManager.getResourceType(resourceTypeId);
        assertTrue(resourceType != null);
        resourceTypeDao.verify();
    }

    public void testSaveResourceType() throws Exception {
        ResourceType resourceType = new ResourceType();

        // set expected behavior on dao
        resourceTypeDao.expects(once()).method("saveResourceType")
            .with(same(resourceType)).isVoid();

        resourceTypeManager.saveResourceType(resourceType);
        resourceTypeDao.verify();
    }

    public void testAddAndRemoveResourceType() throws Exception {
        ResourceType resourceType = new ResourceType();

        // set required fields

        // set expected behavior on dao
        resourceTypeDao.expects(once()).method("saveResourceType")
            .with(same(resourceType)).isVoid();
        resourceTypeManager.saveResourceType(resourceType);
        resourceTypeDao.verify();

        // reset expectations
        resourceTypeDao.reset();

        resourceTypeDao.expects(once()).method("removeResourceType").with(eq(new Long(resourceTypeId)));
        resourceTypeManager.removeResourceType(resourceTypeId);
        resourceTypeDao.verify();

        // reset expectations
        resourceTypeDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(ResourceType.class, resourceType.getId());
        resourceTypeDao.expects(once()).method("removeResourceType").isVoid();
        resourceTypeDao.expects(once()).method("getResourceType").will(throwException(ex));
        resourceTypeManager.removeResourceType(resourceTypeId);
        try {
            resourceTypeManager.getResourceType(resourceTypeId);
            fail("ResourceType with identifier '" + resourceTypeId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        resourceTypeDao.verify();
    }
}
