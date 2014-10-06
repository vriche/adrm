package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.ResourceChannel;
import com.vriche.adrm.dao.ResourceChannelDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class ResourceChannelDaoTest extends BaseDaoTestCase {
    private Long resourceChannelId = new Long("1");
    private ResourceChannelDao dao = null;

    public void setResourceChannelDao(ResourceChannelDao dao) {
        this.dao = dao;
    }

    public void testAddResourceChannel() throws Exception {
        ResourceChannel resourceChannel = new ResourceChannel();

        // set required fields

        dao.saveResourceChannel(resourceChannel);

        // verify a primary key was assigned
        assertNotNull(resourceChannel.getId());

        // verify set fields are same after save
    }

    public void testGetResourceChannel() throws Exception {
        ResourceChannel resourceChannel = dao.getResourceChannel(resourceChannelId);
        assertNotNull(resourceChannel);
    }

    public void testGetResourceChannels() throws Exception {
        ResourceChannel resourceChannel = new ResourceChannel();

        List results = dao.getResourceChannels(resourceChannel);
        assertTrue(results.size() > 0);
    }

    public void testSaveResourceChannel() throws Exception {
        ResourceChannel resourceChannel = dao.getResourceChannel(resourceChannelId);

        // update required fields

        dao.saveResourceChannel(resourceChannel);

    }

    public void testRemoveResourceChannel() throws Exception {
        Long removeId = new Long("3");
        dao.removeResourceChannel(removeId);
        try {
            dao.getResourceChannel(removeId);
            fail("resourceChannel found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveResourceChannels(final Map idList) throws Exception {
        try {
        	dao.removeResourceChannels(idList);
            fail("resourceChannel found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
