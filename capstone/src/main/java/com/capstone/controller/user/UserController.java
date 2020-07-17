package com.capstone.controller.user;

import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capstone.model.HashTagDTO;
import com.capstone.model.NewCategoryDTO;
import com.capstone.model.NewsDTO;
import com.capstone.service.HashTagService;
import com.capstone.service.NewCategoryService;
import com.capstone.service.NewsService;

@Controller
public class UserController {

	@Autowired
	private NewsService newsService;
	@Autowired
	private NewCategoryService newCatService;
	@Autowired
	private HashTagService hashtagService;
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		List<NewsDTO> listNews = newsService.getTop6News();
		request.setAttribute("NewList", listNews);
		return "/user/home";
	}
	
	@RequestMapping(value = "/tintuc", method = RequestMethod.GET)
	public String Tintuc(HttpServletRequest request ) {
//		NewCategoryDTO category = new NewCategoryDTO();
		List<NewCategoryDTO> listNewsCat = newCatService.getAllCategories();
		List<NewsDTO> listNews = newsService.getAllNews();
		List<NewsDTO> listNews4Date = newsService.getTop4NewsByDate();
		List<HashTagDTO> listTag = hashtagService.getAllTags();		
//		int countCat = newsService.countNewsOfCategory(category.getId());
		request.setAttribute("listNewsCat", listNewsCat);
		request.setAttribute("NewList", listNews);
		request.setAttribute("listTag", listTag);
		request.setAttribute("listNews4Date", listNews4Date);
//		request.setAttribute("countCat", countCat);
		return "/user/all_news";
	}
	
	@RequestMapping(value = "/bfp", method = RequestMethod.GET)  //ham Dat viet
	public String calculateBFP(Model model) {
		return "/user/result_bfp_caculate";
	}
	
	@RequestMapping(value = "/bmr", method = RequestMethod.GET)  //ham Dat viet
	public String calculateBMR(Model model) {
		return "/user/result_bmr_caculate";
	}

	@RequestMapping(value = "/bmi", method = RequestMethod.GET)  //ham Dat viet
	public String calculateBMI(Model model) {
		return "/user/result_bmi_caculate";
	}
	@PostMapping(value = "/bmi")
	public String CalBMI(HttpServletRequest request,
						@RequestParam(name = "weight", required = true) double weight,
						@RequestParam(name = "height", required = true) double height,
						@RequestParam(name = "inlineRadioOptions", required = true) String gender,
						Model model) {
		
		
		height = height / 100;
		double bmi = weight / (height * height);
		String tinhtrangBMI = null;
		
		

		if (bmi < 16) {
			tinhtrangBMI = "Gầy độ 3";
		} else if (bmi >= 16 && bmi < 17) {
			tinhtrangBMI = "Gầy độ 2";
		} else if (bmi >= 17 && bmi < 18.5) {
			tinhtrangBMI = " Gầy độ 1";
		} else if (bmi >= 18.5 && bmi < 25) {
			tinhtrangBMI = " Bình thường";
		} else if (bmi >= 25 && bmi < 30) {
			tinhtrangBMI = " Thừa cân";
		} else if (bmi >= 30 && bmi < 35) {
			tinhtrangBMI = " Béo phì cấp độ 1";
		} else if (bmi >= 35 && bmi < 40) {
			tinhtrangBMI = " Béo phì cấp độ 2";
		} else if (bmi > 40) {
			tinhtrangBMI = " Béo phì cấp độ 3";
		}
		
		bmi =Double.parseDouble(new DecimalFormat("##.###").format(bmi)); 
		
		model.addAttribute("bmi", bmi);
		model.addAttribute("tinhtrang", tinhtrangBMI);
		
		return "/user/result_bmi_caculate";

	}

	@PostMapping(value = "/bfp")
	public String CalBFP(HttpServletRequest request,
						@RequestParam(name = "age", required = true) double age,
						@RequestParam(name = "weight", required = true) double weight,
						@RequestParam(name = "height", required = true) double height,
						@RequestParam(name = "inlineRadioOptions", required = true) String gender,
						Model model) {
		
		height = height / 100;
		double bmi = weight / (height * height);
		double bfp = 5;
		String tinhtrangBFP = " ";

		if (gender.equals("male")) {
			bfp = 1.20 * bmi + 0.23 * age - 16.2;
			
		} else if (gender.equals("female")) {
			bfp = 1.20 * bmi + 0.23 * age - 5.4;
		}

//		if (gender.equals("male")) {
//			if (bfp >= 2 && bfp <= 5) {
//				tinhtrangBFP = "Essential fat";
//			}
//			if (bfp >= 6 && bfp <= 13) {
//				tinhtrangBFP = "Athletes ";
//			}
//			if (bfp >= 14 && bfp <= 17) {
//				tinhtrangBFP = "Fitness";
//			}
//			if (bfp >= 18 && bfp <= 25) {
//				tinhtrangBFP = "Average";
//			}
//			if (bfp >= 26) {
//				tinhtrangBFP = "Obese";
//			}
//		} else if (gender.equals("female")) {
//			if (bfp >= 10 && bfp <= 13) {
//				tinhtrangBFP = "Essential fat";
//			}
//			if (bfp >= 14 && bfp <= 20) {
//				tinhtrangBFP = "Athletes ";
//			}
//			if (bfp >= 21 && bfp <= 24) {
//				tinhtrangBFP = "Fitness";
//			}
//			if (bfp >= 25 && bfp <= 31) {
//				tinhtrangBFP = "Average";
//			}
//			if (bfp >= 32) {
//				tinhtrangBFP = "Obese";
//			}
//		}
		
		if (bfp >= 2 && bfp <= 5 && gender.equals("male")) {
			tinhtrangBFP = "Essential fat";
		}
		if (bfp >= 6 && bfp <= 13 && gender.equals("male")) {
			tinhtrangBFP = "Athletes ";
		}
		if (bfp >= 14 && bfp <= 17 && gender.equals("male")) {
			tinhtrangBFP = "Fitness";
		}
		if (bfp >= 18 && bfp <= 25 && gender.equals("male")) {
			tinhtrangBFP = "Average";
		}
		if (bfp >= 26 && gender.equals("male")) {
			tinhtrangBFP = "Obese";
		}
	
		if (bfp >= 10 && bfp <= 13 && gender.equals("female")) {
			tinhtrangBFP = "Essential fat";
		}
		if (bfp >= 14 && bfp <= 20 && gender.equals("female")) {
			tinhtrangBFP = "Athletes ";
		}
		if (bfp >= 21 && bfp <= 24 && gender.equals("female")) {
			tinhtrangBFP = "Fitness";
		}
		if (bfp >= 25 && bfp <= 31 && gender.equals("female")) {
			tinhtrangBFP = "Average";
		}
		if (bfp >= 32 && gender.equals("female")) {
			tinhtrangBFP = "Obese";		
	}
		
		
		
		bfp =Double.parseDouble(new DecimalFormat("##.###").format(bfp)); 
		
		model.addAttribute("tinhtrangbfp", tinhtrangBFP);
		model.addAttribute("bfp", bfp);
		
		return "/user/result_bfp_caculate";

	}
	
	@PostMapping(value = "/bmr")
	public String CalBMR(HttpServletRequest request,
						@RequestParam(name = "age", required = true) double age,
						@RequestParam(name = "weight", required = true) double weight,
						@RequestParam(name = "height", required = true) double height,
						@RequestParam(name = "inlineRadioOptions", required = true) String gender,
						@RequestParam(name = "cuongdo", required = true) String cuongdo,
						Model model) {
		
		height = height / 100;
		double bmr = 0;
		double bfp = 0;
		double bmi = weight / (height * height);
		double tdee=0;
		if (gender.equals("male")) {
			bfp = 1.20 * bmi + 0.23 * age - 16.2;
		} else if (gender.equals("female")) {
			bfp = 1.20 * bmi + 0.23 * age - 5.4;
		}
		
		bmr = 21.6 * weight * (100 -bfp)/100;
		
		if(cuongdo.equals("it")) {
			tdee = bmr * 1.2;
		}else if(cuongdo.equals("nhe")) {
			tdee = bmr * 1.375;
		}else if(cuongdo.equals("vuaphai")) {
			tdee = bmr * 1.55;
		}else if(cuongdo.equals("nhieu")) {
			tdee = bmr * 1.725;
		}else if(cuongdo.equals("ratnhieu")) {
			tdee = bmr * 1.9;
		}
		bmr =Double.parseDouble(new DecimalFormat("##.##").format(bmr)); 
		tdee =Double.parseDouble(new DecimalFormat("##.##").format(tdee));
		
		model.addAttribute("BMR", bmr);
		model.addAttribute("tdee", tdee);
		
		return "/user/result_bmr_caculate";

	}
	
	
}
