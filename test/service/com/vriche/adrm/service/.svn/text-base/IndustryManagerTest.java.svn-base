
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;

import com.vriche.adrm.dao.IndustryDao;
import com.vriche.adrm.model.Industry;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.IndustryManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class IndustryManagerTest extends BaseManagerTestCase {
    private final String industryId = "1";
    private IndustryManagerImpl industryManager = new IndustryManagerImpl();
    private Mock industryDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        industryDao = new Mock(IndustryDao.class);
        industryManager.setIndustryDao((IndustryDao) industryDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        industryManager = null;
    }

    public void testGetIndustrys() throws Exception {
        List results = new ArrayList();
        Industry industry = new Industry();
        results.add(industry);

        // set expected behavior on dao
        industryDao.expects(once()).method("getIndustrys")
            .will(returnValue(results));

        List industrys = industryManager.getIndustrys(null);
        assertTrue(industrys.size() == 1);
        industryDao.verify();
    }

    public void testGetIndustry() throws Exception {
        // set expected behavior on dao
        industryDao.expects(once()).method("getIndustry")
            .will(returnValue(new Industry()));
        Industry industry = industryManager.getIndustry(industryId);
        assertTrue(industry != null);
        industryDao.verify();
    }

    public void testSaveIndustry() throws Exception {
        Industry industry = new Industry();

        // set expected behavior on dao
        industryDao.expects(once()).method("saveIndustry")
            .with(same(industry)).isVoid();

        industryManager.saveIndustry(industry);
        industryDao.verify();
    }

    public void testAddAndRemoveIndustry() throws Exception {
        Industry industry = new Industry();

        // set required fields
        industry.setName("HlNpEhOxEvJpJoInKeXpWnKpLgIaExOjEzImHbYzSxIwRpYpPaVgPwMpCnUuVtZoDzTwIuLwMtIdMsOaGhTtWiQbAdXgYoBnApXaBmLmBiJaDoJkUeWaYlSsMkAnXjAt");

        // set expected behavior on dao
        industryDao.expects(once()).method("saveIndustry")
            .with(same(industry)).isVoid();
        industryManager.saveIndustry(industry);
        industryDao.verify();

        // reset expectations
        industryDao.reset();

        industryDao.expects(once()).method("removeIndustry").with(eq(new Long(industryId)));
        industryManager.removeIndustry(industryId);
        industryDao.verify();

        // reset expectations
        industryDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(Industry.class, industry.getId());
        industryDao.expects(once()).method("removeIndustry").isVoid();
        industryDao.expects(once()).method("getIndustry").will(throwException(ex));
        industryManager.removeIndustry(industryId);
        try {
            industryManager.getIndustry(industryId);
            fail("Industry with identifier '" + industryId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        industryDao.verify();
    }
}
