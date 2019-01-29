package com.example.anub.mvvmdemo.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class CarsItem{

	@SerializedName("models")
	private List<String> models;

	@SerializedName("name")
	private String name;

	public void setModels(List<String> models){
		this.models = models;
	}

	public List<String> getModels(){
		return models;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"CarsItem{" + 
			"models = '" + models + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}