package com.vriche.adrm.util;


import java.awt.Color;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRElement;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExpression;
import net.sf.jasperreports.engine.JRImage;
import net.sf.jasperreports.engine.JRReport;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.base.JRBaseLine;
import net.sf.jasperreports.engine.base.JRBasePrintText;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JRDesignImage;
import net.sf.jasperreports.engine.design.JRDesignLine;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignStyle;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import net.sf.jasperreports.engine.design.JRDesignVariable;
import net.sf.jasperreports.engine.design.JasperDesign;

import org.apache.commons.beanutils.BasicDynaBean;
import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.collections.CollectionUtils;

import com.vriche.adrm.model.Org;

/*
 * �޸�ǰ
 * JasperReport jasperReport = (JasperReport)JRLoader.loadObject(reportFile.getPath());
 * 
 * �޸ĺ�
 * String[] headers = {"�ֶ�1", "�ֶ�2", "�ֶ�3", "�ֶ�4"}; 
 * String[] alias = preaseAliasColumnHeaders(headers);  
 * JasperReport jasperReport = getJasperReport(title,headers, alias); 
 */

public class JasperReportUtil {
	/** �����ֶο��? */  
//	private final static int textWidth = 80;  
	/** �����ֶθ߶� */  
	private final static int textHeight = 20;  
	/** coulumnHeader����������? */  
	private final static int columnHeaderfontSize = 14;  
	/** detail ����������? */  
	private final static int fontSize = 12;  
	/** ���ü��? */  
//	private final static int X = 80;  
	/** coulumnHeader����߶�? */  
	private final static int columnHeaderHeight = 20;  
	/** detail ����߶�? */  
	private final static int detailHeight = 20;  
	/**  */  
	private static String aliasColumn = "value";  

    
    
    /** 
     * �a��columnHeaders�Ąe��(Headers[]�п��ܞ����ģ������б�Ҫ�Äe�����Q)  
     * @param headers 
     * @return 
     */  
	public static String[] preaseAliasColumnHeaders(String headers[]) {  
     int size = headers.length;  
     String[] alias = new String[size];  
     if(alias.length > 0){
    	 alias[0] = "lable";
         for (int i = 1; i < size; i++) {  
        	 System.out.println("i>>>>>>>>>"+i);
             alias[i] = aliasColumn + (i);  
         }  
     }

     return alias;  
    }  
    /** 
     * �a��Template�ļ� 
     *  
     * @param headers 
     * @param alias 
     * @return 
     * @throws JRException 
     */  
	
