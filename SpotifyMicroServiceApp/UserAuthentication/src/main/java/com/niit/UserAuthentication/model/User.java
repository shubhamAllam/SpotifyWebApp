package com.niit.UserAuthentication.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class User {

    @Id
    private String userName;
    private String password;
    private String email;
}
