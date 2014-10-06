
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.DayInfoDao;
import com.vriche.adrm.model.DayInfo;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.DayInfoManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class DayInfoManagerTest extends BaseManagerTestCase {
    private final String dayInfoId = "1";
    private DayInfoManagerImpl dayInfoManager = new DayInfoManagerImpl();
    private Mock dayInfoDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        dayInfoDao = new Mock(DayInfoDao.class);
        dayInfoManager.setDayInfoDao((DayInfoDao) dayInfoDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        dayInfoManager = null;
    }

    public void testGetDayInfos() throws Exception {
        List results = new ArrayList();
        DayInfo dayInfo = new DayInfo();
        results.add(dayInfo);

        // set expected behavior on dao
        dayInfoDao.expects(once()).method("getDayInfos")
            .will(returnValue(results));

        List dayInfos = dayInfoManager.getDayInfos(null);
        assertTrue(dayInfos.size() == 1);
        dayInfoDao.verify();
    }

    public void testGetDayInfo() throws Exception {
        // set expected behavior on dao
        dayInfoDao.expects(once()).method("getDayInfo")
            .will(returnValue(new DayInfo()));
        DayInfo dayInfo = dayInfoManager.getDayInfo(dayInfoId);
        assertTrue(dayInfo != null);
        dayInfoDao.verify();
    }

    public void testSaveDayInfo() throws Exception {
        DayInfo dayInfo = new DayInfo();

        // set expected behavior on dao
        dayInfoDao.expects(once()).method("saveDayInfo")
            .with(same(dayInfo)).isVoid();

        dayInfoManager.saveDayInfo(dayInfo);
        dayInfoDao.verify();
    }

    public void testAddAndRemoveDayInfo() throws Exception {
        DayInfo dayInfo = new DayInfo();

        // set required fields

        // set expected behavior on dao
        dayInfoDao.expects(once()).method("saveDayInfo")
            .with(same(dayInfo)).isVoid();
        dayInfoManager.saveDayInfo(dayInfo);
        dayInfoDao.verify();

        // reset expectations
        dayInfoDao.reset();

        dayInfoDao.expects(once()).method("removeDayInfo").with(eq(new Long(dayInfoId)));
        dayInfoManager.removeDayInfo(dayInfoId);
        dayInfoDao.verify();

        // reset expectations
        dayInfoDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(DayInfo.class, dayInfo.getId());
        dayInfoDao.expects(once()).method("removeDayInfo").isVoid();
        dayInfoDao.expects(once()).method("getDayInfo").will(throwException(ex));
        dayInfoManager.removeDayInfo(dayInfoId);
        try {
            dayInfoManager.getDayInfo(dayInfoId);
            fail("DayInfo with identifier '" + dayInfoId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        dayInfoDao.verify();
    }
}
