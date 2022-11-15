package com.niit.UserAuthentication.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.niit.UserAuthentication.model.User;
import com.niit.UserAuthentication.services.UserAuthService;
import org.apache.http.auth.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userDefinedException.UserAlreadyExistException;
import userDefinedException.UserNotFoundException;

@RestController @RequestMapping("/app/authentication/")
public class UserController {

    private UserAuthService userAuthService;
    private ResponseEntity responseEntity;

    @Autowired
    public UserController(UserAuthService userAuthService){
        this.userAuthService = userAuthService;
    }

    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistException{
        try{
            userAuthService.registerAnUser(user);
            responseEntity = new ResponseEntity<>("User Created!", HttpStatus.CREATED);
        }catch (UserAlreadyExistException ex){
            throw ex;
        }catch (Exception e){
            responseEntity = new ResponseEntity<>("Error while Saving Data!", HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }

        return responseEntity;
    }

    @PostMapping("login")
    @HystrixCommand(fallbackMethod = "fallBackMsg", commandKey = "loginKey", groupKey = "login")
    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "120000")
    public ResponseEntity<?> userLoginFunc(@RequestBody User user) throws UserNotFoundException, InvalidCredentialsException{
        try{
            User retrieveUser = userAuthService.userLogin(user);
            responseEntity = new ResponseEntity(retrieveUser, HttpStatus.OK);
        }catch(UserNotFoundException ex){
            throw ex;
        }catch (Exception e){
            responseEntity = new ResponseEntity("Error while Logging In!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    public ResponseEntity<?> fallBackMsg(@RequestBody User user) throws InvalidCredentialsException {
        String msg = "Login Failed due to reload timeout";
        return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("user/{username}/{password}")
    public ResponseEntity<?> getUserDetails(@PathVariable String username, @PathVariable String password) throws UserNotFoundException{
        try{
            User user = userAuthService.getUser(username, password);
            responseEntity = new ResponseEntity(user, HttpStatus.OK);
        }catch(UserNotFoundException ex){
            throw ex;
        }catch (Exception e){
            responseEntity = new ResponseEntity("Error while Logging In!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
