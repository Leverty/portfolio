package com.company.member.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {

	private String 	userId; 			// 유저 아이디
	private String 	userPw; 			// 유저 비밀번호
	private String 	userName; 			// 유저 이름
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date	userBirth;			// 유저 생일
	private String 	userEmail; 			// 유저 이메일
	private String	userPhone;			// 유저 핸드폰번호
	private String 	userGender;			// 유저 성별
	private String	sample6_postcode;		// 유저 우편번호
	private String	sample6_address;		// 유저 주소
	private String	sample6_detailAddress; 	// 유저 상세주소
	
	
	
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
}