	public static JasperReport getJasperReport(Map searchMap,Map parameters)   throws JRException {  
		String titl = (String)StringUtil.getURLDecoderStr((String)searchMap.get("title"));
		String reportType = (String)StringUtil.getURLDecoderStr((String)searchMap.get("reportType"));
		String header =  (String)StringUtil.getURLDecoderStr((String)searchMap.get("headers"));
		String header2 ="";
		boolean isqueryAdres2 = "queryAdres2".equals(reportType);
		if(isqueryAdres2){
			  header2 =  (String)StringUtil.getURLDecoderStr((String)searchMap.get("headers2")); 
//			  System.out.println(">>>>>>>>>"+header2+">>>>>>>>>>>>>>>>>>>>>>"+ header2.split(","));
		 }
		
		
		String displaySumColum =  (String)StringUtil.getURLDecoderStr((String)searchMap.get("displaySumColum"));
		String colAlign = StringUtil.getURLDecoderStr(StringUtil.getNullValue(searchMap.get("colAlign"),""));
		String widthsP = StringUtil.getURLDecoderStr(StringUtil.getNullValue(searchMap.get("widthsP"),""));
		
//		 System.out.println("colAlign************************************"+colAlign);
		
		
		boolean isSum = Boolean.valueOf((String)searchMap.get("isSum")).booleanValue();
		boolean isVertical = Boolean.valueOf((String)searchMap.get("isVertical")).booleanValue();
		String orgId = (String)StringUtil.getURLDecoderStr((String)searchMap.get("orgId"));
		if("".equals(orgId)) orgId ="1";
		String[] headers = header.split(",");
		String[] alias = JasperReportUtil.preaseAliasColumnHeaders(headers); 
		String[] displaySumColums = displaySumColum.split(","); 
		String[] colAligns = colAlign.split(","); 
		String[] widthsPs = widthsP.split(","); 
//		String[] titles = titl.split(",");
//		if(titles.length>1){
//			titl =titles[0]+"/n/r/t"+titles[1];
//		}
		

		  JasperDesign design = new JasperDesign();  
//		     JRDesignStyle normalStyle = setReportSytle(design);  
		     
		     int pageWidth = 595;
		     int pageHeight =842;
		     int pageColumnWidth =535;
		     
		     if(!isVertical){
		    	 pageWidth = 842;
		    	 pageHeight =595;
		    	 pageColumnWidth =782;
		     }
		      
		     // name="statistics"  
		     design.setName("statistics");  
		     // columnCount="1"  
		     // printOrder="Vertical"  
		     design.setPrintOrder(JRReport.PRINT_ORDER_VERTICAL);  
		 
		     if(isVertical){
		         // orientation="Portrait"  
		         design.setOrientation(JRReport.ORIENTATION_PORTRAIT);   
		     }else{
		         // orientation="Landscape"  
		         design.setOrientation(JRReport.ORIENTATION_LANDSCAPE);  
		     }
		     // pageWidth="595"  
		     design.setPageWidth(pageWidth);  
		     // pageHeight="842"  
		     design.setPageHeight(pageHeight);  
		     // columnWidth="535"  
		     design.setColumnWidth(pageColumnWidth);  
		     // columnSpacing="0"  
		     design.setColumnSpacing(0);  
		     // leftMargin="30"  
		     design.setLeftMargin(30);  
		     // rightMargin="30"  
		     design.setRightMargin(30);  
		     // topMargin="20"  
		     design.setTopMargin(20);  
		     // bottomMargin="20"  
		     design.setBottomMargin(20);  
		     // whenNoDataType="NoPages"  
		     design.setWhenNoDataType(JRReport.WHEN_NO_DATA_TYPE_BLANK_PAGE);  
		     // isTitleNewPage="false"  
		     design.setTitleNewPage(false);  
		     // isSummaryNewPage="false"  
		     design.setSummaryNewPage(false);  
		     
		     
	    	  int textWidth = pageColumnWidth/headers.length;
	    	  int X = textWidth;	   
		     
		      
		     JRDesignBand title = new JRDesignBand();  
		     title.setHeight(50);  
		     JRDesignStaticText staticText = new JRDesignStaticText();  
		     
		     staticText.setText(titl);  
//		     System.out.println(">>>>>>>>>"+widthsP+">>>>>>>>>>>>>>>>>>>>>>"+widthsP);
		     staticText.setX(0);
		     staticText.setFontSize(20);  
		     staticText.setHeight(50);  
		     staticText.setWidth(pageColumnWidth);  
		     staticText.setTextAlignment(JRBasePrintText.HORIZONTAL_ALIGN_CENTER);
		     staticText.setPdfFontName("STSong-Light");    
		     staticText.setPdfEmbedded(true);    
		     staticText.setPdfEncoding("UniGB-UCS2-H");
//		     staticText.setStyle(normalStyle);  
		     title.addElement(staticText);  
		     
		     drawLogoBand(design,title,orgId);
		     
		     JRDesignBand columnHeader = new JRDesignBand();  
		     columnHeader.setHeight(columnHeaderHeight);  
		      
		     JRDesignBand detail = new JRDesignBand();  
		     detail.setHeight(detailHeight);  
		     
		     
		     int tempSum = 0;
		     for (int i = 0; i < headers.length; i++) {  
		      // add column headers  
		      staticText = new JRDesignStaticText();  
		      staticText.setText(headers[i]);  
		      staticText.setFontSize(columnHeaderfontSize);  
		      staticText.setHeight(textHeight);  
		      
//		      System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.>>>>>11111111111111111111111>>>>>>>>>>>>>>>>>>>"+ header2.split(",")[i]);
		     
		      if(!"".equals(widthsP)){

		    	  if(i == headers.length-1){
		    		  textWidth = pageColumnWidth - tempSum;
		    		  X =  tempSum; 
		    		  widthsPs[i] = textWidth+"";
		    	  }else{

		    		  textWidth =  (int) Math.floor(pageColumnWidth * Double.valueOf(widthsPs[i]).doubleValue()/100);
//		    		  System.out.println(">>>>>>>>>"+textWidth+">>>>>>>>>>>>>>>>>>>>>>"+textWidth);
		    		  X =  tempSum; 
		    		  tempSum = tempSum + textWidth;
		    		  widthsPs[i] = textWidth+"";
		    	  }
		      }else{
		    	  X = X * i; 
		      }
		      
		      
//		      if(!"".equals(widthsP)){
//		    	  textWidth =  (int) Math.floor(pageColumnWidth * Integer.valueOf(widthsPs[i]).intValue()/100);
//		    	  widthsPs[i] = textWidth+"";
//		    	  X =  tempSum; 
//		    	  tempSum = tempSum + textWidth;
//		      }else{
//		    	  X = X * i; 
//		      }		      
		      
		      
		      staticText.setX(X); 
		      staticText.setWidth(textWidth);  
		      
		      
		      staticText.setPdfFontName("STSong-Light");  
		      staticText.setPdfEmbedded(true);  
		      staticText.setPdfEncoding("UniGB-UCS2-H");  
		      staticText.setTextAlignment(JRBasePrintText.HORIZONTAL_ALIGN_CENTER);  
		      
		      staticText.setLeftBorder(JRBaseLine.PEN_1_POINT);  
		      staticText.setTopBorder(JRBaseLine.PEN_1_POINT);  
		      if(i == headers.length-1){
		    	  staticText.setRightBorder(JRBaseLine.PEN_1_POINT);  
		      }

		      staticText.setBottomBorder(JRBaseLine.PEN_1_POINT);  
		      columnHeader.addElement(staticText);  
		      
		      // define fields  
		      JRDesignField field = new JRDesignField();  
		      field.setName(alias[i]);  
		      field.setValueClass(java.lang.String.class);  
		      design.addField(field);  
		      
		      // add text fields for displaying fields  
		      JRDesignTextField textField = new JRDesignTextField();  
		      JRDesignExpression expression = new JRDesignExpression();  
		      
			  expression.setValueClass(java.lang.String.class);  
			  expression.setText("$F{" + alias[i] + "}");  
			  
//			  if(displaySumColums[i].equals("1")){
//				  textField.setTextAlignment(JRBasePrintText.HORIZONTAL_ALIGN_RIGHT);
//			  }else{
//				  textField.setTextAlignment(JRBasePrintText.HORIZONTAL_ALIGN_CENTER);   
//			  }
			  if("".equals(colAlign)){
				  textField.setTextAlignment(JRBasePrintText.HORIZONTAL_ALIGN_CENTER);   
			  }else{
				  textField.setTextAlignment(getAlign(colAligns[i]));   
			  }
			
			  

//			  textField.setPositionType(JRElement.POSITION_TYPE_FLOAT);
			  textField.setMode(JRElement.MODE_TRANSPARENT);
			  textField.setPositionType(JRElement.POSITION_TYPE_FIX_RELATIVE_TO_TOP);
			  textField.setStretchType(JRElement.STRETCH_TYPE_RELATIVE_TO_BAND_HEIGHT);
			  textField.setStretchWithOverflow(true);
			
	
//			  if("queryAdres2".equals(reportType)){
//				  System.out.println("AAAAAAAAAAAAAA ************************************"+ "$F{" + alias[i] + "}");
//				  textField.setUnderline(true);
//			  }
			  
		      textField.setExpression(expression);  
		      textField.setFontSize(fontSize);  
		      textField.setHeight(textHeight);  
		      textField.setWidth(textWidth);  
		      textField.setX(X);  
		      textField.setPdfFontName("STSong-Light");  
		      textField.setPdfEmbedded(true);  
		      textField.setPdfEncoding("UniGB-UCS2-H");  

		      
		      textField.setLeftBorder(JRBaseLine.PEN_1_POINT);  
//		      textField.setTopBorder(JRBaseLine.PEN_1_POINT);  
		      if(i == headers.length-1){
		    	  textField.setRightBorder(JRBaseLine.PEN_1_POINT);  
		      }
		      textField.setBottomBorder(JRBaseLine.PEN_1_POINT);  
		      
		      detail.addElement(textField);  
		      
		     }  
		     

		     design.setTitle(title); 
		     design.setColumnHeader(columnHeader);  
		     design.setDetail(detail);
		     
		     drawColumnFooterBand(design,pageColumnWidth);
		     drawPageFooterBand(design,pageColumnWidth,pageWidth);
		
		     
		     drawSumBand(design,displaySumColums,alias,textWidth,X,isSum,widthsPs);
		     
		     JasperReport jasperReport = JasperCompileManager.compileReport(design);  		
		   

		     return jasperReport;  		
		

	}
	
