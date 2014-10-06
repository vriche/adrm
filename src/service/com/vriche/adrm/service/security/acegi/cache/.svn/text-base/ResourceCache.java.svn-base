/****************************************************************************     
 * Created on 2007-4-28                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.service.security.acegi.cache;

import java.util.List;

import com.vriche.adrm.service.security.acegi.resource.ResourceDetails;
/**
 * 为 {@link org.springside.components.acegi.resource.Resource} 实例提供缓存.
 * @author cac
 *
 */
public interface ResourceCache {
	
	public ResourceDetails getResourceFromCache(String resString);
	
	public void putResourceInCache(ResourceDetails resourceDetails);
	
	public void removeResourceFromCache(String resString);
	
	public List getAllResources();

	public void removeAllResources();

}
