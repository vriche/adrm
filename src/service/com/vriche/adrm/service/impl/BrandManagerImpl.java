
package com.vriche.adrm.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.dao.BrandDao;
import com.vriche.adrm.model.Brand;
import com.vriche.adrm.service.BrandManager;
import com.vriche.adrm.service.impl.BaseManager;
import com.vriche.adrm.util.GetFirstLetter;
import com.vriche.adrm.util.StringUtil;

public class BrandManagerImpl extends BaseManager implements BrandManager {
    private BrandDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setBrandDao(BrandDao dao) {
        this.dao = dao;
    }

    /**
     * @see com.vriche.adrm.adver.service.BrandManager#getBrandsByIdList(final Map idList)
     */
    public List getBrandsByIdList(final Map idList) {
        return dao.getBrandsByIdList(idList);
    }
   /**
     * @see com.vriche.adrm.adver.service.BrandManager#getBrands(com.vriche.adrm.adver.model.Brand)
     */
    public List getBrands(final Brand brand) {
        return dao.getBrands(brand);
    }

    /**
     * @see com.vriche.adrm.adver.service.BrandManager#getBrand(String id)
     */
    public Brand getBrand(final String id) {
        return dao.getBrand(new Long(id));
    }

    /**
     * @see com.vriche.adrm.adver.service.BrandManager#saveBrand(Brand brand)
     */
    public void saveBrand(Brand brand) {
    	String helpCode = brand.getHelpCode();
    	if(StringUtils.isEmpty(helpCode)){
    		 helpCode = GetFirstLetter.getPinYinHeadChar(brand.getName());
    		 brand.setHelpCode(helpCode);
    	}
    	
        dao.saveBrand(brand);
    }

    /**
     * @see com.vriche.adrm.adver.service.BrandManager#removeBrand(String id)
     */
    public void removeBrand(final String id) {
        dao.removeBrand(new Long(id));
    }

     /**
     * @see com.vriche.adrm.adver.service.BrandManager#removeBrands(String Map)
     */
    public void removeBrands(final Map idList) {
        dao.removeBrands(idList);
    }

	public PaginatedList getBrandsPage(Brand brand, String pageIndex, String pageSize) {
		// TODO Auto-generated method stub
		return dao.getBrandsPage(brand,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}

	public String getBrandsCount(Brand brand) {
		// TODO Auto-generated method stub
		return dao.getBrandsCount(brand).toString();
	}


	public void saveBrandHelpCode() {
		String name = "";
		String helpCodeName = "";
		long id = 0;
		int curVer =32;
//		String rep ="\n\r\t";

		try {
			ResultSet rsOrg = dao.getDefaultDataSource().getConnection().createStatement().executeQuery("select adver_product_brand_id,name from tb_adver_product_brand where adver_product_brand_id>0");

			while (rsOrg.next()){	
				id = rsOrg.getLong("adver_product_brand_id");
				name = StringUtil.getNullValue(rsOrg.getString("name"),"");
				helpCodeName = GetFirstLetter.getPinYinHeadChar(name);
			
				String sql ="update tb_adver_product_brand set help_code ='"+ helpCodeName +"'  where adver_product_brand_id=" + id +"";
				System.out.println("mody_brand_helpcode>>>"+ helpCodeName +">>>"+sql);
				try {
					dao.getDefaultDataSource().getConnection().createStatement().execute(sql);
				} catch (SQLException e) {
					 System.out.println(sql+"/n;系统数据库升级到"+ curVer +"失败");
//					e.printStackTrace();
				}
			}
			rsOrg.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}    
}
