package edu.aluismarte.diplomado.utils;

import edu.aluismarte.diplomado.model.week4.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author aluis on 3/27/2022.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DBSimulator {

    private static final DBSimulator instance = new DBSimulator();

    private static final List<User> USERS = List.of(
            new User("1", "Pedro"),
            new User("2", "Raul")
    );

    public static DBSimulator get() {
        return instance;
    }

    public User findUser(String id) {
        return USERS.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }
}
