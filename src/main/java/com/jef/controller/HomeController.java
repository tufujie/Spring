package com.jef.controller;

import java.io.IOException;

import com.jef.service.IHumanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    @Resource(name = "manService")
    private IHumanService manService;
    @Resource(name = "womanService")
    private IHumanService womanService;

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException {
        manService.speak();
        manService.walk();
        womanService.speak();
        womanService.walk();
		return new ModelAndView("home");
	}
}
