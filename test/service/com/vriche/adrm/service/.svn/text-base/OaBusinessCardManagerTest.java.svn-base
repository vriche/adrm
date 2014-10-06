
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaBusinessCardDao;
import com.vriche.adrm.model.OaBusinessCard;
import com.vriche.adrm.service.impl.OaBusinessCardManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaBusinessCardManagerTest extends BaseManagerTestCase {
    private final String oaBusinessCardId = "1";
    private OaBusinessCardManagerImpl oaBusinessCardManager = new OaBusinessCardManagerImpl();
    private Mock oaBusinessCardDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaBusinessCardDao = new Mock(OaBusinessCardDao.class);
        oaBusinessCardManager.setOaBusinessCardDao((OaBusinessCardDao) oaBusinessCardDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaBusinessCardManager = null;
    }

    public void testGetOaBusinessCards() throws Exception {
        List results = new ArrayList();
        OaBusinessCard oaBusinessCard = new OaBusinessCard();
        results.add(oaBusinessCard);

        // set expected behavior on dao
        oaBusinessCardDao.expects(once()).method("getOaBusinessCards")
            .will(returnValue(results));

        List oaBusinessCards = oaBusinessCardManager.getOaBusinessCards(null);
        assertTrue(oaBusinessCards.size() == 1);
        oaBusinessCardDao.verify();
    }

    public void testGetOaBusinessCard() throws Exception {
        // set expected behavior on dao
        oaBusinessCardDao.expects(once()).method("getOaBusinessCard")
            .will(returnValue(new OaBusinessCard()));
        OaBusinessCard oaBusinessCard = oaBusinessCardManager.getOaBusinessCard(oaBusinessCardId);
        assertTrue(oaBusinessCard != null);
        oaBusinessCardDao.verify();
    }

    public void testSaveOaBusinessCard() throws Exception {
        OaBusinessCard oaBusinessCard = new OaBusinessCard();

        // set expected behavior on dao
        oaBusinessCardDao.expects(once()).method("saveOaBusinessCard")
            .with(same(oaBusinessCard)).isVoid();

        oaBusinessCardManager.saveOaBusinessCard(oaBusinessCard);
        oaBusinessCardDao.verify();
    }

    public void testAddAndRemoveOaBusinessCard() throws Exception {
        OaBusinessCard oaBusinessCard = new OaBusinessCard();

        // set required fields

        // set expected behavior on dao
        oaBusinessCardDao.expects(once()).method("saveOaBusinessCard")
            .with(same(oaBusinessCard)).isVoid();
        oaBusinessCardManager.saveOaBusinessCard(oaBusinessCard);
        oaBusinessCardDao.verify();

        // reset expectations
        oaBusinessCardDao.reset();

        oaBusinessCardDao.expects(once()).method("removeOaBusinessCard").with(eq(new Long(oaBusinessCardId)));
        oaBusinessCardManager.removeOaBusinessCard(oaBusinessCardId);
        oaBusinessCardDao.verify();

        // reset expectations
        oaBusinessCardDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaBusinessCard.class, oaBusinessCard.getId());
        oaBusinessCardDao.expects(once()).method("removeOaBusinessCard").isVoid();
        oaBusinessCardDao.expects(once()).method("getOaBusinessCard").will(throwException(ex));
        oaBusinessCardManager.removeOaBusinessCard(oaBusinessCardId);
        try {
            oaBusinessCardManager.getOaBusinessCard(oaBusinessCardId);
            fail("OaBusinessCard with identifier '" + oaBusinessCardId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaBusinessCardDao.verify();
    }
}
