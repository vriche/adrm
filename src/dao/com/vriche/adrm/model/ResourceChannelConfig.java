package com.vriche.adrm.model;

public class ResourceChannelConfig {
	protected Long id;
	protected Long channelId;
	protected String channelCode;
	
	
	protected Integer enable;
    protected Integer sendType;	
    protected String sendAddress;	
    protected String resourceSort;	
    protected Integer sendZeo;
    
    protected String preOne;	
    protected String preTow;
	/**
	 * @return Returns the channelId.
	 */
	public Long getChannelId() {
		return channelId;
	}
	/**
	 * @param channelId The channelId to set.
	 */
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	/**
	 * @return Returns the enable.
	 */
	public Integer getEnable() {
		return enable;
	}
	/**
	 * @param enable The enable to set.
	 */
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	/**
	 * @return Returns the id.
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return Returns the preOne.
	 */
	public String getPreOne() {
		return preOne;
	}
	/**
	 * @param preOne The preOne to set.
	 */
	public void setPreOne(String preOne) {
		this.preOne = preOne;
	}
	/**
	 * @return Returns the preTow.
	 */
	public String getPreTow() {
		return preTow;
	}
	/**
	 * @param preTow The preTow to set.
	 */
	public void setPreTow(String preTow) {
		this.preTow = preTow;
	}
	/**
	 * @return Returns the resourceSort.
	 */
	public String getResourceSort() {
		return resourceSort;
	}
	/**
	 * @param resourceSort The resourceSort to set.
	 */
	public void setResourceSort(String resourceSort) {
		this.resourceSort = resourceSort;
	}
	/**
	 * @return Returns the sendAddress.
	 */
	public String getSendAddress() {
		return sendAddress;
	}
	/**
	 * @param sendAddress The sendAddress to set.
	 */
	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}
	/**
	 * @return Returns the sendType.
	 */
	public Integer getSendType() {
		return sendType;
	}
	/**
	 * @param sendType The sendType to set.
	 */
	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}
	/**
	 * @return Returns the sendZeo.
	 */
	public Integer getSendZeo() {
		return sendZeo;
	}
	/**
	 * @param sendZeo The sendZeo to set.
	 */
	public void setSendZeo(Integer sendZeo) {
		this.sendZeo = sendZeo;
	}
	/**
	 * @return Returns the channelCode.
	 */
	public String getChannelCode() {
		return channelCode;
	}
	/**
	 * @param channelCode The channelCode to set.
	 */
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}	

    
}
