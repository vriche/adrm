package com.vriche.adrm.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.labels.StandardPieItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.BarRenderer;
import org.jfree.chart.renderer.BarRenderer3D;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.data.DefaultCategoryDataset;
import org.jfree.data.DefaultPieDataset;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.AnalyDao;
import com.vriche.adrm.dao.OaTeleExpensesDao;
import com.vriche.adrm.dao.OrderDayInfoDao;
import com.vriche.adrm.dao.OrderDetailDao;
import com.vriche.adrm.model.AnalyzeClass;
import com.vriche.adrm.model.CustomerProduct;
import com.vriche.adrm.model.OaTeleExpenses;
import com.vriche.adrm.model.OrderDayInfo;
import com.vriche.adrm.model.User;
import com.vriche.adrm.service.AnalyCarrierMatterManager;
import com.vriche.adrm.service.CarrierManager;
import com.vriche.adrm.service.JFreeChartService;
import com.vriche.adrm.service.OrderDayInfoManager;
import com.vriche.adrm.service.OrderDetailManager;
import com.vriche.adrm.service.UserManager;


public class JFreeChartServiceImpl  extends BaseManager implements JFreeChartService{
	
	private OrderDayInfoDao orderDayInfoDao;
	private OrderDayInfoManager orderDayInfoManager;
	private OrderDetailManager orderDetailManager;
	private OrderDetailDao orderDetailDao;
	private UserManager userManager;
	private CarrierManager carrierManager;
	private AnalyCarrierMatterManager analyCarrierMatterManager;
	
	private OaTeleExpensesDao oaTeleExpensesDao;
	
	/** 
	 * @param orderDayInfoDao The orderDayInfoDao to set.
	 */
	public void setOrderDayInfoDao(OrderDayInfoDao orderDayInfoDao) {
		this.orderDayInfoDao = orderDayInfoDao;
	}
	
	public void setOrderDayInfoManager(OrderDayInfoManager orderDayInfoManager) {
		this.orderDayInfoManager = orderDayInfoManager;
	}

	public void setOrderDetailDao(OrderDetailDao orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}

	public void setOrderDetailManager(OrderDetailManager orderDetailManager) {
		this.orderDetailManager = orderDetailManager;
	}


	public void setOaTeleExpensesDao(OaTeleExpensesDao oaTeleExpensesDao) {
		this.oaTeleExpensesDao = oaTeleExpensesDao;
	}
	
	
	public void setAnalyCarrierMatterManager(AnalyCarrierMatterManager analyCarrierMatterManager) {
		this.analyCarrierMatterManager = analyCarrierMatterManager;
	}

	/** 
	 * ï¿½Í»ï¿½Í³ï¿½ï¿½----ï¿½ï¿½ï¿½ï¿½Ñ¯.
	 */	
	public ArrayList getDataByBeginAndEndDate(String sysUser,String channelModelParam,String startDate, String endDate,String userId,String carrierName,String customerId){
		
		ArrayList results = new ArrayList();
		List carrierIdList = new ArrayList();
		
		
		try{

//			System.out.println(">>>>> 2  "+userId+"  x "+carrierName);	
			Map mp =new HashMap();
			List userIdList = new ArrayList();
			mp.put("startDate",startDate);
			mp.put("endDate",endDate);
			//mp.put("parentId",carrierName);
		

//			ÅÐ¶ÏÊÇ·ñ·ÖÆµµÀ£¬ÖµÎª1·Ö£¬·ñÔò²»·Ö
			boolean channelPull = false;
			int channelMode = Integer.parseInt(channelModelParam);
			if(channelMode==1){
				 channelPull = true;
				}
			
			carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,sysUser);
			mp.put("carrierIdList",carrierIdList);


			
//			System.out.println(">>>>>>  "+customerId.equals("null"));
		
			if(!customerId.equals("null"))
			    mp.put("customerId",customerId);
			
			if((!"".equals(userId) &&  userId!=null)){
	    		List userls = new ArrayList();
	    		userls.add(userId);
	    		mp.put("UserIdList",userls);
	    	}else{
	    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
	    		
//	    		List ls = userManager.getOwnerUsersList(userRelsMap);
	    		List ls = (List)userRelsMap.get(sysUser);
	    		for(Iterator it=ls.iterator();it.hasNext();){
	    			User user = (User)it.next();
	    			userIdList.add(user.getId());
	    		}
	    		mp.put("UserIdList",userIdList);
	    	}
			
			List list = orderDayInfoDao.getCustomerRelIncome(mp);
//			System.out.println(">>>>> 2  "+list.size());	
			for(Iterator it = list.iterator();it.hasNext();){
				OrderDayInfo orderdayInfo = (OrderDayInfo) it.next();
										
				results.add(orderdayInfo);

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return results;
	}
	
	public String customerAnalyzeChart(String sysUser,String channelModelParam,String startDate,String endDate,String userId,String carrierName,String customerId,  HttpSession session, PrintWriter pw) {

		String filename = null;

//		System.out.println(">>>>> 2  "+userId+"  y "+carrierName);	
		try {
			ArrayList list = getDataByBeginAndEndDate(sysUser,channelModelParam,startDate,endDate,userId,carrierName,customerId);
//			System.out.println(">>>>>   "+list.size());
			Iterator it = list.iterator();
			
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						
            while (it.hasNext()) {
            	OrderDayInfo orderdayInfo = (OrderDayInfo) it.next();
            	if(orderdayInfo.getCustomer().getCustomerName().length()>6)  {         	
            		dataset.addValue(orderdayInfo.getDayRelIncome(), "Hits",orderdayInfo.getCustomer().getCustomerName().substring(0,6));
            	}else{
            		dataset.addValue(orderdayInfo.getDayRelIncome(), "Hits",orderdayInfo.getCustomer().getCustomerName());
            	}	
            }
            
            

			//  Create the chart object
			CategoryAxis categoryAxis = new CategoryAxis("");
			ValueAxis valueAxis = new NumberAxis("");
			BarRenderer3D renderer = new BarRenderer3D();
			renderer.setItemURLGenerator(new StandardCategoryURLGenerator("customerAnalyze.jsp","series","section"));
			
			
            renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());
            

			Plot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
			
			//Font font = new Font("SansSerif",JFreeChart.DEFAULT_TITLE_FONT.BOLD,1);
			
			JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
//			System.out.println("   >>>>   "+JFreeChart.DEFAULT_TITLE_FONT);
			chart.setBackgroundPaint(java.awt.Color.white);

			//  Write the chart image to the temporary directory
			ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, 900, 350, info, session);

			//  Write the image map to the PrintWriter
			ChartUtilities.writeImageMap(pw, filename, info);
			pw.flush();
						
		}catch(Exception e){
//            System.out.println("Exception - " + e.toString());
            e.printStackTrace(System.out);
            filename = "public_error_500x300.png";
		}
					
