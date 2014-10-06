package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.ResourceType;
import com.vriche.adrm.dao.ResourceTypeDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ResourceTypeDaoTest extends BaseDaoTestCase {
    private Long resourceTypeId = new Long("1");
    private ResourceTypeDao dao = null;

    public void setResourceTypeDao(ResourceTypeDao dao) {
        this.dao = dao;
    }

    public void testAddResourceType() throws Exception {
        ResourceType resourceType = new ResourceType();

        // set required fields

        dao.saveResourceType(resourceType);

        // verify a primary key was assigned
        assertNotNull(resourceType.getId());

        // verify set fields are same after save
    }

    public void testGetResourceType() throws Exception {
        ResourceType resourceType = dao.getResourceType(resourceTypeId);
        assertNotNull(resourceType);
    }

    public void testGetResourceTypes() throws Exception {
        ResourceType resourceType = new ResourceType();

        List results = dao.getResourceTypes(resourceType);
        assertTrue(results.size() > 0);
    }

    public void testSaveResourceType() throws Exception {
        ResourceType resourceType = dao.getResourceType(resourceTypeId);

        // update required fields

        dao.saveResourceType(resourceType);

    }

    public void testRemoveResourceType() throws Exception {
        Long removeId = new Long("3");
        dao.removeResourceType(removeId);
        try {
            dao.getResourceType(removeId);
            fail("resourceType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveResourceTypes(final Map idList) throws Exception {
        try {
        	dao.removeResourceTypes(idList);
            fail("resourceType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
