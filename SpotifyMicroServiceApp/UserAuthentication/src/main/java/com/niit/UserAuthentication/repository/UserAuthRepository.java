package com.niit.UserAuthentication.repository;

import com.niit.UserAuthentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthRepository extends JpaRepository<User, String> {

    User findByUserNameAndPassword(String userName, String password);
}
