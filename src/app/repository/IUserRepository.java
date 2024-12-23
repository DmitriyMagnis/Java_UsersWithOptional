package app.repository;

import app.entity.User;
import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> getData() throws Exception;
    Optional<User> getUserById(int userId) throws Exception;
    Optional<User> getUserByEmail(String email) throws Exception;
    Optional<List<User>> getAllUsers() throws Exception;
}