		return filename;
	}
	
	public String customerAnalyzeChartTime(String sysUser,String channelModelParam,String startDate,String endDate,String userId,String carrierName,String customerId, HttpSession session, PrintWriter pw) {

		String filename = null;
		
		try {

			ArrayList list = getDataByBeginAndEndDate(sysUser,channelModelParam,startDate,endDate,userId,carrierName,customerId);
//			System.out.println(">>>> 3  "+list.size());
			Iterator it = list.iterator();
			
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						
            while (it.hasNext()) {
            	OrderDayInfo orderdayInfo = (OrderDayInfo) it.next();
            	            	
            	dataset.addValue(orderdayInfo.getAdSumTimes(), "Hits",orderdayInfo.getCustomer().getCustomerName());
            }
            
            

			//  Create the chart object
			CategoryAxis categoryAxis = new CategoryAxis("");
			ValueAxis valueAxis = new NumberAxis("");
			//valueAxis.setAutoRangeMinimumSize(200000);
			BarRenderer3D renderer = new BarRenderer3D();
			renderer.setItemURLGenerator(new StandardCategoryURLGenerator("customerAnalyze.jsp","series","section"));
			
			
            renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

			Plot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
			JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
			chart.setBackgroundPaint(java.awt.Color.white);

			//  Write the chart image to the temporary directory
			ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, 900, 350, info, session);

			//  Write the image map to the PrintWriter
			ChartUtilities.writeImageMap(pw, filename, info);
			pw.flush();
						
		}catch(Exception e){
//            System.out.println("Exception - " + e.toString());
            e.printStackTrace(System.out);
            filename = "public_error_500x300.png";
		}
					
		return filename;
	}

	/** 
	 * ï¿½Í»ï¿½Í³ï¿½ï¿½----È«ï¿½ï¿½ï¿½Ñ?.
	 */	
	
	public ArrayList getDateByYearAndCustomerIds(String sysUser,String channel,String year, String[] customerIds,String userId,String carrierName) {
		
		ArrayList results = new ArrayList();
		List userIdList = new ArrayList();
		List carrierIdList = new ArrayList();
		try{
			Map map = new HashMap();
			map.put("year", year);
			map.put("CustomerIdList", customerIds);
			//map.put("parentId",carrierName);
			
            int channelMod = Integer.parseInt(channel);
//			ÅÐ¶ÏÊÇ·ñ·ÖÆµµÀ£¬ÖµÎª1·Ö£¬·ñÔò²»·Ö
			boolean channelPull = false;
			
			if(channelMod==1){
				 channelPull = true;
				}
			
			carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,sysUser);
			map.put("carrierIdList",carrierIdList);
			
			
			
			if((!"".equals(userId) &&  userId!=null)){
	    		List userls = new ArrayList();
	    		userls.add(userId);
	    		map.put("UserIdList",userls);
	    	}else{
	    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
	    		
//	    		List ls = userManager.getOwnerUsersList(userRelsMap);
	    		 List ls = (List)userRelsMap.get(sysUser);
//	    		System.out.println(">>>>>  1  "+ls.size()) ;
	    		for(Iterator it=ls.iterator();it.hasNext();){
	    			User user = (User)it.next();
	    			userIdList.add(user.getId());
	    		}
	    		map.put("UserIdList",userIdList);
	    	}
			List daoList = orderDayInfoDao.getCustomerByYearPage(map);
			List list = (List) daoList.get(0);
			
			for(Iterator it = list.iterator();it.hasNext();){
				OrderDayInfo orderdayInfo = (OrderDayInfo) it.next();
										
				results.add(orderdayInfo);

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return results;
	}


	public String yearAnalyzeChartIncome(String sysUser,String channel,String year, String[] customerIds,String userId,String carrierName, HttpSession session, PrintWriter pw) {
		
		String filename = null;                                                                                                                                                   
		
		try {

			ArrayList list = getDateByYearAndCustomerIds(sysUser,channel,year,customerIds,userId,carrierName);
			
			Iterator it = list.iterator();
			
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						
            while (it.hasNext()) {
            	OrderDayInfo orderdayInfo = (OrderDayInfo) it.next();
            	dataset.addValue(orderdayInfo.getDayRelIncome(), "Hits",orderdayInfo.getPublishDate().toString().substring(4,6));
            }
            
            

			//  Create the chart object
			CategoryAxis categoryAxis = new CategoryAxis("");
			ValueAxis valueAxis = new NumberAxis("");
			BarRenderer3D renderer = new BarRenderer3D();
			renderer.setItemURLGenerator(new StandardCategoryURLGenerator("yearAnalyze.jsp","series","section"));
			
			
            renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

			Plot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
			JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
			chart.setBackgroundPaint(java.awt.Color.white);

			//  Write the chart image to the temporary directory
			ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info, session);

			//  Write the image map to the PrintWriter
			ChartUtilities.writeImageMap(pw, filename, info);
			pw.flush();
						
		}catch(Exception e){
//            System.out.println("Exception - " + e.toString());
            e.printStackTrace(System.out);
            filename = "public_error_500x300.png";
		}
					
		return filename;
	}

	public String yearAnalyzeChartTime(String sysUser,String channel,String year, String[] customerIds,String userId,String carrierName, HttpSession session, PrintWriter pw) {
		
		String filename = null;
		
		try {

			ArrayList list = getDateByYearAndCustomerIds(sysUser,channel,year,customerIds,userId,carrierName);
			
			Iterator it = list.iterator();
			
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						
            while (it.hasNext()) {
            	OrderDayInfo orderdayInfo = (OrderDayInfo) it.next();
            	dataset.addValue(orderdayInfo.getAdSumTimes(), "Hits",orderdayInfo.getPublishDate().toString().substring(4,6));
            }
            
            

			//  Create the chart object
			CategoryAxis categoryAxis = new CategoryAxis("");
			ValueAxis valueAxis = new NumberAxis("");
			BarRenderer3D renderer = new BarRenderer3D();
			renderer.setItemURLGenerator(new StandardCategoryURLGenerator("yearAnalyze.jsp","series","section"));
			
			
            renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

			Plot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
			JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
			chart.setBackgroundPaint(java.awt.Color.white);

			//  Write the chart image to the temporary directory
			ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info, session);

			//  Write the image map to the PrintWriter
			ChartUtilities.writeImageMap(pw, filename, info);
			pw.flush();

		}catch(Exception e){
//            System.out.println("Exception - " + e.toString());
            e.printStackTrace(System.out);
            filename = "public_error_500x300.png";
		}
					
		return filename;
	}
	public ArrayList getTotalCountByYearAndCustomerIds(String sysUser,String channel,String year, String[] customerIds,String userId,String carrierName) {
		
		ArrayList results = new ArrayList();
		List userIdList = new ArrayList();
		List carrierIdList = new ArrayList();
		try{
			Map map = new HashMap();
			map.put("year", year);
			map.put("CustomerIdList", customerIds);
			//map.put("parentId",carrierName);

//			ÅÐ¶ÏÊÇ·ñ·ÖÆµµÀ£¬ÖµÎª1·Ö£¬·ñÔò²»·Ö
			boolean channelPull = false;
			int channelMod = Integer.parseInt(channel);
			if(channelMod==1){
				 channelPull = true;
				}
			
			carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,sysUser);
			map.put("carrierIdList",carrierIdList);
			
			
			
			
			if((!"".equals(userId) &&  userId!=null)){
	    		List userls = new ArrayList();
	    		userls.add(userId);
	    		map.put("UserIdList",userls);
	    	}else{
	    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
	    		
//	    		List ls = userManager.getOwnerUsersList(userRelsMap);
	    		List ls = (List)userRelsMap.get(sysUser);
//	    		System.out.println(">>>>>  1  "+ls.size()) ;
	    		for(Iterator it=ls.iterator();it.hasNext();){
	    			User user = (User)it.next();
	    			userIdList.add(user.getId());
	    		}
	    		map.put("UserIdList",userIdList);
	    	}
			List daoList = orderDayInfoDao.getCustomerByYearPage(map);
			List list = (List) daoList.get(1);
			
			for(Iterator it = list.iterator();it.hasNext();){
				OrderDayInfo orderdayInfo = (OrderDayInfo) it.next();
										
				results.add(orderdayInfo);

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return results;
	}
	public String yearAnalyzeChartMoneyIn(String sysUser,String channel,String year, String[] customerIds,String userId,String carrierName, HttpSession session, PrintWriter pw) {
		
		String filename = null;
		
		try {

			ArrayList list = getTotalCountByYearAndCustomerIds(sysUser,channel,year,customerIds,userId,carrierName);
			
			Iterator it = list.iterator();
			
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						
            while (it.hasNext()) {
            	OrderDayInfo orderdayInfo = (OrderDayInfo) it.next();
//            	dataset.addValue(Integer.parseInt(orderdayInfo.getToaccountTotal()), "Hits",orderdayInfo.getIncomeDate().toString().substring(4,6));
            	dataset.addValue(Double.parseDouble(orderdayInfo.getToaccountTotal()), "Hits",orderdayInfo.getIncomeDate().toString().substring(4,6));
            }
            

			//  Create the chart object
			CategoryAxis categoryAxis = new CategoryAxis("");
			ValueAxis valueAxis = new NumberAxis("");
			BarRenderer3D renderer = new BarRenderer3D();
			renderer.setItemURLGenerator(new StandardCategoryURLGenerator("yearAnalyze.jsp","series","section"));
			
			
            renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

			Plot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
			JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
			chart.setBackgroundPaint(java.awt.Color.white);

			//  Write the chart image to the temporary directory
			ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info, session);

			//  Write the image map to the PrintWriter
			ChartUtilities.writeImageMap(pw, filename, info);
			pw.flush();
		}catch(Exception e){
//            System.out.println("Exception - " + e.toString());
            e.printStackTrace(System.out);
            filename = "public_error_500x300.png";
		}
					
		return filename;
	}
	

	public ArrayList getDateByYearAndCustomerIdsQuarter(String sysUser,String channel,String year, String[] customerIds,String userId,String carrierName) {
		
		ArrayList results = new ArrayList();
		List userIdList = new ArrayList();
		List carrierIdList = new ArrayList();
		Map mp = new HashMap();
		
		try{
			Map map = new HashMap();
			map.put("year", year);
			map.put("CustomerIdList", customerIds);
			//map.put("parentId",carrierName);
			

//			ÅÐ¶ÏÊÇ·ñ·ÖÆµµÀ£¬ÖµÎª1·Ö£¬·ñÔò²»·Ö
			boolean channelPull = false;
			int channelMode = Integer.parseInt(channel);
			if(channelMode==1){
				 channelPull = true;
				}
			
			carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,sysUser);
			map.put("carrierIdList",carrierIdList);
			
			if((!"".equals(userId) &&  userId!=null)){
	    		List userls = new ArrayList();
	    		userls.add(userId);
	    		map.put("UserIdList",userls);
	    	}else{
	    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
	    		
//	    		List ls = userManager.getOwnerUsersList(userRelsMap);
	    		List ls =(List)userRelsMap.get(sysUser);
//	    		System.out.println(">>>>>  1  "+ls.size()) ;
	    		for(Iterator it=ls.iterator();it.hasNext();){
	    			User user = (User)it.next();
	    			userIdList.add(user.getId());
	    		}
	    		map.put("UserIdList",userIdList);
	    	}
			List daoList = orderDayInfoDao.getCustomerByYearPage(map);
			List list = (List) daoList.get(0);
			

			for (Iterator it = list.iterator(); it.hasNext();) {
				OrderDayInfo orderDayInfo = (OrderDayInfo) it.next();
				int month = Integer.parseInt(orderDayInfo.getPublishDate()
						.toString().substring(4, 6));
				mp.put(new Integer(month), orderDayInfo);
			}
			int k=1;
			double temp[]=new double[4];
			double temp1[]=new double[4];
			for(int j=1;j<5;j++){
				OrderDayInfo orderDayQuarter = new OrderDayInfo();
				int kk=k;
				for (int i = kk; i < kk+3; i++) {
					Object obj = mp.get(new Integer(i));
					if (obj != null ) {
						OrderDayInfo orderDayInfo1 = new OrderDayInfo();
						orderDayInfo1 = (OrderDayInfo)obj;
						temp[0]+=orderDayInfo1.getDayRelPuton().doubleValue();
						temp[1]+=orderDayInfo1.getDayRelIncome().doubleValue();
						temp[2]+=orderDayInfo1.getAdSumTimes().doubleValue();
					}
					k++;
				}
				orderDayQuarter.setPublishDate(new Integer(j));
				orderDayQuarter.setDayRelIncome(new Double(temp[1]));
				orderDayQuarter.setAdSumTimes(new Double(temp[2]));
				orderDayQuarter.setDayRelPuton(new Double(temp[0]));
				results.add(orderDayQuarter);
				for(int i=0;i<temp1.length;i++){
					temp1[i] += temp[i];
					temp[i] = 0;
				}
			}
			
			OrderDayInfo coltotal=new OrderDayInfo();
			coltotal.setPublishDate(new Integer(5));
			coltotal.setDayRelIncome(new Double(temp1[1]));
			coltotal.setAdSumTimes(new Double(temp1[2]));
			coltotal.setDayRelPuton(new Double(temp1[0]));
			results.add(coltotal);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return results;
	}
	
	public String yearAnalyzeChartIncomeQuarter(String sysUser,String channel,String year, String[] customerIds,String userId,String carrierName, HttpSession session, PrintWriter pw) {
		
		String filename = null;                                                                                                                                                   
		
		try {

			ArrayList list = getDateByYearAndCustomerIdsQuarter(sysUser,channel,year,customerIds,userId,carrierName);
			
			Iterator it = list.iterator();
			
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            while (it.hasNext()) {
            	OrderDayInfo orderdayInfo = (OrderDayInfo) it.next();
//				System.out.println(">>  "+orderdayInfo.getPublishDate().toString());
            	dataset.addValue(orderdayInfo.getDayRelIncome(), "Hits",orderdayInfo.getPublishDate().toString().equals("5")?"ï¿½Ï¼ï¿½":orderdayInfo.getPublishDate().toString());
            }
            
            

			//  Create the chart object
			CategoryAxis categoryAxis = new CategoryAxis("");
			ValueAxis valueAxis = new NumberAxis("");
			BarRenderer3D renderer = new BarRenderer3D();
			renderer.setItemURLGenerator(new StandardCategoryURLGenerator("yearAnalyze.jsp","series","section"));
			
			
            renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

			Plot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
			JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
			chart.setBackgroundPaint(java.awt.Color.white);

			//  Write the chart image to the temporary directory
			ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info, session);

			//  Write the image map to the PrintWriter
			ChartUtilities.writeImageMap(pw, filename, info);
			pw.flush();
						
		}catch(Exception e){
//            System.out.println("Exception - " + e.toString());
            e.printStackTrace(System.out);
            filename = "public_error_500x300.png";
		}
					
		return filename;
	}

	public String yearAnalyzeChartTimeQuarter(String sysUser,String channel,String year, String[] customerIds,String userId,String carrierName, HttpSession session, PrintWriter pw) {
		
		String filename = null;
		
		try {

			ArrayList list = getDateByYearAndCustomerIdsQuarter(sysUser,channel,year,customerIds,userId,carrierName);
			
			Iterator it = list.iterator();
			
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						
            while (it.hasNext()) {
            	OrderDayInfo orderdayInfo = (OrderDayInfo) it.next();
            	dataset.addValue(orderdayInfo.getAdSumTimes(), "Hits",orderdayInfo.getPublishDate().toString().equals("5")?"ï¿½Ï¼ï¿½":orderdayInfo.getPublishDate().toString());
            }
            
            

			//  Create the chart object
			CategoryAxis categoryAxis = new CategoryAxis("");
			ValueAxis valueAxis = new NumberAxis("");
			BarRenderer3D renderer = new BarRenderer3D();
			renderer.setItemURLGenerator(new StandardCategoryURLGenerator("yearAnalyze.jsp","series","section"));
			
			
            renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

			Plot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
			JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
			chart.setBackgroundPaint(java.awt.Color.white);

			//  Write the chart image to the temporary directory
			ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info, session);

			//  Write the image map to the PrintWriter
			ChartUtilities.writeImageMap(pw, filename, info);
			pw.flush();

		}catch(Exception e){
//            System.out.println("Exception - " + e.toString());
            e.printStackTrace(System.out);
            filename = "public_error_500x300.png";
		}
					
		return filename;
	}
	public ArrayList getTotalCountByYearAndCustomerIdsQuarter(String year, String[] customerIds,String userId,String carrierName) {
		
		ArrayList results = new ArrayList();
		System.out.println("ï¿½ï¿½ï¿½ï¿½");
		try{
			Map map = new HashMap();
			map.put("year", year);
			map.put("CustomerIdList", customerIds);
			List daoList = orderDayInfoDao.getCustomerByYearPage(map);
			List list = (List) daoList.get(1);
			
			for(Iterator it = list.iterator();it.hasNext();){
				OrderDayInfo orderdayInfo = (OrderDayInfo) it.next();
										
				results.add(orderdayInfo);

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return results;
	}
	public String yearAnalyzeChartMoneyInQuarter(String sysUser,String channel,String year, String[] customerIds,String userId,String carrierName, HttpSession session, PrintWriter pw) {
		
		String filename = null;
		
		try {

			ArrayList list = getDateByYearAndCustomerIdsQuarter(sysUser,channel,year,customerIds,userId,carrierName);
			//System.out.println("------jkant----"+list.toString()+"-------------");
			Iterator it = list.iterator();
			
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			//System.out.println("-------111-----------------");			
            while (it.hasNext()) {
            	OrderDayInfo orderdayInfo = (OrderDayInfo) it.next();
            	dataset.addValue(orderdayInfo.getDayRelIncome(), "Hits",orderdayInfo.getPublishDate().toString().equals("5")?"ï¿½Ï¼ï¿½":orderdayInfo.getPublishDate().toString());
            	
            	//System.out.println("-------2222------"+ orderdayInfo.getPublishDate().toString() +"-----------");
            }
           // System.out.println("-------3333-----------------");	

			//  Create the chart object
			CategoryAxis categoryAxis = new CategoryAxis("");
			ValueAxis valueAxis = new NumberAxis("");
			BarRenderer3D renderer = new BarRenderer3D();
			renderer.setItemURLGenerator(new StandardCategoryURLGenerator("yearAnalyze.jsp","series","section"));
			
			
            renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

			Plot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
			JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
			chart.setBackgroundPaint(java.awt.Color.white);

			//  Write the chart image to the temporary directory
			ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info, session);

			//  Write the image map to the PrintWriter
			ChartUtilities.writeImageMap(pw, filename, info);
			pw.flush();
		}catch(Exception e){
//            System.out.println("Exception - " + e.toString());
            e.printStackTrace(System.out);
            filename = "public_error_500x300.png";
		}
					
		return filename;
	}
	/** 
	 * ï¿½Í»ï¿½Í³ï¿½ï¿½----Òµï¿½ï¿½Ô±ï¿½ï¿½Ñ¯.
	 */	
	
	public ArrayList getDataByHitMonthPutOn(String sysUser,String channelModelParam,String hitMonth,String startDate,String endDate,String userId,String carrierName){
		
		ArrayList results = new ArrayList();
		HashMap sectionMap = new HashMap();
		 List userIdList = new ArrayList();
		 List carrierIdList = new ArrayList();
		Map map = new HashMap();
		map.put("startDate",startDate);
		map.put("endDate",endDate);
//		map.put("parentId",carrierName);

//		ÅÐ¶ÏÊÇ·ñ·ÖÆµµÀ£¬ÖµÎª1·Ö£¬·ñÔò²»·Ö
		boolean channelPull = false;
		
		int channelMode = Integer.parseInt(channelModelParam);

		if(channelMode==1){
			 channelPull = true;
			}
		
		carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,sysUser);
		map.put("carrierIdList",carrierIdList);


		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		map.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		
//    		List ls = userManager.getOwnerUsersList(userRelsMap);
    		List ls =(List)userRelsMap.get(sysUser);
//    		System.out.println(">>>>>  1  "+ls.size()) ;
    		for(Iterator it=ls.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		map.put("UserIdList",userIdList);
    	}
		List list = orderDayInfoDao.getBusinessPage(map);
		
		Iterator iter = list.listIterator();
		int currentPosition = 0;
		while(iter.hasNext()){
			OrderDayInfo orderdayInfo = (OrderDayInfo) iter.next();
			
			String month = orderdayInfo.getPublishDate().toString().substring(4,6);
//			System.out.println("month----" + month);	ss	
			if(hitMonth == null ? true : hitMonth.equals(month)) {
//						System.out.println("name = "+orderdayInfo.getBusinessFirstName()+orderdayInfo.getBusinessLastName());
				Integer position = (Integer)sectionMap.get(orderdayInfo.getBusinessFirstName()+orderdayInfo.getBusinessLastName());

				if(position != null){
					OrderDayInfo orderdayInfos = (OrderDayInfo) results.get(position.intValue());
					orderdayInfos.setDayRelPuton( orderdayInfo.getDayRelPuton());
				}else{
					results.add(orderdayInfo);
					sectionMap.put(orderdayInfo.getBusinessFirstName()+orderdayInfo.getBusinessLastName(), new Integer(currentPosition));
					currentPosition++;
				}
			}
		}
		
		return results;
	}
	
	 public String businessAnalyzeChartPuton(String sysUser,String channelModelParam,String hitMonth,String startDate, String endDate,String userId,String carrierName, HttpSession session, PrintWriter pw) {

			String filename = null;
			
			try {
				ArrayList list = getDataByHitMonthPutOn(sysUser,channelModelParam,hitMonth,startDate,endDate,userId,carrierName);
//				System.out.println("Puton  "+list.size()+" 2 "+userId);
				Iterator it = list.iterator();
				
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
							
	            while (it.hasNext()) {
	            	OrderDayInfo orderdayInfo = (OrderDayInfo) it.next();
	            	            	
	            	dataset.addValue(orderdayInfo.getDayRelPuton(), "Hits",orderdayInfo.getBusinessFirstName()+orderdayInfo.getBusinessLastName());
	            }
	            
	            

				//  Create the chart object
				CategoryAxis categoryAxis = new CategoryAxis("");
				ValueAxis valueAxis = new NumberAxis("");
				BarRenderer3D renderer = new BarRenderer3D();
				renderer.setItemURLGenerator(new StandardCategoryURLGenerator("businessAnalyze.jsp","series","section"));
				
				
	            renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

				Plot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
				JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
				chart.setBackgroundPaint(java.awt.Color.white);

				//  Write the chart image to the temporary directory
				ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
				filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info, session);

				//  Write the image map to the PrintWriter
				ChartUtilities.writeImageMap(pw, filename, info);
				pw.flush();
							
			}catch(Exception e){
//	            System.out.println("Exception - " + e.toString());
	            e.printStackTrace(System.out);
	            filename = "public_error_500x300.png";
			}
						
			return filename;
		}

	public String businessAnalyzeChart(String sysUser,String channelModelParam,String hitMonth,String startDate, String endDate,String userId,String carrierName, HttpSession session, PrintWriter pw) {

		String filename = null;
		
		try {
			ArrayList list = getDataByHitMonth(sysUser,channelModelParam,hitMonth,startDate,endDate,userId,carrierName);
//			System.out.println("LLL  "+list.size()+" 2 "+userId);
			Iterator it = list.iterator();
			
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						
            while (it.hasNext()) {
            	OrderDayInfo orderdayInfo = (OrderDayInfo) it.next();
            	            	
            	dataset.addValue(orderdayInfo.getDayRelIncome(), "Hits",orderdayInfo.getBusinessFirstName()+orderdayInfo.getBusinessLastName());
            }
            
            

			//  Create the chart object
			CategoryAxis categoryAxis = new CategoryAxis("");
			ValueAxis valueAxis = new NumberAxis("");
			BarRenderer3D renderer = new BarRenderer3D();
			renderer.setItemURLGenerator(new StandardCategoryURLGenerator("businessAnalyze.jsp","series","section"));
			
			
            renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

			Plot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
			JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
			chart.setBackgroundPaint(java.awt.Color.white);

			//  Write the chart image to the temporary directory
			ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info, session);

			//  Write the image map to the PrintWriter
			ChartUtilities.writeImageMap(pw, filename, info);
			pw.flush();
						
		}catch(Exception e){
//            System.out.println("Exception - " + e.toString());
            e.printStackTrace(System.out);
            filename = "public_error_500x300.png";
		}
					
		return filename;
	}

	public ArrayList getMonthByStartAndEndDate(String startDate,String endDate){
		ArrayList monthList = new ArrayList();
		
		int startMon = Integer.parseInt(startDate.substring(4,6));
		int endMon = Integer.parseInt(endDate.substring(4,6));
				
		for(int i =startMon ; i<=endMon;i++){
			String mon = i+"";
			if(mon.length() == 1) mon = "0"+mon;
			monthList.add(mon);
		}
		return monthList;
	}
	
	public ArrayList getDataByHitMonth(String sysUser,String channelModelParam,String hitMonth,String startDate,String endDate,String userId,String carrierName){
			
		ArrayList results = new ArrayList();
		HashMap sectionMap = new HashMap();
		List carrierIdList = new ArrayList();
		 List userIdList = new ArrayList();
		Map map = new HashMap();
		map.put("startDate",startDate);
		map.put("endDate",endDate);
//		map.put("parentId",carrierName);

//		ÅÐ¶ÏÊÇ·ñ·ÖÆµµÀ£¬ÖµÎª1·Ö£¬·ñÔò²»·Ö
		boolean channelPull = false;
		
		int channelMode = Integer.parseInt(channelModelParam);

		if(channelMode==1){
			 channelPull = true;
			}
		
		carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,sysUser);
		map.put("carrierIdList",carrierIdList);

		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		map.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		
