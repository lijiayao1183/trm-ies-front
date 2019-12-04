package com.trm.model.common;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ComIntDataTwo {
	private BigInteger num;
	private BigDecimal count;

	public BigInteger getNum() {
		return num;
	}

	public void setNum(BigInteger num) {
		this.num = num;
	}

	public BigDecimal getCount() {
		return count;
	}

	public void setCount(BigDecimal count) {
		this.count = count;
	}

	public ComIntDataTwo(BigInteger num, BigDecimal count) {
		super();
		this.num = num;
		this.count = count;
	}

	public ComIntDataTwo() {
		super();
	}

}
