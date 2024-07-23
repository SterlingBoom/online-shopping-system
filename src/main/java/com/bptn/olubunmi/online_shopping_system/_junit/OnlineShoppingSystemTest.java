package com.bptn.olubunmi.online_shopping_system._junit;

//package com.bptn.olubunmi.online_shopping_system.console;

import com.bptn.olubunmi.online_shopping_system._service.UserService;
import com.bptn.olubunmi.online_shopping_system.data.UserData;
import com.bptn.olubunmi.online_shopping_system.management.OnlineShoppingSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class OnlineShoppingSystemTest {
	private OnlineShoppingSystem onlineShoppingSystem;
	private UserService userService;

	@BeforeEach
	public void setUp() {
		onlineShoppingSystem = new OnlineShoppingSystem();
		List<UserData> users = new ArrayList<>();
		userService = new UserService(users);

//        // Adding a test user
		UserData userTest = new UserData("userTest", "password123", "test@example.com", "123 Test St");
		userService.addUser(userTest);
	}

	@Test
	public void testLoginSuccessful() {
		String username = "userTest";
		String password = "password123";

//        using this to test
//        Expecting Result for successful - assertNotNull(loggedInUser)
//        Expecting Result for not successful- assertNull(loggedInUser)
//        String password = "wrongPassword";

		UserData loggedInUser = userService.getUserByUsernameAndPassword(username, password);

		assertNotNull(loggedInUser, "User should be logged in successfully.");
		assertEquals(username, loggedInUser.getUsername(), "Username should match.");
	}

	@Test
	public void testLoginFailure() {
		String username = "UserTest";
		String password = "wrongPassword";

		UserData loggedInUser = userService.getUserByUsernameAndPassword(username, password);

		assertNull(loggedInUser, "User should not log in with incorrect password.");
	}

	@Test
	public void testLoginWithInvalidUsernameAndEmail() {
		String username = "invalidUser";
		String password = "wrongPassword";

		UserData loggedInUser = userService.getUserByUsernameAndPassword(username, password);

		assertNull(loggedInUser, "User should not be found for invalid username and password.");
	}
}