	public static byte getAlign(String s){
		if("left".equals(s))
			return JRBasePrintText.HORIZONTAL_ALIGN_LEFT;
		if("right".equals(s))
			return JRBasePrintText.HORIZONTAL_ALIGN_RIGHT;
		if("center".equals(s))
			return JRBasePrintText.HORIZONTAL_ALIGN_CENTER;
		return 0;
  }
	 
	
	
    public static JasperReport getJasperReport(String titl,String[] headers,  
      String alias[],String[] displaySumColum,boolean isSum,boolean isVertical,String orgId) throws JRException {  
    	
     JasperDesign design = new JasperDesign();  
//     JRDesignStyle normalStyle = setReportSytle(design);  
     
     int pageWidth = 595;
     int pageHeight =842;
     int pageColumnWidth =535;
     
     if(!isVertical){
    	 pageWidth = 842;
    	 pageHeight =595;
    	 pageColumnWidth =782;
     }
      
     // name="statistics"  
     design.setName("statistics");  
     // columnCount="1"  
     // printOrder="Vertical"  
     design.setPrintOrder(JRReport.PRINT_ORDER_VERTICAL);  
 
     if(isVertical){
         // orientation="Portrait"  
         design.setOrientation(JRReport.ORIENTATION_PORTRAIT);   
     }else{
         // orientation="Landscape"  
         design.setOrientation(JRReport.ORIENTATION_LANDSCAPE);  
     }
     // pageWidth="595"  
     design.setPageWidth(pageWidth);  
     // pageHeight="842"  
     design.setPageHeight(pageHeight);  
     // columnWidth="535"  
     design.setColumnWidth(pageColumnWidth);  
     // columnSpacing="0"  
     design.setColumnSpacing(0);  
     // leftMargin="30"  
     design.setLeftMargin(30);  
     // rightMargin="30"  
     design.setRightMargin(30);  
     // topMargin="20"  
     design.setTopMargin(20);  
     // bottomMargin="20"  
     design.setBottomMargin(20);  
     // whenNoDataType="NoPages"  
     design.setWhenNoDataType(JRReport.WHEN_NO_DATA_TYPE_BLANK_PAGE);  
     // isTitleNewPage="false"  
     design.setTitleNewPage(false);  
     // isSummaryNewPage="false"  
     design.setSummaryNewPage(false);  
     
     
     int textWidth = pageColumnWidth/headers.length;
     int X = textWidth;
      
     JRDesignBand title = new JRDesignBand();  
     title.setHeight(50);  
     JRDesignStaticText staticText = new JRDesignStaticText();  
     staticText.setText(titl);  
//     System.out.println(">>>>>>>>>"+titl+">>>>>>>>>>>>>>>>>>>>>>"+titl);
     staticText.setX(0);
     staticText.setFontSize(20);  
     staticText.setHeight(50);  
     staticText.setWidth(pageColumnWidth);  
     staticText.setTextAlignment(JRBasePrintText.HORIZONTAL_ALIGN_CENTER);
     staticText.setPdfFontName("STSong-Light");    
     staticText.setPdfEmbedded(true);    
     staticText.setPdfEncoding("UniGB-UCS2-H");
//     staticText.setStyle(normalStyle);  
     title.addElement(staticText);  
     
     drawLogoBand(design,title,orgId);
     
     JRDesignBand columnHeader = new JRDesignBand();  
     columnHeader.setHeight(columnHeaderHeight);  
      
     JRDesignBand detail = new JRDesignBand();  
     detail.setHeight(detailHeight);  
     
     
      
     for (int i = 0; i < headers.length; i++) {  
      // add column headers  
      staticText = new JRDesignStaticText();  
      staticText.setText(headers[i]);  
      staticText.setFontSize(columnHeaderfontSize);  
      staticText.setHeight(textHeight);  
      staticText.setWidth(textWidth);  
      staticText.setX(X * i);  
      staticText.setPdfFontName("STSong-Light");  
      staticText.setPdfEmbedded(true);  
      staticText.setPdfEncoding("UniGB-UCS2-H");  
      staticText.setTextAlignment(JRBasePrintText.HORIZONTAL_ALIGN_CENTER);  
      
      staticText.setLeftBorder(JRBaseLine.PEN_1_POINT);  
      staticText.setTopBorder(JRBaseLine.PEN_1_POINT);  
      if(i == headers.length-1){
    	  staticText.setRightBorder(JRBaseLine.PEN_1_POINT);  
      }

      staticText.setBottomBorder(JRBaseLine.PEN_1_POINT);  
      columnHeader.addElement(staticText);  
      
      // define fields  
      JRDesignField field = new JRDesignField();  
      field.setName(alias[i]);  
      field.setValueClass(java.lang.String.class);  
      design.addField(field);  
      
      // add text fields for displaying fields  
      JRDesignTextField textField = new JRDesignTextField();  
      JRDesignExpression expression = new JRDesignExpression();  
      
	  expression.setValueClass(java.lang.String.class);  
	  expression.setText("$F{" + alias[i] + "}");  
	  
	  if(displaySumColum[i].equals("1")){
		  textField.setTextAlignment(JRBasePrintText.HORIZONTAL_ALIGN_RIGHT);
	  }else{
		  textField.setTextAlignment(JRBasePrintText.HORIZONTAL_ALIGN_CENTER);   
	  }
	 
	  
	  
	  
	
	  
	  
//      if(i == 0){
//    	  expression.setValueClass(java.lang.String.class);  
//    	  expression.setText("$F{" + alias[i] + "}");  
//    	  textField.setTextAlignment(JRBasePrintText.HORIZONTAL_ALIGN_CENTER);  
//      }else{
//    	  expression.setValueClass(java.lang.Double.class);  
//    	  expression.setText("new java.lang.Double($F{" + alias[i] + "})");
//    	  textField.setPattern("##0.###");
//    	  textField.setTextAlignment(JRBasePrintText.HORIZONTAL_ALIGN_RIGHT);  
//      }
//	  textField.setPositionType(JRElement.POSITION_TYPE_FLOAT);
	  
	  textField.setMode(JRElement.MODE_TRANSPARENT);
	  textField.setPositionType(JRElement.POSITION_TYPE_FIX_RELATIVE_TO_TOP);
	  textField.setStretchType(JRElement.STRETCH_TYPE_RELATIVE_TO_BAND_HEIGHT);
	  textField.setStretchWithOverflow(true);
	
      textField.setExpression(expression);  
      textField.setFontSize(fontSize);  
      textField.setHeight(textHeight);  
      textField.setWidth(textWidth);  
      textField.setX(X * i);  
      textField.setPdfFontName("STSong-Light");  
      textField.setPdfEmbedded(true);  
      textField.setPdfEncoding("UniGB-UCS2-H");  
      
//      textField.setLeftBorder(JRBaseLine.PEN_1_POINT);  
//      textField.setTopBorder(JRBaseLine.PEN_1_POINT);  
//      textField.setRightBorder(JRBaseLine.PEN_1_POINT);  
//      textField.setBottomBorder(JRBaseLine.PEN_1_POINT);  
      
      
      textField.setLeftBorder(JRBaseLine.PEN_1_POINT);  
//      textField.setTopBorder(JRBaseLine.PEN_1_POINT);  
      if(i == headers.length-1){
    	  textField.setRightBorder(JRBaseLine.PEN_1_POINT);  
      }
      textField.setBottomBorder(JRBaseLine.PEN_1_POINT);  
      
      detail.addElement(textField);  
      
     }  
     

     design.setTitle(title); 
     design.setColumnHeader(columnHeader);  
     design.setDetail(detail);
     
     drawColumnFooterBand(design,pageColumnWidth);
     drawPageFooterBand(design,pageColumnWidth,pageWidth);
//     drawSumBand(design,displaySumColum,alias,textWidth,X,isSum);
    

     return JasperCompileManager.compileReport(design);  
     
    }  
    
    
    public static void drawSumBand(JasperDesign design,String[] displaySumColum,String[] alias,int textWidth,int X,boolean isSum,String[] widthsPs)throws JRException {

   	 JRDesignBand sumBand = new JRDesignBand();
     sumBand.setHeight(textHeight);    	
     
     
    
     
     int sum = 0;
     for (int i = 0; i < alias.length; i++) {
    	 
    	 if(!"".equals(widthsPs[0])){
        	 textWidth = Double.valueOf(widthsPs[i]).intValue();
        	 X = sum;
        	 sum = sum + textWidth; 
    	 }else{
    		 X = X * i;
    	 }


			
    	 if (i == 0) {
				JRDesignStaticText sumTextField = new JRDesignStaticText();
				sumTextField.setText("�ϼ�:");
				sumTextField.setFontSize(fontSize);
				sumTextField.setX(X);
				sumTextField.setWidth(textWidth);
				sumTextField.setHeight(textHeight);
				
				if(!isSum) sumTextField.setHeight(1);
				
				

				sumTextField.setPdfFontName("STSong-Light");
				sumTextField.setPdfEmbedded(true);
				sumTextField.setPdfEncoding("UniGB-UCS2-H");
				sumTextField.setTextAlignment(JRBasePrintText.HORIZONTAL_ALIGN_CENTER);
				sumTextField.setLeftBorder(JRBaseLine.PEN_1_POINT);
//				sumTextField.setTopBorder(JRBaseLine.PEN_1_POINT);
//				sumTextField.setRightBorder(JRBaseLine.PEN_1_POINT);
				sumTextField.setBottomBorder(JRBaseLine.PEN_1_POINT);
				sumBand.addElement(sumTextField); 
				
    	 }else{
	
    		 	if(isSum && displaySumColum[i].equals("1")){
    		 		
       				JRDesignTextField sumTextField = new JRDesignTextField();
    				JRDesignVariable variable = new JRDesignVariable();
    				variable.setName(alias[i]);
    				variable.setValueClass(java.lang.Double.class);
    			
    				JRDesignExpression initExpre = new JRDesignExpression();
    				initExpre.setValueClass(java.lang.Double.class);
    				initExpre.setText("new java.lang.Double(0)");
    				variable.setCalculation(variable.CALCULATION_SUM);
    				variable.setInitialValueExpression(initExpre);

    				JRDesignExpression varExpression = new JRDesignExpression();
    				varExpression.setText("new java.lang.Double($F{" + alias[i]+ "})");
    				varExpression.setValueClass(java.lang.Double.class);
    				variable.setExpression(varExpression);

    				design.addVariable(variable);

    				JRDesignExpression expression3 = new JRDesignExpression();
    				expression3.setText("$V{" + alias[i] + "}");
    				expression3.setValueClass(java.lang.Double.class);
    				sumTextField.setExpression(expression3);
    				sumTextField.setPattern("##0.###");
    				sumTextField.setFontSize(fontSize);
    				sumTextField.setHeight(textHeight);
    				sumTextField.setWidth(textWidth);
    				sumTextField.setX(X);
    				
    				if(!isSum) sumTextField.setHeight(1);
    				
    				
    				
    				sumTextField.setPdfFontName("STSong-Light");
    				sumTextField.setPdfEmbedded(true);
    				sumTextField.setPdfEncoding("UniGB-UCS2-H");
    				sumTextField.setTextAlignment(JRBasePrintText.HORIZONTAL_ALIGN_RIGHT);
//    				sumTextField.setLeftBorder(JRBaseLine.PEN_1_POINT);
//    				sumTextField.setTopBorder(JRBaseLine.PEN_1_POINT);
//    				sumTextField.setRightBorder(JRBaseLine.PEN_1_POINT);
//    				sumTextField.setBottomBorder(JRBaseLine.PEN_1_POINT);
    				
    				
    				sumTextField.setLeftBorder(JRBaseLine.PEN_1_POINT);  
//    				sumTextField.setTopBorder(JRBaseLine.PEN_1_POINT);  
    				sumTextField.setBottomBorder(JRBaseLine.PEN_1_POINT);
    			    if(i == alias.length-1){
    			    	sumTextField.setRightBorder(JRBaseLine.PEN_1_POINT);  
    			     }

    				sumBand.addElement(sumTextField);    		 	
					
    				
    		 	}else{
    				JRDesignStaticText sumTextField = new JRDesignStaticText();
    				sumTextField.setText("");
    				sumTextField.setFontSize(fontSize);
    				sumTextField.setWidth(textWidth);
    				sumTextField.setHeight(textHeight);
    				
    				if(!isSum) sumTextField.setHeight(1);
    				
    				
    				sumTextField.setX(X);
    				sumTextField.setPdfFontName("STSong-Light");
    				sumTextField.setPdfEmbedded(true);
    				sumTextField.setPdfEncoding("UniGB-UCS2-H");
    				sumTextField.setTextAlignment(JRBasePrintText.HORIZONTAL_ALIGN_CENTER);
    				sumTextField.setLeftBorder(JRBaseLine.PEN_1_POINT);
//    				sumTextField.setTopBorder(JRBaseLine.PEN_1_POINT);
//    				sumTextField.setRightBorder(JRBaseLine.PEN_1_POINT);
    				sumTextField.setBottomBorder(JRBaseLine.PEN_1_POINT);
    				
    			    if(i == alias.length-1){
    			    	sumTextField.setRightBorder(JRBaseLine.PEN_1_POINT);  
    			     }
    			    
    				sumBand.addElement(sumTextField);     		 		
    		 	}
    	 }
    
    	 
    	 
     }
    	
     design.setSummary(sumBand);
    }
    
