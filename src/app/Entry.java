package app;

import app.controller.UserController;
import app.repository.UserRepository;
import app.service.UserService;
import app.view.UserView;

public class Entry {
    public static void main(String[] args) {
        new UserController(
            new UserService(
                    new UserRepository()),
                    new UserView()
            ).runApp();
    }
}
