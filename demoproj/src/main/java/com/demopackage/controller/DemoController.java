package com.demopackage.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demopackage.model.User;
import com.demopackage.service.DemoService;

@RestController
@RequestMapping("/")
public class DemoController {
	
	@Autowired
	private DemoService demoService;

	@ResponseBody
    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
	public Map<String, Object> insert(@RequestBody User user){
		Map<String, Object> data = new HashMap();
		boolean insert = demoService.insert(user);
		data.put("message", insert);		
		return data;
	}
	
	
	@ResponseBody
    @RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
	public Map<String, Object> delete(@PathVariable("id") String id){
		Map<String, Object> data = new HashMap<String, Object>();
		boolean delete =  demoService.delete(id);
		data.put("message", delete);	
		return data;
	}
	
	@ResponseBody
    @RequestMapping(value = {"/getall"}, method = RequestMethod.GET)
	public Map<String, Object> getAll(){
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("message",demoService.getAll());
		return data;
	}
	
    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
	public ModelAndView welcome(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");	
		return mv;
	}
	
	
	
	
}
