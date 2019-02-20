package JDI;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {
    public static User PITER = new User("epam", "1234", "PITER CHAILOVSKII");

    String login;
    String password;
    String fullName;
}
