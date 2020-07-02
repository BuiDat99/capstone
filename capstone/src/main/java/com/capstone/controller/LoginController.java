package com.capstone.controller;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capstone.google.GooglePojo;
import com.capstone.google.GoogleUtils;
import com.capstone.utils.WebUtils;

@Controller
public class LoginController {
	
	 @Autowired
	  private GoogleUtils googleUtils;

	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
//        model.addAttribute("title", "Welcome");
//        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }
	
 
	 @RequestMapping("/login-google")
	  public String loginGoogle(HttpServletRequest request) throws ClientProtocolException, IOException {
	    String code = request.getParameter("code");
	    
	    if (code == null || code.isEmpty()) {
	      return "redirect:/login?google=error";
	    }
	    String accessToken = googleUtils.getToken(code);
	    
	    GooglePojo googlePojo = googleUtils.getUserInfo(accessToken);
	    UserDetails userDetail = googleUtils.buildUser(googlePojo);
	    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
	        userDetail.getAuthorities());
	    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    return "userInfoPage";
	  }
	 
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {
         
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
         
        return "admin/trangchu";
    }
 
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
 
        return "user/loginP";
    }
 
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }
 
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
 
        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();
 
        System.out.println("User Name: " + userName);
 
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
 
        if(userInfo.contains("ROLE_ADMIN"))
        {        	
        	return "redirect:/admin";
        }
        
        return "user/userInfoPage";
    }
 
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
 
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
            String userInfo = WebUtils.toString(loginedUser);
 
            model.addAttribute("userInfo", userInfo);
 
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
 
        }
 
        return "403Page";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {       
        return "/user/register";
    }
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {       
        return "/user/home";
    }
    
    @RequestMapping(value = "/bmi", method = RequestMethod.GET)
    public String calculateBMI(Model model) {       
        return "/user/result_bmi_caculate";
    }
}
