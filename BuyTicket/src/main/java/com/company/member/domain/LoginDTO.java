package com.company.member.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginDTO {

	private String 	user_name; 			// 유저 이름
	private String	user_id;			// 유저 아이디
	private String 	user_pw;			// 유저 패스워드
}
