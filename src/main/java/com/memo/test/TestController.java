package com.memo.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@Controller 
public class TestController {

	// String
	@ResponseBody
	@RequestMapping("/test1")
	public String test1() {
		return "Hello world";
	}
	
	// json
	@ResponseBody
	@RequestMapping("/test2")
	public Map<String, Object> test2(){
		Map<String, Object> result = new HashMap<>();
		result.put("aaaa", 1234);
		result.put("bbbb", "zzz");
		result.put("cccc", "asd");
		
		return result;
	}
	
	// jsp
	@RequestMapping("/test3")
	public String test3() {
		return "test/example";
	}
}
