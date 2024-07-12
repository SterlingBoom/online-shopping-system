package com.bptn.olubunmi.online_shopping_system._junit;

//package com.bptn.olubunmi.online_shopping_system.console;

import com.bptn.olubunmi.online_shopping_system._service.UserService;
import com.bptn.olubunmi.online_shopping_system.console.OnlineShoppingSystem;
import com.bptn.olubunmi.online_shopping_system.data.UserData;
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
        UserData testUser = new UserData("testUser", "password123", "test@example.com", "123 Test St");
        userService.addUser(testUser);
    }

    @Test
    public void testLoginSuccessful() {
        String username = "testUser";
        String password = "password123";

        UserData loggedInUser = userService.getUserByUsernameAndPassword(username, password);
        
        assertNotNull(loggedInUser, "User should be logged in successfully.");
        assertEquals(username, loggedInUser.getUsername(), "Username should match.");
    }

    @Test
    public void testLoginFailure() {
        String username = "testUser";
        String password = "wrongPassword";

        UserData loggedInUser = userService.getUserByUsernameAndPassword(username, password);
        
        assertNull(loggedInUser, "User should not log in with incorrect password.");
    }
}

