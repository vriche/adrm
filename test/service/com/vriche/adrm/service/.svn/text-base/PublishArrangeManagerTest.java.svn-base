
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.PublishArrangeDao;
import com.vriche.adrm.model.PublishArrange;
import com.vriche.adrm.service.impl.PublishArrangeManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class PublishArrangeManagerTest extends BaseManagerTestCase {
    private final String publishArrangeId = "1";
    private PublishArrangeManagerImpl publishArrangeManager = new PublishArrangeManagerImpl();
    private Mock publishArrangeDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        publishArrangeDao = new Mock(PublishArrangeDao.class);
        publishArrangeManager.setPublishArrangeDao((PublishArrangeDao) publishArrangeDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        publishArrangeManager = null;
    }

    public void testGetPublishArranges() throws Exception {
        List results = new ArrayList();
        PublishArrange publishArrange = new PublishArrange();
        results.add(publishArrange);

        // set expected behavior on dao
        publishArrangeDao.expects(once()).method("getPublishArranges")
            .will(returnValue(results));

        List publishArranges = publishArrangeManager.getPublishArranges(null);
        assertTrue(publishArranges.size() == 1);
        publishArrangeDao.verify();
    }

    public void testGetPublishArrange() throws Exception {
        // set expected behavior on dao
        publishArrangeDao.expects(once()).method("getPublishArrange")
            .will(returnValue(new PublishArrange()));
        PublishArrange publishArrange = publishArrangeManager.getPublishArrange(publishArrangeId);
        assertTrue(publishArrange != null);
        publishArrangeDao.verify();
    }

    public void testSavePublishArrange() throws Exception {
        PublishArrange publishArrange = new PublishArrange();

        // set expected behavior on dao
        publishArrangeDao.expects(once()).method("savePublishArrange")
            .with(same(publishArrange)).isVoid();

        publishArrangeManager.savePublishArrange(publishArrange);
        publishArrangeDao.verify();
    }

    public void testAddAndRemovePublishArrange() throws Exception {
        PublishArrange publishArrange = new PublishArrange();

        // set required fields
        publishArrange.setCarrierId(new Long(935484023));
        publishArrange.setCarrierName("VdJnDpJbQyNaIrGpQzGoQiBkEyPlTxRaOxJfJeDgLfMkNiVnIiOiEuTcKzOwIoXtFdVfFjXqYxDcYoXcQjIlJzTrGtCyWxArTiMiPyCbCuFeElIjIxJmDvRfYdVpEtGc");
        publishArrange.setFilePath("HzTyUjTzOkOvUtEbPcSyOfWwXqTdCkVjDfBrKiEoHtBcRkXmHxWoWlEyQtHvVcJaEiIqMgXnLuWhUhYrFzOePfXbPeLtVdMbKwEoZnVsSpWzFhHxCtUpEpCqRtOtAxNjZtRsGpPqNqFdDrMgItEwPoBrOxXtWhVrYrVhYnEhUeKlNnXpJcCsMiFuPhXgBnWqYyIxFnUkUeGdNmAwCmUgJnYjVnHbIvWyOiDrBfDrJePsRzHgOzEyCzAbFqSmNtSc");
        publishArrange.setIsEnable(new Boolean("false"));
        publishArrange.setIsLocked(new Boolean("false"));
        publishArrange.setPublishDate(new Integer(670288942));
        publishArrange.setResourceId(new Long(434092465));
        publishArrange.setResourceMeno("WzXqSmIpReYiCfBsCuQiZrGeQhWpAcSdYcMwIrZhGlFjVbCcTwClCySwErOzKnNmJoBqGtHeTyYiKjCxOzXlDyRrNoOvZuLiLdSiGfUkPnDqZkBdBpKqUnStPzRnMuAu");
        publishArrange.setResourceName("AvXhVdCpYrOkZrNnEcOyDaRyOfYhZqOiRiPfBfOeQuAxCxRzRiXnNhFiEhAxMvPnNkAyLoFiIzHkYgBmXcXpJzYeVuEpKiMzZaKiAjVyXwWeTvAcViIoPzQbIwFdJjEo");
        publishArrange.setResourceTotalTimes(new Integer(1746916066));
        publishArrange.setResourceUsedTimes(new Integer(247272165));

        // set expected behavior on dao
        publishArrangeDao.expects(once()).method("savePublishArrange")
            .with(same(publishArrange)).isVoid();
        publishArrangeManager.savePublishArrange(publishArrange);
        publishArrangeDao.verify();

        // reset expectations
        publishArrangeDao.reset();

        publishArrangeDao.expects(once()).method("removePublishArrange").with(eq(new Long(publishArrangeId)));
        publishArrangeManager.removePublishArrange(publishArrangeId);
        publishArrangeDao.verify();

        // reset expectations
        publishArrangeDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(PublishArrange.class, publishArrange.getId());
        publishArrangeDao.expects(once()).method("removePublishArrange").isVoid();
        publishArrangeDao.expects(once()).method("getPublishArrange").will(throwException(ex));
        publishArrangeManager.removePublishArrange(publishArrangeId);
        try {
            publishArrangeManager.getPublishArrange(publishArrangeId);
            fail("PublishArrange with identifier '" + publishArrangeId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        publishArrangeDao.verify();
    }
}
