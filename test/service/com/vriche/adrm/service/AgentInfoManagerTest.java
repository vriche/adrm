
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.AgentInfoDao;
import com.vriche.adrm.model.AgentInfo;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.AgentInfoManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class AgentInfoManagerTest extends BaseManagerTestCase {
    private final String agentInfoId = "1";
    private AgentInfoManagerImpl agentInfoManager = new AgentInfoManagerImpl();
    private Mock agentInfoDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        agentInfoDao = new Mock(AgentInfoDao.class);
        agentInfoManager.setAgentInfoDao((AgentInfoDao) agentInfoDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        agentInfoManager = null;
    }

    public void testGetAgentInfos() throws Exception {
        List results = new ArrayList();
        AgentInfo agentInfo = new AgentInfo();
        results.add(agentInfo);

        // set expected behavior on dao
        agentInfoDao.expects(once()).method("getAgentInfos")
            .will(returnValue(results));

        List agentInfos = agentInfoManager.getAgentInfos(null);
        assertTrue(agentInfos.size() == 1);
        agentInfoDao.verify();
    }

    public void testGetAgentInfo() throws Exception {
        // set expected behavior on dao
        agentInfoDao.expects(once()).method("getAgentInfo")
            .will(returnValue(new AgentInfo()));
        AgentInfo agentInfo = agentInfoManager.getAgentInfo(agentInfoId);
        assertTrue(agentInfo != null);
        agentInfoDao.verify();
    }

    public void testSaveAgentInfo() throws Exception {
        AgentInfo agentInfo = new AgentInfo();

        // set expected behavior on dao
        agentInfoDao.expects(once()).method("saveAgentInfo")
            .with(same(agentInfo)).isVoid();

        agentInfoManager.saveAgentInfo(agentInfo);
        agentInfoDao.verify();
    }

    public void testAddAndRemoveAgentInfo() throws Exception {
        AgentInfo agentInfo = new AgentInfo();

        // set required fields

        // set expected behavior on dao
        agentInfoDao.expects(once()).method("saveAgentInfo")
            .with(same(agentInfo)).isVoid();
        agentInfoManager.saveAgentInfo(agentInfo);
        agentInfoDao.verify();

        // reset expectations
        agentInfoDao.reset();

        agentInfoDao.expects(once()).method("removeAgentInfo").with(eq(new Long(agentInfoId)));
        agentInfoManager.removeAgentInfo(agentInfoId);
        agentInfoDao.verify();

        // reset expectations
        agentInfoDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(AgentInfo.class, agentInfo.getId());
        agentInfoDao.expects(once()).method("removeAgentInfo").isVoid();
        agentInfoDao.expects(once()).method("getAgentInfo").will(throwException(ex));
        agentInfoManager.removeAgentInfo(agentInfoId);
        try {
            agentInfoManager.getAgentInfo(agentInfoId);
            fail("AgentInfo with identifier '" + agentInfoId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        agentInfoDao.verify();
    }
}
