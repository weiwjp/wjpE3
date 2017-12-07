package cn.e3.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	/**
	 * 跳转页面
	 */
	@RequestMapping("{page}")
	public String page(@PathVariable String page){
		return page;
	}
}
