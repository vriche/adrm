
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.ResourceChannelDao;
import com.vriche.adrm.model.ResourceChannel;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.ResourceChannelManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class ResourceChannelManagerTest extends BaseManagerTestCase {
    private final String resourceChannelId = "1";
    private ResourceChannelManagerImpl resourceChannelManager = new ResourceChannelManagerImpl();
    private Mock resourceChannelDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        resourceChannelDao = new Mock(ResourceChannelDao.class);
        resourceChannelManager.setResourceChannelDao((ResourceChannelDao) resourceChannelDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        resourceChannelManager = null;
    }

    public void testGetResourceChannels() throws Exception {
        List results = new ArrayList();
        ResourceChannel resourceChannel = new ResourceChannel();
        results.add(resourceChannel);

        // set expected behavior on dao
        resourceChannelDao.expects(once()).method("getResourceChannels")
            .will(returnValue(results));

        List resourceChannels = resourceChannelManager.getResourceChannels(null);
        assertTrue(resourceChannels.size() == 1);
        resourceChannelDao.verify();
    }

    public void testGetResourceChannel() throws Exception {
        // set expected behavior on dao
        resourceChannelDao.expects(once()).method("getResourceChannel")
            .will(returnValue(new ResourceChannel()));
        ResourceChannel resourceChannel = resourceChannelManager.getResourceChannel(resourceChannelId);
        assertTrue(resourceChannel != null);
        resourceChannelDao.verify();
    }

    public void testSaveResourceChannel() throws Exception {
        ResourceChannel resourceChannel = new ResourceChannel();

        // set expected behavior on dao
        resourceChannelDao.expects(once()).method("saveResourceChannel")
            .with(same(resourceChannel)).isVoid();

        resourceChannelManager.saveResourceChannel(resourceChannel);
        resourceChannelDao.verify();
    }

    public void testAddAndRemoveResourceChannel() throws Exception {
        ResourceChannel resourceChannel = new ResourceChannel();

        // set required fields

        // set expected behavior on dao
        resourceChannelDao.expects(once()).method("saveResourceChannel")
            .with(same(resourceChannel)).isVoid();
        resourceChannelManager.saveResourceChannel(resourceChannel);
        resourceChannelDao.verify();

        // reset expectations
        resourceChannelDao.reset();

        resourceChannelDao.expects(once()).method("removeResourceChannel").with(eq(new Long(resourceChannelId)));
        resourceChannelManager.removeResourceChannel(resourceChannelId);
        resourceChannelDao.verify();

        // reset expectations
        resourceChannelDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(ResourceChannel.class, resourceChannel.getId());
        resourceChannelDao.expects(once()).method("removeResourceChannel").isVoid();
        resourceChannelDao.expects(once()).method("getResourceChannel").will(throwException(ex));
        resourceChannelManager.removeResourceChannel(resourceChannelId);
        try {
            resourceChannelManager.getResourceChannel(resourceChannelId);
            fail("ResourceChannel with identifier '" + resourceChannelId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        resourceChannelDao.verify();
    }
}
