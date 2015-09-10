package com.netease.yuandao.alert.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.ui.ModelMap;

import com.netease.yuandao.alert.common.Const;


public class DataPack {
	public static final String KEY = "result";
	
	/**
	 * 包装结果为JSON数据
	 * @param model
	 * @param code
	 * @param message
	 * @param result
	 */
	public static void packResultMap(ModelMap model, int code, String message, Object result) {
		model.clear();

		model.put("code", code);
		model.put("message", message);
		model.put(KEY, result);
	}
	
	public static void packFailure(ModelMap model, String message) {
		model.clear();

		model.put("code", Const.FAIL);
		model.put("message", message);
	}
	
	
	public static void packFailure(ModelMap model, Exception e,Logger logger){
		if(e instanceof Exception){
			model.put("code", Const.FAIL);
			model.put("message", e.getMessage());
		}else{
			String msg=e.getMessage();
			if(msg==null){
				msg=e.getClass().getName();
			}
			msg="内部错误:"+msg;
			model.put("code", Const.FAIL);
			model.put("message", msg);
			logger.error(msg,e);
		}
	}
	
	public static void packOk(ModelMap model) {
		model.clear();

		model.put("code", Const.OK);
	}
	
	public static void packOk(ModelMap model, Object result) {
		model.clear();
		
		model.put("code", Const.OK);
		model.put("message", "");
		model.put(KEY, result);
	}
	
	public static void packOk(ModelMap model, List<?> list) {
		model.clear();

		model.put("code", Const.OK);
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("total", list.size());
		ret.put("list", list);
		model.put(KEY, ret);
	}
}
