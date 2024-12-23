package app.service;

import app.entity.User;
import app.exceptions.UserException;
import app.repository.UserRepository;
import app.utils.UserValidator;
import java.io.IOException;
import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(String userId) throws IOException {
        if (UserValidator.isIdValid(userId)) {
            return userRepository
                    .getUserById(Integer.parseInt(userId))
                    .orElse(null);
        }

        throw new UserException("Wrong user Id!");

    }

    public User getUserByEmail(String email) throws IOException {
        if (UserValidator.isEmailValid(email)) {
            return userRepository
                    .getUserByEmail(email)
                    .orElse(null);
        }

        throw new UserException("Wrong user email!");
    }

    public List<User> getAllUsers() throws IOException {
        return userRepository.getAllUsers().orElse(null);
    }
}
