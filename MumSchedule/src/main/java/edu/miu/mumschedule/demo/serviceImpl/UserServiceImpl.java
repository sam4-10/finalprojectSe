package edu.miu.mumschedule.demo.serviceImpl;


import edu.miu.mumschedule.demo.dao.UserRepository;

import edu.miu.mumschedule.demo.domain.User;
import edu.miu.mumschedule.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;



    @Override
    public void saveUser(edu.miu.mumschedule.demo.domain.User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        System.out.println("inside finduserie---");
        return userRepository.findById(id);
    }


    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }



    @Override
    public User getUserByPasswordAndUserName(String password, String userName) {
        System.out.println("------------");
        return userRepository.getUserByCredential_PasswordAndCredential_UserName(password, userName);
    }

    @Override
    public User getUserByEmailAndFirstName(String email, String firstName) {
        return userRepository.findAllByEmailAndFirstName(email, firstName);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User finduserByName(String userName) {
        return userRepository.findUserByCredentialUserName(userName);
    }

    @Override
    public  User findById(Long credentialId) {
        Optional<User>  user = userRepository.findById(credentialId);
        return user.get();
    }


}