    public static void  drawLogoBand(JasperDesign design,JRDesignBand band,String orgId){
    	
        Org org = SysParamUtil.getOrgFromMap(orgId);	
        String logoFileRealPath = org.getLogFileRel();
//    	String logoFileRealPath = (String)Constants.APPLACTION_MAP.get(Constants.APP_SYS_LOGO_FILE);
    	
    	
        JRDesignImage staticImage = new JRDesignImage(design);  
        staticImage.setX(10);
//		staticImage.setY(10);
		staticImage.setHeight(40);
		staticImage.setWidth(40);
		staticImage.setScaleImage(JRImage.SCALE_IMAGE_RETAIN_SHAPE);
//		staticImage.setScaleImage(JRDesignImage.SCALE_IMAGE_CLIP);
		staticImage.setLazy(true);
        staticImage.setHorizontalAlignment(JRDesignImage.HORIZONTAL_ALIGN_CENTER);  
//        staticImage.setEvaluationTime(JRExpression.EVALUATION_TIME_NOW);
//        staticImage.setScaleImage(JRDesignImage.SCALE_IMAGE_CLIP); 
//    	staticImage.setHyperlinkType(JRDesignImage.HYPERLINK_TYPE_REFERENCE);
    	
        JRDesignExpression expression = new JRDesignExpression();  
        expression.setValueClass(File.class);
        String f = StringUtil.oldReplace(logoFileRealPath, "\\", "/");
        expression.setText("new File(\"" + f + "\")");
        staticImage.setExpression(expression);
        
//        JRDesignParameter parameter = new JRDesignParameter();
//
//        parameter.setName("scritturaChart");
//        parameter.setValueClass(java.awt.Image.class);
//        try {
//			design.addParameter(parameter);
//		} catch (JRException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
        
//        JRDesignExpression expression = new JRDesignExpression();  
//        expression.setValueClass(java.awt.Image.class);
//        expression.setText("$P{scritturaChart}");
//        staticImage.setExpression(expression);
   
        
//          expression.setValueClass(Image.class); 
//        expression.setValueClass(JRRenderable.class); 
//        String f = StringUtil.oldReplace(logoFileRealPath,"\\","/");
//        expression.setText("new File(\""+ f +"\")");
//          Image img = new ()
//        File imgFile = new File(f);
//        expression.setText(imgFile.getPath());
//        expression.setText("new File(\"C:/logo.jpg\")");
//        staticImage.setExpression(expression); 
//        File imgFile = new File( f);
//        FileInputStream in = new FileInputStream(f);
//        byte[] buffer = net.sf.jasperreports.engine.util.JRImageLoader.loadImageDataFromInputStream(in);
//        staticImage.setFill(buffer);
        band.addElement(staticImage);
    }
    
