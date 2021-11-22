package com.company.member.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.member.domain.LoginDTO;
import com.company.member.domain.UserDTO;
import com.company.member.service.UserService;

@Controller
@RequestMapping("member/*")
public class UserRegisterController {
	
	//로깅을 위한 변수
	private static final Logger logger
		= LoggerFactory.getLogger(UserRegisterController.class);
	
	//-------------------------------------------------------------------------------------------------
	//컨트롤러는 서비스를, 서비스는 DAO를 호출한다.
	//-------------------------------------------------------------------------------------------------
	@Inject
	UserService userService;
	
	//-------------------------------------------------------------------------------------------------
	// 회원가입 get
	//-------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegister() throws Exception {
		logger.info("get register");
		return "/member/register";
	}
		
	//-------------------------------------------------------------------------------------------------
	// 회원가입 post
	//-------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(UserDTO userDTO) throws Exception {
		logger.info("post register");
		
		// 데이터를 존재한다면 1, 아니면 0을 돌려받는다.
		
		int result = userService.idCheck(userDTO);
		try {
			if(result == 1) {
				return "/member/register";
			} else if(result == 0) {
				userService.register(userDTO);
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return "redirect:/member/login";
	}
	
	
	//-------------------------------------------------------------------------------------------------
	// 로그인 get
	//-------------------------------------------------------------------------------------------------
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String getLogin() throws Exception {
		logger.info("MemberController login GET....");
		return "/member/login";
	}
	
	//-------------------------------------------------------------------------------------------------
	// 로그인 post
	//-------------------------------------------------------------------------------------------------
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(UserDTO userDTO, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		logger.info("UserRegisterController login POST....");
		logger.info("UserRegisterController login POST userDTO ==> " + userDTO);
		
		HttpSession session = req.getSession();
		//넘겨받은 회원정보를 가지고 Service에게 의뢰한다.
		LoginDTO login = userService.login(userDTO);
		logger.info("MemberController Return Value " + login);
			
		//해당하는 회원정보가 없으면
		if(login == null) {
			session.setAttribute("user", null);
			rttr.addFlashAttribute("msg", false);
		} else {
			// 로그인이 정상이라면 세션을 발급한다.
			session.setAttribute("user", login);
		//return "/member/login";
		}
		return "redirect:/";
		//return "/member/login";
	}
	
	//-------------------------------------------------------------------------------------------------
	// 로그아웃
	//-------------------------------------------------------------------------------------------------
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		//로그아웃 버튼을 눌렀을 경우, 세션을 없앤다.
		session.invalidate();
		return "redirect:/";
	}
	
	//-------------------------------------------------------------------------------------------------
	// 아이디 중복 검사
	//-------------------------------------------------------------------------------------------------
	@ResponseBody
	@RequestMapping(value="/idCheck", method = RequestMethod.POST)
	public int idCheck(UserDTO userDTO) throws Exception {
		logger.info("UserRegisterController idCheck.....");
		int result = userService.idCheck(userDTO);
		logger.info("UserRegisterController idCheck Return Value [" + result + "]");
		return result;
	}
	
	//-------------------------------------------------------------------------------------------------
	//로그인 입력 값 검사
	//-------------------------------------------------------------------------------------------------
	@RequestMapping("login_check.do")
	public ModelAndView login_check(@ModelAttribute UserDTO userDTO, HttpSession session) throws Exception {
		logger.info("UserRegisterController 진입.....");
		
		//로그인 검사 성공 => 이름이 넘어온다, 실패일 경우 => null이 넘어온다.
		String name = userService.loginCheck(userDTO, session);
		
		//넘겨줄 값을 저장하고 넘어갈 뷰페이지를 동시에 사용.
		ModelAndView mav = new ModelAndView();
		if(name != null) {	// 로그인 검사가 정상이면 시작 페이지로 이동한다.
			mav.setViewName("index"); //main => 뷰의 이름
			//뷰에 전달할 값
			mav.addObject("message", name);
		} else { //로그인 검사를 실패하였으면 login 페이지로 다시 되돌아가게 한다.
			mav.setViewName("member/login");
			//뷰에 전달할 값
			mav.addObject("message", "error");
		}
		return mav;
	}
}
