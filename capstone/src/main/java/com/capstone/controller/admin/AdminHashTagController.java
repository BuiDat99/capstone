package com.capstone.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.model.AppUserDTO;
import com.capstone.model.HashTagDTO;
import com.capstone.service.HashTagService;

@Controller
public class AdminHashTagController {

	@Autowired
	private HashTagService tagService;

	@GetMapping(value = "/admin/tag/search")
	public String searchTag(HttpServletRequest request,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "page", required = false) Integer page) {
		page = page == null ? 1 : page;
		keyword = keyword == null ? "" : keyword;
		// mac dinh 10 ban ghi 1 trang
		List<HashTagDTO> tagList = tagService.search(keyword, 0, page * 10);
		request.setAttribute("tagList", tagList);
		request.setAttribute("page", page);
		request.setAttribute("keyword", keyword);
		return "/admin/manager_tag";
	}
	
	@GetMapping(value = "/admin/tag/insert")
    public String TagInsert() {       
        return "/admin/insertTag";
    }
	
	@PostMapping(value = "/admin/tag/insert")
	public String AdminAddTagPost(@ModelAttribute(name = "addtag") HashTagDTO tag) {		
		tagService.addTag(tag);
		return "redirect:/admin/tag/search";

	}
	
	@GetMapping(value = "/admin/tag/update")
	public String AdminUpdateTagGet(Model model, @RequestParam(name = "id") int id) {
		HashTagDTO tag = tagService.getTagbyId(id);
		model.addAttribute("tag", tag);
		return "/admin/updateTag";
	}

	@PostMapping(value = "/admin/tag/update")
	public String AdminUpdateTagPost(@ModelAttribute(name = "tag") HashTagDTO tag) {
		tagService.updateTag(tag);
		return "redirect:/admin/tag/search";
	}
			

	@GetMapping(value = "/admin/tag/delete")
	public String deleteTag(int id) {
		tagService.deleteTag(id);;
		return "redirect:/admin/tag/search";
	}
	
	
}
