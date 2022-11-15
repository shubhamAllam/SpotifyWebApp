package com.niit.UserAuthentication.services;

import com.niit.UserAuthentication.model.User;
import com.niit.UserAuthentication.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userDefinedException.UserAlreadyExistException;
import userDefinedException.UserNotFoundException;

@Service
public class UserAuthServiceImpl implements UserAuthService{

    private UserAuthRepository userAuthRepository;

    @Autowired
    public UserAuthServiceImpl(UserAuthRepository userAuthRepository){
        this.userAuthRepository = userAuthRepository;
    }

    // Registration method
    @Override
    public User registerAnUser(User user) throws UserAlreadyExistException {
        if(userAuthRepository.findById(user.getUserName()).isPresent()){
            throw new UserAlreadyExistException();
        }
        return userAuthRepository.save(user);
    }

    // Login method
    @Override
    public User userLogin(User user) throws UserNotFoundException {
        if(userAuthRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword()) == null){
            throw new UserNotFoundException();
        }
        return userAuthRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
    }

    @Override
    public User getUser(String username, String password) throws UserNotFoundException {
        if(userAuthRepository.findByUserNameAndPassword(username, password) == null){
            throw new UserNotFoundException();
        }
        return userAuthRepository.findByUserNameAndPassword(username, password);
    }
}
