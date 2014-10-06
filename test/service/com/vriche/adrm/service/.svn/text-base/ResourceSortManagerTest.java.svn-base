
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.ResourceSortDao;
import com.vriche.adrm.model.ResourceSort;
import com.vriche.adrm.service.impl.ResourceSortManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class ResourceSortManagerTest extends BaseManagerTestCase {
    private final String resourceSortId = "1";
    private ResourceSortManagerImpl resourceSortManager = new ResourceSortManagerImpl();
    private Mock resourceSortDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        resourceSortDao = new Mock(ResourceSortDao.class);
        resourceSortManager.setResourceSortDao((ResourceSortDao) resourceSortDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        resourceSortManager = null;
    }

    public void testGetResourceSorts() throws Exception {
        List results = new ArrayList();
        ResourceSort resourceSort = new ResourceSort();
        results.add(resourceSort);

        // set expected behavior on dao
        resourceSortDao.expects(once()).method("getResourceSorts")
            .will(returnValue(results));

        List resourceSorts = resourceSortManager.getResourceSorts(null);
        assertTrue(resourceSorts.size() == 1);
        resourceSortDao.verify();
    }

    public void testGetResourceSort() throws Exception {
        // set expected behavior on dao
        resourceSortDao.expects(once()).method("getResourceSort")
            .will(returnValue(new ResourceSort()));
        ResourceSort resourceSort = resourceSortManager.getResourceSort(resourceSortId);
        assertTrue(resourceSort != null);
        resourceSortDao.verify();
    }

    public void testSaveResourceSort() throws Exception {
        ResourceSort resourceSort = new ResourceSort();

        // set expected behavior on dao
        resourceSortDao.expects(once()).method("saveResourceSort")
            .with(same(resourceSort)).isVoid();

        resourceSortManager.saveResourceSort(resourceSort);
        resourceSortDao.verify();
    }

    public void testAddAndRemoveResourceSort() throws Exception {
        ResourceSort resourceSort = new ResourceSort();

        // set required fields

        // set expected behavior on dao
        resourceSortDao.expects(once()).method("saveResourceSort")
            .with(same(resourceSort)).isVoid();
        resourceSortManager.saveResourceSort(resourceSort);
        resourceSortDao.verify();

        // reset expectations
        resourceSortDao.reset();

        resourceSortDao.expects(once()).method("removeResourceSort").with(eq(new Long(resourceSortId)));
        resourceSortManager.removeResourceSort(resourceSortId);
        resourceSortDao.verify();

        // reset expectations
        resourceSortDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(ResourceSort.class, resourceSort.getId());
        resourceSortDao.expects(once()).method("removeResourceSort").isVoid();
        resourceSortDao.expects(once()).method("getResourceSort").will(throwException(ex));
        resourceSortManager.removeResourceSort(resourceSortId);
        try {
            resourceSortManager.getResourceSort(resourceSortId);
            fail("ResourceSort with identifier '" + resourceSortId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        resourceSortDao.verify();
    }
}
