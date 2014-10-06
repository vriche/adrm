package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.CarrierType;
import com.vriche.adrm.dao.CarrierTypeDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class CarrierTypeDaoTest extends BaseDaoTestCase {
    private String carrierTypeId = new String("1");
    private CarrierTypeDao dao = null;

    public void setCarrierTypeDao(CarrierTypeDao dao) {
        this.dao = dao;
    }

    public void testAddCarrierType() throws Exception {
        CarrierType carrierType = new CarrierType();

        // set required fields

        java.lang.String name = "HhAtTyPwQuPhItIeIoIjBxZqEfZmKpNkXqUyBeSlRwLfPxMqLaUxJsWtOeXuHwIoVnSrTsHzEuCoJmVqRzGgUcPfVlUaGoSkMxPsQzOcCtRdDoRrEgSrFmEqMzKtStFl";
        carrierType.setName(name);        

        dao.saveCarrierType(carrierType);

        // verify a primary key was assigned
        assertNotNull(carrierType.getId());

        // verify set fields are same after save
        assertEquals(name, carrierType.getName());
    }

    public void testGetCarrierType() throws Exception {
        CarrierType carrierType = dao.getCarrierType(carrierTypeId);
        assertNotNull(carrierType);
    }

    public void testGetCarrierTypes() throws Exception {
        CarrierType carrierType = new CarrierType();

        List results = dao.getCarrierTypes(carrierType);
        assertTrue(results.size() > 0);
    }

    public void testSaveCarrierType() throws Exception {
        CarrierType carrierType = dao.getCarrierType(carrierTypeId);

        // update required fields
        java.lang.String name = "DjIrIpWfPlAiJxYtGwUjHqUmIxLpUkHfXxBxNmEkRwWuBbCkFkHzLpHmPrUpHdYyEhOzOqErQmQrMaMoEaIuWzPsHzWaFjWxGgUaFxPhIhFwJsZxPlJoCmTjVjYhPoJk";
        carrierType.setName(name);        

        dao.saveCarrierType(carrierType);

        assertEquals(name, carrierType.getName());
    }

    public void testRemoveCarrierType() throws Exception {
        String removeId = new String("3");
        dao.removeCarrierType(removeId);
        try {
            dao.getCarrierType(removeId);
            fail("carrierType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveCarrierTypes(final Map idList) throws Exception {
        try {
        	dao.removeCarrierTypes(idList);
            fail("carrierType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
