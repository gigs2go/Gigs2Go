package com.gigs2go.repos.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.gigs2go.model.entities.security.User;
import com.gigs2go.model.repos.security.UserRepository;
import com.gigs2go.repos.AbstractRepoTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:config/repo.xml")
@Transactional
public class UserRepositoryTest extends AbstractRepoTest {

	private Logger logger = Logger
			.getLogger(UserRepositoryTest.class);

	@Autowired
	private UserRepository repo;

	@Test
	public void testInject() {
		assertNotNull(repo);
	}

	@Rollback
	@Test
	public void testSaveUser() {
		logger.debug("Creating user");
		User user = new User();
		user.setUsername("fred"); 
		user.setPassword("password");
		user = repo.save(user);
		user = null;
		user = repo.findOne("fred");
		assertNotNull(user);
		assertEquals("fred", user.getUsername());
		assertEquals("password", user.getPassword());
	}

	@Test
	public void testFindUserByUsername() {
		logger.debug("Finding user");
		List<User> users = repo.findByUsername("tim");
		assertNotNull(users);
		assertEquals(1, users.size());
		User user = users.get(0);
		assertEquals("tim", user.getUsername());
	}

}
