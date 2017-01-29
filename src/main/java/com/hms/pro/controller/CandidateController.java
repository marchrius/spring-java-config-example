package com.hms.pro.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.hms.pro.constants.QueryResultBySateEnum;
import com.hms.pro.dao.FloorDao;
import com.hms.pro.domain.Building;
import com.hms.pro.domain.Candidate;
import com.hms.pro.domain.Floor;
import com.hms.pro.domain.Payment;
import com.hms.pro.domain.Room;
import com.hms.pro.domain.RoomType;
import com.hms.pro.service.HMSService;
import com.hms.pro.ui.CandidateUI;
import com.hms.pro.ui.RoomsUI;

@Controller
public class CandidateController {
	static final Logger LOGGER = LoggerFactory.getLogger(CandidateController.class);
	
	@Autowired
	private HMSService hmsService;
	
	@RequestMapping(value="/auth/candidateForm")
	public String candidateForm(Model model){
		
		List<RoomType> roomTypes=hmsService.getRoomTypes(QueryResultBySateEnum.ACTIVE);
		List<Building> buildings=hmsService.getBuildings(QueryResultBySateEnum.ACTIVE);
		//List<Floor> floors=hmsService.getFloors(QueryResultBySateEnum.ACTIVE);
		model.addAttribute("roomTypes",roomTypes);
		model.addAttribute("buildings", buildings);
		//model.addAttribute("floors", floors);
		return "candidateForm";
	}
	
	@RequestMapping(value="/auth/registerCandidate", method=RequestMethod.POST)
	public String registerCandidate(@ModelAttribute CandidateUI candidateObj, Model model) throws ParseException{
		LOGGER.debug("Candidte : "+candidateObj.getPaymentDate());
	   // MultipartFile file=  multipartRequest.getFile("idProof");
	    //LOGGER.debug(file.getOriginalFilename());
		Candidate candidate=new Candidate();
		candidate.setName(candidateObj.getFullName());
		candidate.setAddress(candidateObj.getAddress());
		candidate.setMobileNo(candidateObj.getMobileNo());
		candidate.setEmergencyContactNo(candidateObj.getEmergencyContactNo());
		candidate.setOccupation(candidateObj.getOccupation());
		candidate.setWorkPlace(candidateObj.getWorkPlace());
		candidate.setIdType(candidateObj.getIdType());
		candidate.setIdNo(candidateObj.getIdNo());
		candidate.setRoom(new Room(candidateObj.getRoom()));
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		Date paymentDate=dateFormat.parse(candidateObj.getPaymentDate());
		LOGGER.debug(""+paymentDate);
		candidate.setCanPaymentDate(paymentDate);
		candidate.setJoinDate(new Date());
		candidate.setIsActive(1);
		candidate.setCandidateFee(candidateObj.getCandidateFee());
		Calendar c = Calendar.getInstance();
		
		if(candidateObj.getCandidateFee()-candidateObj.getPaidAmount()>0){
			int due=candidateObj.getCandidateFee()-candidateObj.getPaidAmount();
			candidate.setDueAmount(due);
			c.setTime(paymentDate);
			c.add(Calendar.DATE,30);
			candidate.setDueDate(c.getTime());
			candidate.setPendingDueDate(dateFormat.parse(candidateObj.getDueDate()));
			candidate.setPaymentStatus("Pending");
		}else{
			candidate.setDueAmount(candidateObj.getCandidateFee());
			c.setTime(paymentDate);
			c.add(Calendar.DATE,30);
			candidate.setDueDate(c.getTime());
			candidate.setPaymentStatus("DONE");
			LOGGER.debug("NEXT DUE :"+c.getTime());
		}
		candidate.setVacationFlag(1);
		Set<Payment> payments=new LinkedHashSet<Payment>();
		Payment payment=new Payment();
		payment.setCandidate(candidate);
		payment.setPaidAmount(candidateObj.getPaidAmount());
		payment.setPaidDate(paymentDate);
		payments.add(payment);
		candidate.setPayments(payments);
		hmsService.saveCandidate(candidate);
		
		return "";
	}
	
	@RequestMapping(value="/auth/getFloors/{roomType}/{buildingId}", method=RequestMethod.GET)
	@ResponseBody
	public List<RoomsUI> getFloors(@PathVariable int roomType,@PathVariable int buildingId){
		List<RoomsUI> roomsUIs=hmsService.getFloors(QueryResultBySateEnum.ACTIVE,roomType,buildingId);
		return roomsUIs;
	}
	
	@RequestMapping(value="/auth/getRooms/{roomType}/{buildingId}/{floorId}")
	@ResponseBody
	public List<RoomsUI> getRooms(@PathVariable int roomType, @PathVariable int buildingId, @PathVariable int floorId){
		List<RoomsUI> roomsUI=hmsService.getRooms(QueryResultBySateEnum.ACTIVE,roomType,buildingId,floorId);
		return roomsUI;
	}
	
