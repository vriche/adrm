package com.vriche.adrm.service.impl;

import com.vriche.adrm.service.UpdateSystemManager;
import com.vriche.adrm.dao.UpdateSystemDao;


public class UpdateSystemManagerImpl extends BaseManager implements UpdateSystemManager {
	
	private UpdateSystemDao updateSystemDao;

	public void setUpdateSystemDao(UpdateSystemDao updateSystemDao) {
		this.updateSystemDao = updateSystemDao;
	}

	public void excuteSqlMermDB() {
		updateSystemDao.excuteUpdate11();
	}
	public void excuteSqlDistanceDB() {
		updateSystemDao.excuteUpdate12();
	}

	public void excuteSqlClearDataDB() {
		updateSystemDao.excuteUpdate13();
	}
	
	public void excuteSqlClearDataDBorder() {
		updateSystemDao.excuteUpdate13_1();
	}

	public void excuteSqlTransferDataDB() {
		updateSystemDao.excuteUpdate14();
	}
}
