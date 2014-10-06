


/*
 * �������� 2007-03-14
 *
 * ����  ȡ����ʱ�乤��
 *
 */

/****************************************************************************     
 * Created on 2007-7-8                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
* ˵��:      ȡ����ʱ�乤��


*
* @author   ��ѧ֩��
* @author   haoxueweb@163.com
* @version  1.0
* Company   http://freehost04.websamba.com/dudu178
*/
public class DateUtil2 {

 public DateUtil2(){}
 /**
     * @see     ȡ�õ�ǰ���ڣ���ʽΪ��yyyy-MM-dd��
     * @return String
     */
    public String GetDate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sDate = sdf.format(new Date());
        return sDate;
    }

    /**
     * @see     ȡ�õ�ǰʱ�䣨��ʽΪ��yyy-MM-dd HH:mm:ss��
     * @return String
     */
    public static String GetDateTime()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sDate = sdf.format(new Date());
        return sDate;
    }

    /**
     * @see     ��ָ����ʽȡ�õ�ǰʱ��()
     * @return String
     */
    public static String GetTimeFormat(String strFormat)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
        String sDate = sdf.format(new Date());
        return sDate;
    }

    /**
     * @see     ȡ��ָ��ʱ��ĸ�����ʽ()
     * @return String
     * @throws ParseException
     */
    public static String SetDateFormat(String myDate,String strFormat) throws ParseException
    {

        SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
        String sDate = sdf.format(sdf.parse(myDate));

        return sDate;
    }

    public static String FormatDateTime(String strDateTime, String strFormat)
    {
        String sDateTime = strDateTime;
        try {
            Calendar Cal = parseDateTime(strDateTime);
            SimpleDateFormat sdf = null;
            sdf = new SimpleDateFormat(strFormat);
            sDateTime = sdf.format(Cal.getTime());
        } catch (Exception e) {

        }
        return sDateTime;
    }

    public static Calendar parseDateTime(String baseDate)
    {
        Calendar cal = null;
        cal = new GregorianCalendar();
        int yy = Integer.parseInt(baseDate.substring(0, 4));
        int mm = Integer.parseInt(baseDate.substring(5, 7)) - 1;
        int dd = Integer.parseInt(baseDate.substring(8, 10));
        int hh = 0;
        int mi = 0;
        int ss = 0;
        if(baseDate.length() > 12)
        {
            hh = Integer.parseInt(baseDate.substring(11, 13));
            mi = Integer.parseInt(baseDate.substring(14, 16));
            ss = Integer.parseInt(baseDate.substring(17, 19));
        }
        cal.set(yy, mm, dd, hh, mi, ss);
        return cal;
    }
    public int getDay(String strDate)
    {
        Calendar cal = parseDateTime(strDate);
        return  cal.get(Calendar.DATE);
    }

    public int getMonth(String strDate)
    {
        Calendar cal = parseDateTime(strDate);

        return cal.get(Calendar.MONTH) + 1;
    }

    public int getWeekDay(String strDate)
    {
        Calendar cal = parseDateTime(strDate);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public String getWeekDayName(String strDate)
    {
        String mName[] = {
            "��", "һ", "��", "��", "��", "��", "��"
        };
        int iWeek = getWeekDay(strDate);
        iWeek = iWeek - 1;
        return "����" + mName[iWeek];
    }

    public int getYear(String strDate)
    {
        Calendar cal = parseDateTime(strDate);
        return cal.get(Calendar.YEAR) + 1900;
    }

    public String DateAdd(String strDate, int iCount, int iType)
    {
        Calendar Cal = parseDateTime(strDate);
        int pType = 0;
        if(iType == 0)
        {
            pType = 1;
        } else
        if(iType == 1)
        {
            pType = 2;
        } else
        if(iType == 2)
        {
            pType = 5;
        } else
        if(iType == 3)
        {
            pType = 10;
        } else
        if(iType == 4)
        {
            pType = 12;
        } else
        if(iType == 5)
        {
            pType = 13;
        }
        Cal.add(pType, iCount);
        SimpleDateFormat sdf = null;
        if(iType <= 2)
            sdf = new SimpleDateFormat("yyyy-MM-dd");
        else
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sDate = sdf.format(Cal.getTime());
        return sDate;
    }

    public String DateAdd(String strOption, int iDays, String strStartDate)
    {
        if(!strOption.equals("d"));
        return strStartDate;
    }

    public int DateDiff(String strDateBegin, String strDateEnd, int iType)
    {
        Calendar calBegin = parseDateTime(strDateBegin);
        Calendar calEnd = parseDateTime(strDateEnd);
        long lBegin = calBegin.getTimeInMillis();
        long lEnd = calEnd.getTimeInMillis();
        int ss = (int)((lBegin - lEnd) / 1000L);
        int min = ss / 60;
        int hour = min / 60;
        int day = hour / 24;
        if(iType == 0)
            return hour;
        if(iType == 1)
            return min;
        if(iType == 2)
            return day;
        else
            return -1;
    }
   
    /*****************************************
     * @����     �ж�ĳ���Ƿ�Ϊ����
     * @return  boolean
     * @throws ParseException
     ****************************************/
    public static boolean isLeapYear(int yearNum){
     boolean isLeep = false;
        /**�ж��Ƿ�Ϊ���꣬��ֵ��һ��ʶ��flag*/
        if((yearNum % 4 == 0) && (yearNum % 100 != 0)){
         isLeep = true;
        }  else if(yearNum % 400 ==0){
         isLeep = true;
        } else {
         isLeep = false;
        }
        return isLeep;
    }

   
     /*****************************************
     * @����     ���㵱ǰ����ĳ��ĵڼ���
     * @return  interger
     * @throws ParseException
     ****************************************/
    public int getWeekNumOfYear(){
     Calendar calendar = Calendar.getInstance();
     int iWeekNum = calendar.get(Calendar.WEEK_OF_YEAR);
     return iWeekNum;
    }

    /*****************************************
     * @����     ����ָ������ĳ��ĵڼ���
     * @return  interger
     * @throws ParseException
     ****************************************/
    public int getWeekNumOfYearDay(String strDate ) throws ParseException{
     Calendar calendar = Calendar.getInstance();
     SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
     Date curDate = format.parse(strDate);
     calendar.setTime(curDate);
     int iWeekNum = calendar.get(Calendar.WEEK_OF_YEAR);
     return iWeekNum;
    }
    /*****************************************
     * @����     ����ĳ��ĳ�ܵĿ�ʼ����
     * @return  interger
     * @throws ParseException
     ****************************************/
    public String getYearWeekFirstDay(int yearNum,int weekNum) throws ParseException {
     
     Calendar cal = Calendar.getInstance();
     cal.set(Calendar.YEAR, yearNum);
     cal.set(Calendar.WEEK_OF_YEAR, weekNum);
     cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
     //�ֱ�ȡ�õ�ǰ���ڵ��ꡢ�¡���
     String tempYear = Integer.toString(yearNum);
     String tempMonth = Integer.toString(cal.get(Calendar.MONTH) + 1);
     String tempDay = Integer.toString(cal.get(Calendar.DATE));
     String tempDate = tempYear + "-" +tempMonth + "-" + tempDay;
     return SetDateFormat(tempDate,"yyyy-MM-dd");


     
    }
    /*****************************************
     * @����     ����ĳ��ĳ�ܵĽ�������
     * @return  interger
     * @throws ParseException
     ****************************************/
    public String getYearWeekEndDay(int yearNum,int weekNum) throws ParseException {
     Calendar cal = Calendar.getInstance();
     cal.set(Calendar.YEAR, yearNum);
     cal.set(Calendar.WEEK_OF_YEAR, weekNum + 1);
     cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        //�ֱ�ȡ�õ�ǰ���ڵ��ꡢ�¡���
     String tempYear = Integer.toString(yearNum);
     String tempMonth = Integer.toString(cal.get(Calendar.MONTH) + 1);
     String tempDay = Integer.toString(cal.get(Calendar.DATE));
     String tempDate = tempYear + "-" +tempMonth + "-" + tempDay;
     return SetDateFormat(tempDate,"yyyy-MM-dd");
    }
   
   
    /*****************************************
     * @����     ����ĳ��ĳ�µĿ�ʼ����
     * @return  interger
     * @throws ParseException
     ****************************************/
    public String getYearMonthFirstDay(int yearNum,int monthNum) throws ParseException {
     
     //�ֱ�ȡ�õ�ǰ���ڵ��ꡢ�¡���
     String tempYear = Integer.toString(yearNum);
     String tempMonth = Integer.toString(monthNum);
     String tempDay = "1";
     String tempDate = tempYear + "-" +tempMonth + "-" + tempDay;
     return SetDateFormat(tempDate,"yyyy-MM-dd");
     
    }
    /*****************************************
     * @����     ����ĳ��ĳ�µĽ�������
     * @return  interger
     * @throws ParseException
     ****************************************/
    public static String getYearMonthEndDay(int yearNum,int monthNum) throws ParseException {
     

       //�ֱ�ȡ�õ�ǰ���ڵ��ꡢ�¡���
     String tempYear = Integer.toString(yearNum);
     String tempMonth = Integer.toString(monthNum);
     String tempDay = "31";
     if (tempMonth.equals("1") || tempMonth.equals("3") || tempMonth.equals("5") || tempMonth.equals("7") ||tempMonth.equals("8") || tempMonth.equals("10") ||tempMonth.equals("12")) {
      tempDay = "31";
     }
     if (tempMonth.equals("4") || tempMonth.equals("6") || tempMonth.equals("9")||tempMonth.equals("11")) {
      tempDay = "30";
     }
     if (tempMonth.equals("2")) {
      if (isLeapYear(yearNum)) {
       tempDay = "29";
      } else {
         tempDay = "28";
      }
     }
     //System.out.println("tempDay:" + tempDay);
     String tempDate = tempYear + "-" +tempMonth + "-" + tempDay;
     return SetDateFormat(tempDate,"yyyy-MM-dd");

    }
    public static String getYearMonthEndDay2(int yearNum,int monthNum) throws ParseException {
        

        //�ֱ�ȡ�õ�ǰ���ڵ��ꡢ�¡���
      String tempYear = Integer.toString(yearNum);
      String tempMonth = Integer.toString(monthNum);
      String tempDay = "31";
      if (tempMonth.equals("1") || tempMonth.equals("3") || tempMonth.equals("5") || tempMonth.equals("7") ||tempMonth.equals("8") || tempMonth.equals("10") ||tempMonth.equals("12")) {
       tempDay = "31";
      }
      if (tempMonth.equals("4") || tempMonth.equals("6") || tempMonth.equals("9")||tempMonth.equals("11")) {
       tempDay = "30";
      }
      if (tempMonth.equals("2")) {
       if (isLeapYear(yearNum)) {
        tempDay = "29";
       } else {
          tempDay = "28";
       }
      }
      //System.out.println("tempDay:" + tempDay);
      tempMonth = tempMonth.length()<2?"0"+tempMonth:tempMonth;
      tempDay = tempDay.length()<2?"0"+tempDay:tempDay;
      return tempYear +tempMonth + tempDay;
     

     }
    

    

}