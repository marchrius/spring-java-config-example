package com.hms.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hms.pro.constants.QueryResultBySateEnum;
import com.hms.pro.domain.Building;
import com.hms.pro.service.HMSService;

@Controller
public class AdministrationController {

	@Autowired
	private HMSService hmsService;
	
	@RequestMapping(value="/auth/showRoomTypePage")
	public String showRoomTypesPage(Model model){
		List<Building> buildings=hmsService.getBuildings(QueryResultBySateEnum.ACTIVE);
		model.addAttribute("buildings", buildings);
		return "roomTypes";
	}
	
	@RequestMapping(value = "/auth/saveRoomType", method=RequestMethod.POST)
	public HttpEntity<String> saveRoomType(@RequestParam int buildingId, @RequestParam String roomType){
	
		Building building = hmsService.getBuilding(QueryResultBySateEnum.ACTIVE, buildingId);
		HttpEntity<String> resp =  new ResponseEntity<String>(HttpStatus.OK);
		
		return resp;
	}
}
