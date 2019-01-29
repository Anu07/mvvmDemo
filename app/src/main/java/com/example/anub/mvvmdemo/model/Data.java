package com.example.anub.mvvmdemo.model;

public class Data{
	private String businessToken;

	public void setBusinessToken(String businessToken){
		this.businessToken = businessToken;
	}

	public String getBusinessToken(){
		return businessToken;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"businessToken = '" + businessToken + '\'' + 
			"}";
		}
}