    public static void drawColumnFooterBand(JasperDesign design,int pageColumnWidth){
    	// Column footer  
    	JRDesignBand band = new JRDesignBand();  
    	band.setHeight(0);  
    	design.setColumnFooter(band);  
    }

    public static void drawPageFooterBand(JasperDesign design,int pageColumnWidth,int pageWidth) throws JRException{
    	
    	
    	
    	// Column footer  
    	JRDesignBand band = new JRDesignBand();  

    	band.setHeight(20);  
   
    	JRDesignLine line2 = new JRDesignLine();          
    	line2.setX(0);  
    	line2.setY(-10);  
    	line2.setWidth(pageColumnWidth);  
    	line2.setHeight(0);  
//    	line2.setForecolor(new Color(0x99,0xFF,0xFF));  
    	line2.setForecolor(Color.black);  
    	
//    	band.addElement(line2);  
//     	int pos = pageWidth - (pageWidth -pageColumnWidth)/2 -120;  
    	JRDesignStaticText staticText = new JRDesignStaticText();  
    	staticText.setX(pageColumnWidth-111);   
    	staticText.setY(0);  
    	staticText.setWidth(110);  
    	staticText.setHeight(20);  
    	staticText.setPdfFontName("STSong-Light");     
    	staticText.setPdfEmbedded(true);     
    	staticText.setPdfEncoding("UniGB-UCS2-H");    
    	staticText.setTextAlignment(JRBasePrintText.HORIZONTAL_ALIGN_RIGHT);
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");  
    	staticText.setText(sdf.format(new Date())); 
//    	staticText.setText("打印时间:"+ sdf.format(new Date())); 
    	
    	band.addElement(staticText);  
    	
    	
    	staticText = new JRDesignStaticText(); 
    	 
    	
    	int X = (pageColumnWidth/2)-45;
    	
    	staticText.setX(X);   X +=15;
    	staticText.setY(0);  
    	staticText.setWidth(15);  
    	staticText.setHeight(20);  
    	staticText.setPdfFontName("STSong-Light");     
    	staticText.setPdfEmbedded(true);     
    	staticText.setPdfEncoding("UniGB-UCS2-H");      	
    	staticText.setText("��"); 
    	staticText.setTextAlignment(JRBasePrintText.HORIZONTAL_ALIGN_RIGHT);
    	band.addElement(staticText);  
    	  
    	
    	JRDesignTextField textField = new JRDesignTextField(); 
    	textField.setX(X); 
    	textField.setY(0);  
    	textField.setWidth(20); X +=20;   
    	textField.setHeight(20);  
    	textField.setPdfFontName("STSong-Light");     
    	textField.setPdfEmbedded(true);     
    	textField.setPdfEncoding("UniGB-UCS2-H");    
//    	textField.setPositionType(JRElement.POSITION_TYPE_FLOAT);
    	textField.setMode(JRElement.MODE_TRANSPARENT);
        textField.setStretchWithOverflow(true);
    	JRDesignExpression expression = new JRDesignExpression();  
    	expression.setValueClass(java.lang.Integer.class);   
    	expression.setText("$V{PAGE_NUMBER}"); 
    	textField.setExpression(expression);  
    	textField.setEvaluationTime(JRExpression.EVALUATION_TIME_NOW);
    	textField.setTextAlignment(JRBasePrintText.HORIZONTAL_ALIGN_RIGHT);
    	band.addElement(textField);

    	
    	staticText = new JRDesignStaticText();  
    	staticText.setX(X);  
    	staticText.setY(0);  
    	staticText.setWidth(10);   X +=10;
    	staticText.setHeight(20);  
    	staticText.setPdfFontName("STSong-Light");     
    	staticText.setPdfEmbedded(true);     
    	staticText.setPdfEncoding("UniGB-UCS2-H");    
    	staticText.setTextAlignment(JRBasePrintText.HORIZONTAL_ALIGN_LEFT);
    	staticText.setText("/"); 
    	band.addElement(staticText);  
    	
    	
    	textField = new JRDesignTextField(); 
    	textField.setX(X);
    	textField.setY(0);  
    	textField.setWidth(20);  X +=20;  
//    	textField.setPositionType(JRElement.MODE_TRANSPARENT);
    	textField.setMode(JRElement.MODE_TRANSPARENT);
        textField.setStretchWithOverflow(true);

    	textField.setHeight(20);  
    	textField.setPdfFontName("STSong-Light");     
    	textField.setPdfEmbedded(true);     
    	textField.setPdfEncoding("UniGB-UCS2-H");    
    	textField.setTextAlignment(JRBasePrintText.HORIZONTAL_ALIGN_LEFT);
    	textField.setEvaluationTime(JRExpression.EVALUATION_TIME_REPORT);
    	expression = new JRDesignExpression();  
    	expression.setValueClass(java.lang.Integer.class);   
    	expression.setText("$V{PAGE_NUMBER}");  
    	textField.setExpression(expression);  

    	band.addElement(textField);   

    	
    	
    	staticText = new JRDesignStaticText(); 
    	staticText.setX(X);
    	staticText.setY(0);  
    	staticText.setWidth(15);  
    	staticText.setHeight(20);  
    	staticText.setPdfFontName("STSong-Light");     
    	staticText.setPdfEmbedded(true);     
    	staticText.setPdfEncoding("UniGB-UCS2-H");      	
    	staticText.setText("ҳ"); 
    	staticText.setTextAlignment(JRBasePrintText.HORIZONTAL_ALIGN_LEFT);
    	band.addElement(staticText);     	
    	
    	design.setPageFooter(band);  
    }   
    