//    		List ls = userManager.getOwnerUsersList(userRelsMap); 
    		List ls =(List)userRelsMap.get(sysUser);
    		for(Iterator it=ls.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		map.put("UserIdList",userIdList);
    	}
		List list = orderDayInfoDao.getBusinessPage(map);
		
		Iterator iter = list.listIterator();
		int currentPosition = 0;
//		System.out.println("month----"  );	
		while(iter.hasNext()){
			OrderDayInfo orderdayInfo = (OrderDayInfo) iter.next();
			
			String month = orderdayInfo.getPublishDate().toString().substring(4,6);
//			System.out.println("month----" + month);	
			if(hitMonth == null ? true : hitMonth.equals(month)) {
//						System.out.println("name = "+orderdayInfo.getBusinessFirstName()+orderdayInfo.getBusinessLastName());
				Integer position = (Integer)sectionMap.get(orderdayInfo.getBusinessFirstName()+orderdayInfo.getBusinessLastName());
				
				if(position != null){
					OrderDayInfo orderdayInfos = (OrderDayInfo) results.get(position.intValue());
					orderdayInfos.setDayRelIncome( orderdayInfo.getDayRelIncome());
				}else{
					results.add(orderdayInfo);
					sectionMap.put(orderdayInfo.getBusinessFirstName()+orderdayInfo.getBusinessLastName(), new Integer(currentPosition));
					currentPosition++;
				}
			}
		}
