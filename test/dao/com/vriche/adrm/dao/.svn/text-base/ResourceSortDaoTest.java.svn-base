package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.ResourceSort;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ResourceSortDaoTest extends BaseDaoTestCase {
    private Long resourceSortId = new Long("1");
    private ResourceSortDao dao = null;

    public void setResourceSortDao(ResourceSortDao dao) {
        this.dao = dao;
    }

    public void testAddResourceSort() throws Exception {
        ResourceSort resourceSort = new ResourceSort();

        // set required fields

        dao.saveResourceSort(resourceSort);

        // verify a primary key was assigned
        assertNotNull(resourceSort.getId());

        // verify set fields are same after save
    }

    public void testGetResourceSort() throws Exception {
        ResourceSort resourceSort = dao.getResourceSort(resourceSortId);
        assertNotNull(resourceSort);
    }

    public void testGetResourceSorts() throws Exception {
        ResourceSort resourceSort = new ResourceSort();

        List results = dao.getResourceSorts(resourceSort);
        assertTrue(results.size() > 0);
    }

    public void testSaveResourceSort() throws Exception {
        ResourceSort resourceSort = dao.getResourceSort(resourceSortId);

        // update required fields

        dao.saveResourceSort(resourceSort);

    }

    public void testRemoveResourceSort() throws Exception {
        Long removeId = new Long("3");
        dao.removeResourceSort(removeId);
        try {
            dao.getResourceSort(removeId);
            fail("resourceSort found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveResourceSorts(final Map idList) throws Exception {
        try {
        	dao.removeResourceSorts(idList);
            fail("resourceSort found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
