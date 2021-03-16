package edu.miu.mumschedule.demo.dao;


import edu.miu.mumschedule.demo.domain.Credential;

import edu.miu.mumschedule.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User getUserByCredential(Credential credential);
    User getUserByCredential_PasswordAndCredential_UserName(String password, String userName);

    User findAllByEmailAndFirstName(String email, String firstName);


    User findUserByEmail(String email);
    User findUserByCredentialUserName(String userName);
}
