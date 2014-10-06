/****************************************************************************     
 * Created on 2007-10-15                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.model;

import org.apache.commons.lang.builder.ToStringBuilder;

public class OrderDetailColl extends BaseObject {
    
	protected String advName;
	protected String advVer;
	protected String tapCode;
	protected String carrier;
	protected String carrierParent;
	protected String resource;
	protected String resourceMemo;
	protected String specific;
	protected String length;
	protected String month;
	protected String monthSysPrice;
	protected String monthTimes;
	protected String monthRelPrice;
	protected String day1;
	protected String day2;
	protected String day3;
	protected String day4;
	protected String day5;
	protected String day6;
	protected String day7;
	protected String day8;
	protected String day9;
	protected String day10;
	protected String day11;
	protected String day12;
	protected String day13;
	protected String day14;
	protected String day15;
	protected String day16;
	protected String day17;
	protected String day18;
	protected String day19;
	protected String day20;
	protected String day21;
	protected String day22;
	protected String day23;
	protected String day24;
	protected String day25;
	protected String day26;
	protected String day27;
	protected String day28;
	protected String day29;
	protected String day30;
	protected String day31;	
	protected String meno;
	protected String orderDetailId;
	protected String orderSubCate;
	
	protected String monthStart;
	protected String monthEnd;	
	protected String broStartEndTime;	
	protected String publishMemo;	
	protected String checkState;
	
	
	
	public String getMeno() {
		return meno;
	}
	public void setMeno(String meno) {
		this.meno = meno;
	}
	public OrderDetailColl(){
		this.monthSysPrice = "0";
		this.monthTimes = "0";
		this.monthRelPrice = "0";
		this.advName = "";
		this.advVer = "";
		this.tapCode = "";
		this.carrier = "";
		this.resource = "";
		this.meno = "";
		this.specific = "";
		this.length = "";
		this.month = "";
		this.day1 = "";
		this.day2 = "";
		this.day3 = "";
		this.day4 = "";
		this.day5 = "";
		this.day6 = "";
		this.day7 = "";
		this.day8 = "";
		this.day9 = "";
		this.day10 = "";
		this.day11 = "";
		this.day12 = "";
		this.day13 = "";
		this.day14 = "";
		this.day15 = "";
		this.day16 = "";
		this.day17 = "";
		this.day18 = "";
		this.day19 = "";
		this.day20 = "";
		this.day21 = "";
		this.day22 = "";
		this.day23 = "";
		this.day24 = "";
		this.day25 = "";
		this.day26 = "";
		this.day27 = "";
		this.day28 = "";
		this.day29 = "";
		this.day30 = "";
		this.day31 = "";
	}
	public String getAdvName() {
		return advName;
	}

	public void setAdvName(String advName) {
		this.advName = advName;
	}

	public String getAdvVer() {
		return advVer;
	}

	public void setAdvVer(String advVer) {
		this.advVer = advVer;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getDay1() {
		return day1;
	}

	public void setDay1(String day1) {
		this.day1 = day1;
	}

	public String getDay10() {
		return day10;
	}

	public void setDay10(String day10) {
		this.day10 = day10;
	}

	public String getDay11() {
		return day11;
	}

	public void setDay11(String day11) {
		this.day11 = day11;
	}

	public String getDay12() {
		return day12;
	}

	public void setDay12(String day12) {
		this.day12 = day12;
	}

	public String getDay13() {
		return day13;
	}

	public void setDay13(String day13) {
		this.day13 = day13;
	}

	public String getDay14() {
		return day14;
	}

	public void setDay14(String day14) {
		this.day14 = day14;
	}

	public String getDay15() {
		return day15;
	}

	public void setDay15(String day15) {
		this.day15 = day15;
	}

	public String getDay16() {
		return day16;
	}

	public void setDay16(String day16) {
		this.day16 = day16;
	}

	public String getDay17() {
		return day17;
	}

	public void setDay17(String day17) {
		this.day17 = day17;
	}

	public String getDay18() {
		return day18;
	}

	public void setDay18(String day18) {
		this.day18 = day18;
	}

	public String getDay19() {
		return day19;
	}

	public void setDay19(String day19) {
		this.day19 = day19;
	}

	public String getDay2() {
		return day2;
	}

	public void setDay2(String day2) {
		this.day2 = day2;
	}

	public String getDay20() {
		return day20;
	}

	public void setDay20(String day20) {
		this.day20 = day20;
	}

	public String getDay21() {
		return day21;
	}

	public void setDay21(String day21) {
		this.day21 = day21;
	}

	public String getDay22() {
		return day22;
	}

	public void setDay22(String day22) {
		this.day22 = day22;
	}

	public String getDay23() {
		return day23;
	}

	public void setDay23(String day23) {
		this.day23 = day23;
	}

	public String getDay24() {
		return day24;
	}

	public void setDay24(String day24) {
		this.day24 = day24;
	}

	public String getDay25() {
		return day25;
	}

	public void setDay25(String day25) {
		this.day25 = day25;
	}

	public String getDay26() {
		return day26;
	}

	public void setDay26(String day26) {
		this.day26 = day26;
	}

	public String getDay27() {
		return day27;
	}

	public void setDay27(String day27) {
		this.day27 = day27;
	}

	public String getDay28() {
		return day28;
	}

	public void setDay28(String day28) {
		this.day28 = day28;
	}

	public String getDay29() {
		return day29;
	}

	public void setDay29(String day29) {
		this.day29 = day29;
	}

	public String getDay3() {
		return day3;
	}

	public void setDay3(String day3) {
		this.day3 = day3;
	}

	public String getDay30() {
		return day30;
	}

	public void setDay30(String day30) {
		this.day30 = day30;
	}

	public String getDay31() {
		return day31;
	}

	public void setDay31(String day31) {
		this.day31 = day31;
	}

	public String getDay4() {
		return day4;
	}

	public void setDay4(String day4) {
		this.day4 = day4;
	}

	public String getDay5() {
		return day5;
	}

	public void setDay5(String day5) {
		this.day5 = day5;
	}

	public String getDay6() {
		return day6;
	}

	public void setDay6(String day6) {
		this.day6 = day6;
	}

	public String getDay7() {
		return day7;
	}

	public void setDay7(String day7) {
		this.day7 = day7;
	}

	public String getDay8() {
		return day8;
	}

	public void setDay8(String day8) {
		this.day8 = day8;
	}

	public String getDay9() {
		return day9;
	}

	public void setDay9(String day9) {
		this.day9 = day9;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getMonthRelPrice() {
		return monthRelPrice;
	}

	public void setMonthRelPrice(String monthRelPrice) {
		this.monthRelPrice = monthRelPrice;
	}

	public String getMonthSysPrice() {
		return monthSysPrice;
	}

	public void setMonthSysPrice(String monthSysPrice) {
		this.monthSysPrice = monthSysPrice;
	}

	public String getMonthTimes() {
		return monthTimes;
	}

	public void setMonthTimes(String monthTimes) {
		this.monthTimes = monthTimes;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public String getSpecific() {
		return specific;
	}

	public void setSpecific(String specific) {
		this.specific = specific;
	}

	public String getTapCode() {
		return tapCode;
	}

	public void setTapCode(String tapCode) {
		this.tapCode = tapCode;
	}

	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("day15", this.day15).append(
				"day23", this.day23).append("day30", this.day30).append(
				"day26", this.day26).append("month", this.month).append("day1",
				this.day1).append("monthRelPrice", this.monthRelPrice).append(
				"specific", this.specific).append("day16", this.day16).append(
				"day3", this.day3).append("day5", this.day5).append("day17",
				this.day17).append("advVer", this.advVer).append("day24",
				this.day24).append("day14", this.day14).append("day25",
				this.day25).append("day31", this.day31).append("monthSysPrice",
				this.monthSysPrice).append("day9", this.day9).append("day12",
				this.day12).append("day4", this.day4).append("advName",
				this.advName).append("day22", this.day22).append("day6",
				this.day6).append("day11", this.day11).append("tapCode",
				this.tapCode).append("monthTimes", this.monthTimes).append(
				"day27", this.day27).append("day21", this.day21).append(
				"length", this.length).append("day7", this.day7).append(
				"resource", this.resource).append("day10", this.day10).append(
				"day29", this.day29).append("day28", this.day28).append(
				"day18", this.day18).append("day8", this.day8).append("day13",
				this.day13).append("carrier", this.carrier).append("day20",
				this.day20).append("day2", this.day2).append("day19",
				this.day19).toString();
	}
	public String getCarrierParent() {
		return carrierParent;
	}
	public void setCarrierParent(String carrierParent) {
		this.carrierParent = carrierParent;
	}
	public String getResourceMemo() {
		return resourceMemo;
	}
	public void setResourceMemo(String resourceMemo) {
		this.resourceMemo = resourceMemo;
	}
	public String getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public String getOrderSubCate() {
		return orderSubCate;
	}
	public void setOrderSubCate(String orderSubCate) {
		this.orderSubCate = orderSubCate;
	}
	public String getMonthEnd() {
		return monthEnd;
	}
	public void setMonthEnd(String monthEnd) {
		this.monthEnd = monthEnd;
	}
	public String getMonthStart() {
		return monthStart;
	}
	public void setMonthStart(String monthStart) {
		this.monthStart = monthStart;
	}
	public String getBroStartEndTime() {
		return broStartEndTime;
	}
	public void setBroStartEndTime(String broStartEndTime) {
		this.broStartEndTime = broStartEndTime;
	}
	public String getPublishMemo() {
		return publishMemo;
	}
	public void setPublishMemo(String publishMemo) {
		this.publishMemo = publishMemo;
	}
	public String getCheckState() {
		return checkState;
	}
	public void setCheckState(String checkState) {
		this.checkState = checkState;
	}

}
