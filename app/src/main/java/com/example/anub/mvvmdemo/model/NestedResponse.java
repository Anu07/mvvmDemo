package com.example.anub.mvvmdemo.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class NestedResponse{

	@SerializedName("cars")
	private List<CarsItem> cars;

	@SerializedName("name")
	private String name;

	@SerializedName("age")
	private int age;

	public void setCars(List<CarsItem> cars){
		this.cars = cars;
	}

	public List<CarsItem> getCars(){
		return cars;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setAge(int age){
		this.age = age;
	}

	public int getAge(){
		return age;
	}

	@Override
 	public String toString(){
		return 
			"NestedResponse{" + 
			"cars = '" + cars + '\'' + 
			",name = '" + name + '\'' + 
			",age = '" + age + '\'' + 
			"}";
		}
}