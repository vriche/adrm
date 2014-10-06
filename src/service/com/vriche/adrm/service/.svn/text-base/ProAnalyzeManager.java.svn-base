/**
 * 
 */
package com.vriche.adrm.service;

import java.util.Collection;
import java.util.List;

import com.vriche.adrm.model.FusionChartObject;
import com.vriche.adrm.model.ParamClass;

/**
 * @author vriche
 *
 */
public interface ProAnalyzeManager extends Manager{
	
	public String getCostByProgramName(ParamClass paramClass,String pageIndex, String pageSize);

//	public List getProAudienceAnalyzes(ParamClass paramClass);
//	public String getProAudienceAnalyzeCount(ParamClass paramClass);
	
	public List getProCostAnalyzes(ParamClass paramClass);
	public String getProCostAnalyzeCount(ParamClass paramClass);
	
	public String getProAudienceAnalyzeList(ParamClass paramClass);

	public String getProIncomeAnalyzeList1(ParamClass paramClass,String pageIndex,String pageSize);
	public String getProIncomeAnalyzeList(ParamClass paramClass);
	public String getProIncomeAnalyzeCount(ParamClass paramClass);
	
    public Collection getCollectionsByCostAnalyze(final String queryString,String type);
    
    public FusionChartObject[] getProgramChartObjsByCostAnalyze(String queryString);
    
    public Collection getCollectionsByProgramAudienceRate(final String queryString,String type);
    
    public FusionChartObject[] getProgramChartObjsByProgramAudienceRate(String queryString);

    public Collection getCollectionsByIncome(final String queryString,String type);
    
    public FusionChartObject[] getProgramChartObjsByIncome(String queryString);
    
    public Collection getCollectionsByCostIncomeAudience(final String queryString,String type);
    
    public FusionChartObject[] getProgramChartObjsByCostIncomeAudience(String queryString);
    
    public String getCostIncomeAudienceAnalyzeList(ParamClass paramClass);
    public List getTotalMoneyList(ParamClass paramClass);
}
