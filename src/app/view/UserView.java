package app.view;

import app.entity.User;
import java.util.List;
import java.util.Scanner;

public class UserView {
    static Scanner scanner = new Scanner(System.in);

    public String showMenu() {
        System.out.print("Select one on following options: \n");
        System.out.print("1) Show all users. \n");
        System.out.print("2) Find user by id \n");
        System.out.print("3) Find user by email \n");
        System.out.print("0) Exit \n");
        return scanner.nextLine().trim();
    }

    public String getUserId() {
        System.out.print("Input user id: ");
        return scanner.nextLine().trim();
    }

    public String getUserEmail() {
        System.out.print("Input user email: ");
        return scanner.nextLine().trim();
    }

    public void getOutput(String output) {
        System.out.println(output);
    }

    public void getOutput(User user) {
        System.out.println(
                (
                    String.format(
                        "User: ID: %d, NAME: %s, EMAIL: %s",
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                    )
                )
        );
    }

    public void getOutput(List<User> users) {
        StringBuilder builder = new StringBuilder();

        for(User user: users) {
            builder.append(
                    String.format(
                    "ID: %d, Name: %s, Email: %s %n",
                    user.getId(),
                    user.getName(),
                    user.getEmail()
                    )
            );
        }
        System.out.println(builder);
    }

}
