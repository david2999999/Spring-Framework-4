package com.spring.domain.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VisitorData implements Serializable {

	private static final long serialVersionUID = -8102054687812594494L;
	
	private String currentVisitorName;
	private String currentVisitorEmail;
	private List<Visitor> visitors = new ArrayList<Visitor>();
	
	public VisitorData() {
		super();
	}

	public VisitorData(String currentVisitorName, String currentVisitorEmail, List<Visitor> visitors) {
		super();
		this.currentVisitorName = currentVisitorName;
		this.currentVisitorEmail = currentVisitorEmail;
		this.setVisitors(visitors);
	}

	public String getCurrentVisitorName() {
		return currentVisitorName;
	}

	public void setCurrentVisitorName(String currentVisitorName) {
		this.currentVisitorName = currentVisitorName;
	}

	public String getCurrentVisitorEmail() {
		return currentVisitorEmail;
	}

	public void setCurrentVisitorEmail(String currentVisitorEmail) {
		this.currentVisitorEmail = currentVisitorEmail;
	}
	
	@Override
	public String toString() {
		return "Visitor data: " + currentVisitorEmail + " , " + currentVisitorName;
	}

	public List<Visitor> getVisitors() {
		return visitors;
	}

	public void setVisitors(List<Visitor> visitors) {
		this.visitors = visitors;
	}
}