//		System.out.println(">>>>>  1  "+results.size()+"e  "+userId) ;
		return results;
	}
	
	
	/** 
	 * ï¿½ï¿½ï¿½ï¿½Í³ï¿½ï¿½----ï¿½ï¿½ï¿½ï¿½Ñ¯.
	 */		
	
	public ArrayList getDataByCarrierAndDate(String sysUser,String startDate, String endDate, String[] carrierIds,String userId) {
		ArrayList resultList = new ArrayList();
		
		try {
			List list = orderDayInfoManager.getCarrierByDate(startDate,endDate,carrierIds,userId,sysUser,"false","1");
			
			for(Iterator it = list.iterator();it.hasNext();){
				OrderDayInfo orderdayInfo = (OrderDayInfo) it.next();
										
				resultList.add(orderdayInfo);

			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultList;
	}

	public String carrierScopeAnalyzeInCount(String sysUser,String startDate, String endDate, String[] carrierIds, String userId,  HttpSession session, PrintWriter pw) {

		String filename = null;
		
		try {
			ArrayList list = getDataByCarrierAndDate(sysUser,startDate,endDate,carrierIds,userId);
			
			Iterator it = list.iterator();
			
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						
            while (it.hasNext()) {
            	OrderDayInfo orderdayInfo = (OrderDayInfo) it.next();
            	            	
            	dataset.addValue(orderdayInfo.getDayRelIncome(), "Hits",orderdayInfo.getCarrier().getCarrierName());
            }
            
            

			//  Create the chart object
			CategoryAxis categoryAxis = new CategoryAxis("");
			ValueAxis valueAxis = new NumberAxis("");
			BarRenderer3D renderer = new BarRenderer3D();
			renderer.setItemURLGenerator(new StandardCategoryURLGenerator("carrierScopeAnalyze.jsp","series","section"));
			
			
            renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

			Plot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
			JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
			chart.setBackgroundPaint(java.awt.Color.white);

			//  Write the chart image to the temporary directory
			ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info, session);

			//  Write the image map to the PrintWriter
			ChartUtilities.writeImageMap(pw, filename, info);
			pw.flush();
						
		}catch(Exception e){
//            System.out.println("Exception - " + e.toString());
            e.printStackTrace(System.out);
            filename = "public_error_500x300.png";
		}
					
		return filename;
	}

	public String carrierScopeAnalyzeTimeSum(String sysUser,String startDate, String endDate, String[] carrierIds, String userId, HttpSession session, PrintWriter pw) {

		String filename = null;
		
		try {
			ArrayList list = getDataByCarrierAndDate(sysUser,startDate,endDate,carrierIds,userId);
			
			Iterator it = list.iterator();
			
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						
            while (it.hasNext()) {
            	OrderDayInfo orderdayInfo = (OrderDayInfo) it.next();
            	            	
            	dataset.addValue(orderdayInfo.getAdSumTimes(), "Hits",orderdayInfo.getCarrier().getCarrierName());
            }
            
            

			//  Create the chart object
			CategoryAxis categoryAxis = new CategoryAxis("");
			ValueAxis valueAxis = new NumberAxis("");
			BarRenderer3D renderer = new BarRenderer3D();
			renderer.setItemURLGenerator(new StandardCategoryURLGenerator("carrierScopeAnalyze.jsp","series","section"));
			
			
            renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

			Plot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
			JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
			chart.setBackgroundPaint(java.awt.Color.white);

			//  Write the chart image to the temporary directory
			ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info, session);

			//  Write the image map to the PrintWriter
			ChartUtilities.writeImageMap(pw, filename, info);
			pw.flush();
						
		}catch(Exception e){
//            System.out.println("Exception - " + e.toString());
            e.printStackTrace(System.out);
            filename = "public_error_500x300.png";
		}
					
		return filename;
	}

	/** 
	 * ï¿½ï¿½ï¿½ï¿½Í³ï¿½ï¿½----È«ï¿½ï¿½ï¿½Ñ?.
	 */		


	public String carrierAllYearAnalyzeChartIncome(String sysUser,String hitMonth,String year, String[] carrierIds,String userId, HttpSession session, PrintWriter pw) {

		String filename = null;
		
		try {
			ArrayList list = getDataByMonth(sysUser,hitMonth,year,carrierIds,userId);
			
			Iterator it = list.iterator();
			
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						
            while (it.hasNext()) {
            	OrderDayInfo orderdayInfo = (OrderDayInfo) it.next();
            	            	
            	dataset.addValue(orderdayInfo.getDayRelIncome(), "Hits",orderdayInfo.getCarrier().getCarrierName());
            }
            
            

			//  Create the chart object
			CategoryAxis categoryAxis = new CategoryAxis("");
			ValueAxis valueAxis = new NumberAxis("");
			BarRenderer3D renderer = new BarRenderer3D();
			renderer.setItemURLGenerator(new StandardCategoryURLGenerator("carrierAllYearAnalyze.jsp","series","section"));
			
			
            renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

			Plot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
			JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
			chart.setBackgroundPaint(java.awt.Color.white);

			//  Write the chart image to the temporary directory
			ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info, session);

			//  Write the image map to the PrintWriter
			ChartUtilities.writeImageMap(pw, filename, info);
			pw.flush();
						
		}catch(Exception e){
//            System.out.println("Exception - " + e.toString());
            e.printStackTrace(System.out);
            filename = "public_error_500x300.png";
		}
					
		return filename;
	}
	
	public ArrayList getMonthByStartEndDateAndCarrier(){
		ArrayList monthList = new ArrayList();
			
		for(int i =1 ; i<=12;i++){
			String mon = i+"";
			if(mon.length() == 1) mon = "0"+mon;
			monthList.add(mon);
		}
		return monthList;
	}	
	public ArrayList getDataByMonth(String sysUser,String hitMonth,String year, String[] carrierIds,String userId){
		
		ArrayList results = new ArrayList();
		HashMap sectionMap = new HashMap();
		List userIdList = new ArrayList();
		Map mp = new HashMap();
		mp.put("year",year);
		mp.put("carrierIdList",carrierIds);
//		mp.put("parentId",carrierName);
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    		
//    		List ls = userManager.getOwnerUsersList(userRelsMap);
    		List ls =(List)userRelsMap.get(sysUser);
    		for(Iterator it=ls.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		mp.put("UserIdList",userIdList);
    	}
		
		List list = orderDayInfoDao.getCarrierAllYear(mp);
		
		Iterator iter = list.listIterator();
		int currentPosition = 0;
		while(iter.hasNext()){
			OrderDayInfo orderdayInfo = (OrderDayInfo) iter.next();
			
			String month = orderdayInfo.getPublishDate().toString().substring(4,6);
//			System.out.println("month----" + month);		
			if(hitMonth == null ? true : hitMonth.equals(month)) {
//						System.out.println("name = "+orderdayInfo.getCarrier().getCarrierName());
				Integer position = (Integer)sectionMap.get(orderdayInfo.getCarrier().getCarrierName());

				if(position != null){
					OrderDayInfo orderdayInfos = (OrderDayInfo) results.get(position.intValue());
					orderdayInfos.setDayRelIncome( orderdayInfo.getDayRelIncome());
				}else{
					results.add(orderdayInfo);
					sectionMap.put(orderdayInfo.getCarrier().getCarrierName(), new Integer(currentPosition));
					currentPosition++;
				}
			}
		}
		
		return results;
	}	
	/** 
	 * Æ·ï¿½ï¿½Í³ï¿½ï¿½----ï¿½Í»ï¿½Æ·ï¿½ï¿½Í¶ï¿½ï¿½ï¿½ï¿½Ñ¯.
	 */		
	
	public ArrayList getCustomerName(String sysUser,String channelModel,String startDate, String endDate,String userId,String[] carrierIds){
		ArrayList results = new ArrayList();
		List userIdList = new ArrayList();
		Map mapCust = new HashMap();
		try{
			List list = new ArrayList();
			List carrierIdList = new ArrayList();
			CollectionUtils.addAll(carrierIdList, carrierIds);
			Map mp = new HashMap();
			mp.put("beginDate",startDate);
			mp.put("endDate",endDate);
			mp.put("carrierIdList",carrierIdList);
//			mp.put("parentId",carrierName);

			
			if((!"".equals(userId) &&  userId!=null)){
	    		List userls = new ArrayList();
	    		userls.add(userId);
	    		mp.put("UserIdList",userls);
	    	}else{
	    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
//	    		list = userManager.getOwnerUsersList(userRelsMap);
	    		list =(List)userRelsMap.get(sysUser);
	    		for(Iterator it=list.iterator();it.hasNext();){
	    			User user = (User)it.next();
	    			userIdList.add(user.getId());
	    		}
	    		mp.put("UserIdList",userIdList);
	    	}
			List lt = orderDetailDao.getCustomerProductByBeginAndEndDate(mp);
			Map mapCustomerName = getCustomerByList(lt);
//			 System.out.println("List   "+lt.size()+" mapCustomerName   "+mapCustomerName.size());		
			for (Iterator it = mapCustomerName.keySet().iterator(); it.hasNext();) {
				 String key_customerName = (String)it.next();
				 List newCutList = getNewListByCustomerName(lt,key_customerName);
			
				 mapCust.put(key_customerName,newCutList);
			}
			for (Iterator it = mapCust.values().iterator(); it.hasNext();) {
				List cutList = (List)it.next();
					 
				for(Iterator iter = cutList.listIterator();iter.hasNext();){
//					 System.out.println("results   "+results.size());			 
					results.add(iter.next());
				}
			}	

		}catch(Exception e){
			e.printStackTrace();
		}
//		System.out.println("lt   "+results.size());
		return results;		
	}
	
	private Map getCustomerByList(List ls){
		Map map = new HashMap();
		for (Iterator it = ls.iterator();it.hasNext();){
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			String customerName = customerProduct.getCustomerName();
			map.put(customerName,customerName);
		}
		return map;
	}
	private ArrayList getNewListByCustomerName(List ls,String custName){
		ArrayList lsCustomer = new ArrayList();
		int i = 0 ;
		ArrayList noNullCustomerName = new ArrayList();
		for (Iterator it = ls.iterator();it.hasNext();){
			
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			
			String customerName = customerProduct.getCustomerName();
			
			if(customerName.equals(custName)){
				if(i > 0) customerProduct.setCustomerName("");
				i++;
				lsCustomer.add(customerProduct.getCustomerName());
			}
		}
		for (Iterator it = lsCustomer.iterator();it.hasNext();){
			String customerName = (String)it.next();
			if(!customerName.equals(""))
				noNullCustomerName.add(customerName);
		}
		return noNullCustomerName;
	}
	
	
	public ArrayList getDataByCustomerName(String sysUser,String channelModel,String customerName,String startDate, String endDate,String userId,String[] carrierIds) {
		
		ArrayList results = new ArrayList();
		HashMap sectionMap = new HashMap();
			
		List list = new ArrayList();
		List userIdList = new ArrayList();
		List carrierIdList = new ArrayList();
		
		CollectionUtils.addAll(carrierIdList, carrierIds);
		Map mp = new HashMap();
		mp.put("beginDate",startDate);
		mp.put("endDate",endDate);
		mp.put("carrierIdList",carrierIdList);
//		mp.put("parentId",carrierName);

		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
    
//    		list = userManager.getOwnerUsersList(userRelsMap);
    		list =(List)userRelsMap.get(sysUser);
    		for(Iterator it=list.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
    		mp.put("UserIdList",userIdList);
    	}
			
		List ls = orderDetailDao.getCustomerProductByBeginAndEndDate(mp);
			
		Iterator iter = ls.listIterator();
		int currentPosition = 0;
		while(iter.hasNext()){
			CustomerProduct customerProduct = (CustomerProduct) iter.next();
			
			String cusName = customerProduct.getCustomerName();
			
			if(cusName == null ? true : cusName.equals(customerName)){
				Integer position = (Integer)sectionMap.get(customerProduct.getMatterName());
				
				if(position != null){
					CustomerProduct cusProducts = (CustomerProduct) results.get(position.intValue());
					cusProducts.setRelIncome( customerProduct.getRelIncome());
				}else{
					results.add(customerProduct);
					sectionMap.put(customerProduct.getMatterName(), new Integer(currentPosition));
					currentPosition++;
				}
			}
			
		}
		return results;
	}

	public String customerProductRelChart(String sysUser,String channelModel,String customerName,String startDate, String endDate,String userId,String[] carrierIds, HttpSession session, PrintWriter pw) {

		String filename = null;
		
		try {
			ArrayList list = getDataByCustomerName(sysUser,channelModel,customerName,startDate,endDate,userId,carrierIds);
			
//			System.out.println("list = " + list.size());
			
			Iterator it = list.iterator();
			
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						
            while (it.hasNext()) {
            	CustomerProduct customerProduct = (CustomerProduct) it.next();
            	            	
            	dataset.addValue(customerProduct.getRelIncome(), "Hits",customerProduct.getMatterName());
            }
            
            

			//  Create the chart object
			CategoryAxis categoryAxis = new CategoryAxis("");
			ValueAxis valueAxis = new NumberAxis("");
			BarRenderer3D renderer = new BarRenderer3D();
			renderer.setItemURLGenerator(new StandardCategoryURLGenerator("customerProductRelIncome.jsp","series","section"));
			
			
            renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

			Plot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
			JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
			chart.setBackgroundPaint(java.awt.Color.white);

			//  Write the chart image to the temporary directory
			ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info, session);

			//  Write the image map to the PrintWriter
			ChartUtilities.writeImageMap(pw, filename, info);
			pw.flush();
						
		}catch(Exception e){
//            System.out.println("Exception - " + e.toString());
            e.printStackTrace(System.out);
            filename = "public_error_500x300.png";
		}
					
		return filename;
	}
	
	
	/** 
	 * Æ·ï¿½ï¿½Í³ï¿½ï¿½----ï¿½ï¿½ÒµÆ·ï¿½ï¿½Í¶ï¿½ï¿½ï¿½ï¿½Ñ¯.
	 */	
	
	
	

	private CustomerProduct getNewIndustryList(List ls,String carrierName){
	//	List lsIndustry = new ArrayList();
		double industryMoney=0;
		CustomerProduct cpMoney = new CustomerProduct();
		for (Iterator it = ls.iterator();it.hasNext();){
			
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			
			String carName = customerProduct.getIndustryType();
			
			if(carName.equals(carrierName)){
				industryMoney+=customerProduct.getRelIncome().doubleValue();
	//			lsIndustry.add(customerProduct);
			}
		}
		cpMoney.setIndustryType(carrierName)	;
		cpMoney.setRelIncome(new Double(industryMoney));
	//	System.out.println("<<<<<<<<<<  cpMoney  >>>>>>>>>>   "+carrierName+"   "+industryMoney);
		return cpMoney;
	}
	

	private List getNewIndustryNameList(List ls,List lsIndustry,String carrierName){
		
//		double industryMoney=0;
//		CustomerProduct cpMoney = new CustomerProduct();
		for (Iterator it = ls.iterator();it.hasNext();){
			
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			
			String industryType = customerProduct.getIndustryType();
			
			if(!lsIndustry.contains(carrierName)){
				lsIndustry.add(industryType);
//				System.out.println("<<<<<<<<<<  industryType11>>>>>>>>   "+industryType);
			}
		}
//		cpMoney.setIndustryType(carrierName)	;
//		cpMoney.setRelIncome(new Double(industryMoney));
//		System.out.println("<<<<<<<<<<  lsIndustry  >>>>>>>>>>   "+lsIndustry.size());
		return lsIndustry;
	}

	private ArrayList getIndustryTotalRateList(List ls){
		ArrayList productRate = new ArrayList();
		Double sumReal = (Double)ls.get(ls.size()-1);
		
	//	System.out.println("<<<<<<<<<<  sumReal  >>>>>>>>>"+sumReal);
		
		ls.remove(ls.size()-1);
		for(Iterator it = ls.iterator(); it.hasNext();) {
			CustomerProduct cutPro = (CustomerProduct)it.next();
			String rates;
			double rate = 0;
			String rateStr = new Double(cutPro.getRelIncome().doubleValue()/sumReal.doubleValue()*100).toString();
	//		System.out.println("<<<<<<<<<<  rateStr %%%%%%"+rateStr);
			if(rateStr.length()>5){
				rates = rateStr.substring(0,4);
				rate = new Double(rates).doubleValue();
	//			System.out.println("<<<<<<<<<<  rateStr  if %%%%%%"+rates);
			}else{
				rate = new Double(rateStr).doubleValue();
	//			System.out.println("<<<<<<<<<<  rate else %%%%%%"+rate);
			}
			 
	//		double rate = Math.round(cutPro.getRelIncome().doubleValue()/sumReal.doubleValue()*100);
	//		System.out.println("<<<<<<<<<<  rate %%%%%%"+rate);
			//ï¿½ï¿½ï¿½ï¿½ï¿½serUsedï¿½ï¿½Å±ï¿½ï¿½ï¿?			
			cutPro.setUsed(new Double(rate).toString()+"%");
			productRate.add(cutPro);
		}
//		CustomerProduct customerProduct = new CustomerProduct();
//		customerProduct.setIndustryType("ï¿½ï¿½Òµï¿½Üºï¿½");
//		customerProduct.setRelIncome(sumReal);
//		productRate.add(customerProduct);
	//	System.out.println("<<<<<<<<<<  productRate  >>>>>>>>>"+productRate.size());
		return productRate;
	}


	public ArrayList getIndustryName(String userName,String channelModel,String startDate, String endDate,String userId,String carrierName) {
		
		ArrayList results = new ArrayList();
		Map mapCust = new HashMap();
		try{
//			List list = new ArrayList();
			List userIdList = new ArrayList();
			List carrierIdList = new ArrayList();
			Map mp = new HashMap();
			
			mp.put("beginDate",startDate);
			mp.put("endDate",endDate);
//			mp.put("parentId",carrierName);

//			ÅÐ¶ÏÊÇ·ñ·ÖÆµµÀ£¬ÖµÎª1·Ö£¬·ñÔò²»·Ö
			boolean channelPull = false;
			int channelModelParam = Integer.parseInt(channelModel);

			if(channelModelParam==1){
				 channelPull = true;
				}
			
			carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,userName);
			mp.put("carrierIdList",carrierIdList);

			
			
			if((!"".equals(userId) &&  userId!=null)){
	    		List userls = new ArrayList();
	    		userls.add(userId);
	    		mp.put("UserIdList",userls);
	    	}else{
	    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
	    		
//	    		List ls = userManager.getOwnerUsersList(userRelsMap);
	    		List ls =(List)userRelsMap.get(userName);
//	    		System.out.println(">>>>>  1  "+ls.size()) ;
	    		for(Iterator it=ls.iterator();it.hasNext();){
	    			User user = (User)it.next();
	    			userIdList.add(user.getId());
	    		}
	    		mp.put("UserIdList",userIdList);
	    	}
			
			List list = orderDetailDao.getIndustryTypeProductByBeginAndEndDate(mp);
			
			
			Map industryTypeMap = getIndustryTypeByList(list);
			
			for (Iterator it = industryTypeMap.keySet().iterator(); it.hasNext();) {
				 String key_industryType = (String)it.next();
				 List newCutList = getNewListByIndustryType(list,key_industryType);
				 			 
				 mapCust.put(key_industryType,newCutList);
			}
			
			for (Iterator it = mapCust.values().iterator(); it.hasNext();) {
				List cutList = (List)it.next();
				
				for(Iterator iter = cutList.listIterator();iter.hasNext();){
					results.add(iter.next());
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return results;
	}
	
	private Map getIndustryTypeByList(List ls){
		Map map = new HashMap();
		for (Iterator it = ls.iterator();it.hasNext();){
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			String industryType = customerProduct.getIndustryType();
			map.put(industryType,industryType);
		}
		return map;
	}

	private List getNewListByIndustryType(List ls,String industryTypeName){
		List lsIndustry = new ArrayList();
		int i = 0 ;
		List noNullIndustry = new ArrayList();
		for (Iterator it = ls.iterator();it.hasNext();){
			
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			
			String industryType = customerProduct.getIndustryType();
			
			if(industryType.equals(industryTypeName)){
				if(i > 0) customerProduct.setIndustryType("");
				i++;
				lsIndustry.add(customerProduct.getIndustryType());
			}
		}
		for (Iterator it = lsIndustry.iterator();it.hasNext();){
			String industryType = (String)it.next();
			if(!industryType.equals(""))
				noNullIndustry.add(industryType);
		}
		return noNullIndustry;
	}
	
	
	
	
public ArrayList getIndustryNameTotal(String startDate, String endDate,String userId,String carrierName) {
		
		Map mapCust = new HashMap();
		ArrayList lsAll = new ArrayList();
		List lsIndustry = new ArrayList();
		try{
			Map mp = new HashMap();
			List list = new ArrayList();
			List userIdList = new ArrayList();
			mp.put("beginDate",startDate);
			mp.put("endDate",endDate);
			mp.put("parentId",carrierName);
//			System.out.println(">>>>>  1  "+isPrint) ;
			if((!"".equals(userId) &&  userId!=null)){
	    		List userls = new ArrayList();
	    		userls.add(userId);
	    		mp.put("UserIdList",userls);
	    	}else{
	    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
	    		list = userManager.getOwnerUsersList(userRelsMap);
	    		for(Iterator it=list.iterator();it.hasNext();){
	    			User user = (User)it.next();
	    			userIdList.add(user.getId());
	    		}
	    		mp.put("UserIdList",userIdList);
	    	}
		
			List ls = orderDetailDao.getIndustryTypeProductByBeginAndEndDate(mp);
			Map advTypeMap = getIndustryTypeByList(ls);
			
			for (Iterator it = advTypeMap.keySet().iterator(); it.hasNext();) {
				 String key_advType = (String)it.next();
				 
				 List industryName = getNewIndustryNameList(ls,lsIndustry,key_advType);
				 			 
				 mapCust.put(key_advType,industryName);
			}
			
			for (Iterator it = mapCust.values().iterator(); it.hasNext();) {
				List namelist = (List)it.next();
				for(Iterator iter = namelist.listIterator();iter.hasNext();){
					String industryName = (String)iter.next();
//					System.out.println(xx);
					if(!lsAll.contains(industryName))
						lsAll.add(industryName);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
//		System.out.println("  lsAll  "+lsAll.size());
		return lsAll;
	}
	
	public ArrayList getDataByIndustryType(String userName,String channelModel,String indusType,String startDate, String endDate,String userId,String carrierName){
		ArrayList results = new ArrayList();
		HashMap sectionMap = new HashMap();
		List ls = new ArrayList();	
		List userIdList = new ArrayList();	
		List carrierIdList =new ArrayList();
		Map map = new HashMap();
		map.put("beginDate",startDate);
		map.put("endDate",endDate);
//		map.put("parentId",carrierName);

//		ÅÐ¶ÏÊÇ·ñ·ÖÆµµÀ£¬ÖµÎª1·Ö£¬·ñÔò²»·Ö
		boolean channelPull = false;
		int channelModelParam = Integer.parseInt(channelModel);

		if(channelModelParam==1){
			 channelPull = true;
		}
		carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,userName);
		map.put("carrierIdList",carrierIdList);

		
		if((!"".equals(userId) &&  userId!=null)){
			List userls = new ArrayList();
			userls.add(userId);
			map.put("UserIdList",userls);
		}else{
			Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
//				ls = userManager.getOwnerUsersList(userRelsMap);
		     	ls =(List)userRelsMap.get(userName);
			for(Iterator it=ls.iterator();it.hasNext();){
				User user = (User)it.next();
				userIdList.add(user.getId());
			}
			map.put("UserIdList",userIdList);
		}
		
		List list = orderDetailDao.getIndustryTypeProductByBeginAndEndDate(map);
			
		Iterator iter = list.listIterator();
		int currentPosition = 0;
		while(iter.hasNext()){
			CustomerProduct customerProduct = (CustomerProduct) iter.next();
			
			String industryType = customerProduct.getIndustryType();
			
			if(industryType == null ? true : industryType.equals(indusType)){
				Integer position = (Integer)sectionMap.get(customerProduct.getMatterName());
				
				if(position != null){
					CustomerProduct cusProducts = (CustomerProduct) results.get(position.intValue());
					cusProducts.setRelIncome( customerProduct.getRelIncome());
				}else{
					results.add(customerProduct);
					sectionMap.put(customerProduct.getMatterName(), new Integer(currentPosition));
					currentPosition++;
				}
			}
			
		}
		return results;
	}

	public ArrayList getDataIndustryNameTotal(String userName,String channelModel,String startDate, String endDate,String userId,String carrierName) {
		
		Map mapCust = new HashMap();
		List lsAll = new ArrayList();
		try{
			Map mp = new HashMap();
			List list = new ArrayList();
			List userIdList = new ArrayList();
			List carrierIdList = new ArrayList();
			
			mp.put("beginDate",startDate);
			mp.put("endDate",endDate);
//			mp.put("parentId",carrierName);

//			ÅÐ¶ÏÊÇ·ñ·ÖÆµµÀ£¬ÖµÎª1·Ö£¬·ñÔò²»·Ö
			boolean channelPull = false;
			int channelModelParam = Integer.parseInt(channelModel);

			if(channelModelParam==1){
				 channelPull = true;
			}
			carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,userName);
			mp.put("carrierIdList",carrierIdList);

			
//			System.out.println(">>>>>  1  "+isPrint) ;
			if((!"".equals(userId) &&  userId!=null)){
	    		List userls = new ArrayList();
	    		userls.add(userId);
	    		mp.put("UserIdList",userls);
	    	}else{
	    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
	    			list = userManager.getOwnerUsersList(userRelsMap);
	    			list =(List)userRelsMap.get(userName);
	    		for(Iterator it=list.iterator();it.hasNext();){
	    			User user = (User)it.next();
	    			userIdList.add(user.getId());
	    		}
	    		mp.put("UserIdList",userIdList);
	    	}
			double sumReal = 0;
			List ls = orderDetailDao.getIndustryTypeProductByBeginAndEndDate(mp);
			Map advTypeMap = getIndustryTypeByList(ls);
			
			for (Iterator it = advTypeMap.keySet().iterator(); it.hasNext();) {
				 String key_advType = (String)it.next();
				 
				 CustomerProduct newCP = getNewIndustryList(ls,key_advType);
				 			 
				 mapCust.put(key_advType,newCP);
			}
//			
			for (Iterator it = mapCust.values().iterator(); it.hasNext();) {
				CustomerProduct cutPro = (CustomerProduct)it.next();
				sumReal += cutPro.getRelIncome().doubleValue();
				lsAll.add(cutPro);
				
//				CollectionUtils.addAll(lsAll,cutList.iterator());
			}
			
			lsAll.add(new Double(sumReal));
		}catch(Exception e){
			e.printStackTrace();
		}
		return getIndustryTotalRateList(lsAll);
	}
	
	public String industryProductRelChartTotal(String userName,String channelModel,String industryType,String startDate, String endDate,String userId,String carrierName, HttpSession session, PrintWriter pw) {

		String filename = null;
		
		try {				 
			ArrayList list = getDataIndustryNameTotal(userName,channelModel,startDate,endDate,userId,carrierName);
			
//			System.out.println("list = " + list.size());
			
			Iterator it = list.iterator();
			
			DefaultPieDataset dataset = new DefaultPieDataset();	
						
            while (it.hasNext()) {
            	CustomerProduct customerProduct = (CustomerProduct) it.next();
//            	System.out.println("customerProduct = " + customerProduct.getIndustryType());
            	            	
            	dataset.setValue(customerProduct.getIndustryType(),customerProduct.getRelIncome());

            }
            
            
            
			//  Create the chart object
            PiePlot plot = new PiePlot(dataset);
            plot.setInsets(new Insets(0, 15, 10, 5));
            plot.setURLGenerator(new StandardPieURLGenerator("industryProductRelIncome.jsp","section"));
            plot.setToolTipGenerator(new StandardPieItemLabelGenerator());
            
			JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
			chart.setBackgroundPaint(java.awt.Color.white);
			
			
			//  Write the chart image to the temporary directory
			ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info, session);

			//  Write the image map to the PrintWriter
			ChartUtilities.writeImageMap(pw, filename, info);
			pw.flush();
						
		}catch(Exception e){
//            System.out.println("Exception - " + e.toString());
            e.printStackTrace(System.out);
            filename = "public_error_500x300.png";
		}
					
		return filename;
	}
	
	public String industryProductRelChart(String userName,String channelModelParam,String industryType,String startDate, String endDate,String userId,String carrierName, HttpSession session, PrintWriter pw) {

		String filename = null;
		
		try {
			ArrayList list = getDataByIndustryType(userName,channelModelParam,industryType,startDate,endDate,userId,carrierName);
			
//			System.out.println("list = " + list.size());
			
			Iterator it = list.iterator();
			
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						
            while (it.hasNext()) {
            	CustomerProduct customerProduct = (CustomerProduct) it.next();
            	            	
            	dataset.addValue(customerProduct.getRelIncome(), "Hits",customerProduct.getMatterName());
            }
            
            

			//  Create the chart object
			CategoryAxis categoryAxis = new CategoryAxis("");
			ValueAxis valueAxis = new NumberAxis("");
			BarRenderer3D renderer = new BarRenderer3D();
			renderer.setItemURLGenerator(new StandardCategoryURLGenerator("industryProductRelIncome.jsp","series","section"));
			
			
            renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

			Plot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
			JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
			chart.setBackgroundPaint(java.awt.Color.white);

			//  Write the chart image to the temporary directory
			ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info, session);

			//  Write the image map to the PrintWriter
			ChartUtilities.writeImageMap(pw, filename, info);
			pw.flush();
						
		}catch(Exception e){
//            System.out.println("Exception - " + e.toString());
            e.printStackTrace(System.out);
            filename = "public_error_500x300.png";
		}
					
		return filename;
	}

	
	/** 
	 * Æ·ï¿½ï¿½Í³ï¿½ï¿½----ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Æ·ï¿½ï¿½Í¶ï¿½ï¿?ï¿½ï¿½Ñ¯.
	 */	
	
	public ArrayList getAdvTypeName(String userName,String channelModel,String startDate, String endDate,String userId,String carrierName) {
		
		ArrayList results = new ArrayList();
		List userIdList = new ArrayList();
		List carrierIdList = new ArrayList();
		Map mapCust = new HashMap();
		try{
			Map mp = new HashMap();
			mp.put("beginDate",startDate);
			mp.put("endDate",endDate);
//			mp.put("parentId",carrierName);
//			ÅÐ¶ÏÊÇ·ñ·ÖÆµµÀ£¬ÖµÎª1·Ö£¬·ñÔò²»·Ö
			boolean channelPull = false;
			
			int channelModeParam = Integer.parseInt(channelModel);

			if(channelModeParam==1){
				 channelPull = true;
			}
			carrierIdList = carrierManager.getCarrierIdLists(carrierName,channelPull,userName);
			mp.put("carrierIdList",carrierIdList);

			
			
//			System.out.println(">>>>>  1  "+isPrint) ;
			if((!"".equals(userId) &&  userId!=null)){
	    		List userls = new ArrayList();
	    		userls.add(userId);
	    		mp.put("UserIdList",userls);
	    	}else{
	    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
//	    		List ls = userManager.getOwnerUsersList(userRelsMap);
	    		List ls =(List)userRelsMap.get(userName);
	    		for(Iterator it=ls.iterator();it.hasNext();){
	    			User user = (User)it.next();
	    			userIdList.add(user.getId());
	    		}
	    		mp.put("UserIdList",userIdList);
	    	}
			List list = orderDetailDao.getAdvTypeProductByBeginAndEndDate(mp);
			
			Map advTypeMap = getAdvTypeByIdList(list);
			
			for (Iterator it = advTypeMap.keySet().iterator(); it.hasNext();) {
				 String key_advType = (String)it.next();
				 
				 List newCutList = getNewListByAdvType(list,key_advType);
				 			 
				 mapCust.put(key_advType,newCutList);
			}
			
			for (Iterator it = mapCust.values().iterator(); it.hasNext();) {
				List cutList = (List)it.next();
				for(Iterator iter = cutList.listIterator();iter.hasNext();){
					results.add(iter.next());
				}
			}	
		}catch(Exception e){
			e.printStackTrace();
		}
		return results;
	}
	
	private Map getAdvTypeByIdList(List ls){
		Map map = new HashMap();
		for (Iterator it = ls.iterator();it.hasNext();){
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			String carrierName = customerProduct.getCarrierName();
			map.put(carrierName,carrierName);
		}
		return map;
	}
	private ArrayList getNewListByAdvType(List ls,String carrierName){
		ArrayList lsIndustry = new ArrayList();
		int i = 0 ;
		ArrayList noNullIndustry = new ArrayList();
		for (Iterator it = ls.iterator();it.hasNext();){
			
			CustomerProduct customerProduct = (CustomerProduct) it.next();
			
			String carName = customerProduct.getCarrierName();
			
			if(carName.equals(carrierName)){
				if(i > 0) customerProduct.setCarrierName("");
				i++;
				lsIndustry.add(customerProduct.getCarrierName());
			}
		}
		for (Iterator it = lsIndustry.iterator();it.hasNext();){
			String noNullName = (String)it.next();
			if(!noNullName.equals(""))
				noNullIndustry.add(noNullName);
		}
		return noNullIndustry;
	}
	
	public ArrayList getDataByAdvTypeName(String channelModel,String carrierName,String startDate, String endDate,String userId,String carrierName1,String curUserName){
		
		ArrayList results = new ArrayList();
		HashMap sectionMap = new HashMap();
		List carrierIdList = new ArrayList();
		List list = new ArrayList();
		List userIdList = new ArrayList();
		Map mp = new HashMap();
		mp.put("beginDate",startDate);
		mp.put("endDate",endDate);
//		mp.put("parentId",carrierName1);

//		ÅÐ¶ÏÊÇ·ñ·ÖÆµµÀ£¬ÖµÎª1·Ö£¬·ñÔò²»·Ö
		boolean channelPull = false;
		int channelModeParam = Integer.parseInt(channelModel);
		if(channelModeParam==1){
			 channelPull = true;
		}
		carrierIdList = carrierManager.getCarrierIdLists(carrierName1,channelPull,curUserName);
		mp.put("carrierIdList",carrierIdList);

		
		
		if((!"".equals(userId) &&  userId!=null)){
    		List userls = new ArrayList();
    		userls.add(userId);
    		mp.put("UserIdList",userls);
    	}else{
    		Map userRelsMap = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_USER_RELS);
//    		list = userManager.getOwnerUsersList(userRelsMap);
    		list =(List)userRelsMap.get(curUserName);
    		for(Iterator it=list.iterator();it.hasNext();){
    			User user = (User)it.next();
    			userIdList.add(user.getId());
    		}
//    		System.out.println("OOOO   "+userId+"  "+userIdList.size());
    		mp.put("UserIdList",userIdList);
    	}
		
		
		List ls = orderDetailDao.getAdvTypeProductByBeginAndEndDate(mp);
			
		Iterator iter = ls.listIterator();
		int currentPosition = 0;
//		System.out.println("))))  "+carrierName+"  "+ls.size());
		while(iter.hasNext()){
			CustomerProduct customerProduct = (CustomerProduct) iter.next();
			
			String carriName = customerProduct.getCarrierName();
			
			if(carriName == null ? true : carriName.equals(carrierName)){
				Integer position = (Integer)sectionMap.get(customerProduct.getMatterName());
//				System.out.println("))))  "+position);
				
				if(position != null){
					CustomerProduct cusProducts = (CustomerProduct) results.get(position.intValue());
					cusProducts.setRelIncome( customerProduct.getRelIncome());
				}else{
					results.add(customerProduct);
					sectionMap.put(customerProduct.getCarrierName(), new Integer(currentPosition));
					currentPosition++;
				}
			}
			
		}
//		System.out.println("))  results  ))  "+results.size());
		return results;
	}
	public String advTypeProductRelChart(String channelModel,String carrierName,String startDate, String endDate,String userId,String carrierName1,String curUserName, HttpSession session, PrintWriter pw) {

		String filename = null;
		
		
		try {
			ArrayList list = getDataByAdvTypeName(channelModel,carrierName,startDate,endDate,userId,carrierName1,curUserName);
			
//			System.out.println("list = " + list.size());
			
			Iterator it = list.iterator();
			
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						
            while (it.hasNext()) {
            	CustomerProduct customerProduct = (CustomerProduct) it.next();
            	            	
            	dataset.addValue(customerProduct.getRelIncome(), "Hits",customerProduct.getMatterName());
            }
            
            

			//  Create the chart object
			CategoryAxis categoryAxis = new CategoryAxis("");
			ValueAxis valueAxis = new NumberAxis("");
			BarRenderer3D renderer = new BarRenderer3D();
			renderer.setItemURLGenerator(new StandardCategoryURLGenerator("advTypeProductRelIncome.jsp","series","section"));
			
			
            renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());
            //renderer.setPositiveItemLabelPosition(null);
			Plot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
			JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
			chart.setBackgroundPaint(java.awt.Color.white);

			//  Write the chart image to the temporary directory
			ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, 1500, 450, info, session);

			//  Write the image map to the PrintWriter
			ChartUtilities.writeImageMap(pw, filename, info);
			pw.flush();
						
		}catch(Exception e){
//            System.out.println("Exception - " + e.toString());
            e.printStackTrace(System.out);
            filename = "public_error_500x300.png";
		}
					
		return filename;
	}

	public ArrayList getTeleExpensesByDate(String startDate, String endDate) {
		
		ArrayList results = new ArrayList();
		
		try{
			Map mp = new HashMap();

			mp.put("beginDate",startDate);
			mp.put("endDate",endDate);
			
			List list = oaTeleExpensesDao.getOaTeleExpensesByDate(mp);
						
			for(Iterator it = list.iterator();it.hasNext();){
				OaTeleExpenses oaTeleExpenses = (OaTeleExpenses) it.next();
										
				results.add(oaTeleExpenses);

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return results;
	}

	public String teleExpensesChart(String startDate, String endDate, HttpSession session, PrintWriter pw) {

		String filename = null;
		
		try {
			ArrayList list = getTeleExpensesByDate(startDate,endDate);
						
			Iterator it = list.iterator();
			
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						
            while (it.hasNext()) {
            	OaTeleExpenses oaTeleExpenses = (OaTeleExpenses) it.next();
            	            	
            	dataset.addValue(oaTeleExpenses.getExpenses(), "Hits",oaTeleExpenses.getBranch().getName());
            }
            
            

			//  Create the chart object
			CategoryAxis categoryAxis = new CategoryAxis("");
			ValueAxis valueAxis = new NumberAxis("");
			BarRenderer3D renderer = new BarRenderer3D();
			renderer.setItemURLGenerator(new StandardCategoryURLGenerator("oaTeleExpensessQuery.jsp","series","section"));
			
			
            renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());

			Plot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
			JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
			chart.setBackgroundPaint(java.awt.Color.white);

			//  Write the chart image to the temporary directory
			ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
			filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, info, session);

			//  Write the image map to the PrintWriter
			ChartUtilities.writeImageMap(pw, filename, info);
			pw.flush();
						
		}catch(Exception e){
//            System.out.println("Exception - " + e.toString());
            e.printStackTrace(System.out);
            filename = "public_error_500x300.png";
		}
					
		return filename;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}


	public ArrayList getDataByHitMonth(String hitMonth, String startDate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList getDataByMonth(String hitMonth, String year, String[] carrierIds) {
		// TODO Auto-generated method stub
		return null;
	}
public ArrayList getAnalyCarrierMatterDate(String startDate, String endDate,String[] resourceIds){
		
		ArrayList results = new ArrayList();
		
		try{
			
			
			List ls = analyCarrierMatterManager.getAnalyCarrierMatterList(startDate,endDate,resourceIds);
			
			for(Iterator it = ls.iterator();it.hasNext();){
				AnalyzeClass anlyClass = (AnalyzeClass) it.next();
				results.add(anlyClass);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return results;
	}

public String analyCarrierMatterAnalyzeInCount(String startDate, String endDate, String[] resourceIds, HttpSession session, PrintWriter pw) {
	// TODO Auto-generated method stub
	String filename = null;
	
	try {
		ArrayList list = getAnalyCarrierMatterDate(startDate,endDate,resourceIds);
//		System.out.println(">>>>>   "+list.size());
		Iterator it = list.iterator();
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
					
        while (it.hasNext()) {
        	AnalyzeClass anlyClass = (AnalyzeClass) it.next();
        	if(anlyClass.getMatterName().length()>6)  {         	
        		dataset.addValue(anlyClass.getRelIncome(), "Hits",anlyClass.getMatterName().substring(0,6));
        	}else{
        		dataset.addValue(anlyClass.getRelIncome(), "Hits",anlyClass.getMatterName());
        	}	
        }
        
        

		//  Create the chart object
		CategoryAxis categoryAxis = new CategoryAxis("");
		ValueAxis valueAxis = new NumberAxis("");
		BarRenderer3D renderer = new BarRenderer3D();
		renderer.setItemURLGenerator(new StandardCategoryURLGenerator("analyCarrierMatter.jsp","series","section"));
		
		
        renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());
        

		Plot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
		
		//Font font = new Font("SansSerif",JFreeChart.DEFAULT_TITLE_FONT.BOLD,1);
		
		JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
//		System.out.println("   >>>>   "+JFreeChart.DEFAULT_TITLE_FONT);
		chart.setBackgroundPaint(java.awt.Color.white);

		//  Write the chart image to the temporary directory
		ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
		filename = ServletUtilities.saveChartAsPNG(chart, 900, 350, info, session);

		//  Write the image map to the PrintWriter
		ChartUtilities.writeImageMap(pw, filename, info);
		pw.flush();
					
	}catch(Exception e){
//        System.out.println("Exception - " + e.toString());
        e.printStackTrace(System.out);
        filename = "public_error_500x300.png";
	}
				
	return filename;
}
	

public String analyCarrierMatterTimeSum(String startDate, String endDate, String[] resourceIds, HttpSession session, PrintWriter pw) {
	// TODO Auto-generated method stub
String filename = null;
	
	try {
		ArrayList list = getAnalyCarrierMatterDate(startDate,endDate,resourceIds);
//		System.out.println(">>>>>   "+list.size());
		Iterator it = list.iterator();
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
					
        while (it.hasNext()) {
        	AnalyzeClass anlyClass = (AnalyzeClass) it.next();
        	if(anlyClass.getMatterName().length()>6)  {         	
        		dataset.addValue(anlyClass.getSumTimes(), "Hits",anlyClass.getMatterName().substring(0,6));
        	}else{
        		dataset.addValue(anlyClass.getSumTimes(), "Hits",anlyClass.getMatterName());
        	}	
        }
        
        

		//  Create the chart object
		CategoryAxis categoryAxis = new CategoryAxis("");
		ValueAxis valueAxis = new NumberAxis("");
		BarRenderer3D renderer = new BarRenderer3D();
		renderer.setItemURLGenerator(new StandardCategoryURLGenerator("analyCarrierMatter.jsp","series","section"));
		
		
        renderer.setToolTipGenerator(new StandardCategoryToolTipGenerator());
        

		Plot plot = new CategoryPlot(dataset, categoryAxis, valueAxis, renderer);
		
		//Font font = new Font("SansSerif",JFreeChart.DEFAULT_TITLE_FONT.BOLD,1);
		
		JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
//		System.out.println("   >>>>   "+JFreeChart.DEFAULT_TITLE_FONT);
		chart.setBackgroundPaint(java.awt.Color.white);

		//  Write the chart image to the temporary directory
		ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
		filename = ServletUtilities.saveChartAsPNG(chart, 900, 350, info, session);

		//  Write the image map to the PrintWriter
		ChartUtilities.writeImageMap(pw, filename, info);
		pw.flush();
					
	}catch(Exception e){
//        System.out.println("Exception - " + e.toString());
        e.printStackTrace(System.out);
        filename = "public_error_500x300.png";
	}
				
	return filename;
}

/**
 * @param carrierManager The carrierManager to set.
 */
public void setCarrierManager(CarrierManager carrierManager) {
	this.carrierManager = carrierManager;
}





	
}



