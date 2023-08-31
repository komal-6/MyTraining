package com.ignek.customanno.customannotation;

@SmartPhone(os="Android", version=6)
public class NokiaSeries {
	String os;
	int version;
	public NokiaSeries(String os, int version) {
		super();
		this.os = os;
		this.version = version;
	}
	
}
