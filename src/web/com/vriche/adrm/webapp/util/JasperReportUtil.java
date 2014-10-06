package com.vriche.adrm.webapp.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRReport;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.base.JRBaseLine;
import net.sf.jasperreports.engine.base.JRBasePrintText;
import net.sf.jasperreports.engine.design.JRDesignBand;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignField;
import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import net.sf.jasperreports.engine.design.JRDesignVariable;
import net.sf.jasperreports.engine.design.JasperDesign;

import org.apache.commons.beanutils.BasicDynaBean;
import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.collections.CollectionUtils;

import com.vriche.adrm.util.ConvertUtil;

/*
 * 修改前
 * JasperReport jasperReport = (JasperReport)JRLoader.loadObject(reportFile.getPath());
 * 
 * 修改后
 * String[] headers = {"字段1", "字段2", "字段3", "字段4"}; 
 * String[] alias = preaseAliasColumnHeaders(headers);  
 * JasperReport jasperReport = getJasperReport(title,headers, alias); 
 */

public class JasperReportUtil {
	/** 设置字段宽度 */  
//	private final static int textWidth = 80;  
	/** 设置字段高度 */  
	private final static int textHeight = 20;  
	/** coulumnHeader区域字体大小 */  
	private final static int columnHeaderfontSize = 14;  
	/** detail 区域字体大小 */  
	private final static int fontSize = 12;  
	/** 设置间距 */  
//	private final static int X = 80;  
	/** coulumnHeader区域高度 */  
	private final static int columnHeaderHeight = 20;  
	/** detail 区域高度 */  
	private final static int detailHeight = 20;  
	/**  */  
	private static String aliasColumn = "value";  

    
    
    /** 
     * 產生columnHeaders的別名(Headers[]有可能為中文，所以有必要用別名來替換)  
     * @param headers 
     * @return 
     */  
	public static String[] preaseAliasColumnHeaders(String headers[]) {  
     int size = headers.length;  
     String[] alias = new String[size];  
     for (int i = 0; i < size; i++) {  
      alias[i] = aliasColumn + (i+1);  
     }  
     return alias;  
    }  
    /** 
     * 產生Template文件 
     *  
     * @param headers 
     * @param alias 
     * @return 
     * @throws JRException 
     */  
    public static JasperReport getJasperReport(String reportType,String titl,String[] headers,  
      String alias[],String[] displaySumColum,boolean isSum,boolean isVertical) throws JRException {  
    	
     JasperDesign design = new JasperDesign();  
   
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
     // orientation="Portrait"  
     design.setOrientation(JRReport.ORIENTATION_PORTRAIT);  
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
     JRDesignStaticText titleText = new JRDesignStaticText();  
     titleText.setText(titl);  
     titleText.setX(0);
     titleText.setFontSize(20);  
     titleText.setHeight(50);  
     titleText.setWidth(535);  
     titleText.setTextAlignment(JRBasePrintText.HORIZONTAL_ALIGN_CENTER);
     title.addElement(titleText);  
     
     JRDesignBand columnHeader = new JRDesignBand();  
     columnHeader.setHeight(columnHeaderHeight);  
      
     JRDesignBand detail = new JRDesignBand();  
     detail.setHeight(detailHeight);  
     
     
      
     for (int i = 0; i < headers.length; i++) {  
      // add column headers  
      JRDesignStaticText staticText = new JRDesignStaticText();  
      staticText.setText(headers[i]);  
      staticText.setFontSize(columnHeaderfontSize);  
      staticText.setHeight(textHeight);  
      staticText.setWidth(textWidth);  
      staticText.setX(X * i);  
      staticText.setPdfFontName("MHei-Medium");  
      staticText.setPdfEmbedded(true);  
      staticText.setPdfEncoding("UniCNS-UCS2-H");  
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
	 
	  
	  
//	  reportType queryAdres2
	
//	  if("queryAdres2".equals(reportType)){
//		  textField.setUnderline(true);
//	  }
	  
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

      textField.setExpression(expression);  
      textField.setFontSize(fontSize);  
      textField.setHeight(textHeight);  
      textField.setWidth(textWidth);  
      textField.setX(X * i);  
      textField.setPdfFontName("MHei-Medium");  
      textField.setPdfEmbedded(true);  
      textField.setPdfEncoding("UniCNS-UCS2-H");  
      
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
     

     drawSumBand(design,displaySumColum,alias,textWidth,X,isSum);
    

     return JasperCompileManager.compileReport(design);  
     
    }  
    
    
    public static void drawSumBand(JasperDesign design,String[] displaySumColum,String[] alias,int textWidth,int X,boolean isSum)throws JRException {
    	
   	 JRDesignBand sumBand = new JRDesignBand();
     sumBand.setHeight(textHeight);    	
     
     for (int i = 0; i < alias.length; i++) {
    	 

			
    	 if (i == 0) {
				JRDesignStaticText sumTextField = new JRDesignStaticText();
				sumTextField.setText("合计");
				sumTextField.setFontSize(fontSize);
				sumTextField.setWidth(textWidth);
				sumTextField.setHeight(textHeight);
				
				if(!isSum) sumTextField.setHeight(1);
				
				
				sumTextField.setX(X * i);
				sumTextField.setPdfFontName("MHei-Medium");
				sumTextField.setPdfEmbedded(true);
				sumTextField.setPdfEncoding("UniCNS-UCS2-H");
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
    				
    				if(!isSum) sumTextField.setHeight(1);
    				
    				
    				sumTextField.setX(X * i);
    				sumTextField.setPdfFontName("MHei-Medium");
    				sumTextField.setPdfEmbedded(true);
    				sumTextField.setPdfEncoding("UniCNS-UCS2-H");
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
    				
    				
    				sumTextField.setX(X * i);
    				sumTextField.setPdfFontName("MHei-Medium");
    				sumTextField.setPdfEmbedded(true);
    				sumTextField.setPdfEncoding("UniCNS-UCS2-H");
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
    
    
    
  
    
    /** 
     * 利用反射机制，装载数据
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
    
}
