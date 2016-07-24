package com.hms.pro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoomController {

	@RequestMapping(value="/auth/rooms")
	public String displayRoomPage(){
		
		return "roomspage";
	}
	
}
