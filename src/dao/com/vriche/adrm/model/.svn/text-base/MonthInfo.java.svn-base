/****************************************************************************     
 * Created on 2006-11-6                                                     *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.model;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * MonthInfo class
 * 
 * This class is used to 
 * 
 * <p><a href="MonthInfo.java.html"><i>View Source</i></a></p>
 * 
 * @struts.form include-all="true"  extends="BaseForm"
 * 
 */
public class MonthInfo extends BaseObject {

	private static final long serialVersionUID = 8791187768667651989L;
	protected Integer year;
    protected Integer month;
    protected Integer monthDate;
    protected String monthStr;
    
    protected Boolean isCurMonth;    //是否当前月
    protected Integer adStartDate;   //开始日期
    protected Integer adEndDate;     //结束日期
    protected Integer monthResTotal; //月资源累计
    protected Integer monthResUsed;  //月资源使用
    protected Integer monthTims;     //月总次数
    protected Double  monthPrice;    //月价格
    protected Double  monthPay;      //月应付款
    protected Double  monthIncome;   //月到款款
    
//    protected DayInfoArray day1  = new DayInfoArray();
//    protected DayInfoArray day2  = new DayInfoArray();
//    protected DayInfoArray day3  = new DayInfoArray();
//    protected DayInfoArray day4  = new DayInfoArray();
//    protected DayInfoArray day5  = new DayInfoArray();
//    protected DayInfoArray day6  = new DayInfoArray();
//    protected DayInfoArray day7  = new DayInfoArray();
//    protected DayInfoArray day8  = new DayInfoArray();
//    protected DayInfoArray day9  = new DayInfoArray();
//    protected DayInfoArray day10 = new DayInfoArray();
//    protected DayInfoArray day11 = new DayInfoArray();
//    protected DayInfoArray day12 = new DayInfoArray();
//    protected DayInfoArray day13 = new DayInfoArray();
//    protected DayInfoArray day14 = new DayInfoArray();
//    protected DayInfoArray day15 = new DayInfoArray();
//    protected DayInfoArray day16 = new DayInfoArray();
//    protected DayInfoArray day17 = new DayInfoArray();
//    protected DayInfoArray day18 = new DayInfoArray();
//    protected DayInfoArray day19 = new DayInfoArray();
//    protected DayInfoArray day20 = new DayInfoArray();
//    protected DayInfoArray day21 = new DayInfoArray();
//    protected DayInfoArray day22 = new DayInfoArray();
//    protected DayInfoArray day23 = new DayInfoArray();
//    protected DayInfoArray day24 = new DayInfoArray();
//    protected DayInfoArray day25 = new DayInfoArray();
//    protected DayInfoArray day26 = new DayInfoArray();
//    protected DayInfoArray day27 = new DayInfoArray();
//    protected DayInfoArray day28 = new DayInfoArray();
//    protected DayInfoArray day29 = new DayInfoArray();
//    protected DayInfoArray day30 = new DayInfoArray();
//    protected DayInfoArray day31 = new DayInfoArray();
    
   
    protected DayInfoArray days[] = new DayInfoArray[31];
    