    private static JRDesignStyle setReportSytle(JasperDesign jasperDesign)  throws JRException {  
    	JRDesignStyle normalStyle = new JRDesignStyle();
		normalStyle.setName("Arial_Normal");
		normalStyle.setDefault(true);
		normalStyle.setFontName("Arial");
		normalStyle.setFontSize(12);
		normalStyle.setPdfFontName("STSong-Light");
		normalStyle.setPdfEncoding("UniGB-UCS2-H");
		normalStyle.setPdfEmbedded(true);
		jasperDesign.addStyle(normalStyle);

		JRDesignStyle boldStyle = new JRDesignStyle();
		boldStyle.setName("Arial_Bold");
		boldStyle.setFontName("Arial");
		boldStyle.setFontSize(12);
		boldStyle.setBold(true);
		boldStyle.setPdfFontName("STSong-Light");
		boldStyle.setPdfEncoding("UniGB-UCS2-H");
		boldStyle.setPdfEmbedded(true);
		jasperDesign.addStyle(boldStyle);

		JRDesignStyle italicStyle = new JRDesignStyle();
		italicStyle.setName("Arial_Italic");
		italicStyle.setFontName("Arial");
		italicStyle.setFontSize(12);
		italicStyle.setItalic(true);
		italicStyle.setPdfFontName("STSong-Light");
		italicStyle.setPdfEncoding("UniGB-UCS2-H");
		italicStyle.setPdfEmbedded(true);
		jasperDesign.addStyle(italicStyle);
		return normalStyle;  	
    }
  
    
    /**
	 * ���÷�����ƣ�װ�����
	 * 
	 * @param headers
	 * @param list
	 * @return
	 * @throws Exception
	 */  
    public static List getBaseList(String[] headers, List ls,Object tarObj) throws Exception {  
    	
     List list = ConvertUtil.convertobjList2ArrayList(ls,tarObj);
     List result = new ArrayList();  
     int length = headers.length;  
     DynaProperty[] dynaProps = new DynaProperty[length];  
     for (int i = 0; i < length; i++) {  
      dynaProps[i] = new DynaProperty(headers[i], String.class);  
     }  
     BasicDynaClass dynaClass = new BasicDynaClass("first",BasicDynaBean.class, dynaProps); 
     
     for (Iterator it = list.iterator();it.hasNext();){
    	   String[] objs = (String[]) it.next();
	       DynaBean employee = dynaClass.newInstance();  
	       for (int i = 0; i < length; i++) {  
	    	   employee.set(headers[i], objs[i]);  
	       }  
	       result.add(employee);      	 
     }
//     System.out.println("result.size>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+result.size());
     return result;  
    }     
    
