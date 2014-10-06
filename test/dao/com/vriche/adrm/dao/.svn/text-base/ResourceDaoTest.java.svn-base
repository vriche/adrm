package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.dao.ResourceDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ResourceDaoTest extends BaseDaoTestCase {
    private Long resourceId = new Long("1");
    private ResourceDao dao = null;

    public void setResourceDao(ResourceDao dao) {
        this.dao = dao;
    }

    public void testAddResource() throws Exception {
        Resource resource = new Resource();

        // set required fields

        java.lang.Long carrierId = new Long(1160716328);
        resource.setCarrierId(carrierId);        

        java.lang.String resourceName = "UnTqEjTnAqPhInJrBzVdIkXbGpWwYvEe";
        resource.setResourceName(resourceName);        

        dao.saveResource(resource);

        // verify a primary key was assigned
        assertNotNull(resource.getId());

        // verify set fields are same after save
        assertEquals(carrierId, resource.getCarrierId());
        assertEquals(resourceName, resource.getResourceName());
    }

    public void testGetResource() throws Exception {
        Resource resource = dao.getResource(resourceId);
        assertNotNull(resource);
    }

    public void testGetResources() throws Exception {
        Resource resource = new Resource();

        List results = dao.getResources(resource);
        assertTrue(results.size() > 0);
    }

    public void testSaveResource() throws Exception {
        Resource resource = dao.getResource(resourceId);

        // update required fields
        java.lang.Long carrierId = new Long(319697951);
        resource.setCarrierId(carrierId);        
        java.lang.String resourceName = "HwObJeTcEjAeMjUuNmPiLsYeRtXdQdFx";
        resource.setResourceName(resourceName);        

        dao.saveResource(resource);

        assertEquals(carrierId, resource.getCarrierId());
        assertEquals(resourceName, resource.getResourceName());
    }

    public void testRemoveResource() throws Exception {
        Long removeId = new Long("3");
        dao.removeResource(removeId);
        try {
            dao.getResource(removeId);
            fail("resource found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveResources(final Map idList) throws Exception {
        try {
        	dao.removeResources(idList);
            fail("resource found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
