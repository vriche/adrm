package com.vriche.adrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/** 
 * 此类采用 poi包 实现了读 .xls 文件的功能， 
 * 用 poi 读 excel 相对而言要比 fastExcel 麻烦，而且速度上也没有 fastExcel 快 
 * @author  hellojim 
 * @company cxtech 
 */  
public class ReadExcelByPoi {  
  
    private String URL; //要读取的 .xls 文件的目录  
    private int index = 0; //要读取的 .xls 文件的那个 Sheet ， 默认为第0个(Sheet1)  
    private int beginRow = 0; //要读取的 Sheet 的开始行， 默认为第0行  
    private int beginCol = 0; //要读取的 Sheet 的开始列， 默认为第0列  
      
    private final static int defaultRow = 0;  
    
    
    public ReadExcelByPoi() {  
   
    } 
      
    /** 
     *  URL 要读取的那个 .xls 文件的地址 
     */  
    public ReadExcelByPoi(String URL) {  
        //这里简单的做了个判断  
        if(URL == null || URL.trim().equals("")) {   
            System.out.println("文件不能为空!");  
        }else if(URL.trim().indexOf(".xls") == -1 && URL.trim().indexOf(".XLS") == -1) {  
            System.out.println("文件格式不正确!");  
        }else {  
            this.URL = URL;  
        }  
    }  
    /** 
     *  URL 要读取的那个 .xls 文件的地址 
     *  index 要读取的那个 Sheet ， 默认为第一个(Sheet1) 
     */  
    public ReadExcelByPoi(String URL, int index) {  
        this(URL);  
        this.index = index;  
    }  
    /** 
     *  URL 要读取的那个 .xls 文件的地址 
     *  index 要读取的那个 Sheet ， 默认为第一个(Sheet1) 
     *  beginRow 要读取的 Sheet 的开始行 
     *  beginCol 要读取的 Sheet 的开始列 
     */  
    public ReadExcelByPoi(String URL,int index,int beginRow,int beginCol) {  
        this(URL,index);  
        this.beginRow = beginRow;  
        this.beginCol = beginCol;  
    }  
      
    public int getIndex() {  
        return index;  
    }  
    public void setIndex(int index) {  
        this.index = index;  
    }  
    public String getURL() {  
        return URL;  
    }  
    public void setURL(String URL) {  
        this.URL = URL;  
    }  
      
    public int getBeginCol() {  
        return beginCol;  
    }  
    public void setBeginCol(int beginCol) {  
        this.beginCol = beginCol;  
    }  
    public int getBeginRow() {  
        return beginRow;  
    }  
    public void setBeginRow(int beginRow) {  
        this.beginRow = beginRow;  
    }  
    
    
    public String[][] read(File f) throws Exception {  
    	String[][] strArray = null;  
//        String value = null;  
//        File f = new File(this.URL);  
          
        FileInputStream fos = new FileInputStream(f);  //把要读取的 .xls 文件 包装起来  
        HSSFWorkbook workbook = new HSSFWorkbook(fos); //得到 excel 工作簿对应的 HSSFWorkbook 对象  
          
        HSSFSheet sheet = null;  
          
        try {  
            sheet = workbook.getSheetAt(this.index); //得到 excel 工作簿中 某个Sheet 对应的 HSSFSheet 对象  
        }catch(IndexOutOfBoundsException ex) {  
            return null;  
        }  
          
        HSSFRow row = sheet.getRow(defaultRow); //得到某个 Sheet 中的第 0 行(默认为第 0 行)  
          
        int rows = sheet.getLastRowNum() - this.beginRow;  //得到共有多少行  
        int cols = row.getLastCellNum() - this.beginCol;   //得到共有多少列  

          
        strArray = new String[rows+1][cols];  

          
        for (int i = this.beginRow,m=0; i <= rows+this.beginRow; i++,m++) {  
          row = sheet.getRow(i); //得到此工作区中的某一得数据  
          for (int j = this.beginCol,n=0; j < cols+this.beginCol; j++,n++) {   
      
            HSSFCell mycell = row.getCell( (short) j); //得到一个具体的单元格  
            try {  
                strArray[m][n] = getStringCellValue(mycell);  
            }  
            catch (Exception e) {  
              e.printStackTrace();  
            }  
          }  
        }  
        
        
        return strArray;     	
    }
    /** 
     * 获取单元格数据内容为字符串类型的数据 
     * @param cell Excel单元格 
     * @return String 单元格数据内容 
     */  
    private String getStringCellValue(HSSFCell mycell) {  
    	
        //[注意]: 这里一定要加上这个判断,如果某个单元格为空，这里的 mycell 就为 null,易发生 NullProintException  
        /* [注意]：这里在得到某个单元格中内容前，一定要先判断这个单元格中内容的数据类型， 
        然后根据数据类型用对应的getXxxCellValue这样的方法来得到具体内容,如果不做这样的判断可能出现 int 型数据而你用了  
        getStringCellValue()这样的方法去取数据，就会报错，这也是 POI 取 Excel 中数据的一个缺点。  
        本个在以上两个"注意"点上栽了不少跟头，相反如果是用 fastExcel 这两个问题根本不存在 */  
        String value = "";  
        
        if(mycell != null){
        	  int   cellType   =   mycell.getCellType();  
          	  switch   (cellType)   {  
          	  case   HSSFCell.CELL_TYPE_BOOLEAN:  
          		  value = String.valueOf(mycell.getBooleanCellValue()).trim(); 
          		  break;  
          	  case   HSSFCell.CELL_TYPE_ERROR:  
          		  value = String.valueOf(mycell.getErrorCellValue()).trim(); 
          		  break;  
          	  case   HSSFCell.CELL_TYPE_FORMULA:  
          		  value = String.valueOf(mycell.getCellFormula()).trim(); 
          		  break;  
          	  case   HSSFCell.CELL_TYPE_NUMERIC: 
          		  
          		  if(HSSFDateUtil.isCellDateFormatted(mycell)) {
           			value = getDateCellValue(mycell);
           		  }else{
           			value = String.valueOf(mycell.getNumericCellValue()).trim(); 
           		  }
  
          		  break;  
          	  case   HSSFCell.CELL_TYPE_STRING:  
          		  	value = String.valueOf(mycell.getStringCellValue()).trim(); 
          		  break;  
          	  case   HSSFCell.CELL_TYPE_BLANK:  
          		  value = ""; 
          		  break;  
          	  default:
          		  value = ""; 
          	  	  break;  
          	  }   
        }else{
        	 value = "";  
        }
      
        return value;  
    }     
   
