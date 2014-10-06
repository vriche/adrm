package com.vriche.adrm.util;



import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.GenericValidator;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.Constants;

public class Page {
	  
	private Integer size;
	private Integer pageSize;
	private Integer pageIndex;
	private boolean isEmpty;
	private boolean isFirstPage;
	private boolean isLastPage;
	private boolean isPreviousPageAvailable;
	private boolean isNextPageAvailable;
	private int totalPage;
	private String pageIndexName;
	

	public Page(){}
	 
	public Page(PaginatedList paginatedList){
		this.setPage(paginatedList);
	}
	
	public Page(String displayTableName,HttpServletRequest request){
		this.setPageByDisplayTag(displayTableName,request);
	}
	
	public boolean getIsFirstPage() {
		return isFirstPage;
	}
	public void setIsFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}
	public boolean getIsLastPage() {
		return isLastPage;
	}
	public void setIsLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}
	public boolean getIsNextPageAvailable() {
		return isNextPageAvailable;
	}
	public void setIsNextPageAvailable(boolean isNextPageAvailable) {
		this.isNextPageAvailable = isNextPageAvailable;
	}
	public boolean getIsPreviousPageAvailable() {
		return isPreviousPageAvailable;
	}
	public void setIsPreviousPageAvailable(boolean isPreviousPageAvailable) {
		this.isPreviousPageAvailable = isPreviousPageAvailable;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public boolean getIsEmpty() {
		return isEmpty;
	}
	public void setIsEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public String getPageIndexName() {
		return pageIndexName;
	}

	public void setPageIndexName(String pageIndexName) {
		this.pageIndexName = pageIndexName;
	}
	
	public void setPage(PaginatedList paginatedList) {
		this.setSize(new Integer(paginatedList.size()));
		this.setPageSize(new Integer(paginatedList.getPageSize()));
		this.setIsPreviousPageAvailable(paginatedList.isPreviousPageAvailable());
		this.setIsNextPageAvailable(paginatedList.isNextPageAvailable());
		this.setIsFirstPage(paginatedList.isFirstPage());
		this.setIsLastPage(paginatedList.isLastPage());
		this.setIsEmpty(paginatedList.isEmpty());
		this.setTotalPage(paginatedList.size()/paginatedList.getPageSize());
		
//		System.out.println("size" + paginatedList.size());
//		System.out.println("getPageSize" + paginatedList.getPageSize());
//		System.out.println("getPageIndex" + paginatedList.getPageIndex());
//		System.out.println("getPageSize" + paginatedList.getPageIndex());
	}
	
	public void setPageByDisplayTag(String displayTableName,HttpServletRequest request){
        // 页数的参数名
        String pageIndexName = new org.displaytag.util.ParamEncoder(displayTableName).encodeParameterName(org.displaytag.tags.TableTagParameters.PARAMETER_PAGE);		
        int pageSize = GenericValidator.isBlankOrNull(request.getParameter("PAGE_SIZE"))?0:(Integer.parseInt(request.getParameter("PAGE_SIZE")));
        int pageIndex = GenericValidator.isBlankOrNull(request.getParameter(pageIndexName))?0:(Integer.parseInt(request.getParameter(pageIndexName))-1);   


//        System.out.println("pageIndexName>>>>>>>>>>>" + pageIndexName);
//        System.out.println("pageIndex>>>>>>>>>>>" + pageIndex);		
//        System.out.println("pageSize>>>>>>>>>>>" + request.getParameter("pagesize"));		
        
        this.setPageIndex(new Integer(pageIndex));
        this.setPageSize(new Integer("9"));
        this.setPageIndexName(pageIndexName);
	}




}
