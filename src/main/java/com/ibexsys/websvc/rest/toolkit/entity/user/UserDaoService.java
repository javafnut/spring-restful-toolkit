package com.ibexsys.websvc.rest.toolkit.entity.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();

	private static Long usersCount = 4l;

	static {
		users.add(new User(1l, "Dave", new Date()));
		users.add(new User(2l, "Janet", new Date()));
		users.add(new User(3l, "Mike", new Date()));
		users.add(new User(4l, "FooBar", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}

	public User findById(Long id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User deleteById(long id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
