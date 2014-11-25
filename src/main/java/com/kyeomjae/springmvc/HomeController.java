package com.kyeomjae.springmvc;

import static com.kyeomjae.springmvc.service.UserServiceImpl.MIN_LOGCOUNT_FOR_SILVER;
import static com.kyeomjae.springmvc.service.UserServiceImpl.MIN_RECCOMEND_FOR_GOLD;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kyeomjae.springmvc.domain.Level;
import com.kyeomjae.springmvc.domain.User;
import com.kyeomjae.springmvc.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	UserService userService;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(
			Locale locale,
			Model model,
			@RequestParam(value = "a", required = true) int a,
			@RequestParam(value = "b", required = false, defaultValue = "5") int b) {
		model.addAttribute("result", a + b);

		return "result";
	}

	public void add() {
		this.userService.deleteAll();
		
		List<User> users = Arrays.asList(
				new User("bumjin", 		"박범진", "p1", "user1@ksug.org", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER - 1, 0), //49, 0
				new User("joytouch", 	"강명성", "p2", "user2@ksug.org", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 0), //50, 0
				new User("erwins", 		"신승한", "p3", "user3@ksug.org", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD - 1), //60, 29
				new User("madnite1", 	"이상호", "p4", "user4@ksug.org", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD), //60, 30
				new User("green", 		"오민규", "p5", "user5@ksug.org", Level.GOLD, 100, Integer.MAX_VALUE)
			);
		this.userService.add(users.get(0));
		this.userService.add(users.get(1));
		this.userService.add(users.get(2));
		this.userService.add(users.get(3));
		this.userService.add(users.get(4));
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get(Locale locale, Model model,
			@RequestParam(value = "id", required = true) String id) {
		this.add();
		
		User user = this.userService.get(id);
		model.addAttribute("user", user);
		return "userInfo";
	}
	
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public String getAll(Locale locale, Model model) {
		this.add();
		
		List<User> users = this.userService.getAll();
		model.addAttribute("users", users);
		return "usersInfo";
	}
}
