package com.tka.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tka.entity.Matches;
import com.tka.entity.Player;
import com.tka.entity.Team;
import com.tka.entity.User;
import com.tka.service.UserService;

@Controller
@Component
public class UserController {

	public UserController() {
		System.err.println("I am in UserController");
	}

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String openLoginPage() {
		return "login";
	}

	@GetMapping("/logincheck")
	public String loginCheck(@ModelAttribute User user, Model model) {
		System.err.println("In logincheck Controller=" + user);
		boolean correct = userService.loginCheck(user);
		System.err.println("credentials are:" + correct);
		System.err.println("fetchallplayer usercontroller");

		if (correct) {
			List<Player> playersList = userService.fetchAllplayer();
			model.addAttribute("allusers", playersList); // Set the list with the correct attribute name
			return "players"; // Return the view name "players"
		} else {
			model.addAttribute("message", "Invalid Credentials"); // Add error message to the model
			return "login"; // Return the view name "login"
		}
	}

	@GetMapping("/teamcheck")
	public String teamCheck(@ModelAttribute User user, Model model) {
		System.err.println("IN Teamcheck UserController=" + user);

		boolean correct = userService.loginCheck(user); // Separate credential check
		System.err.println("credentials are:" + correct);

		if (correct) {
			List<Team> teamList = userService.fetchAllTeams(user); // Fetch teams based on user
			model.addAttribute("allteams", teamList);
			return "teams";
		} else {
			model.addAttribute("message", "Invalid Credentials");
			return "login";
		}
	}

	@GetMapping("/allmatches")
	public String allMatches(@ModelAttribute User user, Model model) {
		System.out.println("In ALLMatches UserController" + user);

		boolean correct = userService.loginCheck(user);
		System.out.println("Credentials ARE:" + correct);
		if (correct) {
			List<Matches> matchesList = userService.allMatches(user);
			model.addAttribute("allmatches", matchesList);
			return "matches";

		} else {
			model.addAttribute("message", " Invalid Credentials");
			return "login";
		}

	}

}
