package com.hms.pro.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hms.pro.constants.QueryResultBySateEnum;
import com.hms.pro.domain.Building;
import com.hms.pro.service.HMSService;
import com.hms.pro.ui.RoomSearchUI;
import com.hms.pro.ui.RoomTypeUI;
import com.hms.pro.ui.SearchReqObj;
import com.hms.pro.ui.SearchRespObj;

@Controller
public class RoomController {
	static final Logger LOGGER = LoggerFactory.getLogger(RoomController.class);
	
	@Autowired
	private HMSService hmsService;
	 
	@RequestMapping(value="/auth/rooms")
	public String displayRoomPage(Model model){
		List<Building> buildings=hmsService.getBuildings(QueryResultBySateEnum.ACTIVE);
		model.addAttribute("buildings", buildings);		
		return "roomspage";
	}
	
	@RequestMapping(value="/auth/getShareTypes/{buildingId}")
	@ResponseBody
	public List<RoomTypeUI> findRoomTypes(@PathVariable Integer buildingId){
		List<RoomTypeUI> roomTypes=hmsService.getRoomTypesOfBuilding(buildingId);
		return roomTypes;
	}
	
	@RequestMapping(value="/auth/findRooms", method=RequestMethod.POST, consumes="application/json")
	@ResponseBody
	public List<RoomSearchUI> findSearch(@RequestBody SearchReqObj searchReqObj){
		
		return hmsService.getRoomSearchResults(QueryResultBySateEnum.ACTIVE, searchReqObj);
	}
	
}
