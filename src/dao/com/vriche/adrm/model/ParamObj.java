package com.vriche.adrm.model;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ParamObj extends BaseObjectWithoutNestedFormValidation {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2278410608099538886L;
	
	protected String lable;
	protected String value1;
	protected String value2;
	protected String value3;
	protected String value4;
	protected String value5;
	protected String value6;
	protected String value7;
	protected String value8;
	protected String value9;
	protected String value10;
	protected String value11;
	protected String value12;
	protected String value13;
	protected String value14;
	protected String value15;
	
	protected String loginUser;
	protected String loginUserId;
	protected String orgId;
	protected String model;
	protected String whereModel;
	protected String displayModel;
	
	
	public String getValue1() {
		return value1;
	}
	public void setValue1(String value1) {
		this.value1 = value1;
	}
	public String getValue10() {
		return value10;
	}
	public void setValue10(String value10) {
		this.value10 = value10;
	}
	public String getValue11() {
		return value11;
	}
	public void setValue11(String value11) {
		this.value11 = value11;
	}
	public String getValue12() {
		return value12;
	}
	public void setValue12(String value12) {
		this.value12 = value12;
	}
	public String getValue13() {
		return value13;
	}
	public void setValue13(String value13) {
		this.value13 = value13;
	}
	public String getValue14() {
		return value14;
	}
	public void setValue14(String value14) {
		this.value14 = value14;
	}
	public String getValue15() {
		return value15;
	}
	public void setValue15(String value15) {
		this.value15 = value15;
	}
	public String getValue2() {
		return value2;
	}
	public void setValue2(String value2) {
		this.value2 = value2;
	}
	public String getValue3() {
		return value3;
	}
	public void setValue3(String value3) {
		this.value3 = value3;
	}
	public String getValue4() {
		return value4;
	}
	public void setValue4(String value4) {
		this.value4 = value4;
	}
	public String getValue5() {
		return value5;
	}
	public void setValue5(String value5) {
		this.value5 = value5;
	}
	public String getValue6() {
		return value6;
	}
	public void setValue6(String value6) {
		this.value6 = value6;
	}
	public String getValue7() {
		return value7;
	}
	public void setValue7(String value7) {
		this.value7 = value7;
	}
	public String getValue8() {
		return value8;
	}
	public void setValue8(String value8) {
		this.value8 = value8;
	}
	public String getValue9() {
		return value9;
	}
	public void setValue9(String value9) {
		this.value9 = value9;
	}
	public String getLable() {
		return lable;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}
	public String getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("orgId", this.orgId).append(
				"loginUser", this.loginUser).append("lable", this.lable)
				.append("value1", this.value1).append("value2", this.value2)
				.append("value15", this.value15).append("value3", this.value3)
				.append("value14", this.value14).append("value4", this.value4)
				.append("value13", this.value13).append("value5", this.value5)
				.append("value12", this.value12).append("value6", this.value6)
				.append("value7", this.value7).append("value11", this.value11)
				.append("value8", this.value8).append("value10", this.value10)
				.append("value9", this.value9).toString();
	}
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getWhereModel() {
		return whereModel;
	}
	public void setWhereModel(String whereModel) {
		this.whereModel = whereModel;
	}
	public String getDisplayModel() {
		return displayModel;
	}
	public void setDisplayModel(String displayModel) {
		this.displayModel = displayModel;
	}
	public String getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

}