    public static Collection getBaseList2Collection(String[] headers, List ls,Object tarObj) {  
    	List list = new ArrayList();  
		try {
			list = getBaseList(headers,ls,tarObj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Collection result =new ArrayList();  
    	CollectionUtils.addAll(result,list.iterator());
        return result;  
    }    
    
//    private JasperPrint getReportForImageTesting() {
//
//
//
//        JasperPrint reportPrintObj = null;
//
//
//
//        try {
//
//
//
//            //Setting the scriptlet class
//
//            JasperDesign reportDesignObj = new JasperDesign();          
//            
//            reportDesignObj.setScriptletClass("com.mypkg.JFreeChartScriptlet");
//
//
//
//            //Setting the scriptlet variable
//
//            JRDesignVariable scriptletVar = new JRDesignVariable();
//
//            scriptletVar.setName("Chart");
//
//            scriptletVar.setValueClass(net.sf.jasperreports.engine.JRRenderable.class);
//
//            scriptletVar.setSystemDefined(true);
//
//            reportDesignObj.addVariable(scriptletVar);
//
//            reportDesignObj.setName("Sample Report Name");
//
//
//
//            JRDesignBand band = new JRDesignBand();
//
//            band.setHeight(500);
//
//
//
//            reportDesignObj.setTitle(band);
//
//
//
//            //** DYNAMIC IMAGE FROM SCRIPTLET **//
//
//            JRDesignImage dynamicImageFromScriptlet = new JRDesignImage(reportDesignObj);
//
//            dynamicImageFromScriptlet.setX(0);
//
//            dynamicImageFromScriptlet.setY(50);
//
//            dynamicImageFromScriptlet.setHeight(300);
//
//            dynamicImageFromScriptlet.setWidth(515);
//
//            dynamicImageFromScriptlet.setScaleImage(JRImage.SCALE_IMAGE_CLIP);
//
//
//
//            JRDesignExpression dynamicImageExpression = new JRDesignExpression();
//
//            dynamicImageExpression.setValueClass(net.sf.jasperreports.engine.JRRenderable.class);
//
//            dynamicImageExpression.setText("$V{Chart}");
//
//            dynamicImageFromScriptlet.setExpression(dynamicImageExpression);
//
//            band.addElement(dynamicImageFromScriptlet);
//
//
//
//            //** STATIC IMAGE RESIDING ON LOCAL MACHINE **//
//
//            JRDesignImage staticImage = new JRDesignImage(reportDesignObj);
//
//            staticImage.setX(0);
//
//            staticImage.setY(50);
//
//            staticImage.setHeight(300);
//
//            staticImage.setWidth(700);
//
//            staticImage.setScaleImage(JRImage.SCALE_IMAGE_CLIP);
//
//            staticImage.setLazy(true);
//
//
//
//            JRDesignExpression staticImageExpression = new JRDesignExpression();
//
//            staticImageExpression.setValueClass(String.class);
//
//            staticImageExpression.setText("C:/chart.jpg");
//
//            staticImage.setExpression(staticImageExpression);
//
//
//
//            //**Adding both images to the band **//
//
//            band.addElement(dynamicImageFromScriptlet);
//
//            band.addElement(staticImage);
//
//
//
//            //Compile the report
//
//            JasperReport reportObj = JasperCompileManager.compileReport(reportDesignObj);
//
//
//
//            //Fill the report
//
//            reportPrintObj = JasperFillManager.fillReport(reportObj, null, new JREmptyDataSource());
//
//
//
//            /** Content in JRXML file of samples/jfreechart directory **/
//
//            //  <variable name="Chart" class="net.sf.jasperreports.engine.JRRenderable" calculation="System"/>
//
//            //	<image scaleImage="Clip" hAlign="Center" hyperlinkType="Reference">
//
//            //		<reportElement x="0" y="110" width="515" height="300"/>
//
//            //		<graphicElement/>
//
//            //		<imageExpression class="net.sf.jasperreports.engine.JRRenderable"><![CDATA[$V{Chart}]]></imageExpression>
//
//            //		<hyperlinkReferenceExpression><![CDATA["http://www.jfree.org/jfreechart"]]></hyperlinkReferenceExpression>
//
//            //	</image>
//
//
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//        }
//
//        return reportPrintObj;
//
//    }
    
}
