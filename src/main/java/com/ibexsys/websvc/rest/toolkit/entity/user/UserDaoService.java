package com.ibexsys.websvc.rest.toolkit.entity.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
	
	private static final List<User> users = new ArrayList<>();

	private static Long usersCount = 4L;

	static {
		users.add(new User(1L, "Dave", new Date()));
		users.add(new User(2L, "Janet", new Date()));
		users.add(new User(3L, "Mike", new Date()));
		users.add(new User(4L, "FooBar", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

//	public User save(User user) {
//		if (user.getId() == null) {
//			user.setId(++usersCount);
//		}
//		users.add(user);
//		return user;
//	}

	public User findById(Long id) {
		for (User user : users) {
			if (user.getId().equals(id)) {
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