    public MonthInfo() {}
    /**
     * 
     * Returns the adEndDate
     * @return Date
     * 
     */
    public Integer getAdEndDate() {
        return adEndDate;
    }
    /**
     * @param adEndDate The adEndDate to set.
     */
    public void setAdEndDate(Integer adEndDate) {
        this.adEndDate = adEndDate;
    }
    /**
     * 
     * Returns the adStartDate
     * @return Date
     * 
     */
    public Integer getAdStartDate() {
        return adStartDate;
    }
    /**
     * @param adStartDate The adStartDate to set.
     */
    public void setAdStartDate(Integer adStartDate) {
        this.adStartDate = adStartDate;
    }
    /**
     * 
     * Returns the isCurMonth
     * @return Boolean
     * 
     */
    public Boolean getIsCurMonth() {
        return isCurMonth;
    }
    /**
     * @param isCurMonth The isCurMonth to set.
     */
    public void setIsCurMonth(Boolean isCurMonth) {
        this.isCurMonth = isCurMonth;
    }
    /**
     * 
     * Returns the monthDate
     * @return Date
     * 
     */
    public Integer getMonthDate() {
        return monthDate;
    }
    /**
     * @param monthDate The monthDate to set.
     */
    public void setMonthDate(Integer monthDate) {
        this.monthDate = monthDate;
    }
//    /**
//     * 
//     * Returns the day1
//     * @return DayInfo
//     */
//    public DayInfoArray getDay1() {
//        return day1;
//    }
//    /**
//     * @param day1 The day1 to set.
//     */
//    public void setDay1(DayInfoArray day1) {
//        this.day1 = day1;
//    }
//    /**
//     * 
//     * Returns the day10
//     * @return DayInfo
//     */
//    public DayInfoArray getDay10() {
//        return day10;
//    }
//    /**
//     * @param day10 The day10 to set.
//     */
//    public void setDay10(DayInfoArray day10) {
//        this.day10 = day10;
//    }
//    /**
//     * 
//     * Returns the day11
//     * @return DayInfoArray
//     */
//    public DayInfoArray getDay11() {
//        return day11;
//    }
//    /**
//     * @param day11 The day11 to set.
//     */
//    public void setDay11(DayInfoArray day11) {
//        this.day11 = day11;
//    }
//    /**
//     * 
//     * Returns the day12
//     * @return DayInfoArray
//     */
//    public DayInfoArray getDay12() {
//        return day12;
//    }
//    /**
//     * @param day12 The day12 to set.
//     */
//    public void setDay12(DayInfoArray day12) {
//        this.day12 = day12;
//    }
//    /**
//     * 
//     * Returns the day13
//     * @return DayInfoArray
//     */
//    public DayInfoArray getDay13() {
//        return day13;
//    }
//    /**
//     * @param day13 The day13 to set.
//     */
//    public void setDay13(DayInfoArray day13) {
//        this.day13 = day13;
//    }
//    /**
//     * 
//     * Returns the day14
//     * @return DayInfoArray
//     */
//    public DayInfoArray getDay14() {
//        return day14;
//    }
//    /**
//     * @param day14 The day14 to set.
//     */
//    public void setDay14(DayInfoArray day14) {
//        this.day14 = day14;
//    }
//    /**
//     * 
//     * Returns the day15
//     * @return DayInfoArray
//     */
//    public DayInfoArray getDay15() {
//        return day15;
//    }
//    /**
//     * @param day15 The day15 to set.
//     */
//    public void setDay15(DayInfoArray day15) {
//        this.day15 = day15;
//    }
//    /**
//     * 
//     * Returns the day16
//     * @return DayInfoArray
//     */
//    public DayInfoArray getDay16() {
//        return day16;
//    }
//    /**
//     * @param day16 The day16 to set.
//     */
//    public void setDay16(DayInfoArray day16) {
//        this.day16 = day16;
//    }
//    /**
//     * 
//     * Returns the day17
//     * @return DayInfoArray
//     */
//    public DayInfoArray getDay17() {
//        return day17;
//    }
//    /**
//     * @param day17 The day17 to set.
//     */
//    public void setDay17(DayInfoArray day17) {
//        this.day17 = day17;
//    }
//    /**
//     * 
//     * Returns the day18
//     * @return DayInfoArray
//     */
//    public DayInfoArray getDay18() {
//        return day18;
//    }
//    /**
//     * @param day18 The day18 to set.
//     */
//    public void setDay18(DayInfoArray day18) {
//        this.day18 = day18;
//    }
//    /**
//     * 
//     * Returns the day19
//     * @return DayInfoArray
//     */
//    public DayInfoArray getDay19() {
//        return day19;
//    }
//    /**
//     * @param day19 The day19 to set.
//     */
//    public void setDay19(DayInfoArray day19) {
//        this.day19 = day19;
//    }
//    /**
//     * 
//     * Returns the day2
//     * @return DayInfoArray
//     */
//    public DayInfoArray getDay2() {
//        return day2;
//    }
//    /**
//     * @param day2 The day2 to set.
//     */
//    public void setDay2(DayInfoArray day2) {
//        this.day2 = day2;
//    }
//    /**
//     * 
//     * Returns the day20
//     * @return DayInfoArray
//     * 
//     */
//    public DayInfoArray getDay20() {
//        return day20;
//    }
//    /**
//     * @param day20 The day20 to set.
//     */
//    public void setDay20(DayInfoArray day20) {
//        this.day20 = day20;
//    }
//    /**
//     * 
//     * Returns the day21
//     * @return DayInfoArray
//     */
//    public DayInfoArray getDay21() {
//        return day21;
//    }
//    /**
//     * @param day21 The day21 to set.
//     */
//    public void setDay21(DayInfoArray day21) {
//        this.day21 = day21;
//    }
//    /**
//     * 
//     * Returns the day22
//     * @return DayInfoArray
//     */
//    public DayInfoArray getDay22() {
//        return day22;
//    }
//    /**
//     * @param day22 The day22 to set.
//     */
//    public void setDay22(DayInfoArray day22) {
//        this.day22 = day22;
//    }
//    /**
//     * 
//     * Returns the day23
//     * @return DayInfoArray
//     * 
//     */
//    public DayInfoArray getDay23() {
//        return day23;
//    }
//    /**
//     * @param day23 The day23 to set.
//     */
//    public void setDay23(DayInfoArray day23) {
//        this.day23 = day23;
//    }
//    /**
//     * 
//     * Returns the day24
//     * @return DayInfoArray
//     * 
//     */
//    public DayInfoArray getDay24() {
//        return day24;
//    }
//    /**
//     * @param day24 The day24 to set.
//     */
//    public void setDay24(DayInfoArray day24) {
//        this.day24 = day24;
//    }
//    /**
//     * 
//     * Returns the day25
//     * @return DayInfoArray
//     * 
//     */
//    public DayInfoArray getDay25() {
//        return day25;
//    }
//    /**
//     * @param day25 The day25 to set.
//     */
//    public void setDay25(DayInfoArray day25) {
//        this.day25 = day25;
//    }
//    /**
//     * 
//     * Returns the day26
//     * @return DayInfoArray
//     * 
//     */
//    public DayInfoArray getDay26() {
//        return day26;
//    }
//    /**
//     * @param day26 The day26 to set.
//     */
//    public void setDay26(DayInfoArray day26) {
//        this.day26 = day26;
//    }
//    /**
//     * 
//     * Returns the day27
//     * @return DayInfoArray
//     * 
//     */
//    public DayInfoArray getDay27() {
//        return day27;
//    }
//    /**
//     * @param day27 The day27 to set.
//     */
//    public void setDay27(DayInfoArray day27) {
//        this.day27 = day27;
//    }
//    /**
//     * 
//     * Returns the day28
//     * @return DayInfoArray
//     */
//    public DayInfoArray getDay28() {
//        return day28;
//    }
//    /**
//     * @param day28 The day28 to set.
//     */
//    public void setDay28(DayInfoArray day28) {
//        this.day28 = day28;
//    }
//    /**
//     * 
//     * Returns the day29
//     * @return DayInfoArray
//     */
//    public DayInfoArray getDay29() {
//        return day29;
//    }
//    /**
//     * @param day29 The day29 to set.
//     */
//    public void setDay29(DayInfoArray day29) {
//        this.day29 = day29;
//    }
//    /**
//     * 
//     * Returns the day3
//     * @return DayInfoArray
//     */
//    public DayInfoArray getDay3() {
//        return day3;
//    }
//    /**
//     * @param day3 The day3 to set.
//     */
//    public void setDay3(DayInfoArray day3) {
//        this.day3 = day3;
//    }
//    /**
//     * 
//     * Returns the day30
//     * @return DayInfoArray
//     * 
//     */
//    public DayInfoArray getDay30() {
//        return day30;
//    }
//    /**
//     * @param day30 The day30 to set.
//     */
//    public void setDay30(DayInfoArray day30) {
//        this.day30 = day30;
//    }
//    /**
//     * 
//     * Returns the day31
//     * @return DayInfoArray
//     * 
//     */
//    public DayInfoArray getDay31() {
//        return day31;
//    }
//    /**
//     * @param day31 The day31 to set.
//     */
//    public void setDay31(DayInfoArray day31) {
//        this.day31 = day31;
//    }
//    /**
//     * 
//     * Returns the day4
//     * @return DayInfoArray
//     * 
//     */
//    public DayInfoArray getDay4() {
//        return day4;
//    }
//    /**
//     * @param day4 The day4 to set.
//     */
//    public void setDay4(DayInfoArray day4) {
//        this.day4 = day4;
//    }
//    /**
//     * 
//     * Returns the day5
//     * @return DayInfoArray
//     */
//    public DayInfoArray getDay5() {
//        return day5;
//    }
//    /**
//     * @param day5 The day5 to set.
//     */
//    public void setDay5(DayInfoArray day5) {
//        this.day5 = day5;
//    }
//    /**
//     * 
//     * Returns the day6
//     * @return DayInfoArray
//     * 
//     */
//    public DayInfoArray getDay6() {
//        return day6;
//    }
//    /**
//     * @param day6 The day6 to set.
//     */
//    public void setDay6(DayInfoArray day6) {
//        this.day6 = day6;
//    }
//    /**
//     * 
//     * Returns the day7
//     * @return DayInfoArray
//     * 
//     */
//    public DayInfoArray getDay7() {
//        return day7;
//    }
//    /**
//     * @param day7 The day7 to set.
//     */
//    public void setDay7(DayInfoArray day7) {
//        this.day7 = day7;
//    }
//    /**
//     * 
//     * Returns the day8
//     * @return DayInfoArray
//     * 
//     */
//    public DayInfoArray getDay8() {
//        return day8;
//    }
//    /**
//     * @param day8 The day8 to set.
//     */
//    public void setDay8(DayInfoArray day8) {
//        this.day8 = day8;
//    }
//    /**
//     * 
//     * Returns the day9
//     * @return DayInfoArray
//     * 
//     */
//    public DayInfoArray getDay9() {
//        return day9;
//    }
//    /**
//     * @param day9 The day9 to set.
//     */
//    public void setDay9(DayInfoArray day9) {
//        this.day9 = day9;
//    }
    /**
     * 
     * Returns the month
     * @return Integer
     * 
     */
    public Integer getMonth() {
        return month;
    }
    /**
     * @param month The month to set.
     */
    public void setMonth(Integer month) {
        this.month = month;
    }
    /**
     * 
     * Returns the monthPrice
     * @return Double
     * 
     */
    public Double getMonthPrice() {
        return monthPrice;
    }
    /**
     * @param monthPrice The monthPrice to set.
     */
    public void setMonthPrice(Double monthPrice) {
        this.monthPrice = monthPrice;
    }
    /**
     * 
     * Returns the monthTims
     * @return Integer
     * 
     */
    public Integer getMonthTims() {
        return monthTims;
    }
    /**
     * @param monthTims The monthTims to set.
     */
    public void setMonthTims(Integer monthTims) {
        this.monthTims = monthTims;
    }
    /**
     * 
     * Returns the year
     * @return Integer
     * 
     */
    public Integer getYear() {
        return year;
    }
    /**
     * @param year The year to set.
     */
    public void setYear(Integer year) {
        this.year = year;
    }
    
