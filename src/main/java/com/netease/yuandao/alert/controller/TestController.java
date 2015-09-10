/**
 * 
 */
package com.netease.yuandao.alert.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.netease.yuandao.alert.utils.DataPack;

/**
 * @author Administrator
 * a test controller ,u can type http://localhost:8080/api/alert/test to send a get request
 * or http://localhost:8080/alert/test to open a test page.
 */
@Controller
public class TestController {

	@RequestMapping("/api/alert/test")
	public void test(ModelMap model){
		Map<Object,Object> result = new HashMap<Object,Object>();
		result.put("test", "test");
		DataPack.packOk(model,result);
		return ;
	}
	
	@RequestMapping("/alert/test")
	public String test(HttpServletRequest request,@RequestParam(value="test",required=false) String test,ModelMap model){
		model.put("test", test);
		return "test/test";
	}
}
