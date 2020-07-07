package com.capstone.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
		
	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public String adminHome(Model model) {       
        return "/admin/blank";
    }
    
	@RequestMapping(value = "/admin/newCat", method = RequestMethod.GET)
    public String NewCat(Model model) {       
        return "/admin/manager_category_news";
    }
	
	@RequestMapping(value = "/admin/news", method = RequestMethod.GET)
    public String News(Model model) {       
        return "/admin/manager_news";
    }	   
	    
	@RequestMapping(value = "/admin/user", method = RequestMethod.GET)
    public String User(Model model) {       
        return "/admin/manager_user";
    }
    
	@RequestMapping(value = "/admin/contact", method = RequestMethod.GET)
    public String Contact(Model model) {       
        return "/admin/manager_contact";
    }
}
