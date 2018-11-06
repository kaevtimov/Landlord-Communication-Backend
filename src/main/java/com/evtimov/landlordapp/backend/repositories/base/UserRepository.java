package com.evtimov.landlordapp.backend.repositories.base;

import com.evtimov.landlordapp.backend.models.User;

import java.util.List;

public interface UserRepository {

    User registerUser(User entity);

    List<User> findAllTenants();

    List<User> findAllLandlords();

    User updateUserOnlineStatus(int userId, User model);

    User updateUserRegistrationToken(int userId, String token);

    User getUserByUsername(String pattern);

    User getUserHashAndSaltByUsername(String username);

    String checkUsername(String pattern);

    String checkEmail(String pattern);

    User getUserById(int userId);
}
