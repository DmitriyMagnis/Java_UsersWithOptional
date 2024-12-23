package app.utils;

public class UserValidator {
    private static final String ID_REGEX = "^\\d+$";

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public static boolean isIdValid(String id) {
        return !id.isEmpty() & id.matches(ID_REGEX);
    }

    public static boolean isEmailValid(String email) {
        return !email.isEmpty() & email.matches(EMAIL_REGEX);
    }

}
