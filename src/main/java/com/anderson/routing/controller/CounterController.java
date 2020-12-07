package com.anderson.routing.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	
	@RequestMapping("/")
    public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			int counter = (int) session.getAttribute("count") + 1 ;
			session.setAttribute("count", counter );
		}
        return "index.jsp";
    }
	
	@RequestMapping("/counter")
	public String count(Model model, HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		model.addAttribute("counter", session.getAttribute("count"));
		return "count.jsp";
	}
	

}
