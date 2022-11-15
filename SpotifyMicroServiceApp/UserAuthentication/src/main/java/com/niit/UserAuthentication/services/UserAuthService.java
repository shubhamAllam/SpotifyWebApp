package com.niit.UserAuthentication.services;

import com.niit.UserAuthentication.model.User;
import userDefinedException.UserAlreadyExistException;
import userDefinedException.UserNotFoundException;

public interface UserAuthService {

    User registerAnUser(User user) throws UserAlreadyExistException;
    User userLogin(User user) throws UserNotFoundException;
    User getUser(String username, String password) throws UserNotFoundException;
}
