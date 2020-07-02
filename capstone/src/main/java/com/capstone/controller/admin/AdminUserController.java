package com.capstone.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.model.AppUserDTO;
import com.capstone.service.AppUserService;

@Controller
public class AdminUserController {
	@Autowired
	private AppUserService userService;

	@GetMapping(value = "/admin/user/search")
	public String searchUser(HttpServletRequest request,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "page", required = false) Integer page) {
		page = page == null ? 1 : page;
		keyword = keyword == null ? "" : keyword;
		// mac dinh 10 ban ghi 1 trang
		List<AppUserDTO> userList = userService.search(keyword, 0, page * 10);
		request.setAttribute("userList", userList);
		request.setAttribute("page", page);
		request.setAttribute("keyword", keyword);
		return "admin/user/userList";
	}

	@GetMapping(value = "/admin/user/add")
	public String AdminAddUserGet() {
		return "admin/user/userAdd";
	}

	@PostMapping(value = "/admin/user/add")
	public String AdminAddUserPost(@ModelAttribute(name = "adduser") AppUserDTO user) {		
		userService.insert(user);
		return "redirect:/admin/user/search";

	}

	@GetMapping(value = "/admin/user/update")
	public String AdminUpdateUserGet(Model model, @RequestParam(name = "id") Long id) {
		AppUserDTO user = userService.get(id);
		model.addAttribute("user", user);
		return "admin/user/userUpdate";
	}

	@PostMapping(value = "/admin/user/update")
	public String changePassword(@ModelAttribute(name = "user") AppUserDTO user) {
		userService.update(user);
		return "redirect:/admin/user/search";
	}
			

	@GetMapping(value = "/admin/user/delete")
	public String deleteUser(Long id) {
		userService.delete(id);
		return "redirect:/admin/user/search";
	}
}
