package com.lexa.starter.sparkjava.utils;

import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer{
	
	@Override
	public String render(Object model) throws Exception {
		return JsonConverter.convertToJson(model);
	}
}
