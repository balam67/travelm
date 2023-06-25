package com.travel.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
public static void main(String[] args) {
	BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
	
	 
	String rawPassword = "welcome#123";
	String encodedPassword = bCryptPasswordEncoder.encode(rawPassword);
	System.out.println(encodedPassword);
}
}
