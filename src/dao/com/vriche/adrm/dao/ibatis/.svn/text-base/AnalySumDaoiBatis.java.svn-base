package com.vriche.adrm.dao.ibatis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.vriche.adrm.dao.AnalySumDao;

public class AnalySumDaoiBatis extends BaseDaoiBATIS implements AnalySumDao {



	public List getStatisticSum(Map mp) {
		return getSqlMapClientTemplate().queryForList("getStatisticSum", mp);
	}
}
