package com.kyeomjae.springmvc;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/manager/**")
public class ManagerController {

	private static final Logger logger = LoggerFactory
			.getLogger(ManagerController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String deleteUser(Locale locale, Model model, @RequestParam(value = "id", required = true) int id) {
		model.addAttribute("id", id);

		return "delete";
	}
}
