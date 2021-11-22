package com.company.ticket;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopMenuController {

	//----------------------------------------------------------------------------------
	// Main Page
	//----------------------------------------------------------------------------------
	@RequestMapping("/")
	public String main(Model model) {
		return "/index";
	}
	
	
	//----------------------------------------------------------------------------------
	// Ticketing Page
	//----------------------------------------------------------------------------------
	@RequestMapping("/ticketing")
	public String Ticketing(Model model) {
		return "/ticketing/ticketing";
	}
	
	//----------------------------------------------------------------------------------
	// Movie Page
	//----------------------------------------------------------------------------------
	@RequestMapping("/movie")
	public String Movie(Model model) {
		return "/movie/movie";
	}
	
	//----------------------------------------------------------------------------------
	// Rank Page
	//----------------------------------------------------------------------------------
	@RequestMapping("/rank")
	public String Rank(Model model) {
		return "/rank/rank";
	}
	
	//----------------------------------------------------------------------------------
	// Event Page
	//----------------------------------------------------------------------------------
	@RequestMapping("/event")
	public String Event(Model model) {
		return "/event/event";
	}
}













