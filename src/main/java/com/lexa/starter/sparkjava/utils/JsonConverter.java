package com.lexa.starter.sparkjava.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.reflect.Type;

public class JsonConverter {
	private static final Gson gson = new GsonBuilder().create();
	
	public static  <T> T convertFromJson(String toConvert,  Class<T>  clazz){
        return gson.fromJson(toConvert, clazz);
    }
	
	public static  <T> T convertFromJson(String toConvert,  Type  typeOfT){
        return gson.fromJson(toConvert, typeOfT);
    }
	
	public static String convertToJson(Object toConvert){
        return gson.toJson(toConvert);
    }
}
