package com.spring.domain.test;

import java.io.Serializable;

public class VisitorCount implements Serializable {

	private static final long serialVersionUID = -5560656606739015300L;

	private int count;

	public VisitorCount(int count) {
		super();
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
	
}