	@RequestMapping(value="/auth/candidates")
	public String showCandidates(Model model){
		List<Building> buildings=hmsService.getBuildings(QueryResultBySateEnum.ACTIVE);
		model.addAttribute("buildings", buildings);
		return "candidates";
	}
	
	@RequestMapping (value = "/auth/candidatesList/{buildingId}/{onlyVacates}", method=RequestMethod.GET)
	@ResponseBody
	public List<CandidateUI> getCandidatesList (@PathVariable int buildingId,@PathVariable boolean onlyVacates) {
		List<CandidateUI> candidates=null;
		if(onlyVacates){
			candidates=hmsService.getCandidates(QueryResultBySateEnum.ACTIVE, buildingId,true);
		}else{
			candidates=hmsService.getCandidates(QueryResultBySateEnum.ACTIVE, buildingId,false);
		}
		
		LOGGER.debug("Size "+candidates.size());
		return candidates;
	}
	
	@RequestMapping(value = "/auth/updateVacateData/{candidateId}/{vacateDate}", method = RequestMethod.GET)
	@ResponseBody
	public int updateVacateData (@PathVariable int candidateId, @PathVariable String vacateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date= null;
		try {

			date = formatter.parse(vacateDate);
			System.out.println(date);
			System.out.println(formatter.format(date));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		int updateFlag = hmsService.updateVacateData(QueryResultBySateEnum.DEACTIVE, candidateId, date);
		return updateFlag;
	}
	
	@RequestMapping(value="/auth/cancelVacate/{candidateId}")
	@ResponseBody
	public HttpEntity<String> cancelVacate(@PathVariable int candidateId){
		int updateFlag=hmsService.updateVacateData(QueryResultBySateEnum.ACTIVE, candidateId, null);
		HttpEntity<String> entity=new ResponseEntity<String>(HttpStatus.OK);
		return entity;
	}
	@RequestMapping(value="/auth/vacate/{candidateId}")
	@ResponseBody
	public HttpEntity<String> vacate(@PathVariable int candidateId){
		Candidate candidate = hmsService.getCandidateDetails(QueryResultBySateEnum.ACTIVE, candidateId);
		candidate.setIsActive(QueryResultBySateEnum.DEACTIVE.ordinal());
		hmsService.saveCandidate(candidate);
		HttpEntity<String> entity=new ResponseEntity<String>(HttpStatus.OK);
		return entity;
	}
	@RequestMapping (value = "/auth/candidateDetails/{candidateId}", method = RequestMethod.GET, consumes={"application/json"})
	@ResponseBody
	public Candidate getCandidateDetails (@PathVariable int candidateId) {
		Candidate candidate = hmsService.getCandidateDetails(QueryResultBySateEnum.ACTIVE, candidateId);
		return candidate;
	}
	
	@RequestMapping (value = "/auth/candidateDetails/{candidateId}", method = RequestMethod.GET, consumes={"text/html"})
	public String getCandidateDetails (@PathVariable int candidateId,Model model) {
		Candidate candidate = hmsService.getCandidateDetails(QueryResultBySateEnum.ACTIVE, candidateId);
		model.addAttribute("candidate", candidate);
		return "candidateMoreInfo";
	}
	
	@RequestMapping(value="/auth/editCandidateInfo/{cid}")
	public String editCandidateForm(@PathVariable int cid, Model model){
		Candidate candidate = hmsService.getCandidateDetails(QueryResultBySateEnum.ACTIVE, cid);
		List<RoomType> roomTypes=hmsService.getRoomTypes(QueryResultBySateEnum.ACTIVE);
		List<Building> buildings=hmsService.getBuildings(QueryResultBySateEnum.ACTIVE);
		model.addAttribute("roomTypes",roomTypes);
		model.addAttribute("buildings", buildings);
		model.addAttribute("candidate", candidate);
		return "editCandidateInfo";
	}
	
	@RequestMapping(value="/auth/updateCandidate", method=RequestMethod.POST)
	public String updateCandidate(@ModelAttribute CandidateUI candidateObj, Model model) throws ParseException{
		Candidate candidate=hmsService.getCandidateDetails(QueryResultBySateEnum.ACTIVE, candidateObj.getCandidateId());
		candidate.setName(candidateObj.getFullName());
		candidate.setAddress(candidateObj.getAddress());
		candidate.setMobileNo(candidateObj.getMobileNo());
		candidate.setEmergencyContactNo(candidateObj.getEmergencyContactNo());
		candidate.setOccupation(candidateObj.getOccupation());
		candidate.setWorkPlace(candidateObj.getWorkPlace());
		candidate.setIdType(candidateObj.getIdType());
		candidate.setIdNo(candidateObj.getIdNo());
		candidate.setRoom(new Room(candidateObj.getRoom()));
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
		Date paymentDate=dateFormat.parse(candidateObj.getPaymentDate());
		candidate.setCanPaymentDate(paymentDate);
		candidate.setCandidateFee(candidateObj.getCandidateFee());
		LOGGER.debug("Updating candidate :"+candidate.getCandidateId());
		hmsService.saveCandidate(candidate);
		return null;
	}
}
