package com.alurageek.alurageek.services.users;

import java.util.List;
import com.alurageek.alurageek.models.User;

public interface IUserService{

    List<User> findAllUsers();
    User findByIdUser(Long id);
    User saveUser(User user);
    User updateUser(User user, Long id);
    void deleteByIdUser(Long id);

}