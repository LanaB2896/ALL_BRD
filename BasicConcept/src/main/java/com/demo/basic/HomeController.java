package com.demo.basic;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.basic.info.Details;
import com.demo.basic.info.Login;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String first(Locale locale, Model model) {
		List<String> Types = new ArrayList<String>();
		Types.add("Admin");
		Types.add("User");
		model.addAttribute("RoleTypes", Types );
		model.addAttribute("direction", new Details());
		return "performance";
	}
		
		@RequestMapping(value = "/", method = RequestMethod.POST)
		public String second(@ModelAttribute("direction")Details details, Locale locale, Model model) {
			model.addAttribute("direction", details);
			return "home";
		}
	
		@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hai(Locale locale, Model model) {
		
		
		model.addAttribute("Details", new Login());
		return "home";
	}
		
		@RequestMapping(value = "/", method = RequestMethod.POST)
		public String bye(@ModelAttribute("Details")Login admin, Locale locale, Model model) {
			
			
			model.addAttribute("Details", admin);
			return "home";
	}
}
