package edu.miu.mumschedule.demo.service;


import edu.miu.mumschedule.demo.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(User user);
    void deleteUser(Long id);
    Optional<User> findUserById(Long id);
    List<User> findAllUsers();
//    List<User> findAllNonVerifiedUsers();

    User getUserByPasswordAndUserName(String password, String userName);

    User getUserByEmailAndFirstName(String email, String firstName);

    User findUserByEmail(String email);

    User finduserByName(String userName);




}
