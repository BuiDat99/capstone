package com.capstone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "App_User", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_USER_UK", columnNames = "User_Name") })
public class AppUser {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id", nullable = false)
    private Long userId;
 	
	@NotNull
    @Column(name = "User_Name", length = 36, nullable = false)
    private String userName;
 	
	@NotNull
    @Column(name = "Encryted_Password", length = 128, nullable = false)
    private String encrytedPassword;
 
    @Column(name = "Enabled", length = 1, nullable = false)
    private byte enabled;
    
    @NotNull
    @Column(name="Email", length = 128)
    private String email;
}
