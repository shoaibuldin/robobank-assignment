package nl.robobank.dummy;

import nl.rabobank.enums.RoleType;
import nl.rabobank.mongo.model.UserModel;

public final class UserDummy {

    public static UserModel fetchOneUser(String username, String password) {
        return UserModel.builder()
                .username(username)
                .password(password)
                .enabled(true)
                .roleType(RoleType.ADMIN)
                .build();
    }
}
