/****************************************************************************     
 * Created on 2007-11-21                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/

/**
 * Title:��ú��ֵ�ƴ������ĸ
 * Description: GB 2312-80 ����¼�ĺ��ֳַ���������һ�������ǳ��ú��֣��� 3755 ����
 * ���� 16��55 ����������ƴ����ĸ������˳�����У��ڶ��������Ǵγ��ú��֣�
 * �� 3008 �������� 56��87 ���������ף��ʻ�˳�����У����Ա�����ֻ�ܲ鵽
 * ��һ�����ֵ���ĸ��ͬʱ�Է�����ĸ��zh��ch��sh��ֻ��ȡ����ĸ��z��c��s�� 
 * Copyright: Copyright (c) 2004
 * Company: 
 * @author not attributable
 * @version 1.0
 */
package com.vriche.adrm.util;

import java.io.UnsupportedEncodingException;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class GetFirstLetter {
//	 ���������λ��ת������
	  private static final int GB_SP_DIFF = 160;

//	��Ź���һ�����ֲ�ͬ��������ʼ��λ��
	  private static final int[] secPosvalueList = {
	      1601, 1637, 1833, 2078, 2274, 2302, 2433, 2594, 2787,
	      3106, 3212, 3472, 3635, 3722, 3730, 3858, 4027, 4086,
	      4390, 4558, 4684, 4925, 5249, 5600};

//	��Ź���һ�����ֲ�ͬ��������ʼ��λ���Ӧ����
	  private static final char[] firstLetter = {
	      'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j',
	      'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
	      't', 'w', 'x', 'y', 'z'};
	  

	  
	  

//	��ȡһ���ַ�����ƴ����
	  public static String getFirstLetter(String oriStr) {
		    String str = StringUtil.SBCchange(oriStr).toLowerCase();
		    str = StringUtil.StringFilter(str);
	    
	    if (str == null || str.trim().length() == 0) {  
            return "";  
        }  
  	    
	    
	      //�����ַ���_ & @  
        //����   48-57  
        //��ĸ 65-90    97-122  
        //����  
        //�ո� 
//	    boolean isGBK = false;
//	    try {
//			isGBK = StringUtil.isGBK(str);
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	    
	    StringBuffer buffer = new StringBuffer();
	    char ch;
	    char[] temp;
	    for (int i = 0; i < str.length(); i++) { //���δ���str��ÿ���ַ�
	      ch = str.charAt(i);
	      temp = new char[] {ch};
	      try {
		      byte[] uniCode = new String(temp).getBytes("GBK");
		      if (uniCode[0] < 128 && uniCode[0] > 0) { // �Ǻ���
		        buffer.append(temp);
		        
		      }else{
		    	  char hanzi=convert(uniCode);
		    	  if(hanzi!='-'){
		    		  buffer.append(hanzi);
		    	  }else{
		    		  buffer.append(toPinYin(str.substring(i,i+1)));
		    	  }
		      }  
	      } catch (UnsupportedEncodingException e) {
	    	  e.printStackTrace();
	      }

	    }
	    return buffer.toString();
	  }
	  
	  
	 

	  /** ��ȡһ�����ֵ�ƴ������ĸ��
	   * GB�������ֽڷֱ��ȥ160��ת����10��������ϾͿ��Եõ���λ��
	   * ���纺��"��"��GB����0xC4/0xE3���ֱ��ȥ0xA0��160������0x24/0x43
	   * 0x24ת��10���ƾ���36��0x43��67����ô������λ�����3667���ڶ��ձ��ж���Ϊ��n'
	   */

	  private static char convert(byte[] bytes) {

	    char result = '-';
	    int secPosvalue = 0;
	    int i;
	    for (i = 0; i < bytes.length; i++) {
	      bytes[i] -= GB_SP_DIFF;
	    }
	    secPosvalue = bytes[0] * 100 + bytes[1];
	    for (i = 0; i < 23; i++) {
	      if (secPosvalue >= secPosvalueList[i] &&
	          secPosvalue < secPosvalueList[i + 1]) {
	        result = firstLetter[i];
	        break;
	      }
	    }
	    return result;
	  }
	  private static String toPinYin(String hanzhis){
		  CharSequence s= hanzhis;

		  char [] hanzhi=new char[s.length()];
		  for(int i=0;i<s.length();i++){
			  hanzhi[i]=s.charAt(i);
		  }

		  char [] t1 =hanzhi;
		  String[] t2 = new String[s.length()];
		  
		  /** *//**
		  * ���������ʽ
		  */
		  
		  net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
		  
		  t3.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		  t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		  t3.setVCharType(HanyuPinyinVCharType.WITH_V);

		  int t0=t1.length;
		  String py = "";
		  
		  try {
			  for (int i=0;i<t0;i++){
				  t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
				  py=py+t2[0].toString();
			  }
		  }
		  catch (BadHanyuPinyinOutputFormatCombination e1) {
			  e1.printStackTrace();
		  }
		  
		return py.trim().toLowerCase().substring(0,1);
		  
	}
	  
	  
	  /** 
	  * ��ȡÿ�����ֵ�����ĸ 
	  * @param str 
	  * @return String 
	  */ 
	  public static String getPinYinHeadChar(String str)  
	  {   
		  
		    str = StringUtil.SBCchange(str).toLowerCase();
		    str = StringUtil.StringFilter(str);
	    
		    if (str == null || str.trim().length() == 0) {  
	            return "";  
	        } 
	         String convert = "";  
	         for (int j = 0; j < str.length(); j++) {   
	               char word = str.charAt(j);  
	               // ��ȡ���ֵ�����ĸ  
	               String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);  
	               if (pinyinArray != null) {  
	                       convert += pinyinArray[0].charAt(0);   
	               } else {  
	                       convert += word;  
	               }  
	          }   
	          return convert;  
	   }    
	  /** 
	  * ���ַ���ת����ASCII�� 
	  * @param cnStr 
	  * @return String 
	  */ 
	  public static String getCnASCII(String cnStr)  
	  {   
	        StringBuffer strBuf = new StringBuffer();   
	        // ���ַ���ת�����ֽ�����   
	        byte[] bGBK = cnStr.getBytes();  
	        for (int i = 0; i < bGBK.length; i++) {  
	             // ��ÿ���ַ�ת����ASCII��  
	             strBuf.append(Integer.toHexString(bGBK[i] & 0xff));  
	        }  
	        return strBuf.toString();  
	  }      	  
	  
	  
	  
	  
	  
	  
	  
}
