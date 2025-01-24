package com.tka.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.tka.entity.Matches;
import com.tka.entity.Player;
import com.tka.entity.Team;
import com.tka.entity.User;

@Repository
public class UserDao {

	public UserDao() {
		System.err.println("I am in UserDao");
	}

	@Autowired
	SessionFactory sessionFactory;

	public boolean loginCheck(User user) {
		System.err.println("I am in Logincheck Dao:" + user);
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("uname", user.getUname()));
		criteria.add(Restrictions.eq("password", user.getPassword()));
		List<User> userlist = criteria.list();
		System.err.println(userlist);
		if (userlist != null && userlist.size() == 1) {
			System.err.println("I am in IF Statement");
			return true;
		} else
//			model.addAttribute("message", "enter correct details");
			return false;
	}

	public List<Player> fetchAllplayer() {
		System.err.println("fetchallplayer userDao");
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Player.class);
		List<Player> playersList = criteria.list();
		session.close();
		return playersList;

	}

	public List<Team> fetchTeamsByUser(User user) {
		System.err.println("fetchteam UserDao");
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Team.class);
		// criteria.add(Restrictions.eq("id", user.getUid())); // Assuming there's a
		// userId field in Team
		List<Team> teamList = criteria.list();
		session.close();
		return teamList;
	}

	public List<Matches> allMatches(User user) {
		System.err.println("All Matches UserDAO");
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Matches.class);
		List<Matches> matchesList = criteria.list();
		session.close();
		return matchesList;

	}
}
