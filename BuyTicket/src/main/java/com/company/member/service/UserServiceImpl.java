package com.company.member.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.company.member.domain.LoginDTO;
import com.company.member.domain.UserDTO;
import com.company.member.persistence.UserDAO;
import com.company.ticket.HomeController;

import lombok.extern.java.Log;

@Log
@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	UserDAO userDAO;
	
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	//-------------------------------------------------------------------------------------------------
	// 회원가입
	//-------------------------------------------------------------------------------------------------
	@Override
	public int register(UserDTO userDTO) throws Exception {
		log.info("UserService register.....");
		return userDAO.register(userDTO);
	}

	//-------------------------------------------------------------------------------------------------
	// 아이디 중복 체크
	//-------------------------------------------------------------------------------------------------
	@Override
	public int idCheck(UserDTO userDTO) throws Exception {
		log.info("UserService idCheck.....");
		int result = userDAO.idCheck(userDTO);
		return result;
	}
	
	//-------------------------------------------------------------------------------------------------
	// 로그인
	//-------------------------------------------------------------------------------------------------
	@Override
	public LoginDTO login(UserDTO userDTO) throws Exception {
		log.info("UserService login.....");
		LoginDTO rtnUser =  userDAO.login(userDTO);
		log.info("UserService login Return Value : " + rtnUser);
		return rtnUser;
	}
	
	//-------------------------------------------------------------------------------------------------
	// 로그인 검사
	//-------------------------------------------------------------------------------------------------
	@Override
	public String loginCheck(UserDTO userDTO, HttpSession session) throws Exception {
		log.info("UserService 진입.....");
		// 데이터가 존재하면 : 이름이 넘어온다.
		// 데이터가 존재하지 않으면 : null이 넘어온다.
		//String name = memberDAO.loginCheck(memberDTO);
		String name = userDAO.loginCheck(userDTO, session);
			
		if(name != null) { // 데이터가 존재하면 => 등록된 유저임을 뜻한다.
			//세션을 발급한다.
			session.setAttribute("userId", userDTO.getUserId());
			session.setAttribute("name",   name);
		}
		return name;
	}

	//-------------------------------------------------------------------------------------------------
	//로그아웃 => 세션 초기화
	//-------------------------------------------------------------------------------------------------
	@Override
	public void logout(HttpSession session) throws Exception {
		//세션을 모두 초기화한다.
		session.invalidate();
	}
	
}
