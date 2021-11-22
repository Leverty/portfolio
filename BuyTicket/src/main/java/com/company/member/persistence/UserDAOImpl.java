package com.company.member.persistence;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.company.member.domain.LoginDTO;
import com.company.member.domain.UserDTO;

import lombok.extern.java.Log;

@Log
@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.company.member.mappers.memberMapper";
	
	public UserDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	//-------------------------------------------------------------------------------------------------
	// 회원가입
	//-------------------------------------------------------------------------------------------------
	@Override
	public int register(UserDTO userDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + ".register", userDTO);
	}

	//-------------------------------------------------------------------------------------------------
	// 아이디 중복 체크
	//-------------------------------------------------------------------------------------------------
	@Override
	public int idCheck(UserDTO userDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".idCheck", userDTO);
	}
	
	//-------------------------------------------------------------------------------------------------
	// 로그인
	//-------------------------------------------------------------------------------------------------
	@Override
	public LoginDTO login(UserDTO userDTO) throws Exception {
		log.info("UserDAOImpl login() ==>");
		LoginDTO rtnUser = sqlSession.selectOne(NAMESPACE + ".login", userDTO);
		log.info("UserDAOImpl login Return Value : " + rtnUser);
		return rtnUser;
	}
	
	//-------------------------------------------------------------------------------------------------
	// 로그인 검사
	//-------------------------------------------------------------------------------------------------
	@Override
	public String loginCheck(UserDTO userDTO, HttpSession session) throws Exception {
		log.info("MemberDAOImpl loginCheck() ==> ");
		return sqlSession.selectOne(NAMESPACE + ".loginCheck", userDTO);
	}
	
	//-------------------------------------------------------------------------------------------------
	//로그아웃 => 세션 초기화
	//-------------------------------------------------------------------------------------------------
	@Override
	public void logout(HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
