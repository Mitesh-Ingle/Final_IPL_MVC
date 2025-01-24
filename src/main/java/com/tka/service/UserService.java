package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tka.dao.UserDao;
import com.tka.entity.Matches;
import com.tka.entity.Player;
import com.tka.entity.Team;
import com.tka.entity.User;

@Service
public class UserService {

	public UserService() {
		System.err.println("I am in UserService");
	}

	@Autowired
	UserDao userDao;

	public boolean loginCheck(User user) {
		System.err.println("I am in logincheck Service:" + user);
		return userDao.loginCheck(user);

	}

	public List<Player> fetchAllplayer() {
		System.err.println("fetchallPlayer userService");
		return userDao.fetchAllplayer();
	}

//	public boolean verifyUserCredentials(User user) {
//		// Implement logic to verify user credentials (e.g., check username and
//		// password)
//		return userDao.loginCheck(user);
//	}

	public List<Team> fetchAllTeams(User user) {
		System.err.println("fetchTeams UserSrvice" + user);
		return userDao.fetchTeamsByUser(user);
	}

	public List<Matches> allMatches(User user) {
		System.out.println("all Matches:" + user);
		return userDao.allMatches(user);
	}
}
