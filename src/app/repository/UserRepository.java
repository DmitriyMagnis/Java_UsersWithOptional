package app.repository;

import app.entity.User;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements IUserRepository {
    private final String BASE_PATH = "db";
    private final String FILE_NAME = "users";

    public List<User> getData() throws IOException {
        List<User> users = new ArrayList<>();

        Files.readAllLines(Paths.get(BASE_PATH, FILE_NAME + ".txt")).forEach(str -> {
            String[] data = str.trim().split("\\s+");
            User product = new User(Integer.parseInt(data[0]), data[1], data[2]);
            users.add(product);
        });

        return users;
    }

    public Optional<User> getUserById(int userId) throws IOException {
        return this.getData()
                .stream()
                .filter(user -> user.getId() == userId)
                .findFirst();
    }
    public Optional<User> getUserByEmail(String email) throws IOException {
        return this.getData()
                .stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public Optional<List<User>> getAllUsers() throws IOException {
        return Optional.of(this.getData())
                       .filter(data -> !data.isEmpty())
                       .map(ArrayList::new);
    }
}
