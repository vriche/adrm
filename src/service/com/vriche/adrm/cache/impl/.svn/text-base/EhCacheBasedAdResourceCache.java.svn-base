package com.vriche.adrm.cache.impl;

import java.util.List;
import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataRetrievalFailureException;

import com.vriche.adrm.Constants;
import com.vriche.adrm.cache.AdResourceCache;
import com.vriche.adrm.model.Resource;


public class EhCacheBasedAdResourceCache implements AdResourceCache {

//	 ~ Static fields/initializers
	// =============================================

	private static final Log logger = LogFactory.getLog(EhCacheBasedAdResourceCache.class);
	
	private static final String key = Constants.AVAILABLE_RESOURCE_MAP;

	// ~ Instance fields
	// ========================================================

	Cache cache;

	// ~ Methods
	// ================================================================

	public void setCache(Cache cache) {
		this.cache = cache;
	}

	public Cache getCache() {
		return this.cache;
	}

	/* (non-Javadoc)
	 * @see org.springside.components.acegi.cache.ResourceCache#getResourceFromCache(java.lang.String)
	 */
	public Map getResourceFromCache() {
		Element element = null;

		try {
			element = cache.get(key);
		} catch (CacheException cacheException) {
			throw new DataRetrievalFailureException("Cache failure: "
					+ cacheException.getMessage(), cacheException);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Cache hit: " + (element != null) + "; resString: " + key);
		}

		if (element == null) {
			return null;
		} else {
			return (Map) element.getValue();
		}
	}
	
	public Resource getResourceFromCache(String id) {
		Element element = null;

		try {
			element = cache.get(id);
		} catch (CacheException cacheException) {
			throw new DataRetrievalFailureException("Cache failure: "
					+ cacheException.getMessage(), cacheException);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("Cache hit: " + (element != null) + "; resString: "
					+ id);
		}

		if (element == null) {
			return null;
		} else {
			return (Resource) element.getValue();
		}
	}

	/* (non-Javadoc)
	 * @see org.springside.components.acegi.cache.ResourceCache#putResourceInCache(org.springside.components.acegi.model.ResourceDetails)
	 */
	public void putResourceInCache(Resource resource) {
		Element element = new Element(resource.getId(),resource);
		if (logger.isDebugEnabled()) {
			logger.debug("Cache put: " + element.getKey());
		}
//		logger.info("Cache put: " + element.getKey());
		
		this.cache.put(element);
	}
	
	public void putResourceInCache(Map mp) {
		Element element = new Element(key,mp);
		if (logger.isDebugEnabled()) {
			logger.debug("Cache put: " + element.getKey());
		}
//		logger.info("Cache put: " + element.getKey());
		
		this.cache.put(element);
	}

	/* (non-Javadoc)
	 * @see org.springside.components.acegi.cache.ResourceCache#removeResourceFromCache(java.lang.String)
	 */
	public void removeResourceFromCache(String key) {
		if (logger.isDebugEnabled()) {
			logger.debug("Cache remove: " + key);
		}
		this.cache.remove(key);
	}

	public List getAllResources() {
		return this.cache.getKeys();
	}
	
	public void removeAllResources() {
		this.cache.removeAll();
	}

}
