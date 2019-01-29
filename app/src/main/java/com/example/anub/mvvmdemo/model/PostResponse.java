package com.example.anub.mvvmdemo.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;


@Entity
@Generated("com.robohorse.robopojogenerator")
public class PostResponse{

    @PrimaryKey
	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	@SerializedName("body")
	private String body;

	@SerializedName("userId")
	private int userId;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setBody(String body){
		this.body = body;
	}

	public String getBody(){
		return body;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	@Override
 	public String toString(){
		return
			"PostResponse{" +
			"id = '" + id + '\'' +
			",title = '" + title + '\'' +
			",body = '" + body + '\'' +
			",userId = '" + userId + '\'' +
			"}";
		}
}
