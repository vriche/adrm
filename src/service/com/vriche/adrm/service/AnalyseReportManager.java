package com.vriche.adrm.service;

import java.util.Collection;

import com.vriche.adrm.model.AnalyzeClass;

public interface AnalyseReportManager extends Manager{
	public Collection getCutReport(AnalyzeClass analyzeClass);
	public Collection getCutYearReport(AnalyzeClass analyzeClass);
	public Collection getBussinessReport(AnalyzeClass analyzeClass);
	public Collection getIncomeChannelReport(AnalyzeClass analyzeClass);
	public Collection getIncomeDetailReport(AnalyzeClass analyzeClass);
	public Collection getCarrierReport(AnalyzeClass analyzeClass);
	
	public Collection getBrandReport(AnalyzeClass analyzeClass);
	public Collection getResourceAdverReport(AnalyzeClass analyzeClass);

}