    /**
     * 
     * Returns the monthStr
     * @return String
     */
    public String getMonthStr() {
        return monthStr;
    }
    /**
     * @param monthStr The monthStr to set.
     */
    public void setMonthStr(String monthStr) {
        this.monthStr = monthStr;
    } 
    
    /**
	 * 
	 * Returns the days
	 * @return DayInfoArray[] 
	 * 
	 * @hibernate.property length="128" column="days" not-null="false"
	 */
	public DayInfoArray[] getDays() {
		return days;
	}
	/** 
	 * @param days The days to set.
	 */
	public void setDays(DayInfoArray[] days) {
		this.days = days;
	}
	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof MonthInfo)) {
			return false;
		}
		MonthInfo rhs = (MonthInfo) object;
		return new EqualsBuilder().append(this.days, rhs.days).append(
				this.month, rhs.month).append(this.monthTims, rhs.monthTims)
				.append(this.monthDate, rhs.monthDate).append(this.monthPay,
						rhs.monthPay).append(this.isCurMonth, rhs.isCurMonth)
				.append(this.monthResTotal, rhs.monthResTotal).append(
						this.monthResUsed, rhs.monthResUsed).append(
						this.monthIncome, rhs.monthIncome).append(
						this.adStartDate, rhs.adStartDate).append(this.year,
						rhs.year).append(this.adEndDate, rhs.adEndDate).append(
						this.monthPrice, rhs.monthPrice).append(this.monthStr,
						rhs.monthStr).isEquals();
	}
	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-1472496133, 988038029).append(this.days)
				.append(this.month).append(this.monthTims).append(
						this.monthDate).append(this.monthPay).append(
						this.isCurMonth).append(this.monthResTotal).append(
						this.monthResUsed).append(this.monthIncome).append(
						this.adStartDate).append(this.year).append(
						this.adEndDate).append(this.monthPrice).append(
						this.monthStr).toHashCode();
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("monthPrice", this.monthPrice)
				.append("monthStr", this.monthStr).append("month", this.month)
				.append("adEndDate", this.adEndDate).append("monthTims",
						this.monthTims).append("isCurMonth", this.isCurMonth)
				.append("days", this.days).append("monthDate", this.monthDate)
				.append("year", this.year).append("adStartDate",
						this.adStartDate).toString();
	}
	public Double getMonthIncome() {
		return monthIncome;
	}
	public void setMonthIncome(Double monthIncome) {
		this.monthIncome = monthIncome;
	}
	public Double getMonthPay() {
		return monthPay;
	}
	public void setMonthPay(Double monthPay) {
		this.monthPay = monthPay;
	}
	public Integer getMonthResTotal() {
		return monthResTotal;
	}
	public void setMonthResTotal(Integer monthResTotal) {
		this.monthResTotal = monthResTotal;
	}
	public Integer getMonthResUsed() {
		return monthResUsed;
	}
	public void setMonthResUsed(Integer monthResUsed) {
		this.monthResUsed = monthResUsed;
	}


}