    private String getDateCellValue(HSSFCell cell) {  
        String result = "";  
        try {  
            int cellType = cell.getCellType();  
            if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {  
                Date date = cell.getDateCellValue();  

                if(date.getYear() == -1){
                	int hh = date.getHours();
                	int mm = date.getMinutes();
                	int ss = date.getSeconds();

                	result = String.valueOf((hh*3600+mm*60+ss)*1000);
                	
                }else{
                	
                	result = dateToString(date, "yyyyMMdd");

                }
               
            } 
        } catch (Exception e) {  
            System.out.println("日期格式不正确!");  
            e.printStackTrace();  
        }  
        return result;  
    }  
    public String dateToString(Date date, String pattern) {
        DateFormat format = new SimpleDateFormat(pattern); 
        String str = format.format(date);
        return str;
      }
 
    
    
  public String[][] read() throws Exception {  
	File f = new File(this.URL);  
    return read(f);
  }  
    
    /**  
     * 返回 若干个 sheet, 若干个 sheet 存放于 ArrayList 中 
     * */  
  public ArrayList readAll() throws Exception {  
          
      ArrayList al = new ArrayList();   
        
      String[][] strArr = null;  
        
      while(true) {  
            strArr = read();  
            if(strArr == null) {  
                break;  
            }else {  
                al.add(strArr);  
                this.index ++;  
            }  
      }  
      return al;  
  }  
      
  public static void printArr(String[][] strArr) {  
        
        for(int i=0; i<strArr.length; i++) { 
        	boolean printRow = false;
            for(int j=0; j<strArr[i].length; j++) {  
                
                if(strArr[i][j] != null && strArr[i][j] != ""){
                	System.out.print(strArr[i][j] + "   ");  
                	printRow = true;
                }
            }  
            if(printRow) System.out.println();  
        }  
          
        System.out.println("______________________________________________________________________");  
          
  }  
  
  public List  getNewArrList(String[][] strArr) {  
	  List ls = new ArrayList();
      for(int i=0; i<strArr.length; i++) { 
      	boolean printRow = false;
          for(int j=0; j<strArr[i].length; j++) {  
              
              if(strArr[i][j] != null && strArr[i][j] != ""){
//              	System.out.print(strArr[i][j] + "   ");  
              	printRow = true;
              }
          }  
          if(printRow){
//        	  System.out.println();  
        	  ls.add(strArr[i]);
          }
      }  
        
     return ls;
        
}  
    
  public static void main(String [] args) throws Exception {  
      
        
	  ReadExcelByPoi readExcel = new ReadExcelByPoi("d:\\test.xls");  
        readExcel.setIndex(1);  
        readExcel.setBeginRow(1);  
        readExcel.setBeginCol(1);  
        //读某一个 Sheet   
        String[][] strArr2 = readExcel.read();  
        printArr(strArr2);  
          
        //读所有的 Sheet  
        readExcel.setIndex(0);  
        ArrayList al = readExcel.readAll();  
        if(al != null && al.size() > 0) {  
              
            for(int i=0; i<al.size(); i++) {  
                  
                String[][] strArr = (String[][])al.get(i);  
                printArr(strArr);  
            }  
        }  
  }  
}  