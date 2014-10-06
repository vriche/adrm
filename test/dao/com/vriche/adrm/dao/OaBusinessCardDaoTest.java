package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaBusinessCard;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaBusinessCardDaoTest extends BaseDaoTestCase {
    private Long oaBusinessCardId = new Long("1");
    private OaBusinessCardDao dao = null;

    public void setOaBusinessCardDao(OaBusinessCardDao dao) {
        this.dao = dao;
    }

    public void testAddOaBusinessCard() throws Exception {
        OaBusinessCard oaBusinessCard = new OaBusinessCard();

        // set required fields

        dao.saveOaBusinessCard(oaBusinessCard);

        // verify a primary key was assigned
        assertNotNull(oaBusinessCard.getId());

        // verify set fields are same after save
    }

    public void testGetOaBusinessCard() throws Exception {
        OaBusinessCard oaBusinessCard = dao.getOaBusinessCard(oaBusinessCardId);
        assertNotNull(oaBusinessCard);
    }

    public void testGetOaBusinessCards() throws Exception {
        OaBusinessCard oaBusinessCard = new OaBusinessCard();

        List results = dao.getOaBusinessCards(oaBusinessCard);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaBusinessCard() throws Exception {
        OaBusinessCard oaBusinessCard = dao.getOaBusinessCard(oaBusinessCardId);

        // update required fields

        dao.saveOaBusinessCard(oaBusinessCard);

    }

    public void testRemoveOaBusinessCard() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaBusinessCard(removeId);
        try {
            dao.getOaBusinessCard(removeId);
            fail("oaBusinessCard found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaBusinessCards(final Map idList) throws Exception {
        try {
        	dao.removeOaBusinessCards(idList);
            fail("oaBusinessCard found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
