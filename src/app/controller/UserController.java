package app.controller;

import app.entity.User;
import app.service.UserService;
import app.view.UserView;
import java.util.List;

public class UserController {
    private final UserService userService;
    private final UserView userView;

    public UserController(UserService userService, UserView userView) {
        this.userService = userService;
        this.userView = userView;
    }

    public void runApp() {
        switch (userView.showMenu()) {
            case "1":
                getAllUsers();
                runApp();
                break;
            case "2":
                getUserById();
                runApp();
                break;
            case "3":
                getUserByEmail();
                runApp();
                break;
            case "0":
                System.exit(0);
                break;
            default:
                runApp();
        }
    }

    private void getUserById() {
        try {
            User user = userService.getUserById(userView.getUserId());

            if (user != null )
                userView.getOutput(user);
            else userView.getOutput("No User found!");

        } catch (Exception e) {
            userView.getOutput(e.getMessage());
        }
    }

    private void getUserByEmail() {
        try {
            User user = userService.getUserByEmail(userView.getUserEmail());

            if (user != null )
                userView.getOutput(user);
            else userView.getOutput("No User found!");

        } catch (Exception e) {
            userView.getOutput(e.getMessage());
        }
    }

    private void getAllUsers() {
        try {
            List<User> userList = userService.getAllUsers();

            if (userList != null)
                userView.getOutput(userList);
            else
                userView.getOutput("No users found!");

        } catch (Exception e) {
            userView.getOutput(e.getMessage());
        }

    }
}
