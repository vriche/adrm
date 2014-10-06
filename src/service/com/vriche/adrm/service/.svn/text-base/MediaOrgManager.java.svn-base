package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.MediaOrgDao;
import com.vriche.adrm.model.MediaOrg;
import com.vriche.adrm.service.Manager;

public interface MediaOrgManager extends Manager {

	/**
	 * Setter for DAO, convenient for unit testing
	 */
	public void setMediaOrgDao(MediaOrgDao mediaOrgDAO);

	/**
	 * Retrieves all of the mediaOrgs
	 */
	public List getMediaOrgs(MediaOrg mediaOrg);

	/**
	 * Retrieves all of the mediaOrgsByIdList
	 */
	public List getMediaOrgsByIdList(final Map idList);

	/**
	 * Gets mediaOrg's information based on id.
	 * 
	 * @param id
	 *            the mediaOrg's id
	 * @return mediaOrg populated mediaOrg object
	 */
	public MediaOrg getMediaOrg(final String id);

	/**
	 * Saves a mediaOrg's information
	 * 
	 * @param mediaOrg
	 *            the object to be saved
	 */
	public void saveMediaOrg(MediaOrg mediaOrg);

	/**
	 * Removes a mediaOrg from the database by id
	 * 
	 * @param id
	 *            the mediaOrg's id
	 */
	public void removeMediaOrg(final String id);

	/**
	 * Removes a mediaOrg from the database by id
	 * 
	 * @param idList
	 */
	public void removeMediaOrgs(final Map idList);
	
	 public Map getMediaOrgsSelectItem(MediaOrg mediaOrg);
}
