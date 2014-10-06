package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.AgentInfo;
import com.vriche.adrm.dao.AgentInfoDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class AgentInfoDaoTest extends BaseDaoTestCase {
    private Long agentInfoId = new Long("1");
    private AgentInfoDao dao = null;

    public void setAgentInfoDao(AgentInfoDao dao) {
        this.dao = dao;
    }

    
    public void testAddAgentInfo() throws Exception {
        AgentInfo agentInfo = new AgentInfo();

        // set required fields

        dao.saveAgentInfo(agentInfo);

        // verify a primary key was assigned
        assertNotNull(agentInfo.getId());

        // verify set fields are same after save
    }

    public void testGetAgentInfo() throws Exception {
        AgentInfo agentInfo = dao.getAgentInfo(agentInfoId);
        assertNotNull(agentInfo);
    }

    public void testGetAgentInfos() throws Exception {
        AgentInfo agentInfo = new AgentInfo();

        List results = dao.getAgentInfos(agentInfo);
        assertTrue(results.size() > 0);
    }

    public void testSaveAgentInfo() throws Exception {
        AgentInfo agentInfo = dao.getAgentInfo(agentInfoId);

        // update required fields

        dao.saveAgentInfo(agentInfo);

    }

    public void testRemoveAgentInfo() throws Exception {
        Long removeId = new Long("3");
        dao.removeAgentInfo(removeId);
        try {
            dao.getAgentInfo(removeId);
            fail("agentInfo found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveAgentInfos(final Map idList) throws Exception {
        try {
        	dao.removeAgentInfos(idList);
            fail("agentInfo found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
