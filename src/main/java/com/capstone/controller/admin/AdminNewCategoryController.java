package com.capstone.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.model.NewCategoryDTO;
import com.capstone.service.NewCategoryService;

@Controller
public class AdminNewCategoryController {
	@Autowired
	private NewCategoryService categoryService;
	
	@GetMapping(value = "/admin/newCat/search")
	public String searchCategory(HttpServletRequest request
//			,
//			@RequestParam(value = "keyword", required = false) String keyword,
//			@RequestParam(value = "page", required = false) Integer page
			) {
//		final int PAGE_SIZE = 7;
//		page = page == null ? 1 : page;
//		keyword = keyword == null ? "" : keyword;
//		int totalPage = categoryService.countCategoryWhensearch(keyword);
//		int pageCount = (totalPage % PAGE_SIZE == 0) ? totalPage / PAGE_SIZE : totalPage / PAGE_SIZE + 1;
//		// mac dinh 10 ban ghi 1 trang
		List<NewCategoryDTO> categoryList = categoryService.getAllCategories();
//		List<Integer> listCount = new ArrayList<Integer>();
//		for(int i=1;i<=pageCount;i++) {
//			listCount.add(i);
//		}
		request.setAttribute("categoryList", categoryList);
//		request.setAttribute("page", page);
//		request.setAttribute("keyword", keyword);
//		request.setAttribute("listCount", listCount);
		return "admin/newsCategory/manage-news-category";
	}
	
	@GetMapping(value = "/admin/newCat/insert")
    public String CategoryInsert() {       
        return "admin/newsCategory/add-news-category";
    }
	
	@PostMapping(value = "/admin/newCat/insert")
	public String AdminAddCategoryPost(@ModelAttribute(name = "addCategory") NewCategoryDTO category) {		
		categoryService.addCategory(category);
		return "redirect:/admin/newCat/search";

	}
	
	@GetMapping(value = "/admin/newCat/update")
	public String AdminUpdateCategoryGet(Model model, @RequestParam(name = "id") int id) {
		NewCategoryDTO category = categoryService.getCategorybyId(id);
		model.addAttribute("category", category);
		return "admin/newsCategory/edit-news-category";
	}

	@PostMapping(value = "/admin/newCat/update")
	public String AdminUpdateCategoryPost(@ModelAttribute(name = "category") NewCategoryDTO category) {
		categoryService.updateCategory(category);
		return "redirect:/admin/newCat/search";
	}
			

	@GetMapping(value = "/admin/newCat/delete")
	public String deleteCategory(int id) {
		categoryService.deleteCategory(id);
		return "redirect:/admin/newCat/search";
	}
}
